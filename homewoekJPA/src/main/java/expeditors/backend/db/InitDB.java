package expeditors.backend.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;


import static java.lang.System.out;

@Component
public class InitDB {


   public static void main(String[] args) {
      InitDB idb = new InitDB();

      idb.doIt();
   }

   public void doIt() {
      String url = "jdbc:postgresql://localhost:5433/adoptapp";
      String user = "larku";
      String pw = "larku";
      DriverManagerDataSource dataSource = new DriverManagerDataSource(url, user, pw);

      JdbcClient jdbcClient = JdbcClient.create(dataSource);
   }
}