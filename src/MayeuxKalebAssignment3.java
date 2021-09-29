/*
 * Kaleb Mayeux
 * CS1450 Section 002
 * Assignment 3
 * Due 9-16-21
 * 
 * For this assignment I am tasked with: reading data form a file,and parsing that data into an arraylist as an object. 
 * Then, I am to display the ArrayList, and find out / apply various tags upon the data (whether the birds are swimmers, name, type, and speed.
 * Finally, I am to create a swimming race and find / display the one that would win.
 */
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class MayeuxKalebAssignment3 
{
	
	public static void main(String[] args) throws IOException
	{
		//Initialize Scanner and File being used
		File fileName = new File("Birds.txt");
		Scanner inputFile = new Scanner (fileName);
		
		//Declare variables that will be in use for main
		String name;
		String type;
		int runSpeed;
		int swimSpeed;
		int flyAltitude;
		int fileSize;
		fileSize = inputFile.nextInt();
		
		ArrayList<Bird> birds = new ArrayList<>(fileSize);
		
		//Parse through file given and add the given value into the ArrayList of objects
		for (int i = 0; i < fileSize; i++)
		{
			type = inputFile.next();
			name = inputFile.next();
			runSpeed = inputFile.nextInt();
			swimSpeed = inputFile.nextInt();
			flyAltitude = inputFile.nextInt();
			
			if (type.contains("penguin"))
			{
				birds.add(i, new Penguin(name, runSpeed, swimSpeed));
			}
			else if (type.contains("ostrich"))
			{
				birds.add(i, new Ostrich(name, runSpeed, swimSpeed));
			}
			else if (type.contains("loon"))
			{
				birds.add(i, new Loon(name, flyAltitude, swimSpeed));
			}
			else if (type.contains("sootytern"))
			{
				birds.add(i, new SootyTern(name, flyAltitude, runSpeed));
			}
		}
		
		displayBirds(birds);
		
		//Run swimming race with the value of method find swimmer
		Bird winningBird = swimmingRace(findSwimmer(birds));
		
		//Print the winner of the swimming race
		System.out.printf("The winner is %s the %s swimming at %dmph!", winningBird.getName(), winningBird.getType(), ((swimmer) winningBird).swim());

		inputFile.close();
	}
	
	// Displays all of the given birds in the file
	public static void displayBirds(ArrayList<Bird> birds)
	{
		System.out.println("Birds and Abilities\n--------------------------------------------");
		
		for (int i = 0; i < birds.size(); i++)
		{

			// If a bird is not in the instance of something, set its corresponding value to 0
			if (!(birds.get(i) instanceof swimmer))
			{
				System.out.printf("%s is a %s\n%s\n", birds.get(i).getName(), birds.get(i).getType(), birds.get(i).strangeFact());
				System.out.printf("Swim Speed: %d\tRun Speed: %d\tFlyingAltitude: %d\n\n", 0, ((runner) birds.get(i)).run(), ((flyer) birds.get(i)).fly());
			}
			else if (!(birds.get(i) instanceof flyer))
			{
				System.out.printf("%s is a %s\n%s\n", birds.get(i).getName(), birds.get(i).getType(), birds.get(i).strangeFact());
				System.out.printf("Swim Speed: %d\tRun Speed: %d\tFlyingAltitude: %d\n\n", ((swimmer) birds.get(i)).swim(), ((runner) birds.get(i)).run(), 0);
			}
			else if (!(birds.get(i) instanceof runner))
			{
				System.out.printf("%s is a %s\n%s\n", birds.get(i).getName(), birds.get(i).getType(), birds.get(i).strangeFact());
				System.out.printf("Swim Speed: %d\tRun Speed: %d\tFlyingAltitude: %d\n\n", ((swimmer) birds.get(i)).swim(), 0, ((flyer) birds.get(i)).fly());
			}
		}
		
	}
	
	//Find all birds that are swimmers from file
	public static ArrayList<Bird>findSwimmer(ArrayList<Bird> birds)
	{
		ArrayList<Bird> swimmingBirds = new ArrayList<>();
		
		System.out.println("----------------------------\nBIRDS THAT CAN SWIM\n----------------------------");
		System.out.println("Bird\tType\tSwimming Speed");
		
		for (int i = 0; i < birds.size(); i++)
		{
			if (birds.get(i) instanceof swimmer)
			{
				System.out.printf("%s\t%s\t\t%d\n", birds.get(i).getName(), birds.get(i).getType(), ((swimmer) birds.get(i)).swim());
				swimmingBirds.add(birds.get(i));
			}
		}
		return swimmingBirds;
	}
	
	//Pit all swimming birds against each other and declare the fastest the winner
	public static Bird swimmingRace (ArrayList<Bird> swimmingBirds)
	{
		int winningBird = 0;
		
		System.out.println("------------------------\nSWIMMING RACE\n------------------------");
		System.out.println("Swimming birds get ready ... get set ... go!");
		
		for (int i = 0;  i < swimmingBirds.size(); i++)
		{
			for (int j = 0; j < swimmingBirds.size(); j++)
			{
				if ((((swimmer) swimmingBirds.get(j)).swim() > ((swimmer) swimmingBirds.get(i)).swim()))
				{
					//This final if statement checks to ensure that j is larger than the already winning value before assigning it
					if (((swimmer) swimmingBirds.get(j)).swim() > ((swimmer) swimmingBirds.get(winningBird)).swim())
					{
						winningBird = j;
					}
				}
			}
		}
		
		
		return swimmingBirds.get(winningBird);
	}

}

