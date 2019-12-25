package com.Test.day20191129;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class mainpanel extends JPanel implements KeyListener, MouseListener, ActionListener,Serializable
{
	Attritube man1=new Attritube();
	int max=50;
	char[][] map,maptmp;
	int manX,manY,boxnum;
	Image[] myImage;
	Readmap Levelmap;
	Readmap Levelmaptmp;
	int len=30;
	int num=10;
	int num2=36;
	int data=1;
	int ff=0;
	public int level=1;
	Stack mystack=new Stack();
	Random rand = new Random();
	JFrame a2=new JFrame();
	//mainFrame mf=new mainFrame();
	final JFrame w=new JFrame("商店购买菜单");
	final JFrame w2=new JFrame("游玩菜单");
	final JFrame w3=new JFrame("个人界面");
	final JFrame w4=new JFrame("界面");
	final JFrame w5=new JFrame("打工菜单");
	public void setJF(JFrame a)
	{
		
		this.a2=a;
	}
	public void randman(Attritube a)
	{
		man1.money=a.money;
		man1.food=a.food;
	}
	mainpanel()
	{	
		setBounds(15,50,600,600);
		setBackground(Color.white);
		addKeyListener(this);
		myImage=new Image[100];
		for(int i=0; i<10; i++)
		{
		    myImage[i] = Toolkit.getDefaultToolkit().getImage("pic\\"+i+".gif");
		}
		//myImage[10]=Toolkit.getDefaultToolkit().getImage("pic\\"+"a.gif");
		 for(char i='a';i<='z';i++)
		 {
			 myImage[num]=Toolkit.getDefaultToolkit().getImage("pic\\"+i+".gif");
			 num++;
		 }
		 for(char i='A';i<='Z';i++)
		 {
			 myImage[num]=Toolkit.getDefaultToolkit().getImage("pic\\"+(int )(i-48)+".gif");
			 num++;
		 }
		 ///myImage[36]=A--17
		setVisible(true);
	}
	void fare()
	{
		if(data>=60&&ff==0)
		{
			w.setSize(720,720);
			w.setVisible(true);
			w.setResizable(false);
			w.setLocation(300,20);
			w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container cont=w.getContentPane();
			cont.setLayout(null);
			cont.setBackground(Color.white);
			JPanel j=(JPanel)w.getContentPane();
			j.setOpaque(false);
			JOptionPane.showMessageDialog(w, "时间到60天未通过考试，失败！");
		}
	}
	void fresh()
	{
	}
	void IThero(int i,Attritube a,JFrame x)
	{
		fresh();
		a2=x;
		man1=a;
		Levelmap=new Readmap(i);
		Levelmaptmp=new Readmap(i);
		map=Levelmap.getmap();
		manX=Levelmap.getmanX();
		manY=Levelmap.getmanY();
		maptmp=Levelmaptmp.getmap();
		repaint();
	}
	int maxlevel(){return max;}
	public void paint(Graphics g)
	{
		for(int i=0; i<20; i++)
			for(int j=0; j<20; j++)
		    {
				if(map[j][i]<='9'&&map[j][i]>='0')
			    g.drawImage(myImage[(int )(map[j][i]-48)],i*len,j*len,this);// draw g
				else if(map[j][i]<='z'&&map[j][i]>='a')
				{
					 g.drawImage(myImage[(int )(map[j][i]-87)],i*len,j*len,this);
				}
				else if(map[j][i]<='Z'&&map[j][i]>='A')
				{
					g.drawImage(myImage[(int )(map[j][i]-29)],i*len,j*len,this);
				}
			}		
		g.setColor(new Color(0,0,0));
		g.setFont(new Font("楷体_2312",Font.BOLD,30));
	}
	public void menuwork()
	{
		w5.setSize(720,720);
		w5.setVisible(true);
		w5.setResizable(false);
		w5.setLocation(300,20);
		w5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cont=w5.getContentPane();
		cont.setLayout(null);
		cont.setBackground(Color.white);
		JPanel j=(JPanel)w5.getContentPane();
		j.setOpaque(false);
	
		final JButton btn1=new JButton("金钱:"+man1.money);//rand
		btn1.setBounds(100, 50, 100, 50);
		w5.add(btn1);
		final JButton x1=new JButton("姓名:"+man1.name);
		x1.setBounds(200, 50, 100, 50);
		w5.add(x1);
		final JButton x2=new JButton("性别:"+man1.sex);
		x2.setBounds(300, 50, 100, 50);
		w5.add(x2);
		final JButton x3=new JButton("年龄:"+man1.age);
		x3.setBounds(400, 50, 100, 50);
		w5.add(x3);
		final JButton x4=new JButton("力量:"+man1.strong);
		x4.setBounds(500, 50, 100, 50);
		w5.add(x4);
		final JButton x5=new JButton("智力:"+man1.smart);
		x5.setBounds(600, 50, 100, 50);
		w5.add(x5);
		final JButton btn3=new JButton("打工");//rand
		btn3.setBounds(100, 200, 100, 50);
		w5.add(btn3);
		final JButton btn6=new JButton("精力"+man1.date);//rand
		btn6.setBounds(200, 200, 100, 50);
		w5.add(btn6);
		btn6.setText("精力"+man1.date);
		btn3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btn3)
				{
					if(man1.date<=0)
					{
						
						JOptionPane.showMessageDialog(w5, "不能打工没精力");	
					}
					else
					{
					man1.date-=1;
					man1.smart+=1;
					man1.money+=30;
					}
					btn1.setText("金钱："+man1.money);
					x5.setText("智力："+man1.smart);
					btn6.setText("精力："+man1.date);
				
				}
			}
		});
		final JButton btn22=new JButton("退出");//rand
		btn22.setBounds(100, 350, 150, 50);
		w5.add(btn22);
		btn22.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btn22)
				{
					w5.dispose();
				}
			}
		});
	}
	public void menubuy()  


	{
		w.setSize(720,720);
		w.setVisible(true);
		w.setResizable(false);
		w.setLocation(300,20);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cont=w.getContentPane();
		cont.setLayout(null);
		cont.setBackground(Color.white);
		JPanel j=(JPanel)w.getContentPane();
		j.setOpaque(false);
	
		final JButton btn1=new JButton("金钱:"+man1.money);//rand
		btn1.setBounds(100, 50, 120, 50);
		w.add(btn1);
		final JButton x1=new JButton("姓名:"+man1.name);
		x1.setBounds(200, 50, 100, 50);
		w.add(x1);
		final JButton x2=new JButton("性别:"+man1.sex);
		x2.setBounds(300, 50, 100, 50);
		w.add(x2);
		final JButton x3=new JButton("年龄:"+man1.age);
		x3.setBounds(400, 50, 100, 50);
		w.add(x3);
		final JButton x4=new JButton("力量:"+man1.strong);
		x4.setBounds(500, 50, 100, 50);
		w.add(x4);
		final JButton x5=new JButton("智力:"+man1.smart);
		x5.setBounds(600, 50, 100, 50);
		w.add(x5);
		final JButton btn3=new JButton("食物"+man1.food);//rand
		btn3.setBounds(100, 200, 100, 50);
		w.add(btn3);
		final JButton x7=new JButton("精力:"+man1.date);
		x7.setBounds(100, 100, 120, 50);
		w.add(x7);
		btn3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btn3)
				{
					if(man1.money<=9)
					{
						
						JOptionPane.showMessageDialog(w, "没钱");	
						
					}
					else if(man1.date<=0)
					{
						JOptionPane.showMessageDialog(w, "没精力不能买");
					}
					else
					{
					man1.date--;
					man1.money-=10;
					man1.food+=1;
					}
					btn3.setText("食物："+man1.food);
					btn1.setText("金钱："+man1.money);
					x7.setText("精力："+man1.date);
				}
			}
		});
		final JButton btn22=new JButton("退出");//rand
		btn22.setBounds(100, 350, 150, 50);
		w.add(btn22);
		
		btn22.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btn22)
				{
					btn1.setVisible(false);
					x7.setVisible(false);
					w.dispose();
				}
			}
		});
	}
	public void menustudy()
	{
		w4.setSize(720,720);
		w4.setVisible(true);
		w4.setResizable(false);
		w4.setLocation(300,20);
		w4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cont=w4.getContentPane();
		cont.setLayout(null);
		cont.setBackground(Color.white);
		JPanel j=(JPanel)w4.getContentPane();
		j.setOpaque(false);
	
		final JButton btn1=new JButton("金钱:"+man1.money);//rand
		btn1.setBounds(100, 50, 100, 50);
		w4.add(btn1);
		final JButton x1=new JButton("姓名:"+man1.name);
		x1.setBounds(200, 50, 100, 50);
		w4.add(x1);
		final JButton x2=new JButton("性别:"+man1.sex);
		x2.setBounds(300, 50, 100, 50);
		w4.add(x2);
		final JButton x3=new JButton("年龄:"+man1.age);
		x3.setBounds(400, 50, 100, 50);
		w4.add(x3);
		final JButton x4=new JButton("力量:"+man1.strong);
		x4.setBounds(500, 50, 100, 50);
		w4.add(x4);
		final JButton x5=new JButton("智力:"+man1.smart);
		x5.setBounds(600, 50, 100, 50);
		w4.add(x5);
		final JButton btn3=new JButton("学习");//rand
		btn3.setBounds(100, 200, 100, 50);
		w4.add(btn3);
		final JButton btn30=new JButton("考试");//rand
		btn30.setBounds(300, 200, 100, 50);
		w4.add(btn30);
		final JButton btn6=new JButton("精力"+man1.date);//rand
		btn6.setBounds(200, 200, 100, 50);
		w4.add(btn6);
		btn3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btn3)
				{
					if(man1.date<=0)
					{
						
						JOptionPane.showMessageDialog(w4, "没精力不能学");	
					}
					else
					{
					man1.date-=1;
					man1.smart+=3;
					}
					x5.setText("智力："+man1.smart);
					btn6.setText("精力："+man1.date);
				}
			}
		});
		final JButton btn22=new JButton("退出");//rand
		btn22.setBounds(100, 350, 150, 50);
		w4.add(btn22);
		btn22.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btn22)
				{
					w4.dispose();
				}
			}
		});
		btn30.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btn30)
				{
					if(man1.smart>20)
					{
						JOptionPane.showMessageDialog(w2, "智力到达20+，考试通过！");
						ff=1;
					}
					else
					{
						JOptionPane.showMessageDialog(w2, "智力<20");
					}
				}
			}
		});
	}
	public void menuplay()
	{
		w2.setSize(720,720);
		w2.setVisible(true);
		w2.setResizable(false);
		w2.setLocation(300,20);
		w2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cont=w2.getContentPane();
		cont.setLayout(null);
		cont.setBackground(Color.white);
		JPanel j=(JPanel)w2.getContentPane();
		j.setOpaque(false);
	
		final JButton btn1=new JButton("金钱:"+man1.money);//rand
		btn1.setBounds(100, 50, 100, 50);
		w2.add(btn1);
		final JButton x1=new JButton("姓名:"+man1.name);
		x1.setBounds(200, 50, 100, 50);
		w2.add(x1);
		final JButton x2=new JButton("性别:"+man1.sex);
		x2.setBounds(300, 50, 100, 50);
		w2.add(x2);
		final JButton x3=new JButton("年龄:"+man1.age);
		x3.setBounds(400, 50, 100, 50);
		w2.add(x3);
		final JButton x4=new JButton("力量:"+man1.strong);
		x4.setBounds(500, 50, 100, 50);
		w2.add(x4);
		final JButton x5=new JButton("智力:"+man1.smart);
		x5.setBounds(600, 50, 100, 50);
		w2.add(x5);
		final JButton btn3=new JButton("玩");//rand
		btn3.setBounds(100, 200, 100, 50);
		w2.add(btn3);
		btn3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btn3)
				{
					if(man1.money<=9)
					{
						
						JOptionPane.showMessageDialog(w2, "没钱");	
					}
					else
					{
					man1.money-=10;
					man1.smart+=1;
					}
					x5.setText("智力："+man1.smart);
					btn1.setText("金钱："+man1.money);
				}
			}
		});
		final JButton btn22=new JButton("退出");//rand
		btn22.setBounds(100, 350, 150, 50);
		w2.add(btn22);
		btn22.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btn22)
				{
					btn1.setVisible(false);
					w2.dispose();
				}
			}
		});
	}
	public void menuman()
	{
		w3.setSize(720,720);
		w3.setVisible(true);
		w3.setResizable(false);
		w3.setLocation(300,20);
		w3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cont=w3.getContentPane();
		cont.setLayout(null);
		cont.setBackground(Color.white);
		JPanel j=(JPanel)w3.getContentPane();
		j.setOpaque(false);
	
		final JButton btn1=new JButton("金钱:"+man1.money);//rand
		btn1.setBounds(100, 50, 100, 50);
		w3.add(btn1);
		final JButton x1=new JButton("姓名:"+man1.name);
		x1.setBounds(200, 50, 100, 50);
		w3.add(x1);
		final JButton x2=new JButton("性别:"+man1.sex);
		x2.setBounds(300, 50, 100, 50);
		w3.add(x2);
		final JButton x3=new JButton("年龄:"+man1.age);
		x3.setBounds(400, 50, 100, 50);
		w3.add(x3);
		final JButton x4=new JButton("力量:"+man1.strong);
		x4.setBounds(500, 50, 100, 50);
		w3.add(x4);
		final JButton x5=new JButton("智力:"+man1.smart);
		x5.setBounds(600, 50, 100, 50);
		w3.add(x5);
		final JButton x7=new JButton("精力:"+man1.date);
		x7.setBounds(100, 100, 100, 50);
		w3.add(x7);
		final JButton btn3=new JButton("休息");//rand
		btn3.setBounds(100, 200, 100, 50);
		w3.add(btn3);
		final JButton btn33=new JButton("天数"+data);//rand
		btn33.setBounds(200, 200, 100, 50);
		w3.add(btn33);
		btn3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btn3)
				{
					man1.date=10;
					data++;
					JOptionPane.showMessageDialog(w3, "新的一天开始了");	
					btn33.setText("天数"+data);
					x7.setText("精力"+man1.date);
				}
			}
		});
		final JButton btn22=new JButton("退出");//rand
		btn22.setBounds(100, 350, 150, 50);
		w3.add(btn22);
		
		btn22.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btn22)
				{
					btn1.setVisible(false);
					w3.dispose();
				}
			}
		});
	}
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{moveup();}
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{movedown();}
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{moveleft();}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{moveright();}
		if(iswin()==1)
		{
			IThero(2,man1,a2);
			mystack.removeAllElements();
		}
		else if(iswin()==2)
		{

			IThero(6,man1,a2);
			mystack.removeAllElements();
		}
		else if(iswin2()==3)
		{
			IThero(4,man1,a2);
			//menubuy();
			//IThero(1,man1);
			mystack.removeAllElements();
		}
		else if(iswin2()==5)
		{
			IThero(5,man1,a2);
			mystack.removeAllElements();
		}
		else if(iswin3()==7)
		{
			IThero(10,man1,a2);
		}
		else if(iswin()==11)
		{
			IThero(11,man1,a2);
		}
		else if(iswin4()==88)
		{
			menubuy();
		}
		else if(iswin4()==77)
		{
			IThero(12,man1,a2);
		}
		else if(iswin2()==15)
		{
			IThero(13,man1,a2);
		}
		else if(iswin3()==16)
		{
			IThero(14,man1,a2);
		}
		else if(iswin4()==40)
		{
			IThero(15,man1,a2);
		}
		else if(iswin()==19)
		{
			IThero(17,man1,a2);
		}
		else if(iswin3()==21)
		{
			IThero(16,man1,a2);
		}
		else if(iswin2()==100)
		{
			IThero(18,man1,a2);
		}
		else if(iswin5()==89)
		{
			menuplay();
		}
		else if(iswin5()==85)
		{
			menuman();
		}
		else if(iswin3()==83)
		{
			menustudy();
		}
		else if(iswin4()==55)
		{
			menuwork();
		}
	}
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
	boolean isMystackEmpty(){return mystack.isEmpty();}
	int  back(){
		return (Integer)mystack.pop();
		}
    void remove(){
		mystack.removeAllElements();
		}
	void moveup()
	{
		if(map[manY-1][manX]=='2'||map[manY-1][manX]=='4'||map[manY-1][manX]=='a'||
				map[manY-1][manX]=='E'||map[manY-1][manX]=='I'||map[manY-1][manX]=='h'
				||map[manY-1][manX]=='i'||map[manY-1][manX]=='w')
		{
			if(maptmp[manY][manX]=='4')
				map[manY][manX]='4';
			
			else if(maptmp[manY][manX]=='a')
				map[manY][manX]='a';
			else if(maptmp[manY][manX]=='E')
				map[manY][manX]='E';
			else if(maptmp[manY][manX]=='I')
				map[manY][manX]='I';
			else if(maptmp[manY][manX]=='h')
				map[manY][manX]='h';
			else if(maptmp[manY][manX]=='i')
				map[manY][manX]='i';
			else if(maptmp[manY][manX]=='w')
				map[manY][manX]='w';
			else 
				map[manY][manX]='2';
			map[manY-1][manX]='8';
			repaint();
			manY--;
			mystack.push(10);
		}
		
		
		if(map[manY-1][manX]=='1')
		{
			map[manY][manX]='8';repaint();
		}
	}
	void movedown()
	{
		if(map[manY+1][manX]=='2'||map[manY+1][manX]=='4'||map[manY+1][manX]=='a'
	||map[manY+1][manX]=='E'||map[manY+1][manX]=='I'||map[manY+1][manX]=='h'||
	map[manY+1][manX]=='i'||map[manY+1][manX]=='w')
		{
			if(maptmp[manY][manX]=='4')
				map[manY][manX]='4';
			
			else if(maptmp[manY][manX]=='a')
				map[manY][manX]='a';
			else if(maptmp[manY][manX]=='E')
				map[manY][manX]='E';
			else if(maptmp[manY][manX]=='I')
				map[manY][manX]='I';
			else if(maptmp[manY][manX]=='h')
				map[manY][manX]='h';
			else if(maptmp[manY][manX]=='i')
				map[manY][manX]='i';
			else if(maptmp[manY][manX]=='w')
				map[manY][manX]='w';
			else 
				map[manY][manX]='2';
			map[manY+1][manX]='5';
			repaint();
			manY++;
			mystack.push(20);
		}
		
		
		else if(map[manY+1][manX]=='1')
		{
			map[manY][manX]='5';repaint();
		}
	}
    void moveleft()
	{
		if(map[manY][manX-1]=='2'||map[manY][manX-1]=='4'||map[manY][manX-1]=='a'||
				map[manY][manX-1]=='E'||map[manY][manX-1]=='I'||map[manY][manX-1]=='h'
				||map[manY][manX-1]=='i'||map[manY+1][manX]=='w')
		{
			if(maptmp[manY][manX]=='4')
				map[manY][manX]='4';
			
			else if(maptmp[manY][manX]=='a')
				map[manY][manX]='a';
			else if(maptmp[manY][manX]=='E')
				map[manY][manX]='E';
			else if(maptmp[manY][manX]=='I')
				map[manY][manX]='I';
			else if(maptmp[manY][manX]=='h')
				map[manY][manX]='h';
			else if(maptmp[manY][manX]=='i')
				map[manY][manX]='i';
			else if(maptmp[manY][manX]=='w')
				map[manY][manX]='w';
			else 
				map[manY][manX]='2';
			map[manY][manX-1]='6';	
			repaint();
			manX--;
			mystack.push(30);
		}
		
		
		else if(map[manY][manX-1]=='1')
		{
			map[manY][manX]='6';repaint();
		}
	}
	void moveright()
	{
		if(map[manY][manX+1]=='2'||map[manY][manX+1]=='4'||map[manY][manX+1]=='a'
				||map[manY][manX+1]=='E'||map[manY][manX+1]=='I'||map[manY][manX+1]=='h'
				||map[manY][manX+1]=='i'||map[manY][manX+1]=='w')
		{			
			if(maptmp[manY][manX]=='4')
				map[manY][manX]='4';
			else if(maptmp[manY][manX]=='a')
				map[manY][manX]='a';
			else if(maptmp[manY][manX]=='E')
				map[manY][manX]='E';
			else if(maptmp[manY][manX]=='I')
				map[manY][manX]='I';
			else if(maptmp[manY][manX]=='h')
				map[manY][manX]='h';
			else if(maptmp[manY][manX]=='i')
				map[manY][manX]='i';
			else if(maptmp[manY][manX]=='w')
				map[manY][manX]='w';
			else 
			{
				map[manY][manX]='2';
			}
			map[manY][manX+1]='7';			
			repaint();
			manX++;
			mystack.push(40);
		}
		else if(map[manY][manX+1]=='1')
		{
			map[manY][manX]='7';
			repaint();
		}
	}
    int  iswin()
	{
		int num=0;
		for(int i=0; i<20; i++)
		{
			for(int j=0; j<20; j++)
		 {
			if(maptmp[i][j]=='4')
			{
			
				if(map[i][j]=='7')
				{
					num=1;
				}
				else if(map[i][j]=='6')
				{
					num=2;
				}
				else if(map[i][j]=='5')
				{
					num=11;
				}
				else if(map[i][j]=='8')
				{
					num=19;
				}
			}
		 }
		}
		return num;
	}
	int  iswin2()
	{
		int num=0;
		for(int i=0; i<20; i++)
		{
			for(int j=0; j<20; j++)
		 {
			
			if(maptmp[i][j]=='E')
			{
				if(map[i][j]=='8')
				{
					num=3;
				}
				else if(map[i][j]=='6')
				{
					num=5;
				}
				else if(map[i][j]=='5')
				{
					num=15;
				}
				else if(map[i][j]=='7')
				{
					num=100;
				}
			}
			
		 }
		}
		return num;
	}
	int  iswin3()
	{
		int num=0;
		for(int i=0; i<20; i++)
		{
			for(int j=0; j<20; j++)
		 {
			if(maptmp[i][j]=='h')
			{
				if(map[i][j]=='8')
				{
					num=7;
				}
				else if(map[i][j]=='5')
				{
					num=16;
				}
				else if(map[i][j]=='7')
				{
					num=21;
				}
				else if(map[i][j]=='6')
				{
					num=83;
				}
				else
				{
					w2.dispose();
				}
			}
			
		 }
		}
		return num;
	}
	int iswin4()
	{
		int num=0;
		for(int i=0; i<20; i++)
		{
			for(int j=0; j<20; j++)
		 {
			if(maptmp[i][j]=='i')
			{
				if(map[i][j]=='8')
				{
					num=88;
				}
				if(map[i][j]=='7')
				{
					num=77;
				}
				if(map[i][j]=='5')
				{
					num=40;
				}
				if(map[i][j]=='6')
				{
					num=55;
				}
				else
				{
					w.dispose();
				}
			}
			
		 }
		}
		return num;
	}
	int iswin5()
	{
		int num=0;
		for(int i=0; i<20; i++)
		{
			for(int j=0; j<20; j++)
		 {
			if(maptmp[i][j]=='w')
			{
				if(map[i][j]=='8')
				{
					num=89;
				}
				else if(map[i][j]=='7')
				{
					num=85;
				}
				else if(map[i][j]=='6')
				{
					num=84;
				}
				else
				{
					w2.dispose();
					w3.dispose();
				}
			}
		 }
		}
		return num;
	}
	public void saveGameDataToFile(File file) {

		try {

			FileOutputStream fileStream = new FileOutputStream(file);
			ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
			
			objectStream.writeObject(man1);
			objectStream.close();
			fileStream.close();
		} catch (Exception e) {

			System.out.println(e);
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
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
