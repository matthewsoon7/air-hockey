//Name -
//Date -
//Class -
//Lab  - 

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color color;
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}

	//add the other Ball constructors
	
	public Ball(int i, int j, int k, int l, Color col,int speedx,int speedy) {
		xPos=i;
		yPos=j;
		width=k;
		height=l;
		color=col;
		xSpeed=speedx;
		ySpeed=speedy;
}
	
	
	
	   
   //add the set methods
   
	public void setYSpeed(int i) {
	ySpeed=i;
	
}
	public void setXSpeed(int i) {
		xSpeed=i;
		
	}
	

   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
	   window.setColor(Color.WHITE);
	      window.fillRect(getX(), getY(), getWidth(), getHeight());

      setX(getX()+xSpeed);
		//setY
      setY(getY()+ySpeed);
		//draw the ball at its new location
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }
   
	

	
///////////////////////////////////// below is completed
   //add the get methods
	public int getYSpeed() {
		
		return ySpeed;
	}   
	
public int getXSpeed() {
		
		return xSpeed;
	}  
public boolean equals(Object obj)
	{
		Block other = (Block)obj;
	      if( (getHeight()==other.getHeight())
	    		  && (getX()==other.getX()) 
	    		  && (getY()==other.getY()) 
	    		  && (getWidth()==other.getWidth()) 
	    		  && (getColor()==other.getColor())
	    		  && (getXSpeed()==other.getXSpeed())
	    		  && (getYSpeed()==other.getYSpeed())
	    		  )
	         return true;
	      
	      return false;

	}
public String toString(){
	
	return  xPos + " " + yPos + " " + width + " " + height + " " + color + " " + xSpeed + " " + ySpeed;
}


}