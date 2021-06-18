package ls.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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


			if (action == null || action.length() == 0) {
				MemberDAO memDao = new MemberDAO();

				HttpSession userIdforDeleteMember =request.getSession();
				String test = request.getParameter("userId");
				int userId = Integer.parseInt(test);
				MemberBean member = memDao.findMemberByUserID(userId);
				gotoPage(request,response,"/deleteMem.jsp");
				userIdforDeleteMember.setAttribute("test",userId);
			}
			else if(action.equals("delete")) {
				String test = request.getParameter("userId");
				int userId = Integer.parseInt(test);
				MemberDAO memDao = new MemberDAO();
				memDao.updateLeaveDay(userId);
				request.setAttribute("messege", "削除");
				request.getRequestDispatcher("/complete.jsp").forward(request, response);
				return;

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
