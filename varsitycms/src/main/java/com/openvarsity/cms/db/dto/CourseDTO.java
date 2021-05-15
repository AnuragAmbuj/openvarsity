package com.openvarsity.cms.db.dto;

import com.openvarsity.base.db.AbstractDataDto;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class CourseDTO extends AbstractDataDto {
    private String courseName;
    private String generalDescription;
    private String syllabus;
}
