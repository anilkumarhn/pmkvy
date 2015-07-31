package org.ndt.student.controller;

import org.ndt.student.entity.Batch;
import org.ndt.student.services.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BatchController 
{
	@Autowired
    private BatchService batchService;
 
	@RequestMapping(value="batchs.html", method = RequestMethod.POST)
	public ModelAndView getBatchList(@ModelAttribute("batch") Batch batch ,BindingResult bindingResult ,Model model, @RequestParam("centre") String cetreID, @RequestParam("sector") String sectorID)
	{
		model.addAttribute("batchList", (batchService.getBatchList()));
		model.addAttribute("centre",cetreID);
		model.addAttribute("sector",sectorID);
		ModelAndView mv = new ModelAndView("batch","command",model);  
		return mv;  
	}
	
	@RequestMapping(value="edit", method = RequestMethod.POST)
	public ModelAndView editBatch(@ModelAttribute("batch") Batch batch,BindingResult bindingResult,Model model )
	{
		batchService.editBatch(batch);
		model.addAttribute("batchList", (batchService.getBatchList()));
		ModelAndView mv = new ModelAndView("batch","command",model);  
		return mv; 
	} 	
}