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

	//資料IDから資料を検索
	public RecordBean findRecordByBookID(int bookID) {
		PreparedStatement st = null;
		ResultSet rs = null;
		 try {
			//SQL
			String sql = "SELECT * FROM record WHERE book_id = ?";
			st = con.prepareStatement(sql);
			//SQLをデータベースへ
			st.setInt(1, bookID);
			rs = st.executeQuery();

			if (rs.next()) {
				int bookId = rs.getInt("book_id");
				Long isbn = rs.getLong("isbn");
				Date stockDay = rs.getDate("stock_day");
				Date throwoutDay =rs.getDate("throwout_day");
				String memo = rs.getString("memo");

				RecordBean rb = new RecordBean(bookId,isbn, stockDay, throwoutDay,memo);
				return rb;
			}
		} catch (Exception e) {
					e.printStackTrace();
		  }
		return null;
	   }
	public boolean updateRecordByBean(RecordBean bean) {
		PreparedStatement st = null;
		 try {
			String sql = "UPDATE record SET isbn=?, stock_day=?,memo=? WHERE book_id = ?";
			st = con.prepareStatement(sql);
			st.setLong(1, bean.getIsbn());
			st.setDate(2, bean.getStockDay());
			st.setString(3, bean.getMemo());
			st.setInt(4, bean.getBookId());
			int rows = st.executeUpdate();

			if(rows > 0) {
				// 行数が0行よりおおければ、変更したものとする
				return true;

			}else {
				return false;
			}
		}
		 catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				if(st != null) st.close();
				close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	//廃棄日の更新
	public void updateThrowoutDay(int bookId) {
		PreparedStatement st = null;
		 try {
			String sql = "UPDATE record SET throwout_day = CURRENT_DATE WHERE book_id = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, bookId);
			st.executeUpdate();

			return;
		}
		 catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(st != null) st.close();
				close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	//資料IDから資料台帳の情報を取得
	public RecordBean getRecordInfoByBookId(int bookId) throws DAOException{
		PreparedStatement st = null;
		ResultSet rs = null;
		if(con == null) {
			getConnection();
		}
		try {
			String sql = "SELECT * FROM record WHERE book_id = ? AND throwout_day IS NULL";

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
	public boolean addRecordInfo(long isbn, String memo) throws DAOException{

		PreparedStatement st2 = null;
		ResultSet rs = null;
		try {
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
				return true;
			}else {
				// 加えることが出来ませんでした
				return false;
			}

		}
		catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("実行できませんでした");
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(st2 != null) st2.close();
				close();
			}
			catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}
	//資料IDで検索
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
	public int getNextBookId() throws DAOException{
		// currvalで取得してきた値に1追加することで資料IDに追加されるはずのIDを取得してくる
		// nextvalでシーケンスを更新しているわけではないため、同時更新が起きると取得してくる
		// 値と実際にDBに挿入される値が異なる場合があることに注意。
		// 表示のみ使用することを推奨

		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			//emailが一致する会員の検索
			String sql = "SELECT MAX(book_id) FROM record";
			//stオブジェクトの取得
			st = con.prepareStatement(sql);
			//資料IDの設定
			//SQLの実行
			rs = st.executeQuery();
			//結果の取得と表示
			if (rs.next()) {
				//会員情報を返す
				int nowBookId = rs.getInt("max");
				return nowBookId + 1;
			}
			//資料ID該当なし
			else {
				// 起きないはず？
				throw new DAOException("検索に失敗しました。");
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
