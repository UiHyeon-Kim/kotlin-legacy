# Legacy

## refactoring list
### CustomerLegacy class
- [ ] data class 로 변경
- [ ] id, name 을 value class 로 바꿔보기
- [ ] status 를 enum 클래스 타입으로 변경
  - [ ] CustomerState
  - [ ] ACTIVE, DORMANT 등

### CustomerService class
- [ ] 변수 및 함수 private 캡슐화
- [ ] 고객 수정 Delegates.observable 사용해보기

### Common
- [ ] 명확한 이름으로 변경
- [ ] 패키지 및 기능 분리
- [ ] 하드 코딩 상수화