package proj.models;

import java.util.List;

import org.jsoup.nodes.Element;

public interface MovieDAO {

	void crawlingMovie() throws Exception;

	void crawlingMovieComment(MovieCommentVO movieCommentVO) throws Exception;

	void make_wordcloud(MovieCommentVO movieCommentVO) throws Exception;

	List<MovieVO> getMovieList(MovieVO movieVO);

}
