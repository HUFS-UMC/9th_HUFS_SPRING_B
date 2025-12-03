
## 📌 작업 내용

- @ValidPage 커스텀 Validation 어노테이션 구현

    - PageValidator 연동, 페이지 번호(1 이상) 검증

    - GlobalExceptionHandler에서 Validation 예외 자동 처리

- 미션 관련 API 3개 구현

    - GET /stores/{storeId}/missions — 특정 가게의 미션 목록 조회 (최신순, 10개 페이징)

    - GET /users/{userId}/missions/in-progress — 내가 진행 중인 미션 조회 (IN_PROGRESS 필터링, 페이징)

    - PATCH /users/{userId}/missions/{userMissionId}/complete — 미션 완료 처리(상태 COMPLETED & 완료 시간 업데이트)
    - 내가 작성한 리뷰 목록
- 리뷰 API 개선

    - 리뷰 응답에 ownerReply(사장님 답글) 필드 추가

    - OwnerReply → Reply로 통합해 중복 제거

    - 사장님 댓글 조건: UserRole.OWNER + parent == null

- 페이징 처리 개선

    - 프론트는 1-based, 백엔드는 0-based로 통일된 변환 처리

    - ReviewSearchRequest, MissionPageRequest에 @ValidPage 적용

- Swagger 문서화 강화

    - @Operation, @ApiResponses 작성

    - 요청/응답 스펙 및 상태 코드 명세 추가

- 코드 리팩터링

    - ReviewServiceImpl 반복문 → Stream API 변환

    - Converter 계층에도 Stream API 적용

    - DTO Builder 패턴 일관성 유지

## 💡 배운 점 / 느낀 점

- 커스텀 Validation을 통해 재사용 가능한 입력 검증 구조를 설계할 수 있었다.

- 페이징 1-based ↔ 0-based 변환을 API 전반에서 일관되게 처리하는 것이 중요함을 이해했다.

- DTO 구조는 중복을 줄이는 방향이 유지보수성과 확장성을 높인다는 점을 경험했다.

- Stream API를 적용해 코드 가독성과 선언적 스타일의 장점을 체감했다.
