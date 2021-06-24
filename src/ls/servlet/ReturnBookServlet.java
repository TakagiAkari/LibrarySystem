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
import ls.bean.LendingBean;
import ls.bean.RecordBean;
import ls.dao.CatalogDAO;
import ls.dao.DAOException;
import ls.dao.LendingDAO;
import ls.dao.RecordDAO;
import ls.module.OperateDate;
import ls.module.XSS;

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

			String action = XSS.escape(request.getParameter("action"));

			LendingDAO lDao = new LendingDAO();
			HttpSession session = request.getSession(false);

			if(action == null || action.length() == 0 || action.equals("reInput")) {

				gotoPage(request, response, "/returnInput.jsp");

			}else if(action.equals("check")) {

				String bookId = XSS.escape(request.getParameter("bookId"));
				// 入力確認
				if(bookId == null || bookId.length() == 0) {
					request.setAttribute("message", "値が入力されていません。");
					gotoPage(request, response, "/errMessage.jsp");
				}

				int bookIdInt = Integer.parseInt(bookId);

				// TODO:userIdはlendingテーブルからとってくる
				LendingBean lBean = lDao.getUnreturnedBookByBookId(bookIdInt);

				if(lBean == null) {
					request.setAttribute("message", "この書籍は貸し出されていません");
					gotoPage(request, response, "/errMessage.jsp");
				}
				// 今日の日付を返却日とする
				lBean.setReturnDay(OperateDate.getDateNow());
				int userIdInt =  lBean.getUserId();
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
					session.setAttribute("lendingBeanForReturnBook", lBean);
					session.setAttribute("userNameForReturnBook", userName);
					session.setAttribute("bookNameForReturnBook", bookName);
					gotoPage(request, response, "/checkReturn.jsp");
				}

			}else if(action.equals("complete")&&(session != null)) {

				LendingBean lendingBean = (LendingBean)session.getAttribute("lendingBeanForReturnBook");
				int bookId = lendingBean.getBookId();
				java.sql.Date returnDay = lendingBean.getReturnDay();
			    lDao.updateReturnDay(returnDay, bookId);


			    request.setAttribute("message", "返却処理");
				gotoPage(request, response, "/complete.jsp");
			}
			}catch(DAOException e) {
				e.printStackTrace();
		    }catch(NumberFormatException e) {
				e.printStackTrace();
				request.setAttribute("message", "数字を入力してください。");
				gotoPage(request, response, "/errMessage.jsp");
		    }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
