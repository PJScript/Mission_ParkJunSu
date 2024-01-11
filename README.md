# Mission_ParkJunSu


## 프로젝트 설명
익명 게시판 프로젝트 입니다. 

<br />

### 홈 화면
> 자유게시판, 개발게시판, 일상게시판, 사건사고게시판, 전체게시판
> 
![스크린샷 2024-01-11 오전 10.40.13.png](readMeImages%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-01-11%20%EC%98%A4%EC%A0%84%2010.40.13.png)
![스크린샷 2024-01-11 오전 10.42.18.png](readMeImages%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-01-11%20%EC%98%A4%EC%A0%84%2010.42.18.png)

- 게시판의 신규 생성 및 관리를 위해 각 게시판은 category 라는 테이블에서 관리합니다.
- 게시판 삭제시 그 게시판과 관련된 사이드 이펙트가 발생 할 수 있어서 **is_deleted** 라는 컬럼으로 **논리적 삭제**를 처리하고 있습니다.
- sort_order 컬럼으로 게시판의 정렬순서를 바꿀 수 있도록 설계해두었습니다. ( 현재 화면단에서는 해당 컬럼을 참조하지 않고 그대로 보여주고 있습니다 )
- label 이라는 컬럼으로 유저에게 실제 보여질 이름을 지정할 수 있습니다. 
- value 라는 컬럼으로 url에 추가할 값 혹은 내부적으로 사용할 카테고리의 고유 값을 지정해두었습니다.
 
<br />

### 게시글 목록 화면
> 나중에 쓴 글이 최상단으로 올라오도록 sql문에 조건을 걸어두었습니다.
> 
![스크린샷 2024-01-11 오전 10.45.31.png](readMeImages%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-01-11%20%EC%98%A4%EC%A0%84%2010.45.31.png)
![스크린샷 2024-01-11 오전 10.45.55.png](readMeImages%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-01-11%20%EC%98%A4%EC%A0%84%2010.45.55.png)

- **category_id** 컬럼으로 어떤 게시판에 쓰여진 글인지 구분하고 있습니다.
- 게시글에 비밀번호 컬럼을 두어 추후 삭제 및 수정이 가능하도록 해두었습니다.
- 게시글을 물리적으로 삭제하면 그와 연관있는 댓글 혹은 이미지들이 게시글을 참조하지 못하는 문제가 있어서 에러가 발생 할 수 있습니다. 이를 **is_deleted** 컬럼을 두어 논리적으로 삭제할 수 있도록 설계 했습니다.
- 글쓰기 버튼 클릭 -> 글쓰기 화면
- 게시판 목록 버튼 클릭 -> 홈 ( 게시판 목록이 보이는 화면 )

**추가**: db 이미지를 보면 비밀번호가 그대로 노출되고 있는데 리팩토링 할때 비밀번호를 암호화 해서 저장하도록 수정 할 계획 입니다.

<br />

### 게시글 보기 화면
> 게시판 이름, 게시글의 제목, 게시글의 본문, 작성일 등을 표시합니다. 수정 및 삭제, 댓글 작성 및 삭제 모두 해당 페이지에서 할 수 있습니다.
> 
![스크린샷 2024-01-11 오전 10.46.39.png](readMeImages%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-01-11%20%EC%98%A4%EC%A0%84%2010.46.39.png)
- 어떤 게시판에 쓰여진 글인지 확인 할 수 있도록 구현했습니다.
- 상단 오른쪽에 게시판 목록, 글 목록으로 이동할 수 있는 편의기능을 구현했습니다.
- 댓글 작성시 닉네임을 입력할 수 있도록 구현했습니다.
- 수정과 삭제 (게시글 댓글) 버튼 클릭 시 비밀번호 입력 화면으로 이동합니다.

<br />

### 비밀번호 입력 화면
> 게시글 화면에서 수정, 삭제 버튼 클릭 시 아래 화면으로 이동합니다. 게시글 삭제인지 댓글 삭제인지 등 어떤 작업인지 판별하는 작업은 url로 처리합니다.
> 비밀번호가 같으면 게시글을 삭제하고 해당 해당 게시글이 있던 게시판으로 다시 이동합니다. 
> 

![스크린샷 2024-01-11 오전 10.47.18.png](readMeImages%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-01-11%20%EC%98%A4%EC%A0%84%2010.47.18.png)

<br />

![스크린샷 2024-01-11 오전 10.48.02.png](readMeImages%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-01-11%20%EC%98%A4%EC%A0%84%2010.48.02.png)

