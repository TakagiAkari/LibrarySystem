package ls.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ls.bean.MemberBean;

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



		public MemberBean findMemberByUserID(int userID) {
		PreparedStatement st = null;
		ResultSet rs = null;
		 try {
			//SQL
			String sql = "SELECT * FROM member WHERE user_id = ?";
			st = con.prepareStatement(sql);
			//SQLをデータベースへ
			st.setInt(1, userID);
			rs = st.executeQuery();

			if (rs.next()) {
				int userId = rs.getInt("user_id");
				String userName = rs.getString("user_name");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				Date birth = rs.getDate("birthday");
				Date enterDay =rs.getDate("enter_day");

				MemberBean bean = new MemberBean(userId,userName, address, tel, email,birth, enterDay);

				return bean;

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
		 return null;
	}
}





