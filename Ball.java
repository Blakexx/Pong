//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private double xSpeed;
	private double ySpeed;

	public Ball()
	{
		super(200,200,10,10);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	//add the other Ball constructors
	public Ball(Color col){
		super(200,200,10,10,col);
		xSpeed=3;
		ySpeed=1;
	}
	
	public Ball(int x, int y)
	{
		super(x,y,10,10);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y,Color col)
	{
		super(x,y,10,10,col);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y, int w, int h)
	{
		super(x,y,w,h);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y, int w, int h, Color col)
	{
		super(x,y,w,h,col);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int x, int y, int w, int h, double xs, double ys)
	{
		super(x,y,w,h);
		xSpeed=xs;
		ySpeed=ys;
	}
	public Ball(int x, int y, int w, int h, Color col, double xs, double ys)
	{
		super(x,y,w,h,col);
		xSpeed=xs;
		ySpeed=ys;
	}
	

   //add the set methods
   public void setXSpeed(double x)
   {
   	xSpeed = x;
   }
   public void setYSpeed(double y)
   {
   	ySpeed = y;
   }

   public void moveAndDraw(Graphics window)
   {
   	window.setColor(Color.WHITE);
   	//draw a white ball at old ball location
   	window.fillRect(super.getX(),super.getY(),super.getWidth(),super.getHeight());
      super.setX((int)Math.round(super.getX()+xSpeed));
		//setY
		super.setY((int)Math.round(super.getY()+ySpeed));
		//draw the ball at its new location
		window.setColor(super.getColor());
		window.fillRect(super.getX(),super.getY(),super.getWidth(),super.getHeight());
   }
   
	public boolean equals(Object obj)
	{
		Ball cool = (Ball)obj;
		return (cool.getX() == super.getX()) && (cool.getY() == super.getY()) && (cool.getWidth() == super.getWidth()) && (cool.getHeight() == super.getHeight()) && (cool.getColor() == super.getColor())&&(cool.getXSpeed()==xSpeed&&cool.getYSpeed()==ySpeed);
	}   

   //add the get methods
   public double getXSpeed(){
   	return xSpeed;
   }
   public double getYSpeed(){
   	return ySpeed;
   }
   //add a toString() method
   public String toString(){
   	return super.toString()+" "+xSpeed+" "+ySpeed; 
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
   public Color getColor()
   {
   	return super.getColor();
   }
}