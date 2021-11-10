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
 

<img src="https://user-images.githubusercontent.com/52926582/141039788-3284d5d9-8ca9-4f89-b9b7-bc3cbc74fad8.PNG" width="800" height="500" />
                                                                                                                                         
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
 - 비밀번호는 암호화 후 저장
 

# 도메인 모델 및 테이블 설계
![엔티티 모델](https://user-images.githubusercontent.com/52926582/141036469-0e43a562-9a71-4258-931c-84b0f143071f.PNG)

[도메인모델]

회원(Member): 이름과 임베디드 타입인 주소( Address ), 그리고 주문( orders ) 리스트를 가진다.

주문(Order): 한 번 주문시 여러 상품을 주문할 수 있으므로 주문과 주문상품( OrderItem )은 일대다 관계
다. 주문은 상품을 주문한 회원과 배송 정보, 주문 날짜, 주문 상태( status )를 가지고 있다. 주문 상태는 열
거형을 사용했는데 주문( ORDER ), 취소( CANCEL )을 표현할 수 있다.


주문상품(OrderItem): 주문한 상품 정보와 주문 금액( orderPrice ), 주문 수량( count ) 정보를 가지고
있다. (보통 OrderLine , LineItem 으로 많이 표현한다.)


상품(Item): 이름, 가격, 재고수량( stockQuantity )을 가지고 있다. 상품을 주문하면 재고수량이 줄어든
다. 상품의 종류로는 도서, 음반, 영화가 있는데 각각은 사용하는 속성이 조금씩 다르다.


배송(Delivery): 주문시 하나의 배송 정보를 생성한다. 주문과 배송은 일대일 관계다.


카테고리(Category): 상품과 다대다 관계를 맺는다. parent , child 로 부모, 자식 카테고리를 연결한
다.


주소(Address): 값 타입(임베디드 타입)이다. 회원과 배송(Delivery)에서 사용한다.

![테이블 설계](https://user-images.githubusercontent.com/52926582/141039618-fffb75a4-57e7-4217-9a9c-6a4a7e91c050.PNG)

[테이블모델]

Item 테이블은 싱글테이블 전략으로 생성
- 조인을 하지 않아 성능이 조인 전략보다 낫다 그렇지만 불필요한 공간이 발생하기 때문에 메모리 측면으로 봤을때 비효율적이다.

 
 
 
