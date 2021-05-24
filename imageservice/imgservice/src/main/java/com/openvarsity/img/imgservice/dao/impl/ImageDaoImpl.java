package com.openvarsity.img.imgservice.dao.impl;

import com.openvarsity.base.db.AbstractDaoImpl;
import com.openvarsity.base.mapper.ModelMappingUtil;
import com.openvarsity.img.imgservice.dto.ImageDto;
import com.openvarsity.img.imgservice.entity.ImageEntity;
import com.openvarsity.img.imgservice.repo.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageDaoImpl extends AbstractDaoImpl<ImageDto,Long, ImageEntity, ImageRepository> {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    protected ImageRepository getRepository() {
        return imageRepository;
    }

    @Override
    protected ImageDto toDto(ImageEntity entity) {
        return ModelMappingUtil.map(entity,ImageDto.class);
    }

    @Override
    protected List<ImageDto> toDto(List<ImageEntity> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    protected ImageEntity toEntity(ImageDto dto) {
        return ModelMappingUtil.map(dto,ImageEntity.class);
    }

    @Override
    protected List<ImageEntity> toEntity(List<ImageDto> dtos) {
        return null;
    }
}
