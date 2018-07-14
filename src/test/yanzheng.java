package test;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import basic.Const;
import main.Window;
import stu.Stu_information;
import stu.Stu_select;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class yanzheng extends JFrame {

	JPanel contentPane = new JPanel() {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon ii = new ImageIcon("stu_log.jpg");
            g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
        }
    };
	public JTextField textField;
	private JPasswordField passwordField;
	String Real_number;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yanzheng frame = new yanzheng();
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
	public yanzheng() {
		setTitle("\u5B66\u751F\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5B66\u53F7");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(82, 54, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(82, 107, 54, 15);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(146, 53, 175, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args) {
				String number_1=textField.getText();
				String password_1=passwordField.getText();
				
				
				//
				Connection con=null;
				Statement sql;
				ResultSet rs;
				ResultSet rs2;
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
				}
				catch(Exception e){}
				
				String uri="jdbc:mysql://localhost:3306/test?useSSL=true";
				String user="root";
				String password=Const.password;
				try{
					con=(Connection) DriverManager.getConnection(uri,user,password);
				}		
				catch(SQLException e){}
				
				try{
					sql=con.createStatement();
					rs2=sql.executeQuery("select * from stu_introduction where id="+number_1);
					
					
					int i=0;
					while(rs2.next()){
						String t1=rs2.getString(1);
						String t2=rs2.getString(2);
						if(t1.equals(number_1)){
							Const.stuname=t2;
						}
					}
				}
				catch(Exception www){
					System.out.println(www);
				}
				
				
				try{
					sql=con.createStatement();
					
					if(number_1.equals("")){
						Component jPanel = null;
						JOptionPane.showMessageDialog(jPanel, "输入不能为空！", "一个官方的窗口",JOptionPane.WARNING_MESSAGE);
					}
					else{
						rs=sql.executeQuery("select * from SS where number="+number_1);
						System.out.println(rs);
						if(rs.equals(null)){
							Component jPanel = null;
							JOptionPane.showMessageDialog(jPanel, "账号不存在！", "一个官方的窗口",JOptionPane.WARNING_MESSAGE);
						
						}
						else{
							int i=0;
							while(rs.next()){
								Real_number=rs.getString(1);
								String Real_password=rs.getString(2);
								
								
		//						System.out.println(Real_password);
		//						System.out.println(password_1);
		//						System.out.println(Real_number.equals(number_1));
		//						System.out.println((Real_password)==String.valueOf(password_1));
								
								if(Real_number.equals(number_1)&&Real_password.equals(password_1)){
									Const.id=textField.getText();
									Component jPanel = null;
									JOptionPane.showMessageDialog(jPanel, "登录成功！", "一个官方的窗口",JOptionPane.WARNING_MESSAGE);
									
									yanzheng.this.setVisible(false);
									Stu_select.main(null);
								}
								else{
									Component jPanel = null;
									JOptionPane.showMessageDialog(jPanel, "您的密码错误！", "一个官方的窗口",JOptionPane.WARNING_MESSAGE);
								}
							}
						}
						System.out.println(Real_number);
						if(Real_number==null){
							Component jPanel = null;
							JOptionPane.showMessageDialog(jPanel, "学号不存在！", "一个官方的窗口",JOptionPane.WARNING_MESSAGE);
						
						}
					}
						con.close();
				}
				catch (SQLException e) {
					// TODO: handle exception
					System.out.println(e);
				}
				//
				
			}
		});
		button.setBounds(228, 179, 93, 23);
		contentPane.add(button);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(146, 106, 175, 21);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("尚未注册？");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yanzheng.this.setVisible(false);
				student.main(null);
			}
		});
		btnNewButton.setBounds(82, 179, 110, 23);
		contentPane.add(btnNewButton);
		
	}
}
