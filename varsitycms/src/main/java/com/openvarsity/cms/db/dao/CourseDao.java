package com.openvarsity.cms.db.dao;

import com.openvarsity.base.db.AbstractDao;
import com.openvarsity.cms.db.dto.CourseDto;

public interface CourseDao extends AbstractDao<CourseDto,Long> {

    CourseDto saveCourse(CourseDto courseDTO);
    CourseDto findCourseById(Long id);
    CourseDto updateCourse(CourseDto courseDTO);

    CourseDto updateCourseImage(Long courseId, String imageId);
}
