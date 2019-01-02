package com.redsheep.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.redsheep.dao.BookTypeDao;
import com.redsheep.model.BookType;
import com.redsheep.util.DbUtil;
import com.redsheep.util.StringUtil;

public class BookTypeAddInternal extends JInternalFrame {
	private JTextField bookTypeText;

	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAddInternal frame = new BookTypeAddInternal();
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
	public BookTypeAddInternal() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Add Book Type");
		setBounds(100, 100, 411, 282);

		JLabel lblNewLabel = new JLabel("Book Type :");

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeActionPerformed(e);
			}
		});

		bookTypeText = new JTextField();
		bookTypeText.setColumns(10);

		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(64)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup().addComponent(btnNewButton)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnConfirm))
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(bookTypeText,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(160, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(73)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(
						bookTypeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(53).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
						.addComponent(btnConfirm))
				.addContainerGap(77, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * Add BookType ActionPerformed
	 * 
	 * @param e
	 */
	protected void bookTypeActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String bookTypeName = this.bookTypeText.getText();
		if (StringUtil.isEmpty(bookTypeName)) {
			JOptionPane.showMessageDialog(null, "图书类别不能为空");
			return;
		}
		BookType bookType = new BookType(bookTypeName);
		Connection con = null;

		try {
			con = dbUtil.getCon();
			int res = bookTypeDao.add(con, bookType);
			if (res == 1) {
				JOptionPane.showMessageDialog(null, "图书类别添加成功");
				resetValue();
			} else {
				JOptionPane.showMessageDialog(null, "图书类别添加失败");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书类别添加失败");
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}

	}

	/**
	 * Reset ActionPerformed
	 * 
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.resetValue();
	}

	/**
	 * Reset TextField
	 */
	private void resetValue() {
		bookTypeText.setText("");
	}

}
