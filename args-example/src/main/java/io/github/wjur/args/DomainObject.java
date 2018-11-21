package io.github.wjur.args;

import java.time.ZonedDateTime;

public class DomainObject {
    private final Long id;
    private final String name;
    private final ZonedDateTime createdAt;

    public DomainObject(Long id, String name, ZonedDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
