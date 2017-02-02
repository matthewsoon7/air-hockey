//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.awt.Color;

class BallTestOne
{
	public static void main( String args[] )
	{
		//x, y, wid, ht, color, xSpd, ySpd
		
		Ball one = new Ball(200,200,10,10,Color.BLACK,3,1);
		out.println(one);
		
		Ball two = new Ball(100,90,10,10,Color.BLACK,3,1);
		out.println(two);
		
		Ball three = new Ball(100,100,30,50,Color.BLACK,3,1);
		out.println(three);
		
		Ball four = new Ball(100,100,30,50,Color.BLUE,3,1);
		out.println(four);
		
		Ball five = new Ball(100,100,30,50,Color.BLUE,5,6);
		out.println(five);
		
									
		Ball six = new Ball(100,100,30,50,Color.blue,5,6);
		out.println(six);		
		
		out.println(five.equals(four));		
		
		out.println(five.equals(five));										
	}
}