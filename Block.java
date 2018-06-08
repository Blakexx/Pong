//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block()
	{
		xPos=100;
		yPos=150;
		width=10;
		height=10;
		color=new Color(0,0,0);
	}

	//add other Block constructors - x , y , width, height, color
	public Block(Color col){
		color=col;
	}
	
	public Block(int x, int y)
	{
		xPos=x;
		yPos=y;
		width=0;
		height=0;
		color = new Color(0,0,0);
	}
	public Block(int x, int y, int w, int h)
	{
		xPos=x;
		yPos=y;
		width=w;
		height=h;
		color = new Color(0,0,0);
	}
	public Block(int x, int y, int w, int h, Color col)
	{
		xPos=x;
		yPos=y;
		width=w;
		height=h;
		color = col;
	}
   //add the other set methods
   public void setPos(int x, int y)
   {
   	xPos = x;
   	yPos = y;
   }
   public void setX(int x)
   {
   	xPos = x;
   }
   public void setY(int y)
   {
   	yPos = y;
   }
   public void setWidth(int h)
   {
   	height = h;
   }
   public void setHeight(int w)
   {
   	width = w;
   }
   public void setColor(Color col)
   {
   	color = col;
   }

   public void draw(Graphics window)
   {
     window.setColor(color);
     window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
   	 window.setColor(col);
     window.fillRect(getX(), getY(), getWidth(), getHeight());
   }
   
	public boolean equals(Object obj)
	{
		Block cool = (Block)obj;
		return (cool.getX() == xPos) && (cool.getY() == yPos) && (cool.getWidth() == width) && (cool.getHeight() == height) && (cool.getColor() == color);
	}   

   //add the other get methods
   public int getX()
   {
   	return xPos;
   }
   public int getY()
   {
   	return yPos;
   }
   public int getWidth()
   {
   	return width;
   }
   public int getHeight()
   {
   	return height;
   }
   public Color getColor()
   {
   	return color;
   }

   //add a toString() method  - x , y , width, height, color
   public String toString(){
   	return ""+xPos+" "+yPos+" "+width+" "+height+" "+color;
   }
}