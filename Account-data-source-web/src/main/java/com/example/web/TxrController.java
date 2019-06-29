package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.service.TxrService;
import com.example.model.Txn;

@Controller
public class TxrController {

	@Autowired
	private TxrService txrService;

	@RequestMapping(value = "txr.htm", method = RequestMethod.GET)
	public String showTxrForm() {
		// ..

		return "txr-form";
	}

	@RequestMapping(value = "show.htm", method = RequestMethod.GET)
	public String showStatementForm() {
		// ..
		return "statement-form";
	}

	@RequestMapping(value = "txr.htm", method = RequestMethod.POST)
	public String doTxr(@ModelAttribute TxrRequest request, Model model) {
		System.out.println(request.getAmount());
		boolean b = txrService.transfer(request.getAmount(), request.getFromAccNum(), request.getToAccNum());

		TxrResponse response = new TxrResponse();
		response.setMessage(b ? "Txr Successfull" : "Txr Failed");
		model.addAttribute("status", response);
		return "txr-status";
	}

	@RequestMapping(value = "show.htm", method = RequestMethod.POST)
	public ModelAndView showTxr(@RequestParam String fromAccNum) {
		System.out.println(fromAccNum);
		List<Txn> list = txrService.show(fromAccNum);// txn.getAccount().getNumber());
		System.out.println(list);
		ModelAndView mav = new ModelAndView();
		mav.addObject("txnList", list);
		mav.setViewName("statement-show");
		return mav;
	}

}
