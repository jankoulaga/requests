package controllers;

import java.util.Date;

import models.RequestData;
import play.libs.F.Function;
import play.libs.F.Function0;
import play.libs.F.Promise;
import play.libs.WS;
import play.mvc.Controller;
import play.mvc.Result;
import dao.RequestDao;

/**
 * The Class Application is the default controller. Since there are only two
 * methods inside this application it seemed fair that i have just one
 * controller.
 */
public class Application extends Controller {

	/** The Constant URL_ARRAY. Holding all the possible URL */
	private static final String[] URL_ARRAY = { "http://www.spiegel.de",
			"http://www.sueddeutsche.de", "http://www.welt.de",
			"http://www.bild.de", "http://www.faz.net" };

	/**
	 * Index method called when no extra path is added. This automatically
	 * redirects to <code>/benchmark</code> path and invokes the
	 * {@link #benchmark()} method.
	 * 
	 * @return the result with a redirect
	 */
	public static Result index() {
		return redirect("/benchmark");
	}

	/**
	 * Requests method returns <b>ALL</b> the data from the requests collection.
	 * 
	 * @return <b>ALL</b> the data from the requests collection
	 */
	public static Result requests() {
		return ok(play.libs.Json.toJson(RequestDao.getAll()));
	}

	/**
	 * Benchmark method is supposed to asynchronously open url's from the
	 * {@link #URL_ARRAY} array.
	 * 
	 * @return the data recorded string
	 */
	public static Result benchmark() {
		for (String url : URL_ARRAY) {
			recordData(url);
		}
		return ok("Data recorded");
	}

	/**
	 * Record data logs the time elapsed for each get request to a parameter
	 * URL.
	 * 
	 * @param url
	 *            the url
	 */
	private static void recordData(final String url) {
		// Create a new promise
		Promise.promise(new Function0<RequestData>() {
			public RequestData apply() {
				// This is so I can tell if Sven invoked the service:)
				System.out.println("Apply " + url);
				// Set start time in milisec.
				final long startMilisecs = System.currentTimeMillis();
				final RequestData data = new RequestData();
				// Save URL
				data.setUrl(url);
				// Set start time
				data.setStartTime(new Date(startMilisecs));
				// Call the URL asynchronously
				WS.url(url).get().map(new Function<WS.Response, Result>() {
					public Result apply(WS.Response response) {
						// Done, save time
						long endMilisecs = System.currentTimeMillis();
						data.setEndTime(new Date(endMilisecs));
						data.setRequestDuration(endMilisecs - startMilisecs);
						// Insert asynchronously
						Promise.promise(new Function0<RequestData>() {

							@Override
							public RequestData apply() throws Throwable {
								RequestDao.insert(data);
								//Sven check
								System.out.println("Request reply " + url);
								return null;
							}

						});

						return ok();
					}
				});
				return data;
			}
		});

	}
}
