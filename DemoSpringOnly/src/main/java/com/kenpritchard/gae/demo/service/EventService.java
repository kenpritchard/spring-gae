package com.kenpritchard.gae.demo.service;

import java.util.List;

import com.kenpritchard.gae.demo.domain.Event;

/**
 * The EventService interface is the method to store and retrieve events.
 */
public interface EventService {
    
    /**
     * Gets the event list.
     *
     * @return the event list
     */
    List<Event> getEventList();
    
    /**
     * Creates the event.
     *
     * @param event the event
     * @return the event
     */
    Event createEvent(Event event);
    
    /**
     * Delete event.
     *
     * @param event the event
     * @return true, if successful
     */
    boolean deleteEvent(Event event);
}
