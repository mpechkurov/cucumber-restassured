package alpha.vantage.temp;

import java.util.HashMap;
import java.util.Map;

import com.jayway.restassured.response.Response;

import static java.lang.ThreadLocal.withInitial;

public enum TestContext {
    CONTEXT;

    private static final String RESPONSE = "RESPONSE";
    private final ThreadLocal<Map<String, Object>> testContexts = withInitial(HashMap::new);

    public Response get(String name) {
        return (Response) testContexts.get().get(name);
    }

    public Response set(String name, Response object) {
        testContexts.get().put(name, object);
        return object;
    }

    public Response getResponse() {
        return get(RESPONSE);
    }

    public Response setResponse(Response response) {
        return set(RESPONSE, response);
    }

    public void reset() {
        testContexts.get().clear();
    }
}
