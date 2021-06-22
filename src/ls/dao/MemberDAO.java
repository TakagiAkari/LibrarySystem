package ls.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ls.bean.MemberBean;

public class MemberDAO {

	private Connection con;

	public MemberDAO() throws DAOException{
		getConnection();
	}

//Dateはjava.sql.Date
	public int addMember(String name, String address, String tel, String email, Date birth, Date enterDaysql) throws DAOException {
		if(con == null) {
			getConnection();
		}
		PreparedStatement st = null;
		try {
			String sql = "INSERT INTO member(user_name, address, tel, email, birthday, enter_day) VALUES(?, ?, ?, ?, ?, ?)";
			st = con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, address);
			st.setString(3, tel);
			st.setString(4, email);
			st.setDate(5, birth);
			st.setDate(6, enterDaysql);

			int rows = st.executeUpdate();
			return rows;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("会員情報の新規登録に失敗しました");
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
	//会員情報変更
	public int ChangeMember(MemberBean bean) throws DAOException {
		if(con == null) {
			getConnection();
		}
		PreparedStatement st = null;
		try {
			String sql = "UPDATE member SET user_name= ?, address= ?, tel= ?, email= ?, birthday= ? WHERE user_id = ?";
			st = con.prepareStatement(sql);

			st.setString(1,bean.getUserName());
			st.setString(2,bean.getAddress());
			st.setString(3,bean.getTel());
			st.setString(4,bean.getEmail());
			st.setDate(5,bean.getBirth());
			st.setInt(6,bean.getUserId());

			int rows = st.executeUpdate();
			return rows;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("会員情報の変更に失敗しました");
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
//emailで検索
	public MemberBean findByEail(String email) throws DAOException{

		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			//emailが一致する会員の検索
			String sql ="SELECT * FROM member WHERE email = ? AND leave_day is null";
			//stオブジェクトの取得
			st = con.prepareStatement(sql);
			//Emailの設定
			st.setString(1, email);
			//SQLの実行
			rs = st.executeQuery();
			//結果の取得と表示
			if (rs.next()) {
				int userId = rs.getInt("user_id");
				String userName = rs.getString("user_name");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				email = rs.getString("email");
				Date birth = rs.getDate("birthday");
				Date enterDay = rs.getDate("enter_day");
				Date leaveDay = rs.getDate("leave_day");
				MemberBean bean = new MemberBean(userId, userName, address, tel, email, birth, enterDay, leaveDay);
				//会員情報を返す
				return bean;
			}
			//Email該当なし
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



		public MemberBean findMemberByMemID(int userID) {
		PreparedStatement st = null;
		ResultSet rs = null;
		 try {
			//SQL
			String sql = "SELECT * FROM member WHERE user_id = ?";
			st = con.prepareStatement(sql);
			//SQLをデータベースへ
			st.setInt(1, userID);
			rs = st.executeQuery();

			if (rs.next()) {
				int userId = rs.getInt("user_id");
				String userName = rs.getString("user_name");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				Date birth = rs.getDate("birthday");
				Date enterDay =rs.getDate("enter_day");

				MemberBean bean = new MemberBean(userId,userName, address, tel, email,birth, enterDay);
				return bean;
			}
		} catch (Exception e) {
					e.printStackTrace();
		  }
		return null;
	   }

		public void updateLeaveDay(int userId) {
		PreparedStatement st = null;
		 try {
			String sql = "UPDATE member SET leave_day = CURRENT_DATE WHERE user_id = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, userId);
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
}





