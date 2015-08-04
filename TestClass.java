package supplierManagement.project;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

	/**
	 * @param args
	 */
	private static List<Supplier> suppliers =new ArrayList<Supplier>(); //act like database now

	static
	{
		suppliers.add(new Supplier(1, "Birla", 3, 4, Display.getDate("12.03.2024")));
		suppliers.add(new Supplier(2, "Tata", 4, 1, Display.getDate("01.11.2020")));
		suppliers.add(new Supplier(3, "ACC", 2, 5, Display.getDate("09.05.2016")));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int id = Display.getNumber("Enter Supplier ID");
		Supplier s = new Supplier(id);

		int i = suppliers.indexOf(id);
		System.out.println(id +" = " + i);

		Supplier sup = suppliers.get(suppliers.indexOf(s));
		Display.display(sup.getSupplier_name());
	}

}
