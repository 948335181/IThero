package com.Test.day20191129;

import java.awt.Color;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


class mainFrame extends JFrame implements ActionListener,ItemListener, MouseListener,Serializable
{
	int flag1=0,flag2=0,flag3=0,flag4=0;
	JFrame mainframe = new JFrame("主界面");
	Random rand =new Random();
	Attritube man=new Attritube();
	mainpanel w= new mainpanel();
	final String me= "开发者：陈亮\n学号：201710262129\n班级：17gb软件2班";
	JLabel lb,lb2,a1;
	JTextField username;
	JButton btnmuc,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btnx;
	mainpanel panel;
	Sound sound;
	JComboBox jc=new JComboBox();
	MenuItem renew1=new MenuItem("读档");
	MenuItem back=new MenuItem("存档");
	MenuItem exit=new MenuItem("退出");
	MenuItem ss=new MenuItem("操作说明");
	MenuItem about=new MenuItem("关于");
	File mapfile;
	int fff=0;
	public void tittle()
	{
		mainframe.setSize(720,720);
		mainframe.setVisible(true);
		mainframe.setResizable(false);
		mainframe.setLocation(300,20);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cont=mainframe.getContentPane();
		cont.setLayout(null);
		cont.setBackground(Color.white);
		Menu choice=new Menu("选项");
		choice.add(renew1);
		choice.add(back);
		choice.addSeparator();
		choice.add(exit);
		renew1.addActionListener(this);
		exit.addActionListener(this);
		back.addActionListener(this);
		Menu help=new Menu("帮助");
		help.add(ss);
		help.add(about);
		about.addActionListener(this);
		MenuBar bar=new MenuBar();
		bar.add(choice);bar.add(help);
		mainframe.setMenuBar(bar);    
		lb=new JLabel("课 程 设 计：I T 英 雄",SwingConstants.CENTER);
		lb2=new JLabel(" ",SwingConstants.CENTER);
		mainframe.add(lb);
		mainframe.add(lb2);
		lb.setBounds(50,20,300,20);
		lb.setForeground(Color.black);
		lb2.setBounds(625,500,55,20);
		lb2.setForeground(Color.white);
		
	}
	public void mainFrame1()
	{
		tittle();                                    
		allstart();
	}
	public void allstart()
	{
		flag1=1;
		JPanel j=(JPanel)mainframe.getContentPane();
		j.setOpaque(false);
		Image image = getToolkit().getImage("pic\\3.gif");
		btn1 = new JButton("开始游戏");
		mainframe.add(btn1);
		btn1.setBounds(250, 200, 150, 60);
		btn1.addMouseListener(this);
		btn1.addActionListener(this);
		JPanel j2=(JPanel)super.getContentPane();
		j.setOpaque(false);
		Image image2 = getToolkit().getImage("pic\\3.gif");
		btn3 = new JButton("读档");
		mainframe.add(btn3);
		btn3.setBounds(250, 300, 150, 60);
		btn3.addMouseListener(this);
		btn3.addActionListener(this);
		JPanel j3=(JPanel)mainframe.getContentPane();
		j.setOpaque(false);
		Image image3 = getToolkit().getImage("pic\\3.gif");
		btn4 = new JButton("退出");
		mainframe.add(btn4);
		btn4.setBounds(250, 400, 150, 60);
		btn4.addMouseListener(this);
		btn4.addActionListener(this);
		
	}
	public void gamemap1()
	{
		flag2=1;
    	btn1.setVisible(false);
    	btn3.setVisible(false);
    	btn4.setVisible(false);
    	JPanel j=(JPanel)mainframe.getContentPane();
		j.setOpaque(false);
		Image image = getToolkit().getImage("pic\\3.gif");
		btn2 = new JButton("随机属性");
		btn2.setBounds(250, 200, 150, 60);
		btn2.addMouseListener(this);
		btn2.addActionListener(this);
		mainframe.add(btn2);
		btn6 = new JButton("正常开始");
		btn6.setBounds(250, 300, 150, 60);
		btn6.addMouseListener(this);
		btn6.addActionListener(this);
		mainframe.add(btn6);
	}
	public void write()
	{
		flag3=1;
		btn2.setVisible(false);
		btn6.setVisible(false);
		JPanel j=(JPanel)mainframe.getContentPane();
		j.setOpaque(false);
	    a1 = new JLabel("你人物名字：");
	    mainframe.add(a1);
	    a1.setForeground(Color.black);
	    username = new JTextField();
	    mainframe.add(username);
	    a1.setBounds(250, 100, 200, 20);
	    username.setBounds(450, 100, 120, 20);
	    mainframe.add(username);
	    btnx = new JButton("enter");
	    mainframe.add(btnx);
		btnx.setBounds(250, 200, 150, 60);
		btnx.addMouseListener(this);
		btnx.addActionListener(this);
		
	}
	public void enter(){
		fff=1;
		btnx.setVisible(false);
		a1.setVisible(false);
		username.setVisible(false);
		//sound=new Sound();
		//sound.loadSound();
		panel=new mainpanel();
		mainframe.add(panel);
		panel.IThero(panel.level,man,mainframe);
		panel.requestFocus();
		validate();
	}

