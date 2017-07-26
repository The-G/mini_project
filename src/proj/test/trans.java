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
 * Servlet implementation class Transser
 */
@WebServlet("/Transser")
public class trans extends HttpServlet {

	
   private static final long serialVersionUID = 1L;
   

 
   //DB에는 movie_id,keyword_ko,keyword_en,keyword_cn,count로 구성되어 있다
   //DB에서 통째로 외국어 키워드가 null인 애들을 받아온다
   //이때 받아온 DB는(select kokeyword,enkeyword(cn),count from keyword_table where enkeyword=null;)
   
   //에서 받아온 DB를 뜻하면 우리는 인덱스를 통해 kokeyword를 하나씩 받아오고
   //for 문을 통해 한 줄 씩  word1.append( list[i]+"\n");식으로 붙여 한문장을 만든다
   //이 한 문장을 번역한다.
   //이 번역한 한 줄을 다시 짤라 for문을 통해 한 단어 형태로 리스트에 넣어준다.
   //잘라진 순서대로 다시 DB에 리스트를 insert하여 null이었던 해당 언어 컬럼에 넣어 준다.
  

   @Override
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	   KeywordDAO keywordDAO = new KeywordDAO();
	   List list = keywordDAO.inkeyword();
	   System.out.println(list);
	   
		
      String clientId = "ubasmpZ93GesXy0pAZhb";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "625P_Q0Dn2";//애플리케이션 클라이언트 시크릿값";
        try {

        	StringBuffer word1 = new StringBuffer("광섭 "+"\n");
        	
        	word1.append( "브라우저 "+"\n" );
        	word1.append( "의자"+"\n");
        	
        	System.out.println(word1);

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
                   JSONObject jsonMessage =(JSONObject) jsonObject.get("message");
                   JSONObject jsonResult =(JSONObject) jsonMessage.get("result");
                   String jsonTranslatedText =(String) jsonResult.get("translatedText");
                   System.out.println(jsonTranslatedText);
                   String arr[]=jsonTranslatedText.split(", ");
                   for(int i=0; i<arr.length;i++){
                	   System.out.println(arr[i]);
                	   //db에 어펜드
                   }
                   
            } catch (Exception e) {
                   e.printStackTrace();
            }
       } catch (Exception e) {
            System.out.println(e);
        }
   }
}