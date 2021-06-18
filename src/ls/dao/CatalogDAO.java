package ls.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
