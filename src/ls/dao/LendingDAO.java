package ls.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ls.bean.LendingBean;

public class LendingDAO {
	private Connection con;


	public LendingDAO() throws DAOException{
		getConnection();
	}

	//DateはSQLDate
	public int addLending(int userId, int bookId, Date returnLimit, String memo) throws DAOException {
		if(con == null) {
			getConnection();
		}
		PreparedStatement st = null;
		try {
			String sql = "INSERT INTO lending(user_id, book_id, return_limit, memo) VALUES(?, ?, ?, ?)";
			st = con.prepareStatement(sql);
			st.setInt(1, userId);
			st.setInt(2, bookId);
			st.setDate(3, returnLimit);
			st.setString(4, memo);

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




	public String returnUserName(int userIdserch) throws DAOException {
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {//userIdが一致する会員の検索
			String sql = "SELECT user_name FROM member WHERE user_id = ?";
			//stオブジェクトの取得
			st = con.prepareStatement(sql);
			//Emailの設定
			st.setInt(1, userIdserch);
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



	public String returnBookName(int bookIdserch) throws DAOException {
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {//userIdが一致する会員の検索
			String sql = "SELECT book_name FROM record WHERE book_id = ?";
			//stオブジェクトの取得
			st = con.prepareStatement(sql);
			//Emailの設定
			st.setInt(1, bookIdserch);
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


	public List<LendingBean> findAll() throws DAOException {
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			//貸し出し台帳からデータを取得するSQL
			String sql = "SELECT * FROM lending";
			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			//SQLの実行
			rs = st.executeQuery();
			//結果の取得
			List<LendingBean> list = new ArrayList<LendingBean>();
			while (rs.next()) {
				int lendId = rs.getInt("lendId");
				int bookId = rs.getInt("bookId");
				int userId = rs.getInt("userId");
				Date lendDay = rs.getDate("lendDay");
				Date returnLimit = rs.getDate("returnLimit");
				Date returnDay = rs.getDate("returnDay");
				String memo = rs.getString("memo");
				LendingBean bean = new LendingBean(lendId, bookId, userId, lendDay, returnLimit, returnDay, memo);
				list.add(bean);
			}
			return list;

		}
		catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("一覧の取得に失敗しました。");
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