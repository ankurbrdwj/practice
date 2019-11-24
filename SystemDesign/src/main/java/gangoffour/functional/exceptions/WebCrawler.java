package gangoffour.functional.exceptions;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

public class WebCrawler {
    public void crawl(List<String> urlsToCrawl) {
        urlsToCrawl.stream()
                .map(ThrowingFunction.unchecked(URL::new))
                .forEach(ThrowingConsumer.unchecked(this::save));
    }

    private void save(URL url) throws IOException {
        String uuid = UUID.randomUUID().toString();
        InputStream inputStream = url.openConnection().getInputStream();
        Files.copy(inputStream, Paths.get(uuid + ".txt"), StandardCopyOption.REPLACE_EXISTING);
    }
}
