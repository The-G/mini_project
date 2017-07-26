package proj.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import proj.member.dao.MemberDAO;
import proj.member.dto.MemberVO;

@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/member/join.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name=request.getParameter("name");
		String userid=request.getParameter("userid");
		String pwd=request.getParameter("pwd");
		String nickname=request.getParameter("nickname");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String worstMovie=request.getParameter("worstMovie");
		String gender = request.getParameter("gender");
		String receiveEmail = request.getParameter("receiveEmail");
		String receiveSns = request.getParameter("receiveSns");
		
		MemberVO mVo = new MemberVO();
		mVo.setName(name);
		mVo.setUserid(userid);
		mVo.setPwd(pwd);
		mVo.setNickname(nickname);
		mVo.setEmail(email);
		mVo.setPhone(phone);
		mVo.setWorstMovie(worstMovie);
		mVo.setGender(Integer.parseInt(gender));
		mVo.setReceiveEmail(Integer.parseInt(receiveEmail));
		mVo.setReceiveSns(Integer.parseInt(receiveSns));
		
		MemberDAO mDao=MemberDAO.getInstance();
		int result=mDao.insertMember(mVo);
		
		HttpSession session=request.getSession();
		
		if(result==1){
			session.setAttribute("userid", mVo.getUserid());
			request.setAttribute("message", "회원가입에 성공했습니다.");
		}else{
			request.setAttribute("message", "회원가입에 실패했습니다.");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/login.jsp");
		dispatcher.forward(request, response);
	}

}

