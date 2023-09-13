package com.fornula.domain.member.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.fornula.domain.member.dto.Member;
import com.fornula.domain.member.dto.vo.FindPasswordForm;
import com.fornula.domain.member.service.MemberJoinService;
import com.fornula.domain.member.service.MemberLoginService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
	
	private final MemberLoginService memberLoginService;
	private final MemberJoinService memberJoinService;
	
	// 회원가입 폼
	@GetMapping("/join")
	public String join(@ModelAttribute Member member) {
		return "join";
	}
	
	// 회원가입 
	@PostMapping("/join")
	public String joinForm(@ModelAttribute @Valid Member member, RedirectAttributes redirectAttributes, Errors errors) {
		
		 
		if (errors.hasErrors()) {
			System.out.println(errors.getErrorCount());
			log.info("Validation errors: {}", errors);
			return "member/join";
		}
		 
		 redirectAttributes.addFlashAttribute("message", "회원가입 성공");
		 return "redirect:/";
	}
	
	
	
	// 아이디 찾기
	@GetMapping("/findId")
	public String showFindId() {
		return "find-id";
	}
	
	
	// 비밀번호 찾기
	@GetMapping("/findPw")
	public String findPw() {
		return "find-pw";
	}
	
	@PostMapping("/findPw")
	public String findPw(@ModelAttribute FindPasswordForm form, RedirectAttributes redirectAttributes) {
		
		Member findMember = memberLoginService.findPw(form.getId(), form.getEmail());
		
		// 실패 로직
		if(ObjectUtils.isEmpty(findMember)) {
			redirectAttributes.addAttribute("status", "false");
			redirectAttributes.addFlashAttribute("message", "맞"
					+ "지 않는 아이디 또는 이메일입니다.");
			return "redirect:/member/findPw";
		}
		
		redirectAttributes.addAttribute("memberIdx", findMember.getMemberIdx());
		
		return "redirect:/member/updatePassword/{memberIdx}";
	}
	
	@GetMapping("/updatePassword/{memberIdx}")
	public String findNewPw(@PathVariable String memberIdx, Model model) {
		
		model.addAttribute("memberIdx", memberIdx);
		
		return "update-password";
	}
	
	@PostMapping("/updatePassword/{memberIdx}") 
	public String updatePassword(@PathVariable String memberIdx, 
								@RequestParam(required = false) String newPassword, 
								RedirectAttributes redirectAttributes, 
								Model model
								) {
		
		Member findByIdxMember = memberLoginService.findByIdx(Integer.parseInt(memberIdx));
		
		if(ObjectUtils.isEmpty(findByIdxMember)) {
			redirectAttributes.addFlashAttribute("message", "찾으시는 비밀번호와 동일한 아이디가 없습니다");
			return "redirect:/member/findPw";
		}
		
		int result = memberLoginService.updatePassword(findByIdxMember.getId(), newPassword);
		
		if(result == 0) {
			return "400";
		}
		
		model.addAttribute("message", "비밀번호가 변경되었습니다.");
		return "common-success";
	}
	
	//로그아웃
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
		
	}
	
	
}