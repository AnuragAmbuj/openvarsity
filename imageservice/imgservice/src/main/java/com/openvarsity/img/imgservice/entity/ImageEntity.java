package com.openvarsity.img.imgservice.entity;

import com.openvarsity.base.db.AbstractEntity;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "images")
@Slf4j
@Data
public class ImageEntity extends AbstractEntity {

    @Column(name = "image_url", nullable = false)
    private String imageUrl;
}
