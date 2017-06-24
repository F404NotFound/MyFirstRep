package com.yzu.GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.yzu.game.Game;

public class MyFrame extends Frame{
	private static final long serialVersionUID = 1L;

	public MyFrame() {
		setBounds(200,80,600,500);
		add(new CenterPanel());
		setVisible(true);	
	}
}

class CenterPanel extends Panel{
	
	private static final long serialVersionUID = 1L;
	public CenterPanel(){
		add(new WestPanel(this),BorderLayout.WEST);
		//add(new EastPanel(this),BorderLayout.CENTER);
		setBounds(20,20,460,460);
		setLayout(new BorderLayout());
		setVisible(true);
	}
	public void paint(Graphics g){ 
		g.setColor(Color.red); 
		String path = "src/images/background.jpg";
		File file = new File(path);
		Image img = Util.getImage(file);
		
		g.drawImage(img, 0, 0,this.getWidth(),this.getHeight(), null);
	}
}


class WestPanel extends Panel{
	
	private static final long serialVersionUID = 1L;

	TextField num1;
	TextField num2;
	TextField num3;
	
	
	
	public WestPanel(CenterPanel cp){
		Label notice = new Label("请输入三个1-9的整数");
		num1 = new TextField();
		num2 = new TextField();
		num3 = new TextField();
		Button start = new Button("start");
		
		add(notice);
		add(num1);
		add(num2);
		add(num3);
		add(start);

		notice.setBounds(5,20,140,20);
		num1.setBounds(20, 60, 80, 20);
		num2.setBounds(20, 100, 80, 20);
		num3.setBounds(20, 140, 80, 20);
		start.setBounds(20, 180, 80, 20);
		
		start.addActionListener(new numMonitor(cp));
		setBounds(5,5,140,460);
		setLayout(null);
		setVisible(true);
	}
	
	
	
	class numMonitor implements ActionListener{
		private int n1,n2,n3;
		CenterPanel cp;
		public numMonitor(CenterPanel cp) {
			this.cp = cp;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			String s1 = num1.getText();
			String s2 = num2.getText();
			String s3 = num3.getText();
			
			String regEx = "^[1-9]{1}$";
			
			//正则表达式判断如果三个输入都为1-9的数字则进行运输
			if(Pattern.matches(regEx, s1)&&
					Pattern.matches(regEx, s2)&&Pattern.matches(regEx, s3)){
				
				n1 = Integer.parseInt(s1);
				n2 = Integer.parseInt(s2);
				n3 = Integer.parseInt(s3);
			
				if(cp.getComponentCount()==1){
					cp.add(new EastPanel(cp,n1,n2,n3),BorderLayout.CENTER);
				}else{
					cp.remove(cp.getComponent(1));
					cp.add(new EastPanel(cp,n1,n2,n3),BorderLayout.CENTER);
				}
				cp.validate();
			}else{
				JOptionPane.showMessageDialog(null, 
						"请输入三个1-9的整数","错误输入",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
}

class EastPanel extends Panel{
	
	private static final long serialVersionUID = 1L;
	
	protected JTable table; 
	protected Object[][] data; 
	protected String[] colname = {"序号","单词"};
	CenterPanel cp;
	int n1;int n2;int n3;
	public EastPanel(CenterPanel cp,int n1,int n2,int n3){
		this.n1 = n1;this.n2 = n2;this.n3 = n3;
		this.cp = cp;
		createTableData();  //创建表格所需数据   
        table = getSimpleTable();    
        JScrollPane jsPane = new JScrollPane(table);
        add(jsPane);
        jsPane.setBounds(200,5,200,460);
		setLayout(null);
		setVisible(true);
	}
	public void createTableData(){  
 		ArrayList<Object> result  = new Game().sort(n1, n2, n3);
		data = new Object[result.size()][2];
		for(int i =0;i<result.size();i++){
				data[i] = new Object[]{i+1,result.get(i)};
			}
    }  
    public JTable getSimpleTable(){  
        table = new JTable(data,colname);  
        return table;  
    }  
}

