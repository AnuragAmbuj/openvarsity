package com.openvarsity.cms.utils;

import com.openvarsity.cms.db.dto.CourseDto;
import com.openvarsity.cms.model.CreateCourseRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CourseObjectMapper {

    public static CourseDto fromCreateRequest(CreateCourseRequest request){
        final CourseDto courseDto = new CourseDto();
        courseDto.setCourseName(request.getCourseName());
        courseDto.setSyllabus(request.getSyllabus());
        courseDto.setGeneralDescription(request.getDescription());
        return courseDto;
    }

}
