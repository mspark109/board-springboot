package com.msp.domain.posts;

import com.msp.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter // 롬복 꺼
@NoArgsConstructor // 롬복 꺼
@Entity  // JPA 꺼
public class Posts extends BaseTimeEntity {

    @Id  // 테이블의 PK 필드.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK생성 규칙을 나타냄. 우측에 해당 옵션을 추가해야만 자동 증가가 됨.
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
