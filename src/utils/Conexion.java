package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	public Connection cadena_conexion(){
		Connection cn=null;
		String usu="admin";
		String pass="admin";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Blog",usu,pass);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return cn;
	}
	
	

}
