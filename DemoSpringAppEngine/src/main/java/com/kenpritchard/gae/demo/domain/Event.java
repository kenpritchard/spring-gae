package com.kenpritchard.gae.demo.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.kenpritchard.gae.demo.constants.AppConstants;

/**
 * The Event class, primary domain for the application.
 */
public class Event implements Serializable, Comparable<Event> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private long id;

	/** The title. */
	private String title;

	/** The date. */
	private Date date;

	/**
	 * Sets the title.
	 * 
	 * @param theTitle
	 *            the new title
	 */
	public void setTitle(final String theTitle) {
		if (this.title == null) {
			this.title = theTitle;
		}
	}

	/**
	 * Sets the date.
	 * 
	 * @param theDate
	 *            the new date
	 */
	public void setDate(final Date theDate) {
		if (this.date == null) {
			this.date = theDate;
		}
	}

	/**
	 * Sets the id.
	 * 
	 * @param theId
	 *            the new id
	 */
	public void setId(final long theId) {
		this.id = theId;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat(
				AppConstants.DATE_FORMAT);
		StringBuilder builder = new StringBuilder();
		builder.append(this.getId()).append(" ")
				.append(formatter.format(this.getDate())).append(" ")
				.append(this.getTitle());
		return (this.getId() + " " + formatter.format(this.getDate()) + " " + this
				.getTitle());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object otherEvent) {
		boolean match = false;
		if (this == otherEvent) {
			match = true;
		} else if (otherEvent instanceof Event) {
			final Event event = (Event) otherEvent;
			match = (this.title.compareTo(event.title) == 0 && (this.date
					.compareTo(event.date) == 0));
		}
		return match;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Event event) {
		final int LESS_THAN = -1;
		final int EQUAL = 0;
		final int GREATER_THAN = 1;
		int order = LESS_THAN;
		if (this == null) {
			order = event == null ? EQUAL : LESS_THAN;
		} else if (event == null) {
			order = GREATER_THAN;
		} else if (this == event) {
			order = EQUAL;
		} else {
			order = this.title.compareTo(event.title);
			if (EQUAL == order) {
				order = this.date.compareTo(event.date);
			}
		}
		return order;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int seed = 89;
		int result = 97;
		result = (int) (seed * result + this.id);
		result = seed * result + this.title.hashCode();
		result = seed * result + this.date.hashCode();
		return result;
	}
}