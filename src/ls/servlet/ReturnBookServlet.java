package ls.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ls.bean.ReturnBean;
import ls.dao.DAOException;
import ls.dao.ReturnDAO;

@WebServlet("/ReturnBookServlet")
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public ReturnBookServlet() {
        super();
    }


    private void gotoPage (HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher(page);
    	rd.forward(request, response);
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");

			String action = request.getParameter("action");
			ReturnDAO dao = new ReturnDAO();
			HttpSession session = request.getSession(false);

			if(action == null || action.length() == 0 || action.equals("reInput")) {

				gotoPage(request, response, "/returnInput");

			}else if(action.equals("check")) {

				String bookId = request.getParameter("bookId");
				int bookIdInt = Integer.parseInt(bookId);
				ReturnBean ReturnInfo = dao.returnInfo(bookIdInt);
				if(bookId == null || bookId.length() == 0) {
					request.setAttribute("errMessage", "書籍IDを入力してください");
					gotoPage(request, response, "/errMessage.jsp");

				}else {
					session.setAttribute("displayInfo", ReturnInfo);
					gotoPage(request, response, "/checkreturn.jsp");
				}

			}else if(action.equals("complete")&&(session != null)) {

				ReturnBean returnbean = (ReturnBean)session.getAttribute("ReturnInfo");
				int bookId = returnbean.getBookId();
				java.sql.Date returnDay = returnbean.getReturnDay();

			    dao.recordReturnDay(returnDay, bookId);


			    request.setAttribute("message", "返却処理");
				gotoPage(request, response, "/complete.jsp");
			}
			}catch(DAOException e) {
				e.printStackTrace();
			}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
