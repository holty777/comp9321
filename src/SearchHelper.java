import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SearchHelper {

	List<Publication> dtdEntries;

	public SearchHelper(List<Publication> dtdEntries) {
		this.dtdEntries = dtdEntries;
	}

	public List<Publication> getAllEntries() {
		return dtdEntries;
	}

	public List<Publication> findEntries(Map<String, String[]> searchMap) {
		List<Publication> entries = new ArrayList<Publication>();
		String attribute = null;
		boolean matches = true;
		for (Publication entry : dtdEntries) {
			matches = true;
			for (Entry<String, String[]> pair : searchMap.entrySet()) {
				if (pair.getValue()[0].equals("")
						|| pair.getKey().equals("action"))
					continue;
				attribute = entry.getAttributeString(pair.getKey())
						.toLowerCase();
				for (String item : pair.getValue()) {
					if (attribute == null
							|| !attribute.contains(item.toLowerCase())) {
						matches = false;
						break;
					}
				}
			}
			if (matches)
				entries.add(entry);
		}
		return entries;
	}

	public Publication findEntry(String key) {
		
		int low = 0, high = dtdEntries.size() - 1;
		Publication entry = null;
		String entryKey = "";

		while (true) {
			entry = dtdEntries.get(low);
			entryKey = entry.getAttribute(PubTypes.KEY).get(0);
			if (low > high)
				return null;
			if ((entryKey).equals(key)) {
				return entry;
			}
			else {

				low = low + 1;
			}
		}
	}
}
