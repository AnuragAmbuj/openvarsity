package com.openvarsity.cms.index;

import com.openvarsity.cms.index.contract.AbstractDocument;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "course-index")
@Data
public class CourseDocument extends AbstractDocument {

    @Field(type = FieldType.Text, name = "course_name")
    private String courseName;

    @Field(type = FieldType.Text, name = "course_title")
    private String courseTitle;

    @Field(type = FieldType.Text, name = "course_summary")
    private String courseSummary;

    @Field(type = FieldType.Text, name = "course_image_id")
    private String courseImageId;

    @Field(type = FieldType.Text, name = "intro_clip_id")
    private String introductoryVideoClipId;

    @Field(type = FieldType.Text, name = "general_description")
    private String generalDescription;

    @Field(type = FieldType.Text, name = "syllabus")
    private String syllabus;
}