interface swimmer
{
	int swim();
}

interface runner
{
	int run();
}

interface flyer
{
	int fly();
}

abstract class Bird
{
	private String type;
	private String name;
	
	public String getName()
	{
		return name;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	abstract String strangeFact();
}

class Penguin extends Bird implements runner, swimmer
{
	private int runSpeed;
	private int swimSpeed;
	
	public Penguin (String name, int runSpeed, int swimSpeed)
	{
		setName(name);
		setType("Penguin");
		setRunSpeed(runSpeed);
		setSwimSpeed(swimSpeed);
	}	
	
	@Override
	public int swim() 
	{
		return swimSpeed;
	}

	@Override
	public int run() 
	{
		return runSpeed;
	}

	@Override
	String strangeFact() 
	{
		return "I can’t fly but I’m the fastest swimmer and deepest diver and can stay underwater up to 20 minutes.";
	}

	public void setRunSpeed(int runSpeed) 
	{
		this.runSpeed = runSpeed;
	}

	public void setSwimSpeed(int swimSpeed) 
	{
		this.swimSpeed = swimSpeed;
	}
}

class Ostrich extends Bird implements runner, swimmer
{
	private int runSpeed;
	private int swimSpeed;
	
	public Ostrich (String name, int runSpeed, int swimSpeed)
	{
		setName(name);
		setType("Ostrich");
		setRunSpeed(runSpeed);
		setSwimSpeed(swimSpeed);
	}

	@Override
	public int swim() 
	{
		return swimSpeed;
	}

	@Override
	public int run() 
	{
		return runSpeed;
	}

	@Override
	String strangeFact() 
	{
		return "Who needs flying when you’re the biggest bird on earth! I can be up to 9 feet tall and weigh up to 300 pounds – bring it on!";
	}

	public void setRunSpeed(int runSpeed) 
	{
		this.runSpeed = runSpeed;
	}
	
	public void setSwimSpeed(int swimSpeed) 
	{
		this.swimSpeed = swimSpeed;
	}
}

class SootyTern extends Bird implements runner, flyer
{
	private int runSpeed;
	private int flyAltitude;
	
	public SootyTern (String name, int flyAltitude, int runSpeed)
	{
		setName(name);
		setType("Sooty Tern");
		setRunSpeed(runSpeed);
		setFlyAltitude(flyAltitude);
	}

	@Override
	public int fly() 
	{
		return flyAltitude;
	}

	@Override
	public int run() 
	{
		return runSpeed;
	}

	@Override
	String strangeFact() 
	{
		return "Strange as it may sound, I spend most of my life at sea and I can't swim but I can nap while flying!";
	}

	public void setRunSpeed(int runSpeed) 
	{
		this.runSpeed = runSpeed;
	}

	public void setFlyAltitude(int flyAltitude) 
	{
		this.flyAltitude = flyAltitude;
	}
}

class Loon extends Bird implements swimmer, flyer
{
	private int flyAltitude;
	private int swimSpeed;
	
	public Loon (String name, int flyAltitude, int swimSpeed)
	{
		setName(name);
		setType("Loon");
		setFlySpeed(flyAltitude);
		setSwimSpeed(swimSpeed);
	}

	@Override
	public int fly() 
	{
		return flyAltitude;
	}

	@Override
	public int swim() 
	{
		return swimSpeed;
	}

	@Override
	String strangeFact() 
	{
		return "My legs are so far back on my body that I cannot walk on land, so I push myself along the ground on my chest.";
	}

	public void setFlySpeed(int flyAltitude) 
	{
		this.flyAltitude = flyAltitude;
	}

	public void setSwimSpeed(int swimSpeed) 
	{
		this.swimSpeed = swimSpeed;
	}
}
