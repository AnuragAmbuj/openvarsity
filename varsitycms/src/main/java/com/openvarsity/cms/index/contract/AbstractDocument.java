package com.openvarsity.cms.index.contract;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public abstract class AbstractDocument {

    @Id
    private Long id;

    @Field(type = FieldType.Date, name = "created_at")
    protected Date createdAt;

    @Field(type = FieldType.Date, name = "updated_at")
    protected Date updatedAt;

    @Field(type = FieldType.Text, name = "created_by")
    protected String createdBy;

    @Field(type = FieldType.Text, name = "updated_by")
    protected String updatedBy;

    @Field(type = FieldType.Boolean, name = "published")
    protected boolean published = true;

    @Field(type = FieldType.Boolean, name = "deleted")
    protected boolean deleted = false;

}
