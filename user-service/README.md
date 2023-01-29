## USER-SERVICE

### 사용 기술
- Kotlin 1.6.21
- Spring Boot 2.7.7
- Spring Security 5.7.6
- Spring Cloud 2021.0.5
- Spring Data JPA 2.7.6
- Hibernate 5.6.14
- QueryDSL 5.0.0
- H2 Database 1.4.200

### 패키지 구조
```bash
└── src
    ├── main
    │   ├── kotlin
    │   │   └── com
    │   │       └── tme
    │   │           └── userservice
    │   │               ├── adapters
    │   │               │   ├── in
    │   │               │   │   └── web
    │   │               │   │       ├── converter
    │   │               │   │       └── dto
    │   │               │   └── out
    │   │               │       └── persistence
    │   │               │           ├── converter
    │   │               │           ├── entity
    │   │               │           └── repository
    │   │               ├── application
    │   │               │   ├── converter
    │   │               │   ├── dto
    │   │               │   ├── port
    │   │               │   │   ├── in
    │   │               │   │   └── out
    │   │               │   └── service
    │   │               ├── config
    │   │               ├── domain
    │   │               ├── erorrs
    │   │               │   └── exceptions
    │   │               ├── filter
    │   │               ├── properties
    │   │               ├── security
    │   │               └── util
    │   └── resources
    └── test
```

adapters
- 인바운드 어댑터(in)와 아웃바운드 어댑터(out)로 구분한다.
- 인바운드 어댑터: 인바운드 포트를 통해 외부 애플리케이션 또는 서비스와 내부 비즈니스 영역 간 데이터 교환을 조정한다.
- 아웃바운드 어댑터: 아웃바운드 포트를 통해 내부 비즈니스 영역과 외부 애플리케이션 또는 서비스와 데이터 교환을 조정한다.

application
- 내부 비즈니스 영역을 외부에 노출하기 위한 API인 포트를 정의한다.
- 포트는 인바운드 포트와 아웃바운드 포트로 구분한다.
- 인바운드 포트 API를 통해 비즈니스 로직을 구현한 서비스를 포함한다.

domain
- 비즈니스의 핵심인 도메인 모델을 정의한다.