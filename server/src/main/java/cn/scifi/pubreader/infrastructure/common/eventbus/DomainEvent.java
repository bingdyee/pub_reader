package cn.scifi.pubreader.infrastructure.common.eventbus;

import lombok.Getter;

import java.util.UUID;

/**
 * @author Bing D. Yee
 * @since 2022/04/19
 */
@Getter
public class DomainEvent {

    private final String id;

    private final long timestamp;

    public DomainEvent() {
        this.id = UUID.randomUUID().toString();
        this.timestamp = System.currentTimeMillis();
    }

}
