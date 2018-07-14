package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import java.sql.*;
import com.mysql.jdbc.Connection;

import basic.Const;
import stu.Stu_information;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JPasswordField;

public class student extends JFrame {


	private JTextField textField;
	private JPasswordField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student frame = new student();
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
	public student() {
		setTitle("\u5B66\u751F\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 318);
		
		JPanel contentPane = new JPanel() {
	        public void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            ImageIcon ii = new ImageIcon("stu.jpg");
	            g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
	        }
	    };
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setBounds(72, 56, 62, 32);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setBounds(144, 63, 145, 21);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u5BC6\u7801");
		label.setForeground(Color.CYAN);
		label.setBounds(72, 113, 54, 15);
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(textField);
		contentPane.add(label);
		
		JButton btnEnter = new JButton("注册");
		btnEnter.setBounds(219, 162, 73, 23);
		contentPane.add(btnEnter);	
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(144, 111, 145, 21);
		contentPane.add(textField_1);
		
		getContentPane().add(contentPane);
		
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SS s1=new SS();
				s1.setNumber(textField.getText());
				s1.setPassword(textField_1.getText());
				System.out.println(s1.getNumber());
				System.out.println(s1.getPassword());
				
				
//				连接数据库
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
				
				String new_1="("+s1.getNumber()+","+s1.getPassword()+")";
				String sqlStr="insert into SS values"+new_1;
				
				if(s1.getPassword().length()!=6){
					Component jPanel = null;
					JOptionPane.showMessageDialog(jPanel, "密码长度不为6位，长度不合理", "一个官方的窗口",JOptionPane.WARNING_MESSAGE); 
					return;
				}
				else if(s1.getNumber().length()!=10)
				{
					Component jPanel = null;
					JOptionPane.showMessageDialog(jPanel, "学号长度不为10位，长度不合理", "一个官方的窗口",JOptionPane.WARNING_MESSAGE); 
					return;
				}
				else{
					try{
						sql=con.createStatement();
						rs=sql.executeQuery("select * from SS");
						int ok=sql.executeUpdate(sqlStr);
						while(rs.next()){
							String number=rs.getString(1);
							String password2=rs.getString(2);
							System.out.printf("%s\t",number);
							System.out.printf("%s\t",password2);
							
						}
						con.close();
					}
					catch(SQLException e){
						System.out.println(e);
					}
					Component jPanel = null;
					JOptionPane.showMessageDialog(jPanel, "注册成功！", "一个官方的窗口",JOptionPane.WARNING_MESSAGE); 
					student.this.setVisible(false);
					yanzheng.main(null);
				}
			}
		});
	}
}
