package ls.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ls.bean.RecordBean;
import ls.module.OperateDate;

//RecordBeanの実装

public class RecordDAO {

	private Connection con;

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

	public RecordDAO() throws DAOException{
		getConnection();
	}

	private void close() throws SQLException{
		if(con != null) {
			con.close();
			con = null;
		}
	}

	public RecordBean getRecordInfoByBookId(int bookId) throws DAOException{
		PreparedStatement st = null;
		ResultSet rs = null;
		if(con == null) {
			getConnection();
		}
		try {
			String sql = "SELECT * FROM record WHERE book_id = ?";

			st = con.prepareStatement(sql);
			st.setLong(1, bookId);

			rs = st.executeQuery();

			if(rs.next()) {
				int book_id = rs.getInt("book_id");
				long isbn = rs.getLong("isbn");
				Date stockDay = rs.getDate("stock_day");
				String memo = rs.getString("memo");

				return new RecordBean(book_id, isbn, stockDay, memo);

			}else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("エラー");
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




	// 追加した行の資料idを返り値とする
	public int addRecordInfo(long isbn, String memo) throws DAOException{

		PreparedStatement st1 = null;
		PreparedStatement st2 = null;
		ResultSet rs = null;
		try {
			String getRecordIdSql = "SELECT nextval('record_book_id_seq')";
			st1 = con.prepareStatement(getRecordIdSql);
			rs = st1.executeQuery();

			int next_book_id = -1;

			if(rs.next()) {
				next_book_id = rs.getInt(1);
			}else {
				// -1を返す 加えることが出来ませんでした
				return -1;
			}


			String insertSql = "INSERT INTO record(isbn,stock_day,throwout_day,memo) VALUES(?,?,?,?)";
			st2 = con.prepareStatement(insertSql);

			st2.setLong(1, isbn);
			// 現在時刻を取得
			st2.setDate(2, OperateDate.getDateNow());
			// 廃棄日は決まっていないためnullをセットする
			st2.setNull(3, java.sql.Types.NULL);
			st2.setString(4, memo);

			// SQLの実行
			int rows = st2.executeUpdate();
			// 結果の取得

			if(rows > 1) {
				// 次の資料idを返す
				return next_book_id;
			}else {
				// 加えることが出来ませんでした
				return -1;
			}

		}
		catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("実行できませんでした");
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(st1 != null) st1.close();
				if(st2 != null) st2.close();
				close();
			}
			catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}

	/*機能実装原型
	public RecordBean 機能名() throws DAOException{

		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

		}
		catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("");
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
	}*/


}
