package proj.test;

public class KeywordVO {
	private long movie_id;
	private String keyword_ko;
	private String keyword_en;
	private String keyword_ch;
	private int count;
	@Override
	public String toString() {
		return "keywordVO [movie_id=" + movie_id + ", keyword_ko=" + keyword_ko + ", keyword_en=" + keyword_en
				+ ", keyword_ch=" + keyword_ch + ", count=" + count + "]";
	}
	public long getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(long movie_id) {
		this.movie_id = movie_id;
	}
	public String getKeyword_ko() {
		return keyword_ko;
	}
	public void setKeyword_ko(String keyword_ko) {
		this.keyword_ko = keyword_ko;
	}
	public String getKeyword_en() {
		return keyword_en;
	}
	public void setKeyword_en(String keyword_en) {
		this.keyword_en = keyword_en;
	}
	public String getKeyword_ch() {
		return keyword_ch;
	}
	public void setKeyword_ch(String keyword_ch) {
		this.keyword_ch = keyword_ch;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
