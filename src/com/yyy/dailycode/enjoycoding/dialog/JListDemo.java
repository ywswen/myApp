package com.yyy.dailycode.enjoycoding.dialog;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;

public class JListDemo extends JApplet implements SwingConstants {
	public JListDemo(){
		init();
	}
	public static void main(String[] args) {
		new JListDemo();
	}
	JPanel jpanel = new JPanel();
	JList jList = new JList(new String[] { "china", "england", "america" });

	JLabel jLabel = new JLabel("请选择国家:");
	
	public void init() {
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		jList.setBorder(BorderFactory.createTitledBorder("国家列表"));
		jList.setBackground(Color.LIGHT_GRAY);

		jList.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				String strSelectedValue = "";
				for (int i = 0; i < jList.getSelectedValues().length; i++)
					if (strSelectedValue.equals(""))
						strSelectedValue = jList.getSelectedValues()[i]
								.toString();
					else
						strSelectedValue += ","
								+ jList.getSelectedValues()[i].toString();
				showStatus("您选择的国家有:" + strSelectedValue);
			}

		});
		jpanel.add(jLabel);
		jpanel.add(jList);

		contentPane.add(jpanel);

	}

}
