
public class OOP_Review 
{

	public static void main(String[] args) 
	{
		
	}
	

}

class Dog
{
	private String name;   
	private int size;
	private String color;
	private String breed;
	private boolean sitting;
	private boolean fetching;
	
	Dog myDog = new Dog("Ajax", 55, "Black and Brown", "German Shepard");
	
	public Dog()
	{
		
	}
	
	public Dog(String dogName, int dogSize, String dogColor, String dogBreed)
	{
		name = dogName;
		size = dogSize;
		color = dogColor;
		breed = dogBreed;
		sitting = false;
		fetching = false;
	}
	
	public void bark()
	{
		System.out.println("Ruff! Ruff Ruff!!!");
	}
	
	public boolean sit()
	{
		return sitting;
	}
	
	public boolean fetch()
	{
		return fetching;
	}
}
