//package kion.pong.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball
{

	int x,y;
	int size = 16;
	int speed = 2;
	int Pscore=0;
	int Ascore=0;
	int vx,vy;

	Rectangle boundingBox;

	public Ball(int x,int y)
	{
		this.x=x;
		this.y=y;

		vx =speed;
		vy= speed;

		boundingBox = new Rectangle(x,y,size,size);
	     boundingBox.setBounds(x,y,size,size);
	}

	public void tick(Game game)
	{
		boundingBox.setBounds(x,y,size,size);
		if(x<=0)
		{
			vx =speed;
			game.aScore++;
			//System.out.println("Ai's score:"+ Ascore);

		}
		else if(x + size >= game.getWidth() )
		{
			vx = -speed;
			game.pScore++;
		//	System.out.println("Player 1's score:"+ Pscore);

		}

		if(y<=0)
		{
			vy =speed;

		}
		else if(y + size >= game.getHeight() )
		{
			vy = -speed;

		}
		x+=vx;
		y+=vy;

		paddleCollide(game);
	}
	private void paddleCollide(Game game)
	{
		if(boundingBox.intersects(game.player.boundingBox))
		{
			vx = speed;
		}
		else if(boundingBox.intersects(game.ai.boundingBox))
		{
			vx = -speed;
		}
	}
	public void render(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillOval(x, y, size, size);






	}

}
