package proj.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Servlet implementation class Trans
 */
@WebServlet("/Trans")
public class Trans extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @Override
	   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
		  KeywordImpl keywordImpl = new KeywordImpl();
		  KeywordDAO keywordDAO = KeywordImpl.getInstance();
		  List <KeywordVO> list = keywordImpl.inkeyword();
		  
//		  List<KeywordVO> list = keywordDAO.inkeyword();
		  //KeywordVO keywordVO = new KeywordVO();
		  
	   StringBuffer word1 = new StringBuffer();
		   for(KeywordVO keywordVO : list){
			   word1.append(keywordVO.getKeyword_ko()+"\n" );
			   
		   }

	      String clientId = "ubasmpZ93GesXy0pAZhb";//애플리케이션 클라이언트 아이디값";
	        String clientSecret = "625P_Q0Dn2";//애플리케이션 클라이언트 시크릿값";
	        try {

//	        	StringBuffer word1 = new StringBuffer("광섭 "+"\n");
//	        	
//	        	word1.append( "브라우저 "+"\n" );
//	        	word1.append( "의자"+"\n");
	        	
//	  		  List<KeywordVO> list = keywordDAO.inkeyword();
//	 		   StringBuffer word1 = new StringBuffer();
//			   for(KeywordVO keywordVO1 : list){
//				   word1.append(keywordVO.getKeyword_ko()+"\n" );
//				   
//			   }

	            String text = URLEncoder.encode(word1.toString(), "UTF-8");

	            String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            
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
	            if(responseCode==200) { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            } else {  // 에러 발생
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

	                   JSONObject jsonObject =(JSONObject) obj;
	                   System.out.println(jsonObject);
	                   JSONObject jsonMessage =(JSONObject) jsonObject.get("message");
	                   
	                   if(jsonMessage != null) {
		                   System.out.println(jsonMessage.toString());
		                   if(jsonMessage==null){
		                	   System.out.println("모든 단어가 번역 되어 있음");
		                   }
		                   JSONObject jsonResult =(JSONObject) jsonMessage.get("result");
		                   String jsonTranslatedText =(String) jsonResult.get("translatedText");
		                   
		                   String[] word_engs = jsonTranslatedText.split("\n");
	
		                   for(int i=0; i<list.size();i++){
		                	   KeywordVO keywordVO = list.get(i);
		                	   keywordVO.setKeyword_en(word_engs[i]);
		                   }
	                   }
	                   keywordDAO.outkeyword(list);
	                   
	                   for(KeywordVO vo : list) {
	                	   System.out.println(vo);
	                   }
	                  
	            } catch (Exception e) {
	                   e.printStackTrace();
	            }
	       } catch (Exception e) {
	            System.out.println(e);
	        }
	   }
	}