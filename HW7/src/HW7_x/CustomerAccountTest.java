package HW7_x;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;



class CustomerAccountTest {
	private CustomerAccount cusaccount1;
	
	@Mock
	private CustomerAccount cusaccount2;
	
	@Mock
	private CustomerAccountDAO mockDAO;
	
	@BeforeEach
	void setUp() throws Exception {
		cusaccount1 = new CustomerAccount();
		cusaccount2 = spy(cusaccount1);
		mockDAO = mock(CustomerAccountDAO.class); 
	}
	
	
	

	
	@Test
      void test1() throws SQLException, NoAccountCreatedException {
		
		String name = "Radha Sai";
		String phone = "602-479-4081";
		String accno = "1111222233334444";
		
		when(mockDAO.newAcctNumber(anyString(), anyString())).thenReturn("1111222233334444");
		when(mockDAO.saveAccount(cusaccount2)).thenThrow(new SQLException());
		cusaccount2.CustomerAccountDAO(mockDAO);
		
		try {
			cusaccount2.createNewAccount(name, phone);
		} catch (NoAccountCreatedException e) {
			String expected = String.format(" %s  %s  %s ", name, phone, accno);
			String actual = e.getMessage();
			assertEquals(expected, actual, "The exception messages do not match");
		}	
	}
	
	
	@Test
    void test3() throws SQLException, NoSuchCustomerAccountException {
		
		String name = "pradeep";
		String accno = "1424149";
		
	
		when(mockDAO.updateAccount(cusaccount2)).thenThrow(new SQLException());
		cusaccount2.CustomerAccountDAO(mockDAO);
		
		try {
			cusaccount2.updateCustomerName(accno, name);
		} catch (NoSuchCustomerAccountException e) {
			String expected = String.format(" %s %s ", name, accno);
			String actual = e.getMessage();
			assertEquals(expected, actual, "The exception messages do not match");
		}
		
			
	}
	

	@AfterEach
	void tearDown() throws Exception {
	}

}