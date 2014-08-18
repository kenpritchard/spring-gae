package com.kenpritchard.gae.demo.domain;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class EventTest {
    private Event event1;
    private Event event2;
    private String title1 = "Title 1";
    private Calendar date1;
    private long id1 = 1;
    private String title2 = "Title 2";
    private Calendar date2;
    private long id2 = 2;
    
    @Before
    public void setup() {
	this.date1 = Calendar.getInstance();
	this.date2 = Calendar.getInstance();
	this.date2.add(Calendar.MONTH, 1);
	this.event1 = new Event();
	this.event2 = new Event();
	this.event1.setTitle(this.title1);
	this.event1.setDate(this.date1.getTime());
	this.event1.setId(this.id1);
	this.event2.setTitle(this.title2);
	this.event2.setDate(this.date2.getTime());
	this.event2.setId(this.id2);
    }

    @Test
    public void testToString() {
	assertTrue("String output does not match", this.event1.toString().equalsIgnoreCase(this.event1.toString()));
	assertFalse("String output for different events matches", this.event1.toString().equalsIgnoreCase(this.event2.toString()));
    }

    @Test
    public void testEqualsObject() {
	Event otherEvent = new Event();
	otherEvent.setDate(this.event1.getDate());
	otherEvent.setId(this.event1.getId());
	otherEvent.setTitle(this.event1.getTitle());
	assertFalse("Event should not be equal to null", this.event1.equals(null));
	assertTrue("Event not equal itself", this.event1.equals(this.event1));
	assertTrue("Event not equal copied event", this.event1.equals(otherEvent));
	assertFalse("Event should not be equal to different event", this.event1.equals(this.event2));
	
    }

    @Test
    public void testCompareTo() {
	assertFalse("Event should not be equal to null", this.event1.compareTo(null) == 0);
	assertTrue("Event should be greater than", this.event2.compareTo(this.event1) > 0);
	assertTrue("Event should be equal", this.event1.compareTo(this.event1) == 0);
    }

}
