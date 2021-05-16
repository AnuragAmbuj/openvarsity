package com.openvarsity.cms.service.impl;

import com.openvarsity.cms.db.dao.CourseDao;
import com.openvarsity.cms.db.dto.CourseDto;
import com.openvarsity.cms.exceptions.CMSErrorCode;
import com.openvarsity.cms.exceptions.ServiceException;
import com.openvarsity.cms.model.*;
import com.openvarsity.cms.service.CourseService;
import com.openvarsity.cms.utils.CourseObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public CourseDto createCourse(CreateCourseRequest request) throws ServiceException {
        //TODO
        return courseDao.createCourse(CourseObjectMapper.fromCreateRequest(request));
    }


    @Override
    public CourseDto getCourseDetails(Long courseId) throws ServiceException {
        //TODO
        CourseDto dto = courseDao.findCourseById(courseId);
        if(dto == null){
            throw new ServiceException(CMSErrorCode.NO_SUCH_COURSE);
        }
        return dto;
    }

    @Override
    public CourseDto updateCourse(CourseDto request) throws ServiceException {
        //TODO image and video upload mechanism
        final CourseDto courseDto = courseDao.updateCourse(request);
        if(courseDto == null){
            throw new ServiceException(CMSErrorCode.NO_SUCH_COURSE);
        }
        return courseDto;
    }

    @Override
    public CourseDto updateCourseImage(UpdateImageRequest request) throws ServiceException {
        final CourseDto courseDto = courseDao.updateCourseImage(request.getCourseId(),request.getImageId());
        if(courseDto == null){
            throw new ServiceException(CMSErrorCode.NO_SUCH_COURSE);
        }
        return courseDto;
    }

}
