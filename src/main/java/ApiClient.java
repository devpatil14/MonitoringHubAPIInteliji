import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

    public class ApiClient {

        private String baseUrl;

        public ApiClient(String baseUrl) {
            this.baseUrl = baseUrl;
        }

        private RequestSpecification getRequestSpecification() {
            return RestAssured.given()
                    .baseUri(baseUrl)
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON);
        }

        public ApiResponse get(String endpoint) {
            Response response = getRequestSpecification()
                    .when()
                    .get(endpoint)
                    .then()
                    .extract()
                    .response();
            return new ApiResponse(response);
        }

        public ApiResponse post(String endpoint, String body) {
            Response response = getRequestSpecification()
                    .body(body)
                    .when()
                    .post(endpoint)
                    .then()
                    .extract()
                    .response();
            return new ApiResponse(response);
        }

        public ApiResponse put(String endpoint, String body) {
            Response response = getRequestSpecification()
                    .body(body)
                    .when()
                    .put(endpoint)
                    .then()
                    .extract()
                    .response();
            return new ApiResponse(response);
        }

        public ApiResponse delete(String endpoint) {
            Response response = getRequestSpecification()
                    .when()
                    .delete(endpoint)
                    .then()
                    .extract()
                    .response();
            return new ApiResponse(response);
        }

        public ApiResponse patch(String endpoint, String body) {
            Response response = getRequestSpecification()
                    .body(body)
                    .when()
                    .patch(endpoint)
                    .then()
                    .extract()
                    .response();
            return new ApiResponse(response);
        }
}
