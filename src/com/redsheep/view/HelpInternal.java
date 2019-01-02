package com.redsheep.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class HelpInternal extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpInternal frame = new HelpInternal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HelpInternal() {
		setClosable(true);
		setTitle("Help");
		setBounds(100, 100, 524, 243);

		JLabel lblGithub = new JLabel("Go to https://github.com/alanredsheep to get help");
		lblGithub.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));

		JLabel lblEmail = new JLabel("Or connect us on 13423668045@163.com");
		lblEmail.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(23).addComponent(lblGithub))
								.addGroup(groupLayout.createSequentialGroup().addGap(52).addComponent(lblEmail)))
						.addContainerGap(45, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(54).addComponent(lblGithub).addGap(41)
						.addComponent(lblEmail).addContainerGap(59, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

	}

}
