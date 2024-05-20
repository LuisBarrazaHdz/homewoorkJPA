package expeditors.backend.dao.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class JDBCQueryTemplate<T> extends AbstractDao {

    public JDBCQueryTemplate() {

    }

    public List<T> queryForList(String sql) {
        List<T> items = new ArrayList<>();

        try (
                Connection con = getConnection();
                Statement stmt = con.createStatement();
                ResultSet rset = stmt.executeQuery(sql);
                ) {
            while (rset.next()) {
                items.add(mapItem(rset));
            }
        }
        catch (SQLException sqe) { sqe.printStackTrace(); }
        return items;
    }

    public abstract T mapItem (ResultSet rset) throws SQLException;

}
