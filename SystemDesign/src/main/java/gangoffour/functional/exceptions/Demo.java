package gangoffour.functional.exceptions;

public class Demo {

}

class Test implements Runnable {
    public void run() {
        System.out.printf("%d", 3);
    }

    public static void main(String[] args) throws InterruptedException {
        {
            int value = 554;
            //String var = (String) value; //line 1
            String temp = "123";
            //int data = (int) temp; //line 2
            //System.out.println(data + var);
        }
    }

} 