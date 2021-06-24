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
	//貸出台帳の追加
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
	//会員IDを返す
	public String returnUserName(int userIdInt) throws DAOException {
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {//userIdが一致する会員の検索
			String sql = "SELECT user_name FROM member WHERE user_id = ? AND leave_day IS  NULL";
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
	//変更日の変更
	public int updateReturnDay(Date returnDay, int bookId) throws DAOException {
		if(con == null) {
			getConnection();
		}
		PreparedStatement st = null;

		try {
			String sql = "UPDATE lending SET return_day = ? WHERE book_id = ?";
			st = con.prepareStatement(sql);
			st.setDate(1, returnDay);
			st.setInt(2, bookId);
			int rows = st.executeUpdate();
			return rows;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("返却日の登録に失敗しました");
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
	//資料名を返す
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
	//貸出中の資料IDを返す
	public LendingBean getUnreturnedBookByBookId(int book_id) throws DAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM lending WHERE book_id = ? AND return_day IS null";
			//stオブジェクトの取得
			st = con.prepareStatement(sql);
			st.setInt(1, book_id);
			//Emailの設定
			//SQLの実行
			rs = st.executeQuery();
			//結果の取得と表示

			if(rs.next()) {
				int lendId = rs.getInt("lend_id");
				int bookId = rs.getInt("book_id");
				int userId = rs.getInt("user_id");
				Date lendDay = rs.getDate("lend_day");
				Date returnLimit = rs.getDate("return_limit");
				String memo = rs.getString("memo");

				return new LendingBean(lendId, bookId, userId, lendDay, returnLimit, memo);
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
	//資料IDに該当する資料が貸出中か
	public boolean existsUnreturnedBook(int book_id) throws DAOException {
		// return_dayがnullの行があればまだ返却されていないものとしてTrueを返したい
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM lending WHERE book_id = ? AND return_day IS null";
			//stオブジェクトの取得
			st = con.prepareStatement(sql);
			st.setInt(1, book_id);
			//Emailの設定
			//SQLの実行
			rs = st.executeQuery();
			//結果の取得と表示

			return rs.next();
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
	//会員IDに該当する会員に貸出中があるか
	public boolean existsUnreturnedBookNow(int user_id) throws DAOException {
		// return_dayがnullの行があればまだ返却されていないものとしてTrueを返したい
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM lending WHERE user_id = ? AND return_day IS null";
			//stオブジェクトの取得
			st = con.prepareStatement(sql);
			st.setInt(1, user_id);
			//Emailの設定
			//SQLの実行
			rs = st.executeQuery();
			//結果の取得と表示

			return rs.next();
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException("会員IDの検索に失敗しました。");
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
	//貸出履歴一覧
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
				int lendId = rs.getInt("lend_id");
				int bookId = rs.getInt("book_id");
				int userId = rs.getInt("user_id");
				Date lendDay = rs.getDate("lend_day");
				Date returnLimit = rs.getDate("return_limit");
				Date returnDay = rs.getDate("return_day");
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
