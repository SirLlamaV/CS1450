/*
 * Kaleb Mayeux
 * CS 1450
 * T/TH Section
 * Due September 2, 2021
 * Assignment 1
 * In this assignment I am tasked with creating and filling an array.
 * Afterwards, I am to manipulate said array in various ways.
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
public class MayeuxKalebAssignment1 
{

	public static void main(String[] args) throws IOException
	{
		//Initialize variables necessary and required arrays
		int odd;
		int numStorage = 0;
		
		int[] array1 = {13, 18, 1, 4, 8, 16, 11};
		int[] array2 = {9, 10, 5, 12, 3, 7, 14};
		
		System.out.println("Array 1: Original\n" + "-----------------");
		for (int i = 0; i < array1.length; i++)
		{
			System.out.printf("array1[%d] = %d\n", i, array1[i]);
		}
		
		System.out.println("\nArray 2: Original\n" + "-----------------");
		for (int i = 0; i < array2.length; i++)
		{
			System.out.printf("array2[%d] = %d\n", i, array2[i]);
		}
		
		
		// This code swaps even numbers to array 1 and odd numbers to array 2
		for (int i = 0; i < array1.length; i++)
		{
			if (array1[i] % 2 > 0)
			{
				odd = array1[i];
				for (int j = 0; j < array2.length; j++)
				{
					if(array2[j] % 2 == 0)
					{
						array1[i] = array2[j];
						array2[j] = odd;
						break;
					}
				}
			}
		}
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		System.out.println("\nArray 1: Sorted Even\n" + "-----------------");
		
		for (int i = 0; i < array1.length; i++)
		{
			System.out.printf("array1[%d] = %d\n", i, array1[i]);
		}
		
		System.out.println("\nArray 2: Sorted Odd\n" + "-----------------");
		for (int i = 0; i < array2.length; i++)
		{
			System.out.printf("array2[%d] = %d\n", i, array2[i]);
		}
		
		System.out.println("\nShow values being written to file\n" + "---------------------------------");
		
		//Creating a file with name and preparing it to be written to.
		
		File fileName = new File("assignment1.txt");
		PrintWriter outputFile = new PrintWriter (fileName);
		
		
		//Sorts the arrays in ascending order and then writes them to the file
		for (int i = 0; i <= array1.length;)
			{
				if (array1[i] < array2[6])
				{
					for (int j = 0; j < array2.length;)
					{
						j = numStorage;
						if(array1[i] > array2[j])
						{
							System.out.printf("Writing to File: %d\n", array2[j]);
							outputFile.println(array2[j]);
							j++;
							numStorage = j;
						}
						else if (array1[i] < array2[j])
						{
							System.out.printf("Writing to File: %d\n",array1[i]);
							outputFile.println(array1[i]);
							i++;
						}
					}
				}
				// Messy code that prevents an array overflow from manually adding 1 to i by breaking out of the loop
					System.out.printf("Writing to File: %d\n",array1[i]);
					outputFile.println(array1[i]);
					if (i + 2 > array1.length)
					{
						break;
					}
					else
					{
						i++;
					}
			}
		
		outputFile.close();
		
		Scanner readFile = new Scanner (fileName);
		
		int[] finalArray = new int[14];
		
		System.out.println("\nFinal Array\n" + "-------------------------------");
		
		
		// Takes the contents of the file and transfers them to an array, then prints the array.
		for(int i = 0; i < finalArray.length; i++)
		{
			finalArray[i] = readFile.nextInt();
			System.out.printf("finalArray[%d] = %d\n", i, finalArray[i]);
		}
		
		readFile.close();
	}
}
