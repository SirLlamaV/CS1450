import java.util.Arrays;

/*
 * Kaleb Mayeux
 * CS 1450
 * T/TH Section
 * Due September 2, 2021
 * Assignment 1
 * In this assignment I am tasked with creating and filling an array.
 * Afterwards, I am to manipulate said array in various ways.
 */

public class MayeuxKalebAssignment1 
{

	public static void main(String[] args)
	{
		int[] array1 = {13, 18, 1, 4, 8, 16, 11};
		int[] array2 = {9, 10, 5, 12, 3, 7, 14};
		
		System.out.println("Array 1: Original\n" + "-----------------");
		
		for (int i = 0; i < array1.length; i++)
		{
			System.out.printf("array1[%d] = " + array1[i] + " \n", i);
		}
		
		System.out.println("\nArray 2: Original\n" + "-----------------");
		for (int i = 0; i < array2.length; i++)
		{
			System.out.printf("array2[%d] = " + array2[i] + " \n", i);
		}
		
		
	}

}
