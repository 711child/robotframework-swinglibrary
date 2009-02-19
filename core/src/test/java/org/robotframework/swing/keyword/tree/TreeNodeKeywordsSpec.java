package org.robotframework.swing.keyword.tree;

import jdave.Block;
import jdave.junit4.JDaveRunner;
import junit.framework.AssertionFailedError;

import org.jmock.Expectations;
import org.junit.runner.RunWith;
import org.robotframework.jdave.contract.RobotKeywordContract;
import org.robotframework.jdave.contract.RobotKeywordsContract;


@RunWith(JDaveRunner.class)
public class TreeNodeKeywordsSpec extends TreeSpecification<TreeNodeKeywords> {
    public class Any {
        public TreeNodeKeywords create() {
            return new TreeNodeKeywords();
        }

        public void isRobotKeywordsAnnotated() {
            specify(context, satisfies(new RobotKeywordsContract()));
        }

        public void hasCollapseTreeNodeKeyword() {
            specify(context, satisfies(new RobotKeywordContract("collapseTreeNode")));
        }

        public void hasExpandTreeNodeKeyword() {
            specify(context, satisfies(new RobotKeywordContract("expandTreeNode")));
        }

        public void hasSelectTreeNodeKeyword() {
            specify(context, satisfies(new RobotKeywordContract("selectTreeNode")));
        }
        
        public void hasTreeNodeShouldBeExpandedKeyword() {
            specify(context, satisfies(new RobotKeywordContract("treeNodeShouldBeExpanded")));
        }

        public void hasTreeNodeShouldBeCollapsedKeyword() {
            specify(context, satisfies(new RobotKeywordContract("treeNodeShouldBeCollapsed")));
        }

        public void hasUnselectTreeNodeKeyword() {
            specify(context, satisfies(new RobotKeywordContract("unselectTreeNode")));
        }

        public void hasTreeNodeShouldBeLeafKeyword() {
            specify(context, satisfies(new RobotKeywordContract("treeNodeShouldBeLeaf")));
        }

        public void hasTreeNodeShouldNotBeLeafKeyword() {
            specify(context, satisfies(new RobotKeywordContract("treeNodeShouldNotBeLeaf")));
        }

        public void hasClearTreeSelectionKeyword() {
            specify(context, satisfies(new RobotKeywordContract("clearTreeSelection")));
        }

        public void hasGetTreeNodeLabelKeyword() {
            specify(context, satisfies(new RobotKeywordContract("getTreeNodeLabel")));
        }

        public void hasGetTreeNodeIndexKeyword() {
            specify(context, satisfies(new RobotKeywordContract("getTreeNodeIndex")));
        }
        
        public void hasClickOnTreeNodeKeyword() {
            specify(context, satisfies(new RobotKeywordContract("clickOnTreeNode")));
        }
    }

    public class OperatingOnTree {
        private String nodePath = "path|to|node";

        public TreeNodeKeywords create() {
            return populateWithMockOperatorFactory(new TreeNodeKeywords());
        }
        
        public void clicksOnTreeNode() {
            checking(new Expectations() {{
                one(treeOperator).clickOnNode(nodePath, 2);
                one(operatorFactory).createOperator(treeIdentifier); will(returnValue(treeOperator));
                one(treeOperator).clickOnNode(nodePath, 1);
            }});
            
            context.clickOnTreeNode(treeIdentifier, nodePath, new String[] { "2" });
            context.clickOnTreeNode(treeIdentifier, nodePath, new String[0]);
        }
        
        public void getsTreeNodeIndex() {
            checking(new Expectations() {{
                one(treeOperator).getTreeNodeIndex(nodePath); will(returnValue(3));
            }});
            
            specify(context.getTreeNodeIndex(treeIdentifier, nodePath), 3);
        }

        public void getsTreeNodeLabel() {
            final String nodeLabel = "node";
            checking(new Expectations() {{
                one(treeOperator).getTreeNodeLabel(2); will(returnValue(nodeLabel));
            }});
            
            specify(context.getTreeNodeLabel(treeIdentifier, "2"), nodeLabel);
        }
        
        public void clearsTreeSelection() {
            checking(new Expectations() {{
                one(treeOperator).clearSelection();
            }});

            context.clearTreeSelection(treeIdentifier);
        }
        
        public void collapsesTreeNode() {
            checking(new Expectations() {{
                one(treeOperator).collapse(nodePath);
            }});
            
            context.collapseTreeNode(treeIdentifier, nodePath);
        }
        
        public void expandsTreeNode() {
            checking(new Expectations() {{
                one(treeOperator).expand(nodePath);
            }});
            
            context.expandTreeNode(treeIdentifier, nodePath);
        }
        
