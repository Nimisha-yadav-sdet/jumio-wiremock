package org.jumio.wiremock.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Headers {
    private String ContentType;
}
