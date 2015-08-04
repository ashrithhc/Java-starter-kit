package supplierManagement.project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Supplier {
	
	public Supplier(int supplier_ID, String supplier_name, int item,
			int city, Date contract_date) {
		super();
		this.supplier_ID = supplier_ID;
		this.supplier_name = supplier_name;
		this.item = item;
		this.city = city;
		this.contract_date = contract_date;
	}
	public Supplier(int supplier_ID) {
		// TODO Auto-generated constructor stub
		this.supplier_ID = supplier_ID;
	}
	private String supplier_name;
	Date contract_date;
	private int supplier_ID, city, item;
	
	public int getSupplier_ID() {
		return supplier_ID;
	}
	public void setSupplier_ID(int supplier_ID) {
		this.supplier_ID = supplier_ID;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public Date getContract_date() {
		return contract_date;
	}
	public void setContract_date(String contract_date) {
		this.contract_date = Display.getDate(contract_date);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Supplier other = (Supplier) obj;

		if (supplier_ID == other.getSupplier_ID())
			return true;
		return false;
	}
	
/*	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Supplier other = (Supplier) obj;
		if (supplier_ID == null) {
			if (other.supplier_ID != null)
				return false;
		} else if (!supplier_ID.equals(other.supplier_ID))
			return false;
		return true;
	}*/
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Supplier ID is " + supplier_ID;
	}
}