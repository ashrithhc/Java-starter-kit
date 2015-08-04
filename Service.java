package supplierManagement.project;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

public class Service implements ServiceInterface
{
	private static Logger log = Logger.getLogger("Logging");
	private static DataInterface d = new Data();
	
	@Override
	public boolean validate_user(User user)
	{
		return d.validate_user(user);
	}

	@Override
	public boolean add_supplier(Supplier sup)
	{
		// TODO Auto-generated method stub
		try {
			log.info("Entered add_supplier in service");
			d.add_supplier(sup);
			log.info("Returning Successful addition to presentation!");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("Returning error due to ID violation from Service!");
			return false;
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			log.error("Returning error due to Date field from Service!");
			return false;
		}
	}

	@Override
	public boolean modify_supplier(int supplier_ID, String name)
	{
		// TODO Auto-generated method stub
		try {
			log.info("Entered modify_supplier in service with ("+supplier_ID+","+name+"");
			d.modify_supplier(supplier_ID, name);
			log.info("Returning Successful modification to presentation!");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("Returning Failure in modification to presentation!");
			return false;
		}
	}

	@Override
	public boolean delete_supplier(int supplier_ID)
	{
		// TODO Auto-generated method stub
		try {
			log.info("Entered delete_supplier in service");
			d.delete_supplier(supplier_ID);
			log.info("Returning Successful deletion to presentation!");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("Returning Failure in deletion to presentation!");
			return false;
		}
	}

	@Override
	public String view(String choice)
	{
		// TODO Auto-generated method stub
		Service s = new Service();
		log.info("Entered view in service");
		if (choice.equals("1")) return s.supplier_list();
		else if (choice.equals("2")) return s.item_list();
		return "Not a Valid Choice";
	}

	@Override
	public String supplier_list()
	{
		// TODO Auto-generated method stub
		List <Supplier> sup_list = new ArrayList<Supplier>();
		sup_list = d.get_supplier_list();
		
		String S = "List Of Suppliers :";
		for(Supplier supplier_obj : sup_list)
		{
			S = S + "\n" + supplier_obj.getSupplier_ID() + " " + supplier_obj.getSupplier_name();
		}
		
		return S;
	}

	@Override
	public String item_list()
	{
		// TODO Auto-generated method stub
		List <Item> item_list = new ArrayList<Item>();
		item_list = d.get_items_list();
		
		String S = "List Of Items :";
		for(Item item_obj : item_list)
		{
			S = S + "\n" + item_obj.getItem_ID() + " " + item_obj.getItem_name();
		}
		
		return S;
	}

	@Override
	public boolean check_admin(String uname) {
		// TODO Auto-generated method stub
		if (uname.equals("admin")) return true;
		return false;
	}

	@Override
	public String get_supplierOf(int item_ID)
	{
		// TODO Auto-generated method stub
		List <Supplier> sup_list = new ArrayList<Supplier>();
		sup_list = d.get_supplierOf(item_ID);
		
		log.info("Supplier List of selected item Received");
		
		String S = "Suppliers Supplying the selected Item :";
		for (Supplier sup_obj : sup_list)
		{
			S = S + "\n" + sup_obj.getSupplier_ID() + " " + sup_obj.getSupplier_name();
		}

		log.info("Returning Sup_list String to presentation");
		return S;
	}

	@Override
	public String get_itemsOf(int supplier_ID)
	{
		// TODO Auto-generated method stub
		List <Item> item_list = new ArrayList<Item>();
		item_list = d.get_itemsOf(supplier_ID);
		
		log.info("Item List of selected Supplier Received");
		
		String S = "List Of Items Supplied :";
		for(Item item_obj : item_list)
		{
			S = S + "\n" + item_obj.getItem_ID() + " " + item_obj.getItem_name();
		}
		
		log.info("Returning Item_list String to presentation");
		return S;
	}

/*	public static void main(String[] args)
	{
		ServiceInterface s_obj = new Service();
		
		boolean is_admin = s_obj.check_admin("admin");
		
		User user = new User("admin", "admin");
		boolean proper_user = s_obj.validate_user(user);
		
		Supplier sup = new Supplier("9", "Facebook", 3, 4, "12.03.2024");
		boolean check = s_obj.add_supplier(sup);

		check = s_obj.modify_supplier("1", "Name Changed");

		check = s_obj.delete_supplier("2");

		s_obj.view("1");
		
		String s_list = s_obj.supplier_list();
		
		String i_list = s_obj.item_list();
		
		i_list = s_obj.get_itemsOf("1");
		
		s_list = s_obj.get_supplierOf(1);

		Date d = s_obj.getDate("12.03.2024");
	}
*/	
}
