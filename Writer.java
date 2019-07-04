//package autoWrite;


//Currently, if the team won no awards and did not advance to eliminations, only the intro and wrap paragraphs are produced. 
//Version 3.0 is planned to include a "what we learned" paragraph in this situation.


public class Writer 
{
	private static final String FULL_TEAM = "The T.E.S.T. Team 303"; 		//full team name
	private static final String HALF_TEAM = "The T.E.S.T. Team";			//shorted team name	
	private static final String TEAM = "Team 303";							//shortest team name
	private static final String GAME = "FIRST Stronghold";					//name of this year's game
	private static final String WIN = "cross various defenses and shoot small gray balls, called boulders, into a tower. "
			+ "For bonus points, robots can suspend themselves from the tower, or traverse 4 of the 5 defenses, two times each";		//copied from game manual, the "win condition"
	private static final String SPONSORS = "Johnson & Johnson Healthcare Systems, Inc. / STS Tire & Auto Centers "
			+ "/ DOD Stem & Picatinny / " + "J&E Metal Fabricators / Huawei / Rotor Clip / 303 RAMP / ASCO / Yokogawa Electric";		//current top-tier sponsors
	private static final String CONTACT = "Advisor, firstteam303@brrsd.k12.nj.us / Asst. Advisor, asstfirstteam303@brrsd.k12.nj.us";	//team contact info
	
	public static String intro(String event, String date, String location, int award, String awardName, int win, int elims)
	{				
		String end = "";			//stores the entire paragraph in one string to pass back to runner
		
		int random = (int) (Math.random() * 2);		//picks a phrase. Change the *2 to a bigger number if you add more phrases
		if (random ==0)
			end +=(FULL_TEAM + " competed on " + date +  " in " + location +" at the " + event);		//Pay attention to spaces, add them to the connecting phrases
		if (random ==1)
			end +=("On " + date + ", " + FULL_TEAM + " competed at " + event + " in " + location);		//There's no ending punctuation here because this phrase is combined with the next phrase (below)
		//another phrase would look like..
		//if (random==2)
		//end+= (FULL_TEAM + " visited " + location + " to compete at " + event + " on " + date);
		
		if (award ==0 || win == 0)  //if the team won the event OR won an award (or both)
		{
			int rand = (int) (Math.random() *4);  			//again, *4 for 4 phrases, numbered starting at 0
			
			if (rand == 0)
				end +=(" and won " + awardName + ". ");
			if (rand == 1)
				end +=(" and took home the " + awardName + " award. ");
			if (rand == 2)
				end +=(". After a long competition, " + TEAM  + " received the " + awardName + " award for their efforts. ");
			if (rand == 3)
				end +=(" and emerged as victors. Taking home the " + awardName + " award, the team competed well. ");
		}
		else		//if the team won no awards, or did not win the event
		{
			int rand = (int) (Math.random() * 2);
			
			if (rand == 0)
				end +=(". Despite not bringing home awards, ");
			if (rand == 1)
				end +=(". No matter the final outcome, ");
			
			end +=(" the team competed well. "); 			//this could have its own random picker to add diversity
		}
		
		//this section writes about the game, and summarizes the paragraph
		random = (int) (Math.random()*3);
		if (random == 0)		
			end +=("This year's challenge is called " + GAME + ". To score points and win, a team must " + WIN + ". ");
		if (random == 1)
			end +=(GAME + " is the name of this year's challenge. To score points, teams " + WIN + ". ");
		if (random == 2)
			end +=("The 2016 game is called "+ GAME + ". To earn points and win, teams " + WIN + ". ");
	
		if (elims == 0)
			end +=("After advancing to the elimination rounds, the team had a very successful weekend. ");
		else
			end +=("Despite performing to the best of their ability, " + TEAM + " did not advance "
					+ "into the elimination rounds. ");
		if (win == 0)
			end +=(TEAM + " won the event after their hard work and dedication. ");
		
		return end;
		
	}


