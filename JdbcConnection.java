import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class JdbcConnection {

	private Connection connect;
	private final String oraThinProtocal = "jdbc:oracle:thin:@";
	private String host, serviceId, port, user, password;

	public JdbcConnection(String host, String serviceId, String port,String user, String password) {
		this.host = host;
		this.serviceId = serviceId;
		this.user = user;
		this.port = port;
		this.password = password;
		
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public Connection connect() {
		String url = oraThinProtocal+this.host+":"+this.port+":"+this.serviceId;
		try {
			this.connect = DriverManager.getConnection(url,this.user, this.password);
			this.connect.setAutoCommit(false);
		}catch(Exception e) {
			System.out.println(e +"line 36: JdbcConnection");
		}
		return this.connect;
	}
	
	public void disconnect() {
		try {
			this.connect.close();
		}catch(Exception e) {
			System.out.println(e + "method disconnect() JdbcConnection");
		}
	}
	
	public void commit() {
		try {
			connect.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
//51
