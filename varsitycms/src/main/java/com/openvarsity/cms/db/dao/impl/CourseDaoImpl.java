package com.openvarsity.cms.db.dao.impl;

import com.openvarsity.base.db.AbstractDaoImpl;
import com.openvarsity.cms.db.dao.CourseDao;
import com.openvarsity.cms.db.dto.CourseDTO;
import com.openvarsity.cms.db.entity.Course;
import com.openvarsity.cms.db.repo.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseDaoImpl extends AbstractDaoImpl<CourseDTO,Long, Course, CourseRepository> implements CourseDao {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    protected CourseRepository getRepository() {
        return courseRepository;
    }

    @Override
    protected CourseDTO toDto(Course entity) {
        return modelMapper.map(entity,CourseDTO.class);
    }

    @Override
    protected List<CourseDTO> toDto(List<Course> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    protected Course toEntity(CourseDTO dto) {
        return modelMapper.map(dto,Course.class);
    }

    @Override
    protected List<Course> toEntity(List<CourseDTO> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public Long createCourse(CourseDTO courseDTO) {
        final CourseDTO course = save(courseDTO);
        return course.getId();
    }

    @Override
    public CourseDTO findCourseById(Long id) {
        Optional<CourseDTO> course = find(id);
        return course.orElse(null);
    }

    @Override
    public Long updateCourse(CourseDTO courseDTO) {
        CourseDTO updatedCourseDto = update(courseDTO);
        if(updatedCourseDto!=null){
            return updatedCourseDto.getId();
        }
        return null;
    }
}
