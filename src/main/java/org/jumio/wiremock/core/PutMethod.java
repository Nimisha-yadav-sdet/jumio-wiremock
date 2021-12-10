package org.jumio.wiremock.core;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutMethod implements HttpRequests {

    /**
     * @param baseURI
     * @param basePath
     * @param requestSpecification
     * @return
     */
    @Override
    public Response sendRequest(String baseURI, String basePath, RequestSpecification requestSpecification) {

        Response response = requestSpecification.when()
                .baseUri(baseURI)
                .basePath(basePath)
                .log()
                .all()
                .put()
                .then()
                .log()
                .status()
                .log()
                .body()
                .extract().response();
        return response;
    }
}
