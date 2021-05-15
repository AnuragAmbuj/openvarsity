package com.openvarsity.cms.service.impl;

import com.openvarsity.cms.db.dao.CourseDao;
import com.openvarsity.cms.exceptions.ServiceException;
import com.openvarsity.cms.model.*;
import com.openvarsity.cms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public CreateCourseResponse createCourse(CreateCourseRequest request) throws ServiceException {
        //TODO
        return null;
    }


    @Override
    public CourseDetailsResponse getCourseDetails(Long courseId) throws ServiceException {
        //TODO
        return null;
    }

    @Override
    public UpdateCourseResponse updateCourse(UpdateCourseRequest request) throws ServiceException {
        //TODO
        return null;
    }

}
