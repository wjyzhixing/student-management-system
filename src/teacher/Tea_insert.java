package teacher;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basic.Const;
import main.Window;
import stu.Stu_select;
import test.student;
import test.yanzheng;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tea_insert extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tea_insert frame = new Tea_insert();
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
	public Tea_insert() {
		setTitle("\u6559\u5E08\u4E3B\u9875\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("亲爱的"+Const.tename+"教师，欢迎登陆本系统：");
		lblNewLabel.setBounds(10, 10, 247, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u8BF7\u9009\u62E9\u60A8\u5C06\u8FDB\u884C\u7684\u64CD\u4F5C\uFF1A");
		label.setBounds(10, 44, 200, 15);
		contentPane.add(label);
		
		JButton button = new JButton("\u8F93\u5165\u6210\u7EE9");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tea_insert.this.setVisible(false);
				Tea_True_insert.main(null);
			}
		});
		button.setBounds(25, 107, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u4FEE\u6539\u6210\u7EE9");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tea_insert.this.setVisible(false);
				Tea_update.main(null);
			}
		});
		button_1.setBounds(164, 107, 93, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u67E5\u8BE2\u6210\u7EE9");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tea_insert.this.setVisible(false);
				Tea_select.main(null);
			}
		});
		button_2.setBounds(293, 107, 93, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u9000\u51FA\u767B\u5F55");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tea_insert.this.setVisible(false);
				Window.main(null);
			}
		});
		button_3.setBounds(293, 204, 93, 23);
		contentPane.add(button_3);
	}
}
