# spring-schedule-calendar 🗓
## 일정 관리 앱 DEVELOP 🧑🏻‍💻

------------
## API 명세서 📋
### Lv 0. API 명세 작성   `필수`
 - [X]  **API 명세서 작성하기**
    - [X]  API명세서는 프로젝트 root(최상위) 경로의 `README.md` 에 작성
   
[Postman_spring-schedule-calendar API 명세서](https://documenter.getpostman.com/view/39375040/2sAY55cJwT)

------------
## ERD 📁

### Lv 0. ERD   `필수`   
 - [X]  **ERD 작성하기**
    - [X]  ERD는 프로젝트 root(최상위) 경로의 `README.md` 에 첨부

<img width="788" alt="spring-schedule-calendar ERD  2024-11-14 오후 8 11 17" src="https://github.com/user-attachments/assets/5bfade4b-bdbb-481b-a947-1d04daac2e2d">

  
------------
## SQL 

 ### Lv 0. SQL 작성   `필수` 
 - [X]  **SQL 작성하기**
    - [X]  설치한 데이터베이스(Mysql)에 ERD를 따라 테이블을 생성

 #### 테이블 생성
<img width="573" alt="스크린샷 2024-11-15 오후 8 37 02" src="https://github.com/user-attachments/assets/fc12fb5f-5533-4c58-b05a-9d6efff5d78c">

 #### 유저, 일정 생성
<img width="983" alt="스크린샷 2024-11-15 오후 8 37 32" src="https://github.com/user-attachments/assets/e330fd4b-8f94-4ae2-b0c2-40156ed1573a">

 #### 유저, 일정 조회 (다건, 단건)
<img width="983" alt="스크린샷 2024-11-15 오후 8 37 47" src="https://github.com/user-attachments/assets/990705f3-d3ad-46e2-80d9-d1de36195871">

 #### 유저, 일정 수정
<img width="578" alt="스크린샷 2024-11-15 오후 8 38 02" src="https://github.com/user-attachments/assets/db91620e-5576-450a-b639-472743d957f8">

 #### 유저, 일정 삭제
<img width="319" alt="스크린샷 2024-11-15 오후 8 38 21" src="https://github.com/user-attachments/assets/867f920b-736f-4a82-b6e3-0fc5b7873ad3">

     
---------------
## 기능 구현 🖥
### 개발 전, 공통 조건

- 모든 테이블은 고유 식별자(ID)를 가진다.
- `3 Layer Architecture` 에 따라 각 Layer의 목적에 맞게 개발
- CRUD 필수 기능은 모두 데이터베이스 연결 및 `JPA`를 사용해서 개발
- `JDBC`와 `Spring Security`는 사용하지 않는다.
- 인증/인가 절차는 `Cookie/Session`을 활용하여 개발
- JPA 연관관계는 `단방향`. 정말 필요한 경우에만 `양방향` 적용!
- 키워드
    - CRUD 관련 어노테이션
        - `@Entity`: 데이터베이스 테이블과 매핑되는 클래스에 사용
        - `@Id`: 해당 필드를 기본 키로 지정
        - `@GeneratedValue`: 기본 키 생성 전략을 설정
        - `@Repository`: DAO(Data Access Object) 클래스에 사용하여 데이터 접근을 명시
        - `@ManyToOne`/`@OneToMany`: 테이블간 연간관계를 설정
        - `@JoinColumn` : join할 컬럼을 설정
     
Validation 어노테이션
@Valid
- `@Valid`
    
    | @NotNull | null 불가 |
    | --- | --- |
    | @NotEmpty | null, “” 불가 |
    | @NotBlank | null, “”. “ “ 불가 |
    | @Size | 문자 길이 측정 |
    | @Max | 최대값 |
    | @Min | 최소값 |
    | @Positive | 양수 |
    | @Negative | 음수 |
    | @Email | E-mail 형식 |
    | @Pattern | 정규 표현식 |

     
### Lv 1. 일정 CRUD  `필수`

- [X]  일정을 저장, 조회, 수정, 삭제할 수 있습니다.
- [X]  일정은 아래 필드를 가집니다.
    - [X]  `작성 유저명`, `할일 제목`, `할일 내용`, `작성일`, `수정일` 필드
    - [X]  `작성일`, `수정일` 필드는 `JPA Auditing`을 활용하여 적용합니다.

### Lv 2. 유저 CRUD  `필수`

- [X]  유저를 저장, 조회, 삭제할 수 있습니다.
- [X]  유저는 아래와 같은 필드를 가집니다.
    - [X]  `유저명`, `이메일`, `작성일`, `수정일` 필드
    - [X]  `작성일`, `수정일` 필드는 `JPA Auditing`을 활용하여 적용합니다.
- [X]  연관관계 구현
    - [X]  일정은 이제 `작성 유저명` 필드 대신 `유저 고유 식별자` 필드를 가집니다.

### Lv 3. 회원가입  `필수`

- [X]  유저에 `비밀번호` 필드를 추가합니다.
    - 비밀번호 암호화는 도전 기능에서 수행합니다.

### Lv 4. 로그인(인증)  `필수`

- 키워드
    
    **인터페이스**
    
    - HttpServletRequest / HttpServletResponse : 각 HTTP 요청에서 주고받는 값들을 담고 있습니다.
- **설명**
    - [X]  **Cookie/Session**을 활용해 로그인 기능을 구현합니다. → `2주차 Servlet Filter`
    - [X]  필터를 활용해 인증 처리를 할 수 있습니다.
    - [ ]  `@Configuration` 을 활용해 필터를 등록할 수 있습니다.
- **조건**
    - [X]  `이메일`과 `비밀번호`를 활용해 로그인 기능을 구현합니다.
    - [X]  회원가입, 로그인 요청은 인증 처리에서 제외합니다.
- **예외처리**
    - [X]  로그인 시 이메일과 비밀번호가 일치하지 않을 경우 401을 반환합니다.

------------
## 트러블 슈팅 🎯
[일정 관리 앱 서버 DEVELOP 트러블 슈팅](https://sooyeoneo.tistory.com/67)
