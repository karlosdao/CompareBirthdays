/**
 * Class: InvalidBirthdayException
 * @author Karlos Dao
 * @version 1.0
 * Course: ITEC 2150 Fall 2018
 * Written November 7, 2018
 * 
 * This class is a custom exception to be used when a birth daste is found to be invalid.
 */
public class InvalidBirthdayException extends Exception
{
	public InvalidBirthdayException()
	{
		super();
	}
	public InvalidBirthdayException(String msg)
	{
		super(msg);
	}

}
