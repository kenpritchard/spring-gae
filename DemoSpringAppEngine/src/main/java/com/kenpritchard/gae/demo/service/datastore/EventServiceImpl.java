package com.kenpritchard.gae.demo.service.datastore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.kenpritchard.gae.demo.domain.Event;
import com.kenpritchard.gae.demo.service.EventService;

/**
 * The Class EventServiceImpl.
 */
public class EventServiceImpl implements EventService {
	
	/** The Constant logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(EventServiceImpl.class);

	  /** The data store. */
  	private static DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();

	/* (non-Javadoc)
	 * @see com.kenpritchard.gae.demo.service.EventService#getEventList()
	 */
	@Override
	public List<Event> getEventList() {
		List<Event> events = new ArrayList<Event>();
		Query query = new Query("Event");
		List<Entity> entities = EventServiceImpl.dataStore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		for(Entity e : entities) {
			Event event = new Event();
			event.setDate((Date) e.getProperty("date"));
			event.setTitle((String) e.getProperty("title"));
			event.setId(e.getKey().getId());
			events.add(event);
		}
		return events;
	}

	/* (non-Javadoc)
	 * @see com.kenpritchard.gae.demo.service.EventService#createEvent(com.kenpritchard.gae.demo.domain.Event)
	 */
	@Override
	public Event createEvent(Event event) {
    	LOGGER.debug("Saving event persistently");
		Entity eventEntity = new Entity("Event");
		eventEntity.setProperty("title", event.getTitle());
		eventEntity.setProperty("date", event.getDate());
		Key key = EventServiceImpl.dataStore.put(eventEntity);
		event.setId(key.getId());
		return event;
	}

	/* (non-Javadoc)
	 * @see com.kenpritchard.gae.demo.service.EventService#deleteEvent(com.kenpritchard.gae.demo.domain.Event)
	 */
	@Override
	public boolean deleteEvent(Event event) {
		boolean success = false;
		Filter titleFilter = new FilterPredicate("title", FilterOperator.EQUAL, event.getTitle());
		Filter dateFilter = new FilterPredicate("date", FilterOperator.EQUAL, event.getDate());
		Filter eventFilter = CompositeFilterOperator.and(titleFilter, dateFilter);
		Query query = new Query("Event").setFilter(eventFilter);
		PreparedQuery preparedQuery = EventServiceImpl.dataStore.prepare(query);
		Entity victim = preparedQuery.asSingleEntity();
		Key key = victim.getKey();
		if(key.getId() == event.getId()) {
			try {
				EventServiceImpl.dataStore.delete(key);
				success = true;
			} catch(Exception e) {
				LOGGER.error("Something went wrong in the delete: " + e);
			}
		}
		return success;
	}

}
