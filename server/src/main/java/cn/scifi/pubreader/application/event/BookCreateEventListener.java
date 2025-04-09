package cn.scifi.pubreader.application.event;

import cn.scifi.pubreader.domain.event.BookCreateEvent;
import cn.scifi.pubreader.infrastructure.common.eventbus.DomainEventListener;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 订阅书籍创建事件
 *
 * @author bingdyee
 * @since 2024/10/22
 */
@Component
@RequiredArgsConstructor
public class BookCreateEventListener implements DomainEventListener<BookCreateEvent> {

    private static final Logger logger = LoggerFactory.getLogger(BookCreateEventListener.class);

    @Override
    public void onDomainEvent(BookCreateEvent event) {
        logger.info("开始处理书籍创建事件....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) { }
        logger.info("处理书籍创建事件完成....");
    }

    @Override
    public Class<BookCreateEvent> getDomainEventClass() {
        return BookCreateEvent.class;
    }

}
