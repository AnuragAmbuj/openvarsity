package com.openvarsity.cms.db.dao;

import com.openvarsity.base.db.AbstractDao;
import com.openvarsity.cms.db.dto.CourseDTO;

public interface CourseDao extends AbstractDao<CourseDTO,Long> {

    public Long createCourse(CourseDTO courseDTO);
    public CourseDTO findCourseById(Long id);
    public Long updateCourse(CourseDTO courseDTO);

}
