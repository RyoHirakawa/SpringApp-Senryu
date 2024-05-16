package com.example;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SenryuController {
	@Autowired
	private SenryuService senryuService;
	@Autowired
	private SenryuRepository senryuRepository;
	
	@GetMapping("/")
	public String index() {
		System.out.println("hell");
		return "index";
	}
	@GetMapping("/post")
	public String post() {
		return "post_senryu";
	}
	@PostMapping("/saveSenryu")
	public String saveSenryu(@Validated @ModelAttribute("Senryu") Senryu senryu, BindingResult bindingResult) {
		System.out.println(senryu.content + " hasErrors : " + bindingResult.hasErrors());
		if (bindingResult.hasErrors()) {
			System.out.println("エラーを検知しました");
			return "redirect:/post";
		}
		senryuService.saveSenryu(senryu.content);
		return "redirect:/view";
	}
	@GetMapping("/view")
	public String view(Model model) {
		java.util.List<Senryu> senryuList = senryuRepository.findAll();
		model.addAttribute("senryuList", senryuList);
		return "view_senryu";
	}
	@GetMapping("/search")
	public String search(@RequestParam("word") String word, Model model) {
		java.util.List<Senryu> senryuList;
		senryuList = senryuService.findSenryuByContentContaining(word);
		model.addAttribute("senryuList", senryuList);
		return "search_senryu";
	}
	@GetMapping("/editSenryu")
	public String edit(@RequestParam("id") Long id, Model model) {
		Optional<Senryu> optionalSenryu = senryuRepository.findById(id);
		Senryu senryu = optionalSenryu.orElseThrow(() -> new RuntimeException("Senryu not found"));
		model.addAttribute("senryu", senryu);
		return "edit_senryu";
	}
	
	@PostMapping("/updateSenryu")
	public String updateSenryu(@ModelAttribute Senryu senryu, Model model) {
		senryuService.updateSenryu(senryu);
		return "redirect:/view";
	}
	@GetMapping("/deleteSenryu")
	public String deleteSenryu(@RequestParam("id") Long id) {
		senryuService.deleteSenryu(id);
		return "redirect:/view";
	}
}
