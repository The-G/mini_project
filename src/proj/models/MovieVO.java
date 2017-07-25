package proj.models;

import java.util.Date;

public class MovieVO {

	private long movie_id;
	private String name;
	private Date release_date;
	private String director;
	private long crawling_daum_id;
	private String img_url;
	private String daum_info_link;
	public long getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(long movie_id) {
		this.movie_id = movie_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name.equals("")) {
			throw new RuntimeException();
		}
		this.name = name;			
	}
	public Date getRelease_date() {
		return release_date;
	}
	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public long getCrawling_daum_id() {
		return crawling_daum_id;
	}
	public void setCrawling_daum_id(long crawling_daum_id) {
		this.crawling_daum_id = crawling_daum_id;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getDaum_info_link() {
		return daum_info_link;
	}
	public void setDaum_info_link(String daum_info_link) {
		this.daum_info_link = daum_info_link;
	}
	@Override
	public String toString() {
		return "MovieVO [movie_id=" + movie_id + ", name=" + name + ", release_date=" + release_date + ", director="
				+ director + ", crawling_daum_id=" + crawling_daum_id + ", img_url=" + img_url + ", daum_info_link="
				+ daum_info_link + "]";
	}
	
	
	
}
