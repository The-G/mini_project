package proj.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proj.models.MovieDAO;
import proj.models.MovieDAOImpl;
import proj.models.MovieVO;

public class ProjSearchAction extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {


		MovieDAO movieDAO = MovieDAOImpl.getInstance(); // DB단에 대한 비즈니스 로직 분리
		
		ModelAndView mav = new ModelAndView();
		try {
			String name = request.getParameter("movie_name").trim();

			// movie_name 과 비슷한 movie_name list를 보여준다...		
			MovieVO movieVO = new MovieVO();
			movieVO.setName(name);

			
//			List<MovieCommentVO> list = movieDAO.getArticleList(pageNation);
			List<MovieVO> list = movieDAO.getMovieList(movieVO);
			mav.setViewName("/WEB-INF/views/proj/movie_list.jsp");
			mav.addObject("list", list);
//			mav.addObject("pageNation", pageNation);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg", "게시물 리스트 출력에러 \\n 관리자에게 문의하세요!!");
			mav.addObject("url", "javascript:history.back();");
			
		}
		return mav;
		
		
	}

}
