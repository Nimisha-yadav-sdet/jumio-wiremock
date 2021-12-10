package org.jumio.wiremock.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MockResponse {

    private Headers headers;
    private String body;
    private Integer status;

}
