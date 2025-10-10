## 🪄 작업 내용
- 이번 PR에서 구현한/수정한 내용을 간단히 적어주세요.
- 지금까지는 주니어 미션만함

1. 프로젝트 초기 설정
- Gradle 의존성 추가: JPA, H2, Mysql, lombok
- application.yml 설정:
    - application.yml에서는 MySQL 연결 정보를 관리(예전 실습)
    - application-test.yml에서는 H2 인메모리 DB를 사용
    - JPA 자동 설정 및 SQL 로깅 활성화
- 도메인 폴더 구조 설계: user, mission, review, stroe
- BaseEntity 설계:
    - createdAt, updatedAt, deletedAt 공통으로 관리
    - @CreatedDate, @LastModifiedDate를 활용하여 자동으로 기록
    - deletedAt 필드를 추가하여 Soft Delete 구조도 구성

## 💡 과제 피드백 Suggestion
- 과제 풀이/코드 관련 피드백이나 배운 점을 적어주세요.
- 필요하다면 스크린샷을 첨부해주세요.

## 🔗 관련 이슈
- Close #이슈번호
- (연결된 이슈가 없으면 'N/A'라고 적어주세요.)
