//package autoWrite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite
{
	public static void file(String title, String intro, String elims, String awards, String wrap) 
	{
		try {
				File directory = new File("C:\\autoWrite_Docs\\" );
				if (!directory.exists())
					directory.mkdir();
				
				String path = "C:\\autoWrite_Docs\\" + title + ".txt";				
				BufferedWriter out = new BufferedWriter(new FileWriter(path));
	
				out.write("Thank you for using AutoWrite! Please note: Make sure to proofread the output file for proper flow and grammar.");
				out.newLine();
				out.write("Below is your generated blog post. ---------------------------------");
				out.newLine();
				out.newLine();
				out.write(intro);
				out.newLine();
				out.write(elims);
				out.newLine();
				out.write(awards);
				out.newLine();
				out.write(wrap);
				out.close();
			}
		catch(IOException e) {e.printStackTrace();}
	}
}