package ls.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteMenberInfoServlet
 */
@WebServlet("/DeleteMemberInfoServlet")
public class DeleteMemberInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemberInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		try {
			request.setCharacterEncoding("UTF-8");
			//パラメーターの取得
			String userId = request.getParameter("userId");
			//DAOが入る

			//削除メソッドを呼び出す
			int count = dao.delete(userId)
			//削除するものをリクエストスコープに入れる
			request.setAttribute("count", count);

			//例外処理
		}catch (IllegalStateException e) {
			error ="エラーです";
		}catch (Exception e) {
			error ="エラーです";
		}finally {
			request.setAttribute("error", error);
			request.getRequestDispatcher("/LibrarySystem/complete").forward(request, response);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
