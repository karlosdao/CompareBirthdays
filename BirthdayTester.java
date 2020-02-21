import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class BirthdayTester
{
	private Scanner input;

	public static void main(String[] args) throws InvalidBirthdayException
	{
		LinkedList<Birthday> bdayList = new LinkedList<Birthday>();
		BirthdayTester birthdayOutput = new BirthdayTester();
		birthdayOutput.input = new Scanner(System.in);
		boolean again = true;
		while(again)
		{
			try
			{
				bdayList.add(birthdayOutput.getBirthdayInfo());
			}
			catch(InvalidBirthdayException ibe)
			{
				again = false;
			}
		}
		
		//print the list
		System.out.println("List of names and brithday:");
		birthdayOutput.print(bdayList);
		
		//sort the list and finds the highest bday
		System.out.println("The oldest person is: " + birthdayOutput.findOldest(bdayList).toString());
		
	}

	//method to enter list
	public Birthday getBirthdayInfo() throws InvalidBirthdayException
	{
		Birthday birthday = new Birthday();
		String name = "";
		int bday;
		
		boolean valid = false;
		do
		{
			try
			{
				
				System.out.println("Enter the person's name. Enter -1 to exit");
				name = input.nextLine();
				birthday.setName(name);
                	valid = true;
			}
			catch(InvalidBirthdayException ibe)
			{
				valid = false;
				System.out.println(ibe.getMessage());
			}
		
		}while(!valid);
		
		if(name.equals("-1"))
		{
			throw new InvalidBirthdayException("End name entry");
		}
		
		do
		{
			try
			{
				System.out.println("Enter the birthday (yyyymmdd)");
				bday = input.nextInt();
				birthday.setBday(bday);
				valid = true;
			}
			catch(InvalidBirthdayException ibe)
			{
				valid = false;
				System.out.println(ibe.getMessage());
			}
			catch(InputMismatchException ime)
			{
				System.out.println("You must enter an integer for birthday");
			}
			finally
			{
				input.nextLine();
			}
			
		}while(!valid);
		
		return birthday;
	}
	
	//method to print list
	private void print(LinkedList<Birthday> bdayList)
    {
        for (Birthday list : bdayList)
        {
            System.out.println(list);            
        }
    }
	
	//method to find oldest
	//pass through the list in parameter
	private Birthday findOldest(LinkedList<Birthday> bdayList)
	{
		ListIterator<Birthday> iter = bdayList.listIterator();
		Birthday current = new Birthday();
		if(iter.hasNext())
		{
			current = iter.next();
		}
		while(iter.hasNext())
		{
			Birthday temp = iter.next();
			if(current.compareTo(temp) > 0)
			{
				current = temp;
			}
		}
		return current;
	}

}
