//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

   //instance variables

   public SpeedUpBall()
   {
   	super();
   }

   public SpeedUpBall(int x, int y)
   {
   	super(x,y);
   }
   public SpeedUpBall(Color col)
   {
   	super(col);
   }
   public SpeedUpBall(int x, int y,Color col)
   {
   	super(x,y,col);
   }
   public SpeedUpBall(int x, int y, int xSpd, int ySpd)
   {
   	super(x,y,xSpd,ySpd);
   }

   public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
   	super(x,y,wid,ht,xSpd,ySpd);
   }


   public SpeedUpBall(int x, int y, int wid, int ht,Color col,int xSpd, int ySpd)
   {
   	super(x,y,wid,ht,col,xSpd,ySpd);
   }

   public void setXSpeed( int xSpd )
   {
   	super.setXSpeed(xSpd);
   }

   public void setYSpeed( int ySpd )
   {
   	super.setYSpeed(ySpd);
   }
   public boolean didCollideLeft(Object obj){
   	Block leftPaddle = (Block)obj;
   	if(super.didCollideLeft(obj)){
   		if(super.getXSpeed()<0){
				super.setXSpeed(super.getXSpeed()-.1);
			}else{
				super.setXSpeed(super.getXSpeed()+.1);
			}
   		return true;
   	}
   	return false;
   }  
   public boolean didCollideRight(Object obj){
   	Block rightPaddle = (Block)obj;
   	if(super.didCollideRight(obj)){
   		if(super.getXSpeed()<0){
				super.setXSpeed(super.getXSpeed()-.1);
			}else{
				super.setXSpeed(super.getXSpeed()+.1);
			}
   		return true;
   	}
   	return false;
   } 
   public boolean didCollideTop(Object obj){
   	Block thing = (Block)obj;
   	if(super.didCollideTop(obj)){
   		if(super.getXSpeed()<0){
				super.setXSpeed(super.getXSpeed()-.1);
			}else{
				super.setXSpeed(super.getXSpeed()+.1);
			}
   		return true;
   	}
   	return false;
   }
   public boolean didCollideBottom(Object obj){
   	Block thing = (Block)obj;
   	if(super.didCollideBottom(obj)){
   		if(super.getXSpeed()<0){
				super.setXSpeed(super.getXSpeed()-.1);
			}else{
				super.setXSpeed(super.getXSpeed()+.1);
			}
   		return true;
   	}
   	return false;
   }  
}

