package myCustCreator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener, KeyListener,MouseListener
{
	private static final long serialVersionUID = 1L;
	private int x,y;
	public Color definedColor = Color.YELLOW;
	public static int [][]boxes = new int[64][64];
	boolean oneGo = false;

	private static boolean grid = true;
	private static Color gridOn = Color.GREEN;
	private static Color gridOff = Color.BLACK;
	private static Color gridColor = Color.GREEN;
	
	public Game()
	{
		Timer time = new Timer(1, this);
		time.start();
		this.setFocusable(true);
		this.addKeyListener(this);
		this.addMouseListener(this);
		
		Reset();
	}

	public void paintComponent(Graphics g)
	{
		int a = -10;
		int b  = -0;

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 640,640);

		for(x = 0; x < 64; ++x)
		{
			for(y = 0; y < 64; ++y)
			{
				repaint();

				whichColor(boxes,x,y);

				a += 10;

				g.setColor(gridColor);
				g.drawRect(a, b, 10, 10);

				g.setColor(definedColor);
				g.fillRect(a, b, 9, 9);
			}

			b += 10;
			a = -10;
		}
		
	}// Displays the current board depending on the wall array.

	public void whichColor(int [][]boxes,int a, int b)
	{
		if(boxes[a][b] == 0)
		{
			definedColor = Color.BLACK;
		}
		else if(boxes[a][b] == 1)
		{
			definedColor = Color.ORANGE;
		}
		else if(boxes[a][b] == 2)
		{
			definedColor = Color.WHITE;
		}
	}

	public void actionPerformed(ActionEvent e)
	{}
	public void keyPressed(KeyEvent e)
	{}
	public void keyReleased(KeyEvent e)
	{}
	public void keyTyped(KeyEvent e)
	{}
	public void mousePressed(MouseEvent e)
	{}	
	public void mouseEntered(MouseEvent e)
	{}
	public void mouseExited(MouseEvent e)
	{}
	public void mouseClicked(MouseEvent e)
	{}	

	public void mouseReleased(MouseEvent e)
	{
		int c,d;

		d = e.getX() / 10;
		c = e.getY() / 10;
		
		System.out.println("X: " + c + " Y: " + d); 
		 
		if(e.getButton() == 1)
		{
			if(boxes[c][d] != 1)
			{
				boxes[c][d] = 1;
			}
			else
			{
				boxes[c][d] = 0;
			}
		}
		else if(e.getButton() == 2)
		{
			boxes[c][d] = 0;			
		}
		else if(e.getButton() == 3)
		{
			if(boxes[c][d] != 2)
			{
				boxes[c][d] = 2;
			}
			else
			{
				boxes[c][d] = 0;
			}		
		}
	
	}// Detects which box is clicked on and changes it's state.

	public static void Reset()
	{
		for(int i = 0; i < 32; ++i)
		{
			for(int j = 0; j < 32; ++j)
			{
				boxes[i][j] = 0;
			}
		}
		
	}// Resets the board.
	
	public static void Grid()
	{
		if(grid)
		{
			gridColor = gridOff;
			grid = false;
		}
		else
		{
			gridColor = gridOn;
			grid = true;
		}
		
	}// Switches the grid lines on and off
	
}// Game.java
