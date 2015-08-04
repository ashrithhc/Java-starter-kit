package supplierManagement.project;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

public class Data implements DataInterface
{
	private static Logger log = Logger.getLogger("Logging");
	private static List<User> users =new ArrayList<User>(); //act like database now
	private static List<Supplier> suppliers =new ArrayList<Supplier>(); //act like database now
	private static List<Item> items =new ArrayList<Item>(); //act like database now

	static 
	{
		users.add(new User("admin", "admin"));
		users.add(new User("U1", "password"));
		users.add(new User("S1", "sachin"));
	}
	
	static
	{
		suppliers.add(new Supplier(1, "Birla", 3, 4, Display.getDate("12.03.2024")));
		suppliers.add(new Supplier(2, "Tata", 4, 1, Display.getDate("01.11.2020")));
		suppliers.add(new Supplier(3, "ACC", 2, 5, Display.getDate("09.05.2016")));
	}
	
	static
	{
		items.add(new Item(1, "Cement"));
		items.add(new Item(2, "Bricks"));
		items.add(new Item(3, "Wood"));
		items.add(new Item(4, "Steel"));
		items.add(new Item(5, "Paint"));
	}

	@Override
	public void storeUserDetailsInDB(User user) throws SQLException,
			IllegalArgumentException
	{
		int pos = users.indexOf(user);

		if(  pos > -1)
				throw new SQLException("id already taken");
		users.add(user);
		log.info("User added to Database");
		//storeInRealDatabase();
		System.out.println(users);
	}

	@Override
	public boolean validate_user(User user)
	{
		// TODO Auto-generated method stub
		if ((users.indexOf(user) > -1) && (users.get(users.indexOf(user)).getPassword().equals(user.getPassword())))
			{
			log.info("User Validated");
			return true;
			}
		log.info("Invalid UserID or Password");
		return false;
	}

	@Override
	public void add_supplier(Supplier sup) throws SQLException
	{
		// TODO Auto-generated method stub
		int pos = suppliers.indexOf(sup);
		log.info("Position of supplier : "+pos);

		if(pos > -1)
				throw new SQLException("id already taken");
		if((new Data()).contract_expired(sup.getContract_date()))
				throw new IllegalArgumentException("Date has already expired!");
		suppliers.add(sup);
		log.info("Supplied added!");
		//storeInRealDatabase();
		System.out.println(suppliers);
	}

	private boolean contract_expired(Date contract_date) {
		// TODO Auto-generated method stub
		String format = "dd.MM.YYYY";
		Date cd = new Date();
		
		if(contract_date.before(cd))
			{
			log.info(contract_date+" before current "+cd);
			return true;
			}
		
		log.info("Date after current Date");
		return false;
	}

	@Override
	public void modify_supplier(int supplier_ID, String new_name)
			throws SQLException
	{
		// TODO Auto-generated method stub
		Supplier s = new Supplier(supplier_ID);
		Supplier sup_obj = suppliers.get(suppliers.indexOf(s));
		log.info("Supplier Object : "+sup_obj);
		sup_obj.setSupplier_name(new_name);
		log.info("Supplier modified");
	}

	@Override
	public void delete_supplier(int supplier_ID) throws SQLException
	{
		// TODO Auto-generated method stub
		Supplier s = new Supplier(supplier_ID);
		Supplier sup_obj = suppliers.get(suppliers.indexOf(s));
		log.info("Supplier Object : "+sup_obj);
		suppliers.remove(suppliers.indexOf(sup_obj));		
		log.info("Supplier deleted");
	}

	@Override
	public List<Supplier> get_supplier_list() {
		// TODO Auto-generated method stub
		log.info("Sending Suppliers List to Service");
		return suppliers;
	}

	@Override
	public List<Item> get_items_list() {
		// TODO Auto-generated method stub
		log.info("Sending Items List to Service");
		return items;
	}

	public List<Supplier> get_supplierOf(int item_ID) {
		// TODO Auto-generated method stub
		List<Supplier> sup_list = new ArrayList<Supplier>();
		
		log.info("Entering loop to fetch suppliers of item_ID : "+item_ID);
		for(Supplier sup : suppliers)
		{
			if (sup.getItem() == item_ID)
			{
				log.info(sup.getItem()+" = "+item_ID);
				sup_list.add(sup);
			}
		}
		
		log.info("Returning suppliers of item_ID : "+ item_ID);
		return sup_list;
	}

	@Override
	public List<Item> get_itemsOf(int supplier_ID) {
		// TODO Auto-generated method stub
		List <Item> item_list = new ArrayList<Item>();
		
		log.info("Entering loop to fetch items of supplier_ID : "+supplier_ID);
		for (Supplier sup : suppliers)
		{
			if (sup.getSupplier_ID() == (supplier_ID))
			{
				log.info(sup.getSupplier_ID()+" = "+supplier_ID);
				item_list.add(items.get(sup.getItem()));
			}
		}
		
		log.info("Returning items of supplier_ID : "+ supplier_ID);
		return item_list;
	}

}

