package ls.servlet;

import java.io.IOException;
import java.sql.Date;

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

			String action = XSS.escape(request.getParameter("action"));
			LendingDAO lendDao = new LendingDAO();
			//session情報をとってこい、「session」に格納しろ、session情報がなかったら「ssesion」にはnullをぶちこめ
			HttpSession session = request.getSession(false);
			if(session == null) {
				gotoPage(request, response, "/LoginServlet");
			}

			if(action == null || action.length() == 0 || action.equals("reInput")) {
					gotoPage(request, response, "/lendingInput.jsp");
				}else if(action.equals("check")) {
					String memo = XSS.escape(request.getParameter("memo"));
					String userIdStr = XSS.escape(request.getParameter("userId"));
					String bookIdStr = XSS.escape(request.getParameter("bookId"));

					if(userIdStr == null || userIdStr.length() == 0 || bookIdStr == null || bookIdStr.length() == 0 ) {
						request.setAttribute("message","会員IDか資料IDが入力されていません。");
						gotoPage(request, response, "/errMessage.jsp");

					}
					int userId = Integer.parseInt(userIdStr);
					int bookId = Integer.parseInt(bookIdStr);

					String userName = lendDao.returnUserName(userId);

					RecordDAO rDao = new RecordDAO();
					CatalogDAO cDao = new CatalogDAO();

					// recordテーブルからbook_idがマッチする行をとってくる
					RecordBean rBean =  rDao.getRecordInfoByBookId(bookId);
					if(rBean == null) {
						request.setAttribute("message","存在しない資料IDです。");
						gotoPage(request, response, "/errMessage.jsp");
					}
					// book_idが一致する行のisbn番号を取得する
					long isbn = rBean.getIsbn();
					// catalogテーブルからisbn番号がマッチする行をとってくる
					CatalogBean cBean = cDao.getCatalogInfoByIsbn(isbn);
					// 本の名前がとってこれる
					String bookName = cBean.getBookName();

					//↑Stringで各情報がそろった⇒情報のチェック↓
					if(userName == null || userName.length() == 0){
						request.setAttribute("message", "存在しない会員IDです。");
						gotoPage(request, response, "/errMessage.jsp");
					}else if(lendDao.existsUnreturnedBook(bookId)) {
						request.setAttribute("message", "すでに貸出されています");
						gotoPage(request, response, "/errMessage.jsp");
					}
					Date stockDate = rBean.getStockDay();

					// 入荷日が今日から三か月以内か確認する
					Date today = OperateDate.getDateNow();
					int elapsedDay = OperateDate.calcElapsedDay(stockDate, today);

					Date returnLimitDay;

					// if 三か月以内
					if(elapsedDay <= 90) {
						// 10日足した日付を返却日時とする
						returnLimitDay = OperateDate.plusDate(today, 10);

					}else {
						// if 三か月より前
						// 15日足した日付を返却日時とする
						returnLimitDay = OperateDate.plusDate(today, 15);
					}

					Date lendDay = OperateDate.getDateNow();
					LendingBean lendingbean = new LendingBean(bookId, bookName, userId, userName,lendDay,returnLimitDay, memo);
					session.setAttribute("lendingBeanForLendingBook", lendingbean);
					gotoPage(request, response, "/checkLending.jsp");
				}else if(action.equals("complete")&&(session != null)) {
			//貸出台帳に登録（INSERT）、貸出完了メッセージの送信、完了画面の表示
					//sessionからBeanを取得、intId,memoの抽出
					// TODO:displayInfoの命名を変える（被らないように）
					LendingBean lendingbean = (LendingBean)session.getAttribute("lendingBeanForLendingBook");
					int userIdInsert = lendingbean.getUserId();
					int bookIdInsert = lendingbean.getBookId();
					String memoInsert = lendingbean.getMemo();
					Date today = lendingbean.getLendDay();
					Date returnLimitDay = lendingbean.getReturnLimit();



					// bookIdから入荷日を取り出してくる return java.sql.Date



					lendDao.addLending(userIdInsert, bookIdInsert, today, returnLimitDay, memoInsert);
					request.setAttribute("message", "貸出");
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
