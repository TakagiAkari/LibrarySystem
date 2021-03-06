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

import ls.bean.MemberBean;
import ls.dao.DAOException;
import ls.dao.MemberDAO;
import ls.module.OperateDate;
import ls.module.XSS;
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
			gotoPage(request, response, "/LibrarySystem/LoginServlet=action=logout");
			return;
		}

		try {
			//パラメータの取得
			String action = XSS.escape(request.getParameter("action"));

			if (action == null || action.length() == 0 || action.equals("input_userId")) {
				request.setAttribute("mode", "change");
				gotoPage(request, response, "/inputMemID.jsp");
			//会員idを入力して変更をクリックで変更情報入力画面へいく
			} else if(action.equals("input")) {
				MemberDAO dao = new MemberDAO();
				int userId = Integer.parseInt(XSS.escape(request.getParameter("MemID")));
				MemberBean bean =dao.findMemberByMemID(userId);
				if (bean == null) {
					request.setAttribute("message", "存在しない会員IDです。");
					gotoPage(request, response, "/errMessage.jsp");
					return;
				}

				session.setAttribute("PreviousMemberInfo",bean);
				gotoPage(request, response, "/changeMemInfo.jsp");
					//showをクリックで変更前の情報表示を行う
			} else if (action.equals("show")) {
				String name = XSS.escape(request.getParameter("name"));
				String address = XSS.escape(request.getParameter("address"));
				String tel = XSS.escape(request.getParameter("tel"));
				String email = XSS.escape(request.getParameter("email"));
				int birthY = Integer.parseInt(XSS.escape(request.getParameter("birthY")));
				int birthM = Integer.parseInt(XSS.escape(request.getParameter("birthM")));
				int birthD = Integer.parseInt(XSS.escape(request.getParameter("birthD")));

				//birthY,birthM,birthDの型変換
				session.getAttribute("PreviousMemberInfo");
				MemberBean ChangeMember = (MemberBean)session.getAttribute("PreviousMemberInfo");
		try {
					Date BirthDay = OperateDate.getJavaSqlDateOfYMD(birthY,birthM,birthD);
					int userId = ChangeMember.getUserId();
					MemberBean LaterMemberInfo = new MemberBean(userId,name, address, tel, email, BirthDay);
					session.setAttribute("LaterMemberInfo", LaterMemberInfo);
					gotoPage(request, response, "/checkMemAlt.jsp");
			} catch (ParseException e) {
					e.printStackTrace();
					request.setAttribute("message", "不正な日付です");
					gotoPage(request, response, "/errMessage.jsp");
				}

			// changeは変更確定
			}else if (action.equals("change")) {
				MemberBean LaterMemberInfo = (MemberBean)session.getAttribute("LaterMemberInfo");
				MemberBean member = (MemberBean) session.getAttribute("PreviousMemberInfo");
				MemberDAO dao = new MemberDAO();
				dao.ChangeMember(LaterMemberInfo);
			if (member == null) { //利用者情報がない
				request.setAttribute("message", "正しく操作してください");
				gotoPage(request, response, "/errMessage.jsp");
				return;
				}
				//変更後はセッション情報をクリアにする
				session.removeAttribute("PreviousMemberInfo");
				//変更情報をユーザに送る
				request.setAttribute("message", "変更");
				gotoPage(request, response, "/complete.jsp");
			}
		    } catch (DAOException e) {
				e.printStackTrace();
				request.setAttribute("message", "内部エラーが発生しました");
				gotoPage(request, response, "/errMessage.jsp");
		    }catch(NumberFormatException e) {
				e.printStackTrace();
				request.setAttribute("message", "数字を入力してください。");
				gotoPage(request, response, "/errMessage.jsp");
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
