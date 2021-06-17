package ls.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

	private Connection con;

	public MemberDAO() throws DAOException{
		getConnetion();
	}

	private void getConnetion() throws DAOException{
		try {
			Class.forName("org.postgresql.Driver");
			String url ="jdbc:postgresql:library_system";
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



		public boolean ExistsUserID(String userID) {
		PreparedStatement st = null;
		ResultSet rs = null;
		 try {
			//SQL
			String sql = "SELECT * FROM member WHERE user_id = ?";
			st = con.prepareStatement(sql);
			//SQLをデータベースへ
			rs = st.executeQuery();

			if (rs.next()) {

				Date leaveDay = rs.getDate("leaveDay");

			} else {
				return false;
			}
		 }
		 catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(st != null) st.close();
				close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;

	}
}





