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
import ls.module.XSS;

/**
 * Servlet implementation class RegisterBookInfoServlet
 */
@WebServlet("/RegisterBookInfoServlet")
public class RegisterBookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterBookInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");

			CatalogDAO catalogDao = new CatalogDAO();
			RecordDAO recordDao = new RecordDAO();
			String action = XSS.escape(request.getParameter("action"));
			HttpSession session = request.getSession(false);
			if(session == null) {
				gotoPage(request, response, "/login.jsp");
			}
			if(action == null || action.length() == 0 || action.equals("reInput")) {
				gotoPage(request, response, "/inputRecord.jsp");
			}else if(action.equals("checkIsbn")) {
				long isbn = Long.parseLong(XSS.escape(request.getParameter("isbn")));
				String memo = XSS.escape(request.getParameter("memo"));

				session.setAttribute("isbnForRegisterBook", isbn);
				session.setAttribute("memoForRegisterBook", memo);

				boolean existsIsbn = catalogDao.existsIsbn(isbn);

				if(existsIsbn) {
					// isbn?????????????????????????????????????????????????????????????????????????????????????????????
					//TODO:test
					RecordBean rBean = new RecordBean(isbn, OperateDate.getDateNow(),memo);
					String bookIdStr = String.valueOf(recordDao.getNextBookId());
					System.out.println(bookIdStr);
					session.setAttribute("bookIdForRegisterBook",bookIdStr);
					session.setAttribute("recordBeanForRegisterBook", rBean);
					CatalogBean cBean = catalogDao.getCatalogInfoByIsbn(isbn);
					session.setAttribute("catalogBeanForRegisterBook", cBean);
					gotoPage(request, response, "/checkBookInfo.jsp");
				}else {
					// isbn?????????????????????????????????????????????????????????????????????????????????????????????????????????
					// ???????????????????????????????????????????????????
					gotoPage(request, response, "/inputCatalog.jsp");
				}
			}else if(action.equals("registerCatalog")) {
				long isbn = (long)session.getAttribute("isbnForRegisterBook");
				String bookName = XSS.escape(request.getParameter("title"));
				int category= Integer.parseInt(XSS.escape(request.getParameter("category")));
				String author = XSS.escape(request.getParameter("author"));
				String publisher = XSS.escape(request.getParameter("publisher"));
				int publishedY = Integer.parseInt(XSS.escape(request.getParameter("publishedY")));
				int publishedM = Integer.parseInt(XSS.escape(request.getParameter("publishedM")));
				int publishedD = Integer.parseInt(XSS.escape(request.getParameter("publishedD")));

				try {
					Date publishDay = OperateDate.getJavaSqlDateOfYMD(publishedY,publishedM,publishedD);

					CatalogBean cBean = new CatalogBean(isbn,bookName,category,author,publisher,publishDay);

					String memo = (String) session.getAttribute("memoForRegisterBook");

					RecordBean rBean = new RecordBean(isbn, OperateDate.getDateNow(),memo);

					session.setAttribute("recordBeanForRegisterBook", rBean);

					// ??????????????????????????????????????????????????????????????????ID??????????????????
					// RecordDAO.getNextBookId();
					// ?????????????????????????????????????????????ID????????????????????????????????????????????????????????????
					// book_id??????????????????????????????
					String bookIdStr = String.valueOf(recordDao.getNextBookId());
					System.out.println(bookIdStr);
					session.setAttribute("bookIdForRegisterBook",bookIdStr);

					session.setAttribute("catalogBeanForRegisterBook", cBean);
					gotoPage(request, response, "/checkBookInfo.jsp");
				}catch (ParseException e) {
					e.printStackTrace();
					request.setAttribute("message", "?????????????????????");
					gotoPage(request, response, "/errMessage.jsp");
				}
			}else if(action.equals("complete")) {
				long isbn = (long)session.getAttribute("isbnForRegisterBook");
				String memo = (String) session.getAttribute("memoForRegisterBook");
				CatalogBean cBean = (CatalogBean) session.getAttribute("catalogBeanForRegisterBook");

				// ??????isbn????????????????????????????????????
				catalogDao.addCatalogInfo(cBean);

				recordDao.addRecordInfo(isbn, memo);
				request.setAttribute("message", "????????????");
				gotoPage(request, response, "/complete.jsp");
			}
		}catch(DAOException e) {
			e.printStackTrace();
			gotoPage(request, response, "/errMessage.jsp");
		}catch(NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("message", "????????????????????????????????????");
			gotoPage(request, response, "/errMessage.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
    private void gotoPage (HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher(page);
    	rd.forward(request, response);
    }

}
