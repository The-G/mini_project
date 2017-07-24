package proj.models;

public class MovieCommentVO {
	
	private String url;
	private String nickname;
	private long score;
	private String content;
	private long movie_id;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public long getScore() {
		return score;
	}
	public void setScore(long score) {
		this.score = score;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(long movie_id) {
		this.movie_id = movie_id;
	}
	@Override
	public String toString() {
		return "MovieCommentVO [url=" + url + ", nickname=" + nickname + ", score=" + score + ", content=" + content
				+ ", movie_id=" + movie_id + "]";
	}

}
