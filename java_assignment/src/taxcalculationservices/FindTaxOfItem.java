package taxcalculationservices;

import Model.Item;
import java.util.ArrayList;
import java.util.Scanner;

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
			// Take input from users
			Item itemObject = ScanValuesForItem();

			// Calculating tax on the Item
			Item itemObjectWithTax = TaxCalculation.calculateTaxForItem(itemObject);

			// The below logic will ask user to enter more than one item
			if (itemObjectWithTax != null)
				itemList.add(itemObjectWithTax);
			System.out.println("Do you want to enter details of any other item (y/n):");
			op = scanObj.nextLine().charAt(0);

		} while (op == 'y' || op == 'Y');

		// to iterate over array list
		for (Item itemObj : itemList) {
			itemObj.printItemDetails();
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
		// do-while loop to check if item name is in alphabets and to make sure it is
		// entered by user.
		do {
			count++;
			if (count > 1 && !name.isEmpty())
				System.out.println("Enter a valid item");
			else if (count > 1 && name.isEmpty())
				System.out.println("Entering item name is mandatory!");
			name = scanObj.nextLine();

		} while (!name.matches("[A-Za-z]*") || name.isEmpty());
		itemObject.setName(name);

		System.out.println("Enter Price");
		while (true) {
			// try-catch block to handle string inputs for expected integer inputs
			try {
				int price = Integer.parseInt(scanObj.nextLine());
				itemObject.setPrice(price);
				break;
			} catch (NumberFormatException e) {
				System.out.println("Enter a number!");
				continue;

			}
		}

		System.out.println("Enter Quantity");
		while (true) {
			// try-catch block to handle string inputs for expected integer inputs
			try {
				int quantity = Integer.parseInt(scanObj.nextLine());
				itemObject.setQuantity(quantity);
				break;

			} catch (NumberFormatException e) {
				System.out.println("Enter a number!");
				continue;
			}
		}

		System.out.println("Enter Type");
		String ty = scanObj.nextLine().toLowerCase();
		while (true) {
			if (ty.equals("raw") || ty.equals("manufactured") || ty.equals("imported")) {
				// if-else to check if type of item is either raw/manufactured/imported.
				itemObject.setType(ty);
				break;

			} else if (ty.isEmpty()) {
				System.out.println("Entering type is Mandatory!");
				ty = scanObj.nextLine().toLowerCase();
				itemObject.setType(ty);

			} else {
				System.out.println("Enter type either raw/manufactured/imported");
				ty = scanObj.nextLine().toLowerCase();
				itemObject.setType(ty);

			}
		}

		return itemObject;

	}
}
