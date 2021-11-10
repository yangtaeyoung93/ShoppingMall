# ShoppingMall

### 프로젝트 환경
- Project : Gradle Project
- Language : Java
- Spring Boot : 2.5.6
- Database : H2

### 테스트 라이브러리
#### Spring-boot-starter-test
- junit4 : 테스트 프레임워크
- assertj : 테스트 코드를 편하게 작성할 수 있도록 도와주는 라이브러리
- spring-test : 스프링 통합 테스트 지원

#### 주요 라이브러리
 - JPA, 하이버네이트
 - 스프링 데이터 JPA
 - 스프링 MVC
 - 스프링 ORM
 
 ### 기타 라이브러리
 - H2 데이터베이스 클라이언트
 - thymleaf
 - lombok
 
 
 #주요 요구사항
 ### 회원 기능
  - 회원 등록
  - 회원 조회
  - 회원 수정
  
 ### 상품 기능
 - 상품 등록
 - 상품 수정
 - 상품 조회
 
 ### 주문 기능
 - 상품 주문
 - 주문 내역 조회
 - 주문 취소
 
 ### 배송 기능
 - 배송 조회
 
 # 기타 요구사항
 - 상품의 종류는 도서,음반,영화가 있다.
 - 상품을 카테고리로 구분할 수 있다.
 - 상품은 재고 관리가 필요하다.
 - 상품 주문시 배송 정보를 입력할 수 있다.
 

# 도메인 모델 및 테이블 설계
![엔티티 모델](https://user-images.githubusercontent.com/52926582/141036469-0e43a562-9a71-4258-931c-84b0f143071f.PNG)

[도메인모델]

![테이블 설계](https://user-images.githubusercontent.com/52926582/141039618-fffb75a4-57e7-4217-9a9c-6a4a7e91c050.PNG)
[테이블모델]

 
 
 
