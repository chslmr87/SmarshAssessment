package org.smarsh.records;

import java.time.Instant;

public record CachedPage(String url, Instant fetchTime, String content) {
}
