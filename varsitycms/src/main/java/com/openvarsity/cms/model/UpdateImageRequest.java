package com.openvarsity.cms.model;

import com.openvarsity.base.request.AbstractRequest;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdateImageRequest extends AbstractRequest {
    @NotBlank(message = "Course Id cannot be null")
    private Long courseId;

    @NotBlank(message = "Image id cannot be empty")
    private String imageId;
}
