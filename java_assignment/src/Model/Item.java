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

	public void printItemDetails() {
		System.out.println("Name: " + this.getName());
		System.out.println("Item Price: " + this.getPrice());
		System.out.println("Sales Tax Liability Per Item: " + this.tax);
		System.out.println("Final Price Per Item: " + (this.tax + this.getPrice()));
		System.out.println("Final Price of " + this.getQuantity()+" "+this.getName()+"s is "+this.getQuantity() * (this.tax + this.getPrice()));
	}

}
