package ls.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import ls.bean.ReturnBean;

public class ReturnDAO {
	private Connection con;

	public ReturnDAO() throws DAOException{
		getConnection();
	}


	/*lend_id	integer		貸出台帳番号
	user_id	integer		利用者のID番号
	book_id	integer		資料ID番号　
	lend_day	date		貸出年月日　
	return_limit	date		返却期限
	return_day	date		返却年月日
	memo	text		備考欄*/



	//DBから貸出情報(全部)を取得、Check画面で返却日以外をDB情報、返却日を当日で表示
	public ReturnBean returnInfo(int bookIdInt) throws DAOException {

		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {//bookIdが一致する資料の検索
			String sql = "SELECT * FROM lending WHERE book_id = ?";
			//stオブジェクトの取得
			st = con.prepareStatement(sql);
			//bookIdの設定
			st.setInt(1, bookIdInt);
			//SQLの実行
			rs = st.executeQuery();
			//結果の取得と表示
			if (rs.next()) {
				Date returnDate = rs.getDate("return_day");

				if(returnDate == null) {
					int lendId  = rs.getInt("lend_id");
					int userId = rs.getInt("user_id");
					int bookId = rs.getInt("book_id");
					Date lendDay = rs.getDate("lend_day");
					Date returnLimit = rs.getDate("return_limit");
					String memo = rs.getString("memo");

					java.util.Date date = new java.util.Date();
			        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			        //String
			        String formattedDate = simpleDateFormat.format(date);
			        //SQLDate
			        Date returnDay = Date.valueOf(formattedDate);


					//beanに格納⇒servに渡す
					ReturnBean returnInfo = new ReturnBean(lendId, userId, bookId, lendDay, returnLimit, returnDay, memo);
					return returnInfo;
				}
			}else {
				return null;
				}
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException("貸出情報の検索に失敗しました。");
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
		return null;
	}


	//返却日の挿入

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
