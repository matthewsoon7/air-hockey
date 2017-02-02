//Name -
//Date -
//Class -
//Lab  - 

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable {
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color color;
	private int xSpeed;
	private int ySpeed;
	private int speed;
	public Block()
	{
		

	}

	//add other Block constructors - x , y , width, height, color
	public Block(int i, int j, int k, int l, Color col) {
		xPos=i;
		yPos=j;
		width=k;
		height=l;
		color=col;
}
	

	
   public Block(int i, int j) {


	   
	}

	//add the other set methods//////////////////////////////////////
	public void setPos(int x, int y) {
		xPos=x;
		yPos=y;		
	}

	
	public void setX(int x) {
		xPos=x;		
	}

	
	public void setY(int y) {
		yPos=y;		
	}
	public void setHeight(int tall) {
		height=tall;		
	}
	public void setWidth(int y) {
		width=y;		
	}
	
	public void setColor(Color col)
   {

		color=col;
   }
	public void setYSpeed(int i) {
		ySpeed=i;
		
	}
		public void setXSpeed(int i) {
			xSpeed=i;
			
		}
//add the other get methods///////////////////////////////////////
    public int getWidth() {
		
		return width;
	}   
public int getHeight() {
		
		return height;
	}   
	@Override
	public int getX() {
		
		return xPos;
	}

	@Override
	public int getY() {
		
		return yPos;
	}   
public Color getColor(){
	  return color;
  }
public int getYSpeed() {
		return ySpeed;
	}
	public int getXSpeed() {
		return xSpeed;
	}
	//////////////////////////////////////////////////////
	public boolean equals(Object obj)
	{
		Block other = (Block)obj;
	      if( (getHeight()==other.getHeight())
	    		  && (getX()==other.getX()) 
	    		  && (getY()==other.getY()) 
	    		  && (getWidth()==other.getWidth()) 
	    		  && (getColor()==other.getColor()))
	         return true;
	      
	      return false;
	}
	
	
	
	
	
   public void draw(Graphics window)
   {
   	//uncomment after you write the set and get methods
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {


   }
   
	
   public void setSpeed(int i) {
 		speed=i;
 		
 	}
    public int getSpeed() {
 		
 		return speed;
 	}   
	
   
	
   //add a toString() method  - x , y , width, height, color
	
	public String toString(){
		
		return  xPos +" "+yPos+" "+width+" "+height+" "+color;
	}

	
	
}