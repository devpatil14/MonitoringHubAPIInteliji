import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;

    public class ApiResponse {

        private Response response;

        public ApiResponse(Response response) {
            this.response = response;
        }

        public int getStatusCode() {
            return response.getStatusCode();
        }

        public String getBodyAsString() {
            return response.getBody().asString();
        }

        public <T> T getBodyAs(Class<T> responseClass) {
            return response.getBody().as(responseClass);
        }

        public String getHeader(String headerName) {
            return response.getHeader(headerName);
        }

        public Headers getHeaders() {
            return response.getHeaders();
        }

        public String getCookie(String cookieName) {
            return response.getCookie(cookieName);
        }

        public Cookies getCookies() {
            return response.getDetailedCookies();
        }

        public Response getRawResponse() {
            return response;
        }

        public long getResponseTime() {
            return response.getTime();
        }

        public String getContentType() {
            return response.getContentType();
        }

        public boolean isSuccess() {
            return response.getStatusCode() / 100 == 2;
        }

        public boolean isClientError() {
            return response.getStatusCode() / 100 == 4;
        }

        public boolean isServerError() {
            return response.getStatusCode() / 100 == 5;
        }

}
