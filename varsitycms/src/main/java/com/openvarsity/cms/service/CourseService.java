package com.openvarsity.cms.service;


import com.openvarsity.cms.exceptions.ServiceException;
import com.openvarsity.cms.model.*;

public interface CourseService {
    CreateCourseResponse createCourse(CreateCourseRequest request) throws ServiceException;
    CourseDetailsResponse getCourseDetails(Long courseId) throws ServiceException;
    UpdateCourseResponse updateCourse(UpdateCourseRequest request) throws ServiceException;
}
