package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class App extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int recX = 5;


    public int[] getWaterArray(int[] lndScap) {
        int maxSeenSoFar = 0;
        int[] maxSeenRight = new int[lndScap.length];
        int maxSeenLeft = 0;
        int[] waterArr = new int[lndScap.length];

        for (int i = lndScap.length - 1; i >= 0; i--) {
            if (lndScap[i] > maxSeenSoFar) {
                maxSeenSoFar = lndScap[i];
                maxSeenRight[i] = maxSeenSoFar;
            } else {
                maxSeenRight[i] = maxSeenSoFar;
            }
        }
        for (int i = 0; i < lndScap.length; i++) {
            if (lndScap[i] > maxSeenLeft) {
                maxSeenLeft = lndScap[i];
            }
            waterArr [i] = Integer.max(Integer.min(maxSeenLeft, maxSeenRight[i]) - lndScap[i], 0);
        }

        return waterArr;
    }

    public long calculateWaterAmount(int[] lndScap) {
        int maxSeenSoFar = 0;
        int[] maxSeenRight = new int[lndScap.length];
        int maxSeenLeft = 0;
        for (int i = lndScap.length - 1; i >= 0; i--) {
            if (lndScap[i] > maxSeenSoFar) {
                maxSeenSoFar = lndScap[i];
                maxSeenRight[i] = maxSeenSoFar;
            } else {
                maxSeenRight[i] = maxSeenSoFar;
            }
        }
        int waterAmount = 0;
        for (int i = 0; i < lndScap.length; i++) {
            waterAmount = waterAmount + Integer.max(Integer.min(maxSeenLeft, maxSeenRight[i]) - lndScap[i], 0);
            if (lndScap[i] > maxSeenLeft) {
                maxSeenLeft = lndScap[i];
            }
        }

        return waterAmount;
    }


    public void paint (Graphics g) {
        g.fillRect(1, 1, 600, 600);

        int[] landScape = new int[]{5, 2, 3, 4, 5, 4, 0, 3, 1};



        for (int aLandScape : landScape) {
            int calRecAm = aLandScape;
            calRecAm = calRecAm * 50;
            int numberOFRec = 500 - calRecAm;
            for (int i = 500; i >= numberOFRec; i -= 50) {

                if (aLandScape == 0) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(recX, i -= 5, 50, 50);
            }
            recX += 52;
        }


        int[] waterArr = getWaterArray(landScape);


        g.setColor(Color.red);
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.drawString("We have gathered "+ calculateWaterAmount(landScape) + " units of water " , 10, 50);



        int WreX = 5;
        
        for(int j = 0; j< waterArr.length; j++){

            int NumberOFlndScap = landScape[j];
            int yOFlndScap = NumberOFlndScap * 50;
            int StartYlAND = 500 - yOFlndScap;


            int YRecWater = waterArr[j] * 50;

            for (int i = 500 ; i >= StartYlAND ; i-=50) {



                if (waterArr[j] > 0) {

                    g.setColor(Color.cyan);
                    int counter = waterArr[j];
                    System.out.println(counter+"Counter");
                    int RectY = StartYlAND - 5;


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





    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(700, 700);
        frame.getContentPane().add(new App());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
