package ls.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ls.dao.DAOException;
import ls.dao.MemberDAO;

public class DeleteMemberInfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
		String error = "";
		try {
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("acttion");
			//パラメーターの取得
			String userID = request.getParameter("userID");
			//DAOが入る
			MemberDAO memDao = new MemberDAO();
			//削除メソッドを呼び出す
			boolean count = memDao.ExistsUserID(userID);
			//削除するものをリクエストスコープに入れる
			request.setAttribute("count", count);
			//例外処理
		}catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			//gotoPage(request, response, "/errInternal.jsp");
		}finally {
			request.setAttribute("error", error);
			request.getRequestDispatcher("/LibrarySystem/DeleteComplete").forward(request, response);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
