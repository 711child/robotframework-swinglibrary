/*
 * Copyright 2008 Nokia Siemens Networks Oyj
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.robotframework.swing.tree;

import java.awt.Component;
import java.awt.Point;

import javax.swing.JPopupMenu;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import org.netbeans.jemmy.ComponentChooser;
import org.netbeans.jemmy.Timeouts;
import org.netbeans.jemmy.Waitable;
import org.netbeans.jemmy.Waiter;
import org.netbeans.jemmy.operators.ComponentOperator;
import org.netbeans.jemmy.operators.ContainerOperator;
import org.netbeans.jemmy.operators.JPopupMenuOperator;
import org.netbeans.jemmy.operators.JTreeOperator;
import org.robotframework.swing.operator.ComponentWrapper;
import org.robotframework.swing.popup.DefaultPopupCaller;
import org.robotframework.swing.popup.PopupCaller;

public class TreeOperator implements ComponentWrapper {
    private PopupCaller<ComponentOperator> popupCaller = new DefaultPopupCaller();
    private TreePathFactory treePathFactory = new TreePathFactory(this);
    private JTreeOperator jTreeOperator;

    public TreeOperator(ContainerOperator containerOperator, ComponentChooser componentChooser) {
        jTreeOperator = new JTreeOperator(containerOperator, componentChooser);
    }

    public TreeOperator(ContainerOperator containerOperator, int index) {
        jTreeOperator = new JTreeOperator(containerOperator, index);
    }

    public TreeOperator(JTreeOperator treeOperator) {
        this.jTreeOperator = treeOperator;
    }

    public JPopupMenu callPopupOnRow(int row) {
        jTreeOperator.selectRow(row);
        jTreeOperator.scrollToRow(row);
        Point pointToClick = jTreeOperator.getPointToClick(row);
        return popupCaller.callPopupOnComponent(jTreeOperator, pointToClick);
    }

    public TreePath findPath(final String treePath) {
        try {
            return (TreePath) createTreeWaiter(treePath).waitAction(null);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void expand(String nodeIdentifier) {
        jTreeOperator.expandPath(createTreePath(nodeIdentifier));
    }
    
    public void collapse(String nodeIdentifier) {
        jTreeOperator.collapsePath(createTreePath(nodeIdentifier));
    }
    
    public void addSelection(String nodeIdentifier) {
        jTreeOperator.addSelectionPath(createTreePath(nodeIdentifier));
    }
    
    public void removeSelection(String nodeIdentifier) {
        jTreeOperator.removeSelectionPath(createTreePath(nodeIdentifier));
    }
    
    public boolean isExpanded(String nodeIdentifier) {
        return jTreeOperator.isExpanded(createTreePath(nodeIdentifier));
    }
    
    public boolean isCollapsed(String nodeIdentifier) {
        return jTreeOperator.isCollapsed(createTreePath(nodeIdentifier));
    }
    
    public boolean isLeaf(String nodeIdentifier) {
        TreeNode lastPathComponent = (TreeNode) createTreePath(nodeIdentifier).getLastPathComponent();
        return lastPathComponent.isLeaf();
    }
    
    public boolean isPathSelected(String nodeIdentifier) {
        return jTreeOperator.isPathSelected(createTreePath(nodeIdentifier));
    }
    
    public boolean isVisible(String nodeIdentifier) {
        return jTreeOperator.isVisible(createTreePath(nodeIdentifier));
    }

    public void clickOnNode(String nodeIdentifier, int clickCount) {
        jTreeOperator.clickOnPath(createTreePath(nodeIdentifier), clickCount);
    }
    
    public JPopupMenuOperator createPopupOperator(String nodeIdentifier) {
        return createPopupFactory().createOperator(nodeIdentifier);
    }
    
    public JPopupMenuOperator createPopupOperatorOnSelectedNodes() {
        return createPopupFactory().createOperatorBySelection();
    }
    
    public String getTreeNodeLabel(int index) {
        TreePath pathForRow = jTreeOperator.getPathForRow(index);
        return pathForRow.getLastPathComponent().toString();
    }

    public int getTreeNodeIndex(String nodePath) {
        return jTreeOperator.getRowForPath(findPath(nodePath));
    }

    public Component getSource() {
        return jTreeOperator.getSource();
    }
    
    public TreePath getPathForRow(int i) {
        return jTreeOperator.getPathForRow(i);
    }
    
    public int getRowCount() {
        return jTreeOperator.getRowCount();
    }
    
    public void clearSelection() {
        jTreeOperator.clearSelection();
    }
    
    public JPopupMenu callPopupOnPath(TreePath treePath) {
        return jTreeOperator.callPopupOnPath(treePath);
    }
    
    public JPopupMenu callPopupOnPaths(TreePath[] treePaths) {
        return jTreeOperator.callPopupOnPaths(treePaths);
    }
    
    public TreePath[] getSelectionPaths() {
        return jTreeOperator.getSelectionPaths();
    }
    
    TreePopupMenuOperatorFactory createPopupFactory() {
        return new TreePopupMenuOperatorFactory(this);
    }
    
    private TreePath createTreePath(String nodeIdentifier) {
        return treePathFactory.createTreePath(nodeIdentifier);
    }
    
    private Waiter createTreeWaiter(String treePath) {
        Waiter waiter = new Waiter(new TreePathWaitable(treePath));
        Timeouts nextNodeTimeout = copyTimeout("JTreeOperator.WaitNextNodeTimeout");
        waiter.setTimeouts(nextNodeTimeout);
        return waiter;
    }

    private Timeouts copyTimeout(String timeout) {
        Timeouts times = jTreeOperator.getTimeouts().cloneThis();
        times.setTimeout("Waiter.WaitingTime", jTreeOperator.getTimeouts().getTimeout(timeout));
        return times;
    }

    private class TreePathWaitable implements Waitable {
        private final String path;

        private TreePathWaitable(String path) {
            this.path = path;
        }

        public Object actionProduced(Object arg0) {
            return new TreePathFinder(jTreeOperator).findPath(path);
        }

        public String getDescription() {
            return "Tree path";
        }
    }
}
