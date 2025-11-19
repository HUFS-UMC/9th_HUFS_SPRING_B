## 📌 작업 내용
- 리뷰 조회 및 생성 API의 응답 통일 및 서비스 구조 리팩토링

- ReviewController에서 ApiResponse 통합 적용
  → 모든 응답을 onSuccess(), onFailure() 형태로 일관 처리

- ReviewQueryService, ReviewCommandService로 서비스 계층 분리
  → 조회(READ)와 생성/수정/삭제(WRITE) 책임 분리

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

| 클래스명                                      | 패키지 경로                          | 기능         | 설명                                                                                        |
| ----------------------------------------- | ------------------------------- | ---------- | ----------------------------------------------------------------------------------------- |
| **ReviewController**                      | `domain.review.controller`      | API 컨트롤러   | `/api/reviews/search` (조회), `/api/reviews/create` (생성) 요청 처리. 모든 응답은 `ApiResponse` 형태로 통일 |
| **ReviewQueryService**                    | `domain.review.service.query`   | 인터페이스      | 리뷰 조회 관련 비즈니스 로직 정의 (GET 요청 전용)                                                           |
| **ReviewQueryServiceImpl**                | `domain.review.service.query`   | 구현체        | `ReviewRepository`를 호출해 조건별 리뷰 조회 후 `ReviewResponse` DTO로 변환                              |
| **ReviewCommandService**                  | `domain.review.service.command` | 인터페이스      | 리뷰 생성/수정/삭제 등 변경성 작업 정의 (POST/PUT/DELETE 전용)                                              |
| **ReviewCommandServiceImpl**              | `domain.review.service.command` | 구현체        | 사용자·가게 정보를 조회 후 `Review` 엔티티를 생성하여 저장                                                     |
| **ApiResponse**                           | `global.apiPayload`             | 응답 포맷 클래스  | 모든 API 응답을 성공/실패 구조로 통일 (`onSuccess`, `onFailure` 메서드 제공)                                 |
| **GeneralExceptionAdvice**                | `global.apiPayload.handler`     | 전역 예외 처리   | `MissingServletRequestParameterException`, `GeneralException` 등을 처리하여 일관된 실패 응답 반환        |
| **GeneralSuccessCode / GeneralErrorCode** | `global.apiPayload.code`        | 응답 코드 Enum | 공통 성공/에러 코드 정의, 컨트롤러 응답에 사용됨                                                              |

