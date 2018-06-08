//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable
{
	private SpeedUpBall ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private int rScore;
	private int lScore;
	private Wall tWall;
	private Wall bWall;
	private Wall lWall;
	private Wall rWall;

	public Pong()
	{
		//set up all variables related to the game
		ball = new SpeedUpBall(400,300,Color.BLUE);
		leftPaddle = new Paddle(25,350,10,100,Color.RED);
		
		rightPaddle = new Paddle(740,350,10,100,Color.RED);
		
		tWall = new Wall(0,0,800,10,Color.BLACK);
		bWall = new Wall(0,550,800,50,Color.BLACK);
		lWall = new Wall(0,0,10,600,Color.GREEN);
		rWall = new Wall(775,0,25,600,Color.GREEN);
		
		keys = new boolean[4];
		rScore = 0;
		lScore=0;
    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
   		boolean temp = true;
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();
		if(temp){
			graphToBack.setColor(Color.RED);
			graphToBack.drawString("Right Score = "+rScore,340,510);
			graphToBack.drawString("Left Score = "+lScore,340,530);
			temp=false;
		}

		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);
		
		tWall.draw(graphToBack);
		bWall.draw(graphToBack);
		rWall.draw(graphToBack);
		lWall.draw(graphToBack);
		
		//see if ball hits left wall or right wall
		if(ball.didCollideLeft(lWall)||ball.didCollideRight(rWall))
		{
			if(ball.didCollideLeft(lWall)){
				rScore++;
				ball.draw(graphToBack,Color.WHITE);
				ball.setX(400);
				ball.setY(300);
			}else{
				lScore++;
				ball.draw(graphToBack,Color.WHITE);
				ball.setX(400);
				ball.setY(300);
			}
			graphToBack.setColor(Color.WHITE);
			graphToBack.fillRect(400,500,200,50);
			graphToBack.setColor(Color.RED);
			graphToBack.drawString("Right Score = "+rScore,340,510);
			graphToBack.drawString("Left Score = "+lScore,340,530);
			ball.setXSpeed(-ball.getXSpeed());
			if(ball.getXSpeed()<0){
				ball.setXSpeed(3);
				ball.setYSpeed(0);
			}else{
				ball.setXSpeed(-3);
				ball.setYSpeed(0);
			}
			rightPaddle.draw(graphToBack,Color.WHITE);
			leftPaddle.draw(graphToBack,Color.WHITE);
			leftPaddle.setY(250);
			rightPaddle.setY(250);
		}
		
		//see if the ball hits the top or bottom wall 
		
		
		if(leftPaddle.didCollideBottom(bWall)){
			leftPaddle.setY(450);
			leftPaddle.draw(graphToBack,Color.RED);
		}else if(leftPaddle.didCollideTop(tWall)){
			leftPaddle.setY(10);
			leftPaddle.draw(graphToBack,Color.RED);
		}
		
		if(rightPaddle.didCollideBottom(bWall)){
			rightPaddle.setY(450);
			rightPaddle.draw(graphToBack,Color.RED);
		}else if(rightPaddle.didCollideTop(tWall)){
			rightPaddle.setY(10);
			rightPaddle.draw(graphToBack,Color.RED);
		}
		


		if(ball.didCollideBottom(bWall)||ball.didCollideTop(tWall))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}
		
		
		if(ball.didCollideLeft(leftPaddle)){
			ball.setXSpeed(ball.getXSpeed()*(-1));
			if(Math.abs((leftPaddle.getY()+leftPaddle.getHeight())-ball.getY()+ball.getHeight()/2)>55){
				ball.setYSpeed(-1);
			}else if(Math.abs((leftPaddle.getY()+leftPaddle.getHeight())-ball.getY()+ball.getHeight()/2)<45){
				ball.setYSpeed(1);
			}else{
				ball.setYSpeed(0);
			}
		}
		
		if(ball.didCollideRight(rightPaddle)){
			ball.setXSpeed(ball.getXSpeed()*(-1));
			if(Math.abs((rightPaddle.getY()+rightPaddle.getHeight())-ball.getY()+ball.getHeight()/2)>55){
				ball.setYSpeed(-1);
			}else if(Math.abs((rightPaddle.getY()+rightPaddle.getHeight())-ball.getY()+ball.getHeight()/2)<45){
				ball.setYSpeed(1);
			}else{
				ball.setYSpeed(0);
			}
		}
		
		//see if the paddles need to be moved
		
		if(keys[0] == true)
		{
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1] == true)
		{
			leftPaddle.moveDownAndDraw(graphToBack);
		}
		if(keys[2] == true)
		{
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[3] == true)
		{
			rightPaddle.moveDownAndDraw(graphToBack);
		}
		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}