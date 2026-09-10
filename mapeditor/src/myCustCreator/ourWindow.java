package myCustCreator;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.zip.ZipFile;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ourWindow extends JFrame
{
	private final static int TILE_SET = 5;	// Very Important for now
	public static JMenu position;
	
	private static final long serialVersionUID = 1L;
	private final int LENGHT = 646;
	private final static int WIDTH = 646;
	private static int TILE = 32;
	private final String VERSION = "Version 1.0.0";
	private static Image wall,floor,blank;
	private static JRadioButtonMenuItem[] radMenButtons = new JRadioButtonMenuItem[aboutImgSet()];
	private static ImageIcon[] imgIcon = new ImageIcon[aboutImgSet()];
	private static Image allWall[] = new Image[aboutImgSet()];
	private static Image allFloor[] = new Image[aboutImgSet()];
	private static JMenuBar menuBar;
	private static JMenu menu,reset,about,tileMenu;
	private static JMenuItem menuItemExport,menuItemImport,resetItem,aboutItem;
	private static JRadioButtonMenuItem rbMenuItem;
	public static String timeIs;

	public ourWindow()
	{
		setTitle("Andy Custom Map Editor \t\t" + VERSION);
		setSize(LENGHT, WIDTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		setIconImage(floor);
		
		/* Menu Stuff */
				
		menuBar = new JMenuBar();

		rbMenuItem = new JRadioButtonMenuItem("Grid");
		
		menu = new JMenu("File");
		tileMenu = new JMenu("Tile Menu");
		reset = new JMenu("Options");
		about = new JMenu("About");
		
		menuItemExport = new JMenuItem("Export");
		menuItemImport = new JMenuItem("Import");
		resetItem = new JMenuItem("Reset");
		
		reset.add(rbMenuItem);
		
		aboutItem = new JMenuItem("How To");

		rbMenuItem.addActionListener(new ActionListener()
		{			
			public void actionPerformed(ActionEvent arg0) 
			{
				Game.Grid();				
			}
		});
		
		aboutItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				About();				
			}
		});
		
		resetItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Game.Reset();				
			}
		});		
		
		menuItemExport.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					Export();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}				
			}
		});
		
		menuItemImport.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					Import();
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}				
			}
		});

		menu.add(menuItemExport);
		menu.add(menuItemImport);
		reset.add(resetItem);
		about.add(aboutItem);
		
		loadTiles();
		setSelectTile();
		
		menuBar.add(menu);
		menuBar.add(tileMenu);
		menuBar.add(reset);
		menuBar.add(about);
		setJMenuBar(menuBar);

		/* Menu Stuff */

		add(new Game());
        setVisible(true);
        
		tileSelected(0);
	}
	
	public static void main(String [] args)
	{
		new ourWindow();
	}
	
	private void Import() throws IOException
	{
		final JFileChooser chooser = new JFileChooser();
		int option;
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files","txt");
		chooser.setFileFilter(filter);
		
		option = chooser.showOpenDialog(getParent());
		
		if(option == JFileChooser.APPROVE_OPTION) 
		{
			File file = chooser.getSelectedFile();
					  
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			
			Queue<Integer> map = new LinkedList<Integer>();
			
			while ((line = reader.readLine()) != null)
			{
				for(char a : line.toCharArray())
				{
					if(a == '0')
					{
						map.add(0);
					}
					else if(a == '1')
					{
						map.add(1);
					}
					else if(a == '2')
					{
						map.add(2);
					}
				}
			}
				
			for(int i = 0; i < 64; ++i)
			{
				for(int j = 0; j < 64; ++j)
				{
					Game.boxes[i][j] = map.poll();
				}
			}
			
			for(int i = 0; i < 64; ++i)
			{
				for(int j = 0; j < 64; ++j)
				{
					System.out.print(Game.boxes[i][j] + " ");
				}
				
				System.out.println();
			}
			
			reader.close();
		}	
	
	}// Imports an existing array walls file and builds the map on the editor screen.
	
	private void Export() throws IOException
	{	
		int HEIGHT =  2048;
		int WIDTH =  2048;
	
		/* Exporting the Wall Array  */
		
		File dir;
		
		timeIs = "" + System.currentTimeMillis();
		
		dir = new File("Map/" + timeIs);
		dir.mkdir();
				
		String fileName = "Map/" + timeIs + "/" + timeIs;		
		FileWriter writer = new FileWriter(fileName + ".txt");				
		
		writer.write(Arrays.deepToString(Game.boxes));
		writer.close();
		
		/* Exporting the Wall Array  */		
		
		BufferedImage bufferedImage = new BufferedImage(HEIGHT,WIDTH, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bufferedImage.createGraphics();
		
		for(int i = 0; i < 64; ++i)
		{
			for(int j = 0; j < 64; ++j)
			{
				
				if(Game.boxes[j][i] == 0)
				{
					g2d.drawImage(blank,(i * TILE),(j * TILE), TILE, TILE,null);
				}
				else if(Game.boxes[j][i] == 1)
				{
					g2d.drawImage(wall,(i * TILE),(j * TILE), TILE, TILE,null);
				}
				else if(Game.boxes[j][i] == 2)
				{
					g2d.drawImage(floor,(i * TILE),(j * TILE), TILE, TILE,null);
				}
			}
		}
		
		File file = new File("Map/" + timeIs + "/" + timeIs + ".png");
		ImageIO.write(bufferedImage, "png", file);
		
		JOptionPane.showMessageDialog(this, "Code + Image Created in folder: " + timeIs ,"Created", JOptionPane.INFORMATION_MESSAGE);
	
	}// Exports the wall array file and exports the wall images also.
	
	private void About()
	{
		String howTo = VERSION + "\n\nLeft Click           =  Wall" + "\nRight Click          =  Floor" + "\nMiddle Mouse     =  Blank";
		
		JOptionPane.showMessageDialog(this, howTo ,"How to use:", JOptionPane.INFORMATION_MESSAGE);
	
	}// Displays a dialog box with some basic version info
	
	private static int aboutImgSet()
	{
		int x = TILE_SET;
		
		/*
		
		This method needs reworking so it isn't hardcoded. Below is an attempted to make it dynamic..
		 
		int x = new File("src/Images").list().length / 2;
				
		List<String> fileNames = new ArrayList<>();
		String directory = "./Images";
		 
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) 
		{
			for (Path path : directoryStream) 
	        {
	            ++x;
	        }
	 
		 }
		 catch (IOException ex)
		 {
			 x = new File("src/Images").list().length / 2;
		 }
		 
		x = x/2;
		
		*/
		
		return x;	
	}
	
	private void setSelectTile()
	{
		for(int i = 0;i < aboutImgSet();++i)
		{
			String imgPlace = "/Images/" + ((char)(97 + i)) + 0 + ".png";
		
			try 
			{
				imgIcon[i] =  new ImageIcon(ImageIO.read(this.getClass().getResourceAsStream(imgPlace)));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
		}// for
		
		for(int i = 0;i < aboutImgSet();++i)
		{			
			radMenButtons[i] = new JRadioButtonMenuItem(i + "",imgIcon[i]);
		}// for
		
		for(int i = 0;i < aboutImgSet();++i)
		{			
			radMenButtons[i].addActionListener(new ActionListener()
			{			
				public void actionPerformed(ActionEvent arg0) 
				{
					String x = arg0.getActionCommand();	
					
					int y = Integer.parseInt(x);
					
					tileSelected(y);
				}
			});
		}// for
		
		for(int i = 0;i < aboutImgSet();++i)
		{			
			tileMenu.add(radMenButtons[i]);
		}// for
		
	}// setSelectTile builds the current tile set that is used when the map image is created.
	
	private void loadTiles()
	{
		init();
		
		try 
		{
			blank = ImageIO.read(this.getClass().getResource("/Images/blank.png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		for(int i = 0;i < aboutImgSet();++i)
		{
			String wallLoc = "";
			String floorLoc = ""; 
			
			try 
			{				
				floorLoc  = "/Images/" + ((char)(97 + i)) + 0 + ".png";				
				wallLoc = "/Images/" + ((char)(97 + i)) + 1 + ".png";
				
				allWall[i] =  ImageIO.read(this.getClass().getResourceAsStream(wallLoc));
				allFloor[i] = ImageIO.read(this.getClass().getResourceAsStream(floorLoc));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
		}// for	
		
	}// Program boots and the images get read in and loaded for use when editing the map
	
	private void tileSelected(int pos)
	{
		for(int i = 0;i < aboutImgSet();++i)
		{			
			radMenButtons[i].setSelected(false);			
		}// for
		
		radMenButtons[pos].setSelected(true);
		
		wall = allWall[pos];
		floor = allFloor[pos];
	
	}// Finds which is the current tile and switches off the other menu components.
	
	public void init()
	{		
		for(int i = 0;i < aboutImgSet();++i)
		{			
			allWall[i] = null;
			allFloor[i] = null;	
			
		}// for
		
	}// Some bare init stuff.

}// ourWindow.java