//Initial Comment

import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class MayeuxKalebAssignment5 
{

	public static void main(String[] args) throws IOException
	{
		
	}

}

class GenericStack<E>
{
	private ArrayList<E> list = new ArrayList<>();
	
	public GenericStack()
	{
		
	}
	
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
	
	public int getSize()
	{
		return list.size();
	}
	
	public E peek()
	{
		return list.get(list.size() - 1);
	}
	
	public E pop()
	{
		E top = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		return top;
	}
	
	public void push(E value)
	{
		list.add(value);
	}
}
