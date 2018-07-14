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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Tea_update extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tea_update frame = new Tea_update();
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
	public Tea_update() {
		setTitle("\u4FEE\u6539\u5B66\u751F\u6210\u7EE9\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u4FEE\u6539\u6210\u7EE9\u5B66\u751F\u5B66\u53F7");
		label.setBounds(21, 22, 179, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(210, 19, 110, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u4FEE\u6539\u6210\u7EE9\u5B66\u751F\u8BFE\u7A0B\u540D\u79F0");
		label_1.setBounds(21, 66, 179, 15);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(210, 63, 110, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u4FEE\u6539\u6210\u7EE9\u5B66\u751F\u6210\u7EE9");
		label_2.setBounds(21, 105, 166, 15);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(210, 102, 110, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String result_1=textField_2.getText();
				String sid=textField.getText();
				String course=textField_1.getText();
				
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
					
					rs=sql.executeQuery("select * from basic where tname='"+Const.tename+"' and cname='"+course+"'");
					String str="";
					while(rs.next()){
						String sid1=rs.getString(1);
							
						str+="学生id："+sid1;
					}
					if(str.equals("")){
						Component jPanel = null;
						JOptionPane.showMessageDialog(jPanel, "老师您没有权限对于这门课程进行编辑！", "一个弹出窗口",JOptionPane.WARNING_MESSAGE);
						return;
					}
					
					String sqlStr="update stu_select set result="+result_1+" where sid="+sid+" and course='"+course+"'";
					
					int ok=sql.executeUpdate(sqlStr);
					
					System.out.println(sql);
					Component jPanel = null;
					JOptionPane.showMessageDialog(jPanel, "修改成功！", "一个弹出窗口！",JOptionPane.WARNING_MESSAGE);
				
				}
				catch(Exception www){
					System.out.println(www);
				}			
			}
		});
		button.setBounds(172, 187, 93, 23);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tea_update.this.setVisible(false);
				Tea_insert.main(null);
			}
		});
		btnNewButton.setBounds(275, 187, 93, 23);
		contentPane.add(btnNewButton);
	}

}
