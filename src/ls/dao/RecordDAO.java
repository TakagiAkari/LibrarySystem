package ls.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ls.bean.RecordBean;

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

	public RecordBean findByBookId(int bookId) throws DAOException{

		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			//emailが一致する会員の検索
			String sql = "SELECT * FROM record WHERE book_id = ? AND throwout_day is null";
			//stオブジェクトの取得
			st = con.prepareStatement(sql);
			//資料IDの設定
			st.setInt(1, bookId);
			//SQLの実行
			rs = st.executeQuery();
			//結果の取得と表示
			if (rs.next()) {
				bookId = rs.getInt("book_id");
				long isbn = rs.getLong("isbn");
				Date stockDay = rs.getDate("stock_day");
				Date throwoutDay = rs.getDate("throwout_day");
				String memo = rs.getString("memo");
				RecordBean bean = new RecordBean(bookId, isbn, stockDay, throwoutDay, memo);
				//会員情報を返す
				return bean;
			}
			//資料ID該当なし
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
