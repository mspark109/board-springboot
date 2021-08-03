package com.msp.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

// 보통 MyBatis 에선 DAO로 불리는 DB Layer 접근자.
// JPA에선 Repository라 부르며 인터페이스로 생성.
// Entity 클래스와 기본 Entity Repository는 함께 위치해야 함. ★★★
// 나중에 프로젝트 규모가 커져 도메인 별로 분리해야 한다면 이때 Entity와 기본Repository는 함께 움직여야 하기 때문에 도메인 패키지에서 관리함.

// 단순히 인터페이스 생성 후, JpaRepository<Entity클래스, PK타입>를 상속하면 기본적인 CRUD 메소드가 자동으로 생성됨.★★★
public interface PostsRepository extends JpaRepository<Posts, Long>{

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")  // SpringDataJpa에서 제공 하지 않는 메소드는 이처럼 쿼리로 작성해도 됨.
    List<Posts> findAllDesc();
}
