package ls.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ls.bean.MemberBean;
import ls.dao.DAOException;
import ls.dao.MemberDAO;

@WebServlet("/DeleteMemberInfoServlet")
public class DeleteMemberInfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
		String error = "";
		try {
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");
			//パラメーターの取得
			int userID = Integer.parseInt(request.getParameter("userID"));

			//DAOが入る
			MemberDAO memDao = new MemberDAO();
			//削除メソッドを呼び出す
			MemberBean member = memDao.findMemberByUserID(userID);
			//削除するものをリクエストスコープに入れる
			request.setAttribute("member", member);
			//例外処理
			request.getRequestDispatcher("/deleteMem.jsp").forward(request, response);

		if (action == null || action.length() == 0) {
			gotoPage(request,response,"/deleteMem.jsp");
		}
		else if(action.equals("delete")) {
			int userId = Integer.parseInt(request.getParameter("userId"));
			memDao.updateLeaveDay(userId);
			request.setAttribute("member", member);
			request.getRequestDispatcher("/complete.jsp").forward(request, response);

		}

		}catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			//gotoPage(request, response, "/errInternal.jsp");
			request.getRequestDispatcher("/errInternal.jsp").forward(request, response);
		}finally {
			//request.setAttribute("error", error);
			//request.getRequestDispatcher("/LibrarySystem/DeleteComplete").forward(request, response);
		}
	}


	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String string) {
		// TODO 自動生成されたメソッド・スタブ

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
