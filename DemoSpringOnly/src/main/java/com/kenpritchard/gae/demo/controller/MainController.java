package com.kenpritchard.gae.demo.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kenpritchard.gae.demo.constants.AppConstants;
import com.kenpritchard.gae.demo.domain.Event;
import com.kenpritchard.gae.demo.service.EventService;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes
public class MainController {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/** The event service. */
	@Autowired
	@Qualifier("eventService")
	private EventService eventService;
	
	/**
	 * Sets the event service.
	 *
	 * @param eventService the new event service
	 */
	public void setEventService(EventService eventService) {
	    this.eventService = eventService;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Serving home page");
		return "home";
	}
	
	/**
	 * Present a form for adding an event.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/new_event", method = RequestMethod.GET)
	public String newEvent(Locale locale, Model model) {
		logger.info("Request for new event");
		Event event = new Event();
		model.addAttribute(AppConstants.EVENT_ATTR, event);
		return "EventForm";
	}
	
	/**
	 * Save the newly added event.
	 *
	 * @param event the event
	 * @param bindingResult the binding result
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/save_event", method = RequestMethod.POST)
	public String saveEvent(@ModelAttribute("event") Event event, BindingResult bindingResult, Model model) {
		logger.info("Saving event: " + event);
		Event created = this.eventService.createEvent(event);
		model.addAttribute(AppConstants.EVENT_ATTR, created);
		return "EventDetails";
	}
	
	/**
	 * List all events.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/list_events", method = RequestMethod.GET)
	public String listEvents(Locale locale, Model model) {
		logger.info("Sending event list");
		List<Event> eventList = this.eventService.getEventList();
		model.addAttribute(AppConstants.EVENT_LIST_ATTR, eventList);
		return "EventList";
	}
	
	/**
	 * Display error.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String displayError(Locale locale, Model model) {
		logger.info("Error page");
		return "EventErrors";
	}
	
	/**
	 * Test event.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/testing", method = RequestMethod.GET)
	public String testEvent(Locale locale, Model model) {
		logger.info("Testing request");
		return "EventTest";
	}
	
}
