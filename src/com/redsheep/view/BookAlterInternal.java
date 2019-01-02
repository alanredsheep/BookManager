package com.redsheep.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.redsheep.dao.BookDao;
import com.redsheep.dao.BookTypeDao;
import com.redsheep.model.Book;
import com.redsheep.model.BookType;
import com.redsheep.util.DbUtil;
import com.redsheep.util.StringUtil;

public class BookAlterInternal extends JInternalFrame {
	private JTextField bookNameText;
	private JTextField authorText;
	private JTable bookTable;
	private JComboBox comboBoxBookType;

	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private BookDao bookDao = new BookDao();
	private JTextField u_idText;
	private JTextField u_bookNameText;
	private JTextField u_authorText;
	private JTextField u_gradeText;
	private JTextField u_priceText;
	private JRadioButton rdbtnNo;
	private JRadioButton rdbtnYes;
	private JComboBox u_bookTypecomboBox;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAlterInternal frame = new BookAlterInternal();
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
	public BookAlterInternal() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Alter Book");
		setBounds(100, 100, 960, 691);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Search Keywords", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JScrollPane scrollPane = new JScrollPane();

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Update Book Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(28)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap(20, Short.MAX_VALUE))
				.addGroup(groupLayout
						.createSequentialGroup().addContainerGap().addComponent(panel_1, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(22, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(25)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE).addGap(32)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
						.addGap(37).addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(57, Short.MAX_VALUE)));

		JLabel lblId = new JLabel("Id :");

		u_idText = new JTextField();
		u_idText.setEditable(false);
		u_idText.setColumns(10);

		JLabel lblBookname = new JLabel("BookName :");

		u_bookNameText = new JTextField();
		u_bookNameText.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Author :");

		u_authorText = new JTextField();
		u_authorText.setColumns(10);

		JLabel lblGrade = new JLabel("Grade :");

		u_gradeText = new JTextField();
		u_gradeText.setColumns(10);

		u_bookTypecomboBox = new JComboBox();

		JLabel lblBooktype = new JLabel("BookType :");

		JLabel lblIsdomestic = new JLabel("IsDomestic :");

		rdbtnYes = new JRadioButton("Yes");
		buttonGroup.add(rdbtnYes);

		JLabel lblPrice = new JLabel("Price :");

		u_priceText = new JTextField();
		u_priceText.setColumns(10);

		rdbtnNo = new JRadioButton("No");
		buttonGroup.add(rdbtnNo);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookUpdateActionPerformed(e);
			}
		});
		btnUpdate.setIcon(new ImageIcon(BookAlterInternal.class.getResource("/icon/main_alter_16px.png")));

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookDeleteActinPerformed(e);
			}
		});
		btnDelete.setIcon(new ImageIcon(BookAlterInternal.class.getResource("/icon/booktype_alter_delete_16px.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_1
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(lblBookname)
										.addComponent(lblNewLabel_3))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(u_authorText, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
										.addComponent(u_bookNameText, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)))
						.addComponent(btnDelete))
				.addGap(18)
				.addGroup(gl_panel_1
						.createParallelGroup(Alignment.TRAILING).addComponent(lblPrice).addComponent(lblGrade))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false).addComponent(u_gradeText)
						.addComponent(u_priceText))
				.addGap(18)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblId)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(u_idText, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addComponent(btnUpdate)
								.addComponent(lblIsdomestic)))
				.addGap(18)
				.addGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING).addComponent(lblBooktype).addComponent(rdbtnYes))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(u_bookTypecomboBox, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnNo))
				.addContainerGap(23, Short.MAX_VALUE)));
		gl_panel_1
				.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup().addGap(26)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblBookname)
										.addComponent(u_bookNameText, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(u_priceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(u_bookTypecomboBox, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(u_idText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblBooktype).addComponent(lblId).addComponent(lblPrice))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3)
										.addComponent(u_authorText, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(u_gradeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblIsdomestic).addComponent(lblGrade).addComponent(rdbtnYes)
										.addComponent(rdbtnNo))
								.addGap(27).addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnDelete).addComponent(btnUpdate))
								.addGap(23)));
		panel_1.setLayout(gl_panel_1);

		bookTable = new JTable();
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTableMousePressed(e);
			}
		});
		bookTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "BookName", "Author", "IsDomestic", "Grade", "Price", "BookType" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getColumnModel().getColumn(0).setPreferredWidth(40);
		bookTable.getColumnModel().getColumn(1).setPreferredWidth(150);
		bookTable.getColumnModel().getColumn(2).setPreferredWidth(140);
		bookTable.getColumnModel().getColumn(3).setPreferredWidth(70);
		bookTable.getColumnModel().getColumn(4).setPreferredWidth(60);
		bookTable.getColumnModel().getColumn(5).setPreferredWidth(70);
		bookTable.getColumnModel().getColumn(6).setPreferredWidth(100);
		scrollPane.setViewportView(bookTable);

		JLabel lblNewLabel = new JLabel("BookName : ");

		bookNameText = new JTextField();
		bookNameText.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Author :");

		authorText = new JTextField();
		authorText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("BookType :");

		comboBoxBookType = new JComboBox();

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearchActionPerformed(e);
			}
		});

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchResetActionPerformed(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel_1)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(authorText, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_2)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(comboBoxBookType, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnSearch)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnReset)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel.createSequentialGroup().addContainerGap()
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblNewLabel)
												.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_1)
												.addComponent(authorText, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_2)
												.addComponent(comboBoxBookType, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnSearch).addComponent(btnReset))
										.addContainerGap(19, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

		this.fillBookType("search");
		this.fillBookType("modify");
		this.fillTable(new Book());
	}

	/**
	 * Book delete actionPerformed
	 * 
	 * @param e
	 */
	protected void bookDeleteActinPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String id = u_idText.getText();

		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "选择要删除的图书类别");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定删除该图书类别？");
		if (n == 0) {
			Connection con = null;
			try {
				con = dbUtil.getCon();
				int m = bookDao.delete(con, id);
				if (m == 1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
				} else {
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
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
	}

	/**
	 * Book update actionPerformed
	 * 
	 * @param e
	 */
	protected void bookUpdateActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String id = this.u_idText.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的项目");
			return;
		}
		String bookName = this.u_bookNameText.getText();
		String author = this.u_authorText.getText();
		String grade = this.u_gradeText.getText();
		String price = this.u_priceText.getText();

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

		BookType bookType = (BookType) u_bookTypecomboBox.getSelectedItem();
		int bookTypeId = bookType.getId();

		Book book = new Book(Integer.parseInt(id), bookName, author, isDomestic, Float.parseFloat(grade),
				Float.parseFloat(price), bookTypeId);

		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = bookDao.update(con, book);
			if (n == 1) {
				JOptionPane.showMessageDialog(null, "图书修改成功");
				resetValue();
			} else {
				JOptionPane.showMessageDialog(null, "图书修改失败");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "图书修改失败");
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

	private void resetValue() {
		// TODO Auto-generated method stub
		this.u_idText.setText("");
		this.u_bookNameText.setText("");
		this.u_authorText.setText("");
		this.u_priceText.setText("");
		this.u_gradeText.setText("");
		this.rdbtnYes.setSelected(true);
		if (this.comboBoxBookType.getItemCount() > 0) {
			this.comboBoxBookType.setSelectedIndex(0);
		}
		this.fillTable(new Book());
	}

	/**
	 * Search form pressed actionPerformed
	 * 
	 * @param e
	 */
	private void bookTableMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = this.bookTable.getSelectedRow();
		this.u_idText.setText((String) bookTable.getValueAt(row, 0));
		this.u_bookNameText.setText((String) bookTable.getValueAt(row, 1));
		this.u_authorText.setText((String) bookTable.getValueAt(row, 2));
		String isDomestic = (String) bookTable.getValueAt(row, 3);
		if ("1".equals(isDomestic)) {
			this.rdbtnYes.setSelected(true);
		} else {
			this.rdbtnNo.setSelected(true);
		}
		this.u_gradeText.setText((String) bookTable.getValueAt(row, 4));
		this.u_priceText.setText((String) bookTable.getValueAt(row, 5));
		String bookTypeName = (String) this.bookTable.getValueAt(row, 6);
		int n = this.u_bookTypecomboBox.getItemCount();
		for (int i = 0; i < n; i++) {
			BookType item = (BookType) this.u_bookTypecomboBox.getItemAt(i);
			if (item.getBookType().equals(bookTypeName)) {
				this.u_bookTypecomboBox.setSelectedIndex(i);
			}
		}
	}

	/**
	 * KeyWord Reset Button Event
	 * 
	 * @param e
	 */
	protected void searchResetActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.bookNameText.setText("");
		this.authorText.setText("");
		this.comboBoxBookType.setSelectedIndex(0);
		fillTable(new Book());
	}

	/**
	 * Search Button Event
	 * 
	 * @param e
	 */
	protected void bookSearchActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String bookName = this.bookNameText.getText();
		String author = this.authorText.getText();
		BookType bookType = (BookType) this.comboBoxBookType.getSelectedItem();
		int bookTypeId = bookType.getId();

		if (StringUtil.isEmpty(bookName) && StringUtil.isEmpty(author) && bookTypeId == -1) {
			this.fillTable(new Book());
			return;
		}
		Book book = new Book(bookName, author, bookTypeId);
		this.fillTable(book);
	}

	/**
	 * Initial BookType ComboBox
	 * 
	 * @param type
	 */
	private void fillBookType(String type) {
		Connection con = null;
		BookType bookType = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookTypeDao.list(con, new BookType());
			if ("search".equals(type)) {
				bookType = new BookType();
				bookType.setBookType("请选择...");
				bookType.setId(-1);
				this.comboBoxBookType.addItem(bookType);
			}
			while (rs.next()) {
				bookType = new BookType();
				bookType.setBookType(rs.getString("bookType"));
				bookType.setId(rs.getInt("bookTypeId"));
				if ("search".equals(type)) {
					this.comboBoxBookType.addItem(bookType);
				} else if ("modify".equals(type)) {
					this.u_bookTypecomboBox.addItem(bookType);
				}
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

	/**
	 * Initial Book Search Table
	 * 
	 * @param book
	 */
	private void fillTable(Book book) {
		DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0); // 查询前清空
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookDao.list(con, book);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("Id"));
				v.add(rs.getString("bookName"));
				v.add(rs.getString("author"));
				v.add(rs.getString("isDomestic"));
				v.add(rs.getString("grade"));
				v.add(rs.getString("price"));
				v.add(rs.getString("bookType"));
				dtm.addRow(v);
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
