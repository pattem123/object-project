package HW7_x;
import java.sql.SQLException;

public class CustomerAccountDAO {
	public boolean saveAccount(CustomerAccount ca) throws SQLException {
		return true;
		}
	public boolean updateAccount(CustomerAccount ca) throws SQLException {
		return true;
		}
	public boolean deleteAccount(CustomerAccount ca) throws SQLException {
		return true;
		}
	public CustomerAccount getAccount(String acctNum) throws SQLException {
		return null;
		}
	public String newAcctNumber(String name, String phone) throws SQLException {
		return "1111222233334444";
		}
	
}
