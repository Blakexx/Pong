//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block implements Collidable
{
   //instance variables
   private int speed;

   public Paddle()
	{
		super(10,10,10,10);
		speed=5;
	}
	
	//add the other Paddle constructors
	public Paddle(Color col){
		super(10,10,10,10,col);
		speed=5;
	}
	
	public Paddle(int x, int y)
	{
		super(x,y,10,10);
		speed=5;
	}
	
	public Paddle(int x, int y,int s)
	{
		super(x,y,10,10);
		speed=s;
	}
	public Paddle(int x, int y, int w, int h)
	{
		super(x,y,w,h);
		speed=5;
	}
	public Paddle(int x, int y, int w, int h, Color col)
	{
		super(x,y,w,h,col);
		speed=5;
	}
	public Paddle(int x, int y, int w, int h, Color col, int s)
	{
		super(x,y,w,h,col);
		speed=s;
	}
	
	public Paddle(int x, int y, int w, int h, int s)
	{
		super(x,y,w,h);
		speed=s;
	}
	
	public void setSpeed(int s){
		speed=s;
	}


   public void moveUpAndDraw(Graphics window)
   {
   	window.setColor(Color.WHITE);
   	draw(window,Color.WHITE);
		super.setY(super.getY()-speed);
		window.setColor(super.getColor());
		draw(window,Color.RED);
   }

   public void moveDownAndDraw(Graphics window)
   {
   	window.setColor(Color.WHITE);
   	draw(window,Color.WHITE);
		super.setY(super.getY()+speed);
		window.setColor(super.getColor());
		draw(window,Color.RED);
   }

   //add get methods
   public int getSpeed()
   {
   	return speed;
   }
   
   //add a toString() method
   public String toString(){
   	return super.toString()+" "+speed; 
   }
   public boolean didCollideLeft(Object obj){
   	Block leftPaddle = (Block)obj;
   	if(super.getX()<=leftPaddle.getX()+leftPaddle.getWidth() && super.getX() + super.getWidth() >= leftPaddle.getX())
		{
		    if(super.getY()>=leftPaddle.getY() && super.getY() <= leftPaddle.getY() + leftPaddle.getHeight())
		     {
		         return true;
		     }
		}
	return false;
   }  
   public boolean didCollideRight(Object obj){
   	Block rightPaddle = (Block)obj;
   	if(super.getX()+super.getWidth()>rightPaddle.getX() && super.getX() < rightPaddle.getX() + rightPaddle.getWidth())
		{
		    if(super.getY()>rightPaddle.getY() && super.getY() < rightPaddle.getY() + rightPaddle.getHeight())
		     {
		         return true;
		     }
		}
	return false;
   } 
   public boolean didCollideTop(Object obj){
   	Block thing = (Block)obj;
   	if(super.getY()<=thing.getY()+thing.getHeight()){
   		if(super.getX()>=thing.getX()&&super.getX()+super.getWidth()<=thing.getX()+thing.getWidth()){
   			return true;
   		}
   	}
   	return false;
   }
   public boolean didCollideBottom(Object obj){
   	Block thing = (Block)obj;
   	if(super.getY()+super.getHeight()>=thing.getY()){
   		if(super.getX()>=thing.getX()&&super.getX()+super.getWidth()<=thing.getX()+thing.getWidth()){
   			return true;
   		}
   	}
   	return false;
   }  
}