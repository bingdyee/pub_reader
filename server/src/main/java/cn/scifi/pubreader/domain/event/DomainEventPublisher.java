package cn.scifi.pubreader.domain.event;

import cn.scifi.pubreader.infrastructure.common.eventbus.DomainEvent;
import cn.scifi.pubreader.infrastructure.common.eventbus.DomainEventBus;
import cn.scifi.pubreader.infrastructure.common.eventbus.DomainEventListener;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 领域事件发布
 *
 * @author bingdyee
 * @since 2024/10/22
 */
@Component
public class DomainEventPublisher implements ApplicationContextAware {

    private static final DomainEventBus EVENT_BUS = new DomainEventBus();

    public static void publish(DomainEvent event) {
        EVENT_BUS.publishEvent(event);
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        Map<String, DomainEventListener> beans = applicationContext.getBeansOfType(DomainEventListener.class);
        beans.forEach((k, v) -> EVENT_BUS.register(v));
    }

}
