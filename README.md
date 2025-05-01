# 📎 판타지 성탑 육성 시뮬레이션 RPG(팀명: 4K )

## 👀 서비스 소개
* 서비스명: EPIC TOWER QUEST  
* 서비스설명: 턴제 로그라이트 RPG
<br>

## 📅 프로젝트 기간
2025.04.29 ~ 2025.05.02
<br>

## ⭐ 주요 기능
* 기능1 : 회원가입및 로그인 시스템
* 기능2 : 랭킹 시스템
* 기능3 : 강화 시스템 
* 기능4 : 이벤트 시스템
* 기능5 : 전투 시스템
<br>

## ⛏ 기술스택
<table>
    <tr>
        <th>구분</th>
        <th>내용</th>
    </tr>
    <tr>
        <td>사용언어</td>
        <td>
            <img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white"/>
        </td>
    </tr>
    <tr>
        <td>개발도구</td>
        <td>
            <img src="https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=Eclipse&logoColor=white"/>
        </td>
    </tr>
    <tr>
        <td>데이터베이스</td>
        <td>
            <img src="https://img.shields.io/badge/Oracle 11g-F80000?style=for-the-badge&logo=Oracle&logoColor=white"/>
        </td>
    </tr>
    <tr>
        <td>협업도구</td>
        <td>
            <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=white"/>
            <img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white"/>
        </td>
    </tr>
</table>


<br>

## 🎈 깃 허브 사용규칙
1) 풀 사용시간은 자유
2) 개인 작업 분량은 푸시하기 전 날짜 이름으로 폴더 만들고 백업을 보관 후 팀원들에게 먼저 알리기
3) 푸시할 때 파일은 하나씩 (각자 커밋 사용 전 메모 남기기)
4) 커밋 후엔 반드시 깃허브에 들어가 수동으로 파일 업데이트가 반영되었는지 확인
5) 작업 완료 후 팀원들에게 알리기
6) 필요하다면 개인 백업폴더의 메모장에 커밋 내용을 간단히 기록 후 다음날 팀 회의때 한번에 공유하기

