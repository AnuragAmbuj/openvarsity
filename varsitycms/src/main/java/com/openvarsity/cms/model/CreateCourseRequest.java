package com.openvarsity.cms.model;

import com.openvarsity.base.request.AbstractRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateCourseRequest extends AbstractRequest {

    @NotNull(message = "Course Name cannot be null")
    private String courseName;

    @NotNull(message = "Description cannot be empty")
    private String description;

    @NotNull(message = "Syllabus cannot be empty")
    private String syllabus;
}
