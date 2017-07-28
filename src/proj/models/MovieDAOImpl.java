package proj.models;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import proj.controllers.WordCount;
import proj.test.KeywordVO;
import rcaller.RCaller;

public class MovieDAOImpl implements MovieDAO {

	private static MovieDAOImpl movieDAO = null;
	private DataSource ds = null;

	private MovieDAOImpl() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:/comp/env/jdbc/mydbcp");
		} catch (Exception e) {
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
		if (ps != null)
			try {
				ps.close();
			} catch (Exception e) {
			}
		if (cn != null)
			try {
				cn.close();
			} catch (Exception e) {
			}
	}

	private void dbClose(ResultSet rs, PreparedStatement ps, Connection cn) {
		if (rs != null)
			try {
				rs.close();
			} catch (Exception e) {
			}
		if (ps != null)
			try {
				ps.close();
			} catch (Exception e) {
			}
		if (cn != null)
			try {
				cn.close();
			} catch (Exception e) {
			}
	}

	@Override
	public void crawlingMovie() throws Exception {

		// TODO:: daum 영화에서 영화명(뒤 년도 제거!!)과 영화 id(url)을 긁은다!!
		// http://movie.daum.net/boxoffice/yearly?year=2016 여기 긁어라!!

		// movie_id number, sequence 처리
		// img_url varchar2
		// name varchar2
		// daum_info_link varchar2
		//// Crawling & Insert START

		String newLine = System.getProperty("line.separator");

		Connection cn = null;
		PreparedStatement ps = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO movie(movie_id, img_url, name, daum_info_link, crawling_daum_id, release_date)"); // movie_id
		// 받아와서
		// 넣어줘야함!!!
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
	}

	@Override
	public void crawlingMovieComment(MovieCommentVO movieCommentVO) throws Exception {

		//// Crawling and Insert START
		String newLine = System.getProperty("line.separator");
		long crawling_id = movieCommentVO.getCrawling_id();
		long movie_id = movieCommentVO.getMovie_id();

		Connection cn = null;
		PreparedStatement ps = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO movie_comment(nickname, score, content, movie_id)");
		sql.append(" VALUES(?, ?, ?, ?)");

		for (int page_num = 1; page_num < 25; page_num++) {
			Document doc = null;
			try {
				doc = Jsoup.connect(
						"http://movie.daum.net/moviedb/grade?movieId=" + crawling_id + "&type=netizen&page=" + page_num)
						.get();
			} catch (IOException e1) {
				System.out.println("사이트 읽는 도중 에러!!");
			}

			Elements nickname = doc.select("ul.list_review > li > div.review_info > a > em");
			Elements scores = doc.select("ul.list_review > li > div.review_info > div.raking_grade > em");
			Elements content = doc.select("ul.list_review > li > div.review_info > p.desc_review");

			for (int j = 0; j < 10; j++) {
				try {
					cn = getConnection();
					ps = cn.prepareStatement(sql.toString());
					ps.setString(1, nickname.get(j).text());
					ps.setString(2, scores.get(j).text());
					ps.setString(3, content.get(j).text());
					ps.setLong(4, movie_id);
					ps.executeUpdate();
				} catch (Exception e) {
					System.out.println("db insert 중 에러!!");
				} finally {
					dbClose(ps, cn);
				}
			}
		}
		//// Crawling and Insert END
	}

	@Override
	public void make_wordcloud(MovieCommentVO movieCommentVO) throws Exception {
		// TODO:: JAVA로 바꿔야함!!
		// INSERT 된 DB를 활용해서 WORDCLOUD를 만들고, db 저장하고 webpage에 반환한다..
		try {
			RCaller caller = new RCaller();
			caller.setRscriptExecutable("C:/Program Files/R/R-3.3.2/bin/x64/Rscript.exe");
			caller.addRCode("source(\"C:/dev/workspace/mini_project/movie_t.R\")");
			caller.runOnly();
			System.out.println("완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MovieVO> getMovieList(MovieVO movieVO) {
		Connection cn = null;
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

			while (rs.next()) {
				MovieVO movieVO_select = new MovieVO();
				movieVO_select.setMovie_id(rs.getLong("movie_id"));
				movieVO_select.setName(rs.getString("name"));
				movieVO_select.setRelease_date(rs.getDate("release_date"));
				movieVO_select.setCrawling_daum_id(rs.getLong("crawling_daum_id"));
				movieVO_select.setImg_url(rs.getString("img_url"));
				// movieVO_select.setDaum_info_link(rs.getString("daum_info_link"));
				list.add(movieVO_select);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose(rs, ps, cn);
		}
		return list;
	}

	@Override
	public List<MovieCommentVO> getMovieCommentList(MovieCommentVO movieCommentVO) {
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<MovieCommentVO> list = new ArrayList<MovieCommentVO>();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT  nickname, score, content, movie_id");
		sql.append(" FROM    MOVIE_COMMENT");
		sql.append(" WHERE   movie_id = ? AND content is not null");

		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql.toString());
			ps.setLong(1, movieCommentVO.getMovie_id());
			rs = ps.executeQuery();

			while (rs.next()) {
				MovieCommentVO movieCommentVO_select = new MovieCommentVO();
				// movieCommentVO_select.setMovie_id(rs.getLong("movie_id"));
				movieCommentVO_select.setNickname(rs.getString("nickname"));
				movieCommentVO_select.setScore(rs.getLong("score"));
				movieCommentVO_select.setContent(rs.getString("content"));
				list.add(movieCommentVO_select);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose(rs, ps, cn);
		}
		return list;
	}

	private ArrayList<WordCount> words;

	@Override
	public JSONArray countWord(List<MovieCommentVO> list) {
		// 받아온 list의 comment를 합치고, replace, split 하고 단어 count 후 list로 반환!!
		// System.out.println(list.get(0).getContent());

		String append_text = "";

		// 바로 content 빼서 합치는 방법 있나??
		for (int i = 0; i < list.size(); i++) {
			append_text = append_text.concat(list.get(i).getContent().toString());
			append_text = append_text.concat(list.get(i).getContent());
			append_text = append_text.concat(System.lineSeparator());
		}

		// System.out.println(append_text);
		// HashMap<String, Integer> count = new HashMap<String, Integer>();

		HashMap<String, Integer> count = new HashMap<String, Integer>();

		// TODO:: FIRST!!! json으로 hash 대신에... 해서 json 통으로 넘기자!!!
		Scanner scan = new Scanner(append_text);

		HashSet<String> filter = new HashSet<String>();
        filter.add("영화");

		while (scan.hasNext()) {
			String word = removePunctuations(scan.next());
			if (filter.contains(word)) continue;
			if (word.equals(""))
				continue;
			Integer n = (Integer) count.get(word);
			// "text" : "study",
			// "size" : 40
			// 형태로 집어넣어야 한다!!
			count.put(word, (n == null) ? 1 : n + 1);
		}

		List<JSONObject> jsonObj = new ArrayList<JSONObject>();
		for (int i = 0; i < count.size(); i++) {
			JSONObject result = new JSONObject();
			try {
				if ((Integer) count.values().toArray()[i] >= 5) {
					result.put("size", count.values().toArray()[i]);
					result.put("text", count.keySet().toArray()[i]);
				} else {
					continue;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsonObj.add(result);
		}
		JSONArray result = new JSONArray(jsonObj);
		System.out.println(result);

		return result;

	}

	private static String removePunctuations(String str) {
		return str.replaceAll("\\p{Punct}|\\p{Digit}", "");
	}

	public JSONArray countWord2(List<MovieCommentVO> list) {

		String append_text = "";

		for (int i = 0; i < list.size(); i++) {
			append_text = append_text.concat(list.get(i).getContent().toString());
			append_text = append_text.concat(list.get(i).getContent());
			append_text = append_text.concat(System.lineSeparator());
		}

		HashMap<String, Integer> count = new HashMap<String, Integer>();

		Scanner scan = new Scanner(append_text);
		
		HashSet<String> filter = new HashSet<String>();
        filter.add("영화");
        
		while (scan.hasNext()) {
			String word = removePunctuations(scan.next());
			if (filter.contains(word)) continue;
			if (word.equals("")) continue;
			Integer n = (Integer) count.get(word);
			count.put(word, (n == null) ? 1 : n + 1);
		}

		List<JSONObject> jsonObj = new ArrayList<JSONObject>();
		for (int i = 0; i < count.size(); i++) {
			JSONObject result = new JSONObject();
			try {
				if ((Integer) count.values().toArray()[i] >= 5) {
					result.put("size", count.values().toArray()[i]);
					result.put("text", to_trans(count.keySet().toArray()[i]));
					// System.out.println(count.keySet().toArray()[i]);
				} else {
					continue;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsonObj.add(result);
		}
		JSONArray result = new JSONArray(jsonObj);
		System.out.println(result);

		return result;

	}

	private static final long serialVersionUID = 1L;

	private String[] to_trans(Object object) {
		String clientId = "ubasmpZ93GesXy0pAZhb";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "625P_Q0Dn2";// 애플리케이션 클라이언트 시크릿값";
		String[] word_engs = null;
		String jsonTranslatedText = null;
		try {

			String text = URLEncoder.encode(object.toString(), "UTF-8");

			String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod("POST");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			// post request
			String postParams = "source=ko&target=en&text=" + text;
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(postParams);
			wr.flush();
			wr.close();
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer rp = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				rp.append(inputLine);
			}
			br.close();

			JSONParser parser = new JSONParser();

			try {
				// myJson.json파일을 읽어와 Object로 파싱
				Object obj = parser.parse(rp.toString());

				JSONObject jsonObject = (JSONObject) obj;
				JSONObject jsonMessage = (JSONObject) jsonObject.get("message");

				if (jsonMessage != null) {
					//System.out.println(jsonMessage.toString());
					if (jsonMessage == null) {
						System.out.println("모든 단어가 번역 되어 있음");
					}
					JSONObject jsonResult = (JSONObject) jsonMessage.get("result");
					jsonTranslatedText = (String) jsonResult.get("translatedText");

					word_engs = jsonTranslatedText.split("\n");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
//		System.out.println(jsonTranslatedText);
		return word_engs;
	}

}
