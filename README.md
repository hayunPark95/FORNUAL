# 개요 
Spring Framework + JSP 전문가 외주 사이트





- FORNUAL은 전문가 외주를 목표로 공급과 수요를 연결해주는 사이트입니다.
FOR + MANAUL의 합성어인 FORNUAL은 카카오, 구글, 네이버 로그인과 같이 간단한 인증 과정을 거쳐 프리랜서, 전문 업체 등의 판매 글을 바탕으로 장바구니 기능, 찜 기능, 리뷰 기능, 카카오톡 공유하기 기능에 더해 카카오페이, KG 이니시스 카드 결제 사용으로 결제를 하는 기능으로 구성되어 있습니다. 

- 검색 기능, 전문가별 랭킹 기능, 전문가의 포트폴리오를 보는 기능, 구매 / 판매 관리를 통하여 일방적으로 소비자 중심의 서비스를 제공하는 평범한 쇼핑몰이 아닌 판매자가 구매자가 될 수도, 구매자가 판매자가 될 수도 있다는 가정하에 양 측 모두에게 풍부한 서비스를 제공한다!는 모토를 가지고 작업에 임하였습니다


- 댓글, 답글 시스템과 QnA 기능의 추가로 여러 번의 피드백이 필요한 FORNUAL의 상품들의 특징을 고려하여 판매, 구매 상황에서의 편의성을 높였으며 페이지를 연결할 때, 사용자의 입장에서 다음 페이지에 어떤 페이지가 있으면 좋을지를 고려해 보다 짜임새있게 페이지 연결을 구현하였습니다


# 프로젝트 소개
크몽을 참고로 만든 사이트입니다


**개발 기간:** 2023년 8월 1일 ~ 2023년 9월 26일


# 기획 의도

이 프로젝트의 주요 기획 의도는 다음과 같습니다:

- 공산품이 아닌 판매자와 소비자의 피드백을 통해 전문가의 능력을 구매하고 판매할 수 있는 외주 사이트를 만드는 것입니다.

- 일반적인 쇼핑몰과 달리 하나의 계정이 판매자와 구매자 역할을 동시에 할 수 있도록 설계하여 많은 데이터베이스 관리와 페이지 설계를 가능하게 합니다.

- 상품 상태를 나타내는 로직 역시 일반 쇼핑몰과 달리 판매자의 계정에서 제작 중, 제작 완료 등과 같은 형태로 나타나도록 제작되었습니다.

이 프로젝트의 핵심 목표는 판매자와 구매자 간의 상호작용을 강화하고 개인 판매자의 능력을 향상시켜보다 다양한 제품과 서비스를 소비자에게 제공하는 것입니다.



# 참여 인원
팀장 : 윤주훈 


- 로그인 관련 기능
- 리뷰 기능
- 상품 관련 기능
- 회원가입


부팀장 : 서수연


- 결제 관련 기능
- QnA 게시판
- 리뷰 기능
- 마이페이지 기능


팀원 : 박하윤


- 상품 관련 기능
- 전문가 페이지 기능
- 검색 기능
- 전문가 랭킹


 팀원 : 조민환


 - 프론트엔드 전반
 - 회원가입
 - 로그인 관련 기능
 - 관리자 페이지


팀원 : 조혜민


- 메인 페이지
- 프론트엔드 전반
- 전문가 페이지 기능
- AWS 서버
- 로그인 관련 기능
- 장바구니
- 공유하기 기능 / 지도 API 기능


# 개발 환경
- Java 11


- JavaScript


- tomcat V 9.0


- OAuth2


- Security


- 서버 : AWS


- Database : Oracle DB(11g)


- 템플릿 : bootstrap


- 외부 API :


카카오페이 api


KG 이그니스 결제 api


소셜로그인(네이버, 구글, 카카오)api


카카오 공유하기 api


구글 맵 api


# ERD 
<img width="1191" alt="ERD" src="https://github.com/juhoon212/fornula/assets/129178751/7e19901b-b190-4e6b-a8cd-da830a14a88b">


