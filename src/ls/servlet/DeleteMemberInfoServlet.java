package ls.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ls.bean.MemberBean;
import ls.dao.DAOException;
import ls.dao.LendingDAO;
import ls.dao.MemberDAO;
import ls.module.XSS;

@WebServlet("/DeleteMemberInfoServlet")
public class DeleteMemberInfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String action = XSS.escape(request.getParameter("action"));
			//HttpSession session = request.getSession(false);
			if(action == null || action.length() == 0 ) {
				request.setAttribute("mode", "delete");
				gotoPage(request, response, "/inputMemID.jsp");
			}
			else if(action.equals("delete") ) {
				MemberDAO memDao = new MemberDAO();
				int MemID;
				try {
					MemID = Integer.parseInt(XSS.escape(request.getParameter("MemID")));
					MemberBean Mbean = memDao.findMemberByMemID(MemID);
					if(Mbean == null) {
						request.setAttribute("message", "存在しない会員IDです。");
						gotoPage(request, response, "/errMessage.jsp");
					}
					request.setAttribute("member", Mbean);

					LendingDAO lenDao = new LendingDAO();
					int useID = Mbean.getUserId();
					boolean OnLoan = lenDao.existsUnreturnedBookNow(useID);
					request.setAttribute("lending", OnLoan);
					gotoPage(request, response, "/deleteMem.jsp");
			} catch (NumberFormatException e) {
				e.printStackTrace();
				request.setAttribute("message", "会員IDを入力してください。");
				gotoPage(request, response, "/errMessage.jsp");
			}
			}
			else if(action.equals("complete")) {
				MemberDAO memDao = new MemberDAO();
				int MemID = Integer.parseInt(XSS.escape(request.getParameter("MemID")));
				memDao.updateLeaveDay(MemID);
				request.setAttribute("message", "退会");
				request.getRequestDispatcher("/complete.jsp").forward(request, response);

			} else if (action.equals("cannot")) {
				request.setAttribute("message", "資料を返却してください。");
				request.getRequestDispatcher("/errMessage.jsp").forward(request, response);

			}



		}catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			//gotoPage(request, response, "/errInternal.jsp");
			request.getRequestDispatcher("/errInternal.jsp").forward(request, response);
		    }catch(NumberFormatException e) {
				e.printStackTrace();
				request.setAttribute("message", "数字を入力してください。");
				gotoPage(request, response, "/errMessage.jsp");
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
