/*******************************************************************
 *
 * File:		OrderBoxes.java
 *
 * Author: 		Dan Gerstl
 *
 * Date:		04/28/2018
 *
 * Purpose:		Project 1
 *
 * Description: Object for determining and tracking the amount of boxes
 *			    needed
 *
 * Comment:		NA
 *
 *********************************************************************/

 public class OrderBoxes
 {
	 /*** Class Constants ***/

	 public final int MINIMUM_BAGS_ORDERED = 0;
	 public final int MAXIMUM_BAGS_ORDERED = 9999;

	 private final int DEFAULT_BAGS_ORDERED = 0;
	 private final int DEFAULT_LARGE_BOXES  = 0;
	 private final int DEFAULT_MEDIUM_BOXES = 0;
	 private final int DEFAULT_SMALL_BOXES  = 0;

	 /*** Class Variables ***/

	 private int bagsOrdered = 0;
	 private int largeBoxes  = 0;
	 private int mediumBoxes = 0;
	 private int smallBoxes  = 0;

	 /*** Constructors ***/

	 public OrderBoxes(int bagsOrdered)
	 {
		 this.setBagsOrdered(bagsOrdered);
		 this.setLargeBoxes(DEFAULT_LARGE_BOXES);
		 this.setMediumBoxes(DEFAULT_MEDIUM_BOXES);
		 this.setSmallBoxes(DEFAULT_SMALL_BOXES);
	 }

	 /*** Class Methods - Transformers/Mutators ***/

	 public void setBagsOrdered(int bags)
	 {
		 if (bags >= MINIMUM_BAGS_ORDERED && bags <= MAXIMUM_BAGS_ORDERED)
		 	this.bagsOrdered = bags;
		 else
		 	this.bagsOrdered = DEFAULT_BAGS_ORDERED;
	 }

	 private void setLargeBoxes(int boxes)
	 {
		 if (boxes >= 0)
		 	this.largeBoxes = boxes;
		 else
		 	this.largeBoxes = DEFAULT_LARGE_BOXES;
	 }

	 private void setMediumBoxes(int boxes)
	 {
		 if (boxes >= 0)
		 	this.mediumBoxes = boxes;
		 else
		 	this.mediumBoxes = DEFAULT_MEDIUM_BOXES;
	 }

	 private void setSmallBoxes(int boxes)
	 {
		 if (boxes >= 0)
			this.smallBoxes = boxes;
		 else
		 	this.smallBoxes = DEFAULT_SMALL_BOXES;
	 }

	 public void calculateBoxesNeeded()
	 {
		 /*** Local Constants ***/

	     final int BAGS_IN_SMALL_BOX   = 5;
	     final int BOXES_IN_BIGGER_BOX = 2;

		 /*** Local Variables ***/

		 int bags = this.bagsOrdered;

		 while (bags > 0)
		 {
			 this.smallBoxes = this.smallBoxes + 1;
			 bags = bags - BAGS_IN_SMALL_BOX;
		 }

		 while (this.smallBoxes >= BOXES_IN_BIGGER_BOX)
		 {
			 this.mediumBoxes = this.mediumBoxes + 1;
			 this.smallBoxes = this.smallBoxes - BOXES_IN_BIGGER_BOX;
		 }

		 while (this.mediumBoxes >= BOXES_IN_BIGGER_BOX)
		 {
			 this.largeBoxes = this.largeBoxes + 1;
			 this.mediumBoxes = this.mediumBoxes - BOXES_IN_BIGGER_BOX;
		 }
	 }

	 /*** Class Methods - Accessors ***/

	 public int getBagsOrdered()
	 {
		 return this.bagsOrdered;
	 }

	 public int getLargeBoxes()
	 {
		 return this.largeBoxes;
	 }

	 public int getMediumBoxes()
	 {
		 return this.mediumBoxes;
	 }

	 public int getSmallBoxes()
	 {
		 return this.smallBoxes;
	 }

	 @Override
	 public String toString()
	 {
		 return "Bags ordered: " + this.getBagsOrdered() + " " +
		 		"Large boxes: "  + this.getLargeBoxes()  + " " +
		 		"Medium boxes: " + this.getMediumBoxes() + " " +
		 		"Small boxes: "  + this.getSmallBoxes()  + " " ;
	 }

	 /*** Application ***/

	 public static void main(String[] args)
	 {
		 OrderBoxes tester = new OrderBoxes(36);

		 System.out.println(tester.toString());

		 System.out.println(" Calculating optimal boxes...");
		 tester.calculateBoxesNeeded();

		 System.out.println(tester.toString());
	 }
 }