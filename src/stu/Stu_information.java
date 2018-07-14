package stu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import basic.Const;
import basic.Student;
import test.yanzheng;

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
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;

public class Stu_information extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	Student stu_in=new Student();
	
	String [] a = {"农学院","植保学院","园艺学院","动科学院","动医学院","林学院","风景园林学院","资环学院","水建学院","机电学院","信息工程学院","食品学院"};
	JComboBox comboBox = new JComboBox(a);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stu_information frame = new Stu_information();
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
	public Stu_information() {
		setTitle("\u5B66\u751F\u4E2A\u4EBA\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setBounds(47, 52, 54, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(111, 49, 93, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6027\u522B\uFF1A");
		label_1.setBounds(229, 52, 54, 15);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(305, 49, 66, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel.setBounds(47, 92, 54, 15);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(111, 89, 105, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u9662\uFF1A");
		lblNewLabel_1.setBounds(47, 135, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_2 = new JLabel("\u73ED\u7EA7\uFF1A");
		label_2.setBounds(47, 177, 54, 15);
		contentPane.add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(111, 174, 134, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args) {
				
				Object o = comboBox.getSelectedItem();
				String s =o.toString();
				System.out.println(s);
				
				
				stu_in.setName(textField.getText());
				stu_in.setId(textField_2.getText());
				stu_in.setSex(textField_1.getText());
//				stu_in.setCollege(textField_3.getText());
				stu_in.setClass(textField_4.getText());
				
				String new_1="("+"'"+stu_in.getId()+"'"+","+"'"+stu_in.getName()+"'"+","+"'"+stu_in.getSex()+"'"+","+"'"+s+"'"+","+"'"+stu_in.getClasses()+"'"+")";
				
				
//				连接数据库
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
				try{
					con=(Connection) DriverManager.getConnection(uri,user,password);
				}		
				catch(SQLException e){}
				
				
				String sqlStr="insert into stu_introduction values"+new_1;
				try{
					sql=con.createStatement();
					
					if(stu_in.getId().equals("")){
						Component jPanel = null;
						JOptionPane.showMessageDialog(jPanel, "学号不能为空！", "警告！",JOptionPane.WARNING_MESSAGE);
						return;
					}
					else
					{
						rs=sql.executeQuery("select * from stu_introduction where id="+stu_in.getId());
						while(rs.next()){
							String number=rs.getString(1);
							if(number.equals(stu_in.getId())){
								Component jPanel = null;
								JOptionPane.showMessageDialog(jPanel, "该学号已被注册！", "警告！",JOptionPane.WARNING_MESSAGE);
								break;
							}
							if(stu_in.getId().equals("")){
								Component jPanel = null;
								JOptionPane.showMessageDialog(jPanel, "学号不能为空！", "警告！",JOptionPane.WARNING_MESSAGE);
								break;
							}
						}
					}
					
					if(stu_in.getClasses().equals("")||s.equals("")||stu_in.getId().equals("")||stu_in.getName().equals("")||stu_in.getSex().equals("")){
						Component jPanel = null;
						JOptionPane.showMessageDialog(jPanel, "必要信息不能为空！", "警告！",JOptionPane.WARNING_MESSAGE);
						return;
					}
					else{
						Component jPanel = null;
						JOptionPane.showMessageDialog(jPanel, "填写成功！重新登录生效！", "一个弹出窗口",JOptionPane.WARNING_MESSAGE);
						Stu_information.this.setVisible(false);
						yanzheng.main(null);
					}
					int ok=sql.executeUpdate(sqlStr);
//					System.out.println(stu_in.getCollege());
					
				}
				catch(SQLException e){
					System.out.println(e);
				}
			}
			
		});
		btnNewButton.setBounds(282, 209, 93, 23);
		contentPane.add(btnNewButton);
		
		JList list = new JList();
		list.setBounds(348, 163, -54, -30);
		contentPane.add(list);
		
		
		comboBox.setBounds(111, 132, 119, 21);
		contentPane.add(comboBox);
		

	}
}
