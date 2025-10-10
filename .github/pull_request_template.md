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

2. 도메인 엔티티 설계

- User 도메인
    - User: 기본 회원 정보 관리
    - PreferredFood: 사용자-음식 선호 관계
    - Food: 음식명 관리
    - UserMission: 사용자 미션 진행 내역 (N:1, 상태 Enum 관리)
    - UserStatus enum 추가
- Mission 도메인
  - Mission: 가게별 미션 정보 관리
  - MissionStatus: 미션 상태 Enum
  - 
- point 도메인
  - Mission, Review, Store 모두에서 포인트가 발생하므로 별도의 point 도메인으로 분리
  - PointHistory 엔티티 생성(amountPoint, content, changeType)
  - 연관관계: User (N:1), Store (N:1)
- Store 도메인
  - 속성: name, address, latitude, longitude
  - PointHistory -> Store 단방향 참조로 단순화
- review 도메인
    - erd 수정(리뷰 답변은 사장님만 작성가능)
    - entity 구성: Review, ReviewImage, ReviewAnswer
    - 모든 관계 단방향 설계(Store – PointHistory, Review – ReviewImage, Review – ReviewAnswer 모두 1:N)
  


## 💡 과제 피드백 Suggestion
1. @JoinColumn? 
   - 이 필드를 외래키로 만들고, 어떤 컬럼과 연결할지 지정하는 어노테이션
   - 사실 JPA는 기본 규칙에 따라 자동으로 외래 키 이름을 만들어버린다고 함.
    예를 들어 store 필드면 → 자동으로 store_id라고 생성됨
   - 그래서 생략은 가능하지만 협업과, DB DDL 생성 시 일관성 유지를 위해 사용

2.@Builder / @Builder.Default 관련
    - 이번 과제를 진행하면서 @Builder를 사용할 때, 컬렉션(List, Set 등) 필드가 초기화되지 않는 문제를 경험.  
@Builder는 기본값 초기화를 무시하기 때문에, new ArrayList<>()로 직접 초기화한 필드가 null로 생성되는 경우가 있음
@Builder.Default를 사용하여 해결
- 
- 과제 풀이/코드 관련 피드백이나 배운 점을 적어주세요.
- 필요하다면 스크린샷을 첨부해주세요.

## 🔗 관련 이슈
1. ERD review_answer 
    Q. review_answer와 user를 N:1 관계로 연결이 맞을까?
    A. 둘다 리뷰 답변이 가능 하도록 하려면 이렇게가 맞을 수 있으나 너무 복잡도가 높음
       사장님만 답변이 가능한 설계로 하여 ERD 수정
- Close #이슈번호
- (연결된 이슈가 없으면 'N/A'라고 적어주세요.)
