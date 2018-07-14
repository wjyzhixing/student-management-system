package teacher;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import basic.Const;
import stu.Stu_select;
import test.yanzheng;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Tea_log extends JFrame {

	JPanel contentPane = new JPanel() {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon ii = new ImageIcon("tea_log.jpg");
            g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
        }
    };
	private JTextField textField;
	private JPasswordField passwordField;

    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tea_log frame = new Tea_log();
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
	public Tea_log() {
		setTitle("\u6559\u5E08\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 331);
		
		getContentPane().add(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6559\u5DE5\u53F7\uFF1A");
		label.setForeground(Color.ORANGE);
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(55, 58, 109, 27);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u6559\u5DE5\u5BC6\u7801\uFF1A");
		label_1.setForeground(Color.ORANGE);
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(55, 113, 109, 27);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(190, 63, 148, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(190, 118, 148, 21);
		contentPane.add(passwordField);
		
		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String number_1=textField.getText();
				String password_1=passwordField.getText();
				Const.teaid=number_1;
				
				//
				Connection con=null;
				Statement sql;
				ResultSet rs;
				ResultSet rs2;
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
				}
				catch(Exception e1){}
				
				String uri="jdbc:mysql://localhost:3306/test?useSSL=true";
				String user="root";
				String password=Const.password;
				try{
					con=(Connection) DriverManager.getConnection(uri,user,password);
				}		
				catch(SQLException e2){}
				
				try{
					sql=con.createStatement();
					rs2=sql.executeQuery("select * from Teacher where id="+number_1);
					
					
					int i=0;
					while(rs2.next()){
						String t1=rs2.getString(1);
						String t2=rs2.getString(2);
						if(t1.equals(number_1)){
							Const.tename=t2;
						}
					}
					if(Const.tename.equals("")){
						Component jPanel = null;
						JOptionPane.showMessageDialog(jPanel, "账号不存在！", "一个官方的窗口",JOptionPane.WARNING_MESSAGE);
						return ;
					}
				}
				catch(Exception www){
					System.out.println(www);
				}
			
				try{
					sql=con.createStatement();
					rs=sql.executeQuery("select * from tea where tid="+number_1);
					
					while(rs.next()){
						String Real_number=rs.getString(1);
						String Real_password=rs.getString(2);
						
						if(Real_number.equals(number_1)&&Real_password.equals(password_1)){
							Const.id=textField.getText();
							Component jPanel = null;
							JOptionPane.showMessageDialog(jPanel, "登录成功！", "一个官方的窗口",JOptionPane.WARNING_MESSAGE);
							
							Tea_log.this.setVisible(false);
							Tea_insert.main(null);
						}
						else{
							Component jPanel = null;
							JOptionPane.showMessageDialog(jPanel, "您的密码错误！", "一个官方的窗口",JOptionPane.WARNING_MESSAGE);
						}
					}
					con.close();
				}
				catch (SQLException e3) {
					// TODO: handle exception
					System.out.println(e3);
				}
			}
		});
		button.setBounds(245, 175, 93, 23);
		contentPane.add(button);
	}
}
