package cn.scifi.novelogic.infrastructure.common.eventbus;


/**
 * @author bingdyee
 * @since 2024/10/22
 */
public interface DomainEventListener<E extends DomainEvent> {

    /**
     *  处理事件
     *
     * @param event 领域事件
     */
    void onDomainEvent(E event);

    Class<E> getDomainEventClass();

}
