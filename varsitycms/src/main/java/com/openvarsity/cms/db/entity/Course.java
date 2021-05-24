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

    @Column(name = "course_title")
    private String courseTitle;

    @Column(name = "course_summary", columnDefinition = "LONGTEXT")
    private String courseSummary;

    @Column(name = "course_image_id")
    private String courseImageId;

    @Column(name = "introductory_video_clip_id")
    private String introductoryVideoClipId;

    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String generalDescription;

    @Column(name = "syllabus", columnDefinition = "LONGTEXT")
    private String syllabus;
}
