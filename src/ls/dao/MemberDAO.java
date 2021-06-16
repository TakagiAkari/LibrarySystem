package ls.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MemberDAO {

	private Connection con;


	public MemberDAO() throws DAOException{
		getConnetion();
	}


	private void getConnetion() throws DAOException{

		try {
			Class.forName("org.postgresql.Driver");
			String url ="jdbc:postgresql:library-system";
			String user ="admin";
			String pass ="himitu";
			con = DriverManager.getConnection(url, user, pass);
		}catch(Exception e) {
			throw new DAOException("データベースへの接続に失敗しました");
		}
	}

	private void close() throws SQLException{
		if(con != null) {
			con.close();
			con = null;
		}
	}
}
