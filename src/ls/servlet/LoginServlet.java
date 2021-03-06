package ls.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ls.module.XSS;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     /
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CORRECT_USER_NAME = "admin";
		String CORRECT_PASSWORD = "himitu";
		request.setCharacterEncoding("UTF-8");
		String userName = XSS.escape(request.getParameter("userName"));
		String password = XSS.escape(request.getParameter("password"));
		String action = XSS.escape(request.getParameter("action"));
		System.out.println("テスト");
		System.out.println(XSS.escape(userName));
		System.out.println(userName);

		HttpSession session = request.getSession(false);

		// sessionを持っていてisLoginがtrueならすでにログインしているものとして扱う
		// 飛んできたときactionがログアウトでなければ（nullでも良い)そのまま投稿ページに飛ばすことを試みる
		if(session != null && (action == null || !action.equals("logout"))) {
			String isLogin = (String)session.getAttribute("isLogin");
			System.out.println();
			if(isLogin != null && isLogin.equals("true")) {
				// ログイン済みの処理を書いてreturnする
				gotoPage(request, response, "/top.jsp");
				return ;
			}
		}

		if(action == null || action.equals("login")) {

			// sessionを持っていなければログインしていないためログイン処理に入る
			if(userName == null || userName.length() == 0 || password == null || password.length() == 0) {
				gotoPage(request, response, "/login.jsp");
				return ;
			}

			if(userName.equals(CORRECT_USER_NAME) && password.equals(CORRECT_PASSWORD)){
				session.setAttribute("isLogin", "true");
				gotoPage(request, response, "/top.jsp");
			}else {
				request.setAttribute("message", "正しいユーザ名とパスワードを入力してください");
				gotoPage(request, response, "/errMessage.jsp");
				return ;
			}
		}else if(action.equals("logout")){
			session.setAttribute("isLogin", "false");
			gotoPage(request, response, "/login.jsp");
			return ;


		}else {
			// actionがnullでもなく、loginでもlogoutでもない場合
			gotoPage(request, response, "/login.jsp");
			return ;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);

	}

}
