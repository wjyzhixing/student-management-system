package stu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import basic.Const;
import test.yanzheng;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Stu_uppass extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stu_uppass frame = new Stu_uppass();
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
	public Stu_uppass() {
		setTitle("\u5B66\u751F\u4FEE\u6539\u5BC6\u7801\u7A97\u53E3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(Const.stuname+"同学，你好");
		lblNewLabel.setBounds(15, 15, 174, 21);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u539F\u5BC6\u7801");
		label.setFont(new Font("宋体", Font.PLAIN, 24));
		label.setBounds(66, 69, 189, 34);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u65B0\u5BC6\u7801");
		label_1.setFont(new Font("宋体", Font.PLAIN, 24));
		label_1.setBounds(66, 149, 189, 34);
		contentPane.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(270, 75, 183, 27);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(266, 155, 187, 27);
		contentPane.add(passwordField_1);
		
		JButton button = new JButton("\u786E\u5B9A\u66F4\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=Const.stuname;
				String old_pass=passwordField.getText();
				String new_pass=passwordField_1.getText();
				
				Connection con=null;
				Statement sql;
				ResultSet rs;
				ResultSet rs2;
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
				}
				catch(Exception e2){}
				
				String uri="jdbc:mysql://localhost:3306/test?useSSL=true";
				String user="root";
				String password=Const.password;
				try{
					con=(Connection) DriverManager.getConnection(uri,user,password);
				}		
				catch(SQLException e2){}
				
				try{
					sql=con.createStatement();
					String sqlStr="update userif set pwd="+new_pass+" where uid='"+Const.id+"'";
					int ok=sql.executeUpdate(sqlStr);
					
					String sqlStr1="update ss set password="+new_pass+" where number='"+Const.id+"'";
					int ok1=sql.executeUpdate(sqlStr1);
					
					System.out.println(sql);
					Component jPanel = null;
					JOptionPane.showMessageDialog(jPanel, "修改成功！请您重新登陆！", "一个弹出窗口！",JOptionPane.WARNING_MESSAGE);
					
					Stu_uppass.this.setVisible(false);
					yanzheng.main(null);
				}
				catch(Exception www){
					System.out.println(www);
				}			
			}
		});
		button.setBounds(330, 230, 123, 29);
		contentPane.add(button);
		

	}
}
