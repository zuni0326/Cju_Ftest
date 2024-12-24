# 시간표 관리 프로그램

## 프로젝트 소개
내가 수강하고 있는 과목의 시간표, 해당 과목의 공지사항, 수강하고 있는 과목의 학생 게시판 등을 제공하여 내 학교생활 스케쥴 관리에 도움을 주는 프로그램입니다

---

## 주요 기능(설계 단계)

### 1. 로그인 화면
- 학번, 비밀번호 입력하여 로그인
- 성공 시 해당 사용자의 이름, 학년, 수강 과목 정보, 총 학점 정보를 불러옵니다
- 실패 시 에러 메시지를 출력하고 다시 시도합니다

---

### 2. 메뉴 화면
로그인 성공 시 다음 메뉴 버튼 화면으로 이동합니다
1. **시간표 보기**
2. **공지사항**
3. **학생 게시판**

- 각 메뉴 화면에서 돌아가기 버튼으로 다시 메뉴 화면으로 돌아올 수 있습니다

---

### 3. 시간표 보기
- 사용자의 수강 과목을 시간표 형태로 요일과 시간별로 정리하여 표시합니다

---

### 4. 공지사항
- 내가 수강 중인 과목에 등록된 메모(예: 과제, 시험, 휴강 등)를 확인 할 수 있습니다
- 공지사항 화면에서는 과목별 메모의 제목을 출력합니다
- 메모의 "보기" 버튼을 클릭하면 메모의 상세 내용을 확인할 수 있습니다
- "돌아가기" 버튼을 통해 전체 메모 목록 화면으로 이동 가능합니다

---

### 5. 학생 게시판
- 내가 수강 중인 과목마다 별도의 게시판을 제공합니다.
- 게시판 기능으로는
  1. 다른 사용자의 게시글 보기.
  2. 새로운 게시글 작성 및 등록.
  3. 게시글 추천 기능 (한 사용자는 동일 게시글을 한 번만 추천 가능).
  4. 자신이 작성한 게시글 삭제 가능.
- "돌아가기" 버튼을 통해 게시판 선택 화면으로 이동 가능합니다.

---

## 실행 흐름
1. 프로그램 실행 → 로그인 화면
2. 로그인 성공 → 메뉴 화면
3. 메뉴 버튼 클릭 → 각 화면으로 이동
   - 시간표 보기
   - 공지사항
   - 학생 게시판
4. 각 화면에서 "돌아가기" 버튼 클릭 → 메뉴 화면

---

## 개발 환경 및 도구
- **언어**: Java
- **IDE**: Eclipse
- **UI**: Java Swing
