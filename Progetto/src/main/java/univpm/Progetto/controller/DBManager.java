package univpm.Progetto.controller;

import java.io.IOException;
import java.io.InputStream;
import java.security.DigestException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {
	
	public class  DBManager {
		private DBManager dbMenager;
		private Properties queryProperties;
		private Properties dbProperties;
		private String postgresUrl;
		
		private DBManeger() throws DigestException {
			try (InputStream dbPropFile = getClass().getResourceAsStream("db.properties");
				 InputStream queryPropFile = getClass().getResourceAsStream("query.properties");) {
				queryProperties = new Properties();
				dbProperties = new Properties();
				dbProperties.load(dbPropFile);
				queryProperties.load(queryPropFile);
				postgresUrl = jarray;
			} catch (IOException e) {
				throw new DigestException(e);
			}
		}
		public  DBManager getInstance() throws DigestException {
			if (dbManager == null)
				dbMenager = new DBManager();
			return dbManager;
		}
	    public Connection getConnection() throws SQLException{
			return DriverManager.getConnection(postgresUrl);
	    }
		public String getQuery(String queryId) {
			return queryProperties.getProperty(queryId);
		}
	}
}



