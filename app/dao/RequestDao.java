package dao;

import models.RequestData;

import org.jongo.MongoCollection;

import uk.co.panaxiom.playjongo.PlayJongo;

/**
 * The Class RequestDao is actually a mockery because it's not a real DAO layer
 * implementation.
 */
public class RequestDao {

	/** The Constant REQUEST_COLLECTION_NAME. */
	private static final String REQUEST_COLLECTION_NAME = "requests";

	/**
	 * Request collection.
	 * 
	 * @return the mongo collection
	 */
	public static MongoCollection requestCollection() {
		return PlayJongo.getCollection(REQUEST_COLLECTION_NAME);
	}

	/**
	 * Gets all {@link RequestData} requests from collections.
	 * 
	 * @return everything there is in the database collection
	 */
	public static Iterable<RequestData> getAll() {
		return requestCollection().find().as(RequestData.class);
	}

	/**
	 * Insert {@link RequestData} object to collection.
	 * 
	 * @param data
	 *            the data to be inserted
	 */
	public static void insert(RequestData data) {
		requestCollection().save(data);
	}
}
