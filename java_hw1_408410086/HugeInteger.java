public class HugeInteger
{
	
	private int digitArray[]; // integer array for storing the digits of the huge integer
	final static int MAX_INT_SIZE = 40; // constant for the maximum number of digits
	
	
	// default no-argument constructor
	public HugeInteger()
	{
		// digitArray will be automatically initialized to contain only 0's
		 digitArray = new int[MAX_INT_SIZE];
	}
	
	
	// single-argument constructor initializes HugeInteger to the specified value
	public HugeInteger(String value)
	{
		this();
		this.parse(value);
	}
	

	public int getDigit(int digit)
	{
		return this.getIndex(MAX_INT_SIZE - digit);
	}
	
	
	public int getIndex(int index)
	{
		if( (index < MAX_INT_SIZE) && (index >= 0))
		{
			return this.digitArray[index];
		}
		
		else
		{
			// Alert the user that the index is out of bounds
			System.out.println("getIndex failed: index out of bounds");

			return -1;
		}
	}
	
	
	private void setDigit(int digit, int value)
	{
		this.setIndex((MAX_INT_SIZE-digit), value);
	}
	
	private void setIndex(int index, int value)
	{
		if( (index < MAX_INT_SIZE) && (index >= 0))
		{
			if( (value < 10) && (value >= 0))
			{
				this.digitArray[index] = value;
			}
			
			else
			{
				// Alert the user if an incorrect value was specified
				System.out.println("setIndex failed: value should be an integer in the range 0-9.");
			}
		}
		
		else
		{
			// Alert the user if the index would have been out of bounds
			System.out.println("setIndex failed: index out of bounds.");
		}
	}
	
	
	public void parse(String value)
	{
		if( (value.length() <= MAX_INT_SIZE) && (value.length() > 0))
		{	
			for(int counter = 1; counter <= value.length(); counter++)
			{
				// charDigit starts at the highest index of the string and decreases
				int charDigit = value.length() - counter;
				
				// check that each character is a numeral
				if( Character.isDigit( value.charAt( charDigit ) ) )
				{
					/*
					 * iterate from the rightmost end of both the array and the string,
					 * as though reading the number numerically
					 */
					this.setDigit(counter, 
						Character.getNumericValue(value.charAt(charDigit)));
				}
				
				else
				{
					// Alert the user if the string contained non-numeric characters
					System.out.println("parse failed: value must consist of numeric characters only.");
				}
			}
		}
		
		else
		{
			// Alert the user if the string was too large or too small
			System.out.printf("parse failed: value must contain %d or fewer characters", MAX_INT_SIZE);
		}
	}
	
	
	public void add(HugeInteger addend)
	{
		int sum = 0;
		int carry = 0;
		
		for(int counter = 1; counter <= MAX_INT_SIZE; counter++)
		{
			sum =  this.getDigit(counter) + addend.getDigit(counter) + carry;
			
			if(sum < 10)
			{
				this.setDigit(counter, sum);
				carry = 0;
			}
			
			else
			{
				this.setDigit(counter, (sum-10));
				carry = 1;
			}
		}
		
		// if addition is finished and the carry is not 0, an overflow has occurred
		if(carry != 0)
		{
			System.out.println("addition result is incorrect: an overflow occurred");
		}
	}
	
	
	public void subtract(HugeInteger subtrahend)
	{	
		int difference = 0;
		int borrow = 0;
		
		// check if the result will be positive and if so, proceed with subtraction
		if(this.isGreaterThanOrEqualTo(subtrahend))
		{
			for(int counter = 1; counter <= MAX_INT_SIZE; counter++)
			{
				difference = this.getDigit(counter) - subtrahend.getDigit(counter) - borrow;
				
				if(difference >= 0)
				{
					this.setDigit(counter, difference);
					borrow = 0;
				}
				
				else
				{
					this.setDigit(counter, (difference+10));
					borrow = 1;
				}
			}
		}
		
		
		else
		{
			// Alert the user that the result would have been negative
			System.out.println("subtraction failed: result would be negative");
		}
	}
		
		
	
	// instance method to check if this HugeInteger has a value of zero
	public boolean isZero()
	{
		for(int counter = 0; counter < MAX_INT_SIZE; counter++)
		{
			// if any digit in the array is not zero, return false immediately
			if(this.getIndex(counter) != 0)
			{
				return false;
			}
		}
		
		// if all of the digits in the array were zero, return true
		return true;
	}
	
	
	// instance method to check if this HugeInteger is equal to another HugeInteger
	public boolean isEqualTo(HugeInteger argument)
	{	
		for(int counter = 0; counter <MAX_INT_SIZE; counter++)
		{
			if(this.getIndex(counter) != argument.getIndex(counter))
			{
				// if any digits in the arrays do not match, return false immediately
				return false;
			}
		}
		
		// if all of the digits in the array matched, return true
		return true;
	}
	
	
	// instance method to check if this HugeInteger is not equal to another HugeInteger
	public boolean isNotEqualTo(HugeInteger argument)
	{
		// return the negation of isEqualTo
		return !(isEqualTo(argument));
	}
	
	
	public boolean isGreaterThan(HugeInteger argument)
	{
		int counter = 0;
		while( (this.getIndex(counter) == argument.getIndex(counter)) && (counter < MAX_INT_SIZE) )
		{
			counter++;
		}
		
		if(counter == MAX_INT_SIZE)
		{
			return false;
		}
		
		else
		{
			return (this.getIndex(counter) > argument.getIndex(counter));
		}
	}
	
	
	// instance method to check if this HugeInteger is greater than or equal to another HugeInteger
	public boolean isGreaterThanOrEqualTo(HugeInteger argument)
	{
		// use preexisting methods to check the two possibilities
		return (this.isEqualTo(argument) || this.isGreaterThan(argument));
	}
	
	
	public boolean isLessThan(HugeInteger argument)
	{
		int counter = 0;
		while( (this.getIndex(counter) == argument.getIndex(counter)) && (counter < MAX_INT_SIZE) )
		{
			counter++;
		}
		
		if(counter == MAX_INT_SIZE)
		{
			return false;
		}
		
		else
		{
			return (this.getIndex(counter) < argument.getIndex(counter));
		}
	}
	
	
	// instance method to check if this HugeInteger is less than or equal to another HugeInteger
	public boolean isLessThanOrEqualTo(HugeInteger argument)
	{
		// use preexisting methods to check the two possibilities
		return (this.isEqualTo(argument) || this.isLessThan(argument));
	}
	
	
	// instance method to return a string representing the HugeInteger value
	@Override public String toString()
	{
		
		
		// create a new StringBuffer object with initial capacity equal to the digitArray capacity
		StringBuffer stringValue = new StringBuffer(MAX_INT_SIZE);
		
		// iterate from left to right through the array, as though listing digits
		for (int counter = 0; counter < MAX_INT_SIZE; counter++)
		{
			// append the integer to the StringBuffer
			// the append method converts the integer to its string representation
			stringValue.append(this.getIndex(counter));
		}
		
		// return the string generated by the StringBuffer's toString method
		return stringValue.toString();
	}
	
	
	// instance method to return a string representing the HugeInteger value,
	// but without any extraneous leading zeros
	public String toShortString()
	{
		// create a StringBuffer object with initial capacity equal to the digitArray capacity
		StringBuffer stringValue = new StringBuffer(MAX_INT_SIZE);
		
		// if the value of the HugeInteger is zero, return a single zero
		if( this.isZero() )
		{
			stringValue.append(0);
		}
		
		// otherwise commence printing
		else
		{
			// iterate from left to right through any extraneous leading zeros
			int counter = 0;
			
			while( (this.getIndex(counter) == 0) && (counter < MAX_INT_SIZE) ) 
			{
				counter++;
			}
			
			// when a value that is not  zero is reached, ordinary printing can begin
			for( ; counter < MAX_INT_SIZE; counter++)
			{
				stringValue.append(this.getIndex(counter));
			}
		}
		
		// return the string generated by the StringBuffer's toString method
		return stringValue.toString();
	}
}