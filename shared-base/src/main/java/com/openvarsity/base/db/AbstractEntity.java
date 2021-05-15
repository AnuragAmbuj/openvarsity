package com.openvarsity.base.db;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@EntityListeners({  AuditingEntityListener.class })
@MappedSuperclass
@AllArgsConstructor
@SuppressWarnings("serial")
@EqualsAndHashCode(of = { "id" })
@NoArgsConstructor
@SuperBuilder
//@Audited
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @CreatedDate
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updatedAt;

    @CreatedBy
    @Column(name = "created_by", nullable = true)
    protected String createdBy;

    @LastModifiedBy
    @Column(name = "updated_by", nullable = true)
    protected String updatedBy;

    @Column(name = "published", columnDefinition = "bit(1) default 1")
    protected Boolean published = true;

    @Column(name = "deleted", columnDefinition = "bit(1) default 0")
    protected Boolean deleted = false;
}
