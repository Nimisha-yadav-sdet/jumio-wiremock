package org.jumio.wiremock.module;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.jumio.wiremock.core.HttpMethods;
import org.jumio.wiremock.core.Processor;
import org.jumio.wiremock.core.RspecEnum;
import org.jumio.wiremock.dto.CreateStubDTO;

import java.util.HashMap;

@Slf4j
public class MockHelper extends Constant {

    static Processor processor = new Processor();
    static ObjectMapper mapper = null;

    /**
     *
     * @param createStubDTO
     * @return
     */
    public static Response createStub(CreateStubDTO createStubDTO) {
        Response response = null;
        try {
            headers = new HashMap<>();
            headers.put("Content-type", "application/json");


            mapper = new ObjectMapper();
            String requestBody = mapper.writeValueAsString(createStubDTO);

            rSpecData = new HashMap<>();
            rSpecData.put(RspecEnum.HEADERS, headers);

            response = processor.sendRequest(baseURI, createStubEndpoint, HttpMethods.POST, rSpecData, requestBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     *
     * @return
     */
    public static Response getAllStub() {
        headers = new HashMap<>();
        headers.put("Content-type", "application/json");

        rSpecData = new HashMap<>();
        rSpecData.put(RspecEnum.HEADERS, headers);

        Response response = processor.sendRequest(baseURI, getAllStubEndpoint, HttpMethods.GET, rSpecData);

        return response;
    }

    /**
     *
     * @return
     */
    public static Response resetStub() {
        headers = new HashMap<>();
        headers.put("Content-type", "application/json");

        rSpecData = new HashMap<>();
        rSpecData.put(RspecEnum.HEADERS, headers);

        Response response = processor.sendRequest(baseURI, resetStubEndpoint, HttpMethods.POST, rSpecData, null);

        return response;
    }

    /**
     *
     * @param stubId
     * @return
     */
    public static Response getStubById(String stubId) {
        headers = new HashMap<>();
        headers.put("Content-type", "application/json");

        pathParams = new HashMap<>();
        pathParams.put("stubMappingId",stubId);

        rSpecData = new HashMap<>();
        rSpecData.put(RspecEnum.HEADERS, headers);
        rSpecData.put(RspecEnum.PATH_PARAMS, pathParams);

        Response response = processor.sendRequest(baseURI, getStubByIdEndpoint, HttpMethods.GET, rSpecData);

        return response;
    }

    /**
     *
     * @param stubId
     * @return
     */
    public static Response deleteStubById(String stubId) {
        headers = new HashMap<>();
        headers.put("Content-type", "application/json");


        pathParams = new HashMap<>();
        pathParams.put("stubMappingId",stubId);

        rSpecData = new HashMap<>();
        rSpecData.put(RspecEnum.HEADERS, headers);
        rSpecData.put(RspecEnum.PATH_PARAMS, pathParams);


        Response response = processor.sendRequest(baseURI, deleteStubByIdEndpoint, HttpMethods.DELETE, rSpecData);

        return response;
    }

    /**
     *
     * @param createStubDTO
     * @param stubId
     * @return
     */
    public static Response updateStubById(CreateStubDTO createStubDTO, String stubId) {
        headers = new HashMap<>();
        headers.put("Content-type", "application/json");

        pathParams = new HashMap<>();
        pathParams.put("stubMappingId",stubId);

        rSpecData = new HashMap<>();
        rSpecData.put(RspecEnum.HEADERS, headers);
        rSpecData.put(RspecEnum.PATH_PARAMS, pathParams);

        Response response = processor.sendRequest(baseURI, updateStubByIdEndpoint, HttpMethods.PUT, rSpecData);

        return response;
    }

}
