package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

	public class DB {
		private static DB DB = new DB();
		private Connection conn;
		private Statement stmt;
		private PreparedStatement pstmt;
		private ResultSet rs;
		private String driverDB = "org.postgresql.Driver";
		private String dbName = "CalculadoraIP";
		private String urlDB = "jdbc:postgresql://localhost:5433/" + this.dbName; 
		private String userDB = "postgres";
		private String passDB = "admin";
		public String resultString = "";
		
		private DB(){
			try {
			Class.forName(driverDB);
			this.conn = DriverManager.getConnection(urlDB, userDB, passDB);
			System.out.println("Conexion establecida");
			} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			}
			} 
		public static DB getInstances() {
			return DB;
			}

		public ResultSet dbStatement(String query) {
			try {
			this.stmt = this.conn.createStatement();
			this.rs = this.stmt.executeQuery(query);
			resultString="";
			if(rs.next()) {
				
			do {
			resultString += ("IP Address:             "+rs.getString("ip_address") + "\n");
			resultString += ("Public/Priv:               "+rs.getString("priv_public")+ "\n");
			resultString += ("Clase:                       "+rs.getString("clase")+ "\n");
			resultString += ("Apipa:                        "+rs.getString("apipa")+ "\n");
			resultString += ("Reservada:              "+rs.getString("reservada")+ "\n");
			resultString += ("Uni/Multi/Broad:      "+rs.getString("uni_multi_broad")+ "\n");
			resultString += ("Network Address:  "+rs.getString("network_address")+ "\n");
			resultString += ("Gateway:                  "+rs.getString("gateway")+ "\n");
			resultString += ("Broadcast:               "+rs.getString("broadcast")+ "\n");
			resultString += ("Rango:                     "+rs.getString("rango")+ "\n");
			resultString += ("\n");
			} while(rs.next());
			} else {
				resultString += "No hay Resultados";
			}	
			} catch (SQLException e) {
			e.printStackTrace();
			}finally {
			try {
			this.stmt.close();
			this.rs.close();
			} catch (SQLException e) {
			e.printStackTrace();
			}
			}
			return rs;
		}
		
		public void dbPrepareStatement(String query, Object[] obj) {
			try {
			this.pstmt = this.conn.prepareStatement(query);
			this.pstmt.setString(1, (String) obj[0]);
			this.pstmt.setString(2, (String) obj[1]);
			this.pstmt.setString(3, (String) obj[2]);
			this.pstmt.setString(4, (String) obj[3]);
			this.pstmt.setString(5, (String) obj[4]);
			this.pstmt.setString(6, (String) obj[5]);
			this.pstmt.setString(7, (String) obj[6]);
			this.pstmt.setString(8, (String) obj[7]);
			this.pstmt.setString(9, (String) obj[8]);
			this.pstmt.setString(10, (String) obj[9]);
			
			this.pstmt.executeUpdate();
			} catch (SQLException e) {
			e.printStackTrace();
			} finally {
			try {
			this.pstmt.close();
			} catch (SQLException e) {
			e.printStackTrace();
			}
			 }
			} 
		
		public void dbClose() {
			try {
			this.conn.close();
			System.out.println("Conexion cerrada");
			} catch (SQLException e) {
			e.printStackTrace();
			} 
		}
}

