package cn.scifi.pubreader.infrastructure.common.eventbus;


import cn.scifi.pubreader.infrastructure.common.utils.CollectionUtils;

import java.util.Map;
import java.util.concurrent.*;


/**
 * 领域事件总线
 *
 * @author Bing D. Yee
 * @since 2022/04/19
 */
public class DomainEventBus {

    private final Executor executor;
    private final Map<Class<? extends DomainEvent>, CopyOnWriteArraySet<DomainEventListener<? extends DomainEvent>>> subscribers;

    public DomainEventBus() {
        this.executor = new ThreadPoolExecutor(
                16, 16,
                0L, TimeUnit.MICROSECONDS,
                new ArrayBlockingQueue<>(1024)
        );
        this.subscribers =  new ConcurrentHashMap<>();
    }

    public void register(DomainEventListener<? extends DomainEvent> listener) {
        Class<? extends DomainEvent> domainEventClass = listener.getDomainEventClass();
        CopyOnWriteArraySet<DomainEventListener<? extends DomainEvent>> listeners = subscribers.getOrDefault(domainEventClass, new CopyOnWriteArraySet<>());
        listeners.add(listener);
        subscribers.putIfAbsent(domainEventClass, listeners);
    }

    public <E extends DomainEvent> void publishEvent(E event) {
        CopyOnWriteArraySet<DomainEventListener<? extends DomainEvent>> domainEventListeners = this.subscribers.get(event.getClass());
        if (CollectionUtils.isNotEmpty(domainEventListeners)) {
            for (DomainEventListener<? extends DomainEvent> listener : domainEventListeners) {
                executor.execute(() -> ((DomainEventListener<E>) listener).onDomainEvent(event));
            }
        }
    }

}
