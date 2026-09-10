package conway.game.play;

import javax.swing.*; 
import java.awt.event.*;	
import java.awt.*;

public class Game extends JPanel implements ActionListener, KeyListener, MouseListener
{
	private static final long serialVersionUID = 1L;
	private final int ANIMATION_SPEED = 150;
	private final int DIM = 50;
	private final int WINDOWSIZE = 500;
	private final int OFFSET = 5;
	private final int TILE_OUTSIDE = DIM / OFFSET;
	private final int TILE_INSIDE = TILE_OUTSIDE - 1;
		
	private Color colorActive = Color.GREEN;
	private Color colorInactive = Color.WHITE;	
	private Color colorLine = Color.LIGHT_GRAY;
	
	private Timer timer;
	
	private boolean [][]boxes = new boolean[DIM][DIM];
	private boolean [][]tempBoxes = new boolean[DIM][DIM];
	
	public Game()
	{	
		this.addKeyListener(this);
		this.setFocusable(true);
		this.addMouseListener(this);
	}

	public void paintComponent(Graphics g)
	{
		int a = -TILE_OUTSIDE;
		int b  = -0;

		g.setColor(colorLine);
		g.fillRect(0, 0, WINDOWSIZE,WINDOWSIZE);

		for(int x = 0; x < DIM; ++x)
		{
			for(int y = 0; y < DIM; ++y)
			{
				a += TILE_OUTSIDE;

				g.setColor(colorLine);
				g.drawRect(a, b, TILE_OUTSIDE, TILE_OUTSIDE);

				g.setColor(TileColor(boxes,x,y));
				g.fillRect(a, b, TILE_INSIDE, TILE_INSIDE);
			}

			b += TILE_OUTSIDE;
			a = -TILE_OUTSIDE;
		}
	}

	public Color TileColor(boolean [][]boxes,int a, int b)
	{
		if(boxes[a][b])
			return colorActive;
		else
			return colorInactive;
	}
	
	public int GetNeighbourCount(int x, int y)
	{		
		int NeighbourCount = 0;

		// Top Left
		
		try
		{
			if(boxes[x - 1][y - 1])
				++NeighbourCount;
		}catch(ArrayIndexOutOfBoundsException e){}
		
		// Top Middle
		
		try
		{
			if(boxes[x][y - 1])
				++NeighbourCount;
		}catch(ArrayIndexOutOfBoundsException e){}
		
		// Top Right
		
		try
		{
			if(boxes[x + 1][y - 1])
				++NeighbourCount;
		}catch(ArrayIndexOutOfBoundsException e){}
		
		// Middle Left
		
		try
		{
			if(boxes[x - 1][y])
				++NeighbourCount;
		}catch(ArrayIndexOutOfBoundsException e){}
		
		// Middle Right
		
		try
		{
			if(boxes[x + 1][y])
				++NeighbourCount;
		}catch(ArrayIndexOutOfBoundsException e){}
		
		
		// Bottom Left
		
		try
		{
			if(boxes[x - 1][y + 1])
				++NeighbourCount;
		}catch(ArrayIndexOutOfBoundsException e){}
		
		// Bottom Middle
		
		try
		{
			if(boxes[x][y + 1])
				++NeighbourCount;
		}catch(ArrayIndexOutOfBoundsException e){}
		
		// Bottom Right
		
		try
		{
			if(boxes[x + 1][y + 1])
				++NeighbourCount;
		}catch(ArrayIndexOutOfBoundsException e){}
				
		return NeighbourCount;
	}
	
	public boolean LifeRule(int x,int y,int NeighbourCount){
		
		boolean status = false;
		
		/*	GAME OF LIFE RULES */
		
		// Rule 1
		// Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
		
		if(boxes[x][y] && NeighbourCount < 2)
		{
			status = false;				
		}
		
		// Rule 2
		// Any live cell with two or three live neighbours lives on to the next generation.
		
		if(boxes[x][y] && NeighbourCount == 2 || NeighbourCount == 3)
		{
			status =  true;				
		}
		
		// Rule 3
		// Any live cell with more than three live neighbours dies, as if by overpopulation.
		
		if(boxes[x][y] && NeighbourCount > 3)
		{
			status =  false;				
		}				
		
		// Rule 4
		// Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction	
		
		if(boxes[x][y] == false && NeighbourCount == 3)
		{
			status =  true;				
		}	
		
		return status;
	}

	public void DrawBoard()
	{		
		ClearTemp();
		
		for(int x = 0; x < DIM; ++x)
		{
			for(int y = 0; y < DIM; ++y)
			{
				int NeighbourCount = GetNeighbourCount(x,y);

				tempBoxes[x][y] = LifeRule(x,y,NeighbourCount);				
			}
		}
		
		for(int x = 0; x < DIM; ++x)
		{
			for(int y = 0; y < DIM; ++y)
			{
				boxes[x][y] = tempBoxes[x][y];		
			}
		}
		
		repaint();
	}

	public void ResetBoard()
	{
		if(timer != null)
			timer.stop();
		
		for(int i = 0; i < DIM; ++i)
		{
			for(int j = 0; j < DIM; ++j)
			{
				boxes[i][j] = false;
				tempBoxes[i][j] = false;
			}
		}

		repaint();
	}
	
	public void ClearTemp()
	{
		for(int i = 0; i < DIM; ++i)
		{
			for(int j = 0; j < DIM; ++j)
				tempBoxes[i][j] = false;
		}		
	}
	
	public void StartTimer(){
		timer = new Timer(ANIMATION_SPEED, this);
		timer.start(); 
	}
	
	public void StopTimer(){
		
		if(timer != null)
			timer.stop(); 
	}

	public void mousePressed(MouseEvent e)
	{
		int a = e.getY() / TILE_OUTSIDE;
		int b = e.getX() / TILE_OUTSIDE;
		
		boxes[a][b] = !boxes[a][b];
		repaint();
	}	
	
	public void actionPerformed(ActionEvent e){	
		DrawBoard();
	}
	
	/* UNUSED BUT REQUIRED */
	
	@SuppressWarnings("unused")
	private void update(){}
	
	public void keyPressed(KeyEvent e){}
	public void keyTyped(KeyEvent e){}	
	public void keyReleased(KeyEvent e){}	
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
}

