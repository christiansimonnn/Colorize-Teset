package corsoEuris.Colorize;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSQL {

	public void getEmps() throws SQLException{
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		Connection conn = DriverManager.getConnection("", "myusername", "my password");
		PreparedStatement statement = conn.prepareStatement("select HSL,COLORS,HEX,RGB from COLORIZE where ");

		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()){

			System.out.println(resultSet.getObject(HSL));
			System.out.println(resultSet.getObject(COLORS));
			System.out.println(resultSet.getObject(HEX));
			System.out.println(resultSet.getObject(RGB));

		}

	}

}
