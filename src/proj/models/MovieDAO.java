package proj.models;


public interface MovieDAO {

	void crawlingMovie() throws Exception;

	void crawlingMovieComment(MovieCommentVO movieCommentVO) throws Exception;

	void make_wordcloud(MovieCommentVO movieCommentVO) throws Exception;
}
