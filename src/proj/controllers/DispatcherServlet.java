package proj.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DispatcherServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	

	private static Logger logger =
			LoggerFactory.getLogger(DispatcherServlet.class);
	
	
	private static Map<String, AbstractController> controllerMap = 
			new HashMap<String, AbstractController>();
	
	@Override
	public void init() throws ServletException { 
		logger.info("DispatcherServlet.intit... 수행중!!!");
		InputStream is = null;
		Properties pr = new Properties();
		String filePath = this.getClass().getResource("").getPath();
		try {
			is = new FileInputStream(
					filePath + "dispatcher-servlet.properties");
			pr.load(is);
			
			for(Object obj : pr.keySet()){
				String key = ((String)obj).trim();
				String classPath = (pr.getProperty(key)).trim();
				
				try {
					Class className = Class.forName(classPath); //class 존재하는지 확인하고 있으면 참조까지 한다!!
					controllerMap.put(key,(AbstractController) className.newInstance()); // 인스턴스 미리 생성!! 그리고 Map에 담는다!!
					logger.info("loaded : " + key);
				} catch (Exception e) {
					e.printStackTrace();
					logger.info("failure : " + key);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(is != null) try{is.close();} catch(Exception e){};
		}
	}

	@Override
	protected void service(
		HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.info("mvcboard 수행 중...");
		String contentPath = request.getContextPath();
		String action = request.getRequestURI().trim().substring(contentPath.length());
		logger.info(action); // 
		
		AbstractController controller = null;
		ModelAndView mav = null;

		controller = controllerMap.get(action);
		if(controller == null){
			logger.info("수행할 액션이 없거나 AbstractController의 서브타입이 아닙니다.");
			return;
		}
		mav = controller.handleRequestInternal(request, response);
		

		if (mav != null){
			for(String key : mav.getModel().keySet()) {
				request.setAttribute(key, mav.getModel().get(key)); 
			}
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(mav.getViewName());
			dispatcher.forward(request, response);
			return;
		} else {
			logger.info("DispatcherServlet에서 길을 잃었다네");
		}
		
	}
}
