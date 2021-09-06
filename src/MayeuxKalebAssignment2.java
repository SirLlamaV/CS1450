import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class MayeuxKalebAssignment2 
{
	public static void main(String[] args) throws IOException
	{
		File fileName = new File("Actors.txt");
		Scanner inputFile = new Scanner (fileName);
		
		while(inputFile.hasNextLine())
		{
			System.out.println("Value read form file is: " + inputFile.nextLine());
		}
		
		inputFile.close();
	}
	
}

class Actor
{
	private String Hero;
	private String Villain;
	private String Monster;
	private String Droid;
}