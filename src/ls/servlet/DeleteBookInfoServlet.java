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
import ls.dao.CatalogDAO;
import ls.dao.DAOException;
import ls.dao.RecordDAO;

/**
 * Servlet implementation class DeleteBookInfoServlet
 */
@WebServlet("/DeleteBookInfoServlet")
public class DeleteBookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		try {
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");
			HttpSession session = request.getSession(false);
			if(action == null || action.length() == 0 ) {
				gotoPage(request, response, "/inputBookID.jsp");
			}
			else if(action.equals("work") ) {

				RecordDAO recDao = new RecordDAO();
				CatalogDAO catDao = new CatalogDAO();
				int bookID = Integer.parseInt(request.getParameter("bookId"));
				RecordBean rb = recDao.findRecordByBookID(bookID);
				long isbn = rb.getIsbn();
				CatalogBean cb = catDao.getCatalogInfoByIsbn(isbn);
				String bookName = cb.getBookName();
				String author = cb.getAuthor();
				String publisher = cb.getPublisher();

				request.setAttribute("record", rb);
				request.setAttribute("catalog", cb);

				gotoPage(request, response, "/deleteBook.jsp");

			}
			else if(action.equals("complete")) {
				RecordDAO recDao = new RecordDAO();
				int bookId = Integer.parseInt(request.getParameter("bookId"));
				recDao.updateThrowoutDay(bookId);
				request.setAttribute("message", "削除");
				request.getRequestDispatcher("/complete.jsp").forward(request, response);
			}
		}catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			request.getRequestDispatcher("/errInternal.jsp").forward(request, response);
		}finally {
		}
	}

private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
