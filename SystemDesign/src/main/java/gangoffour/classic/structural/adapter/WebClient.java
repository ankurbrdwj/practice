package gangoffour.classic.structural.adapter;

public class WebClient {
    WebRequest webRequest;

    public WebClient(WebRequest webRequest) {
        this.webRequest = webRequest;
    }

    private Object createAttachment(String content){

        // create plan old java object ...

        return null;
    }
    public void upload(String content){
        Object data = createAttachment(content);
        int resultCode = webRequest.request(data);
        if (resultCode == 200){
            System.out.println("Status: Ok!");
        }else {
            System.out.println("Status: Error!");
        }
    }
}
