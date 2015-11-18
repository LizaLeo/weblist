package ee.itcollege.weblist.configuration;

import java.beans.PropertyVetoException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class LoggedDataSource implements DataSource {
	
	ComboPooledDataSource ds;
	public LoggedDataSource() throws PropertyVetoException {
		ds = new ComboPooledDataSource();
        ds.setMaxPoolSize(10);
        ds.setMinPoolSize(2);
        
        ds.setJdbcUrl("jdbc:h2:~/db/test");
        ds.setDriverClass("org.h2.Driver");
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return ds.getLogWriter();
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		ds.setLogWriter(out);
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {	
		ds.setLoginTimeout(seconds);
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		return ds.getLoginTimeout();
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return ds.getParentLogger();
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return ds.unwrap(iface);
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return ds.isWrapperFor(iface);
	}

	@Override
	public Connection getConnection() throws SQLException {
		
		// TODO: read documentation
		int numUserPools = ds.getThreadPoolSize();
		System.out.println("pool size: " + numUserPools);
		
		return ds.getConnection();
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return ds.getConnection(username, password);
	}

	
	
}
		