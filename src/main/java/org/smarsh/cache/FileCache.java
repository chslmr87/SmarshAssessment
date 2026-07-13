package org.smarsh.cache;

import org.smarsh.hasher.UrlHasher;
import org.smarsh.records.CachedPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;

public class FileCache implements Cache {

    private static final Path CACHE_DIR = Paths.get("cache");
    public FileCache() throws IOException {
        Files.createDirectories(CACHE_DIR);
    }

    private Path file(String url) {
        return CACHE_DIR.resolve(UrlHasher.hash(url)+".cache");
    }

    @Override
    public boolean exists(String url) {
        return Files.exists(file(url));
    }

    @Override
    public CachedPage load(String url) throws Exception {
        IO.println("Reading from cache...");
        var lines = Files.readAllLines(file(url));
        var timeStamp = Instant.parse(lines.get(0));
        var storedUrl = lines.get(1);
        var contents = String.join(System.lineSeparator(), lines.subList(2, lines.size()));
        return new CachedPage(storedUrl, timeStamp, contents);
    }

    @Override
    public void store(CachedPage page) throws Exception {
        IO.println("Writing to cache...");
        var data = page.fetchTime()
                + System.lineSeparator()
                + page.url()
                + System.lineSeparator()
                + page.content();
        Files.writeString(file(page.url()), data);
    }
}
