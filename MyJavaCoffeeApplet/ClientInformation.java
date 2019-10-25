/*******************************************************************
 *
 * File:		ClientInformation.java
 *
 * Author: 		Dan Gerstl
 *
 * Date:		04/29/2018
 *
 * Purpose:		Project 1
 *
 * Description: Object to hold client information
 *
 * Comment:		NA
 *
 *********************************************************************/

 public class ClientInformation
 {
	 /*** Class Constants ***/

	 private final String DEFAULT_STRING = "None entered";

	 /*** Class Variables ***/

	 private String firstName	  = null;
	 private String lastName 	  = null;
	 private String streetAddress = null;
	 private String city		  = null;
	 private String state		  = null;
	 private String zipCode 	  = null;

	 /*** Constructor ***/

	 public ClientInformation(String firstName, String lastName,
	 						  String address, String city, String state,
	 						  String zipCode)
	 {
		 setFirstName(firstName);
		 setLastName(lastName);
		 setStreetAddress(address);
		 setCity(city);
		 setState(state);
		 setZipCode(zipCode);
	 }

	 /*** Class Methods - Transformers/Mutators ***/

	 public void setFirstName(String name)
	 {
		 if (name.length() > 0)
		 	this.firstName = name;
		 else
		 	this.firstName = DEFAULT_STRING;
	 }

	 public void setLastName(String name)
	 {
		 if (name.length() > 0)
		 	this.lastName = name;
		 else
		 	this.lastName = DEFAULT_STRING;
	 }

	 public void setStreetAddress(String address)
	 {
		 if (address.length() > 0)
		 	this.streetAddress = address;
		 else
		 	this.streetAddress = DEFAULT_STRING;
	 }

	 public void setCity(String city)
	 {
		 if (city.length() > 0)
		 	this.city = city;
		 else
		 	this.city = DEFAULT_STRING;
	 }

	 public void setState(String state)
	 {
		 if (state.length() > 0)
		 	this.state = state;
		 else
		 	this.state = DEFAULT_STRING;
	 }

	 public void setZipCode(String zipCode)
	 {
		 /*** Local Constants ***/

		 final String DEFAULT_ZIP_CODE = "00000";

		 if (verifyZipCode(zipCode))
		 	this.zipCode = zipCode;
		 else
		 	this.zipCode = DEFAULT_ZIP_CODE;
	 }

	 /*** Class Methods - Accessors ***/

	 public String getFirstName()
	 {
		 return this.firstName;
	 }

	 public String getLastName()
	 {
		 return this.lastName;
	 }

	 public String getStreetAddress()
	 {
		 return this.streetAddress;
	 }

	 public String getCity()
	 {
		 return this.city;
	 }

	 public String getState()
	 {
		 return this.state;
	 }

	 public String getZipCode()
	 {
		 return this.zipCode;
	 }

	 @Override
	 public String toString()
	 {
		 return "First name: " 	   + this.getFirstName()	 + " " +
		 		"Last name: "  	   + this.getLastName() 	 + " " +
		 		"Street Address: " + this.getStreetAddress() + " " +
		 		"City: "		   + this.getCity()			 + " " +
		 		"State: "		   + this.getState()		 + " " +
		 		"Zip code: "	   + this.getZipCode()		 + " " ;
	 }

	 public static boolean verifyZipCode(String zipCode)
	 {
		 /*** Local Variables ***/

		 boolean isValid = true;

		 if (zipCode.length() == 5)
		 {
		 	for (int i = 0; i < zipCode.length(); ++i)
		 	{
				if (zipCode.charAt(i) >= '0' && zipCode.charAt(i) <= '9')
				{
					//keep valid
				}
				else
				{
					isValid = false;
				}
			}
		 }
		 else
		 {
			 isValid = false;
		 }

	 	 return isValid;
	 }

	 /*** Application ***/

	 public static void main(String[] args)
	 {
		 ClientInformation tester = new ClientInformation("first", "last",
		                                                  "street", "city",
		                                                  "state", "zip");
	 }
 }