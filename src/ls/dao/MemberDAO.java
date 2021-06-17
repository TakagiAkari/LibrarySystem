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
		getConnection();
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


	public MemberBean findByEail(String email) throws DAOException{

		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			//emailが一致する会員の検索
			String sql = "SELECT * FROM member WHERE email = ? AND leave_day is null";
			//stオブジェクトの取得
			st = con.prepareStatement(sql);
			//Emailの設定
			st.setString(1, email);
			//SQLの実行
			rs = st.executeQuery();
			//結果の取得と表示
			if (rs.next()) {
				int userId = rs.getInt("user_id");
				String userName = rs.getString("user_name");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				email = rs.getString("email");
				Date birthday= rs.getDate("birthday");
				Date enterDay = rs.getDate("enter_day");
				Date leaveDay = rs.getDate("leave_day");
				MemberBean bean = new MemberBean(userId, userName, address, tel, email, birthday, enterDay, leaveDay);
				//会員情報を返す
				return bean;
			}
			//Email該当なし
			else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("検索に失敗しました。");
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(st != null) st.close();
				close();
			}
			catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}
}