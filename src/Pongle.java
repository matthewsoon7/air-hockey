
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.applet.AudioClip;
import java.applet.*;
import java.awt.*;
import java.net.*;
import java.util.*;

public class Pongle extends Applet 
	implements Runnable, MouseListener, MouseMotionListener {

        Thread runner;
        int ballX, ballY, paddle1,paddle2;        // coordinates
		int paddleMin, paddleMax;
		int ballposX1, ballposX, ballposY1, ballposY2, ballIncr;
		boolean upwards,toLeft, started, gameover;
		int topscore = 10; 				// game limit
		int startPlayer;
		int scoreP, scoreC;
		String whowon;
		Color yellow;
		int Difficulty =30;
		
  
        public void init(){  
			Graphics bg = getGraphics();
			
			addMouseMotionListener(this);
			addMouseListener(this);
		ballIncr = 4;				
		ballposX1 = 10 + ballIncr;	
			ballposX = 300 - ballIncr;	
			ballposY1 = 10 + ballIncr;	
			ballposY2 = 200 - ballIncr;	
			
		 paddleMin = 10;			
		 paddleMax = 180;				
		 paddle1 = paddle2 = 20;
			
			startPlayer = 1;
				
			started = false;
			gameover = false;

			yellow = new Color(0,113,0);
			setBackground(yellow);
			
			
		

			this.requestFocus();
        }
		
		protected void newGame() {				
		started = true;
	gameover = false;
			scoreP = 0; 
	scoreC = 0;
			
			if (startPlayer==0) {
				ballX = 300;
				ballY = paddle1;
				toLeft = true; 
				startPlayer = 1;				
			}
			else {
				ballX = 20;
				ballY = (int)(Math.random()*200)+10;
				toLeft = false; 
				startPlayer = 0;
			}			
			
			paddle1 = ballY;
			if (ballY > 160){
				upwards = true;
			}
			else {
				upwards = false;
			}
			paddle2 = ballY;
			showStatus(new Integer(ballY).toString());			
		}
		public void start(){
            runner = new Thread(this);
            runner.start();
        }
		protected void endGame() {		// win or lose strings
			if (scoreC>scoreP) {
				whowon = "      You lost";
			}
			else {
				whowon = "You Won";
			}
			
			//endSound.play();
			started = false;
			gameover = true;
		}
        public void stop() {
            runner.stop();
        }

        public void run() {

            while(true) {
					
					if (ballX<160){
						if (upwards){
							if ( ballY >  paddleMin) paddle2 = ballY + 5;
							else paddle2 =  paddleMin;
						}
						else {
							if ( ballY < paddleMax) paddle2 = ballY - 5;
							else paddle2 = paddleMax;
						}
					}
					
					if(ballX > 289 && ballX < 294 ) {
						if( ((ballY + 5) > paddle1) && ((paddle1 + 31) > ballY) ) {
							toLeft = true;
							showStatus("Player hits");
							
						}
					}					
					if( ballX > 16 && ballX < 21 ) {
						if( ((ballY + 5) > paddle2) && ((paddle2 + 31) > ballY) ) {
							toLeft = false;
							showStatus("Computer hits");							
							
						}
					}
					
					if (scoreC==topscore || scoreP==topscore)endGame();
					
					if (started){
						ballX = getXPos(ballX);
						ballY = getYPos(ballY);
					}
					
                    repaint();	

                    try {
                            Thread.sleep(Difficulty); 
                    }
                    catch (InterruptedException e)
                    {
                    }
            }
        }
		public void update(Graphics g) 
		{
			Graphics offgraph;
			Image offscreen = null;
			Dimension d = getSize();
			offscreen = createImage(d.width, d.height);
			offgraph = offscreen.getGraphics();
			offgraph.setColor(getBackground());
			offgraph.fillRect(0, 0, d.width, d.height);
			offgraph.setColor(getForeground());
			paint(offgraph);
			g.drawImage(offscreen, 0, 0, this);
			offscreen.flush();
		} 
        public void paint(Graphics g) {				
			
			drawBG(g);		
			if(started){
				g.setColor(Color.yellow);
				g.fillOval(ballX,ballY,10,10); 
				g.setColor(Color.red);
				g.fillRect(300,paddle1,5,30); 
				g.setColor(Color.blue);
				g.fillRect(15,paddle2,5,30); 
			}
			// restart strings
			g.setColor(Color.red);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			if(!started) g.drawString(" Click to Start ",70,140);
			g.setColor(Color.blue);
			if(gameover) g.drawString("Game Over",110,80);
			g.drawString("Computer",40,240);
			g.setColor(Color.red);
			g.drawString("You",200,240);
			g.setColor(Color.yellow);
			if(gameover) g.drawString(whowon,50,110);
			g.drawString(new Integer(scoreC).toString(),80,270);
			g.drawString(new Integer(scoreP).toString(),220,270);
		}
		
		protected void drawBG(Graphics bg){			
			bg.setColor(Color.white);
			bg.drawRect(9,9,301,201);
			bg.drawLine(160,10,160,210);
			bg.drawOval(110,60,100,100);
			
			bg.fillRect(0,220,320,60);
			bg.setColor(Color.white);
			bg.setColor(Color.black);
			bg.fillRoundRect(0,220,320,60,20,20);
		}
		protected int getXPos(int x) {
			if(x > ballposX) {				
				if(started && !toLeft) {
					scoreC += 1;
					showStatus("miss");
					 
				}
				toLeft = true;
				return ballposX;
			}
			
			if(x < ballposX1 ) {				
				if(started && toLeft){
					scoreP += 1;		
					showStatus("miss"); 
				}
				toLeft = false;
				return ballposX1;
			}
			if(toLeft) return ballX - ballIncr;
			else return ballX + ballIncr;
		}
		protected int getYPos(int y) {
			if( y > ballposY2) {
				upwards = true;
				return ballposY2;
			}
			if(y < ballposY1) {
				upwards = false;
				return ballposY1;
			}
			if(upwards) return ballY - ballIncr;
			else return ballY + ballIncr;
		}
		 
	public void mouseDragged(MouseEvent e) {
		
	}
	public void mouseMoved(MouseEvent e) {
		int y = e.getY();
		if ( (y - paddle1) > 0 ) MoveDown(y);
		else MoveUp(y);
	}
	
	public void mouseEntered(MouseEvent event) {
    }
    public void mouseExited(MouseEvent event) {
    }
    public void mousePressed(MouseEvent event) {
    }
    public void mouseReleased(MouseEvent event) {
    }
    public void mouseClicked(MouseEvent e) {
		if(!started && e.getY() < 160 && e.getY() > 120) {		
			newGame();
		}
		else {			
		}
	}
    protected void MoveDown(int y){			
		if ( y < paddleMax) paddle1 = y;
		else paddle1 = paddleMax;
	}
	protected void MoveUp(int y){		
		if ( y >  paddleMin) paddle1 = y;
		else paddle1 =  paddleMin;
	}	
	
}