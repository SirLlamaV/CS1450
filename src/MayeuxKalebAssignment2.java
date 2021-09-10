import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class MayeuxKalebAssignment2 
{
	public static void main(String[] args) throws IOException
	{
		// Initialize File, Scanner, Array of Objects, and Movie class array
		File fileName = new File("Actors.txt");
		Scanner inputFile = new Scanner (fileName);
		
		Actor actors[] = new Actor[10];
		Movie movieTest = new Movie();
		
		String name;
		String occupation;
		
		// Skip past the initial 10 in the file
		inputFile.nextLine();
		while(inputFile.hasNextLine())
		{
			for(int i = 0; i < actors.length; i++)
			{
				//Sets occupation (type) to where it appears in the documents and does the same afterwards for name
				occupation = inputFile.next();
				name = inputFile.nextLine();
				name = name.replaceAll("\\s",  ""); //Takes out the whitespace prior to names
				
				if (occupation.contains("Hero")) //If the occupation contains the Hero phrase, create a new hero object with the name given
				{
					actors[i] = new Hero(name);
				}
				else if (occupation.contains("Monster")) // Repeat above for Monster
				{
					actors[i] = new Monster(name);

				}
				else if (occupation.contains("Droid"))// Repeat above for Droid
				{
					actors[i] = new Droid(name);

				}
				else if (occupation.contains("Villain"))// Repeat above for Villain
				{
					actors[i] = new Villain(name);

				}
			}
		}
		
		//Formatting for final table
		
		System.out.printf("---------------------------------------------------------\n");
		System.out.printf("Actor Name\t\tType\t\tMotto To Live By\n");
		System.out.printf("---------------------------------------------------------\n");
		
		for(int i = 0; i <actors.length; i++) //Print array actors
		{
			System.out.printf("%-20s\t%s\t\t%s\t\t\n", actors[i].getName(), actors[i].getOccupation(), actors[i].motto());
		}

		movieTest.selectCast(actors);
		
		inputFile.close();
	}
	
}

class Actor
{
	private String name;
	private String occupation;
	
    public Actor(String name, String occupation)
    {
    	this.name = name;
    	this.occupation = occupation;
    }
    
	public String motto()
    {
    	return "I'll get you!";
    }
    
    public String getName()
    {
    	return name;
    }
    
    public String getOccupation()
    {
    	return occupation;
    }
}

class Monster extends Actor
{

	public Monster(String name) 
	{
		super(name, "Monster");
	}
	
	@Override
	public String motto()
	{
		return "RRAAAUUGGHH GRROWR!!!";
	}
	
}

class Droid extends Actor
{

	public Droid(String name) 
	{
		super(name, "Droid");
	}
	
	@Override
	public String motto()
	{
		return "Beep Beep Bloop Boop Beep!";
	}
	
}

class Villain extends Actor
{

	public Villain(String name) 
	{
		super(name, "Villain");
	}
	
	@Override
	public String motto()
	{
		return "You’ll never stop me!  Haaaaaaa!";
	}
	
}

class Hero extends Actor
{
	public Hero(String name) 
	{
	    super(name, "Hero");
	}
	
	@Override
	public String motto()
	{
		return "To the rescue!  KAPOW!! BAM!! POW!!";
	}
}

class Movie
{
	private int numHeros;
	private int numVillains;
	private Movie[] actorsInMovie;

	private String name;
	private String occupation;
	
	public void selectCast(Actor[] actors)
	{
		for (int i = 0; i < actors.length; i++) //Run through actors and add to a counter for heros and villains
		{
			if (actors[i] instanceof Hero)
			{
				numHeros++;
			}
			else if (actors[i] instanceof Villain)
			{
				numVillains++;
			}
		}
		actorsInMovie = new Movie[actors.length];
		
		for (int i = 0; i < actorsInMovie.length; i++) //Run through actorsInMovie only activating code if actors[i] is in an instanceof Hero or Villain
		{
			if (actors[i] instanceof Hero || actors[i] instanceof Villain)
			{
				actorsInMovie[i] = new Movie(); //This initializes the array of objects
				actorsInMovie[i].name = actors[i].getName();
				actorsInMovie[i].occupation = actors[i].getOccupation();
			}
		}
		
		printMovieDetails(); //Calls the print Movie Details method before filling the rest in after
		for (int i = 0; i < actorsInMovie.length; i++) //Prints the actors name and whether they played a hero or villain
		{
			if (actors[i] instanceof Hero || actors[i] instanceof Villain)
			{
				System.out.printf("\n%-10s\t--- %s", actorsInMovie[i].name, actorsInMovie[i].occupation);
			}
		}
		
	}
	
	public void printMovieDetails()
	{
		System.out.println("\n--------------------------------");
		System.out.println("CS1450 Heroes and Villains Movie");
		System.out.println("--------------------------------");
		
		System.out.printf("Number of Heroes: %d\nNumber of Villains: %d\n", numHeros, numVillains);
	}
}