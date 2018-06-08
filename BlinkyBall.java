//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class BlinkyBall extends Ball
{
	private float temp;
   //constructors
   public BlinkyBall()
   {
   	super();temp = 0;
   }

   public BlinkyBall(int x, int y)
   {
   	super(x,y);temp = 0;
   }
   public BlinkyBall(Color col)
   {
   	super(col);temp = 0;
   }
   public BlinkyBall(int x, int y,Color col)
   {
   	super(x,y,col);temp = 0;
   }
   public BlinkyBall(int x, int y, int xSpd, int ySpd)
   {
   	super(x,y,xSpd,ySpd);temp = 0;
   }

   public BlinkyBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
   	super(x,y,wid,ht,xSpd,ySpd);temp = 0;
   }


   public BlinkyBall(int x, int y, int wid, int ht,Color col,int xSpd, int ySpd)
   {
   	super(x,y,wid,ht,col,xSpd,ySpd);temp = 0;
   }

   public void setXSpeed( int xSpd )
   {
   	super.setXSpeed(xSpd);temp = 0;
   }

   public void setYSpeed( int ySpd )
   {
   	super.setYSpeed(ySpd);temp = 0;
   }

   public void increaseColor()
   {
   	temp+=.01;
   }

   public void moveAndDraw(Graphics window)
   {
   	increaseColor();
   	super.setColor(Color.getHSBColor(temp, 1, 1));
   	super.moveAndDraw(window);
   }
}