package proj.models;

import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;

public interface MovieDAO {

	void crawlingMovie() throws Exception;

	void crawlingMovieComment(MovieCommentVO movieCommentVO) throws Exception;

	void make_wordcloud(MovieCommentVO movieCommentVO) throws Exception;

	List<MovieVO> getMovieList(MovieVO movieVO);
	
	List<MovieCommentVO> getMovieCommentList(MovieCommentVO movieCommentVO);

	JSONArray countWord(List<MovieCommentVO> list);

	JSONArray countWord2(List<MovieCommentVO> list);

}
