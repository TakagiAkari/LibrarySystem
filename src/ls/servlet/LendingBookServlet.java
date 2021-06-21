package ls.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ls.bean.LendingBean;
import ls.dao.DAOException;
import ls.dao.LendingDAO;

@WebServlet("/LendingBookServlet")
public class LendingBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public LendingBookServlet() {
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
			LendingDAO dao = new LendingDAO();
			//
			HttpSession session = request.getSession(false);
			if(action == null || action.length() == 0 || action.equals("reInput")) {
					gotoPage(request, response, "/lendingInput.jsp");
				}else if(action.equals("check")) {
					String userId = request.getParameter("userId");
					String bookId = request.getParameter("bookId");
					int userIdserch = Integer.parseInt(userId);
					int bookIdserch = Integer.parseInt(bookId);
					String userName = dao.returnUserName(userIdserch);
					String bookName = dao.returnBookName(bookIdserch);
					//↑Stringで各情報がそろった⇒情報のチェック↓
					if(userId == null || userId.length() == 0 || bookId == null || bookId.length() == 0) {
						request.setAttribute("errMessage", "すべての情報を入力してください");
						gotoPage(request, response, "/errMessage.jsp");
					}else if(userName == null || userName.length() == 0 || bookName == null || bookName.length() == 0){
						request.setAttribute("errMessage", "DB内の会員名もしくは資料名が不正です");
						gotoPage(request, response, "/errMessage.jsp");
					}else {
						LendingBean lendingbean = new LendingBean(bookId, bookName, userId, userName);
						session.setAttribute("displayInfo", lendingbean);
						gotoPage(request, response, "/checkLending.jsp");
						}
				}else if(action.equals("complete")&&(session != null)) {
			//貸出台帳に登録（INSERT）、貸出完了メッセージの送信、完了画面の表示



					dao.addLending(userId, bookId, returnLimit, memo);
					request.setAttribute("message", "貸出");
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