게시글 삭제 버튼 클릭시 비밀번호 체크 화면으로 이동시켜주는 `controller` 입니다.
게시글의 고유 `id` 값을 받고 이를 전달 해줍니다.

<br />

![스크린샷 2024-01-11 오전 10.48.46.png](readMeImages%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-01-11%20%EC%98%A4%EC%A0%84%2010.48.46.png)
이후 비밀번호 체크 화면단에서는 `submit` 버튼 클릭시 `form` 태그를 통해 실제 삭제 요청을 전송합니다. 이때 위에서 전달받은 `id`를 포함하여 전송합니다.

<br />

![스크린샷 2024-01-11 오전 10.49.36.png](readMeImages%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-01-11%20%EC%98%A4%EC%A0%84%2010.49.36.png)
조금전 보낸 요청은 위 사진의 컨트롤러에서 받아서 삭제 처리를 합니다. 해당 컨트롤러에서는 `articleService.articlePasswordCheck`를 호출하여 비밀번호 체크를 하고 있습니다.

<br />

![스크린샷 2024-01-11 오전 10.50.23.png](readMeImages%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-01-11%20%EC%98%A4%EC%A0%84%2010.50.23.png)
`articleService` 에는 조금전 호출한 메서드가 구현되어 있습니다. 인자로 받을 값이 변경 될 가능성을 염두해 `ArticleDto.ArticlePasswordCheckRequest` 라는 공통 dto 사용하고 있습니다.

<br />

![스크린샷 2024-01-11 오전 10.50.55.png](readMeImages%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-01-11%20%EC%98%A4%EC%A0%84%2010.50.55.png)
비밀번호 확인 결과 입력값이 다를때는 `false`를 리턴하고 controller 에서는 이 값을 토대로 비밀번호 에러 페이지로 이동시킵니다.

<br />

### Service
<details>
  <summary> 게시판 기능 </summary>

- 게시판은 같은 주제의 게시글을 모아둔 단위를 의미한다.
- 게시판의 목록과, 선택된 게시판의 게시글 목록을 볼 수 있는 화면이 필요하다.
    - 게시판 목록의 링크를 선택하면, 해당 게시판에 작성된 게시글 제목만 목록으로 출력되는 화면으로 이동한다.
    - 또한 전체 게시글을 위한 전체 게시판이 존재한다.
    - 게시글 제목은 링크로, 해당 게시글의 정보를 전부 조회할 수 있는 페이지로 이동된다.
    - 조회되는 게시글들은 항상 나중에 작성된 게시글이 최상단에 작성된다.
- 자유 게시판, 개발 게시판, 일상 게시판, 사건사고 게시판이 존재한다.
</details>


<details>
  <summary> 게시글 기능</summary>

- 게시글은 하나의 주제에 대한 의견을 교환하기 위한 글을 의미한다.
    - 제목, 내용으로 구성되어 있다.
    - 게시글이 작성되는 게시판이 존재한다.
- 게시글을 작성할 수 있다.
    - 게시글을 작성하는 페이지가 필요하다.
    - 게시글을 작성하는 페이지에서 어떤 게시판에 작성할지를 선택 가능하다.
    - 게시글의 제목과 내용을 작성한다.
    - 게시글의 내용 자체는 Plain Text로만 구성된다.
    - 게시글을 작성할때는 작성자가 자신임을 증명할 수 있는 비밀번호를 추가해서 작성한다.
- 게시글 단일 조회 화면이 필요하다.
    - 댓글과 관련된 기능은 이 화면에 포함된다.
        - 댓글 목록
        - 댓글 추가하기
        - 댓글 삭제하기
    - 게시글 삭제를 위한 UI가 여기 존재한다.
- 게시글을 수정할 수 있다.
    - 게시글을 수정하는 페이지가 필요하다.
    - 게시글을 수정하는 페이지에는, 게시글의 본래 제목, 글이 존재한다.
    - 게시글 수정을 위해 비밀번호를 제출할 수 있어야 한다.
        - 이 비밀번호가 게시글 작성 당시의 비밀번호와 일치해야 실제로 수정이 이뤄진다.
        - 게시글을 삭제할 수 있다.
    - 단일 게시글 조회 페이지에 있는 삭제를 위한 UI를 이용해 삭제한다.
    - 게시글 삭제를 위해 비밀번호를 제출할 수 있어야 한다.
        - 이 비밀번호가 게시글 작성 당시의 비밀번호와 일치해야 실제로 삭제가 이뤄진다.