	public void choosething()
	{
		flag3=1;
    	btn2.setVisible(false);
    	btn3.setVisible(false);
    	btn6.setVisible(false);
    	fff=1;
		//sound=new Sound();
		//sound.loadSound();
		panel=new mainpanel();
		mainframe.add(panel);
		panel.IThero(panel.level,man,mainframe);
		panel.requestFocus();
		validate();
	}
	
    public void actionPerformed(ActionEvent e)
	{
		
		
		if(e.getSource()==btn1)
		{
			gamemap1();
			
		}
		else if(e.getSource()==btn2)
		{
			man.money=rand.nextInt(100)+10;
			man.food=rand.nextInt(5)+5;
			w.randman(man);
			choosething();
		}
		else if(e.getSource()==btnx)
		{
			if(username.getText()==null||username.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "请输入名字");
			}
			else if(username.getText()!=null)
			{
				man.name=username.getText();
				enter();
			}
		}
		else if(e.getSource()==renew1||e.getSource()==btn3)
		{
			
			FileDialog dialog = new FileDialog(mainFrame.this, "Open",FileDialog.LOAD);
			dialog.setVisible(true);
			String dir = dialog.getDirectory();
			String fileName = dialog.getFile();
			String filePath = dir + fileName;
			
			if (fileName != null && fileName.trim().length() != 0) {
				File file = new File(filePath);
				fff=1;
				if(flag1==1)
				{
				btn1.setVisible(false);
				btn3.setVisible(false);
				btn4.setVisible(false);
				}
				if(flag2==1)
				{
					btn2.setVisible(false);
					btn6.setVisible(false);
				}
				if(flag3==1)
				{
//				btnx.setVisible(false);
//				a1.setVisible(false);
//				username.setVisible(false);	
					;
				}
				Attritube Man;
				try {
				FileInputStream fileStream = new FileInputStream(file);
				ObjectInputStream objectStream = new ObjectInputStream(fileStream);
				Man = (Attritube) objectStream.readObject();
				panel=new mainpanel();
				mainframe.add(panel);
				panel.IThero(4,Man,mainframe);
				panel.requestFocus();
				objectStream.close();
				fileStream.close();
				} catch (Exception e2) {
					System.out.println(e2);
				}		
			} 

		}
		else if(e.getSource()==ss)
		{
			JOptionPane.showConfirmDialog(mainFrame.this,"方向按键上下左右控制人物移动");
			
		}
		else if(e.getSource()==back)
		{
			/////////////save////////////////////////////
			if (fff==0) {
				JOptionPane.showConfirmDialog(mainFrame.this,"游戏没有运行\n不能保存游戏进度", "IThero",
				JOptionPane.DEFAULT_OPTION);
				return;
			}

			FileDialog dialog = new FileDialog(mainFrame.this, "Save",FileDialog.SAVE);
			dialog.setVisible(true);
			String dir = dialog.getDirectory();
			String fileName = dialog.getFile();
			String filePath = dir + fileName;
			
			if (fileName != null && fileName.trim().length() != 0) {
				File file = new File(filePath);
				panel.saveGameDataToFile(file);
			} else {
				JOptionPane.showConfirmDialog(mainFrame.this,"文件名为空\n保存游戏进度失败", "IThero", JOptionPane.DEFAULT_OPTION);
			}
			
		}
		else if(e.getSource()==btn6)
		{
			write();
		}
		else if(e.getSource()==btn4)
		{
	
			System.exit(0);
		}
		else if(e.getSource()==exit){System.exit(0);}
		else if(e.getSource()==about)
		{
			JOptionPane.showMessageDialog(this, me);
		}
		else if(e.getSource()==btnmuc)
		{
			if(sound.isplay())
			{
				sound.mystop();btnmuc.setLabel("音乐开");
			}
			else 
			{
				sound.loadSound();btnmuc.setLabel("音乐关");
			}
			panel.requestFocus();
		}
		
		
	}
    
    
    
    
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
