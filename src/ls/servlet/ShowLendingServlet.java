package ls.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ls.bean.LendingBean;
import ls.dao.DAOException;
import ls.dao.LendingDAO;
/**
 * Servlet implementation class ShowLendingServlet
 */
@WebServlet("/ShowLendingServlet")
public class ShowLendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowLendingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//パラメータの解析

		//モデルを用いて貸出履歴を取得する
		try {
			LendingDAO dao = new LendingDAO();
			List<LendingBean> list = dao.findAll();
			//Listをリクエストスコープに入れる
			request.setAttribute("lending", list);
			//JSPにフォワードする
			RequestDispatcher rd = request.getRequestDispatcher("/showLending.jsp");
			rd.forward(request, response);
		}
		catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			RequestDispatcher rd = request.getRequestDispatcher("/errMessage.jsp");
			rd.forward(request, response);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("message", "数字を入力してください。");
			RequestDispatcher rd = request.getRequestDispatcher("/errMessage.jsp");
			rd.forward(request, response);
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
