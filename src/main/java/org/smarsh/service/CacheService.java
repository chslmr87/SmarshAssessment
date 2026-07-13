package org.smarsh.service;

import org.smarsh.cache.Cache;
import org.smarsh.records.CachedPage;
import org.smarsh.requester.Requester;

import java.time.Instant;

public class CacheService {
    private final Cache cache;
    private final Requester requester;

    public CacheService(
            Cache cache,
            Requester requester) {

        this.cache = cache;
        this.requester = requester;

    }

    public CachedPage getPage(String url) throws Exception {

        if (cache.exists(url)) {
            IO.println("Cache hit");
            return cache.load(url);

        }

        IO.println("Cache missing...");
        String content = requester.request(url);
        CachedPage page = new CachedPage(url, Instant.now(), content);

        cache.store(page);

        return page;

    }

}
