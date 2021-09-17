package com.codename.unity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MemberController {
	
	@Autowired
	private MemberRepository repository;

	  @GetMapping("/members")
	  public String all(Model model) {
		  List<Member> members = repository.findAll();
		  model.addAttribute("members", members);
	    return "members";
	  }
	  // end::get-aggregate-root[]

	  @PostMapping("/members")
	  Member newMember(@RequestBody Member newMember) {
	    return repository.save(newMember);
	  }

	  // Single item
	  
	  @GetMapping("/members/{id}")
	  Member one(@PathVariable Long id) throws MemberNotFoundException {
	    
	    return repository.findById(id)
	      .orElseThrow(() -> new MemberNotFoundException(id));
	  }

	  @PutMapping("/members/{id}")
	  Member replaceMember(@RequestBody Member newMember, @PathVariable Long id) {
	    
	    return repository.findById(id)
	      .map(Member -> {
	        Member.setName(newMember.getName());
	        Member.setRole(newMember.getRole());
	        return repository.save(Member);
	      })
	      .orElseGet(() -> {
	        newMember.setId(id);
	        return repository.save(newMember);
	      });
	  }


}
