
## 🪄 작업 내용
- 도메인별 Repository / DTO / Service 분리 구현
- DTO 설계 및 응답 구조 분리
  - UserPointResponse, MissionListResponse, UserMissionResponse 작성
- JPQL 기반 동적 쿼리 구현
  - 유저별 포인트 합계 조회 (findUserPointInfo)
  - 지역 기반 미션 목록 조회 (findMissionsByRegion)
  - 유저별 진행 미션 페이징 조회 (findUserMissions)

### ⚙️ 구현 구조
| 클래스명                  | 패키지 위치                   | 기능                     | 설명                                                                                   |
| --------------------- | ------------------------ | ---------------------- | ------------------------------------------------------------------------------------ |
| **UserRepository**    | `domain.user.repository` | JPQL 기반 유저 + 포인트 내역 조회 | `findUserPointInfo(Long userId)` 메서드를 통해 `user`와 `point_history` 테이블을 조인하여 총 포인트를 계산 |
| **UserPointResponse** | `domain.user.dto`        | 응답 DTO                 | `name`, `email`, `phoneNumber`, `totalPoint` 필드를 포함하며, 유저 포인트 요약 정보를 반환              |
| **UserQueryService**  | `domain.user.service`    | 서비스 계층                 | Repository를 호출하여 비즈니스 로직 내에서 포인트 합산 정보를 가공 및 반환                                      |
| MissionRepository | domain.mission.repository | 지역 기반 미션 조회 JPQL | findMissionsByRegion(String regionName, Pageable pageable) 메서드로 지역별 미션 리스트를 페이징 형태로 조회 |
| MissionListResponse | domain.mission.dto | 응답 DTO | missionId, title, rewardPoint, storeName, address 필드를 포함하며 홈 화면의 미션 목록에 사용 |
| MissionService | domain.mission.service | 서비스 계층 | 지역 기반 미션 리스트를 조회하고, 홈화면이나 미션 페이지에 전달하는 역할 수행 |
| UserMissionRepository | domain.mission.repository | 유저별 미션 조회 JPQL | findUserMissions(Long userId, Pageable pageable) 메서드로 유저가 수행한 미션 내역을 페이징 형태로 조회 |
| UserMissionResponse | domain.mission.dto | 응답 DTO | price, point, storeName 필드를 포함하며, “내 미션 목록” 화면에 표시되는 정보를 구성 |
| MissionService | domain.mission.service | 서비스 계층 | 유저 미션 목록, 상태 필터링 등 미션 관련 비즈니스 로직 관리 |
| ReviewRepository | domain.review.repository | 리뷰 데이터 저장 (INSERT) | JpaRepository<Review, Long> 상속받아 save() 호출 시 자동으로 INSERT 쿼리 실행 |
| ReviewService | domain.review.service | 리뷰 작성 로직 | User, Store를 조회 후 Review 객체를 생성하고 저장하는 책임 수행 |
| StoreRepository | domain.store.repository | 가게 조회용 기본 레포지토리 | JpaRepository<Store, Long>을 상속받아 가게 데이터를 조회할 때 사용 |


| 방법                 | 설명                               | 특징                |
| ------------------ | -------------------------------- | ----------------- |
| **Fetch Join**     | `join fetch`로 한 번에 연관 데이터까지 가져오기 | 페이징 불가, 데이터 중복 가능 |
| **EntityGraph**    | `@EntityGraph`로 패치 전략 지정         | 쿼리 메서드와 함께 사용 가능  |
| **BatchSize 설정**   | 한 번에 가져올 연관 객체 수 제한              | 대규모 데이터에서 효율적     |
| **DTO Projection** | 필요한 데이터만 DTO로 매핑                 | API 응답 전용에 적합     |
