package com.openvarsity.base.enums;

import java.util.HashMap;
import java.util.Map;

public enum UserType {
    INSTRUCTOR ("Instructor"),
    STUDENT("Student");

    private String userTypeValue;


    UserType(String userTypeValue){
        this.userTypeValue = userTypeValue;
        UserTypeMap.put(userTypeValue,this);
    }


    public static class UserTypeMap{
        private static final Map<String, UserType> _userTypeMap = new HashMap<>();

        public static void put(String key, UserType value){
            _userTypeMap.put(key,value);
        }

        public static UserType get(String key){
            return _userTypeMap.get(key);
        }
    }
}
