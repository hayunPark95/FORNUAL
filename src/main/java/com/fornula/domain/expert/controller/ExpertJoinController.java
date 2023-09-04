package com.fornula.domain.expert.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import com.fornula.domain.expert.dto.Expert;
import com.fornula.domain.expert.service.ExpertJoinService;
import com.fornula.domain.item.dto.Category;
import com.fornula.domain.member.dto.Member;
import com.fornula.domain.member.service.MypageInfoService;
import com.fornula.domain.util.session.SessionConst;
import com.google.common.util.concurrent.Service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/expert")
public class ExpertJoinController {
	private final ExpertJoinService expertJoinService;
	private final WebApplicationContext context;
	private final MypageInfoService service;

	

	@GetMapping("/join")
	public String join(HttpSession session) {
		Member member = (Member) session.getAttribute(SessionConst.Login_Member);

		session.setAttribute("member", member.getId());

		return "expert-join";
	}

	@PostMapping("/join")
	public String join(@Validated @ModelAttribute("expert") Expert expert, 
			@RequestParam MultipartFile uploadFile, Model model,
			Errors errors, HttpSession session) throws IllegalStateException, IOException {
		log.info("expert:{}", expert);
		log.info("file:{}", uploadFile);

		Member member = (Member) session.getAttribute(SessionConst.Login_Member);
		expert.setMemberIdx(member.getMemberIdx());
		
		if(errors.hasErrors()) {
			log.info("errors :{}", errors);
			return "expert-join";
		}

		// 업로드된 파일이 pdf 파일이 아닐 경우
		if (!uploadFile.isEmpty() && !uploadFile.getContentType().equals("application/pdf")) {
			log.info("file:{}", uploadFile);
			model.addAttribute("message", "pdf 파일만 업로드해주세요.");
			return "expert-join";
		}

		
		if(!uploadFile.isEmpty()) {
			String uploadDirectory = context.getServletContext().getRealPath("/resources/upload");
			log.info("filepath =" + uploadDirectory);
	
			String expertfileName = UUID.randomUUID().toString() + "_" + uploadFile.getOriginalFilename();
			log.info("filename =" + expertfileName);
	
			expert.setExpertfileName(expertfileName);

			try {
				uploadFile.transferTo(new File(uploadDirectory, expertfileName));
				System.out.println("파일 업로드 성공");
			} catch (IllegalArgumentException | IOException e) {
				System.out.println("파일 업로드 실패");
				e.printStackTrace();
			}
		}
		

		expertJoinService.addExpertInfo(expert);

		// 등록처리에 성공하였을때 memberIdx 변경
		member.setMemberStatus(2);
		expertJoinService.updateExpertStatus(member);
		session.setAttribute("loginMember", member);
		model.addAttribute("message","전문가 등록이 완료되었습니다");
		
		return "expertjoin-success";

	}
}
