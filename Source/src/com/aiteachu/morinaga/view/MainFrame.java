package com.aiteachu.morinaga.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	private JTree imageTree;

	public MainFrame(){
		GridBagLayout gb = new GridBagLayout();  
        GridBagConstraints gbc = new GridBagConstraints();  
		this.setLayout(gb);
		
		JPanel treePanel = new JPanel();
		treePanel.setBorder(new EmptyBorder(5,5,5,5));
		treePanel.setLayout(new BorderLayout());
		JScrollPane treeJP = new JScrollPane(treePanel);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.2;
		gbc.weighty = 1;
		gb.setConstraints(treeJP, gbc);
		this.add(treeJP);
				
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
		this.imageTree = new JTree(root);
		treePanel.add(this.imageTree, BorderLayout.CENTER);
		
		this.initTree(root);

		JPanel imagePanel = new JPanel();
		JScrollPane imageJP = new JScrollPane(imagePanel);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.8;
		gb.setConstraints(imageJP, gbc);

		this.add(imageJP);

        this.setSize(800, 600);
        this.setLocationRelativeTo(null); 
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        ImageInfoManager im = new ImageInfoManager();
	}
	
	private String formatTime(int time){
		return time < 10 ? "0"+time : time+""; 
	}
	
	private void initTree(DefaultMutableTreeNode root) {
		for(int h=0; h<24; h++){
			DefaultMutableTreeNode hourNode = new DefaultMutableTreeNode(this.formatTime(h) + "時");
			root.add(hourNode);
			
			for(int m=0; m<60; m++){
				String minute = this.formatTime(m) + "分";
				
				DefaultMutableTreeNode minNode = new DefaultMutableTreeNode(minute);
				hourNode.add(minNode);
				
				for(int s=0; s<60; s++){
					String second = this.formatTime(s) + "秒";
					
					DefaultMutableTreeNode secNode = new DefaultMutableTreeNode(second);
					minNode.add(secNode);
				}
			}
		}

//		this.expandAllNode(this.imageTree, new TreePath(root), true);
	}

	private void expandAllNode(JTree tree, TreePath parent, boolean expand) {
	    // Traverse children
	    TreeNode node = (TreeNode) parent.getLastPathComponent();
	    if (node.getChildCount() >= 0) {
	        for (Enumeration<?> e = node.children(); e.hasMoreElements();) {
	            TreeNode n = (TreeNode) e.nextElement();
	            TreePath path = parent.pathByAddingChild(n);
	            expandAllNode(tree, path, expand);
	        }
	    }
	 
	    if (expand) {
	        tree.expandPath(parent);
	    } else {
	        tree.collapsePath(parent);
	    }
	}

	public static void main(String[] args) {
//		String imageHeight = IniFileReader.getConfigValue("img", "prefix");
//		System.out.println(imageHeight);
		new MainFrame();
	}
}
