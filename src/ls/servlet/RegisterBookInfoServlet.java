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
import ls.dao.CatalogDAO;
import ls.dao.DAOException;
import ls.module.OperateDate;

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

			String action = request.getParameter("action");
			HttpSession session = request.getSession(false);
			if(session == null) {
				gotoPage(request, response, "/login.jsp");
			}
			if(action == null || action.length() == 0 || action.equals("reInput")) {
				gotoPage(request, response, "/inputRecord.jsp");
			}else if(action.equals("checkIsbn")) {
				long isbn = Long.parseLong(request.getParameter("isbn"));

				session.setAttribute("isbnForRegisterBook", isbn);
				String memo = request.getParameter("memo");

				CatalogDAO catalogDao = new CatalogDAO();
				boolean existsIsbn = catalogDao.existsIsbn(isbn);

				if(existsIsbn) {
					// isbnの検索結果が存在しないということは書籍情報が登録されていないということ
					// 書籍情報を登録するところから始める
					gotoPage(request, response, "/checkBookInfo.jsp");
				}else {
					gotoPage(request, response, "/inputCatalog.jsp");
				}
			}else if(action.equals("registerCatalog")) {
				long isbn = Long.parseLong(request.getParameter("isbn"));
				String bookName = request.getParameter("title");
				int category= Integer.parseInt(request.getParameter("category"));
				String author = request.getParameter("author");
				String publisher = request.getParameter("publisher");
				int publishedY = Integer.parseInt(request.getParameter("publishedY"));
				int publishedM = Integer.parseInt(request.getParameter("publishedM"));
				int publishedD = Integer.parseInt(request.getParameter("publishedD"));

				try {
					Date publishDay = OperateDate.getJavaSqlDateOfYMD(publishedY,publishedM,publishedD);

					CatalogDAO catalogDao = new CatalogDAO();
					CatalogBean cBean = new CatalogBean(isbn,bookName,category,author,publisher,publishDay);

					catalogDao.addCatalogInfo(cBean);


					// parse出来ない時(日付の入力に不正な値が入っている時)
				}catch (ParseException e) {
					e.printStackTrace();
					request.setAttribute("message", "不正な日付です");
					gotoPage(request, response, "/errMessage.jsp");
				}






			}
		}catch(DAOException e) {
			e.printStackTrace();
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
