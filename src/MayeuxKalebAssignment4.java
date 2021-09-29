/*
 * Initial Comment 
 */

import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

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
			
			Train train = new Train(engineNumber, company, numberRailCars, type, destinationCity);
			System.out.println(train.getEngineNumber());
			
			railroad.addTrainToSortingYard(trackNumber, train);
			
			if (!inputFile.hasNextLine())
			{
				i = fileSize + 1;
			}
		}
		
		
		
		inputFile.close();
	}

}

class Railroad
{
	private int numberTracks;
	private Train[] sortingYard;
	
	public Railroad (int numberTracks)
	{
		sortingYard = new Train[numberTracks];
	}
	
	public int getNumberTracks(int numberTracks)
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
		return String.format("%d\\t%s\\t\\t%d\\t\\t%-15s\\t%s", engineNumber, company, numberRailCars, type, destinationCity);
	}
	
	@Override
	public int compareTo(Train otherTrain)
	{
		if (this.numberRailCars > otherTrain.numberRailCars)
		{
			return 1;
		}
		else if (this.numberRailCars < otherTrain.numberRailCars)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
}