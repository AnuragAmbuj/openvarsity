package com.openvarsity.authservice.entity;

import com.openvarsity.base.db.AbstractEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "permission")
@Data
public class Permission extends AbstractEntity {

    @Column(name = "name")
    private String name;
}
