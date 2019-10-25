/*******************************************************************
 *
 * File:		Invoice.java
 *
 * Author: 		Dan Gerstl
 *
 * Date:		04/29/2018
 *
 * Purpose:		Project 1
 *
 * Description: Object to generate invoice
 *
 * Comment:		NA
 *
 *********************************************************************/

 import java.time.*;

 public class Invoice
 {
	 /*** Class Constants ***/

	 private final static String FORMAT_STRING = "%26s:";

	 private final static String STRING_TOTAL  = FORMAT_STRING +
	 											 "%15s$   %,.2f%n";
	 /*** Private Constructor ***/

	 private Invoice()
	 {
	 }

	 /*** Class Methods ***/

	 public static String createInvoice(ClientInformation clientInfo,
	 									OrderCost cost)
	 {
		 /*** Local Variables ***/

		 StringBuilder invoice = new StringBuilder();

		 invoice.append(createHeader(clientInfo, cost));
		 invoice.append(createBoxesInfo(cost));
		 invoice.append(createDateInfo());
		 invoice.append(createShippingInfo(clientInfo));

		 return invoice.toString();
	 }

	 private static String createHeader(ClientInformation clientInfo,
	 									OrderCost cost)
	 {
		 /*** Local Constants ***/

	     final String STRING_NAME = FORMAT_STRING + "  %s%n";
	 	 final String STRING_BAGS = FORMAT_STRING + "  %-4d%n";

		 /*** Local Variables ***/

		 StringBuilder header = new StringBuilder();

		 /*** Generate Header ***/

		 header.append(String.format(STRING_NAME, "Customer name",
		 							 clientInfo.getFirstName() + " " +
		 							 clientInfo.getLastName()));

		 header.append(String.format(STRING_BAGS, "Number of bags ordered",
		 										  cost.getBagsOrdered()));

		 header.append(String.format(STRING_TOTAL, "Purchase price", "",
		 										   cost.getBagsCost()));
		 return header.toString();
	 }

	 private static String createBoxesInfo(OrderCost boxes)
	 {
		 /*** Local Constants ***/

	 	 final String FORMAT_BOXES = "%30s:%3d%6s: $   %,.2f%n";

		 /*** Local Variables ***/

		 StringBuilder boxesInfo = new StringBuilder();

		 /*** Generate Boxes Information ***/

		 boxesInfo.append(String.format("%n" + FORMAT_STRING + "%n",
		 								"Boxes used"));

		 boxesInfo.append(String.format(FORMAT_BOXES, "Large",
		 								boxes.getLargeBoxes(), "Cost",
		 								boxes.getLargeBoxesCost()));

		 boxesInfo.append(String.format(FORMAT_BOXES, "Medium",
		 								boxes.getMediumBoxes(), "Cost",
		 								boxes.getMediumBoxesCost()));

		 boxesInfo.append(String.format(FORMAT_BOXES, "Small",
		 								boxes.getSmallBoxes(), "Cost",
		 								boxes.getSmallBoxesCost()));

		 boxesInfo.append(String.format("%n%n" + STRING_TOTAL, "Total cost",
		 								"", boxes.getOrderTotal()));
		 return boxesInfo.toString();
	 }

	 private static String createDateInfo()
	 {
		 /*** Local Constants ***/

	 	 final String STRING_DATE = FORMAT_STRING + "%9s%3s, %4s%n";

		 /*** Local Variables ***/

		 LocalDate currentDate = LocalDate.now();
		 LocalDate futureDate  = LocalDate.now().plusWeeks(2);

		 String currentMonth = currentDate.getMonth().toString();
		 String futureMonth  = futureDate.getMonth().toString();

		 StringBuilder dateInfo = new StringBuilder();

		 /*** Correct capitalization on months ***/

		 currentMonth = formatMonth(currentMonth);
		 futureMonth = formatMonth(futureMonth);

		 /*** Generate Date Information ***/

		 dateInfo.append(String.format("%n" + STRING_DATE,
		 							   "Date of order", currentMonth,
		 							   currentDate.getDayOfMonth(),
		 							   currentDate.getYear()));

		 dateInfo.append(String.format(STRING_DATE + "%n",
		 							   "Expected date of arrival",
		 							   futureMonth,
		 							   futureDate.getDayOfMonth(),
		 							   futureDate.getYear()));
		 return dateInfo.toString();
	 }

	 private static String createShippingInfo(ClientInformation clientInfo)
	 {
		 /*** Local Constants ***/

	 	 final String FORMAT_ADDRESS_LINE_1 = "%19s%4s%-1s%n";
	 	 final String FORMAT_ADDRESS_LINE_2 = "%23s%s";

		 /*** Local Variables ***/

		 String addressLine2 = null;

		 StringBuilder shippingInfo = new StringBuilder();

		 /*** Create city, state, zip line ***/

		 addressLine2 = clientInfo.getCity() + ", " + clientInfo.getState() +
		 				" " + clientInfo.getZipCode();

		 /*** Generate Shipping Address ***/

		 shippingInfo.append(String.format(FORMAT_ADDRESS_LINE_1,
		 					 "Shipping address:", "",
		 					 clientInfo.getStreetAddress()));

		 shippingInfo.append(String.format(FORMAT_ADDRESS_LINE_2,
		 					 "", addressLine2));

		 return shippingInfo.toString();
	 }

	 /*** Class Helper Methods ***/

	 private static String formatMonth(String uppercaseMonth)
	 {
		 /*** Local Variables ***/

		 String month = null;

		 month = uppercaseMonth.substring(0,1) +
		 		 uppercaseMonth.substring(1).toLowerCase();

		 return month;
	 }

	 /*** Application ***/

	 public static void main(String[] args)
	 {
		 OrderCost cost = new OrderCost(31);
		 ClientInformation info = new ClientInformation("first", "last",
		 						  					    "1234 street road",
		 						  					    "city", "state",
		 						  					    "zip");

		 System.out.println(createInvoice(info, cost));
	 }
 }