package ls.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ls.bean.MemberBean;
import ls.dao.DAOException;

/**
 * Servlet implementation class ChangeMenberInfoServlet
 */
@WebServlet("/ChangeMenberInfoServlet")
public class ChangeMenberInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeMenberInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession(false);
			MemberBean bean = (MemberBean) session.getAttribute("member");
			if (session == null) {
				request.setAttribute("message", "正しく入力してください");
				gotoPage(request, response, "/errInternal.jsp");
				return;
			}

			try {
				//パラメータの取得
				String action = request.getParameter("action");
				member DAO dao = new memberDAO();
				if (action == null || action.length() == 0 || action.equals("input_userId")) {
					gotoPage(request, response, "/inputMemID.jsp");

				//showをクリックで変更前の情報表示を行う
				} else if (action.equals("show")) {
					String name = request.getParameter("name");
					String address = request.getParameter("address");
					String tel = request.getParameter("tel");
					String email = request.getParameter("email");
					String birthY = request.getParameter("birthY");
					String birthM = request.getParameter("birthM");
					String birthD = request.getParameter("birthD");
					gotoPage(request, response, "/checkMemInfo.jsp");
					// changeは変更確定
				}else if (action.equals("change")) {
					MemberBean member = (MemberBean) session.getAttribute("member");
					if (member == null) { //利用者情報がない
						request.setAttribute("message", "正しく操作してください");
						gotoPage(request, response, "/errInternal.jsp");
					}

					//変更後はセッション情報をクリアにする
					session.removeAttribute("member");
				}
				} catch (DAOException e) {
					e.printStackTrace();
					request.setAttribute("message", "内部エラーが発生しました");
					gotoPage(request, response, "/errInternal.jsp");

				}

		}




	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("/LibrarySystem/changeMemInfo.jsp");
		request.setCharacterEncoding("UTF-8");

		String name;
		String address;
		String tel;
		String email;
		String birthY;
		String birthM;
		String birthD;

		String param = request.getParameter("name");
		if(param == null || param.length() == 0) {
			name = "";
		} else {
			try {
				name = param;
			} catch (NumberFormatException e){
				name = "";
			}
		}
		param = request.getParameter("address");
		if(param == null || param.length() == 0) {
			address = "";
		} else {
			try {
				address = param;
			} catch (NumberFormatException e){
				address = "";
			}
		}
		param = request.getParameter("tel");
		if(param == null || param.length() == 0) {
			tel = "";
		} else {
			try {
				tel = param;
			} catch (NumberFormatException e){
				tel = "";
			}
		}
		param = request.getParameter("email");
		if(param == null || param.length() == 0) {
			email = "";
		} else {
			try {
				email = param;
			} catch (NumberFormatException e){
				email = "";
			}
		}
		param = request.getParameter("birthY");
		if(param == null || param.length() == 0) {
			birthY = "";
		} else {
			try {
				birthY = param;
			} catch (NumberFormatException e){
				birthY = "";
			}
		}
		param = request.getParameter("birthM");
		if(param == null || param.length() == 0) {
			birthM = "";
		} else {
			try {
				birthM = param;
			} catch (NumberFormatException e){
				birthM = "";
			}
		}
		param = request.getParameter("birthD");
		if(param == null || param.length() == 0) {
			birthD = "";
		} else {
			try {
				birthD = param;
			} catch (NumberFormatException e){
				birthD = "";
			}
		}
		try {
			String sql = "update member set user_name = ?, address = ?, tel = ?, email = ?, birthday = ?;"
		}
		//リクエストパラメータの読み込み
		//user_idに紐づいた情報を変更画面に引っ張ってくる
		String user_id = request.getParameter("user_id");
		RequestDispatcher rd = request.getRequestDispatcher("/changeMemInfo.jsp");
		rd.forward(request, response);

	}

}
