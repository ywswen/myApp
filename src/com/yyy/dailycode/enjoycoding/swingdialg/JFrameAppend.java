package com.yyy.dailycode.enjoycoding.swingdialg;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JFrameAppend extends JFrame {
	/**
	 * @属性说明：
	 **/
	private static final long serialVersionUID = -2330411577505087420L;
	private JButton button;
	private JLabel label;

	public JFrameAppend() {
		JPanel pane = new JPanel();
		button = new JButton("<html>第一行<br>第二行</html>");
		label = new JLabel("<html>第1行<br>第2行</html>");
		pane.add(button);
		pane.add(label);
		setContentPane(pane);
		setLocationRelativeTo(null);//窗体居中
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		调整此窗口的大小，以适合其子组件的首选大小和布局。
//		如果该窗口和/或其所有者还不可显示，则在计算首选
//		大小之前都将变得可显示。在计算首选大小之后，将会验证该窗口。 
		pack();
		setVisible(true);
	}

	public static void main(String args[]) {
		new JFrameAppend();
	}
}
