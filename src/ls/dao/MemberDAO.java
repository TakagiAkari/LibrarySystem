package ls.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDAO {

	private Connection con;


	public MemberDAO() throws DAOException{
		getConnection();
	}

//Dateはjava.sql.Date
	public int addMember(String name, String address, String tel, String email, Date birth, Date enterDaysql) throws DAOException {
		if(con == null) {
			getConnection();
		}
		PreparedStatement st = null;
		try {
			String sql = "INSERT INTO member(user_name, address, tel, email, birthday, enter_day) VALUES(?, ?, ?, ?, ?, ?)";
			st = con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, address);
			st.setString(3, tel);
			st.setString(4, email);
			st.setDate(5, birth);
			st.setDate(6, enterDaysql);

			int rows = st.executeUpdate();
			return rows;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("会員情報の新規登録に失敗しました");
		}finally {
			try {
				if(st != null) {
					st.close();
					close();
					}
				}catch(Exception e) {
					throw new DAOException("DBとの接続の開放に失敗しました");
					}
				}
		}



	private void getConnection() throws DAOException{

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


}
