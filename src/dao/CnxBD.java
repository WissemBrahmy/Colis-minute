package dao;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class CnxBD {
		private static  Connection con ; 
		   
		   static {
			   try {
				Class.forName("com.mysql.jdbc.Driver") ;
			    try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/covbd", "root", "");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			   
			   
			   
		   }

		public static Connection getCon() {
			return con;
		}
}
