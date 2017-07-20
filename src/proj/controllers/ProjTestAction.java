package proj.controllers;

import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import proj.models.MovieDAO;
import proj.models.MovieDAOImpl;
import proj.models.MovieVO;
import rcaller.RCaller;

public class ProjTestAction extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
//		Long no = Long.parseLong(request.getParameter("no"));
//		String pwd = request.getParameter("pwd");
		
		MovieVO movieVO = new MovieVO();
//		movieVO.setNo(no);
//		movieVO.setPwd(pwd);
		
		MovieDAO movieDAO = MovieDAOImpl.getInstance();
		ModelAndView mav = new ModelAndView("/WEB-INF/views/result.jsp");
		try {
			
			Crawling_movie_comments();
			Make_wordcloud();
//			movieDAO.deleteArticle(movieVO);
			mav.addObject("msg", "크롤링 / wordcloud 성공");
			mav.addObject("url", "wordcloud");
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("msg", e.getMessage());
			mav.addObject("url", "javascript:history.back();");
		}
		
		return mav;
	}

	private void Crawling_movie_comments() throws IOException {
		//// Crawling START
		FileWriter f0 = null;
		FileWriter f1 = null;
		try {
			f0 = new FileWriter("C:/dev/workspace/mini_project/under5.txt");
			f1 = new FileWriter("C:/dev/workspace/mini_project/upper5.txt");
		} catch (IOException e1) {
			System.out.println("file 만들 때 에러!!");
		}
		String newLine = System.getProperty("line.separator");

		for (int page_num = 1; page_num < 25; page_num++) {

			Document doc = null;
			try {
				doc = Jsoup.connect("http://movie.daum.net/moviedb/grade?movieId=93697&type=netizen&page=" + page_num)
						.get();
			} catch (IOException e1) {
				System.out.println("사이트 읽는 도중 에러!!");
			}

			// 평점
			Elements scores = doc.select("ul.list_review > li > div.review_info > div.raking_grade > em");
			// 댓글내용
			Elements titles = doc.select("ul.list_review > li > div.review_info > p.desc_review");
			
			System.out.println(scores.get(0));
			System.out.println(titles.get(0));
			
			try {
				for (int j = 0; j < 10; j++) {
					if (Integer.parseInt(scores.get(j).text()) < 5) {
//						f0.write("page_num:" + page_num + " / score" + j + ": " + scores.get(j).text() + newLine);					
						f0.write(titles.get(j).text() + newLine);											
					} else {
//						f1.write("page_num:" + page_num + " / score" + j + ": " + scores.get(j).text() + newLine);					
						f1.write(titles.get(j).text() + newLine);												
					}
					System.out.println("page_num : " + page_num + "/" + "list_num: " + j);
				}
			} catch (Exception e) {
				System.out.println("파일 출력 중 에러");
			}
		}
		f0.close();
		f1.close();
		
	}
	
	//// START wordcloud...  이거 작동 안한다 내일 질문!!!
	private void Make_wordcloud() {
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
	//// END wordcloud
	
}
