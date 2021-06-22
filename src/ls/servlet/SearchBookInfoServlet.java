package ls.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ls.bean.CatalogBean;
import ls.bean.RecordBean;
import ls.dao.CatalogDAO;
import ls.dao.DAOException;
import ls.dao.RecordDAO;

/**
 * Servlet implementation class SearchBookInfoServlet
 */
@WebServlet("/SearchBookInfoServlet")
public class SearchBookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchBookInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8");

			String action = request.getParameter("action");

			//topから資料検索をリンクした場合・サーブレットに直接飛んできた場合
			if (action == null || action.length() == 0) {
				request.setAttribute("mode", "search");
				gotoPage(request, response, "/inputBookID.jsp");
			}

			//BookID入力画面で検索ボタンを押した場合
			else if (action.equals("work")) {
				int bookId = Integer.parseInt(request.getParameter("bookId"));

				RecordDAO RD = new RecordDAO();

				RecordBean RB = RD.findByBookId(bookId);

				String BookId = Integer.toString(bookId);

				//該当資料が存在する
				if (RB != null) {
					CatalogDAO CD = new CatalogDAO();
					long isbn = RB.getIsbn();
					CatalogBean CB = CD.findByIsbn(isbn);
					request.setAttribute("record", RB);
					request.setAttribute("catalog", CB);
					gotoPage(request, response, "/resultBook.jsp");
				}
				//資料IDが入力されていない
				else if (BookId == null || BookId.length() == 0) {
					request.setAttribute("message","資料IDを入力してください。");
					gotoPage(request, response, "/errMessage.jsp");
				}
				//該当資料が存在しない
				else {
					request.setAttribute("message","該当資料がありません。");
					gotoPage(request, response, "/errMessage.jsp");
				}
			}

			//その他
			else {
				request.setAttribute("message","書籍IDを正しく入力してください。");
				gotoPage(request, response, "/errMessage.jsp");
			}
		}

		catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request, response, "/errMessage.jsp");
		}

	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
