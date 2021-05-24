package com.openvarsity.img.imgservice.service.impl;

import com.cloudinary.Cloudinary;
import com.openvarsity.img.imgservice.service.CloudinaryImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CloudinaryImageServiceImpl implements CloudinaryImageService {

    @Autowired
    private Cloudinary cloudinary;

}
