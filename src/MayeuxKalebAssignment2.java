import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class MayeuxKalebAssignment2 
{
	public static void main(String[] args) throws IOException
	{
		File fileName = new File("Actors.txt");
		Scanner inputFile = new Scanner (fileName);
		
		Actor[] actors = new Actor[10];
		
		inputFile.nextLine();
		while(inputFile.hasNextLine())
		{
			System.out.printf("Value read form file is: %s\n%s\n", inputFile.next(), inputFile.nextLine());
			actors[1] = inputFile.nextLine();
			
		}
		
		inputFile.close();
	}
	
}

class Actor
{
	
}

class Monster extends Actor
{

}

class Droid extends Actor
{
	
}

class Villain extends Actor
{
	
}

class Hero extends Actor
{
	
}