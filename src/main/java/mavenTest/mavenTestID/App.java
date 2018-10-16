package mavenTest.mavenTestID;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class App extends JPanel {

	public void paint (Graphics g) {
		g.fillRect(1, 1, 600, 600);

		/////////////////////////////  generating land array VARS
		int[] lndScap = new int[] { 8, 2, 3, 7, 5, 4, 0, 3 ,1 };
		int[] waterArr = new int[lndScap.length];
		int recX = 5;
		int numberOFRec;
		/////////////////////////////  generating water array VARS
        int maxSeenSoFar = 0;
        int[] maxSeenRight = new int[lndScap.length];
        int maxSeenLeft = 0;
        int rainwater = 0;

		
		for(int j=0; j< lndScap.length; j++){
			// calculate the amount of the rectangles to be drawn
			int calRecAm = lndScap[j];
			calRecAm = calRecAm * 50; 
			numberOFRec = 500 - calRecAm;
			// draw the landscape
	    for (int i = 500 ; i >= numberOFRec ; i-=50) {
	    	
	    	if (lndScap[j] == 0) {
	    		g.setColor(Color.BLACK);
	    	} else {
	    		g.setColor(Color.WHITE);
	    	}
	    	g.fillRect( recX, i-=5, 50, 50);
	    }
	    recX += 52;
		}
		
		

		// get the water array

			        for (int i = lndScap.length - 1; i >= 0; i--) {
			            if (lndScap[i] > maxSeenSoFar) {
			                maxSeenSoFar = lndScap[i];
			                maxSeenRight[i] = maxSeenSoFar;
			            } else {
			                maxSeenRight[i] = maxSeenSoFar;
			            }
			        }
			
			        for (int i = 0; i < lndScap.length; i++) {
			            rainwater = rainwater + Integer.max(Integer.min(maxSeenLeft, maxSeenRight[i]) - lndScap[i], 0);
			            if (lndScap[i] > maxSeenLeft) {
			                maxSeenLeft = lndScap[i];
			            }
			            waterArr [i] = Integer.max(Integer.min(maxSeenLeft, maxSeenRight[i]) - lndScap[i], 0);
			        }
			            g.setColor(Color.red);
			            g.setFont(new Font("TimesRoman", Font.BOLD, 20));
					    g.drawString("We have gathered "+ rainwater + " units of water " , 10, 50);
		
			       
			        
					int WreX = 5;
					
					for(int j=0; j< waterArr.length; j++){

						int NumberOFlndScap = lndScap[j];
						int yOFlndScap = NumberOFlndScap * 50;
						int StartYlAND = 500 - yOFlndScap; 
				    	System.out.println("from " +  StartYlAND  );
					
						
						int YRecWater = waterArr[j] * 50;
						
					    for (int i = 500 ; i >= StartYlAND ; i-=50) {
					    	System.out.println("from " +  StartYlAND +" To "+ YRecWater   );

						
						// draw the landscape
				    	
					    //	if (waterArr[j] == 0) {
					   // 		g.setColor(Color.WHITE);
						//    	g.fillRect( WreX, i-=5, 50, 50);

					   // 	} 
					    	if (waterArr[j] > 0) {					    				

					    		g.setColor(Color.cyan);
					    		int counter = waterArr[j];
			                	System.out.println(counter+"Counter");
				                int RectY = StartYlAND - 5;
// draw the water spots
				                while (counter > 0  ) {
				                	g.fillRect( WreX,RectY , 50, 50);
				                	RectY -= 55;
				                    counter--;

				                }

					    	}
					    }
					    WreX += 52;
						}
				     
					

				      

			        
	}
	
	
	




	private String ToString(int rainwater) {
		// TODO Auto-generated method stub
		return null;
	}







	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setSize(700, 700);
		frame.getContentPane().add(new App());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		


		
		
	}

}
