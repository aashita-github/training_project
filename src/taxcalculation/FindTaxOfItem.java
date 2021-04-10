package taxcalculation;

import Model.Item;
import java.util.ArrayList;
import java.util.Scanner;
import Model.Item;

/**
 * 
 * @author aashita
 *
 */

public class FindTaxOfItem {
	// Main class to execute input/output functions and print details
	private static Scanner scanObj = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Item> itemList = new ArrayList<Item>();
		char op;

		do {
			Item itemObject = ScanValuesForItem();
			Item itemObjectWithTax = TaxCalculation.calculateTaxForItem(itemObject);
			if (itemObjectWithTax != null)
				itemList.add(itemObjectWithTax);
			System.out.println("Do you want to enter details of any other item (y/n):");
			op = scanObj.nextLine().charAt(0);

		} while (op == 'y' || op == 'Y');

		Item item = new Item();
		for (Item d : itemList) {
			// to iterate over array list
			item.printItemDetails(d);
			System.out.println();

		}

	}

	/**
	 * 
	 * @return itemObject
	 */
	public static Item ScanValuesForItem() {
		// To scan input from users
		Item itemObject = new Item();
		System.out.println("Enter Name");
		String name = "";
		int count = 0;
		do {
			// do-while loop to check if item name is in alphabets and to make sure it is
			// entered by user.
			count++;
			if (count > 1 && !name.isEmpty())
				System.out.println("Enter a valid item");
			else if (count > 1 && name.isEmpty())
				System.out.println("Entering item name is mandatory!");
			name = scanObj.nextLine();

		} while (!name.matches("[A-Za-z]*") || name.isEmpty());
		itemObject.setName(name);

		System.out.println("Enter Price");
		try {
			// try-catch block to handle string inputs for expected int inputs
			itemObject.setPrice(Integer.parseInt(scanObj.nextLine()));
		} catch (NumberFormatException e) {
			System.out.println("Enter a number!");
			itemObject.setPrice(Integer.parseInt(scanObj.nextLine()));

		}
		System.out.println("Enter Quantity");
		try {
			// try-catch block to handle string inputs for expected int inputs
			itemObject.setQuantity(Integer.parseInt(scanObj.nextLine()));
		} catch (NumberFormatException e) {
			System.out.println("Enter a number!");
			itemObject.setQuantity(Integer.parseInt(scanObj.nextLine()));
		}
		System.out.println("Enter Type");

		String ty = scanObj.nextLine().toLowerCase();
		if (ty.equals("raw") || ty.equals("manufactured") || ty.equals("imported")) {
			// if-else to check if type of item is either raw/manufactured/imported.
			itemObject.setType(ty);

		} else {
			System.out.println("Enter type either raw/manufactured/imported");
			ty = scanObj.nextLine().toLowerCase();
			itemObject.setType(ty);

		}

		return itemObject;

	}
}
