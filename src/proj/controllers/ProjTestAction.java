package proj.controllers;

import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import proj.models.MovieCommentVO;
import proj.models.MovieDAO;
import proj.models.MovieDAOImpl;
import proj.models.MovieVO;
import rcaller.RCaller;

public class ProjTestAction extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
//		Long no = Long.parseLong(request.getParameter("no"));
//		String pwd = request.getParameter("pwd"); //page 값을 여기서 받아서!!
		
//		MovieVO movieVO = new MovieVO(); // 이거는 admin이 수행하지.. 영화 정보 긁기
//		MovieCommentVO movieCommentVO = new MovieCommentVO();
//		movieVO.setNo(no);
//		movieVO.setPwd(pwd);
		
		MovieDAO movieDAO = MovieDAOImpl.getInstance();
		ModelAndView mav = new ModelAndView("/WEB-INF/views/result.jsp");
		try {

			movieDAO.crawlingMovie();
//			movieDAO.crawlingMovieComment(movieCommentVO);
//			movieDAO.make_wordcloud(movieCommentVO);
//			movieDAO.deleteArticle(movieVO);
			mav.addObject("msg", "크롤링 / wordcloud 성공");
			mav.addObject("url", "javascript:history.back();");
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("msg", e.getMessage());
			mav.addObject("url", "javascript:history.back();");
		}
		
		return mav;
	}
	
}
