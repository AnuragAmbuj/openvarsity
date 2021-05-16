package com.openvarsity.cms.db.dao.impl;

import com.openvarsity.base.db.AbstractDaoImpl;
import com.openvarsity.cms.db.dao.CourseDao;
import com.openvarsity.cms.db.dto.CourseDto;
import com.openvarsity.cms.db.entity.Course;
import com.openvarsity.cms.db.repo.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CourseDaoImpl extends AbstractDaoImpl<CourseDto, Long, Course, CourseRepository> implements CourseDao {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    protected CourseRepository getRepository() {
        return courseRepository;
    }

    @Override
    protected CourseDto toDto(Course entity) {
        return modelMapper.map(entity, CourseDto.class);
    }

    @Override
    protected List<CourseDto> toDto(List<Course> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    protected Course toEntity(CourseDto dto) {
        return modelMapper.map(dto, Course.class);
    }

    @Override
    protected List<Course> toEntity(List<CourseDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    @Caching(evict = {@CacheEvict(value = "usersList", allEntries = true),}, put = {
            @CachePut(value = "courses", key = "#courseDTO.id")
    })
    public CourseDto saveCourse(CourseDto courseDTO) {
        final CourseDto course = save(courseDTO);
        //TODO index and stuff
        return course;
    }

    @Override
    @Cacheable(value = "courses", key = "#id")
    public CourseDto findCourseById(Long id) {
        Optional<CourseDto> course = find(id);
        return course.orElse(null);
    }

    @Override
    public CourseDto updateCourse(CourseDto courseDTO) {
        return update(courseDTO);
    }

    @Override
    public CourseDto updateCourseImage(Long courseId, String imageId) {
        final Optional<Course> courseOptional = getRepository().findById(courseId);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            course.setCourseImageId(imageId);
            course = getRepository().save(course);
            return toDto(course);
        } else {
            return null;
        }
    }
}
