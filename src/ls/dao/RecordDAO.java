package ls.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ls.bean.RecordBean;

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
	public RecordBean findRecordByBookID(int bookID) {
		PreparedStatement st = null;
		ResultSet rs = null;
		 try {
			//SQL
			String sql = "SELECT * FROM record, WHERE book_id = ?";
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
