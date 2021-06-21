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
			//session情報をとってこい、「session」に格納しろ、session情報がなかったら「ssesion」にはnullをぶちこめ
			HttpSession session = request.getSession(false);
			if(action == null || action.length() == 0 || action.equals("reInput")) {
					gotoPage(request, response, "/lendingInput.jsp");
				}else if(action.equals("check")) {
					String memo = request.getParameter("memo");
					String userId = request.getParameter("userId");
					String bookId = request.getParameter("bookId");
					int userIdInt = Integer.parseInt(userId);
					int bookIdInt = Integer.parseInt(bookId);

					String userName = dao.returnUserName(userIdInt);
					String bookName = dao.returnBookName(bookIdInt);

					//↑Stringで各情報がそろった⇒情報のチェック↓
					if(userId == null || userId.length() == 0 || bookId == null || bookId.length() == 0) {
						request.setAttribute("errMessage", "すべての情報を入力してください");
						gotoPage(request, response, "/errMessage.jsp");
					}else if(userName == null || userName.length() == 0 || bookName == null || bookName.length() == 0){
						request.setAttribute("errMessage", "DB内の会員名もしくは資料名が不正です");
						gotoPage(request, response, "/errMessage.jsp");
					}else {
						LendingBean lendingbean = new LendingBean(memo, bookId, bookName, userId, userName, userIdInt, bookIdInt);
						session.setAttribute("displayInfo", lendingbean);
						gotoPage(request, response, "/checkLending.jsp");
						}
				}else if(action.equals("complete")&&(session != null)) {
			//貸出台帳に登録（INSERT）、貸出完了メッセージの送信、完了画面の表示
					//sessionからBeanを取得、intId,memoの抽出
					LendingBean lendingbean = (LendingBean)session.getAttribute("lendingbean");
					int userIdInsert = lendingbean.getUserIdInt();
					int bookIdInsert = lendingbean.getBookIdInt();
					String memoInsert = lendingbean.getMemo();

					Calender returnLimit;
					//returnLimitの取得
						//returnLimit = today + 10 or 15 days
						//if で addDays(10 or 15)の場合分け


					dao.addLending(userIdInsert, bookIdInsert, returnLimitInsert, memoInsert);
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
