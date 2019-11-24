package gangoffour.classic.structural.adapter;

public class JsonWebRequest implements WebRequest {
    WebService webService;

    public JsonWebRequest(WebService webServices) {
        this.webService=webServices;
    }

    @Override
    public int request(Object data) {
        Json body = pojoToJson(data);
        Json response = webService.postRequest(body);
        if(response != null){
            return 200; // success status code
        }

        return 500; //  Error status code
    }

    private Json pojoToJson(Object data) {


        return null;
    }

    public void connect(String s) {

    }
}
