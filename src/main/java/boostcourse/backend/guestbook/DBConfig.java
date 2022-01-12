package boostcourse.backend.guestbook;

import boostcourse.backend.guestbook.dao.GuestbookDao;
import boostcourse.backend.guestbook.dao.SpringJdbcGuestbookDao;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class DBConfig {
    private static String driverClassName = "com.mysql.cj.jdbc.Driver";
    private static String dbUrl = "jdbc:mysql://localhost:3306/connectdb";
    private static String dbUser = "connectuser";
    private static String dbPassword = "connect123!@#";

    public GuestbookDao guestbookDao() {
        return new SpringJdbcGuestbookDao(dataSource());
    }

    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPassword);

        return dataSource;
    }
}
