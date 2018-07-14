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

public class Admin_stu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_stu frame = new Admin_stu();
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
	public Admin_stu() {
		setTitle("\u7BA1\u7406\u5458\u5B66\u751F\u64CD\u4F5C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("\u6DFB\u52A0\u5B66\u751Fid");
		lblid.setBounds(39, 47, 129, 21);
		contentPane.add(lblid);
		
		textField = new JTextField();
		textField.setBounds(183, 44, 151, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uid=textField.getText();
				
				String new_1="('"+uid+"','"+"123456"+"','"+"S')";
				
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
					String  sqlStr="insert into userif values"+new_1;
					int ok=sql.executeUpdate(sqlStr);
					
					String sqlStr2="insert into ss values"+"('"+uid+"','"+"123456"+"')";
					int ok2=sql.executeUpdate(sqlStr2);
					
					Component jPanel = null;
					JOptionPane.showMessageDialog(jPanel, "插入成功！", "一个弹出窗口！",JOptionPane.WARNING_MESSAGE);
				
				}
				catch(Exception www){
					System.out.println(www);
				}
			}
		});
		button.setBounds(400, 43, 140, 29);
		contentPane.add(button);
		
		JLabel lblid_1 = new JLabel("\u5220\u9664\u5B66\u751Fid");
		lblid_1.setBounds(39, 125, 105, 21);
		contentPane.add(lblid_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(183, 122, 151, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button_1 = new JButton("\u786E\u5B9A\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String d_id=textField_1.getText();
				
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
					String sqlStr="delete from teacher where id="+d_id;
					int ok=sql.executeUpdate(sqlStr);
					String sqlStr2="delete from ss where number="+d_id;
					int ok1=sql.executeUpdate(sqlStr2);
					String sqlStr3="delete from userif where uid="+d_id;
					int ok2=sql.executeUpdate(sqlStr3);
					String sqlStr4="delete from stu_introduction where id="+d_id;
					int ok3=sql.executeUpdate(sqlStr4);
					String sqlStr5="delete from stu_select where sid="+d_id;
					int ok4=sql.executeUpdate(sqlStr5);
					
					Component jPanel = null;
					JOptionPane.showMessageDialog(jPanel, "删除成功！", "一个弹出窗口！",JOptionPane.WARNING_MESSAGE);				
				}
				catch(SQLException q){
					System.out.println(q);
				}
			}
		});
		button_1.setBounds(400, 121, 140, 29);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_stu.this.setVisible(false);
				Admin_add.main(null);
			}
		});
		button_2.setBounds(400, 262, 140, 29);
		contentPane.add(button_2);
	}

}