</details>

<details>
  <summary> 댓글 기능</summary>

- 댓글을 작성할 수 있다.
    - 댓글의 작성은 게시글 단일 조회 페이지에서 이뤄진다.
    - 댓글을 작성할때는 작성자가 자신임을 증명할 수 있는 비밀번호를 추가해서 작성한다.
- 댓글의 목록은 게시글 단일 조회 페이지에서 확인이 가능하다.
- 댓글의 삭제는 게시글 단일 조회 페이지에서 가능하다.
    - 댓글 삭제를 하기 위한 UI가 존재해야 한다.
    - 댓글 삭제를 위해 비밀번호를 제출할 수 있어야 한다.
        - 이 비밀번호가 댓글 작성 당시의 비밀번호와 일치해야 실제로 삭제가 이뤄진다.
</details>


<details>
  <summary> 도전 과제 </summary>


### 1. 해시태그 기능

- 게시글을 작성할때, 사용자가 입력한 내용을 바탕으로 해시태그를 추출한다.
    - 해시태그는 사용자가 작성한 내용 중, `#` 으로 시작하는 단어를 의미한다.
- 특정 해시태그를 가진 게시글 목록을 볼수 있는 화면이 필요하다.
- 게시글 단일 조회 페이지의 내용 뒤쪽에 사용된 해시태그 목록이 표기된다.
    - 링크로서 동작하며, 클릭시 해당 해시태그가 포함된 게시글 목록을 보는 화면으로 이동된다.
    

### 2. 검색 기능

- 게시글 목록을 확인할 수 있는 페이지에, 검색을 위한 UI가 추가된다.
    - 사용자가 검색어를 입력해서 검색을 할 수 있다.
- 검색을 하면서 검색 기준을 선택할 수 있다.
    - 제목
    - 내용
- 개별 게시판이 선택된 상태론 해당 게시판 내에서, 전체 게시판이 선택된 상태론 전체 게시글 중 검색한다.

### 3. 게시글 추가 기능

- 게시글이 작성된 이후 게시글에 이미지를 추가할 수 있다.
    - 게시글 단일 조회 페이지에서 이미지 추가 버튼을 통해 추가한다. 추가할땐 게시글을 작성하면서 전달한 비밀번호를 같이 전달해야 한다.
    - 추가된 이미지는 제목 이후 내용 이전에 추가된 순서대로 배치된다.
- 개별 이미지를 삭제할수 있다. 삭제할땐 게시글을 작성하면서 전달한 비밀번호를 같이 전달해야 한다.
- 게시글 단일 조회 페이지에 이전글 다음글 기능이 추가된다.
    - 이전글 링크를 클릭하면 같은 게시판의 게시글 중, 현재 게시글보다 나중에 작성된 게시글 중 가장 일직 작성된 게시글 단일 조회 페이지로 이동한다.
    - 다음글 링크를 클릭하면 같은 게시판의 게시글 중, 현재 게시글보다 먼저 작성된 게시글 중 가장 늦게 작성된 게시글 단일 조회 페이지로 이동한다.
    - 전체 게시판에서 게시글을 조회하는 경우, 게시판 구분 없이 동일한 기준으로 동작한다.
</details>

## TODO

 - [x] 게시판 목록 페이지
 - [x] 특정 게시판의 게시글 목록 페이지
 - [x] 게시글 작성 페이지
 - [x] 게시글 수정 페이지
 - [x] 게시글 단일 조회 페이지 ( 댓글 보기, 추가, 삭제는 이 페이지에 )

 - [x] 게시글 작성 기능 구현
 - [x] 게시글 수정 기능 구현
 - [x] 게시글 삭제 기능 구현
 - [x] 댓글 작성 기능 구현
 - [x] 댓글 삭제 기능 구현

 - [ ] 해시태그 (도전과제)
 - [ ] 검색기능 (도전과제)
 - [ ] 게시글에 이미지 추가 (도전과제)

## 커밋 규칙
```<type>(<scope>): <subject>```

예시) feat(auth): add login feature



- feat : 새로운 기능 추가
- fix : 버그 수정
- docs : 문서 변경
- style : 코드 스타일 변경 ( 포매팅 )
- refactor : 리팩토링
- test : 테스트 코드 추가, 수정
- chore : 빌드, 툴 설정등 기타 작업



## 시작하기

```sh
git clone https://github.com/PJScript/Mission_ParkJunSu.git
```





## 문제 발생 및 해결과정

