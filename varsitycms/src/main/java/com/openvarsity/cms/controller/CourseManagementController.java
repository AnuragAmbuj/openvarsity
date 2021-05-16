package com.openvarsity.cms.controller;

import com.openvarsity.base.controller.AbstractController;
import com.openvarsity.cms.db.dto.CourseDto;
import com.openvarsity.cms.exceptions.ValidationException;
import com.openvarsity.cms.model.CreateCourseRequest;
import com.openvarsity.cms.model.UpdateImageRequest;
import com.openvarsity.cms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/course")
public class CourseManagementController extends AbstractController {

    @Autowired
    private CourseService courseService;

    @GetMapping(path = "/{id}",produces = "application/json")
    public CourseDto findCourseById(@PathVariable("id") Long id){
        if(id == null){
            throw new ValidationException("Course ID cannot be null");
        }
        return courseService.getCourseDetails(id);
    }

    @PostMapping(path = "/new", produces = "application/json", consumes = "application/json")
    public CourseDto createNewCourse(@RequestBody @Valid CreateCourseRequest request, BindingResult bindingResult, HttpServletRequest servletRequest){
        handleBindingResult(bindingResult);
        return courseService.createCourse(request);
    }

    @PutMapping(path = "/update/{id}", consumes = "application/json")
    public CourseDto updateCourse(@RequestBody CourseDto courseDto, BindingResult bindingResult, HttpServletRequest httpServletRequest){
        handleBindingResult(bindingResult);
        return courseService.updateCourse(courseDto);
    }

    @PutMapping(path = "/update/image", consumes = "application/json")
    public CourseDto updateImage(@RequestBody UpdateImageRequest request, BindingResult bindingResult, HttpServletRequest httpServletRequest){
        handleBindingResult(bindingResult);
        return courseService.updateCourseImage(request);
    }

    private void handleBindingResult(BindingResult bindingResult) {
        if(bindingResult.getAllErrors().size()>0){
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
    }

}
