package com.openvarsity.cms.events;

import org.springframework.context.ApplicationEvent;

public class CourseUpdated extends ApplicationEvent {

    public CourseUpdated(Object source) {
        super(source);
    }
}
