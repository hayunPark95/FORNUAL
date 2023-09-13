package com.fornula.domain.member.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * 이름              널?       유형            
--------------- -------- ------------- 
MEMBER_IDX      NOT NULL NUMBER        
ID              NOT NULL VARCHAR2(20)  
PASSWORD        NOT NULL VARCHAR2(100) 
EMAIL           NOT NULL VARCHAR2(40)  
MEMBER_DATE     NOT NULL DATE          
MEMBER_STATUS   NOT NULL NUMBER        
MEMBERFILE_NAME          VARCHAR2(100) 
LOGIN_DATE               DATE       

 //회원 관심사 테이블 삭제 후
  * 카테고리 1,2,3, 컬럼 추가
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	
	private int memberIdx;
	
	@NotEmpty(message = "아이디를 입력해 주세요")
	@Pattern(regexp = "^[a-zA-Z0-9]{6,20}$", message = "6~20자의 영문 소문자와 숫자만 사용 가능합니다")
	private String id;
	
	@NotEmpty(message = "비밀번호를 입력해 주세요")
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$"
			, message = "8~20자의 영문, 숫자, 특수문자를 모두 포함한 비밀번호를 입력해주세요")
	private String password;
	
	@NotEmpty(message = "이메일을 입력해 주세요")
	@Email(message = "이메일을 양식으로 작성해 주세요")
	private String email;
	
	private String memberDate;
	private int memberStatus;
	private String memberFileName;
	private String loginDate;
	private int categoryOne; // 카테고리 1,2,3 추가
	private int categoryTwo;
	private int categoryThree;
}
