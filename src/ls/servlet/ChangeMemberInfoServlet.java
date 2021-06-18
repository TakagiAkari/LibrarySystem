package ls.servlet;

import java.io.IOException;
import java.lang.reflect.Member;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ls.bean.MemberBean;
import ls.dao.DAOException;
import ls.dao.MemberDAO;

/**
 * Servlet implementation class ChangeMenberInfoServlet
 */
@WebServlet("/ChangeMemberInfoServlet")
public class ChangeMemberInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeMemberInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession(false);
			if (session == null) {
				request.setAttribute("message", "正しく入力してください");
				gotoPage(request, response, "/errMessage.jsp");
				return;
			}
			MemberBean bean = (MemberBean) session.getAttribute("member");


			try {
				//パラメータの取得
				String action = request.getParameter("action");

				if (action == null || action.length() == 0 || action.equals("input_userId")) {
					gotoPage(request, response, "/inputMemID.jsp");
				//会員idを入力して変更をクリックで変更情報入力画面へいく
				} else if(action.equals("input")) {
					MemberDAO dao = new MemberDAO();
					int userId = Integer.parseInt(request.getParameter("userId"));
					dao.findById//名前だけ考える
					HttpSession sessinnputForChangeMemberServlet = request.getSession(false);
					session.setAttribute("Member","name");
					gotoPage(request, response, "/changeMemAlt.jsp");
					//showをクリックで変更前の情報表示を行う
				} else if (action.equals("show")) {
					MemberBean bean = new MemberBean();
					bean.setUserName(request.getParameter("name"));
					bean.setAddress(request.getParameter("address"));
					bean.setTel(request.getParameter("tel"));
					bean.setEmail(request.getParameter("email"));
					bean.setBirth(request.getParameter("birth"));
					gotoPage(request, response, "/checkMemInfo.jsp");
					// changeは変更確定
				}else if (action.equals("change")) {
					MemberBean member = (MemberBean) session.getAttribute("member");
					if (member == null) { //利用者情報がない
						request.setAttribute("message", "正しく操作してください");
						gotoPage(request, response, "/errMember.jsp");
					}
					OrderDAO dao = new OrderDAO();
					String userName = member.saveMember("userName");
					String addres  = member,saveMember("address");
					String tel = member.saveMember("tel");
					String email = member.saveMember("email");
					Date birth = member.saveMember("birth");
					//変更後はセッション情報をクリアにする
					session.removeAttribute("member");
					//変更情報をユーザに送る
					request.setAttribute("message", "変更");
					gotoPage(request, response, "/complete.jsp");
					request.setAttribute("message", "正しく操作してください");
					gotoPage(request, response, "/errMessage.jsp");
				}
				} catch (DAOException e) {
					e.printStackTrace();
					request.setAttribute("message", "内部エラーが発生しました");
					gotoPage(request, response, "/errMember.jsp");
				}
		}




	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
