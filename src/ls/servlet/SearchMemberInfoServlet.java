package ls.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ls.bean.MemberBean;
import ls.dao.DAOException;
import ls.dao.MemberDAO;
import ls.module.XSS;

/**
 * Servlet implementation class SearchMemberServlet
 */
@WebServlet("/SearchMemberInfoServlet")
public class SearchMemberInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMemberInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8");

			String action = XSS.escape(request.getParameter("action"));

			MemberDAO dao = new MemberDAO();

			//サーブレットに直接飛んできた場合・topから会員検索をリンクした場合
			if (action == null || action.length() == 0 ) {
				gotoPage(request, response, "/inputMail.jsp");
			}
			//email入力画面で検索ボタンを押した場合
			else if (action.equals("search")) {
				String email = XSS.escape(request.getParameter("email"));
				MemberBean member = dao.findByEail(email);

				//該当者が存在する
				if (member != null) {
					request.setAttribute("member", member);
					gotoPage(request, response, "/resultMem.jsp");
				}
				//emailが入力されていない
				else if (email == null || email.length() == 0) {
					request.setAttribute("message","メールアドレスを入力してください。");
					gotoPage(request, response, "/errMessage.jsp");
				}
				//該当者が存在しない
				else {
					request.setAttribute("message","該当者がいません。");
					gotoPage(request, response, "/errMessage.jsp");
				}
			}
			//その他
			else {
				request.setAttribute("message","正しく操作してしてください。");
				gotoPage(request, response, "/errMessage.jsp");
			}
		}
		catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request, response, "/errMessage.jsp");
		    }catch(NumberFormatException e) {
				e.printStackTrace();
				request.setAttribute("message", "数字を入力してください。");
				gotoPage(request, response, "/errMessage.jsp");
		    }
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
