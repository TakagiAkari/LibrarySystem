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
			String sql = "INSERT INTO message";
			st = con.prepareStatement(sql);
			// SQLの実行
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

	/*機能実装原型
	public CatalogBean 機能名() throws DAOException{

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
