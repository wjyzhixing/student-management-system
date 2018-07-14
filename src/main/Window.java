package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import admin.Admin_log;
import stu.Stu_information;
import teacher.Tea_log;
import test.yanzheng;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

public class Window extends JFrame {

	private JPanel contentPane;

	/**125023
	 * Launch the application.
	 */
//	2016012917   777777
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
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
	public Window() {
		setTitle("\u5B66\u751F\u6210\u7EE9\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 436);
		
		
		JPanel contentPane = new JPanel() {
	        public void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            ImageIcon ii = new ImageIcon("1.jpg");
	            g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
	        }
	    };
				getContentPane().add(contentPane);
		contentPane.setLayout(null);
		JLabel label = new JLabel("\u5B66\u751F\u6210\u7EE9\u7BA1\u7406\u7CFB\u7EDF");
		label.setBounds(261, 29, 260, 48);
		label.setFont(new Font("¡• È", Font.PLAIN, 23));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8BF7\u9009\u62E9\u60A8\u7684\u8EAB\u4EFD");
		label_1.setBounds(288, 97, 126, 27);
		label_1.setFont(new Font("ÀŒÃÂ", Font.PLAIN, 18));
		contentPane.add(label_1);
		
		JButton btnNewButton_1 = new JButton("\u6559\u5E08");
		btnNewButton_1.setIcon(new ImageIcon("teacher.png"));
		btnNewButton_1.setBounds(288, 197, 135, 35);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window.this.setVisible(false);
				Tea_log.main(null);
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton button_2 = new JButton("\u5B66\u751F");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window.this.setVisible(false);
				yanzheng.main(null);
			}
		});
		button_2.setIcon(new ImageIcon("student.png"));
		button_2.setBounds(83, 197, 135, 35);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u7BA1\u7406\u5458");
		button_3.setIcon(new ImageIcon("admim.png"));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window.this.setVisible(false);
				Admin_log.main(null);
			}
		});
		button_3.setBounds(488, 197, 135, 35);
		contentPane.add(button_3);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(330, 373, 54, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u7EF4\u62A4\u4EBA\uFF1A\u738B\u7ADF\u5B87");
		label_3.setBounds(309, 359, 93, 15);
		contentPane.add(label_3);

	}
}
