## 📝 작업 내용 요약


- 특정 가게에 리뷰 추가 API 구현
  → 유저/가게 조회 후 Review 생성, ApiResponse 통일 적용
- 특정 가게에 미션 추가 API 구현
  → StoreId로 가게 조회 후 Mission 생성, DTO 및 응답 구조 정리
- 유저가 특정 미션에 도전하기 API 구현
  → Mission & User 조회 후 UserMission 생성, 중복 도전 방지 로직 포함
- Query/Command 서비스 분리 적용
  → 리뷰 조회/생성 구조를 CQRS 스타일로 리팩토링
- Controller 의존성 개선
  → ServiceImpl 직접 참조 제거, 인터페이스 기반 구조로 변경하여 확장성 향상

## 💡 과제 피드백 & 배운 점
- 기존 컨트롤러가 ServiceImpl에 직접 의존하고 있어 확장성 저하 문제가 있었음
  → 인터페이스 계층을 도입하여 유연한 구조로 개선

- Query / Command 분리 원칙을 적용하면서, 서비스 단의 역할이 명확해짐
  → “읽기/쓰기 책임 분리 (CQRS)” 개념을 실무적으로 이해

- RestControllerAdvice를 통한 전역 예외 처리 통합의 이점을 체감
  → 예외 발생 시에도 응답 구조가 일관되어 프론트엔드 협업 시 디버깅이 용이해짐

- ApiResponse 구조가 팀 내 표준화된 응답 규격 역할을 하여
  → 성공/실패 여부, 코드, 메시지, 결과를 한눈에 파악할 수 있음

## 🔗 구현구조
| 클래스명                                                  | 패키지 경로                          | 역할                           |
| ----------------------------------------------------- | ------------------------------- | ---------------------------- |
| **ReviewController**                                  | `domain.review.controller`      | 리뷰 조회/생성 API 엔드포인트 제공        |
| **ReviewQueryService**                                | `domain.review.service.query`   | 리뷰 조회 인터페이스                  |
| **ReviewQueryServiceImpl**                            | `domain.review.service.query`   | 리뷰 조회 로직 구현체                 |
| **ReviewCommandService**                              | `domain.review.service.command` | 리뷰 생성/수정/삭제 인터페이스            |
| **ReviewCommandServiceImpl**                          | `domain.review.service.command` | 리뷰 생성 로직 구현체                 |
| **MissionController**                                 | `domain.mission.controller`     | 미션 생성/도전 API 엔드포인트 제공        |
| **MissionService**                                    | `domain.mission.service`        | 미션 생성/도전 인터페이스               |
| **MissionServiceImpl**                                | `domain.mission.service`        | 미션 생성 및 UserMission 생성 로직 구현 |
| **UserMissionResponse / UserMissionChallengeRequest** | `domain.mission.dto`            | 미션 도전 요청 및 응답 DTO            |
| **ApiResponse**                                       | `global.apiPayload`             | 성공/실패 응답 포맷 표준화              |
| **GeneralExceptionAdvice**                            | `global.apiPayload.handler`     | 전역 예외 처리 담당                  |
