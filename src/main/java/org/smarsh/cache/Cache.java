package org.smarsh.cache;

import org.smarsh.records.CachedPage;

public interface Cache {
    boolean exists(String url);
    CachedPage load(String url) throws Exception;
    void store(CachedPage page) throws Exception;
}
