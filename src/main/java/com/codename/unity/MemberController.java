package com.codename.unity;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

	@Autowired
	private MemberRepository memberRepository;
	
	@GetMapping("/signup")
	public String showSignUpForm(Member member) {
		
		return "add-member";
	}
	
	@PostMapping("/addmember")
	public String addMember (@Valid Member member, BindingResult result, Model model) {
	
		if(result.hasErrors()) {
			return "add-member";
		}
		
		memberRepository.save(member);
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String showMemberList(Model model) {
		model.addAttribute("members", memberRepository.findAll());
		return "index";
		
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Member member = memberRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Invalid member Id:" + id));
		
		model.addAttribute("member", member);
		return "update-member";
		}
	
	@PostMapping("update/{id}")
	public String updateMember(@PathVariable("id") long id, @Valid Member member, BindingResult result, Model model) {
		if(result.hasErrors()) {
			member.setId(id);
			return "update-member";
		}
		
		memberRepository.save(member);
		return "redirect:/index";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteMember(@PathVariable("id") long id, Model model) {
		Member member = memberRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Invalid member Id:" + id));
		memberRepository.delete(member);
		return "redirect:/index";
	}
	
}
