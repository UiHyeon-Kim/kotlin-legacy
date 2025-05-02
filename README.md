# Legacy

## refactoring list
### CustomerLegacy class
- [x] data class 로 변경
- [x] id, name 을 value class 로 바꿔보기
- [x] status 를 enum 클래스 타입으로 변경
  - [x] CustomerState
  - [x] ACTIVE, DORMANT 등

### CustomerService class
- [x] 변수 및 함수 private 캡슐화
- [x] 고객 수정 Delegates.observable 사용해보기

### Common
- [x] 명확한 이름으로 변경
- [x] 패키지 및 기능 분리
- [x] 하드 코딩 상수화

## After Refactoring
- MVP 패턴 적용
  - data
    - model
    - repository
  - feature
    - contract
    - presenter
    - view