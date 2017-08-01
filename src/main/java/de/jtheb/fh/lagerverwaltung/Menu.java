package de.jtheb.fh.lagerverwaltung;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import de.jtheb.fh.lagerverwaltung.entities.*;
import org.jdom.Content;
import sun.reflect.generics.tree.Tree;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JTree warehouseTree;
    public JPanel panelMain;
    private JButton addNewItemButton;
    private JButton saveAndExitButton;
    private JButton getItemButton;

    public Menu() {
        TreeNode rootNode = createNodes();
        TreeModel treeModel = new DefaultTreeModel(rootNode);
        warehouseTree.setModel(treeModel);
        warehouseTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);


        addNewItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Item item = new Item();
                ReadFile readFile = new ReadFile();
                Warehouse warehouse = readFile.readWarehouse();

                String getarticleNr = JOptionPane.showInputDialog("Please input a value vor the article number:");
                if (warehouse.itemNrExists(getarticleNr)) {
                    Object[] options = {"OK", "CANCEL"};
                    JOptionPane.showOptionDialog(null, "This article number already exists. If you want to add the existing item click OK to continue", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                    item = warehouse.getExistingItemFromArticleNr(getarticleNr);
                    warehouse.addItem(item);
                    readFile.writeWarehouse(warehouse);

                    TreeNode rootNode = createNodes();
                    TreeModel treeModel = new DefaultTreeModel(rootNode);
                    warehouseTree.setModel(treeModel);
                    return;
                }
                String getName = JOptionPane.showInputDialog("Please input a value for the name:");
                if (warehouse.itemNameExists(getName)) {
                    Object[] options = {"OK", "CANCEL"};
                    JOptionPane.showOptionDialog(null, "This name already exists. If you want to add the existing item click OK to continue", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                    item = warehouse.getExistingItemFromName(getName);
                    warehouse.addItem(item);
                    readFile.writeWarehouse(warehouse);

                    TreeNode rootNode = createNodes();
                    TreeModel treeModel = new DefaultTreeModel(rootNode);
                    warehouseTree.setModel(treeModel);
                    return;
                }
                String getHeight = JOptionPane.showInputDialog("Please input a value for the height:");
                String getWidth = JOptionPane.showInputDialog("Please input a value for the width:");
                String getDepth = JOptionPane.showInputDialog("Please input a value for the depth:");

                int height = Integer.parseInt(getHeight);
                int width = Integer.parseInt(getWidth);
                int depth = Integer.parseInt(getDepth);
                int maximumVolume = 200 * 200 * 200 + 1;
                int volume = height * width * depth;

                if (volume >= maximumVolume) {
                    JOptionPane.showMessageDialog(null, "Your item is too large for this warehouse.");
                    return;
                } else {
                    item.setArticleNr(getarticleNr);
                    item.setName(getName);
                    item.setWidth(width);
                    item.setHeight(height);
                    item.setDepth(depth);
                    warehouse.addItem(item);
                    readFile.writeWarehouse(warehouse);

                    TreeNode rootNode = createNodes();
                    TreeModel treeModel = new DefaultTreeModel(rootNode);
                    warehouseTree.setModel(treeModel);
                }
            }
        });
        getItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, getGetString());
                //TODO Implement this event
            }
        });
        saveAndExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Your warehouse was saved in warehouse.json");
            }
        });
        warehouseTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) warehouseTree.getLastSelectedPathComponent();
                if (node == null) return;
                Object nodeInfo = node.getUserObject();

                if (!node.isNodeChild(createNodes())) return;
            }
        });
    }

    public void getItemFromWarehouse() {

    }

    public String getGetString() {
        String Output = ""; //TODO Implement a way to get the Pathway to
        return Output;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu");
        frame.setContentPane(new Menu().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private TreeNode createNodes() {
        ReadFile readFile = new ReadFile();
        Warehouse warehouse = readFile.readWarehouse();

        DefaultMutableTreeNode root;
        DefaultMutableTreeNode grandparent;
        DefaultMutableTreeNode parent;
        DefaultMutableTreeNode child;

        root = new DefaultMutableTreeNode("Warehouse");
        int counter1 = 1;
        int counter2 = 1;
        for (Shelf shelf : warehouse.getShelves()) {
            grandparent = new DefaultMutableTreeNode("Shelf " + counter1);
            root.add(grandparent);
            counter1++;

            for (Compartment compartment : shelf.getCompartments()) {
                parent = new DefaultMutableTreeNode("Compartment " + counter2);
                grandparent.add(parent);
                counter2++;

                for (Item item : compartment.getItems()) {
                    child = new DefaultMutableTreeNode(item.getName() + " " + item.getArticleNr() + " (HxWxD)= " + item.getHeight() + " x " + item.getWidth() + " x " + item.getDepth());
                    parent.add(child);
                }
            }
            counter2 = 1;

        }


        return root;
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panelMain = new JPanel();
        panelMain.setLayout(new GridLayoutManager(7, 3, new Insets(0, 0, 0, 0), -1, -1));
        addNewItemButton = new JButton();
        addNewItemButton.setText("Add new Item");
        panelMain.add(addNewItemButton, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        saveAndExitButton = new JButton();
        saveAndExitButton.setText("Save the warehouse");
        panelMain.add(saveAndExitButton, new GridConstraints(6, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        getItemButton = new JButton();
        getItemButton.setText("Get Item");
        panelMain.add(getItemButton, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        panelMain.add(scrollPane1, new GridConstraints(0, 0, 6, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        warehouseTree = new JTree();
        warehouseTree.setEditable(false);
        scrollPane1.setViewportView(warehouseTree);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }
}
