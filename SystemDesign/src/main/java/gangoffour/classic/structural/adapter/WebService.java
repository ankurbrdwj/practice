package gangoffour.classic.structural.adapter;

public class WebService {
    public Json postRequest(Json body) {
        return null;
    }

    public static void main(String[] args) {
        WebService webServices = new WebService();

        JsonWebRequest jsonRequestAdapter = new JsonWebRequest(webServices);
        jsonRequestAdapter.connect("https://baraabytes.com");

        WebClient webClient = new WebClient(jsonRequestAdapter);
        webClient.upload("User data");

    }
}
