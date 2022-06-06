import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {
	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sysgitc");
			System.out.println("Connected to the DB!"+con);
			Statement s = con.createStatement();
			System.out.println("Statement Created:"+s);
			ResultSet rs = s.executeQuery("SELECT * FROM EMP");
			System.out.println("Statement excited:"+rs);
			
			while(rs.next()) {
				int deptNo = rs.getInt(1);
				String deptName = rs.getString(2);
				String location = rs.getString(3);
				System.out.println("Dept No:"+deptNo+" Dept Name:"+deptName+" Location"+location);
			}
			rs.close();
			s.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
