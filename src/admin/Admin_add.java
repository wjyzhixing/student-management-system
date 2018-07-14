package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Window;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_add extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_add frame = new Admin_add();
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
	public Admin_add() {
		setTitle("\u7BA1\u7406\u5458\u7BA1\u7406\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7BA1\u7406\u5458\u4F60\u597D\uFF1A");
		label.setBounds(20, 10, 93, 15);
		contentPane.add(label);
		
		JButton button = new JButton("\u6559\u5E08\u64CD\u4F5C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_add.this.setVisible(false);
				Admin_tea.main(null);
			}
		});
		button.setBounds(20, 56, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u5B66\u751F\u64CD\u4F5C");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_add.this.setVisible(false);
				Admin_stu.main(null);
			}
		});
		button_1.setBounds(20, 133, 93, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_add.this.setVisible(false);
				Window.main(null);
			}
		});
		button_2.setBounds(274, 192, 93, 23);
		contentPane.add(button_2);
	}

}
