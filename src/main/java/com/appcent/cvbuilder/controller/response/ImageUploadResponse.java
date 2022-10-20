package com.appcent.cvbuilder.controller.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ImageUploadResponse {
    private String imageUrl;

}
