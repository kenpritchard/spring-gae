package com.kenpritchard.gae.demo.service.local;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.kenpritchard.gae.demo.domain.Event;
import com.kenpritchard.gae.demo.service.EventService;

/**
 * The EventServiceImpl class implements the EventService using
 * local and volatile storage. This implementation for demonstration
 * only.
 */
public class EventServiceImpl implements EventService {
    
    /** The event list. */
    private List<Event> eventList = new CopyOnWriteArrayList<Event>();

    /* (non-Javadoc)
     * @see com.kenpritchard.gae.demo.service.EventService#getEventList()
     */
    @Override
    public List<Event> getEventList() {
	return this.eventList;
    }

    /* (non-Javadoc)
     * @see com.kenpritchard.gae.demo.service.EventService#createEvent(com.kenpritchard.gae.demo.domain.Event)
     */
    @Override
    public Event createEvent(Event event) {
	event.setId(this.eventList.size());
	this.eventList.add(event);
	return event;
    }

    /* (non-Javadoc)
     * @see com.kenpritchard.gae.demo.service.EventService#deleteEvent(com.kenpritchard.gae.demo.domain.Event)
     */
    @Override
    public boolean deleteEvent(Event event) {
	return this.eventList.remove(event);
    }

}
