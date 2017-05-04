import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PagingHelper {

	private static int PAGE_SIZE = 10;

	List<Publication> dtdEntries;

	private int startNo;

	private boolean start;
	private boolean end;

	public PagingHelper(String page) {
		this.dtdEntries = new ArrayList<Publication>();
		start = true;
		end = true;
	}

	public void setResults(List<Publication> results) {
		dtdEntries = results;
		startNo = -PAGE_SIZE;

		start = true;
		end = (results.size() > 10);
	}

	public List<Publication> getCurPage() {
		int num_results = Math.min(startNo + PAGE_SIZE, dtdEntries.size());
		return dtdEntries.subList(startNo, num_results);
	}

	public List<Publication> getNextPage() {
		if (startNo == dtdEntries.size()) {
			return getPrevPage();
		} else if (startNo + PAGE_SIZE > dtdEntries.size()) {
			return dtdEntries.subList(startNo, dtdEntries.size());
		}

		startNo += PAGE_SIZE;
		int num_results = Math.min(startNo + PAGE_SIZE, dtdEntries.size());

		start = getCurPageNo() == 1;
		end = getCurPageNo() == getNoPages();
		return dtdEntries.subList(startNo, num_results);
	}

	public List<Publication> getPrevPage() {
		startNo = Math.max(startNo - PAGE_SIZE, 0);
		int endIndex = Math.min(startNo + 10, dtdEntries.size());

		start = getCurPageNo() == 1;
		end = getCurPageNo() == getNoPages();

		return dtdEntries.subList(startNo, endIndex);
	}

	public int getCurPageNo() {
		return (int) Math.ceil((startNo + PAGE_SIZE) / (double) PAGE_SIZE);
	}

	public int getNoPages() {
		if (dtdEntries.size() <= 10) {
			return 1;
		}
		return (int) Math.ceil(dtdEntries.size() / 10) + 1;
	}

	public boolean isStart() {
		return start;
	}

	public boolean isEnd() {
		return end;
	}
	
	public List<Publication> getRandTen(){
		List<Publication> newList = dtdEntries;
		Collections.shuffle(newList);
		return newList.subList(0,10);
	}
}
