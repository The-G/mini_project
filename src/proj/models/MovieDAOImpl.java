package proj.models;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import rcaller.RCaller;

public class MovieDAOImpl implements MovieDAO {

	private static MovieDAOImpl movieDAO = null;
	private DataSource ds = null;
	
	private MovieDAOImpl() {
		try{
				Context context = new InitialContext();
	 			ds = (DataSource)context.lookup("java:/comp/env/jdbc/mydbcp");
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() throws SQLException {
		return ds.getConnection(); // DBCP 작업에서 이용!!
	}
	
	public static MovieDAOImpl getInstance() { // singleton
		if (movieDAO == null) {
			movieDAO = new MovieDAOImpl();
		}
		return movieDAO;
	}

	private void dbClose(PreparedStatement ps, Connection cn) {
		if (ps != null) try{ps.close();}catch(Exception e){}
		if (cn != null) try{cn.close();}catch(Exception e){}
	}
	
	private void dbClose(ResultSet rs, PreparedStatement ps, Connection cn) {
		if (rs != null) try{rs.close();} catch(Exception e){}
		if (ps != null) try{ps.close();} catch(Exception e){}
		if (cn != null) try{cn.close();} catch(Exception e){}
	}
	

	@Override
	public void crawlingMovie() throws Exception {
		
//		TODO:: 	daum 영화에서 영화명(뒤 년도 제거!!)과 영화 id(url)을 긁은다!!
//				http://movie.daum.net/boxoffice/yearly?year=2016 여기 긁어라!!

//		movie_id number, sequence 처리
//		img_url varchar2
//		name varchar2		
//		daum_info_link varchar2
		//// Crawling & Insert START

		String newLine = System.getProperty("line.separator");
		
		Connection cn = null;
		PreparedStatement ps = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO movie(movie_id, img_url, name, daum_info_link, crawling_daum_id, release_date)"); //movie_id 검색한 거 받아와서 넣어줘야함!!!
		sql.append(" VALUES(seq_movie.nextval, ?, ?, ?, ?, TO_DATE(?, 'yy.mm.dd'))");

		for (int release_year = 2017; release_year >= 2010; release_year--) {

			Document doc = null;
			try {
				doc = Jsoup.connect("http://movie.daum.net/boxoffice/yearly?year=" + release_year).get();
			} catch (IOException e1) {
				System.out.println("사이트 읽는 도중 에러!!");
			}

			Elements img = doc.select("div#mArticle > ul > li > div.info_movie > span > img");
			Elements titles = doc.select("div#mArticle > ul > li > div.wrap_movie > div.info_tit > a.name_movie");
			Elements release_date = doc.select("div#mArticle > ul > li > div.wrap_movie > span.info_state");

			// TODO:: 파일에 넣지 않고 DB에 INSERT 해야함!!
			for (int j = 0; j < 50; j++) {
				try {
					cn = getConnection();
					ps = cn.prepareStatement(sql.toString());
					ps.setString(1, img.get(j).attr("src"));
					ps.setString(2, titles.get(j).text());
					ps.setString(3, titles.get(j).attr("href"));
					ps.setString(4, titles.get(j).attr("href").replace("/moviedb/main?movieId=", ""));
					// crawling_daum_id 나중에 트리거로 바꿔보자!!!
					ps.setString(5, release_date.get(j).text().substring(0, 8));
					ps.executeUpdate();

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("db insert 중 에러!!" + titles.get(j).text());					
				} finally {
					dbClose(ps, cn);
				}

			}

		}
		
		// TODO:: 감독 정보 Crawling
		// director varchar2
		
		//// Crawling & Insert END

		//// START Crawling movie_comment & insert

		//// END   Crawling movie_comment & insert
				
	}

	@Override
	public void crawlingMovieComment(MovieCommentVO movieCommentVO) throws Exception {
//		TODO:: 	input 받으면 비슷한 movie 목록을 창에 띄운다. 그다음 wordcloud 보기 버튼을 
//				누르면, 기존에 있는 db와 새로 크롤링한 db를 이용해서 wordcloud를 만든다.
//				http://movie.daum.net/moviedb/grade?movieId=93697&type=netizen&page= 이부분을
//				긁은다!! 		
//				comment를 긁는데,,, 최신부터 긁고 insert 하다가...db 최근에 긁은 것과 같은 유저명&댓글내용 을 만나면 stop 한다!!
//				그리고 wordcloud 그리기!!!
		
		
		
		//// Crawling and Insert START
		String newLine = System.getProperty("line.separator");
		
		Connection cn = null;
		PreparedStatement ps = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO movie_comment(nickname, score, content, movie_id)");
		sql.append(" VALUES(?, ?, ?, ?)");

		
		for (int release_year = 2017; release_year >= 2010; release_year--) {

			Document doc = null;
			try {
				doc = Jsoup.connect("http://movie.daum.net/boxoffice/yearly?year=" + release_year).get();
			} catch (IOException e1) {
				System.out.println("사이트 읽는 도중 에러!!");
			}

			Elements img = doc.select("div#mArticle > ul > li > div.info_movie > span > img");
			Elements titles = doc.select("div#mArticle > ul > li > div.wrap_movie > div.info_tit > a.name_movie");
			Elements release_date = doc.select("div#mArticle > ul > li > div.wrap_movie > span.info_state");

			// TODO:: 파일에 넣지 않고 DB에 INSERT 해야함!!
			for (int j = 0; j < 50; j++) {
				try {
					cn = getConnection();
					ps = cn.prepareStatement(sql.toString());
					ps.setString(1, img.get(j).attr("src"));
					ps.setString(2, titles.get(j).text());
					ps.setString(3, titles.get(j).attr("href"));
					ps.setString(4, titles.get(j).attr("href").replace("/moviedb/main?movieId=", ""));
					// crawling_daum_id 나중에 트리거로 바꿔보자!!!
					ps.setString(5, release_date.get(j).text().substring(0, 8));
					ps.executeUpdate();

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("db insert 중 에러!!" + titles.get(j).text());					
				} finally {
					dbClose(ps, cn);
				}

			}

		}
		//// Crawling and Insert END

		
		
//		//// Crawling and Create file START
//		FileWriter f0 = null;
//		FileWriter f1 = null;
//		try {
//			f0 = new FileWriter("C:/dev/workspace/mini_project/under5.txt");
//			f1 = new FileWriter("C:/dev/workspace/mini_project/upper5.txt");
//		} catch (IOException e1) {
//			System.out.println("file 만들 때 에러!!");
//		}
//		String newLine = System.getProperty("line.separator");
//
//		for (int page_num = 1; page_num < 25; page_num++) {
//
//			Document doc = null;
//			try {
//				doc = Jsoup.connect("http://movie.daum.net/moviedb/grade?movieId=93697&type=netizen&page=" + page_num)
//						.get();
//			} catch (IOException e1) {
//				System.out.println("사이트 읽는 도중 에러!!");
//			}
//
//			// 평점
//			Elements scores = doc.select("ul.list_review > li > div.review_info > div.raking_grade > em");
//			// 댓글내용
//			Elements titles = doc.select("ul.list_review > li > div.review_info > p.desc_review");
//			
//			System.out.println(scores.get(0));
//			System.out.println(titles.get(0));
//			
//			// TODO:: 파일에 넣지 않고 DB에 INSERT 해야함!!
//			try {
//				for (int j = 0; j < 10; j++) {
//					if (Integer.parseInt(scores.get(j).text()) < 5) {
////						f0.write("page_num:" + page_num + " / score" + j + ": " + scores.get(j).text() + newLine);					
//						f0.write(titles.get(j).text() + newLine);											
//					} else {
////						f1.write("page_num:" + page_num + " / score" + j + ": " + scores.get(j).text() + newLine);					
//						f1.write(titles.get(j).text() + newLine);												
//					}
//					System.out.println("page_num : " + page_num + "/" + "list_num: " + j);
//				}
//			} catch (Exception e) {
//				System.out.println("db insert 중 에러!!");
//			}
//		}
//		f0.close();
//		f1.close();
//		//// Crawling and Create file  END
		
		//// DB insert START 참고!!
//		Connection cn = null;
//		PreparedStatement ps = null;
//		
//		StringBuffer sql = new StringBuffer();
//		sql.append(" INSERT INTO movie_comment(url, nickname, score, content, movie_id)"); //movie_id 검색한 거 받아와서 넣어줘야함!!!
//		sql.append(" VALUES(?, ?, ?, ?, ?)");
//		
//		try {
//			cn = getConnection();
//			ps = cn.prepareStatement(sql.toString());
//			ps.setString(1, movieCommentVO.getUrl());
//			ps.setString(2, movieCommentVO.getNickname());
//			ps.setLong(3, movieCommentVO.getScore());
//			ps.setString(4, movieCommentVO.getContent());
//			ps.setLong(5, movieCommentVO.getMovie_id()); //TODO:: 이부분 MOVIE_TB에서 받아온 것을 넣어야 한다!!!
//			ps.executeUpdate();
//			
//		} finally {
//			dbClose(ps,cn);
//		}
		//// DB insert END
		
		
		
		
		//TODO:: 이부분에 WORDCLOUD 만드는 거 들어가야 할 수도 있겠다!!!
	}

	@Override
	public void make_wordcloud(MovieCommentVO movieCommentVO) throws Exception {
//		TODO:: JAVA로 바꿔야함!!
//			   INSERT 된 DB를 활용해서 WORDCLOUD를 만들고, db 저장하고 webpage에 반환한다..
		try{
            RCaller caller = new RCaller();
			caller.setRscriptExecutable("C:/Program Files/R/R-3.3.2/bin/x64/Rscript.exe");
			caller.addRCode("source(\"C:/dev/workspace/mini_project/movie_t.R\")");
			caller.runOnly();
            System.out.println("완료");
        }catch (Exception e){
            e.printStackTrace();
        }		
	}

	@Override
	public List<MovieVO> getMovieList(MovieVO movieVO) {
		Connection cn =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<MovieVO> list = new ArrayList<MovieVO>();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT MOVIE_ID, NAME, RELEASE_DATE, CRAWLING_DAUM_ID, IMG_URL, DAUM_INFO_LINK");
		sql.append(" FROM   MOVIE");
		sql.append(" WHERE name LIKE '%' || ? || '%'");

		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql.toString());
			ps.setString(1, movieVO.getName());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MovieVO movieVO_select = new MovieVO();
//				movieVO_select.setMovie_id(rs.getLong("movie_id"));
				movieVO_select.setName(rs.getString("name"));
				movieVO_select.setRelease_date(rs.getDate("release_date"));
				movieVO_select.setCrawling_daum_id(rs.getLong("crawling_daum_id"));
				movieVO_select.setImg_url(rs.getString("img_url"));
//				movieVO_select.setDaum_info_link(rs.getString("daum_info_link"));
				list.add(movieVO_select);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose(rs, ps, cn);
		}
		return list;	
	}


	
	
}
