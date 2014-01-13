package models;

import java.util.Date;

/**
 * The Class RequestData is some sort of DTO between the service and Mongo.
 */
public class RequestData {

	/** The url. */
	private String url;

	/** The start time. */
	private Date startTime;

	/** The end time. */
	private Date endTime;

	/** The request duration. */
	private long requestDuration;

	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 * 
	 * @param url
	 *            the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Gets the start time.
	 * 
	 * @return the start time
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * Sets the start time.
	 * 
	 * @param startTime
	 *            the new start time
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * Gets the end time.
	 * 
	 * @return the end time
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * Sets the end time.
	 * 
	 * @param endTime
	 *            the new end time
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * Gets the request duration.
	 * 
	 * @return the request duration
	 */
	public long getRequestDuration() {
		return requestDuration;
	}

	/**
	 * Sets the request duration.
	 * 
	 * @param requestDuration
	 *            the new request duration
	 */
	public void setRequestDuration(long requestDuration) {
		this.requestDuration = requestDuration;
	}

}
