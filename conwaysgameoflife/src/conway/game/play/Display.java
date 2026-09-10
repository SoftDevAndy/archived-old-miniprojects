package conway.game.play;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Display extends JFrame implements MouseListener
{
	private static final long serialVersionUID = 1L;
	private final int WIDTH = 506;
	private final int HEIGHT = 558;
	private final int OFFSET = 2;
	private final int BTN_HEIGHT = 28;
	private final int BTN_POS = 500;
	private final int BTN_WIDTH = WIDTH / 3 - OFFSET;
	private Game game;
	
	private JButton btnRest;
	private JButton btnStep;
	private JButton btnAnim;
	
	private boolean isAnimating = false;
	
	public Display()
	{
		setTitle("Game of Life");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); 
		setResizable(false);
		setVisible(true);
		
		btnRest = new JButton("Clear Grid");		
		btnStep = new JButton("Step Through");	
		btnAnim = new JButton("Animate");	
		
		btnRest.addMouseListener(this);
		btnStep.addMouseListener(this);
		btnAnim.addMouseListener(this);
				
		btnRest.setBounds(OFFSET, BTN_POS, BTN_WIDTH, BTN_HEIGHT);
		btnStep.setBounds(BTN_WIDTH, BTN_POS, BTN_WIDTH, BTN_HEIGHT);
		btnAnim.setBounds(BTN_WIDTH * 2, BTN_POS, BTN_WIDTH, BTN_HEIGHT);
		
		add(btnRest);  
		add(btnStep);
		add(btnAnim);		
		
		game = new Game();
		
		add(game);
	}

	public void mouseClicked(MouseEvent e)
	{
		if(e.getSource() == btnRest)
		{	
			isAnimating = false;
			game.ResetBoard();
		}
		if(e.getSource() == btnStep)
		{
			isAnimating = false;
			game.StopTimer();
			game.DrawBoard();			
		}
		if(e.getSource() == btnAnim)
		{
			if(isAnimating)	
			{	
				isAnimating = false;
				game.StopTimer();
			}
			else
			{
				isAnimating = true;
				game.StartTimer();	
			}
		}
	}

	public static void main(String [] args)
	{
		new Display();
	}
	
	/* UNUSED BUT REQUIRED */
	
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mousePressed(MouseEvent e){}		
}