package ls.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ls.bean.LendingBean;
import ls.dao.LendingDAO;


@WebServlet("/ReteunBookServlet")
public class ReteunBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public ReteunBookServlet() {
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






			if(action == null || action.length() == 0 || action.equals("reInput")) {
				gotoPage(request, response, "/returnInput.jsp");
			}else if(action.equals("check")) {
				String bookId = request.getParameter("bookId");
				int bookIdserch = Integer.parseInt(bookId);




				if(bookId == null || bookId.length() == 0) {
					request.setAttribute("errMessage", "書籍IDを入力してください");
					gotoPage(request, response, "/errMessage.jsp");
				}else {
					//返却情報を表示


					session.setAttribute("displayInfo", lendingbean);
					gotoPage(request, response, "/checkLending.jsp");
					}
			}else if(action.equals("complete")&&(session != null)) {
			}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
