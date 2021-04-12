package taxcalculationservices;

import Model.Item;

/**
 * @author aashita
 *
 */
public class TaxCalculation {
	// Class to calculate tax on implied item
	double tax = 0;

	/**
	 * 
	 * @param itemObject
	 * @return
	 */
	public static Item calculateTaxForItem(Item itemObject) {
		// Method to check type of item user has input and apply tax rules accordingly
		String ty = itemObject.getType();
		if (ty.equals(ItemTypeConstants.Raw)) {
			return calculateRawTax(itemObject);
		}

		else if (ty.equals(ItemTypeConstants.Manufactured)) {
			return calculateManufacturedTax(itemObject);
		} else if (ty.equals(ItemTypeConstants.Imported)) {
			return calculateImportedTax(itemObject);
		}
		return null;

	}

	/**
	 * 
	 * @param itemObject
	 * @return itemObject of raw type
	 */
	public static Item calculateRawTax(Item itemObject) {
		// function to calculate tax for raw items
		double tax = 0.125 * itemObject.getPrice();
		itemObject.setTax(tax);
		return itemObject;
	}

	/**
	 * 
	 * @param itemObject
	 * @return item Object of manufactured item type
	 */
	public static Item calculateManufacturedTax(Item itemObject) {
		// function to calculate tax for manufactured items
		double tax = 0.125 * itemObject.getPrice() + 0.02 * (itemObject.getPrice() + (0.125 * itemObject.getPrice()));
		itemObject.setTax(tax);
		return itemObject;
	}

	/**
	 * 
	 * @param itemObject
	 * @return item Object of imported item type to calculateTaxForItem
	 */
	public static Item calculateImportedTax(Item itemObject) {
		// function to calculate tax for imported items
		double duty = 0.1 * itemObject.getPrice();
		double itemTax = 0.125 * itemObject.getPrice();
		double total = duty + itemTax + itemObject.getPrice();
		double surcharge = (total <= 100) ? 5 : (total > 100 && total <= 200 ? 10 : 0.05 * total);
		double tax = 0.1 * itemObject.getPrice() + surcharge;
		itemObject.setTax(tax);
		return itemObject;
	}
}
