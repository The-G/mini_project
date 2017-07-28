package proj.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proj.member.dao.MemberDAO;
import proj.member.dto.MemberVO;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		MemberDAO mDao = MemberDAO.getInstance();
		
		MemberVO mVo = mDao.getMember(userid);
		request.setAttribute("mVo", mVo);
        	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/memberUpdate.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 한글 깨짐을 방지
		// 폼에서 입력한 회원 정보 얻어오기
		String userid=request.getParameter("userid");
		String pwd=request.getParameter("pwd");
		String nickname=request.getParameter("nickname");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String worstMovie=request.getParameter("worstMovie");
		String gender = request.getParameter("gender");
		String receiveEmail = request.getParameter("receiveEmail");
		String receiveSns = request.getParameter("receiveSns");
		
		// 회원 정보를 저장할 객체 생성
		MemberVO mVo = new MemberVO();
		mVo.setUserid(userid);
		mVo.setPwd(pwd);
		mVo.setNickname(nickname);
		mVo.setEmail(email);
		mVo.setPhone(phone);
		mVo.setWorstMovie(worstMovie);
		mVo.setGender(Integer.parseInt(gender));
		mVo.setReceiveEmail(Integer.parseInt(receiveEmail));
		mVo.setReceiveSns(Integer.parseInt(receiveSns));
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.updateMember(mVo);
		
		response.sendRedirect("proj/main");

//		response.sendRedirect("login.do");

	}

}
