package ls.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LendingDAO {
	private Connection con;


	public LendingDAO() throws DAOException{
		getConnection();
	}

	//DateはSQLDate
	public int addLending(int userIdInt, int bookIdInt, Date lendDay,Date returnLimitDay, String memo) throws DAOException {
		if(con == null) {
			getConnection();
		}
		PreparedStatement st = null;
		try {
			String sql = "INSERT INTO lending(user_id, book_id, lend_day,return_limit, memo) VALUES(?, ?, ?, ?, ?)";
			st = con.prepareStatement(sql);
			st.setInt(1, userIdInt);
			st.setInt(2, bookIdInt);
			st.setDate(3, lendDay);
			st.setDate(4, returnLimitDay);
			st.setString(5, memo);

			int rows = st.executeUpdate();
			return rows;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("貸出情報の新規登録に失敗しました");
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




	public String returnUserName(int userIdInt) throws DAOException {
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {//userIdが一致する会員の検索
			String sql = "SELECT user_name FROM member WHERE user_id = ?";
			//stオブジェクトの取得
			st = con.prepareStatement(sql);
			//Emailの設定
			st.setInt(1, userIdInt);
			//SQLの実行
			rs = st.executeQuery();
			//結果の取得と表示
			if (rs.next()) {
				String userName = rs.getString("user_name");
				return userName;
			}else {
				return null;
				}
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException("会員名の検索に失敗しました。");
		}finally {
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



	public String returnBookName(int bookIdInt) throws DAOException {
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {//userIdが一致するbookの検索
			String sql = "SELECT book_name FROM record WHERE book_id = ?";
			//stオブジェクトの取得
			st = con.prepareStatement(sql);
			//Emailの設定
			st.setInt(1, bookIdInt);
			//SQLの実行
			rs = st.executeQuery();
			//結果の取得と表示
			if (rs.next()) {
				String bookName = rs.getString("book_name");
				return bookName;
			}else {
				return null;
				}
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException("資料名の検索に失敗しました。");
		}finally {
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
