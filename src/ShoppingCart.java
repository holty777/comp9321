import java.util.ArrayList;


public class ShoppingCart {
	
	private ArrayList<Publication> cart;
	
	public ShoppingCart(){
		cart = new ArrayList<Publication>();
	}
	
	public ArrayList<Publication> getCart() {
		return cart;
	}
	
	public void addToCart(Publication dtdEntry) {
		cart.add(dtdEntry);
		System.out.println(cart.size());
	}
	
	public void removeFromCart(String dtdKey) {
		for(int i=0;i<cart.size();i++){
			if(dtdKey.equals(cart.get(i).getAttribute(PubTypes.KEY).get(0))) {
				cart.remove(i);
				break;
			}
		}
	}

}
