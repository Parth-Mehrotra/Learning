import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.*;
import java.lang.Math;
//import javax.swing.BoxLayout;
public class GameLayout extends JPanel implements KeyListener
{
	public String s;
	public String secret;
	int b, seq, seq2;
	public static JLabel[] labels; 
	final int width = 800;								//Width & Height
	final int height = 500;
	private Font font = new Font("Calibri",1,42);		//Font
	//Hangman h;										//New hangman object to utilize methods
	public static String inputString;
	private int p;
	JPanel second;
	boolean i = false;
	Hangman h;											//String to hold the textfield's input
	public GameLayout()
	{
		s = "";
		h = new Hangman();
		second = new JPanel();
		this.setLayout(new BorderLayout());
		p = 0;
		seq2 = 0;
		labels = createLabels(26,"hi");							
		h.add(second);
		secret = h.getSecret();
		this.add(h,BorderLayout.CENTER); 
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(width,height));
		//j = new JTextField("    ");
		//j.setPreferredSize(new Dimension(400,200));
		//j.setLocation(25,100);
		//j.addKeyListener(this);
		//this.add(j,BorderLayout.SOUTH);
	} 
	
	public JLabel[] createLabels(int a, String s)
	{
		JLabel[] k = new JLabel[a];
		for(int i = 0; i<a; i++){
			k[i] = new JLabel();
			k[i].setFont(font);
			second.add(k[i]);
			//k[i].setPreferredSize(new Dimension(50,10));
			//k[i].setLocation(x+=5,y);
		}
		return k;
	}
	public void draw()
	{
		h.setSequence(seq,seq2);
		h.setString(s);
		h.repaint();
	}
	public static String getString()
	{
		return inputString;
	}
	public void keyPressed(KeyEvent e)
	{
		labels[p].setText("" + e.getKeyChar()); 
		inputString = labels[p].getText();
		p++;
		if(secret.indexOf(inputString)==-1)
		{
			seq++;
			draw();
		}
		else if(secret.indexOf(inputString)!=-1)
		{
			seq2++;
			s = "" + e.getKeyChar();
			draw();
			h.repaint();
		}
		//i = true;
	}
	public void keyReleased(KeyEvent e)
	{
		
	}
	public void keyTyped(KeyEvent e)
	{
		
	}
	/*
	public void actionPerformed(ActionEvent e)
	{
		//s = j.getText();
		//update();
		//repaint();

	}
	public void paintComponent(Graphics g)
	{
	    //super.paintComponent(g);
		//g.setColor(Color.RED);
		//setBackground(Color.GREEN);
		//if(i == true) g.drawRect(150,200,25,50);
		//repaint();
	}
	*/
	/*public static String getString()
	{
		return s;
	}
	public static String getSecret()
	{
		return secret;	
	}
	*\
	/*public void update()
	{
		//h.update();
		if(f==true)
		{
			System.out.println("Up");
		}
	}
	*/
}	
