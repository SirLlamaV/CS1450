// When writing to and reading from files you need to import several classes.
// You need: File, IOException, PrintWriter and Scanner
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileExample {

	public static void main(String[] args) throws IOException {

		// First note that when working with files you need to handle exceptions.  There are two choices.
		// Choice 1: you could catch the exception using try/catch blocks in your code but they tend to make 
		// code more complicated. 
		// Choice 2: To simplify code and keep the focus on learning data structures, I recommend throwing 
		// the exception at main has shown in this code and leaving try/catch out of your code for now.
		// Once you become a stronger programmer then start working with try/catch blocks.
		
		// Now let's start with writing to a file.
		// This is a good exercise since it shows where Eclipse places files on your hard drive.
		
		// Create an array with some values
		int[] array = {18, 10, 26, 8};

		// First setup a file reference variable to refer to the text file. 
		// Note that the file has NOT been created on your hard drive yet, this only creates the 
		// reference variable. 
		// The variable fileName is how the code refers to the file Assignment1Example.txt on the hard drive.
		File fileName = new File("Assignment1Example.txt");	
		
		// Second create the file and open it for writing.	
		// The PrintWriter class is used to write data to a file.
		// Let's create a PrintWriter variable called outputFile which will be used used any time you 
		// need to write to Assignment1Example.txt
		PrintWriter outputFile = new PrintWriter (fileName);
		
		// Third write something to the file.  Let's write the values in the array to the file.
		for (int i = 0; i < array.length; i++) {
			outputFile.println(array[i]);
		}
		
		// Fourth close the file.
		// To prove writing to the file worked properly, find the file on your hard drive, open the file and 
		// verify it contains the values stored in the array.
		// The file will be in your eclipse workspace in the CS1450 folder (or whatever you named your 
		// project for this class in Eclipse).  The values 18, 10, 26, and 8 will each be on their own line.
		outputFile.close();
		
		// Student Note: This code shows where the file is located on your hard drive
		System.out.println();
		System.out.println("File is in directory: " + fileName.getAbsolutePath());
		System.out.println();

		// The next step is to read from a file.
		// Before we get started note the following:
		//	    - Earlier we create a Printer named "outputFile"
		//	    - When the PrinterWriter was created, it was connected to "filename"
		//	    - When filename was setup it was connect to Assignment1Example.txt.  
		//	    - Now, before we attempt to read from the file we must close the file. 
		//	    - Closing the file for writing was done with the code outputFile.close()   

		// Reading from a file is very similar to reading from the keyboard.		
		// First open the file for reading by creating a scanner for the file.
		// Note: I'm using the same variable - fileName - so I'm opening the file Assignment1Example.txt
		// on my hard drive but this time for reading.  
		Scanner inputFile = new Scanner (fileName);
		
		// Second prove that you actually read something from the file.
		// Note the use of the method nextLine.  The point is, use the methods in the Scanner class
		// to obtain the information from the file.  With numbers, use nextInt, nextDouble, etc.
		// Important Note: There is no need to read a line of numbers and then parse the line to get 
		// the values.  Let the Scanner methods do the work.
		for (int i = 0; i < array.length; i++) {
			System.out.println("Value read from file is: " + inputFile.nextInt());
		}
		
		// Third close the file.
		inputFile.close();
		
	} // main

} //FileExample
