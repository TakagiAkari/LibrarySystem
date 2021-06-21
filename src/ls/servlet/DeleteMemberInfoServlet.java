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
			HttpSession session = request.getSession(false);
			if(action == null || action.length() == 0 ) {
				gotoPage(request, response, "/inputMemID.jsp");
			}
			else if(action.equals("delete") ) {

				MemberDAO memDao = new MemberDAO();
				int userId = Integer.parseInt(request.getParameter("userId"));
				MemberBean bean = memDao.findMemberByUserID(userId);
				request.setAttribute("member", bean);
				gotoPage(request, response, "/deleteMem.jsp");

			}
			else if(action.equals("complete")) {
				MemberDAO memDao = new MemberDAO();
				int userId = Integer.parseInt(request.getParameter("userID"));
				memDao.updateLeaveDay(userId);
				request.setAttribute("message", "削除");
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


	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String strUrl) {
		try {
			request.getRequestDispatcher(strUrl).forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
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
