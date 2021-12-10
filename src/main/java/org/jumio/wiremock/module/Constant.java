package org.jumio.wiremock.module;

import org.jumio.wiremock.core.RspecEnum;

import java.util.Map;

public class Constant {
    //Mock server base uri
    public static String baseURI = "http://localhost:6666";

    //End points
    public static String createStubEndpoint = "/__admin/mappings";
    public static String getAllStubEndpoint = "/__admin/mappings";
    public static String getStubByIdEndpoint = "/__admin/mappings/{stubMappingId}";
    public static String deleteStubByIdEndpoint = "/__admin/mappings/{stubMappingId}";
    public static String updateStubByIdEndpoint = "/__admin/mappings/{stubMappingId}";
    public static String resetStubEndpoint = "/__admin/mappings/reset";

    //Map
    public static Map<String, Object> headers = null;
    public static Map<String, Object> pathParams = null;
    public static Map<RspecEnum, Map<String, Object>> rSpecData = null;

}
