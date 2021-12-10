package org.jumio.wiremock.core;

import io.restassured.RestAssured;
import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RequestSpecificationConfig {

    /**
     * @param rSpecData
     * @param body
     * @return
     */
    public RequestSpecification getRequestSpecification(Map<RspecEnum, Map<String, Object>> rSpecData, String body) {

        RequestSpecification rSpec = RestAssured.given();

        if (rSpecData.containsKey(RspecEnum.HEADERS) && rSpecData.get(RspecEnum.HEADERS) != null && !rSpecData.get(RspecEnum.HEADERS).isEmpty()) {
            rSpec.headers(rSpecData.get(RspecEnum.HEADERS));
        }

        if (rSpecData.containsKey(RspecEnum.QUERY_PARAMS) && rSpecData.get(RspecEnum.QUERY_PARAMS) != null && !rSpecData.get(RspecEnum.QUERY_PARAMS).isEmpty()) {
            rSpec.queryParams(rSpecData.get(RspecEnum.QUERY_PARAMS));
        }

        if (rSpecData.containsKey(RspecEnum.PATH_PARAMS) && rSpecData.get(RspecEnum.PATH_PARAMS) != null && !rSpecData.get(RspecEnum.PATH_PARAMS).isEmpty()) {
            rSpec.pathParams(rSpecData.get(RspecEnum.PATH_PARAMS));
        }

        if (body != null) {
            rSpec.body(body);
        }

        return rSpec;
    }

    public RequestSpecification getRequestSpecification(Map<RspecEnum, Map<String, Object>> rSpecData, MultiPartSpecification multiPartSpecification) {

        RequestSpecification rSpec = RestAssured.given();

        if (rSpecData.containsKey(RspecEnum.HEADERS) && rSpecData.get(RspecEnum.HEADERS) != null && !rSpecData.get(RspecEnum.HEADERS).isEmpty()) {
            rSpec.headers(rSpecData.get(RspecEnum.HEADERS));
        }

        if (rSpecData.containsKey(RspecEnum.QUERY_PARAMS) && rSpecData.get(RspecEnum.QUERY_PARAMS) != null && !rSpecData.get(RspecEnum.QUERY_PARAMS).isEmpty()) {
            rSpec.queryParams(rSpecData.get(RspecEnum.QUERY_PARAMS));
        }

        if (rSpecData.containsKey(RspecEnum.PATH_PARAMS) && rSpecData.get(RspecEnum.PATH_PARAMS) != null && !rSpecData.get(RspecEnum.PATH_PARAMS).isEmpty()) {
            rSpec.pathParams(rSpecData.get(RspecEnum.PATH_PARAMS));
        }

        if (multiPartSpecification != null) {
            rSpec.multiPart(multiPartSpecification);
        }

        return rSpec;
    }

    /**
     * @param rSpecData
     * @return
     */
    public RequestSpecification getRequestSpecification(Map<RspecEnum, Map<String, Object>> rSpecData) {

        RequestSpecification rSpec = RestAssured.given();

        if (rSpecData.containsKey(RspecEnum.HEADERS) && rSpecData.get(RspecEnum.HEADERS) != null && !rSpecData.get(RspecEnum.HEADERS).isEmpty()) {
            rSpec.headers(rSpecData.get(RspecEnum.HEADERS));
        }

        if (rSpecData.containsKey(RspecEnum.QUERY_PARAMS) && rSpecData.get(RspecEnum.QUERY_PARAMS) != null && !rSpecData.get(RspecEnum.QUERY_PARAMS).isEmpty()) {
            rSpec.queryParams(rSpecData.get(RspecEnum.QUERY_PARAMS));
        }

        if (rSpecData.containsKey(RspecEnum.PATH_PARAMS) && rSpecData.get(RspecEnum.PATH_PARAMS) != null && !rSpecData.get(RspecEnum.PATH_PARAMS).isEmpty()) {
            rSpec.pathParams(rSpecData.get(RspecEnum.PATH_PARAMS));
        }

        return rSpec;
    }

}
