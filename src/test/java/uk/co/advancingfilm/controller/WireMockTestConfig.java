package uk.co.advancingfilm.controller;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.stubbing.ServeEvent;
import java.util.ArrayList;
import java.util.List;

public class WireMockTestConfig {

//    private static WireMockServer wireMockServer = null;
//
//    public static void setupWireMock() {
//        if (wireMockServer == null) {
//            wireMockServer = new WireMockServer(WIRE_MOCK_PORT);
//            wireMockServer.start();
//        } else {
//            resetWireMock();
//        }
//    }
//
//    public static void stubGet(final String uri, final int statusCode) {
//        wireMockServer.stubFor(get(uri)
//                .willReturn(aResponse()
//                        .withStatus(statusCode)
//                        .withHeader("Content-Type", "application/json")
//                        .withBody("SUCCESS")));
//    }
//
//    public static void resetWireMock() {
//        if (wireMockServer == null) {
//            throw new RuntimeException("Wiremock not initialised");
//        }
//        wireMockServer.resetAll();
//    }
//
//    public static List<ServeEvent> getServeEvents() {
//        return wireMockServer != null ? wireMockServer.getAllServeEvents() : new ArrayList<>();
//    }
//
//    public static WireMockServer getWireMockServer() {
//        return wireMockServer;
//    }
}
