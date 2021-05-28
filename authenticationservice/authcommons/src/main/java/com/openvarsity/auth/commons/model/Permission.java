package com.openvarsity.auth.commons.model;

import lombok.Getter;

@Getter
public enum Permission {

    //Course based permissions
    BUY_COURSE(4, "Buy Course"),
    EDIT_COURSE(5,"Edit Course"),
    CREATE_COURSE(7,"Create Course"),
    DELETE_COURSE(8,"Delete Course"),
    VIEW_COURSE_LIST(1,"View Courses"),
    VIEW_RECOMMENDED_COURSES(14,"Recommended Courses"),

    //Student-Instructor Specific Permissions
    VIEW_INSTRUCTOR_PROFILE(2,"View Instructor Profile"),
    COURSE_VIEWS_ANALYTICS(12,"Check you course analytics"),

    //Student Participation
    COMMENT_ACCESS(9,"Write a comment or a review!"),
    DISCUSSION_ACCESS(10,"Participate in discussion"),

    //Profile
    VIEW_OWN_PROFILE(3,"View Profile"),
    EDIT_OWN_PROFILE(13,"Edit own profile"),
    ADDITIONAL_ROLES(6, "Take Additonal Role"),

    //Moderation
    TAKE_DOWN_COURSE(8, "Take Course Down"),
    DELETE_COMMENT(15,"Delete Comment"),
    REMOVE_FROM_DISCUSSION(16,"Remove from Discussion"),

    //Compliance
    REPORT_COURSE(7,"Report this course"),
    AUDIT_COURSE(11,"Audit Course");


    private int identifier;
    private String displayValue;

    Permission(int identifier, String displayValue){
        this.identifier = identifier;
        this.displayValue = displayValue;
    }

}
