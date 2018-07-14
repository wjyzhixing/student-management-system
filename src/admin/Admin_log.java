package admin;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
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
import javax.swing.JPasswordField;

public class Admin_log extends JFrame {

	JPanel contentPane = new JPanel() {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon ii = new ImageIcon("800.jpg");
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
					Admin_log frame = new Admin_log();
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
	public Admin_log() {
		setTitle("\u7BA1\u7406\u5458\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		getContentPane().add(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7BA1\u7406\u5458\u8D26\u53F7");
		label.setBounds(71, 63, 85, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(185, 60, 141, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(185, 116, 141, 21);
		
		JLabel label_1 = new JLabel("\u7BA1\u7406\u5458\u5BC6\u7801");
		label_1.setBounds(71, 119, 85, 15);
		contentPane.add(label_1);
		
		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Ad_no=textField.getText();
				String Ad_pa=passwordField.getText();
				
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
					rs2=sql.executeQuery("select * from Admin_information where Ad_no="+Ad_no);
					
					
					int i=0;
					while(rs2.next()){
						String t1=rs2.getString(1);
						String t2=rs2.getString(2);
						if(t1.equals(Ad_no)){
							Component jPanel = null;
							JOptionPane.showMessageDialog(jPanel, "登录成功！", "一个官方的窗口",JOptionPane.WARNING_MESSAGE);
							Admin_log.this.setVisible(false);
							Admin_add.main(null);
						}
					}
				}
				catch(Exception www){
					System.out.println(www);
				}
			}
		});
		button.setBounds(233, 181, 93, 23);
		contentPane.add(button);
		contentPane.add(passwordField);
	}
}
