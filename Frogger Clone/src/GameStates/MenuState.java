rawpackage GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import TileMap.Background;

public class MenuState extends GameState
{
	
	private Background bg;
	
	private String [] options = {"Start","Help","Quit"};
	
	private Color titleColor;
	private Font titleFont;
	private Font font;
	
	private int currentChoice =0;
	
	
	
	public MenuState(GameStateManager gsm)
	{
		this.gsm = gsm;
		
		try
		{
			bg = new Background("/Background/FinalFrogger.png");
			//bg = new Background("/Background/menubg.gif");
			///titleColor = new Color(128,0,0);
			titleFont = new Font("Arial",Font.PLAIN,28);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void init()
	{
		
	}
	public void update()
	{
		bg.update();
	}
	public void draw(Graphics2D g)
	{
		bg.draw(g);
		
		g.setColor(titleColor);
		g.setFont(titleFont);
		
		g.setFont(font);
		for(int i =0;i<options.length;i++)
		{
			if(i == currentChoice)
			{
				g.setColor(Color.BLACK);
			}
			else
			{
				g.setColor(Color.RED);
			}
			
			g.drawString(options[i], 190, 140+i*50);
		}
		
		
	}
	
	private void select()
	{
		if(currentChoice ==0)
		{
			gsm.setState(GameStateManager.LEVEL1STATE);
		}
		if(currentChoice ==1)
		{
			
		}
		if(currentChoice ==2)
		{
			System.exit(0);
		}
	}
	public void keyPressed(int k)
	{
		if(k == KeyEvent.VK_ENTER)
		{
			select();
		}
		
		if(k == KeyEvent.VK_UP)
		{
			currentChoice--;
			
			if(currentChoice == -1)
			{
				currentChoice = options.length -1;
			}
		}
		if(k == KeyEvent.VK_DOWN)
		{
			currentChoice++;
			
			if(currentChoice == options.length)
			{
				currentChoice = 0;
			}
		}
	}
	public void keyReleased(int k)
	{
		
	}
}
