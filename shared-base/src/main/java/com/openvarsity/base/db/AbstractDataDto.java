package com.openvarsity.base.db;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@ToString
@SuperBuilder
@AllArgsConstructor
@EqualsAndHashCode(of = { "id" })
public abstract class AbstractDataDto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    protected Long id;
    protected Date createdAt;
    protected Date updatedAt;
    protected String createdBy;
    protected String updatedBy;
    protected boolean deleted;
    protected boolean published;
}