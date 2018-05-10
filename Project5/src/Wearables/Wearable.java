package Wearables;

/**
 * Wearable -- creates a new wearable item used to describe a wearable product
 * @author Evan Kohout - project 5
 *
 */
public class Wearable {
	private int ranking;
	private String name;
	private double price;
	private String bodyLocation;
	private String category;
	private String companyName;
	private String companyURL;
	private String companyAddress;
	private String companyCity;
	private String companyState;
	private String companyCountry;
	
	/**
	 * generates a new wearable item
	 * @param ranking - rank of the item
	 * @param name - name of the wearable product
	 * @param price - price of the product
	 * @param bodyLocation - location where item is worn
	 * @param category - category item is part of
	 * @param companyName - company that produced the item
	 * @param companyURL - web address of the company
	 * @param companyAddress - address of the company
	 * @param companyCity - the city or locality of the company
	 * @param companyState - the state or providence of the company
	 * @param companyCountry - the country of origin of the company
	 */
	public Wearable(int ranking, String name, double price, String bodyLocation, String category, String companyName,
			String companyURL, String companyAddress, String companyCity, String companyState, String companyCountry) {
		this.ranking = ranking;
		this.name = name;
		this.price = price;
		this.bodyLocation = bodyLocation;
		this.category = category;
		this.companyName = companyName;
		this.companyURL = companyURL;
		this.companyAddress = companyAddress;
		this.companyCity = companyCity;
		this.companyState = companyState;
		this.companyCountry = companyCountry;
	}

	///////////////////////////////////////
	// GETTERS
	///////////////////////////////////////

	public int getRanking() {
		return ranking;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getBodyLocation() {
		return bodyLocation;
	}

	public String getCategory() {
		return category;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getCompanyURL() {
		return companyURL;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public String getCompanyCity() {
		return companyCity;
	}

	public String getCompanyState() {
		return companyState;
	}

	public String getCompanyCountry() {
		return companyCountry;
	}

	@Override
	public String toString() {
		return "Wearable [ranking=" + ranking + ", name=" + name + ", price=" + price + ", bodyLocation=" + bodyLocation
				+ ", category=" + category + ", companyName=" + companyName + ", companyURL=" + companyURL
				+ ", companyAddress=" + companyAddress + ", companyCity=" + companyCity + ", companyState="
				+ companyState + ", companyCountry=" + companyCountry + "]";
	}

}
