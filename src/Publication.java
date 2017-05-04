import java.util.*;

public class Publication implements Comparable<Publication> {

	private Map<String, List<String>> attrMap;

	public Publication(String type) {
		attrMap = new HashMap<String, List<String>>();
		putAttribute(PubTypes.TagAttr.type.name(), type);
	}

	public List<String> getAttribute(String key) {
		return attrMap.get(key);
	}

	public void putAttribute(String key, String value) {
		if (!attrMap.containsKey(key)) {
			attrMap.put(key, new ArrayList<String>());
		}
		attrMap.get(key).add(value);
	}

	public String getAttributeString(String key) {
		String attr = "";
		if (getAttribute(key) != null) {
			attr = getAttribute(key).toString();
		}
		return attr.replace("[", "").replace("]", "");
	}

	@Override
	public int compareTo(Publication o) {
		String a = this.getAttribute(PubTypes.KEY).get(0);
		String b = o.getAttribute(PubTypes.KEY).get(0);
		return a.compareTo(b);
	}

	public int compareTo(String key) {
		String a = this.getAttribute(PubTypes.KEY).get(0);
		return a.compareTo(key);
	}

	public String printItem() {
		String output = "";
		for (Map.Entry<String, List<String>> entry : attrMap.entrySet()) {
			output += "<tr>";
			String key = entry.getKey();
			output += "<td>" + key + "</td>";
			output += "<td>" + getAttributeString(key) + "</td>";
			output += "</tr>";
		}

		return output;
	}

}
