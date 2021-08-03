package com.msp.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass  // JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들(createdDate, modifiedDate)도 컬럼으로 인식하도록 함.
@EntityListeners(AuditingEntityListener.class)  // BaseTimeEntity에 Auditing 기능을 포함시킴.
public abstract class BaseTimeEntity {

    @CreatedDate    // Entity가 생성되어 저장될 때 자동으로 시간 저장.
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 Entity 값을 변경할 때 시간 자동 저장.
    private LocalDateTime modifiedDate;

}
