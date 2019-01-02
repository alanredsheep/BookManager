package com.redsheep.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.redsheep.dao.BookDao;
import com.redsheep.dao.BookTypeDao;
import com.redsheep.model.Book;
import com.redsheep.model.BookType;
import com.redsheep.util.DbUtil;
import com.redsheep.util.StringUtil;

public class BookAddInternal extends JInternalFrame {

	private JPanel contentPane;
	private JTextField bookNameText;
	private JTextField authorText;
	private JTextField gradeText;
	private JTextField priceText;
	private JComboBox comboBoxBookType;
	private JRadioButton rdbtnYes;
	private JRadioButton rdbtnNo;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private BookDao bookDao = new BookDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInternal frame = new BookAddInternal();
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
	public BookAddInternal() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Add Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("BookName :");

		JLabel lblNewLabel_1 = new JLabel("Author :");

		JLabel lblNewLabel_2 = new JLabel("IsDomestic :");

		JLabel lblNewLabel_3 = new JLabel("Grade :");

		JLabel lblNewLabel_4 = new JLabel("Price :");

		JLabel lblNewLabel_5 = new JLabel("BookType :");

		bookNameText = new JTextField();
		bookNameText.setColumns(10);

		authorText = new JTextField();
		authorText.setColumns(10);

		gradeText = new JTextField();
		gradeText.setColumns(10);

		priceText = new JTextField();
		priceText.setColumns(10);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed();
			}
		});

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookAddActionPerformed(e);
			}
		});

		rdbtnYes = new JRadioButton("Yes");
		buttonGroup.add(rdbtnYes);

		rdbtnNo = new JRadioButton("No");
		buttonGroup.add(rdbtnNo);

		comboBoxBookType = new JComboBox();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(36)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnReset)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnConfirm))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel).addComponent(lblNewLabel_1)
												.addComponent(
														lblNewLabel_2)
												.addComponent(lblNewLabel_3).addComponent(lblNewLabel_4)
												.addComponent(lblNewLabel_5))
										.addGap(50)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(comboBoxBookType, 0, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addGroup(gl_contentPane.createSequentialGroup().addComponent(rdbtnYes)
														.addPreferredGap(ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(rdbtnNo))
												.addComponent(authorText).addComponent(gradeText)
												.addComponent(priceText).addComponent(bookNameText,
														GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(53, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(36)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(
						bookNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1).addComponent(authorText,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
						.addComponent(rdbtnYes).addComponent(rdbtnNo))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3).addComponent(gradeText,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_4).addComponent(priceText,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_5)
						.addComponent(comboBoxBookType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(30).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnReset)
						.addComponent(btnConfirm))
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);

		fillBookType();
	}

	/**
	 * Reset Add Book Form
	 */
	protected void resetValueActionPerformed() {
		// TODO Auto-generated method stub
		resetValue();
	}

	/**
	 * Add Book
	 */
	protected void bookAddActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String bookName = this.bookNameText.getText();
		String author = this.authorText.getText();
		String grade = this.gradeText.getText();
		String price = this.priceText.getText();

		if (StringUtil.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "图书名称不能为空");
			return;
		}
		if (StringUtil.isEmpty(author)) {
			JOptionPane.showMessageDialog(null, "图书作者不能为空");
			return;
		}
		if (StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "图书价格不能为空");
			return;
		}
		boolean isDomestic = true;
		if (rdbtnYes.isSelected()) {
		} else if (rdbtnNo.isSelected()) {
			isDomestic = false;
		} else {
			JOptionPane.showMessageDialog(null, "请选择作者是否是国内作家");
		}

		BookType bookType = (BookType) comboBoxBookType.getSelectedItem();
		int bookTypeId = bookType.getId();

		Book book = new Book(bookName, author, isDomestic, Float.parseFloat(grade), Float.parseFloat(price),
				bookTypeId);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = bookDao.add(con, book);
			if (n == 1) {
				JOptionPane.showMessageDialog(null, "图书添加成功");
				resetValue();
			} else {
				JOptionPane.showMessageDialog(null, "图书添加失败");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "图书添加失败");
			e1.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/**
	 * Reset Add Book Form
	 */
	private void resetValue() {
		// TODO Auto-generated method stub
		this.bookNameText.setText("");
		this.authorText.setText("");
		this.priceText.setText("");
		this.gradeText.setText("");
		this.rdbtnYes.setSelected(true);
		if (this.comboBoxBookType.getItemCount() > 0) {
			this.comboBoxBookType.setSelectedIndex(0);
		}
	}

	/**
	 * Initial BookType ComboBox
	 */
	private void fillBookType() {
		Connection con = null;
		BookType bookType = new BookType();
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookTypeDao.list(con, new BookType());
			while (rs.next()) {
				bookType = new BookType();
				bookType.setId(rs.getInt("bookTypeId"));
				bookType.setBookType(rs.getString("bookType"));
				this.comboBoxBookType.addItem(bookType);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
