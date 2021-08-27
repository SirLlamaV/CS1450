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
public class MayeuxKalebAssignment1 
{

	public static void main(String[] args) throws IOException
	{
		int odd;
		int placeHolder1 = 0;
		int placeHolder2 = 0;
		
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
		
		//Sort and transfer arrays here
		
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
		
		File fileName = new File("assignment1.txt");
		PrintWriter outputFile = new PrintWriter (fileName);
		
		for (int i = 0; i < array1.length; i++)
			{
				if ((array1[i] > array2[i]) && (array1[i] != placeHolder1))
				{
					placeHolder1 = array1[i];
					System.out.println(placeHolder1);
					for (int j = 0; j < array2.length; j++)
					{
						if (placeHolder1 < array2[j])
						{
							outputFile.println(placeHolder1);
							System.out.println(placeHolder1 + " if");
							break;
						}
						else if ((array2[j] < placeHolder1)  && (array2[j] != placeHolder2))
						{
							outputFile.println(array2[j]);
							placeHolder2 = array2[j];
							System.out.println(array2[j] + " elif");
							break;
						}
					}
				}
			}
				
		
		
		outputFile.close();
	}
}
