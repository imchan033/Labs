import java.sql.*;

public class MySQLConn {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/testDB";

	static final String USERNAME = "root";
	static final String PASSWORD = "1234";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			System.out.println("\n- MySQL Connection");
			stmt = conn.createStatement();
			
			String sql;
			sql = "SELECT title, contents FROM testdb.tb_board";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				String title = rs.getString("title");
				String contents = rs.getString("contents");

				System.out.print("\n** Group : " + title);
				System.out.print("\n    -> Member: " + contents);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se1){
			se1.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		System.out.println("\n\n- MySQL Connection Close");
	}
}
