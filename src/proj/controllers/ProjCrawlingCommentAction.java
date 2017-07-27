package proj.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import proj.models.MovieCommentVO;
import proj.models.MovieDAO;
import proj.models.MovieDAOImpl;

public class ProjCrawlingCommentAction extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		Long crawling_id = Long.parseLong(request.getParameter("crawling_id"));
		Long movie_id = Long.parseLong(request.getParameter("movie_id"));
		
		MovieCommentVO movieCommentVO = new MovieCommentVO();
		movieCommentVO.setMovie_id(movie_id);
		movieCommentVO.setCrawling_id(crawling_id);
		
		MovieDAO movieDAO = MovieDAOImpl.getInstance();
		ModelAndView mav = new ModelAndView("/WEB-INF/views/result.jsp");
		try {
			movieDAO.crawlingMovieComment(movieCommentVO);
//			List<MovieCommentVO> list = movieDAO.getMovieCommentList(movieCommentVO);

//			mav.addObject("msg", "movie comment 크롤링 성공");
//			mav.addObject("url", "wordcloud");
//			mav.addObject("list", list);
			
			List<MovieCommentVO> list = movieDAO.getMovieCommentList(movieCommentVO);
			JSONArray count_word = movieDAO.countWord(list); 
		    

			
//			JSONObject result = new JSONObject();
//			result.putAll(count_word);
			
			mav.setViewName("/WEB-INF/views/proj/wordcloud.jsp");
			mav.addObject("list", list);
			mav.addObject("count_word", count_word);

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("msg", e.getMessage());
			mav.addObject("url", "javascript:history.back();");
		}
		
		return mav;		
	}
}