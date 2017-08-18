package cn.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexContoller {
	
	@RequestMapping("/homePage.html")
	public String index(){
		
		return "homePage/homePage";
	}
}
