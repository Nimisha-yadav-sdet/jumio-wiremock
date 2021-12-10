package org.jumio.test;

import io.restassured.response.Response;
import org.jumio.wiremock.core.HttpMethods;
import org.jumio.wiremock.core.Processor;
import org.jumio.wiremock.core.RspecEnum;
import org.jumio.wiremock.module.Constant;

import java.util.HashMap;

public class MockedApiHelper extends Constant {

    static Processor processor = new Processor();
    static String getUserEndpoint = "/api/users";

    public static Response getUsers() {
        headers = new HashMap<>();
        headers.put("Content-type", "application/json");

        rSpecData = new HashMap<>();
        rSpecData.put(RspecEnum.HEADERS, headers);

        Response response = processor.sendRequest(baseURI, getUserEndpoint, HttpMethods.GET, rSpecData);

        return response;
    }
}
