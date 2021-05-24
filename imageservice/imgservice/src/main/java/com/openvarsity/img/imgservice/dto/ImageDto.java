package com.openvarsity.img.imgservice.dto;

import com.openvarsity.base.db.AbstractDataDto;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class ImageDto extends AbstractDataDto {
    private String imageUrl;
}
