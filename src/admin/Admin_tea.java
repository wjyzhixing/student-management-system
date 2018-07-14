package admin;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import basic.Const;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Admin_tea extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_tea frame = new Admin_tea();
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
	public Admin_tea() {
		setTitle("\u7BA1\u7406\u5458\u6559\u5E08\u64CD\u4F5C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("\u8F93\u5165\u5220\u9664\u6559\u5E08\u7684id");
		lblid.setBounds(51, 286, 179, 21);
		contentPane.add(lblid);
		
		JLabel lblid_1 = new JLabel("\u8F93\u5165\u6DFB\u52A0\u6559\u5E08\u7684id");
		lblid_1.setBounds(51, 40, 179, 21);
		contentPane.add(lblid_1);
		
		textField = new JTextField();
		textField.setBounds(245, 37, 164, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u8F93\u5165\u6DFB\u52A0\u6559\u5E08\u7684\u59D3\u540D");
		label.setBounds(51, 95, 197, 21);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(245, 92, 164, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tid=textField.getText();
				String tname=textField_1.getText();
				String tcollege=textField_3.getText();
				String course_name=textField_4.getText();
				String course_id=textField_5.getText();
				String none=textField_6.getText();
				
				String temp1="("+"'"+tid+"',"+"'"+tname+"','"+tcollege+"')";
				
				Connection con=null;
				Statement sql;
				ResultSet rs;
				ResultSet rs2;
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
				}
				catch(Exception pp){}
				
				String uri="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
				String user="root";
				String password=Const.password;
				String str="";
				try{
					con=(Connection) DriverManager.getConnection(uri,user,password);
				}		
				catch(SQLException pp){}
				
				try{
					sql=con.createStatement();
					
					
					rs=sql.executeQuery("select * from userif where uid="+tid);
					while(rs.next()){
						String id=rs.getString(1);
						
						str+=id;
					}
				}
				catch(SQLException q){
					System.out.println(q);
				}
				
				if(str.equals("")){
				try{
					sql=con.createStatement();		
					String sqlStr="insert into teacher values"+temp1;
					int ok=sql.executeUpdate(sqlStr);
					String sqlStr2="insert into tea values"+"('"+tid+"','"+"123456"+"')";
					int ok1=sql.executeUpdate(sqlStr2);
					String sqlStr3="insert into userif values"+"('"+tid+"','"+"123456"+"','"+"T"+"')";
					int ok2=sql.executeUpdate(sqlStr3);
					String sqlStr4="insert into basic values"+"('"+none+"','"+tid+"','"+tname+"','"+course_id+"','"+course_name+"')";
					int ok3=sql.executeUpdate(sqlStr4);
					
					
					Component jPanel = null;
					JOptionPane.showMessageDialog(jPanel, "插入成功！", "一个弹出窗口！",JOptionPane.WARNING_MESSAGE);
				
					
				}
				catch(SQLException q){
					System.out.println(q);
				}
				}
				else{
					try{
						sql=con.createStatement();
						String sqlStr4="insert into basic values"+"('"+none+"','"+tid+"','"+tname+"','"+course_id+"','"+course_name+"')";
						int ok3=sql.executeUpdate(sqlStr4);
						
						
						Component jPanel = null;
						JOptionPane.showMessageDialog(jPanel, "插入成功！", "一个弹出窗口！",JOptionPane.WARNING_MESSAGE);
					
					}
					catch(SQLException qq){
						
					}
				}
			}
		});
		button.setBounds(456, 236, 123, 29);
		contentPane.add(button);
		
		textField_2 = new JTextField();
		textField_2.setBounds(245, 283, 164, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button_1 = new JButton("\u786E\u8BA4");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String did=textField_2.getText();
				
				Connection con=null;
				Statement sql;
				ResultSet rs;
				ResultSet rs2;
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
				}
				catch(Exception pp){}
				
				String uri="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
				String user="root";
				String password=Const.password;
				String str="";
				try{
					con=(Connection) DriverManager.getConnection(uri,user,password);
				}		
				catch(SQLException pp){}
				
				try{
					sql=con.createStatement();		
					String sqlStr="delete from teacher where id="+did;
					int ok=sql.executeUpdate(sqlStr);
					String sqlStr2="delete from tea where tid="+did;
					int ok1=sql.executeUpdate(sqlStr2);
					String sqlStr3="delete from userif where uid="+did;
					int ok2=sql.executeUpdate(sqlStr3);
					String sqlStr4="delete from basic where tid="+did;
					int ok3=sql.executeUpdate(sqlStr4);
					
					Component jPanel = null;
					JOptionPane.showMessageDialog(jPanel, "删除成功！", "一个弹出窗口！",JOptionPane.WARNING_MESSAGE);				
				}
				catch(SQLException q){
					System.out.println(q);
				}
			}
		});
		button_1.setBounds(456, 282, 123, 29);
		contentPane.add(button_1);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_tea.this.setVisible(false);
				Admin_add.main(null);
			}
		});
		btnNewButton.setBounds(456, 354, 123, 29);
		contentPane.add(btnNewButton);
		
		JLabel label_1 = new JLabel("\u8F93\u5165\u6559\u5E08\u7684\u5B66\u9662");
		label_1.setBounds(51, 141, 149, 21);
		contentPane.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(245, 141, 164, 27);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8F93\u5165\u5F00\u8BBE\u8BFE\u7A0B\u540D\u79F0");
		label_2.setBounds(51, 192, 149, 15);
		contentPane.add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(245, 186, 164, 27);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u5F00\u8BBE\u8BFE\u7A0Bid");
		lblNewLabel.setBounds(51, 243, 149, 15);
		contentPane.add(lblNewLabel);
		
		textField_5 = new JTextField();
		textField_5.setBounds(245, 237, 164, 27);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(515, 138, 51, 27);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5E8F\u53F7");
		label_3.setBounds(456, 141, 81, 21);
		contentPane.add(label_3);
	}
}
