package com.redsheep.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	JDesktopPane desktopPane = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {

		// 改变系统默认字体
		Font font = new Font("微软雅黑", Font.PLAIN, 16);
		java.util.Enumeration<Object> keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}

		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1942, 1067);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Data Maintain");
		mnNewMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/icon/main_setting_24px.png")));
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
		menuBar.add(mnNewMenu);

		JMenu mnBookTypeManager = new JMenu("Book Type Manager");
		mnBookTypeManager.setIcon(new ImageIcon(MainFrame.class.getResource("/icon/main_booktype2_32px.png")));
		mnNewMenu.add(mnBookTypeManager);

		JMenuItem mntmNewMenuItem = new JMenuItem("Add Book Type");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAddInternal bookTypeAddInternal = new BookTypeAddInternal();
				bookTypeAddInternal.setVisible(true);
				desktopPane.add(bookTypeAddInternal);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/icon/main_add_24px.png")));
		mnBookTypeManager.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Alter Book Type ");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAlterInternal bookTypeAlterInternal = new BookTypeAlterInternal();
				bookTypeAlterInternal.setVisible(true);
				desktopPane.add(bookTypeAlterInternal);
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(MainFrame.class.getResource("/icon/main_alter_24px.png")));
		mnBookTypeManager.add(mntmNewMenuItem_3);

		JMenu mnNewMenu_2 = new JMenu("Book Data Manager");
		mnNewMenu_2.setIcon(new ImageIcon(MainFrame.class.getResource("/icon/main_bookdata2_24px.png")));
		mnNewMenu.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Add Data Book");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddInternal bookAddInternal = new BookAddInternal();
				bookAddInternal.setVisible(true);
				desktopPane.add(bookAddInternal);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainFrame.class.getResource("/icon/main_add_24px.png")));
		mnNewMenu_2.add(mntmNewMenuItem_2);

		JMenuItem mntmAlterBook = new JMenuItem("Alter Data Book");
		mntmAlterBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAlterInternal bookAlterInternal = new BookAlterInternal();
				bookAlterInternal.setVisible(true);
				desktopPane.add(bookAlterInternal);
			}
		});
		mntmAlterBook.setIcon(new ImageIcon(MainFrame.class.getResource("/icon/main_alter_24px.png")));
		mnNewMenu_2.add(mntmAlterBook);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setIcon(new ImageIcon(MainFrame.class.getResource("/icon/main_exit_24px.png")));
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(null, "是否退出？");
				if (res == 0) {
					dispose();
				}
			}
		});
		mnNewMenu.add(mntmExit);

		JMenu mnNewMenu_1 = new JMenu("About");
		mnNewMenu_1.setIcon(new ImageIcon(MainFrame.class.getResource("/icon/main_star_24px.png")));
		mnNewMenu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Help");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpInternal internalFrame = new HelpInternal();
				internalFrame.setVisible(true);
				desktopPane.add(internalFrame);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrame.class.getResource("/icon/main_help_24px.png")));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);

		// 把JFrame最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}
}
