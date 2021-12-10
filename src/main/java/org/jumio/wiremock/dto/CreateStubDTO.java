package org.jumio.wiremock.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateStubDTO {

    private Request request;
    private MockResponse response;

}



