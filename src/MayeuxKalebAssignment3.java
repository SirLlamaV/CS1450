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

public class MayeuxKalebAssignment3 
{
	
	public static void main(String[] args) 
	{
		
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
	
	abstract void strangeFact();
}

class Penguin extends Bird implements runner, swimmer
{
	private int runSpeed;
	private int swimSpeed;
	
	public Penguin (String name, int runSpeed, int swimSpeed)
	{
		
	}

	@Override
	public int swim() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int run() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	void strangeFact() {
		// TODO Auto-generated method stub
		
	}
}

class Ostrich extends Bird implements runner, swimmer
{
	private int runSpeed;
	private int swimSpeed;
	
	public Ostrich (String name, int runSpeed, int swimSpeed)
	{
		
	}

	@Override
	public int swim() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int run() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	void strangeFact() {
		// TODO Auto-generated method stub
		
	}
}

class SootyTern extends Bird implements runner, flyer
{
	private int runSpeed;
	private int flySpeed;
	
	public SootyTern (String name, int runSpeed, int flySpeed)
	{
		
	}

	@Override
	public int fly() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int run() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	void strangeFact() {
		// TODO Auto-generated method stub
		
	}
}

class Loon extends Bird implements swimmer, flyer
{
	private int flySpeed;
	private int swimSpeed;
	
	public Loon (String name, int flySpeed, int swimSpeed)
	{
		
	}

	@Override
	public int fly() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int swim() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	void strangeFact() {
		// TODO Auto-generated method stub
		
	}
}
