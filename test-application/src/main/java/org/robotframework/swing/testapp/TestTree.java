package org.robotframework.swing.testapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import org.robotframework.javalib.util.KeywordNameNormalizer;

public class TestTree extends JTree implements ActionListener {
    private static final String ROOT_NAME = "The Java Series";
    private String rootName = ROOT_NAME;
    
    private JPopupMenu popup = new JPopupMenu() {{
        add(new MenuItemWithCommand("Insert a child", "insert"));
        add(new MenuItemWithCommand("Remove", "remove"));
        add(new MenuItemWithCommand("Save node paths", "savenodes"));
        add(new MenuItemWithCommand("Show dialog", "showdialog"));
        add(new MenuItemWithCommand("Hide root node", "hideroot"));
        add(new MenuItemWithCommand("Show root node", "showroot"));
        add(new MenuItemWithCommand("Remove root name", "removerootname"));
        add(new MenuItemWithCommand("Restore root name", "restorerootname"));
        add(new JMenuItem("Disabled menuitem") {{
            setEnabled(false);
        }});
        add(new JMenu("Submenu") {{
            add(new JMenuItem("Disabled menuitem") {{
                setEnabled(false);
            }});
            add(new JMenuItem("Enabled menuitem"));
        }});

        setOpaque(true);
        setLightWeightPopupEnabled(true);
        setName("popupMenu");
    }};

    
    public TestTree() {
        this(new DefaultMutableTreeNode(ROOT_NAME) {{
                add(new DefaultMutableTreeNode("Books for Java Programmers") {{
                        add(new DefaultMutableTreeNode(new Object() {
                            public String toString() {
                                return "The Java Tutorial: A Short Course on the Basics"; 
                            }
                        }));
                        add(new DefaultMutableTreeNode(new Object() {
                            public String toString() {
                                return "The Java Tutorial Continued: The Rest of the JDK";
                            }   
                        }));
                        add(new DefaultMutableTreeNode(new Object() {
                            public String toString() {
                                return "The JFC Swing Tutorial: A Guide to Constructing GUIs";       
                            }
                        }));
                }});

                add(new DefaultMutableTreeNode(new Object() {
                    public String toString() {
                        return "Books for Java Implementers"; 
                    }
                }) {{
                    add(new DefaultMutableTreeNode(new Object() {
                        public String toString() {
                            return "The Java Virtual Machine Specification";       
                        }
                    }) {{
                        add(new DefaultMutableTreeNode("leafnode1"));
                        add(new DefaultMutableTreeNode("leafnode2"));
                    }});
                    add(new DefaultMutableTreeNode(new Object() {
                        public String toString() {
                            return "The Java Language Specification"; 
                        }
                    }) {{
                        add(new DefaultMutableTreeNode("leafnode3"));
                        add(new DefaultMutableTreeNode("leafnode4"));
                    }});
                }});
        }});
    }

    public TestTree(DefaultMutableTreeNode dmtn) {
        super(dmtn);
        setName("testTree");

        addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    popup.show((JComponent) e.getSource(), e.getX(), e.getY());
                }
            }
            
            public void mouseClicked(MouseEvent e) {
                TestTreeResults.saveNodes(getSelectionPaths());
                TestTreeResults.clickCount = e.getClickCount();
            }
        });
        
        setCellRenderer(new DefaultTreeCellRenderer() {
            public String getText() {
                String nodeText = super.getText();
                if (nodeText.equals(ROOT_NAME)) {
                    return rootName.toLowerCase();
                } else {
                    return nodeText.toLowerCase();
                }
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("insert")) {
            getLastPathComponent().add(new DefaultMutableTreeNode("child"));
        } else if (ae.getActionCommand().equals("remove")) {
            removeSelected();
        } else if (ae.getActionCommand().equals("showdialog")) {
            JOptionPane.showMessageDialog(this, "This is an example message");
        } else if (ae.getActionCommand().equals("hideroot")) {
            setRootVisible(false);
        } else if (ae.getActionCommand().equals("showroot")) {
            setRootVisible(true);
        } else if (ae.getActionCommand().equals("savenodes")) {
            TestTreeResults.saveNodes(getSelectionPaths());
        } else if (ae.getActionCommand().equals("removerootname")) {
            rootName = "";
        } else if (ae.getActionCommand().equals("restorerootname")) {
            rootName = ROOT_NAME;
        }
        refresh();
        updateUI();
    }
    
    @Override
    public TreePath[] getSelectionPaths() {
        TreePath[] selectionPaths = super.getSelectionPaths();
        return (selectionPaths == null) ? new TreePath[0] : selectionPaths;
    }
    
    private void removeSelected() {
        TreePath[] selectionPaths = getSelectionPaths();
        for (TreePath treePath : selectionPaths) {
            ((DefaultMutableTreeNode)treePath.getLastPathComponent()).removeFromParent();
        }
    }

    private DefaultMutableTreeNode getLastPathComponent() {
        TreePath selectionPath = getSelectionPath();
        if (selectionPath == null) {
            return null;
        }
        return (DefaultMutableTreeNode) selectionPath.getLastPathComponent();
    }

    private void refresh() {
        ((DefaultTreeModel) getModel()).nodeStructureChanged(getLastPathComponent());
    }

    private class MenuItemWithCommand extends JMenuItem {
        public MenuItemWithCommand(String text, String actionCommand) {
            super(text);
            setName(new KeywordNameNormalizer().normalize(text));
            setActionCommand(actionCommand);
            addActionListener(TestTree.this);
        }
    }
}
