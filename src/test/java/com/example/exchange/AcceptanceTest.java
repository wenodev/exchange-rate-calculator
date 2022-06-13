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
		Double KRW_RATE = 1287.035002D;

		ExtractableResponse<Response> response = RestAssured.given().log().all()
				.when().get("/currency" + KRW)
				.then().log().all()
				.extract();

		Double rate = response.jsonPath().get("rate");
		assertThat(rate).isEqualTo(KRW_RATE);
		assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
	}
}
