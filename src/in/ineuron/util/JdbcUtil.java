package in.ineuron.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {
	private static Connection connection = null;
//	private static Properties p = null;
//	private static FileInputStream fis = null;
	
	private JdbcUtil() {
		
	}
	
	static{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws IOException, SQLException {
		// using HikariCP for Connection Pooling.
			
		HikariConfig config = new HikariConfig("src\\in\\ineuron\\properties\\db.properties");
		HikariDataSource dataSource = new HikariDataSource(config);
		connection = dataSource.getConnection();
			
		return connection;
	}
}


//fis = new FileInputStream("src\\in\\ineuron\\properties\\db.properties");
//p = new Properties();
//p.load(fis);
//String url = p.getProperty("url");
//String user = p.getProperty("user");
//String password = p.getProperty("password");
//connection = DriverManager.getConnection(url,user,password);
