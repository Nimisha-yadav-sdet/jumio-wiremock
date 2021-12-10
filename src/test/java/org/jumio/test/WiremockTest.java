package org.jumio.test;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.jumio.wiremock.dto.CreateStubDTO;
import org.jumio.wiremock.dto.Headers;
import org.jumio.wiremock.dto.Request;
import org.jumio.wiremock.dto.MockResponse;
import org.jumio.wiremock.module.MockHelper;
import org.testng.annotations.Test;

public class WiremockTest {

    @Test
    public void createStubForUserDetails() {

        String responseBody = "{\"page\":2,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":[{\"id\":7,\"email\":\"michael.lawson@reqres.in\",\"first_name\":\"Michael\",\"last_name\":\"Lawson\"},{\"id\":8,\"email\":\"lindsay.ferguson@reqres.in\",\"first_name\":\"Lindsay\",\"last_name\":\"Ferguson\"},{\"id\":9,\"email\":\"tobias.funke@reqres.in\",\"first_name\":\"Tobias\",\"last_name\":\"Funke\"},{\"id\":10,\"email\":\"byron.fields@reqres.in\",\"first_name\":\"Byron\",\"last_name\":\"Fields\"},{\"id\":11,\"email\":\"george.edwards@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Edwards\"},{\"id\":12,\"email\":\"rachel.howell@reqres.in\",\"first_name\":\"Rachel\",\"last_name\":\"Howell\"}]}";
        String responseBodyUpdate = "{\"page\":1,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":[{\"id\":7,\"email\":\"michael.lawson@reqres.in\",\"first_name\":\"Michael\",\"last_name\":\"Lawson\"},{\"id\":8,\"email\":\"lindsay.ferguson@reqres.in\",\"first_name\":\"Lindsay\",\"last_name\":\"Ferguson\"},{\"id\":9,\"email\":\"tobias.funke@reqres.in\",\"first_name\":\"Tobias\",\"last_name\":\"Funke\"},{\"id\":10,\"email\":\"byron.fields@reqres.in\",\"first_name\":\"Byron\",\"last_name\":\"Fields\"},{\"id\":11,\"email\":\"george.edwards@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Edwards\"},{\"id\":12,\"email\":\"rachel.howell@reqres.in\",\"first_name\":\"Rachel\",\"last_name\":\"Howell\"}]}";

        Request request = Request.builder()
                .url("/api/users")
                .method("GET")
                .build();

        MockResponse mockResponse = MockResponse.builder()
                .headers(Headers.builder().ContentType("application/json").build())
                .body(responseBody)
                .status(HttpStatus.SC_OK)
                .build();

        CreateStubDTO createStubDTO = CreateStubDTO.builder()
                .request(request)
                .response(mockResponse)
                .build();
        MockHelper.createStub(createStubDTO);
        MockedApiHelper.getUsers();


        Response response = MockHelper.getAllStub();
        MockHelper.getStubById(response.getBody().jsonPath().<String>get("mappings[0].id"));

        MockResponse mockResponseUpdate = MockResponse.builder()
                .headers(Headers.builder().ContentType("application/json").build())
                .body(responseBodyUpdate)
                .status(HttpStatus.SC_OK)
                .build();
        CreateStubDTO updateStubDTO = CreateStubDTO.builder()
                .request(request)
                .response(mockResponseUpdate)
                .build();
        MockHelper.updateStubById(updateStubDTO, response.getBody().jsonPath().<String>get("mappings[0].id"));
        MockHelper.getAllStub();
        MockHelper.deleteStubById(response.getBody().jsonPath().<String>get("mappings[0].id"));
        MockHelper.resetStub();
        MockHelper.getAllStub();
    }


}
