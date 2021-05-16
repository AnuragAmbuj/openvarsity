package com.openvarsity.cms.events;

import org.springframework.context.ApplicationEvent;

/**
 * This event occurs when a course is created
 */
public class CourseCreated extends ApplicationEvent {

    public CourseCreated(Object source) {
        super(source);
    }
}
