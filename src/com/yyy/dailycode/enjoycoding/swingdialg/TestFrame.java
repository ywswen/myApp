package com.yyy.dailycode.enjoycoding.swingdialg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TestFrame extends JFrame implements ActionListener {
	/**
	 * @属性说明：
	 **/
	private static final long serialVersionUID = 1L;
	JLabel lb1, lb2;
	JTextField jtf;
	JButton bt;

	public TestFrame() {
		init();
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		this.setPreferredSize(new Dimension(512,450));           
//		int frameWidth = this.getPreferredSize().width;
//		int frameHeight = this.getPreferredSize().height;
//		this.setSize(frameWidth, frameHeight);
//		this.setLocation((screenSize.width - frameWidth) / 2,(screenSize.height - frameHeight) / 2);
	}

	private void init() {
		this.setLayout(null);
		lb1 = new JLabel("请输入字符串:");
		lb1.setBounds(10, 10, 100, 20);
		lb2 = new JLabel("输入为:");
		lb2.setBounds(120, 10, 100, 20);
		jtf = new JTextField(10);
		jtf.setBounds(10, 50, 100, 20);
		bt = new JButton("确定");
		bt.addActionListener(this);
		bt.setBounds(120, 50, 60, 30);
		this.add(lb1);
		this.add(lb2);
		this.add(jtf);
		this.add(bt);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setVisible(true);
	}

	public static void main(String args[]) {
		new TestFrame();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt && !jtf.getText().trim().equals("")) {
			lb2.setText("输入为:" + jtf.getText().trim());
		} else {
			jtf.setText("");
			JOptionPane.showMessageDialog(this, "格式不合法");
		}
	}
}