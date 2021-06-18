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

import ls.bean.InputMemberBean;
import ls.dao.DAOException;
import ls.dao.MemberDAO;
import ls.module.OperateDate;

@WebServlet("/RegisterMemberServlet")
public class RegisterMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public RegisterMemberServlet() {
        super();
    }


    private void gotoPage (HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher(page);
    	rd.forward(request, response);
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		try {
			//response.setContentType("text/html;charset=UTF-8");

			String action = request.getParameter("action");
			MemberDAO dao = new MemberDAO();
			HttpSession session = request.getSession(false);
			if(action == null || action.length() == 0 || action.equals("reInput")) {
				gotoPage(request, response, "/signUp.jsp");
			}
			else if(action.equals("next") ) {

				String name = request.getParameter("name");
				String address = request.getParameter("address");
				String tel = request.getParameter("tel");
				String email = request.getParameter("email");
				String birthY = request.getParameter("birthY");
				String birthM = request.getParameter("birthM");
				String birthD = request.getParameter("birthD");

				if(name == null || name.length() == 0 || address == null || address.length() == 0 || tel == null ||
					tel.length() == 0 || email == null || email.length() == 0 || birthY == null || birthY.length() == 0 ||
					birthM == null || birthM.length() == 0 || birthD == null || birthD.length() == 0 ) {
					request.setAttribute("errMessage", "すべての情報を入力してください");
					gotoPage(request, response, "/errMessage.jsp");
				}else {


					InputMemberBean memberInfo = new InputMemberBean(name, address, tel, email, birthY, birthM, birthD);
					session.setAttribute("InputMemberInfo", memberInfo);
					gotoPage(request, response, "/checkMemInfo.jsp");
				}

			}
			//DAOを起動し、DBに情報追加、complete.jspへ
			else if(action.equals("complete")&&(session != null)) {

				InputMemberBean memberInfo = (InputMemberBean)session.getAttribute("InputMemberInfo");

				Date birthDate;
				try {
					// 使用しているSimpleDateFormat.parseメソッドがParseExceptionのチェック例外を要求しているため
					birthDate = OperateDate.getJavaSqlDateOfInputMemberBean(memberInfo);
				} catch (ParseException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();

					request.setAttribute("message",e);
					gotoPage(request, response, "/errInternal.jsp");
					return ;
				}
				Date enterDate = OperateDate.getDateNow();

		        dao.addMember(memberInfo.getName(), memberInfo.getAddress(), memberInfo.getTel(), memberInfo.getEmail(), birthDate, enterDate);
		        request.setAttribute("message", "会員登録");
				gotoPage(request, response, "/complete.jsp");

				}
		}catch(DAOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}

}