        public void selectsTreeNode() {
            checking(new Expectations() {{
                one(treeOperator).addSelection(nodePath);
            }});
            
            context.selectTreeNode(treeIdentifier, nodePath, new String[0]);
        }
        
        public void selectsMultipleTreeNodes() {
            final String otherNode = "other|node";
            checking(new Expectations() {{
                one(treeOperator).addSelection(nodePath);
                one(treeOperator).addSelection(otherNode);
            }});
            
            context.selectTreeNode(treeIdentifier, nodePath, new String[] { otherNode });
        }
        
        public void unselectsTreeNode() {
            checking(new Expectations() {{
                one(treeOperator).removeSelection(nodePath);
            }});
            
            context.unselectTreeNode(treeIdentifier, nodePath);
        }
        
        public void treeNodeShouldBeExpandedPassesIfTreeNodeIsExpanded() throws Throwable {
            checking(new Expectations() {{
                one(treeOperator).isExpanded(nodePath); will(returnValue(true));
            }});
            
            specify(new Block() {
                public void run() throws Throwable {
                    context.treeNodeShouldBeExpanded(treeIdentifier, nodePath);
                }
            }, must.not().raise(Exception.class));
        }
        
        public void treeNodeShouldBeExpandedFailsIfTreeNodeIsNotExpanded() throws Throwable {
            checking(new Expectations() {{
                one(treeOperator).isExpanded(nodePath); will(returnValue(false));
            }});
            
            specify(new Block() {
                public void run() throws Throwable {
                    context.treeNodeShouldBeExpanded(treeIdentifier, nodePath);
                }
            }, must.raiseExactly(AssertionFailedError.class, "Tree node '" + nodePath + "' is not expanded."));
        }
        
        public void treeNodeShouldBeCollapsedPassesIfTreeNodeIsCollapsed() throws Throwable {
            checking(new Expectations() {{
                one(treeOperator).isCollapsed(nodePath); will(returnValue(true));
            }});
            
            specify(new Block() {
                public void run() throws Throwable {
                    context.treeNodeShouldBeCollapsed(treeIdentifier, nodePath);
                }
            }, must.not().raise(Exception.class));
        }
        
        public void treeNodeShouldBeCollapsedFailsIfTreeNodeIsNotCollapsed() throws Throwable {
            checking(new Expectations() {{
                one(treeOperator).isCollapsed(nodePath); will(returnValue(false));
            }});
            
            specify(new Block() {
                public void run() throws Throwable {
                    context.treeNodeShouldBeCollapsed(treeIdentifier, nodePath);
                }
            }, must.raiseExactly(AssertionFailedError.class, "Tree node '" + nodePath + "' is not collapsed."));
        }
        
        public void treeNodeShouldBeLeafPassesIfNodeIsLeaf() throws Throwable {
            checking(new Expectations() {{
                one(treeOperator).isLeaf(nodePath); will(returnValue(true));
            }});
            
            specify(new Block() {
                public void run() throws Throwable {
                    context.treeNodeShouldBeLeaf(treeIdentifier, nodePath);
                }
            }, must.not().raise(Exception.class));
        }
        
        public void treeNodeShouldBeLeafFailsIfNodeIsNotLeaf() throws Throwable {
            checking(new Expectations() {{
                one(treeOperator).isLeaf(nodePath); will(returnValue(false));
            }});
            
            specify(new Block() {
                public void run() throws Throwable {
                    context.treeNodeShouldBeLeaf(treeIdentifier, nodePath);
                }
            }, must.raiseExactly(AssertionFailedError.class, "Tree node '" + nodePath + "' is not leaf."));
        }
        
        public void treeNodeShouldNotBeLeafPassesIfNodeIsNotLeaf() throws Throwable {
            checking(new Expectations() {{
                one(treeOperator).isLeaf(nodePath); will(returnValue(false));
            }});
            
            specify(new Block() {
                public void run() throws Throwable {
                    context.treeNodeShouldNotBeLeaf(treeIdentifier, nodePath);
                }
            }, must.not().raise(Exception.class));
        }
        
        public void treeNodeShouldNotBeLeafFailsIfNodeIsLeaf() throws Throwable {
            checking(new Expectations() {{
                one(treeOperator).isLeaf(nodePath); will(returnValue(true));
            }});
            
            specify(new Block() {
                public void run() throws Throwable {
                    context.treeNodeShouldNotBeLeaf(treeIdentifier, nodePath);
                }
            }, must.raiseExactly(AssertionFailedError.class, "Tree node '" + nodePath + "' is leaf."));
        }
        
        public void getsTreeNodeCount() {
            checking(new Expectations() {{
                one(treeOperator).getRowCount(); will(returnValue(3));
            }});
            
            specify(context.getTreeNodeCount(treeIdentifier), must.equal(3));
        }
    }
}

