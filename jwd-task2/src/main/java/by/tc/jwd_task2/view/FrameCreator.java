package by.tc.jwd_task2.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import by.tc.jwd_task2.dao.DAOException;

public class FrameCreator {
	
	 private final JFrame frame = new JFrame("Tree Structure for XML file");

	    public void setVisible() {
	        frame.setVisible(true);
	        frame.setLocationRelativeTo(null);
	    }

	    public FrameCreator(DefaultMutableTreeNode root) throws DAOException {
	        try {
	            JTree tree = new JTree(root);   
	            JScrollPane scrollPane = new JScrollPane(tree); 
	            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setSize(350, 200);
	        } catch (Exception e) {
	        	throw new DAOException(e);
	        }
	    }

}
