package supplierManagement.project;

public class Item {
	
	private String item_name;
	private int item_ID;

	public Item(int item_ID, String item_name) {
		this.item_ID = item_ID;
		this.item_name = item_name;
	}

	public int getItem_ID() {
		return item_ID;
	}

	public void setItem_ID(int item_ID) {
		this.item_ID = item_ID;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
}