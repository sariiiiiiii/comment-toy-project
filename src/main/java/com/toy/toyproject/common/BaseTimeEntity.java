package com.toy.toyproject.common;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    /**
     * @MappedSuperclass
     *  - Jpa Entity 클래스들이 BaseTimeEntity 를 상속할 경우 필드들(createDate, modifiedDate) 도 컬럼으로 인식함
     * @EntityListeners(AuditingEntityListener.class)
     *  - BaseTimeEntity 클래스에 Auditing 기능을 포함시킴
     * @CreatedDate
     *  - Entity 가 생성되어 저장될 때 시간이 자동 저장
     * @LastModifiedDate
     *  - 조회한 Entity 의 값을 변경할 때 시간이 자동 저장
     */

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;


}
