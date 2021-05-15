package com.openvarsity.cms.db.entity;

import com.openvarsity.base.db.AbstractEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "course")
@Entity
@Data
public class Course extends AbstractEntity {

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "description")
    private String general_description;

    @Column(name = "syllabus")
    private String syllabus;

}
