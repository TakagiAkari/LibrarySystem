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
;
/**
 * Servlet implementation class SearchMemberServlet
 */
@WebServlet("/SearchMemberServlet")
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

			String action = request.getParameter("acttion");

			MemberDAO dao = new MemberDAO();

			if (action.equals("search")) {
				String email = request.getParameter("email");
				List<MemberBean> list = dao.findByEmail(email);

				request.setAttribute("members", list);
				gotoPage(request, response, "/resultMem.jsp");
			}
			else {
				request.setAttribute("message","正しく操作してしてください。");
				gotoPage(request, response, "/errIntenal.jsp");
			}

		}
		catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request, response, "/errInternal.jsp");
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