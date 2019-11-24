package gangoffour.functional.exceptions;


import java.util.List;

public class ExceptionDemo {
    public static void main(String[] args) {
        List<String> urlsToCrawl = List.of("https://masterdevskills.com");
        WebCrawler webCrawler = new WebCrawler();
        webCrawler.crawl(urlsToCrawl);
        class Test
        {
            private Demo d;
            void start()
            {
                d = new Demo();
                this.takeDemo(d); /* Line 7 */
            } /* Line 8 */
            void takeDemo(Demo demo)
            {
                demo = null;
                demo = new Demo();
            }
        }
    }
}