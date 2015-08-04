package supplierManagement.project;

import static org.junit.Assert.*;

import org.junit.Test;

public class ServiceTest {
	
	private ServiceInterface s = new Service();
	
	@Test
	public void NoConflict()
	{
		Supplier sup = new Supplier(404, "Fidelity", 3, 4, Display.getDate("12.03.2024"));
		boolean valid = s.add_supplier(sup);
		
		assertEquals("An error has occured, but it had to be true", valid, true);
	}
	
	@Test
	public void ID_violation()
	{
		Supplier sup = new Supplier(1, "Fidelity", 3, 4, Display.getDate("12.03.2024"));
		boolean valid = s.add_supplier(sup);
		
		assertEquals("ID should have been violated", valid, false);
		
	}

}
