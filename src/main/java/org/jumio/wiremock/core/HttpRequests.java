package org.jumio.wiremock.core;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public interface HttpRequests {
    /**
     *
     * @param baseURI
     * @param basePath
     * @param requestSpecification
     * @return
     */
    Response sendRequest(String baseURI, String basePath, RequestSpecification requestSpecification);
}
