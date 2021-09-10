import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class MayeuxKalebAssignment2 
{
	public static void main(String[] args) throws IOException
	{
		File fileName = new File("Actors.txt");
		Scanner inputFile = new Scanner (fileName);
		
		Actor actors[] = new Actor[10];
		Movie movieTest = new Movie();
		
		String name;
		String occupation;
		
		
		inputFile.nextLine();
		while(inputFile.hasNextLine())
		{
			for(int i = 0; i < actors.length; i++)
			{
				occupation = inputFile.next();
				name = inputFile.nextLine();
				name = name.replaceAll("\\s",  "");
				
				if (occupation.contains("Hero"))
				{
					actors[i] = new Hero(name);
				}
				else if (occupation.contains("Monster"))
				{
					actors[i] = new Monster(name);

				}
				else if (occupation.contains("Droid"))
				{
					actors[i] = new Droid(name);

				}
				else if (occupation.contains("Villain"))
				{
					actors[i] = new Villain(name);

				}
			}
		}
		
		System.out.printf("---------------------------------------------------------\n");
		System.out.printf("Actor Name\t\tType\t\tMotto To Live By\n");
		System.out.printf("---------------------------------------------------------\n");
		
		for(int i = 0; i <actors.length; i++)
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
	private Movie actorsInMovie[];
	private String name;
	private String occupation;
	int counter = 0;
	
	public void selectCast(Actor[] actors)
	{
		for (int i = 0; i < actors.length; i++)
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
		
		actorsInMovie = new Movie[numHeros + numVillains + counter];
		
		for (int i = 0; i < actorsInMovie.length; i++)
		{
			if (actors[i] instanceof Hero || actors[i] instanceof Villain)
			{
				occupation = actors[i].getOccupation();
				name = actors[i].getName();
				
				actorsInMovie[i].name = name;
				actorsInMovie[i].occupation = occupation;
			}
		}
		
		printMovieDetails();
		for (int i = 0; i < actorsInMovie.length; i++)
		{
			if (actors[i] instanceof Hero || actors[i] instanceof Villain)
			{
				System.out.printf("%-20s\t--- %s\n", actorsInMovie[i].name, actorsInMovie[i].occupation);
			}
		}
		
	}
	
	public void printMovieDetails()
	{
		System.out.println("\n--------------------------------");
		System.out.println("CS1450 Heroes and Villains Movie");
		System.out.println("--------------------------------");
		
		System.out.printf("Number of Heroes: %d\nNumber of Villains: %d", numHeros, numVillains);
	}
}