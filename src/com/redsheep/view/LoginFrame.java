package com.redsheep.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.redsheep.dao.UserDao;
import com.redsheep.model.User;
import com.redsheep.util.DbUtil;
import com.redsheep.util.StringUtil;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userNameText;
	private JPasswordField passwordText;

	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {

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

		setResizable(false);
		setTitle("\u7BA1\u7406\u5458\u767B\u9646");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 26));
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/icon/login_Library_48px.png")));

		JLabel lblNewLabel_1 = new JLabel("UserName:");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));

		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));

		userNameText = new JTextField();
		userNameText.setColumns(10);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});

		passwordText = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(154)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1).addComponent(lblNewLabel_2).addComponent(btnReset))
								.addGap(57)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(userNameText, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 153,
												Short.MAX_VALUE)
										.addComponent(btnLogin, Alignment.TRAILING).addComponent(passwordText,
												Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(188).addComponent(lblNewLabel,
								GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)))
				.addGap(158)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(44).addComponent(lblNewLabel).addGap(48)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(userNameText, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGap(35)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
								.addComponent(passwordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(41).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLogin).addComponent(btnReset))
						.addGap(49)));
		contentPane.setLayout(gl_contentPane);

		// 设置JFrame居中
		this.setLocationRelativeTo(null);
	}

	/**
	 * Login ActionPerformed
	 * 
	 * @param e
	 */
	private void loginActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String userName = this.userNameText.getText();
		String password = new String(this.passwordText.getPassword());
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if (StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		User user = new User(userName, password);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			User currentUser = userDao.login(con, user);
			if (currentUser != null) {
				// JOptionPane.showMessageDialog(null, "登陆成功");
				dispose();
				new MainFrame().setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误");
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
	 * Reset ActionPerformed
	 * 
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.userNameText.setText(null);
		this.passwordText.setText(null);

	}
}
