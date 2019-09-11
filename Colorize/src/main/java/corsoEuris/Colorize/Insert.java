package corsoEuris.Colorize;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSQL {

    public void getEmps() throws SQLException{
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection conn = DriverManager.getConnection("", "myusername", "my password");
        PreparedStatement statement = conn.prepareStatement("insert into COLORIZE " +
                " (HSL,COLORS,HEX,RGB)" +
                "  values " +
                " (:HSL,:COLORS,:HEX,:RGB) ");
        statement.setObject(?, "VALUE FOR HSL");
        statement.setObject(?, "VALUE FOR COLORS");
        statement.setObject(?, "VALUE FOR HEX");
        statement.setObject(?, "VALUE FOR RGB");


        statement.execute();
    }

}