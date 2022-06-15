package com.example.exchange;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("환율 계산기 인수테스트")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AcceptanceTest {
    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        if (RestAssured.port == RestAssured.UNDEFINED_PORT) {
            RestAssured.port = port;
        }
    }

    /**
     * GIVEN 환율 정보가 저장되어 있을때
     * WHEN 존재하는 통화를 요청하면
     * THEN 환율 정보를 반환한다
     */
    @DisplayName("존재하는 통환를 요청하면 환율 정보를 조회할 수 있다")
    @Test
    void 존재하는_통화_요청_성공() {
        String KRW = "KRW";

        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .when().get("/currency/" + KRW)
                .then().log().all()
                .extract();

        Double rate = response.jsonPath().getDouble("rate");
        assertThat(rate).isGreaterThan(0D);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    /**
     * GIVEN 환율 정보가 저장되어 있을때
     * WHEN 존재하는 통화와 환율을 요청하면
     * THEN 수취금액을 반환한다
     */
    @DisplayName("존재하는 통환를 요청하면 환율 정보를 조회할 수 있다")
    @Test
    void 수취금액_요청_성공() {
        Map<String, Object> params = new HashMap<>();
        params.put("remittance", "100");
        params.put("currency", "KRW");

        ExtractableResponse<Response> response = RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .params(params)
                .when().post("/price")
                .then().log().all()
                .extract();

        Double rate = response.jsonPath().getDouble("price");
        assertThat(rate).isGreaterThan(0D);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}
