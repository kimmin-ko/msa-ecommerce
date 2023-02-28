## ORDER-SERVICE

### 사용 기술
- Kotlin 1.6.21
- Spring Boot 2.7.7
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
    │   │           └── orderservice
    │   │               ├── common
    │   │               │   ├── entity
    │   │               │   └── response
    │   │               ├── config
    │   │               ├── domain
    │   │               │   └── order
    │   │               │       ├── converter
    │   │               │       └── dto
    │   │               │           ├── service
    │   │               │           └── web
    │   │               ├── erorrs
    │   │               │   └── exceptions
    │   │               ├── filter
    │   │               ├── properties
    │   │               └── util
    │   └── resources
    └── test
```

domain
- 비즈니스 로직 구현에 필요한 도메인 모델