	public static String elims(String allyOne, String allyTwo, String oppOne, String oppTwo, String oppThree, 
				String seed, int capt, int win, String event, String date, String adv)						//this writes a whole paragraph about what happened in elims, if applicable
	{
		String end = "";
		if (capt == 0)			//if the team was alliance captian
		{
			int rand = (int) (Math.random()*2);
			if (rand == 0)
				end += ("\n\nAs alliance captains, "+ TEAM+ " chose team " + allyOne + " and team " + allyTwo + " to compete "
						+ "with for the elimination matches. ");
			if (rand == 1)
				if (seed.equals("1"))
					end += ("\n\nAfter finishing in " + seed + "st seed, " + HALF_TEAM + " became captains, and "
						+ "formed their alliance with team " + allyOne + " and team " + allyTwo + ". ");
				else if (seed.equals("2"))
					end += ("\n\nAfter finishing in " + seed + "nd seed, " + HALF_TEAM + " became captains, and "
						+ "formed their alliance with team " + allyOne + " and team " + allyTwo + ". ");
				else if (seed.equals("3"))
					end += ("\n\nAfter finishing in " + seed + "rd seed, " + HALF_TEAM + " became captains, and "
							+ "formed their alliance with team " + allyOne + " and team " + allyTwo + ". ");
				else
					end += ("\n\nAfter finishing in " + seed + "th seed, " + HALF_TEAM + " became captains, and "
								+ "formed their alliance with team " + allyOne + " and team " + allyTwo + ". ");
		}
		else		//if the team was not alliance captain, but still made it to elims
		{
			int rand = (int) (Math.random() * 2);
			if (rand == 0)
				end += ("\n\nAfter being picked by team " + allyOne + ", " + TEAM + " joined them and team " + allyTwo
						+ " in the elimination rounds. ");
			if (rand == 1)
				end += ("\n\nIn the elimination rounds,  "+ TEAM + " competed with team " + allyOne + " and team " + allyTwo + ". ");
		}
		
		if (win == 0)			//if the team won the event
		{
			int rand = (int) (Math.random() *2);
			
			if (rand == 0)
				end += ("The team competed hard and performed well, and after their final face-off with team " + oppOne 
					+ ", team " + oppTwo + ", and team " + oppThree +", " + TEAM + " emerged victorious. ");
			if (rand == 1)
				end += ("After their final match against team " + oppOne 
						+ ", team " + oppTwo + ", and team " + oppThree +", " + TEAM + " came out on top, winning the competition. ");
		}
		else				//if the team did not win the event
		{
			end += ("The team didn't win the event, but still advanced to " + adv + ". ");
			
			int rand = (int) (Math.random()*2);
			if (rand == 0)
				end += ("After facing off against team " + oppOne + ", team " + oppTwo + ", and team " + oppThree 
						+ ", the team could not fight any longer. ");
			if (rand == 1)
				end += ("Their opponents, team " + oppOne + ", team " + oppTwo + ", and team " + oppThree 
						+ ", put up a fight that " + TEAM + "could not win. ");
		
			end += ("Despite their losses, the team still competed well. ");
		}
		
		return end;
	}
	
