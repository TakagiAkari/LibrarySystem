package ls.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReturnDAO {
	private Connection con;

	public ReturnDAO() throws DAOException{
		getConnection();
	}


	public String returnReturnDay() throws DAOException {
		//現在の日付を取得⇒Stringにしてreturn
		String returnDayDisplay;


		return returnDayDisplay;
	}

	//DBからreturn_limitを取得、Stringでreturn
	public String returnReturnLimit(int bookIdserch) throws DAOException {

		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {//bookIdが一致する資料の検索
			String sql = "SELECT return_limit FROM lending WHERE book_id = ?";
			//stオブジェクトの取得
			st = con.prepareStatement(sql);
			//bookIdの設定
			st.setInt(1, bookIdserch);
			//SQLの実行
			rs = st.executeQuery();
			//結果の取得と表示
			if (rs.next()) {
				Date returnLimit = rs.getDate("return_limit");
				//Stringに変換 sample2参照
				//String ReturnLimit = (String)returnLimit;
				return ;
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
	}

	public int recordReturnDay(Date returnDay, int bookId) throws DAOException {
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
