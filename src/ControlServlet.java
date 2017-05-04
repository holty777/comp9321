import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xml.sax.SAXException;

/**
 * Servlet implementation class ControlServlet
 */
@WebServlet(urlPatterns = "/search", displayName = "search")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SearchHelper searchHelper;
	private PagingHelper resultsPager;
	private PagingHelper checkoutPager;

	private String SEARCH_PAGE = "search.jsp";
	private String RESULTS_PAGE = "results.jsp";
	private String ITEM_PAGE = "item.jsp";
	private String POP_ITEM_PAGE = "pop_item.jsp";
	private String CHECKOUT_PAGE = "checkout.jsp";
	private String ADV_PAGE = "advanced_search.jsp";
	
	public ShoppingCart finalCart = new ShoppingCart();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();

		InputStream is = getServletContext().getResourceAsStream(
				"/WEB-INF/dblp.xml");
		XMLParser parser;
		try {
			parser = new XMLParser(is);
		} catch (SAXException e) {
			
			throw new ServletException(e);
		}

		List<Publication> dtdEntriesFull = parser.getDTDEntries();
		Collections.shuffle(dtdEntriesFull);
		List<Publication> dtdEntries = dtdEntriesFull.subList(0, 20000);
		
		searchHelper = new SearchHelper(dtdEntries);
		resultsPager = new PagingHelper(RESULTS_PAGE);
		checkoutPager = new PagingHelper(CHECKOUT_PAGE);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String nextPage = "";
		if (action == null) {
			resultsPager.setResults(searchHelper.findEntries(request
					.getParameterMap()));
			getServletContext().setAttribute("types",
					PubTypes.TagType.values());
			getServletContext().setAttribute("fields",
					PubTypes.TagAttr.values());
			getServletContext().setAttribute("rand",
					resultsPager.getRandTen());
			nextPage = SEARCH_PAGE;
		} else if (action.equals("search")) {
			resultsPager.setResults(searchHelper.findEntries(request
					.getParameterMap()));
			getServletContext().setAttribute("types",
					PubTypes.TagType.values());
			getServletContext().setAttribute("items",
					resultsPager.getNextPage());
			getServletContext().setAttribute("results", resultsPager);
			nextPage = RESULTS_PAGE;
			System.out.println(nextPage);

		} else if (action.equals("advanced")) {
			resultsPager.setResults(searchHelper.findEntries(request
					.getParameterMap()));
			getServletContext().setAttribute("types",
					PubTypes.TagType.values());
			getServletContext().setAttribute("items",
					resultsPager.getNextPage());
			getServletContext().setAttribute("results", resultsPager);
			nextPage = ADV_PAGE;
			System.out.println(nextPage);

		}else if (action.equals("results")) {
			getServletContext().setAttribute("items",
					resultsPager.getCurPage());
			getServletContext().setAttribute("results", resultsPager);
			nextPage = RESULTS_PAGE;
		} else if (action.equals("forward")) {
			PagingHelper ps = (PagingHelper) getServletContext()
					.getAttribute("results");
			getServletContext().setAttribute("items", ps.getNextPage());
			nextPage = RESULTS_PAGE;
		} else if (action.equals("backward")) {
			PagingHelper ps = (PagingHelper) getServletContext()
					.getAttribute("results");
			getServletContext().setAttribute("items", ps.getPrevPage());
			nextPage = RESULTS_PAGE;
		} else if (action.equals("add")) {
			if (request.getSession().getAttribute("cart") == null) {
				request.getSession().setAttribute("cart", new ShoppingCart());
			}
			ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
			String key = request.getParameter("key").replaceAll("_", "/");
			cart.addToCart(searchHelper.findEntry(key));
			nextPage = ITEM_PAGE;
		} else if (action.equals("addpop")) {
			if (request.getSession().getAttribute("cart") == null) {
				request.getSession().setAttribute("cart", new ShoppingCart());
			}
			ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
			String key = request.getParameter("key").replaceAll("_", "/");
			cart.addToCart(searchHelper.findEntry(key));
			nextPage = POP_ITEM_PAGE;
		} else if (action.equals("remove")) {
			ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
			cart.removeFromCart(request.getParameter("key").replaceAll("_", "/"));
			getServletContext().setAttribute("items", cart.getCart());
			nextPage = CHECKOUT_PAGE;
		} else if (action.equals("item")) {
			
			String key = request.getParameter("key").replaceAll("_", "/");
			getServletContext().setAttribute("item",
					searchHelper.findEntry(key));
			nextPage = ITEM_PAGE;
		} else if (action.equals("checkout")) {
			ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
			if (cart != null){
				checkoutPager.setResults(cart.getCart());
				getServletContext().setAttribute("results", checkoutPager);
				getServletContext().setAttribute("items", checkoutPager.getNextPage());

				
			} else {
				getServletContext().setAttribute("items", null);
			}
			nextPage = CHECKOUT_PAGE;
		} else if(action.equalsIgnoreCase("popitem")){
			String key = request.getParameter("key").replaceAll("_", "/");
			getServletContext().setAttribute("item",
					searchHelper.findEntry(key));
			nextPage = POP_ITEM_PAGE;
		}

		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
