package com.neu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.neu.bll.UserBO;
import com.neu.util.Message;
import com.neu.vo.UserVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;


public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserId;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//EventQueue-管理事件排队
		//invokeLater-使runnable的run方法在发出的thread里的the system EventQueue中被调用。
		//这将在所有待处理的事件被处理之后发生。 
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 382, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("请输入用户名：");
		label.setBounds(48, 65, 107, 15);
		contentPane.add(label);
		
		txtUserId = new JTextField();
		txtUserId.setBounds(141, 62, 145, 21);
		contentPane.add(txtUserId);
		txtUserId.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(141, 90, 145, 21);
		contentPane.add(txtPassword);
		
		JLabel label_1 = new JLabel("请输入密码：");
		label_1.setBounds(48, 93, 107, 15);
		contentPane.add(label_1);
		
		JButton btnLogin = new JButton("登录");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userId=txtUserId.getText();
				String password=new String(txtPassword.getPassword());
			  
			   if(userId.equals(""))
			   {
				   JOptionPane.showMessageDialog(null, "用户名不能为空");
				   return;
			   }
			   else if(password.equals(""))
			   {
				   JOptionPane.showMessageDialog(null, "密码不能为空");
				   return;
			   }
			   else
			   {
				  
				   UserVO vo=new UserVO();
				   vo.setUserId(userId);
				   vo.setPassword(password);
				   UserBO bo=new UserBO();
				   switch (bo.validateUser(vo)) {
					case Message.SUCCEED_CODE:
						JOptionPane.showMessageDialog(null, Message.SUCCEED_MESSAGE);
						vo.setLastLogin(new Date());
						bo.updateUser(vo);
						break;
					case Message.USER_NOT_EXIST_CODE:
						JOptionPane.showMessageDialog(null, Message.USER_NOT_EXIST_MESSAGE);
						break;
					case Message.PASSWORD_ERROR_CODE:
						JOptionPane.showMessageDialog(null, Message.PASSWORD_ERROR_MESSAGE);
						break;
						default:
							break;

					}
				   
				   
				
			   }
			   
			}
		});
		btnLogin.setBounds(78, 138, 93, 23);
		contentPane.add(btnLogin);
		
		JButton btnExit = new JButton("退出");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnExit.setBounds(182, 138, 93, 23);
		contentPane.add(btnExit);
	}
}
