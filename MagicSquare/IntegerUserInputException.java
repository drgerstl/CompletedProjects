/********************************************************************
 *
 * File:		IntegerUserInputException.java
 *
 * Author: 		Dan Gerstl
 *
 * Date:		05/19/2018
 *
 * Purpose:		Project 02
 *
 * Description: Provides custom error messages to call.
 *
 * Comment:		NA
 *
 *********************************************************************/

 public class IntegerUserInputException extends Exception
 {
	 /*** Constructors ***/

	 public IntegerUserInputException()
	 {
		 super("Error - User input invalid integer!");
	 }

	 public IntegerUserInputException(String message)
	 {
		 super(message);
	 }

	 public IntegerUserInputException(int minimum, int maximum)
	 {
		 super("Error - User input out of range: " + minimum + "-"
		       + maximum + ".");
	 }
 }