	public static String winAward(String event, String date, String award) 			//writes a paragraph about the award(s) won, if applicable
	{
		String end = "";
		String awardDesc = "";
		
		//If a new type of award is added, it should foloow this format:
		
		//if (award.toUpperCase().indexOf("AWARD_NAME") >= 0) 	//award_name
		//{
			//awardDesc += "AWARD_DESCRIPTION" (found in manual); 
		//}
		
		if (award.toUpperCase().indexOf("CHAIR") >= 0) 	//Chairman's Award
		{
			awardDesc += "The most prestigious award at FIRST, the Chairman's Award honors the team that "
					+ "best represents a model for other teams to emulate and best embodies "
					+ "the purpose and goals of FIRST. ";
			award = "Chairman's";			//this is included on some award entries to catch spelling errors and correct them
		}
		if (award.toUpperCase().indexOf("CREATIVITY") >= 0) 		//Creativity Award
			awardDesc += "Sponsored by Xerox, this award celebrates creativity in design, use of component, or strategy of play. ";
		if (award.toUpperCase().indexOf("INSPIRATION") >= 0) 		//Engineering Inspiration
			awardDesc += "The Engineering Inspiration Award celebrates outstanding success in advancing respect and "
					+ "appreciation for engineering within a team’s school and community. ";
		if (award.toUpperCase().indexOf("ENTRE") >= 0) 				// Entrepreneurship Award
		{
			awardDesc += "Sponsored by Kleiner Perkins Caufield & Byers, The Entrepreneurship Award "
					+ "celebrates the entrepreneurial spirit by "
					+ "recognizing a team that has developed the framework "
					+ "for a comprehensive business plan to scope, manage, and achieve team objectives. ";
			award = "Entrepreneurship";
		}
		if (award.toUpperCase().indexOf("EX") >= 0) 				//Engineering Excellence
		{	
			awardDesc += "Sponsored by Delphi, this award celebrates an elegant and advantageous machine feature. ";
			award = "Engineering Excellence";
		}
		if (award.toUpperCase().indexOf("FINALIST") >= 0)			//Finalist
			awardDesc += "The Finalist Award celebrates the Alliance that makes it to the final match of the competition. ";
		if (award.toUpperCase().indexOf("IMAGERY") >= 0)			//Imagery Award
			awardDesc += "The Imagery Award is presented in honor of Jack Kamen, Dean’s father, for his dedication to "
					+ "art and illustration and his devotion to FIRST. The Imagery Award celebrates attractiveness in engineering and outstanding "
					+ "visual aesthetic integration of machine and team appearance. ";
		if (award.toUpperCase().indexOf("GRA") >= 0) 				//Gracious Professionalism
			awardDesc += "Sponsored by Johnson & Johnson, The Gracious Professionalism Award celebrates outstanding demonstration of FIRST Core Values such as continuous "
					+ "Gracious Professionalism working together both on and off the playing field.";
		if (award.toUpperCase().indexOf("DESIGN") >= 0) 			//Industrial Design
			awardDesc += "Sponsored by General Motors, The Industrial Design Award celebrates form and function in an efficiently "
					+ "designed machine that effectively addresses the game challenge. ";
		if (award.toUpperCase().indexOf("SAFETY") >= 0) 			//Industrial Safety
			awardDesc += "Sponsored by Underwriters Laboratories, The Industrial Safety Award celebrates the team that progresses beyond safety fundamentals by using "
					+ "innovative ways to eliminate or protect against hazards. ";
		if (award.toUpperCase().indexOf("CONTROL") >= 0) 			//Innovation in Control	
			awardDesc += "Sponsored by Rockwell Automation, The Innovation in Control Award celebrates an innovative control system or application"
					+ " of control components– electrical, mechanical, or software – to provide unique machine functions. ";
		if (award.toUpperCase().indexOf("JUDGE") >= 0) 				//Judge's Award
		{	
			awardDesc += "During the course of the competition, the judging panel may decide a team’s unique "
					+ "efforts, performance, or dynamics merit recognition. Thus, the team is awarded the Judge's Award. ";
		}
		if (award.toUpperCase().indexOf("MEDIA") >= 0) 				//Media & Technology Innovation
		{	
			awardDesc += "Sponsored by Comcast NBCUniversal, The Media & Technology Innovation "
					+ "Award recognizes the team that develops "
					+ "and implements the most outstanding digital experience, marketing strategy, "
					+ "and rationale for digital channels to disseminate content "
					+ "to its audience and further the FIRST mission. ";
			award = "Media & Technology Innovation";
		}
		if (award.toUpperCase().indexOf("QUALITY") >= 0) 		//Quality Award
			awardDesc += "Sponsored by Motorola Solutions Foundation, The Quality Award celebrates machine robustness in concept and fabrication. ";
		if (award.toUpperCase().indexOf("SAFETY ANIMATION") >= 0) 		//Safety Animation
			awardDesc += "Sponsored by UL, The Safety Animation Award recognizes the team that submits a short animated film that best promotes the "
					+ "current season’s team safety focus. ";
		if (award.toUpperCase().indexOf("SPIRIT") >= 0) 		//Team Spirit
			awardDesc += "Sponsored by Chrysler, The Team Spirit Award celebrates extraordinary enthusiasm and spirit through exceptional partnership "
					+ "and teamwork furthering the objectives of FIRST. ";
		if (award.toUpperCase().indexOf("WINNER") >= 0) 		//Winner	
			awardDesc += "The Winner Award celebrates the Alliance that wins the competition. ";
		
		
		int randy = (int) (Math.random()*3);
		if (randy ==0)
			end += ("\n\n" + FULL_TEAM + " won the " + award + " award. " + awardDesc);
		if (randy ==1)
			end += ("\n\n" + FULL_TEAM + " was honored to receive the " + award + " award. " + awardDesc);
		if (randy == 2)
			end += ("\n\n" + FULL_TEAM + " took home the " + award + " award. " + awardDesc);
		
		
		
		return end;
	}
	
	public static String wrap()
	{
		String end = "";
		
		end +=("\nThis article was generated using *autoWrite version 2.0*, a blog post generator programmed by Anna Brown (c/o 2017) with help from Bradley Boxer (c/o 2018). ");
		end += ("\n"+ FULL_TEAM + " would like to thank: \n" + SPONSORS);
		end += ("\nFor more information, contact: " + CONTACT);
		
		return end;
	}
	
}
