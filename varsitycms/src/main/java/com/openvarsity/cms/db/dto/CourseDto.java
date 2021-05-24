package com.openvarsity.cms.db.dto;

import com.openvarsity.base.db.AbstractDataDto;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class CourseDto extends AbstractDataDto {
    private String courseName;
    private String courseTitle;
    private String courseSummary;
    private String courseImageId;
    private String introductoryVideoClipId;
    private String generalDescription;
    private String syllabus;
}
