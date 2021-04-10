package Model;

/**
 * @author aashita
 *
 */
public class Item {
	// Item Model having attributes name,price,quantity,type of item.
	private String name;
	private int price;
	private int quantity;
	private String type;
	private double tax = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type.toLowerCase();

	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	/**
	 * 
	 * @param item method will print all the attributes of item object
	 * 
	 */

	public void printItemDetails(Item item) {// to display results on console
		System.out.println("Name: " + item.getName());
		System.out.println("Item Price: " + item.getPrice());
		System.out.println("Sales Tax Liability: " + item.tax);
		System.out.println("Final Price: " + (item.tax + item.getPrice()));
	}

}
