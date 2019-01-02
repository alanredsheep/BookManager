package com.redsheep.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.redsheep.dao.BookDao;
import com.redsheep.dao.BookTypeDao;
import com.redsheep.model.BookType;
import com.redsheep.util.DbUtil;
import com.redsheep.util.StringUtil;

public class BookTypeAlterInternal extends JInternalFrame {

	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private BookDao bookDao = new BookDao();
	private JTable bookTypeTable;
	private JTextField searchKeyword;
	private JTextField idText;
	private JTextField bookTypeText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAlterInternal frame = new BookTypeAlterInternal();
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
	public BookTypeAlterInternal() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Alter Book Type");
		setBounds(100, 100, 499, 627);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblKeyword = new JLabel("KeyWord\uFF1A");

		searchKeyword = new JTextField();
		searchKeyword.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeSearchActionPerformed(e);
			}
		});

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Alter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(55)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addComponent(lblKeyword).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(searchKeyword, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE).addComponent(btnSearch))
						.addComponent(panel, 0, 0, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(57, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(32)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblKeyword)
								.addComponent(searchKeyword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSearch))
						.addGap(43)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addGap(44).addComponent(panel, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(65, Short.MAX_VALUE)));

		JLabel lblNewLabel = new JLabel("BookTypeId :");

		idText = new JTextField();
		idText.setEditable(false);
		idText.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("BookType :");

		bookTypeText = new JTextField();
		bookTypeText.setColumns(10);

		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeDeleteActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(
				new ImageIcon(BookTypeAlterInternal.class.getResource("/icon/booktype_alter_delete_32px.png")));

		JButton btnNewButton = new JButton("Alter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeUpdateActionEvent(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookTypeAlterInternal.class.getResource("/icon/main_alter_32px.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1))
						.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false).addComponent(bookTypeText)
								.addComponent(idText, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup().addComponent(btnNewButton_1)
								.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
								.addComponent(btnNewButton)))
				.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(idText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1).addComponent(
						bookTypeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
				.addGap(12)));
		panel.setLayout(gl_panel);

		bookTypeTable = new JTable();
		bookTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTypeTableMousePressed(e);
			}
		});
		bookTypeTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Id", "BookType" }) {
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTypeTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		bookTypeTable.getColumnModel().getColumn(0).setMinWidth(40);
		bookTypeTable.getColumnModel().getColumn(1).setPreferredWidth(150);
		bookTypeTable.getColumnModel().getColumn(1).setMinWidth(80);
		scrollPane.setViewportView(bookTypeTable);
		getContentPane().setLayout(groupLayout);

		this.fillBookTypeTable(new BookType());
	}

	/**
	 * Delete Book Type
	 * 
	 * @param e
	 */
	protected void bookTypeDeleteActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String id = idText.getText();

		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "选择要删除的图书类别");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定删除该图书类别？");
		if (n == 0) {
			Connection con = null;
			try {
				con = dbUtil.getCon();
				boolean flag = bookDao.existBookByBookTypeId(con, id);
				if (flag) {
					JOptionPane.showMessageDialog(null, "当前类别下有图书，不能删除图书类别");
					return;
				}
				int m = bookTypeDao.delete(con, id);
				if (m == 1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillBookTypeTable(new BookType());
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
	 * Update Book Type
	 * 
	 * @param e
	 */
	protected void bookTypeUpdateActionEvent(ActionEvent e) {
		// TODO Auto-generated method stub
		String id = idText.getText();
		String bookTypeName = bookTypeText.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "选择要修改的图书类别");
			return;
		}
		if (StringUtil.isEmpty(bookTypeName)) {
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空");
			return;
		}
		BookType bookType = new BookType(Integer.parseInt(id), bookTypeName);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = bookTypeDao.update(con, bookType);
			if (n == 1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();
				this.fillBookTypeTable(new BookType());
			} else {
				JOptionPane.showMessageDialog(null, "修改失败");
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

	/**
	 * Click Search Results Form
	 * 
	 * @param e
	 */
	protected void bookTypeTableMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = bookTypeTable.getSelectedRow();
		idText.setText((String) bookTypeTable.getValueAt(row, 0));
		bookTypeText.setText((String) bookTypeTable.getValueAt(row, 1));
	}

	/**
	 * Refresh Alter Form
	 */
	public void resetValue() {
		this.idText.setText("");
		this.bookTypeText.setText("");
	}

	/**
	 * 图书类别搜索事件处理
	 * 
	 * @param e
	 */
	protected void bookTypeSearchActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String bookTypeKeyWord = this.searchKeyword.getText();
		BookType bookType = new BookType();
		bookType.setBookType(bookTypeKeyWord);
		this.fillBookTypeTable(bookType);

	}

	/**
	 * Initial bookType search form
	 * 
	 * @param bookType
	 */
	private void fillBookTypeTable(BookType bookType) {
		DefaultTableModel dtm = (DefaultTableModel) bookTypeTable.getModel();
		dtm.setRowCount(0); // 查询前清空
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookTypeDao.list(con, bookType);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("bookTypeId"));
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
