package supplierManagement.project;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class Presentation
{
	private static ServiceInterface s_obj = new Service();
	
	private static Logger log = Logger.getLogger("Logging");
	private static String username;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int choice = 0;
		do {
			choice = menu1();
			if(choice == 1) login();
			else if (choice != 0)
			{
				Display.display("Invalid Choice!");
				log.info("Choice Other than Exit or Login Entered");
			}
		} while (choice != 0); // exit is done		
	}

	private static void login() {
		// TODO Auto-generated method stub
		String user_id = Display.getString("Enter User ID");
		String password = Display.getString("Enter Password");
		username = user_id;
		
		log.info("User_ID entered is " +user_id);
		log.info("Password entered is " + password);
		
		User user = new User(user_id, password);
		boolean validate = s_obj.validate_user(user);
		log.info("Validate User result : " + validate);
		
		if(!validate) Display.display("Invalid UserID or Password!");
		else
			guider(Menu());
	}

	private static void guider(int menu) {
		// TODO Auto-generated method stub
		log.info("Menu Option : "+ menu);

		if(menu == 1) add_supplier();
		else if(menu == 2) modify_supplier();
		else if(menu == 3) delete_supplier();
		else if(menu == 4) view();
		else if(menu != 0){
			Display.display("Invalid Choice!");
			guider(Menu());
		}
	}

	private static void view() {
		// TODO Auto-generated method stub
		String options =
				"\n Choose to List by : " +
				"\n 1. Suppliers " +
				"\n 2. Items";
		String choice = Display.getString(options);
		log.info("View list by : "+choice);
		int ID_choice = Display.getNumber(s_obj.view(choice));
		log.info("ID selected : "+ID_choice);

		String disp_list = "Invalid Choice";
		if(choice.equals("1")) disp_list = s_obj.get_itemsOf(ID_choice);
		else if((choice.equals("2"))) disp_list = s_obj.get_supplierOf(ID_choice);
		
		Display.display(disp_list);
		
		guider(Menu());
	}

	private static void delete_supplier() {
		// TODO Auto-generated method stub

		if(!s_obj.check_admin(username))
		{
			Display.display("You are not Authorised, Contact the Admin!");
			log.info("User not Authorised to modify");
			return;
		}
		
		int choice = Display.getNumber("Enter Supplier ID\n" +s_obj.supplier_list());
		log.info("Supplier ID to be deleted " + choice);

		boolean check = s_obj.delete_supplier(choice);
		log.info("Supplier Deletion : "+check);
		
		if(!check) Display.display("Deletion Failed");
		else Display.display("Deletion Successful");
		guider(Menu());
	}

	private static void modify_supplier() {
		// TODO Auto-generated method stub
		String new_name;

		if (!s_obj.check_admin(username))
		{
			Display.display("You are not Authorised, Contact the Admin!");
			log.info("User not Authorised to modify");
			return;
		}

		int choice = Display.getNumber("Enter Supplier ID\n" + s_obj.supplier_list());
		log.info("Supplier ID to be modified " + choice);

		new_name = Display.getString("Enter New Supplier Name");

		log.info("Sending (ID, Name) as " + choice + " " + new_name);
		boolean check = s_obj.modify_supplier(choice, new_name);
		log.info("Supplier Modification : "+check);

		if(!check) Display.display("Modification Failed");
		else Display.display("Modification Successful");
		guider(Menu());
	}

	private static void add_supplier() {
		// TODO Auto-generated method stub
		String city_list =
				"\n Enter the City Number : " +
				"\n 1. Bangalore " +
				"\n 2. Mysore " +
				"\n 3. Mangalore " +
				"\n 4. Hyderabad " +
				"\n 5. Mumbai";
		
		String item_list = s_obj.item_list();
		
		int supplier_id = Display.getNumber("Enter Supplier ID");
		String supplier_name = Display.getString("Enter Supplier Name");
		int item = Display.getNumber(item_list);
		int city = Display.getNumber(city_list);
		String format = "dd.MM.YYYY";
		String contract_date = Display.getString("Enter Contract expiry Date as "+ format);
		Date c_date = Display.getDate(contract_date);
		if(c_date ==null)
		{
			Display.display("Invalid Date Format!");
			log.info("Invalid Date format entered");
			guider(Menu());
//			return;
		}
		
		Supplier sup = new Supplier(supplier_id, supplier_name, item, city, c_date);
		log.info("Supplier Info Entered :");
		log.info(supplier_id + " " + supplier_name + " " + item + " " + city + " " + contract_date);
		boolean check = s_obj.add_supplier(sup);
		log.info("Supplier Addition : "+check);
		if(!check) Display.display("Supplier Not Added!");
		else Display.display("Successfully Added!");
		guider(Menu());
	}

	private static int Menu() {
		// TODO Auto-generated method stub
		String options =
				"\n Choose Next Action : " +
				"\n 1. Add " +
				"\n 2. Modify " +
				"\n 3. Delete " +
				"\n 4. View " +
				"\n 0. Logout";
		return Display.getNumber(options);
	}

	private static int menu1() {
		// TODO Auto-generated method stub
		
		String options =
			"\n 1. Login " +
			"\n 0. Exit";
		return Display.getNumber(options);
	}

 
}