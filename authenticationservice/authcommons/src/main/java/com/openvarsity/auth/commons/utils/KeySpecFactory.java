package com.openvarsity.auth.commons.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.openvarsity.auth.commons.exception.FatalCryptError;

import java.io.IOException;
import java.io.InputStream;

public class KeySpecFactory {

    private static final ObjectMapper YAML_OBJ_MAPPER = new ObjectMapper(new YAMLFactory());

    private static CommonsKeySpec currentInstance;
    private static KeySpecFactory keySpecFactory;

    private KeySpecFactory() throws IOException {
        final InputStream streamResource = CommonsKeySpec.class.getResourceAsStream("keyspec.yml");
        currentInstance = getYamlObjMapper().readValue(streamResource, CommonsKeySpec.class);
        //TODO Initialize KeySpec from a KMS system
    }

    private CommonsKeySpec getCurrentInstance(){
        return currentInstance;
    }

    public static CommonsKeySpec getKeySpec(){
        if(currentInstance == null){
            try {
                keySpecFactory = new KeySpecFactory();
            } catch (IOException e) {
                throw new FatalCryptError(e.getMessage());
            }
        }
        return currentInstance;
    }

    public boolean hasKeySpec(){
        return keySpecFactory != null && currentInstance!=null;
    }

    private ObjectMapper getYamlObjMapper(){
        YAML_OBJ_MAPPER.findAndRegisterModules();
        return YAML_OBJ_MAPPER;
    }
}
