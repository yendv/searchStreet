package com.webapp.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.driver.entity.client.Guide;
import com.driver.manager.client.GuideManager;


@Controller
@RequestMapping(value="/guide")
public class GuideController {
	@EJB
	private GuideManager guideManager;
	
	@RequestMapping(value="/index" , method= RequestMethod.GET)
	public String index(HttpServletRequest request , HttpServletResponse reponse){
		List<Guide> guideLst =  guideManager.getDmHuongDanSuDungList(null, null, null);
		System.err.println(guideLst.size());
		return "guideIndex";
	}
}
