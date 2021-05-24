package com.openvarsity.base.mapper;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

import java.io.Serializable;

@UtilityClass
@Slf4j
public class ModelMappingUtil {

    private static final ModelMapper _MODEL_MAPPER = new ModelMapper();

    private static ModelMapper getModelMapper(){
        return _MODEL_MAPPER;
    }

    public static <T extends Serializable> T map(Object object, Class<T> clazz){
        return getModelMapper().map(object,clazz);
    }

}
