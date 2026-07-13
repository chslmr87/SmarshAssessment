package org.smarsh;

import org.smarsh.cache.FileCache;
import org.smarsh.records.CachedPage;
import org.smarsh.requester.WebRequester;
import org.smarsh.service.CacheService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    static void main() throws Exception {

            String url =
                    "https://www.cnn.com/2026/07/13/entertainment/sam-neill-jurassic-park-dead-intl-hnk";

            CacheService service =
                    new CacheService(new FileCache(), new WebRequester());

            CachedPage page = service.getPage(url);

            IO.println();
            IO.println("Fetched: ");
            IO.println(page.fetchTime());

            IO.println();
            IO.println("URL: ");
            IO.println(page.url());

            IO.println();
            IO.println("Content: ");
            IO.println(page.content());

        }

}

