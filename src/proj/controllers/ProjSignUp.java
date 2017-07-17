package proj.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proj.controllers.ModelAndView;

public class ProjSignUp extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/WEB-INF/views/proj/sign_up.jsp");
	}
}
