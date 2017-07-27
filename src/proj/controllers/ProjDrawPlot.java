package proj.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjDrawPlot extends AbstractController {
	
	
	
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		WebElement temp_list;
		
		String name = request.getParameter("name");

		System.setProperty(
                "webdriver.chrome.driver",
                "C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.kobis.or.kr/kobis/business/mast/mvie/searchMovieList.do");
		
		driver.findElement(By.name("sMovName")).sendKeys(name);
		driver.findElement(By.xpath("//*[@id='searchMainTopMovie']/table/tbody/tr/td[2]/img")).click();
		
		driver.findElement(By.xpath("//*[@id='content']/table/tbody/tr[1]/td[1]/a")).click();
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/section/div/ul/li[2]/a")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[5]/div[2]/section[2]/div[1]/section/div/div[2]/table[1]")));
		
		WebElement new_test = driver.findElement(By.xpath("/html/body/div[5]/div[2]/section[2]/div[1]/section/div/div[2]/table/thead/tr/th[1]"));
		
		
		if (new_test.getText().toString().trim().equals("지역")){
			temp_list = driver.findElement(By.xpath("/html/body/div[5]/div[2]/section[2]/div[1]/section/div/div[3]/table[1]"));
		} else {
			temp_list = driver.findElement(By.xpath("/html/body/div[5]/div[2]/section[2]/div[1]/section/div/div[2]/table[1]"));
			
		}
			
		
		
		List<WebElement> list = temp_list.findElements(By.tagName("tr"));
		
		ArrayList<String[]> data_list = new ArrayList<String[]>();
		
		for (WebElement data : list) {
			data_list.add(data.getText().split(" "));
		}
		
		mav.addObject("a", Arrays.asList(data_list.get(2)).get(4).replace(",", ""));
		mav.addObject("b", Arrays.asList(data_list.get(3)).get(4).replace(",", ""));
		mav.addObject("c", Arrays.asList(data_list.get(4)).get(4).replace(",", ""));
		mav.addObject("d", Arrays.asList(data_list.get(5)).get(4).replace(",", ""));
		mav.addObject("e", Arrays.asList(data_list.get(6)).get(4).replace(",", ""));
		mav.addObject("f", Arrays.asList(data_list.get(7)).get(4).replace(",", ""));
		mav.addObject("g", Arrays.asList(data_list.get(8)).get(4).replace(",", ""));
		mav.addObject("h", Arrays.asList(data_list.get(9)).get(4).replace(",", ""));
		mav.addObject("i", Arrays.asList(data_list.get(10)).get(4).replace(",", ""));
		mav.addObject("j", Arrays.asList(data_list.get(11)).get(4).replace(",", ""));
		
		
//		System.out.println();
//		System.out.println(Arrays.asList(data_list.get(3)).get(4));
//		System.out.println(Arrays.asList(data_list.get(4)).get(4));
//		System.out.println(Arrays.asList(data_list.get(5)).get(4));
//		System.out.println(Arrays.asList(data_list.get(6)).get(4));
//		System.out.println(Arrays.asList(data_list.get(7)).get(4));
//		System.out.println(Arrays.asList(data_list.get(8)).get(4));
//		System.out.println(Arrays.asList(data_list.get(9)).get(4));
//		System.out.println(Arrays.asList(data_list.get(10)).get(4));
//		System.out.println(Arrays.asList(data_list.get(11)).get(4));
		
		mav.setViewName("/WEB-INF/views/proj/draw_plot.jsp");
		
		
		return mav;
	}
	

}
