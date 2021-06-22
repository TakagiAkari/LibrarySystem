package ls.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ls.bean.CatalogBean;
import ls.bean.RecordBean;
import ls.dao.CatalogDAO;
import ls.dao.DAOException;
import ls.dao.RecordDAO;
import ls.module.OperateDate;

/**
 * Servlet implementation class ChangeBookInfoServlet
 */
@WebServlet("/ChangeBookInfoServlet")
public class ChangeBookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeBookInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		request.setCharacterEncoding("UTF-8");
		if (session == null) {
			request.setAttribute("message", "正しく入力してください");
			gotoPage(request, response, "/errMessage.jsp");
			return;
		}

		try {
			//パラメータの取得
			String action = request.getParameter("action");

			if (action == null || action.length() == 0 || action.equals("change_action")) {
				gotoPage(request, response, "/inputBookID.jsp");
			//会員idを入力して変更をクリックで変更情報入力画面へいく
			} else if(action.equals("change")) {
				RecordDAO Rdao = new RecordDAO();
				CatalogDAO Cdao = new CatalogDAO();
				int bookId = Integer.parseInt(request.getParameter("bookId"));
			//recordテーブルからbookIdが合う情報をとってくる
				RecordBean Rbean =Rdao.getRecordInfoByBookId(bookId);
				if (Rbean == null) {
					request.setAttribute("message", "正しく入力してください");
					gotoPage(request,response, "/errMessage.jsp");
					return;
				}
				session.setAttribute("PreviousRecordInfo",Rbean);
			//bookIdが一致する行のisbn番号を取得する
				long isbn = Rbean.getIsbn();
			//catalogテーブルからisbn番号がマッチする行をとってくる
				CatalogBean Cbean = Cdao.getCatalogInfoByIsbn(isbn);
			//本の名前、作者、出版社、出版日がとってこれる
				//String bookName = Cbean.getBookName();
			//String author = Cbean.getAuthor();
			//tring publisher = Cbean.getPublisher();
				//Date publishDay = Cbean.getPublishDay();
			//catalogBeanを定義する

				session.setAttribute("PreviousCatalogInfo",Cbean);
				gotoPage(request, response, "/changeBookInfo.jsp");
			//nextをクリックで変更前の情報表示を行う
			} else if (action.equals("show")) {
				int bookId = Integer.parseInt(request.getParameter("bookId"));
				Long isbn = Long.parseLong(request.getParameter("isbn"));
				String bookName = request.getParameter("bookName");
				String author = request.getParameter("author");
				//int category = Integer.parseInt(request.getParameter("category"));
				String publisher = request.getParameter("publisher");
				int publishedY = Integer.parseInt(request.getParameter("publishedY"));
				int publishedM = Integer.parseInt(request.getParameter("publishedM"));
				int publishedD = Integer.parseInt(request.getParameter("publishedD"));

			//publshedY,publishedM,publishedDの型変換
				CatalogBean Cbean = (CatalogBean)session.getAttribute("PreviousCatalogInfo");
				int category = Cbean.getCategory();
				RecordBean Rbean = (RecordBean)session.getAttribute("PreviousRecordInfo");
				String memo = Rbean.getMemo();

		try {
				Date publishDay = OperateDate.getJavaSqlDateOfYMD(publishedY,publishedM,publishedD);
				RecordBean LaterRecordInfo = new RecordBean(bookId,isbn, publishDay, memo);
				CatalogBean LaterCatalogInfo = new CatalogBean(isbn,bookName,category,author,publisher,publishDay);
				//session.setAttribute("PreviousCatalogInfo",category);
				//session.getAttribute(Integer.toString(category));
				session.setAttribute("LaterRecordInfo", LaterRecordInfo);
				session.setAttribute("LaterCatalogInfo", LaterCatalogInfo);
				gotoPage(request, response, "/checkBookAlt.jsp");
			} catch (ParseException e) {
				e.printStackTrace();
				request.setAttribute("message", "不正な情報です");
				gotoPage(request, response, "/errMessage.jsp");
				}

			// nextは変更確定
			}else if (action.equals("complete")&&(session != null)) {
				RecordBean LaterRecordInfo = (RecordBean)session.getAttribute("LaterRecordInfo");
				CatalogBean LaterCatalogInfo = (CatalogBean) session.getAttribute("LaterCatalogInfo");
				CatalogDAO Cdao = new CatalogDAO();
				Cdao.ChangeBookInfo(LaterRecordInfo);
				Cdao.ChangeBookInfo(LaterCatalogInfo);
			if (LaterCatalogInfo == null) { //書籍変更情報がない
				request.setAttribute("message", "正しく操作してください");
				gotoPage(request, response, "/errMessage.jsp");
				return;
				}
			//変更後はセッション情報をクリアにする
				session.removeAttribute("PreviousRecordBean");
				session.removeAttribute("PreviousCatalogBean");
			//変更情報をユーザに送る
				request.setAttribute("message", "変更");
				gotoPage(request, response, "/complete.jsp");
			}
		    } catch (DAOException e) {
		    	e.printStackTrace();
		    	request.setAttribute("message", "内部エラーが発生しました");
		    	gotoPage(request, response, "/errMessage.jsp");
		    }
	    }

	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
