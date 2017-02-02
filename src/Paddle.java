//Name -
//Date -
//Class -
//Lab  - 

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;
   private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color color;
   public Paddle()
   {
		super(10,10);
      speed =5;
   }


   //add the other Paddle constructors
   public Paddle(int i, int j, int k, int l, Color col,int speedx) {
		xPos=i;
		yPos=j;
		width=k;
		height=l;
		color=col;
		speed=speedx;
	
}
//add get methods
   public void setSpeed(int i) {
		speed=i;
		
	}
   public int getSpeed() {
		
		return speed;
	}   
   public boolean equals(Object obj)
	{
		Block other = (Block)obj;
	      if( (getHeight()==other.getHeight())
	    		  && (getX()==other.getX()) 
	    		  && (getY()==other.getY()) 
	    		  && (getWidth()==other.getWidth()) 
	    		  && (getColor()==other.getColor())
	    		  && (getSpeed()==other.getSpeed())
	    		  )
	         return true;
	      
	      return false;

	}







   public void moveUpAndDraw(Graphics window)
   {


   }

   public void moveDownAndDraw(Graphics window)
   {


   }

   
   
   
   //add a toString() method
   public String toString(){
		
		return  xPos + " " + yPos + " " + width + " " + height + " " + color + " " + speed ;
	}
}