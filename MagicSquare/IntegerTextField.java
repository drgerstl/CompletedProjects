/********************************************************************
 *
 * File:		IntegerTextField.java
 *
 * Author: 		Dan Gerstl
 *
 * Date:		05/19/2018
 *
 * Purpose:		Project 02
 *
 * Description: Custome JTextField to handle integers.
 *
 * Comment:		NA
 *
 *********************************************************************/

 import javax.swing.*;

 public class IntegerTextField extends JTextField
 {
	 /*** Class Variables ***/

	 private int minimum = Integer.MIN_VALUE;
	 private int maximum = Integer.MAX_VALUE;

	 /*** Constructors ***/

	 public IntegerTextField(int size)
	 {
		 super(size);
	 }

	 public IntegerTextField(int size, int minimum, int maximum)
	 {
		 super(size);

		 setMinimum(minimum);
		 setMaximum(maximum);
	 }

	 /*** Mutator Methods ***/

	 public void setMinimum(int minimum)
	 {
		 this.minimum = minimum;
	 }

	 public void setMaximum(int maximum)
	 {
		 this.maximum = maximum;
	 }

	 /*** Accessor Methods ***/

	 public int getInteger() throws IntegerUserInputException
	 {
		 /*** Local Variables ***/

		 int intNumber = 0;

		 /*** Extract User Input ***/

		 try
		 {
			 intNumber = Integer.parseInt(getText().trim());

			 if (intNumber < minimum || intNumber > maximum)
			 {
				 throw new IntegerUserInputException(minimum, maximum);
			 }
		 }

		 catch (NumberFormatException e)
		 {
			 throw new IntegerUserInputException("Not an integer - " +
			 									 e.getMessage());
		 }

		 return intNumber;
	 }
 }