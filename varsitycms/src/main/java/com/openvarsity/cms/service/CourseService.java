package com.openvarsity.cms.service;


import com.openvarsity.cms.db.dto.CourseDto;
import com.openvarsity.cms.exceptions.ServiceException;
import com.openvarsity.cms.model.*;

public interface CourseService {
    CourseDto createCourse(CreateCourseRequest request) throws ServiceException;
    CourseDto getCourseDetails(Long courseId) throws ServiceException;
    CourseDto updateCourse(CourseDto request) throws ServiceException;

    CourseDto updateCourseImage(UpdateImageRequest request) throws ServiceException;
}
