package org.smarsh.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.smarsh.cache.Cache;
import org.smarsh.records.CachedPage;
import org.smarsh.requester.Requester;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CacheServiceTest {
    @Mock
    Cache cache;

    @Mock
    Requester requester;

    @InjectMocks
    CacheService service;

    @Test
    void readFromCacheTest() throws Exception {

        String url = "https://google.com";
        CachedPage page = new CachedPage(url, Instant.now(),"cached");
        when(cache.exists(url)).thenReturn(true);
        when(cache.load(url)).thenReturn(page);
        service.getPage(url);
        verify(requester, never()).request(any());
    }

    @Test
    void writeToCacheTest() throws Exception {
        String url = "https://google.com";
        CachedPage page = new CachedPage(url, Instant.now(),"newToCache");
        when(cache.exists(url)).thenReturn(false);
        when(requester.request(url)).thenReturn("helloworld");
        service.getPage(url);
        verify(requester).request(url);
        verify(cache).store(any());

    }


}