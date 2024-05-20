package expeditors.backend.dao.jdbc;

import expeditors.backend.adoption.Adopter;
import expeditors.backend.dao.jdbc.AbstractDao;
import expeditors.backend.dao.jdbc.AdopterDAO;
import expeditors.backend.dao.jdbc.JDBCQueryTemplate;

import java.sql.*;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class AdopterDAOImp extends AbstractDao implements AdopterDAO<Adopter> {
    @Override
    public Optional<Adopter> findById(long id) {
        Optional<Adopter> adopterNew = Optional.empty();
        String sql = "SELECT idAdopter, name, phonenumber FROM Adopter WHERE idAdopter = ?";

        try (
                Connection con = getConnection();
                PreparedStatement prepStmt = con.prepareStatement(sql);
        ) {
            prepStmt.setLong(1, id);

            try (ResultSet rset = prepStmt.executeQuery();) {
                Adopter resAdopter = new Adopter();

                if(rset.next()) {
                    resAdopter.setIdAdopter(rset.getInt("idAdopter"));
                    resAdopter.setName(rset.getString("name"));
                    resAdopter.setPhoneNumber(rset.getString("phonenumber"));
                }
                adopterNew = Optional.of(resAdopter);
            }
        }
        catch (SQLException sqe) { sqe.printStackTrace();}

        return adopterNew;
    }

    @Override
    public List<Adopter> findAll() {
        List<Adopter> adopters = Collections.emptyList();

        JDBCQueryTemplate<Adopter> template = new JDBCQueryTemplate<Adopter>() {
            @Override
            public Adopter mapItem(ResultSet rset) throws SQLException {
                Adopter resAdopter = new Adopter();
                resAdopter.setIdAdopter(rset.getInt("idAdopter"));
                resAdopter.setName(rset.getString("name"));
                resAdopter.setPhoneNumber(rset.getString("phonenumber"));
                return resAdopter;
            }
        };

        adopters = template.queryForList("SELECT idAdopter, name, phonenumber FROM Adopter");

        return adopters;
    }

    @Override
    public Adopter create(Adopter adopter) {
        String sql = "insert into Adopter (name, phoneNumber, date) values (?, ?, ?);";

        try (
                Connection con = getConnection();
                PreparedStatement prepStmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            prepStmt.setString(1, adopter.getName());
            prepStmt.setString(2, adopter.getPhoneNumber());
            prepStmt.setDate(3, Date.valueOf(adopter.getDate()));
            prepStmt.executeUpdate();

            try (ResultSet genKeys = prepStmt.getGeneratedKeys()) {
                if(genKeys.next()) {
                    adopter.setIdAdopter(genKeys.getInt("idAdopter"));
                }
            }
        }
        catch (SQLException sqe) { sqe.printStackTrace(); }

        return adopter;
    }

    @Override
    public Adopter update(Adopter adopter) {
        return null;
    }

    @Override
    public int[] update(List<Adopter> t) {
        return new int[0];
    }

    @Override
    public int delete(Adopter adopter) {
        return 0;
    }
}