## 📌 SW유스케이스
![image](https://github.com/user-attachments/assets/4ed9a747-1109-45c2-8031-80e25460d4cb)
<br>

## 📌 서비스 흐름도
![image](https://github.com/user-attachments/assets/385e1d07-7411-48bc-acd4-4abc2baa1f66)
<br>

## 📌 ER다이어그램
![image](https://github.com/user-attachments/assets/ac9101fd-8398-4fab-9db0-35e69a30a18e)
<br>

## 👨‍👩‍👦‍👦 팀원 역할
<table>
  <tr>      
<td align="center"><img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjEyMDlfMjg0%2FMDAxNjcwNTg5MjIwMTAx.KVN8QUuxbSZe39YyXmvR1EYDWWlJLaMYBuu_w7AkSHsg.5ETAujKgu2U1Pygt3XFfrV8yoRWpoD-tVL5QYIOveX4g.PNG.mikyunge%2F1670585182026.png&type=a340" width="100" height="100"/></td>

<td align="center"><img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2F20160729_20%2Fhklimok_1469777339510RnrXY_PNG%2F%25B1%25D7%25B8%25B28.png&type=a340" width="100" height="100"/></td>

<td align="center"><img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjExMDVfMjIg%2FMDAxNjY3NjU2NzEyMTg4.JaEAsHSunlFdDDenpqDwkllWUgUbwpiOj9wI7zreoo8g.Yb9EVpkjCOGCP_yFNsUgJwhT_Wze9F38Uhr276ppEHcg.PNG.naky1121%2Fimage.png&type=a340" width="100" height="100"/></td>

<td align="center"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnfDzWBgj0v4ucyF-8RzCo0wakd04Xw5To3Q&s" width="100" height="100"/></td>
  </tr>
  <tr>
    <td align="center"><strong>팀장 : 김희광</strong></td>
    <td align="center"><strong>팀원 : 김다원</strong></td>
    <td align="center"><strong>팀원 : 김수연</strong></td>
    <td align="center"><strong>팀원 : 김형진</strong></td>
  </tr>
  <tr>
    <td align="center"><b>DB 설계 및 구축, 아스키아트, PPT</b></td>
    <td align="center"><b>PM</b></td>
    <td align="center"><b>강화 시스템 & 캐릭터 정보 관련</b></td>
    <td align="center"><b>이벤트 기능 구현</b></td>
  </tr>
</table>

## 🤾‍♂️ 트러블슈팅  
* 문제1 <br>
- 오류 코드 : java.sql.SQLException : 인덱스에서 누락된 IN 또는 OUT 매개변수::4
- 원인 : 다른 팀원의 DB에서 COMMIT 을 하지 않아 발생한 오류
- 해결 방안 : 다른 팀원의 DB에서 커밋이 되지 않아 그쪽에서 DB를 점유하고있어 이쪽에서 처리가 되지 않는것이었다.

* 문제2 <br>
- 오류 코드 : java.sql.SQLSyntaxErrorException: ORA-00947: not enough values
- 원인 : user_char_seq.nextval을 value가 아니라 index칸에 넣어서 생긴 문제였다.
- 해결 방안 :  index에 있던 user_char_seq.nextval을 칼럼 인덱스인 seq_num으로 바꾸고
  그에 대한 값으로 values 제일 앞에 user_char_seq.nextval을 추가하여 오류를 잡았다.

* 문제3 <br>
![image](https://github.com/user-attachments/assets/bb323d50-5ec4-4726-8ea2-6507ee691fdb)
- 문제점 : 외래키로 지정된 USER_TABLE의 ID와 START_CHARATER의 CHAR_NAME을 외래키로
  지정하기 위해선 UNIQUE들로 지정해야 되는데 지정이 안되어 있어서 생긴 오류 였다. 
- 해결 방안 : 이미 테이블이 만들어진 USER_TABLE, START_CHARATER에  USER_TABLE의
  ID와 START_CHARATER의 CHAR_NAME을 UNIQUE로 변경하는 제약조건을 걸어 변경하였다.
  <table>
  <tr>
    <td>
    ALTER TABLE USER_TABLE ADD CONSTRAINT SYS C007146 UNIQUE (ID);
    </td>
    <td>
      ALTER TABLE START_CHARATER ADD CONSTRAINT SYS C007147 UNIQUE(CHAR_NAME);
    </td>
  </tr>
  </table>
  
* 문제4 <br>
![image](https://github.com/user-attachments/assets/f323eabd-c2e9-4124-b7a3-1144c653ab9d)
- 오류 원인 : TOP_RANK에는 4개의 컬럼(SEQ NUM, NICKNAME, CHAR NAME, MAX FLOOR)이 있지만 에러가 나온 메시지를 보면
  3개의 컬럼(NICKNAME, CHAR NAME, MAX FLOOR)만 적어서 나온 오류이다.
- 해결 방안: TOP RANK 삽입 시 SEQ NUM도 같이 삽입하여 넣었다. SEQ NUM 삽입시 자동으로 증가하므로 시퀀스를 추가하였고
  값에는 NULL값을 넣어서 실행 하였더니 실행이 정상적으로 되었다.
  
* 문제5 <br>
![image](https://github.com/user-attachments/assets/0b56ef5c-ff8a-42de-8221-b2b5707957c1)
- 오류 원인 : 프로젝트에 ojdbc를 추가하지 않아서 생긴 오류이다.
- 해결 방안 : java의 propertis → Java Build Path(Libraries) → AddExternal JARS 를 클릭하고
  oracle DB의 설치 경로로 가서 OJDBC를 찾아서 클릭 후 추가해준다.

* 문제6 <br>
![image](https://github.com/user-attachments/assets/85daee4b-d9e0-4661-9f9a-e5b4303b3769)
- 오류 원인 : eclipse에서 commit and push가 제대로 수행이 되지 않아서 발생한 오류이다.
- 해결 방안 : 기존 remote를 삭제후 다시생성하고 local을 재설정 해주니 문제가 해결 됨
- 참고 blog : https://m.blog.naver.com/sim4858/220924984480

* 문제7 <br>
![image](https://github.com/user-attachments/assets/e8c903ae-be6e-4380-835d-7a38f3ff2f27)
- 오류 원인 : SQL문의 명령어가 올바르게 종료되지 않아서 발생하였다.
- 해결 방안
<table>
  <tr>
    <td>
    INSERT INTO Start_Charater (CHAR_NAME, CHAR_ATK, CHAR_DEF, PERKS) VALUES
    ('정시우', 18, 12, '시간 지연'),
    ('김하윤', 25, 20, '강철의 힘'),
    ('서이담', 12, 10, '패턴 감지');
    </td>
  </tr>
</table>
