package org.jumio.wiremock.core;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class Processor {

    /**
     * @param baseURI
     * @param basePath
     * @param httpMethods
     * @param requestSpecification
     * @return
     */
    private Response buildRequest(String baseURI, String basePath, HttpMethods httpMethods, RequestSpecification requestSpecification) {
        Response response = null;
        try {
            switch (httpMethods) {

                case GET:
                    response = new GetMethod().sendRequest(baseURI, basePath, requestSpecification);
                    break;
                case POST:
                    response = new PostMethod().sendRequest(baseURI, basePath, requestSpecification);
                    break;
                case PUT:
                    response = new PutMethod().sendRequest(baseURI, basePath, requestSpecification);
                    break;
                case DELETE:
                    response = new DeleteMethod().sendRequest(baseURI, basePath, requestSpecification);
                    break;
                case PATCH:
                    response = new PatchMethod().sendRequest(baseURI, basePath, requestSpecification);
                    break;
                default:
                    throw new IllegalStateException("HTTP method: " + httpMethods + "is not supported!");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     *
     * @param baseURI
     * @param basePath
     * @param httpMethods
     * @param rSpecData
     * @return
     */
    public Response sendRequest(String baseURI, String basePath, HttpMethods httpMethods, Map<RspecEnum, Map<String, Object>> rSpecData) {
        RequestSpecificationConfig requestSpecificationConfig = new RequestSpecificationConfig();
        RequestSpecification requestSpecification = requestSpecificationConfig.getRequestSpecification(rSpecData);
        return buildRequest(baseURI, basePath, httpMethods, requestSpecification);
    }

    /**
     *
     * @param baseURI
     * @param basePath
     * @param httpMethods
     * @param rSpecData
     * @param body
     * @return
     */
    public Response sendRequest(String baseURI, String basePath, HttpMethods httpMethods, Map<RspecEnum, Map<String, Object>> rSpecData, String body) {
        RequestSpecificationConfig requestSpecificationConfig = new RequestSpecificationConfig();
        RequestSpecification requestSpecification = requestSpecificationConfig.getRequestSpecification(rSpecData, body);
        return buildRequest(baseURI, basePath, httpMethods, requestSpecification);
    }
}
