package supplierManagement.project;

import java.util.Date;

public interface ServiceInterface {
//	String registerUser(User user);
	
	public boolean check_admin(String uname);
	
	public boolean validate_user(User user);
	
	public boolean add_supplier(Supplier sup);

	public boolean modify_supplier(int supplier_ID, String name);

	public boolean delete_supplier(int supplier_ID);

	public String view(String choice);
	
	public String supplier_list();
	
	public String item_list();
	
	public String get_itemsOf(int supplier_ID);
	
	public String get_supplierOf(int item_ID);
}