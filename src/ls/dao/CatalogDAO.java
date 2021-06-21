package ls.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ls.bean.CatalogBean;

//CatalogBeanの実装

public class CatalogDAO {

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

	public CatalogDAO() throws DAOException{
		getConnection();
	}

	private void close() throws SQLException{
		if(con != null) {
			con.close();
			con = null;
		}
	}
	public boolean existsIsbn(long isbn) throws DAOException{

		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM catalog WHERE isbn=?";
			st = con.prepareStatement(sql);
			// SQLの実行
			st.setLong(1, isbn);
			rs = st.executeQuery();
			// 結果の取得

			return rs.next();
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
	}

	public boolean addCatalogInfo(CatalogBean cBean) throws DAOException{

		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO catalog VALUES(?,?,?,?,?,?)";
			st = con.prepareStatement(sql);

			st.setLong(1, cBean.getIsbn());
			st.setString(2, cBean.getBookName());
			st.setInt(3, cBean.getCategory());
			st.setString(4, cBean.getAuthor());
			st.setString(5, cBean.getPublisher());
			st.setDate(6, cBean.getPublishDay());
			// SQLの実行
			int rows = st.executeUpdate();
			// 結果の取得

			if(rows > 0) {
				return true;
			}else {
				return false;
			}

		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
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
	public CatalogBean getCatalogInfoByIsbn(long isbn) throws DAOException{

		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM catalog WHERE isbn=?";
			st = con.prepareStatement(sql);
			// SQLの実行
			st.setLong(1, isbn);
			rs = st.executeQuery();
			// 結果の取得

			if(rs.next()) {
				int category = rs.getInt("category");
				String bookName = rs.getString("book_name");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				Date publishDay = rs.getDate("publish_day");

				CatalogBean bean = new CatalogBean(isbn, bookName,category,author,publisher,publishDay);
				return bean;
			}
			// 検索結果がない場合
			else {
				return null;
			}
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
	}
//ISBNで検索する
	public CatalogBean findByIsbn(long isbn) throws DAOException{

		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			//emailが一致する会員の検索
			String sql = "SELECT * FROM catalog WHERE isbn = ?";
			//stオブジェクトの取得
			st = con.prepareStatement(sql);
			//資料IDの設定
			st.setLong(1, isbn);
			//SQLの実行
			rs = st.executeQuery();
			//結果の取得と表示
			if (rs.next()) {
				isbn = rs.getLong("isbn");
				String bookName = rs.getString("book_name");
				int category = rs.getInt("category");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				Date publishDay = rs.getDate("publish_day");
				CatalogBean bean = new CatalogBean(isbn, bookName, category, author, publisher, publishDay);
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
