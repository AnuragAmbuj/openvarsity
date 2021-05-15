package com.openvarsity.cms.model;

import com.openvarsity.base.response.AbstractResponse;
import lombok.Data;

@Data
public class UpdateCourseResponse extends AbstractResponse {
    private boolean updated;
}
