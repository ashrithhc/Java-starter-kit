package supplierManagement.project;


import java.sql.SQLException;
import java.util.List;

public interface DataInterface {

	
	//SQLException primary key is violated, IllegalArgumentException -- database is not coperating
	void storeUserDetailsInDB(User user) throws SQLException,
			IllegalArgumentException;
	
	public boolean validate_user(User user);
	
	public void add_supplier(Supplier sup) throws SQLException;
	
	public void modify_supplier(int supplier_ID, String new_name) throws SQLException;
	
	public void delete_supplier(int supplier_ID) throws SQLException;
	
	public List<Supplier> get_supplier_list();
	
	public List<Item> get_items_list();

	public List<Supplier> get_supplierOf(int item_ID);

	public List<Item> get_itemsOf(int supplier_ID);

}
