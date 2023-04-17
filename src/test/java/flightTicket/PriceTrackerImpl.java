package flightTicket;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class PriceTrackerImpl implements PriceTracker {

	private final AirlinesInfoServices airlinesInfoServices;

	private AtomicReferenceArray airlines;

	public PriceTrackerImpl(AirlinesInfoServices airlinesInfoServices) {
		this.airlinesInfoServices = airlinesInfoServices;
		airlines = new AtomicReferenceArray(this.airlinesInfoServices.getAvailableAirlines().toArray());
	}


//	SELECT DISTINCT f1.origin,  f1.destination, 0 as stops, f1.cost
//	FROM flights f1
//		union
//	SELECT DISTINCT f1.origin,  f2.destination, 1 as stops, f1.cost + f2.cost
//	FROM flights f1
//	JOIN flights f2 ON f1.destination = f2.origin
//
//	UNION SELECT DISTINCT f1.origin, f3.destination,2 as stops, f1.cost + f2.cost + f3.cost  FROM flights f1 JOIN flights f2 ON f2.origin = f1.destination JOIN flights f3 ON f2.destination = f3.origin;
	@Override
	public int getCheapestTicketPrice(String originAirport, String destinationAirport) {


		ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<String, Integer>();

		AtomicInteger valueMin = new AtomicInteger(Integer.MAX_VALUE);
		for (int i = 0; i < airlines.length(); i++) {

			concurrentHashMap.put((String) airlines.get(0),
				this.airlinesInfoServices.getTicketPrice((String) airlines.get(0), originAirport, destinationAirport));

		}
		Optional<Map.Entry<String, Integer>> x = concurrentHashMap.entrySet().stream().min(Map.Entry.<String, Integer>comparingByValue()
			.thenComparing(Map.Entry::getValue));
		return x.isPresent() ? x.get().getValue() : -1;
	}
}
