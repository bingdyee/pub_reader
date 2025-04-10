package utils

import (
	"sync"
)

type DomainEvent struct {
	Data  any
	Topic string
	Async bool
}

type HandleFunc func(any)

type HandleFuncSlice []HandleFunc

type Bus struct {
	subscribers map[string]HandleFuncSlice
	lock        sync.RWMutex
}

func (bus *Bus) Publish(event DomainEvent) {
	bus.lock.RLock()
	defer bus.lock.RUnlock()
	if handlers, found := bus.subscribers[event.Topic]; found {
		for _, handle := range handlers {
			if event.Async {
				go handle(event.Data)
			} else {
				handle(event.Data)
			}
		}
	}
}

func (bus *Bus) Subscribe(topic string, handle HandleFunc) {
	bus.lock.Lock()
	defer bus.lock.Unlock()
	if prev, found := bus.subscribers[topic]; found {
		bus.subscribers[topic] = append(prev, handle)
	} else {
		bus.subscribers[topic] = append([]HandleFunc{}, handle)
	}
}

var EventBus = &Bus{
	subscribers: map[string]HandleFuncSlice{},
}
