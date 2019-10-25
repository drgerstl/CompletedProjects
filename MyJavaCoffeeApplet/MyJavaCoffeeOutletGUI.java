/********************************************************************
 *
 * File:		MyJavaCoffeeOutletGUI.java
 *
 * Author: 		Dan Gerstl
 *
 * Date:		04/29/2018
 *
 * Purpose:		Project 1
 *
 * Description: GUI interface to obtain user information and order amount
 *				and generate an invoice with provided information.
 *
 * Comment:		NA
 *
 *********************************************************************/

 import java.util.*;
 import java.lang.*;
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;

 public class MyJavaCoffeeOutletGUI implements ActionListener
 {
	 /*** Class Variables ***/

	 JButton jbuCreateInvoice = null;
	 JButton jbuClear  		  = null;
	 JButton jbuPrint 		  = null;
	 JButton jbuExit  		  = null;

	 JTextField jteFirstName     = null;
	 JTextField jteLastName	     = null;
	 JTextField jteStreetAddress = null;
	 JTextField jteCity			 = null;
	 JTextField jteZipCode		 = null;
	 JTextField jteBagsToOrder   = null;

	 JComboBox<String> jcoState = null;

	 JTextArea jtaInvoice = null;

	 /*** Constructor ***/

	 public MyJavaCoffeeOutletGUI(String title)
	 {
		 /*** Local Variables ***/

		 JFrame jfrCoffeeOutlet = null;
		 Container c = null;

		 /*** Instantiate Objects ***/

		 jfrCoffeeOutlet = new JFrame(title);

		 /*** Get JFrame address ***/

		 c = jfrCoffeeOutlet.getContentPane();

		 /*** Set attributes for containers ***/

		 setJFrameAttributes(jfrCoffeeOutlet);
		 c.setBackground(Color.lightGray);

		 /*** Build GUI ***/

		 buildGUI(c);
	 }

	 /*** GUI Methods ***/

	 private void setJFrameAttributes(JFrame myGUI)
	 {
		 /*** Set Size ***/

		 myGUI.setSize(510, 575);

		 /*** Set Colors ***/

		 myGUI.setBackground(Color.lightGray);

		 /*** Set Layout ***/

		 myGUI.setLayout(new GridBagLayout());

		 myGUI.setVisible(true);
	 }

	 private void buildGUI(Container c)
	 {
		 /*** Local Variables ***/

		 JPanel jpaName    = null;
		 JPanel jpaAddress = null;
		 JPanel jpaOrder   = null;
		 JPanel jpaButtons = null;
		 JPanel jpaInvoice = null;

		 GridBagConstraints constraints = null;

		 /*** Instantiate Components ***/

		 jpaName 	= createNamePanel();
		 jpaAddress = createAddressPanel();
		 jpaOrder   = createOrderPanel();
		 jpaButtons = createButtonsPanel();
		 jpaInvoice = createInvoicePanel();

		 constraints = new GridBagConstraints();

		 /*** Set Constraints ***/

		 constraints.insets  = new Insets(2,5,2,5);
		 constraints.anchor  = GridBagConstraints.FIRST_LINE_START;
		 constraints.fill    = GridBagConstraints.BOTH;
		 constraints.gridx   = 0;
		 constraints.gridy   = 0;
		 constraints.weightx = 0.5;
		 constraints.weighty = 0.0;

		 /*** Add Containers ***/

		 c.add(jpaName, constraints);

		 constraints.insets  = new Insets(0,0,0,0);
		 constraints.gridy = 1;
		 c.add(jpaAddress, constraints);

		 constraints.gridy = 2;
		 c.add(jpaOrder, constraints);

		 constraints.gridy = 3;
		 c.add(jpaButtons, constraints);

		 constraints.gridy = 4;
		 constraints.weighty = 1.0;
		 c.add(jpaInvoice, constraints);
	 }

	 private JPanel createNamePanel()
	 {
		 /*** Local Variables ***/

		 JPanel jpaName = null;

		 JLabel jlaCustomerName = null;
		 JLabel jlaSpacer       = null;
		 JLabel jlaFirstName 	= null;
		 JLabel jlaLastName		= null;

		 /*** Instantiate Container ***/

		 jpaName = new JPanel();

		 /*** Set Attributes ***/

		 jpaName.setBackground(Color.lightGray);
		 jpaName.setLayout(new GridLayout(0, 2, 5, 0));

		 /*** Instantiate Components ***/

		 jlaCustomerName = new JLabel("Customer name: ");

		 jlaSpacer    	 = new JLabel("");

		 jlaFirstName 	 = new JLabel("First name");
		 jteFirstName 	 = new JTextField(20);

		 jlaLastName  	 = new JLabel("Last name");
		 jteLastName     = new JTextField(20);

		 /*** Add components to container ***/

		 jpaName.add(jlaCustomerName);
		 jpaName.add(jlaSpacer);

		 jpaName.add(jteFirstName);
		 jpaName.add(jteLastName);

		 jpaName.add(jlaFirstName);
		 jpaName.add(jlaLastName);

		 return jpaName;
	 }

	 private JPanel createAddressPanel()
	 {
		 /*** Local Constants ***/

		 final String[] STATES = {"", "AL", "AK", "AZ", "AR", "CA", "CO",
		 						  "CT", "DE", "FL", "GA", "HI", "ID", "IL",
		 						  "IN", "IA", "KS", "KY", "LA", "ME", "MD",
		 						  "MA", "MI", "MN", "MS", "MO", "MT", "NE",
		 						  "NV", "NH", "NJ", "NM", "NY", "NC", "ND",
		 						  "OH", "OK", "OR", "PA", "RI", "SC", "SD",
		 						  "TN", "TX", "UT", "VT", "VA", "WA", "WV",
		 						  "WI", "WY"};

		 /*** Local Variables ***/

		 JPanel jpaAddress  = null;

		 JLabel jlaShippingAddress = null;
		 JLabel jlaStreetAddress   = null;
		 JLabel jlaCity			   = null;
		 JLabel jlaState		   = null;
		 JLabel jlaZipCode		   = null;
		 JLabel jlaBagsOrdered     = null;

		 GridBagConstraints constraints = null;

		 /*** Instantiate Container ***/

		 jpaAddress = new JPanel();

		 /*** Set Container Attributes ***/

		 jpaAddress.setBackground(Color.lightGray);
		 jpaAddress.setLayout(new GridBagLayout());

		 /*** Instantiate Components ***/

		 constraints = new GridBagConstraints();

		 jlaShippingAddress = new JLabel("Shipping Address: ");

		 jlaStreetAddress = new JLabel("Street Address");
		 jteStreetAddress = new JTextField(20);

		 jlaCity = new JLabel("City");
		 jteCity = new JTextField(20);

		 jlaState = new JLabel("State");

		 jcoState = new JComboBox<>(STATES);
		 jcoState.setEditable(false);

		 jlaZipCode = new JLabel("Zip code");
		 jteZipCode = new JTextField(10);

		 /*** Set component attributes and add to container ***/

		 constraints.insets  = new Insets(2,5,2,5);
		 constraints.anchor  = GridBagConstraints.FIRST_LINE_START;
		 constraints.fill    = GridBagConstraints.HORIZONTAL;
		 constraints.gridx   = 0;
		 constraints.gridy   = 0;
		 constraints.weightx = 0.5;
		 constraints.weighty = 0.5;
		 jpaAddress.add(jlaShippingAddress, constraints);

		 constraints.gridx     = 0;
		 constraints.gridy     = 1;
		 constraints.gridwidth = GridBagConstraints.REMAINDER;
		 jpaAddress.add(jteStreetAddress, constraints);

		 constraints.gridx = 0;
		 constraints.gridy = 2;
		 jpaAddress.add(jlaStreetAddress, constraints);

		 constraints.gridwidth = 1;
		 constraints.gridx = 0;
		 constraints.gridy = 3;
		 jpaAddress.add(jteCity, constraints);

		 constraints.gridx = 1;
		 constraints.gridy = 3;
		 jpaAddress.add(jcoState, constraints);

		 constraints.gridx = 2;
		 constraints.gridy = 3;
		 jpaAddress.add(jteZipCode, constraints);

		 constraints.gridx = 0;
		 constraints.gridy = 4;
		 jpaAddress.add(jlaCity, constraints);

		 constraints.gridx = 1;
		 constraints.gridy = 4;
		 jpaAddress.add(jlaState, constraints);

		 constraints.gridx = 2;
		 constraints.gridy = 4;
		 jpaAddress.add(jlaZipCode, constraints);

		 return jpaAddress;
	 }

	 private JPanel createOrderPanel()
	 {
		 /*** Local Variables ***/

		 JPanel jpaOrder 		   = null;

		 JLabel jlaBagsToOrder 	   = null;

		 /*** Instantiate Container ***/

		 jpaOrder = new JPanel();

		 /*** Instantiate Components ***/

		 jlaBagsToOrder = new JLabel("Number of bags to order: ");

		 jteBagsToOrder = new JTextField(9);

		 /*** Set Attributes ***/

		 jpaOrder.setBackground(Color.lightGray);
		 jpaOrder.setLayout(new FlowLayout());

		 /*** Add components to container ***/

		 jpaOrder.add(jlaBagsToOrder);
		 jpaOrder.add(jteBagsToOrder);

		 return jpaOrder;
	 }

	 private JPanel createButtonsPanel()
	 {
		 /*** Local Variables ***/

		 JPanel jpaButtons = null;

		 /*** Instantiate Container ***/

		 jpaButtons = new JPanel();

		 /*** Instantiate Components ***/

		 jbuCreateInvoice = new JButton("Create Invoice");
		 jbuCreateInvoice.addActionListener(this);

		 jbuClear = new JButton("Clear Form");
		 jbuClear.addActionListener(this);

		 jbuPrint = new JButton("Print");
		 jbuPrint.addActionListener(this);

		 jbuExit = new JButton("Exit");
		 jbuExit.addActionListener(this);

		 /*** Set Attributes ***/

		 jpaButtons.setBackground(Color.lightGray);
		 jpaButtons.setLayout(new GridLayout(1, 4, 5, 0));

		 /*** Add components to container ***/

		 jpaButtons.add(jbuCreateInvoice);
		 jpaButtons.add(jbuClear);
		 jpaButtons.add(jbuPrint);
		 jpaButtons.add(jbuExit);

		 return jpaButtons;
	 }

	 private JPanel createInvoicePanel()
	 {
		 /*** Local Variables ***/

		 JPanel jpaInvoice = null;

		 /*** Instantiate Container ***/

		 jpaInvoice = new JPanel();

		 /*** Instantiate Components ***/

		 jtaInvoice = new JTextArea(18,60);

		 /*** Set Attributes ***/

		 jpaInvoice.setBackground(Color.lightGray);

		 jtaInvoice.setEditable(false);
		 jtaInvoice.setFont(new Font("Courier New", Font.PLAIN, 12));

		 /*** Add components to container ***/

		 jpaInvoice.add(jtaInvoice);

		 return jpaInvoice;
	 }

	 /*** Action Event ***/

	 public void actionPerformed( ActionEvent e)
     {
		 /*** Local Variables ***/

		 int bags = 0;

		 String strBags   = null;
		 String firstName = null;
		 String lastName  = null;
		 String address   = null;
		 String city      = null;
		 String state     = null;
		 String zipCode   = null;

		 /*** Exit or Clear ***/

		 if (e.getSource() == jbuExit)
		 {
			 System.exit(0);
		 }

		 else if (e.getSource() == jbuClear)
		 {
			 resetForm();
		 }

		 /*** Get user input ***/

		 strBags   = jteBagsToOrder.getText().trim();
		 firstName = jteFirstName.getText().trim();
		 lastName  = jteLastName.getText().trim();
		 address   = jteStreetAddress.getText().trim();
		 city      = jteCity.getText().trim();
		 state     = jcoState.getSelectedItem().toString();
		 zipCode   = jteZipCode.getText().trim();

		 /*** Remove any additional spaces ***/

		 strBags   = removeExtraSpaces(strBags);
		 firstName = removeExtraSpaces(firstName);
		 lastName  = removeExtraSpaces(lastName);
		 address   = removeExtraSpaces(address);
		 city 	   = removeExtraSpaces(city);
		 zipCode   = removeExtraSpaces(zipCode);

		 /*** Return trimmed text ***/

		 jteBagsToOrder.setText(strBags);
		 jteFirstName.setText(firstName);
		 jteLastName.setText(lastName);
		 jteStreetAddress.setText(address);
		 jteCity.setText(city);
		 jteZipCode.setText(zipCode);

		 /*** Verify Input ***/

		 if (verifyInput(strBags, zipCode))
		 {
			 /*** Get integer value ***/

			 bags = Integer.parseInt(strBags);

			 /*** Instantiate Objects ***/

			 OrderCost order = new OrderCost(bags);
			 ClientInformation client = new ClientInformation(firstName,
			 							    lastName, address, city,
			 							    state, zipCode);
			 /*** Calculate costs ***/

			 order.calculateTotal();

			/*** Create Invoice ***/

		 	if (e.getSource() == jbuCreateInvoice)
		 	{
				 /*** Clear Output ***/

				 clearOutput();

				 /*** Display Invoice ***/

				 jtaInvoice.setText(Invoice.createInvoice(client, order));
			 }

			 else if (e.getSource() == jbuPrint)
			 {
				 /*** Clear Output ***/

				 clearOutput();

				 /*** Print to console ***/

				 System.out.println(Invoice.createInvoice(client,order));
			 }
		 }
		 else
		 {
			 jtaInvoice.setText(" Please verify zip code and bags ordered.");
		 }
	 }

	 /*** Action event helper methods ***/

	 private void resetForm()
	 {
		 /*** Clear Input ***/

		 clearInput();

		 /*** Clear Output ***/

		 clearOutput();

	 }

	 private void clearInput()
	 {
		 jteFirstName.setText("");
		 jteLastName.setText("");
		 jteStreetAddress.setText("");
		 jteCity.setText("");
		 jteZipCode.setText("");
		 jteBagsToOrder.setText("");

		 jcoState.setSelectedIndex(0);
	 }

	 private void clearOutput()
	 {
		 jtaInvoice.setText("");
	 }

	 /*** Validation Methods ***/

	 private boolean verifyInput(String bags, String zipCode)
	 {
		 /*** Local Variables ***/

		 boolean isValid = false;

		 if (verifyIsNumber(bags))
		 {
			 if(ClientInformation.verifyZipCode(zipCode))
			 {
				 isValid = true;
			 }
		 }

		 return isValid;
	 }

	 private boolean verifyIsNumber(String input)
	 {
		 /*** Local Variables ***/

		 boolean isNumber = true;

		 int counter = 0;

		 while (isNumber == true && counter < input.length())
		 {
			 if (!Character.isDigit(input.charAt(counter)))
			 {
				isNumber = false;
			 }
			 counter++;
		 }

		 return isNumber;
	 }

	 private String removeExtraSpaces(String input)
	 {
		 /*** Local Variables ***/

		 String output = input;

		 while (output.indexOf("  ") != -1)
		 {
         	output = output.replace("  ", " ");
		 }

		 return output;
      }

	 /*** Application ***/

	 public static void main(String[] args)
	 {
		 new MyJavaCoffeeOutletGUI("MyJava Coffee Outlet");
	 }
 }