# Oralcle 11g DB 정의서
[DB 정의서](https://github.com/juhoon212/fornula/raw/main/fornual.sql)


# 피드백


1.	프로젝트 방향


완성도를 높이기 위하여... 


- 기능을 여러개 만드는 것이 주니어 개발자에겐 조금 더 도움이 될 수 있을 것
- 검증 로직(ex.@transaction)을 통하여 404,500 상태코드를 최소화 할 것 <- 특히나 결제와 관련된 기능은 더더욱 신경을 쓸 것
- 공용 Exception을 활용하도록 할 것


2. api는 사용할 수 있다면 되도록 사용하여 api를 활용하는 것에 대한 익숙함을 가지도록 할 것


3. back 영역과 front 영역을 나눌 것


- 페이지를 전부 하나하나 이동하는 방식을 사용한다면 서버 비용으로 인하여 기업에 부담감을 줄 수 있다
- restcontroller를 사용하는 것에 익숙해 질 겸 AJAX를 사용 해 볼 것을 권장
- 여유가 된다면 swagger를 사용해보는 것을 추천


4. 소셜 로그인 시 주의사항


- front에서만 구축하는 것이 아닌, back 영역에서도 Token을 활용할 것


5. Query문을 짜임새 있게 짤 것


# 주요 기능

[회원가입 기능](#회원가입-기능)


- 일반적인 회원 가입 기능입니다
- 아이디 찾기, 비밀번호 찾기, 실패 로직 등이 포함되어 있습니다

>> View


[회원가입](https://github.com/juhoon212/fornula/blob/main/screenshot/%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85.png)


[ID 찾기](https://github.com/juhoon212/fornula/blob/main/screenshot/%EC%95%84%EC%9D%B4%EB%94%94%20%EC%B0%BE%EA%B8%B0.png)


[비밀번호 찾기](https://github.com/juhoon212/fornula/blob/main/screenshot/%EB%B9%84%EB%B0%80%EB%B2%88%ED%98%B8%20%EC%B0%BE%EA%B8%B0.png)

---
[로그인 기능](#로그인-기능)


- 카카오, 구글, 네이버 로그인 기능 및 일반적인 회원 가입 기능입니다
- Security가 적용되었습니다


>> View


[구글 로그인](https://github.com/juhoon212/fornula/blob/main/screenshot/%EA%B5%AC%EA%B8%80%EB%A1%9C%EA%B7%B8%EC%9D%B8.png)


[네이버 로그인](https://github.com/juhoon212/fornula/blob/main/screenshot/%EB%84%A4%EC%9D%B4%EB%B2%84%EB%A1%9C%EA%B7%B8%EC%9D%B8.png)


[카카오 로그인](https://github.com/juhoon212/fornula/blob/main/screenshot/%EC%B9%B4%EC%B9%B4%EC%98%A4%EB%A1%9C%EA%B7%B8%EC%9D%B8.png)

---

[메인페이지 기능](#메인페이지-기능)


- header, footer가 포함된 페이지입니다
- 검색, 전문가 랭킹, 고객센터, 회사소개, 카테고리별 검색 기능이 포함된 페이지입니다 


>> View


[헤더(비로그인)](https://github.com/juhoon212/fornula/blob/main/screenshot/%ED%97%A4%EB%8D%94(%EB%B9%84%EB%A1%9C%EA%B7%B8%EC%9D%B8).png)


[헤더(로그인)](https://github.com/juhoon212/fornula/blob/main/screenshot/%ED%97%A4%EB%8D%94(%EB%A1%9C%EA%B7%B8%EC%9D%B8).png)


[메인페이지](https://github.com/juhoon212/fornula/blob/main/screenshot/%EB%A9%94%EC%9D%B8%ED%8E%98%EC%9D%B4%EC%A7%80.png)


[회사 소개](https://github.com/juhoon212/fornula/blob/main/screenshot/%ED%9A%8C%EC%82%AC%EC%86%8C%EA%B0%9C.png)

---

[마이페이지 기능](#마이페이지-기능)


- 내 정보 수정, 구매 관리, 장바구니, 비밀번호 수정, 회원 탈퇴 기능이 포함된 페이지입니다


>> View

[마이페이지 - 정보 수정](https://github.com/juhoon212/fornula/blob/main/screenshot/%EB%A7%88%EC%9D%B4%ED%8E%98%EC%9D%B4%EC%A7%80(%EC%A0%95%EB%B3%B4%EC%88%98%EC%A0%95).png)


[마이페이지 - 구매관리](#여기 채워)


[마이페이지 - 장바구니](https://github.com/juhoon212/fornula/blob/main/screenshot/%EC%9E%A5%EB%B0%94%EA%B5%AC%EB%8B%88.png)


[마이페이지 - 비밀번호 수정](https://github.com/juhoon212/fornula/blob/main/screenshot/%EB%B9%84%EB%B0%80%EB%B2%88%ED%98%B8%20%EC%88%98%EC%A0%95.png)


[마이페이지 - 회원 탈퇴](https://github.com/juhoon212/fornula/blob/main/screenshot/%ED%9A%8C%EC%9B%90%ED%83%88%ED%87%B4.png)

---

[전문가페이지 기능](#전문가페이지-기능)


- 전문가 정보 수정, 판매 관리, 상품 관리, 상품 등록이 포함된 페이지입니다


>> View


[전문가 페이지 - 정보 수정](https://github.com/juhoon212/fornula/blob/main/screenshot/%EC%A0%84%EB%AC%B8%EA%B0%80%20%ED%8E%98%EC%9D%B4%EC%A7%80%20-%20%EC%A0%95%EB%B3%B4%20%EC%88%98%EC%A0%95.png)


[상품 관리](https://github.com/juhoon212/fornula/blob/main/screenshot/%EC%83%81%ED%92%88%20%EA%B4%80%EB%A6%AC.png)


[판매 관리](https://github.com/juhoon212/fornula/blob/main/screenshot/%ED%8C%90%EB%A7%A4%20%EA%B4%80%EB%A6%AC.png)

---

[검색 기능](#검색-기능)


- SQL문을 활용하여 여러 방법(카테고리별 검색, 내용/제목 포함 검색)으로 검색이 가능하도록 만든 기능입니다


>> View


[상품 등록](https://github.com/juhoon212/fornula/blob/main/screenshot/%EC%83%81%ED%92%88%20%EB%93%B1%EB%A1%9D.png)


[상품 수정](https://github.com/juhoon212/fornula/blob/main/screenshot/%EC%83%81%ED%92%88%20%EC%88%98%EC%A0%95.png)


[상품 상세](https://github.com/juhoon212/fornula/blob/main/screenshot/%EC%83%81%ED%92%88%20%EC%83%81%EC%84%B8.png)


[상품 게시판](https://github.com/juhoon212/fornula/blob/main/screenshot/%EC%83%81%ED%92%88%EA%B2%8C%EC%8B%9C%ED%8C%90.png)


[댓글/답글](https://github.com/juhoon212/fornula/blob/main/screenshot/%EB%A6%AC%EB%B7%B0.png)

---

[QnA 기능](#QnA-기능)


- QnA 게시판 기능을 하는 페이지입니다


>> View


[QnA 게시판](https://github.com/juhoon212/fornula/blob/main/screenshot/QnA%EA%B2%8C%EC%8B%9C%ED%8C%90.png)

---

[전문가랭킹 기능](#전문가랭킹-기능)


- 전문가 판매액 순서로 출력, 모든 전문가를 등록일자 순서로 출력하는 페이지입니다


>> View


[결제 창](https://github.com/juhoon212/fornula/blob/main/screenshot/%EA%B2%B0%EC%A0%9C.png)

---

# 발표자료
[Fornual 최종 발표 ppt](https://github.com/juhoon212/fornula/blob/main/final%20ppt.pptx)
