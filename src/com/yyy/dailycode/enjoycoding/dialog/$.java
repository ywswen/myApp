package com.yyy.dailycode.enjoycoding.dialog;


import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class $ extends JFrame {
    public static void main(String[] args) {
        new $();
    }
    
    private JList jList =  new JList();
    private JScrollPane jScrollPane = new JScrollPane(jList);
    private JButton loadJListDatasButton = new JButton("加载数据");
    private JLabel sizeJLabel = new JLabel("加载数量：");
    private JLabel indexJLabel = new JLabel("选中哪行：");
    private JTextField sizeField = new JTextField();
    private JTextField indexField = new JTextField();
    
    public $() {
        this.setLayout(null);
        this.setSize(800, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jScrollPane.setBounds(0, 0, 300, 200);
        this.add(jScrollPane);
        
        loadJListDatasButton.setBounds(300, 150, 100, 30);
        //JButton点击事件
        loadJListDatasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //数量和索引
                String sizeFieldText = sizeField.getText();
                String indexFieldText = indexField.getText();
                int size = sizeFieldText != null ? Integer.valueOf(sizeFieldText) : 20;
                int index = (indexFieldText != null ? Integer.valueOf(indexFieldText) : 11) - 1;
                //将数据加载到JList
                setJListDatas(MyService.getValues(size), index); 
               // setJListDatas(MyService.getValues(size), index, true); 
            }
        });
        this.add(loadJListDatasButton);
        sizeJLabel.setBounds(300, 50, 65, 20);
        sizeField.setBounds(365, 50, 50, 20);
        indexJLabel.setBounds(300, 100, 65, 20);
        indexField.setBounds(365, 100, 50, 20);
        
        this.add(sizeJLabel);
        this.add(indexJLabel);
        this.add(sizeField);
        this.add(indexField);
    }
    
    
    //根据索引定位滚动条
    /**
     * @param datas 数据
     * @param selectedIndex 选中的索引
     */
    public void setJListDatas(Object[] datas, int selectedIndex) {
        jList.setListData(datas);
        
        //如果需要设置默认选中
        if(selectedIndex != 0) { 
            //设置选中索引
            jList.setSelectedIndex(selectedIndex);
            //设置滚动条
            Point p = jList.indexToLocation(selectedIndex);
            if(p != null) {
                JScrollBar jScrollBar = jScrollPane.getVerticalScrollBar();//获得垂直滚动条  
                jScrollBar.setValue(p.y);//设置垂直滚动条位置
            }
        }
    }
    //根据值定位滚动条.. 
    /**
     * @param datas 数据
     * @param selectedIndex 选中的索引
     * @param scroll 是否设置滚动条
     */
    public void setJListDatas(Object[] datas, int selectedIndex, boolean scroll) {
        jList.setListData(datas);
        //如果需要设置默认选中
        if(selectedIndex != 0) { 
            Object value = datas[selectedIndex];
            jList.setSelectedValue(value, scroll);
        }
    }
}
class MyService {
    //获得随机数据
    public static Object[] getValues(int size) {
        Random random = new Random();
        Object[] objs = new Object[size];
        for (int i = 0; i < size; i++) {
            objs[i] = random.nextInt();
        }
        return objs;
    }
}