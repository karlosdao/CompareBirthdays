public class Birthday implements Comparable<Birthday>
{
	//name of person
	private String name = "";
	//Birth date of person in yyyymmdd format
	private int bday = 0;

	public Birthday()
	{
		name = "Fred"; //had to add this
		bday = 20160714; //had to add this
	}
	
	public Birthday(String name, int birthday) throws InvalidBirthdayException
	{
		setName(name);
		setBday(birthday);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name) throws InvalidBirthdayException
	{
	    if (name.length() == 0)
	        throw new InvalidBirthdayException("Name cannot be blank");
		this.name = name;
	}

	public int getBday()
	{
		return bday;
	}

	public void setBday(int bday) throws InvalidBirthdayException
	{
	    if (bday > 20160714 || bday < 0)
	        throw new InvalidBirthdayException("Birth date is invalid");
		this.bday = bday;
	}
	
	public String toString()
	{
		String data = "";
		data += name + " " + bday;
		return data;
	}
	
	//cant invoke compareTo(int) on the primitive type int
	@Override
	public int compareTo(Birthday o)
	{
		return this.bday - o.getBday();
	}
}
