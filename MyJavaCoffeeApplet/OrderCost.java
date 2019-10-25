/*******************************************************************
 *
 * File:		OrderCost.java
 *
 * Author: 		Dan Gerstl
 *
 * Date:		04/28/2018
 *
 * Purpose:		Project 1
 *
 * Description: Object for calculating and holding cost of the order
 *
 * Comment:		NA
 *
 *********************************************************************/

 public class OrderCost extends OrderBoxes
 {
	 /*** Class Constants ***/

	 private final double DEFAULT_SUBTOTAL    = 0.0;
	 private final double DEFAULT_ORDER_TOTAL = 0.0;

	 /*** Local Variables ***/

	 private double bagsCost 		= 0.0;
	 private double largeBoxesCost  = 0.0;
	 private double mediumBoxesCost = 0.0;
	 private double smallBoxesCost  = 0.0;
	 private double orderTotal		= 0.0;

	 /*** Constructors ***/

	 public OrderCost(int bagsOrdered)
	 {
		 super(bagsOrdered);
		 this.setBagsCost(DEFAULT_SUBTOTAL);
		 this.setLargeBoxesCost(DEFAULT_SUBTOTAL);
		 this.setMediumBoxesCost(DEFAULT_SUBTOTAL);
		 this.setSmallBoxesCost(DEFAULT_SUBTOTAL);
		 this.orderTotal = DEFAULT_ORDER_TOTAL;
	 }

	 /*** Class Methods - Transformers/Mutators ***/

	 private void setBagsCost(double total)
	 {
		 if (total >= 0.0)
		 	this.bagsCost = total;
		 else
		 	this.bagsCost = DEFAULT_SUBTOTAL;
	 }

	 private void setLargeBoxesCost(double total)
	 {
		 if (total >= 0.0)
			this.largeBoxesCost = total;
		 else
			this.largeBoxesCost = DEFAULT_SUBTOTAL;
	 }

	 private void setMediumBoxesCost(double total)
	 {
		 if (total >= 0.0)
			this.mediumBoxesCost = total;
		 else
			this.mediumBoxesCost = DEFAULT_SUBTOTAL;
	 }

	 private void setSmallBoxesCost(double total)
	 {
		 if (total >= 0.0)
			this.smallBoxesCost = total;
		 else
			this.smallBoxesCost = DEFAULT_SUBTOTAL;
	 }

	 private double calculateSubtotal(int item, double cost)
	 {
		 /*** Local Variables ***/

		 double subtotal = 0.0;

		 subtotal = item * cost;

		 return subtotal;
	 }

	 public void calculateTotal()
	 {
		 /*** Local Constants ***/

	 	 final double BAG_COST		  = 5.50;
	     final double LARGE_BOX_COST  = 1.80;
	     final double MEDIUM_BOX_COST = 1.00;
	     final double SMALL_BOX_COST  = 0.60;

	     /*** Calculate Boxes ***/

	     this.calculateBoxesNeeded();

		 /*** Calculate Subtotals ***/

		 this.setBagsCost(calculateSubtotal(this.getBagsOrdered(),
		 									BAG_COST));

		 this.setLargeBoxesCost(calculateSubtotal(this.getLargeBoxes(),
		 										  LARGE_BOX_COST));

		 this.setMediumBoxesCost(calculateSubtotal(this.getMediumBoxes(),
		 										   MEDIUM_BOX_COST));

		 this.setSmallBoxesCost(calculateSubtotal(this.getSmallBoxes(),
		 										  SMALL_BOX_COST));
		 /*** Calculate Total ***/

		 this.orderTotal = this.bagsCost + this.largeBoxesCost +
		 				   this.mediumBoxesCost + this.smallBoxesCost;
	 }

	 /*** Class Methods - Accessors ***/

	 public double getBagsCost()
	 {
		 return this.bagsCost;
	 }

	 public double getLargeBoxesCost()
	 {
		 return this.largeBoxesCost;
	 }

	 public double getMediumBoxesCost()
	 {
		 return this.mediumBoxesCost;
	 }

	 public double getSmallBoxesCost()
	 {
		 return this.smallBoxesCost;
	 }

	 public double getOrderTotal()
	 {
		 return this.orderTotal;
	 }

	 @Override
	 public String toString()
	 {
		 return "Bags ordered: "      + this.getBagsOrdered()     + " " +
		 		"Large boxes: "  	  + this.getLargeBoxes()      + " " +
		 		"Medium boxes: "      + this.getMediumBoxes()     + " " +
		 		"Small boxes: "       + this.getSmallBoxes()      + " " +
		 		"Bags cost: "		  + this.getBagsCost()		  + " " +
		 		"Large boxes cost: "  + this.getLargeBoxesCost()  + " " +
		 		"Medium boxes cost: " + this.getMediumBoxesCost() + " " +
		 		"Small boxes cost: "  + this.getSmallBoxesCost()  + " " +
		 		"Order total : " 	  + this.getOrderTotal()	  + " " ;
	 }

	 /*** Application ***/

	 public static void main(String[] args)
	 {
		 OrderCost tester = new OrderCost(10);

		 System.out.println(tester.toString());

		 System.out.println("\n Calculating order total...\n");
		 tester.calculateTotal();

		 System.out.println(tester.toString());
	 }
 }