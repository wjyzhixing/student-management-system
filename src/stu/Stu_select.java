package stu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import basic.Const;
import main.Window;
import test.SS;
import test.student;
import test.yanzheng;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import javax.swing.JTextArea;

public class Stu_select extends JFrame {

	private JPanel contentPane;
	private JScrollPane jsp = null ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stu_select frame = new Stu_select();
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
	public Stu_select() {
		setTitle("\u5B66\u751F\u4E2A\u4EBA\u4FE1\u606F\u7A97\u53E3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtDfdsfsd = new JTextArea();
//		txtDfdsfsd.setBounds(27, 79, 648, 116);
		jsp = new JScrollPane(txtDfdsfsd, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setBounds(27, 79, 648, 116);
		jsp.setBorder(null);
		contentPane.add(jsp);

		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(27, 247, 648, 51);
		
		String temp1=Const.id;
		
		if(Const.stuname.equals("")){
			JLabel lblNewLabel = new JLabel(Const.id+"同学，你好：");
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
			lblNewLabel.setBounds(27, 29, 188, 18);
			contentPane.add(lblNewLabel);
		}
		else{
			JLabel lblNewLabel = new JLabel(Const.stuname+"同学，你好：");
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
			lblNewLabel.setBounds(27, 29, 188, 18);
			contentPane.add(lblNewLabel);
		}
	
		
		JButton btnNewButton = new JButton("\u67E5\u770B\u6210\u7EE9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argc) {
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
					
					
					rs=sql.executeQuery("select * from Stu_select where sid="+temp1);
					while(rs.next()){
						String sid=rs.getString(1);
						String sname=rs.getString(2);
						String cid=rs.getString(3);
						String course=rs.getString(4);
						String result=rs.getString(5);
						
						str+="学生id："+sid+" 学生姓名："+sname+" 课程号："+cid+" 课程名称："+course+" 分数："+result+"\n";
					}
					if(!str.equals("")){
						txtDfdsfsd.setText(str);
					}
					else{
						Component jPanel = null;
						JOptionPane.showMessageDialog(jPanel, "同学不要着急，你的老师还没有录入成绩。", "一个弹出窗口",JOptionPane.WARNING_MESSAGE);
				
					}
					
				}
				catch(SQLException e){
					System.out.println(e);
				}
			}
		});
		btnNewButton.setBounds(558, 27, 117, 23);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(76, 103, 4, 24);
		contentPane.add(textArea);
		
		
//		contentPane.add(txtDfdsfsd);
		
		JButton btnNewButton_1 = new JButton("\u5B8C\u5584\u4E2A\u4EBA\u8D44\u6599");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Stu_select.this.setVisible(false);
				Stu_information.main(null);
			}
		});
		btnNewButton_1.setBounds(403, 27, 140, 23);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("\u67E5\u770B\u4E2A\u4EBA\u4FE1\u606F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					
					
					rs=sql.executeQuery("select * from stu_introduction where id="+temp1);
					while(rs.next()){
						String id=rs.getString(1);
						String name=rs.getString(2);
						String sex=rs.getString(3);
						String college=rs.getString(4);
						String classes=rs.getString(5);
						
						str+="学生id："+id+" 学生姓名："+name+" 性别："+sex+" 学院："+college+" 班级："+classes;
					}
					textArea_1.setText(str);
					
					if(str.equals("")){
						Component jPanel = null;
						JOptionPane.showMessageDialog(jPanel, "同学还没有填写个人信息哦。", "一个弹出窗口",JOptionPane.WARNING_MESSAGE);
				
					}
				}
				catch(SQLException q){
					System.out.println(q);
				}
				
			}
		});
		button.setBounds(27, 214, 117, 23);
		contentPane.add(button);
		
		
		contentPane.add(textArea_1);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stu_select.this.setVisible(false);
				Window.main(null);
			}
		});
		button_1.setBounds(582, 326, 93, 23);
		contentPane.add(button_1);
		
		JButton btnNewButton_2 = new JButton("\u4FEE\u6539\u5BC6\u7801");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stu_select.this.setVisible(false);
				Stu_uppass.main(null);
			}
		});
		btnNewButton_2.setBounds(265, 24, 123, 29);
		contentPane.add(btnNewButton_2);
	}
}
