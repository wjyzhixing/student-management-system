package teacher;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import basic.Const;
import test.student;
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

public class Tea_True_insert extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tea_True_insert frame = new Tea_True_insert();
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
	public Tea_True_insert() {
		setTitle("\u5B66\u751F\u6210\u7EE9\u8F93\u5165\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5B66\u751F\u59D3\u540D");
		label.setBounds(32, 25, 112, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5B66\u751F\u5B66\u53F7");
		label_1.setBounds(32, 73, 98, 15);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(238, 22, 157, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(238, 70, 157, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8BFE\u7A0B\u53F7");
		label_2.setBounds(32, 124, 98, 15);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(238, 121, 157, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("\u8BFE\u7A0B\u540D\u79F0");
		label_3.setBounds(32, 173, 98, 15);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(238, 170, 157, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5206\u6570");
		lblNewLabel.setBounds(32, 219, 112, 15);
		contentPane.add(lblNewLabel);
		
		textField_4 = new JTextField();
		textField_4.setBounds(238, 216, 157, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String stu_name=textField.getText();
				String stu_id=textField_1.getText();
				String cou_id=textField_2.getText();
				String con_name=textField_3.getText();
				String result=textField_4.getText();
				
				String new_1="("+"'"+stu_id+"','"+stu_name+"','"+cou_id+"','"+con_name+"','"+result+"')";
				
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
					
//					查询教师
					rs=sql.executeQuery("select * from basic where tname='"+Const.tename+"' and cid='"+cou_id+"'");
					String str="";
					while(rs.next()){
						String sid=rs.getString(1);
							
						str+="学生id："+sid;
					}
					if(str.equals("")){
						Component jPanel = null;
						JOptionPane.showMessageDialog(jPanel, "老师您没有权限对于这门课程进行编辑！", "一个弹出窗口",JOptionPane.WARNING_MESSAGE);
						return;
					}
					
					String  sqlStr="insert into stu_select values"+new_1;
					int ok=sql.executeUpdate(sqlStr);
					
					Component jPanel = null;
					JOptionPane.showMessageDialog(jPanel, "插入成功！", "一个弹出窗口！",JOptionPane.WARNING_MESSAGE);
				
				}
				catch(Exception www){
					System.out.println(www);
				}
			}
		});
		button.setBounds(315, 284, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tea_True_insert.this.setVisible(false);
				Tea_insert.main(null);
			}
		});
		button_1.setBounds(418, 284, 93, 23);
		contentPane.add(button_1);
	}
}
