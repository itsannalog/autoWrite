//package autoWrite;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Runner 
{
	static String TITLE = ""; 		// For naming file
    
	public static void main(String[] cheese) 	//main method, calls the other classes to combine all inputs to one file
    {
        final JFrame parent = new JFrame();
        parent.setLocation(850, 400);
        parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton button = new JButton();

        button.setText("Click me to begin!");
        parent.add(button);
        parent.pack();
        parent.setVisible(true);

        button.addActionListener(new java.awt.event.ActionListener() 
        {   
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
            	int captain = 1;
                int win = 1;
                String awardName = "NULL";
                String advanced = "NULL";
                String allyOne = "NULL"; 
                String allyTwo = "NULL";
                String oppOne = "NULL";
                String oppTwo = "NULL";
                String oppThree = "NULL";
            	
               String event = JOptionPane.showInputDialog(parent,
                        "What is the event name?", null);
            	
               String date = JOptionPane.showInputDialog(parent,
                       "When was the event?", null); 
               String location = JOptionPane.showInputDialog(parent,
                       "Where was the event?", null); 
               int award = JOptionPane.showConfirmDialog(
               	    parent,
               	    "Did the team win an award? (Include Winner, and Finalist) (Team awards only. Dean's, Woodie, etc does not count.)",
               	    "Awards?",
               	    JOptionPane.YES_NO_OPTION);					//Yes = 0      No = 1
               if (award ==0)
               {
                   awardName = JOptionPane.showInputDialog(parent,
                           "Which award (s)?", null); 
               }
               String seed = JOptionPane.showInputDialog(parent,
                       "Enter the team's final seed: ", null); 
               int elims;
               
               if (seed.equals("8") == false && seed.equals("7") == false && seed.equals("6") == false &&
            		   seed.equals("5") == false && seed.equals("4") == false && seed.equals("3") == false &&
            		   seed.equals("2") == false && seed.equals("1") == false) // if seeded lower than 8th
               {
            	   elims = JOptionPane.showConfirmDialog(
                	    parent,
                	    "Did the team participate in the elimination rounds?",
                	    "Elims?",
                	    JOptionPane.YES_NO_OPTION);					//Yes = 0      No = 1
               }
               else
            	   elims = 0;
               if (elims == 0)
               {
            	   captain = JOptionPane.showConfirmDialog(		//Yes = 0      No = 1
                    	    parent,
                    	    "Was the team an alliance captain?",
                    	    "Alliance Captain?",
                    	    JOptionPane.YES_NO_OPTION);
            	   allyOne = JOptionPane.showInputDialog(parent,
                           "Besides the team, Enter the first alliance member's team number: ", null); 
            	   allyTwo = JOptionPane.showInputDialog(parent,
                           "Enter the remaining alliance member's team number: ", null); 
            	   oppOne = JOptionPane.showInputDialog(parent,
                           "Enter the opposing alliance captain's team number: ", null); 
            	   oppTwo = JOptionPane.showInputDialog(parent,
                           "Enter another opposing alliance member's team number: ", null); 
            	   oppThree = JOptionPane.showInputDialog(parent,
                           "Enter the remaining opposing alliance member's team number: ", null); 
            	   
            	   
            	   win = JOptionPane.showConfirmDialog(		//Yes = 0      No = 1
                   	    parent,
                   	    "Did the team win the event?",
                   	    "Winner?",
                   	    JOptionPane.YES_NO_OPTION);
            	   if (win == 1)
            	   {
            		   Object[] possibilities = {"quarterfinals", "semifinals", "finals"};
            		   advanced = (String)JOptionPane.showInputDialog(
            		                       parent,
            		                       "The team made it to....",
            		                       "Advanced?",
            		                       JOptionPane.PLAIN_MESSAGE,
            		                       null,
            		                       possibilities,
            		                       "quarterfinals");
            	   }//end if win ==1
            	   
               }//end if elims == 0
               
               TITLE = event + "-" + date + "-" + location;
               String elimsPar = "";
               String awardPar = "";
               String intro = Writer.intro(event, date, location, award, awardName, win, elims);
               if (elims ==0)
               	   elimsPar = Writer.elims(allyOne, allyTwo, oppOne, oppTwo, oppThree, seed, captain, win, event, date, advanced);
               if (award == 0)
            	   awardPar = Writer.winAward(event, date, awardName);
               String wrap = Writer.wrap();
               
               FileWrite.file(TITLE, intro, elimsPar, awardPar, wrap);
               
               
               parent.dispose();
            }//end actionPerformed
        }); //end buttonListener
       
    }//end main
}//end class
