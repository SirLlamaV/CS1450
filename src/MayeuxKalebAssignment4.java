/*
 * Initial Comment 
 */

import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class MayeuxKalebAssignment4 
{

	public static void main(String[] args) throws IOException
	{
		File fileName = new File("Trains.txt");
		Scanner inputFile = new Scanner(fileName);
		int fileSize = inputFile.nextInt();
		
		int trackNumber;
		int engineNumber;
		String company;
		int numberRailCars;
		String type;
		String destinationCity;
		
		Railroad railroad = new Railroad(fileSize);
		
		
		for (int i = 0; i <= fileSize; i++)
		{
			trackNumber = inputFile.nextInt();
			engineNumber = inputFile.nextInt();
			company = inputFile.next();
			numberRailCars = inputFile.nextInt();
			type = inputFile.next();
			destinationCity = inputFile.next();
			
			
			railroad.addTrainToSortingYard(trackNumber, new Train(engineNumber, company, numberRailCars, type, destinationCity));
			
			
			
			if (!inputFile.hasNextLine())
			{
				i = fileSize + 1;
			}
		}
		System.out.println("Loading trains onto tracks in sorting yard...");
		
		railroad.displaySortingYard();
		
		printTrainReport(railroad);
		
		inputFile.close();
	}
	
	public static void printTrainReport(Railroad railroad)
	{
		int nonNullCounter = 0;
		ArrayList<Train> trains = new ArrayList<>();
		
		System.out.println("\n\n****************************************************************************");
		System.out.println("\t\t\tTRAIN REPORT\n\t\t(Ordered by Number of Rail Cars)");
		System.out.println("****************************************************************************");
		System.out.println(" Engine\tCompany\t\tRail Cars\tType\t\tDeparting To");
		System.out.println("----------------------------------------------------------------------------");
		for (int i = 0; i < railroad.getNumberTracks(); i++)
		{
			if (railroad.getTrainInSortingYard(i) != null)
			{
				trains.add(i - nonNullCounter, railroad.getTrainInSortingYard(i));
				
			}
			else
			{
				nonNullCounter++;
			}
			
		}
		
		Collections.sort(trains);
		System.out.println(trains.toString().replaceAll(",", "").replaceAll("\\[", " ").replaceAll("\\]", ""));
	}

}

class Railroad
{
	private int numberTracks;
	private Train[] sortingYard;
	
	public Railroad (int numberTracks)
	{
		this.numberTracks = numberTracks;
		sortingYard = new Train[numberTracks];
	}
	
	public int getNumberTracks()
	{
		return numberTracks;
	}
	
	public void addTrainToSortingYard(int trackNumber,Train train)
	{
		sortingYard[trackNumber] = train;
	}
	
	public Train getTrainInSortingYard(int trackNumber)
	{
		return sortingYard[trackNumber];
	}
	
	public void displaySortingYard()
	{
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Track\tEngine\tCompany\t\tRail Cars\tType\t\tDestination");
		System.out.println("----------------------------------------------------------------------------");
		for (int i = 0; i < numberTracks; i++)
		{
			if (sortingYard[i] == null)
			{
				System.out.printf("%d\t%s\t%s\t\t%s\t\t%-15s\t%s\n", i, "---", "---", "---", "---", "---");
			}
			else
			{
				System.out.printf("%d\t%s", i, sortingYard[i]);
			}
			
		}
	}
}

class Train implements Comparable<Train>
{
	private int engineNumber;
	private String company;
	private int numberRailCars;
	private String type;
	private String destinationCity;
	
	public Train (int engineNumber, String company, int numberRailCars, String type, String destinationCity)
	{
		this.engineNumber = engineNumber;
		this.company = company;
		this.numberRailCars = numberRailCars;
		this.type = type;
		this.destinationCity = destinationCity;
	}
	
	public int getEngineNumber()
	{
		return engineNumber;
	}
	
	public String getCompany()
	{
		return company;
	}
	
	public int getNumberRailCars()
	{
		return numberRailCars;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String getDestinationCity()
	{
		return destinationCity;
	}
	
	@Override
	public String toString()
	{
		return String.format("%d\t%s\t\t%d\t\t%-15s\t%s\n", engineNumber, company, numberRailCars, type, destinationCity);
	}
	
	@Override
	public int compareTo(Train otherTrain)
	{
		if (this.numberRailCars > otherTrain.numberRailCars)
		{
			return -1;
		}
		else if (this.numberRailCars < otherTrain.numberRailCars)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}