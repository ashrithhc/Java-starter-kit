package supplierManagement.project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

public class Display {
	
	private static Logger log = Logger.getLogger("Logging");

	public static String getString(String messageToDisplay) {
		// TODO Auto-generated method stub
		return JOptionPane.showInputDialog(messageToDisplay);
	}

	public static int getNumber(String hello) {
		// TODO Auto-generated method stub
		return Integer.parseInt(getString(hello));
	}

	public static void display(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, string);
	}

	public static Date getDate(String inp_date)
	{
		// TODO Auto-generated method stub
		String format = "dd.MM.YYYY";
		SimpleDateFormat sd = new SimpleDateFormat(format);
		sd.setLenient(false);
		try {
			Date contract_date = sd.parse(inp_date);
			log.info("Date converted from String to date");
			return contract_date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("Failure in converting from String to Date");
			return null;
		}
	}

}
