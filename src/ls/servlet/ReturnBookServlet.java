package ls.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ls.bean.CatalogBean;
import ls.bean.RecordBean;
import ls.bean.ReturnBean;
import ls.dao.CatalogDAO;
import ls.dao.DAOException;
import ls.dao.LendingDAO;
import ls.dao.RecordDAO;
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
			HttpSession session1 = request.getSession(false);
			HttpSession session2 = request.getSession(false);
			HttpSession session3 = request.getSession(false);

			if(action == null || action.length() == 0 || action.equals("reInput")) {

				gotoPage(request, response, "/returnInput.jsp");

			}else if(action.equals("check")) {

				String bookId = request.getParameter("bookId");
				int bookIdInt = Integer.parseInt(bookId);
				ReturnBean ReturnInfo = dao.returnInfo(bookIdInt);

				String userId = request.getParameter("userId");
				int userIdInt = Integer.parseInt(userId);
				LendingDAO lDao = new LendingDAO();
				//userIdとってくる
				String userName = lDao.returnUserName(userIdInt);

				//record id,isbn catalog isbn,name（Lendingパクリ）
				RecordDAO rDao = new RecordDAO();
				CatalogDAO cDao = new CatalogDAO();
				// recordテーブルからbook_idがマッチする行をとってくる
				RecordBean rBean =  rDao.getRecordInfoByBookId(bookIdInt);
				// book_idが一致する行のisbn番号を取得する
				long isbn = rBean.getIsbn();
				// catalogテーブルからisbn番号がマッチする行をとってくる
				CatalogBean cBean = cDao.getCatalogInfoByIsbn(isbn);
				// 本の名前がとってこれる
				String bookName = cBean.getBookName();



				if(bookId == null || bookId.length() == 0) {
					request.setAttribute("errMessage", "書籍IDを入力してください");
					gotoPage(request, response, "/errMessage.jsp");

				}else {
					session1.setAttribute("displayInfo1", ReturnInfo);
					session2.setAttribute("USERNAME", userName);
					session3.setAttribute("BOOKNAME", bookName);
					gotoPage(request, response, "/checkReturn.jsp");
				}

			}else if(action.equals("complete")&&(session1 != null)) {

				ReturnBean returnbean = (ReturnBean)session1.getAttribute("displayInfo");
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
