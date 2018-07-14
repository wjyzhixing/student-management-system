package teacher;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import basic.Const;
import main.Window;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import java.awt.Color;

public class Tea_select extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JScrollPane jsp = null;
	private JScrollPane jsp2 = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tea_select frame = new Tea_select();
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
	public Tea_select() {
		setTitle("\u6559\u5E08\u67E5\u8BE2\u5B66\u751F\u5206\u6570\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 473);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8F93\u5165\u6240\u67E5\u79D1\u76EE\u540D\u79F0");
		label.setBounds(29, 23, 112, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(151, 20, 135, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
//		textArea.setounds(29, 48, 542, 107);
		jsp = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setBounds(29, 48, 542, 107);
		jsp.setBorder(null);
		contentPane.add(jsp);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(29, 199, 542, 100);
		jsp2 = new JScrollPane(textArea_1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp2.setBounds(29, 199, 542, 100);
		jsp2.setBorder(null);
		contentPane.add(jsp2);
		
		
		
		JButton button = new JButton("\u67E5\u8BE2\u6240\u6709\u5B66\u751F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String cname=textField.getText();
				
				Connection con=null;
				Statement sql;
				ResultSet rs;
				ResultSet rs2;
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
				}
				catch(Exception e){}
				
				String uri="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
				String user="root";
				String password=Const.password;
				String str="";
				try{
					con=(Connection) DriverManager.getConnection(uri,user,password);
				}		
				catch(SQLException e){}
				
				try{
					sql=con.createStatement();

					rs=sql.executeQuery("select * from basic where tname='"+Const.tename+"' and cname='"+cname+"'");
					String str2="";
					while(rs.next()){
						String sid=rs.getString(1);
							
						str2+="学生id："+sid;
					}
					if(str2.equals("")){
						Component jPanel = null;
						JOptionPane.showMessageDialog(jPanel, "老师您没有权限对于这门课程进行编辑！", "一个弹出窗口",JOptionPane.WARNING_MESSAGE);
						return;
					}
					
					int count=1;
					rs=sql.executeQuery("select * from stu_select where course="+"'"+cname+"'");
					while(rs.next()){
						String sid=rs.getString(1);
						String sname=rs.getString(2);
						String cid=rs.getString(3);
						String course=rs.getString(4);
						String result=rs.getString(5);
						
						str+=count+"学生id："+sid+" 学生姓名："+sname+" 课程名称："+course+" 分数："+result+"\n";
						count+=1;
					}
						textArea.setText(str);	
				}
				catch(SQLException e){
					System.out.println(e);
				}
			}
		});
		button.setBounds(430, 19, 141, 23);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("\u8F93\u5165\u6240\u67E5\u73ED\u7EA7");
		label_1.setBounds(29, 165, 100, 15);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(118, 162, 100, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8F93\u5165\u8BFE\u7A0B\u540D\u79F0");
		label_2.setBounds(239, 165, 94, 15);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(337, 162, 141, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(29, 343, 542, 37);
		contentPane.add(textArea_2);
		
		JButton button_1 = new JButton("\u67E5\u8BE2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cname=textField_2.getText();
				String classes=textField_1.getText();
				
				Connection con=null;
				Statement sql,sql1;
				ResultSet rs;
				ResultSet rs2;
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
				}
				catch(Exception e4){}
				
				String uri="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
				String user="root";
				String password=Const.password;
				String str="";
				try{
					con=(Connection) DriverManager.getConnection(uri,user,password);
				}		
				catch(SQLException e3){}
				
				try{
					sql=con.createStatement();
					sql1=con.createStatement();
					
					rs=sql.executeQuery("select * from basic where tname='"+Const.tename+"' and cname='"+cname+"'");
					String str2="";
					while(rs.next()){
						String sid=rs.getString(1);
							
						str2+="学生id："+sid;
					}
					if(str2.equals("")){
						Component jPanel = null;
						JOptionPane.showMessageDialog(jPanel, "老师您没有权限对于这门课程进行编辑！", "一个弹出窗口",JOptionPane.WARNING_MESSAGE);
						return;
					}
					
					int count=1;
					rs=sql.executeQuery("select * from stu_select where course="+"'"+cname+"'");
					rs2=sql1.executeQuery("select * from stu_introduction where classes="+"'"+classes+"'");
					
					while(rs.next()){
						String sid=rs.getString(1);
						String sname=rs.getString(2);
						String cid=rs.getString(3);
						String course=rs.getString(4);
						String result=rs.getString(5);
						
						while(rs2.next()){
							String cl=rs2.getString(2);
							if(cl.equals(sname)){
								str+=count+"学生id："+sid+" 学生姓名："+sname+" 课程名称："+course+" 分数："+result+"\n";
								count+=1;
							}
						}
						rs2.beforeFirst();
//						str+=count+"学生id："+sid+" 学生姓名："+sname+" 课程名称："+course+" 分数："+result+"\n";

					}
						textArea_1.setText(str);	
				}
				catch(SQLException e2){
					System.out.println(e2);
				}
				
			}
		});
		button_1.setBounds(488, 161, 83, 23);
		contentPane.add(button_1);
		
		JLabel label_3 = new JLabel("\u8F93\u5165\u6240\u67E5\u79D1\u76EE\u540D\u79F0");
		label_3.setBounds(39, 309, 131, 15);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(151, 306, 135, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton button_2 = new JButton("\u6700\u9AD8\u5206");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp1=textField_3.getText();
				
				Connection con=null;
				Statement sql;
				ResultSet rs;
				ResultSet rs2;
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
				}
				catch(Exception e5){}
				
				String uri="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
				String user="root";
				String password=Const.password;
				String str="";
				try{
					con=(Connection) DriverManager.getConnection(uri,user,password);
				}		
				catch(SQLException e5){}
				
				try{
					sql=con.createStatement();
					
					rs=sql.executeQuery("select * from basic where tname='"+Const.tename+"' and cname='"+temp1+"'");
					String str2="";
					while(rs.next()){
						String sid=rs.getString(1);
							
						str2+="学生id："+sid;
					}
					if(str2.equals("")){
						Component jPanel = null;
						JOptionPane.showMessageDialog(jPanel, "老师您没有权限对于这门课程进行编辑！", "一个弹出窗口",JOptionPane.WARNING_MESSAGE);
						return;
					}
					
					int count=1;
					rs=sql.executeQuery("select * from stu_select where result in ( select max(result) from stu_select where course="+"'"+temp1+"'"+")"+" and course='"+temp1+"'");
					while(rs.next()){
						String sid=rs.getString(1);
						String sname=rs.getString(2);
						String cid=rs.getString(3);
						String course=rs.getString(4);
						String result=rs.getString(5);
						int re=Integer.valueOf(result);
						
						str+=count+"学生id："+sid+" 学生姓名："+sname+" 课程名称："+course+" 分数："+re+"\n";
					}
					textArea_2.setText(str);	
				}
				catch(SQLException e6){
					System.out.println(e6);
				}
			}
		});
		button_2.setBounds(352, 305, 93, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u6700\u4F4E\u5206");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp1=textField_3.getText();
				
				Connection con=null;
				Statement sql;
				ResultSet rs;
				ResultSet rs2;
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
				}
				catch(Exception e5){}
				
				String uri="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
				String user="root";
				String password=Const.password;
				String str="";
				try{
					con=(Connection) DriverManager.getConnection(uri,user,password);
				}		
				catch(SQLException e5){}
				
				try{
					sql=con.createStatement();
					
					rs=sql.executeQuery("select * from basic where tname='"+Const.tename+"' and cname='"+temp1+"'");
					String str2="";
					while(rs.next()){
						String sid=rs.getString(1);
							
						str2+="学生id："+sid;
					}
					if(str2.equals("")){
						Component jPanel = null;
						JOptionPane.showMessageDialog(jPanel, "老师您没有权限对于这门课程进行编辑！", "一个弹出窗口",JOptionPane.WARNING_MESSAGE);
						return;
					}
					
					int count=1;
					rs=sql.executeQuery("select * from stu_select where result in ( select min(result) from stu_select where course="+"'"+temp1+"'"+")"+" and course='"+temp1+"'");
					while(rs.next()){
						String sid=rs.getString(1);
						String sname=rs.getString(2);
						String cid=rs.getString(3);
						String course=rs.getString(4);
						String result=rs.getString(5);
						int re=Integer.valueOf(result);
						
						str+=count+"学生id："+sid+" 学生姓名："+sname+" 课程名称："+course+" 分数："+re+"\n";
					}
					textArea_2.setText(str);	
				}
				catch(SQLException e6){
					System.out.println(e6);
				}
			}
		});
		button_3.setBounds(478, 305, 93, 23);
		contentPane.add(button_3);
		
		JButton btnNewButton = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tea_select.this.setVisible(false);
				Window.main(null);
			}
		});
		btnNewButton.setBounds(470, 390, 101, 23);
		contentPane.add(btnNewButton);
	}
}
