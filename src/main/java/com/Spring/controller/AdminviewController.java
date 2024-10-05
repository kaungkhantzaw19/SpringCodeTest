package com.Spring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Spring.model.ProductBean;
import com.Spring.repository.ProductRepo;

@Controller
public class AdminviewController {
	
	@RequestMapping(value="/adminview")
	public String adminView() {
		return "adminview";
	}
	  
	
	@RequestMapping(value="/addproduct")
	public ModelAndView addproduct() {
		ProductBean pb=new ProductBean();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("addproductview");
		mv.addObject("addproductbean", pb);
		return mv;
	}
	@PostMapping(value="/addproductrepo")
	public String addproductrepo(@ModelAttribute("addproductbean") ProductBean pb) {
		ProductRepo pr=new ProductRepo();
		pr.addProductRepo(pb);
		return "redirect:showproduct";
	}
	@RequestMapping(value="/showproduct")
	public String showproduct(Model m) {
		ProductRepo pr=new ProductRepo();
		List<ProductBean> list=pr.showProductRepo();
		m.addAttribute("listdata", list);
		return"showProductView";
	}
//	@GetMapping(value="/updateproduct")
//	public String updateproduct() {
////		ProductRepo pr=new ProductRepo();
////		ModelAndView mv=new ModelAndView();
////		mv.setViewName("updateProductView");
////		mv.addObject("updatedata", pr);
//		return "updateProductView";
//	}
	@PostMapping(value="/updateRepo")
	public String updateRepo(@ModelAttribute("updatedata")ProductBean pb) {
		ProductRepo pr=new ProductRepo();
		pr.updateRepo(pb);
		return"redirect:showproduct";
	}
	@GetMapping(value="/deleteproduct")
	public String deleteproduct(@RequestParam("id")int id) {
		ProductRepo pr=new ProductRepo();
		pr.deleteRepo(id);
		return "redirect:showproduct";
	}
	
	@GetMapping(value="/Update")
	public ModelAndView update() {
		ProductBean pd=new ProductBean();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("updateProductView");
		mv.addObject("updatedata",pd);
		return mv;

	}
	
}
