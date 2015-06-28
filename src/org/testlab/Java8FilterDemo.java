package org.testlab;

import java.math.*;
import java.time.*;
import java.util.*;

/**
 * Simple Java value class to represent a deal
 * 
 */
class Deal {
	public enum Type {
		BOOK, ELECTRONIC, TRAVEL, COSMATIC, ACTIVITY
	}

	private final String provider;
	private final Type type;
	private final BigDecimal price;
	private final BigDecimal discount;
	private final String title;
	private final LocalDate validity;

	public Deal(String provider, Type type, BigDecimal price, BigDecimal discount, String title, LocalDate validity) {
		this.provider = provider;
		this.type = type;
		this.price = price;
		this.discount = discount;
		this.title = title;
		this.validity = validity;
	}

	public String provider() {
		return provider;
	}

	public Type type() {
		return type;
	}

	public BigDecimal price() {
		return price;
	}

	public BigDecimal discount() {
		return discount;
	}

	public String title() {
		return title;
	}

	public LocalDate validity() {
		return validity;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(title).append(" from ").append(provider).append(", price : ").append(price).append(
				", offer valid till ").append(validity).append(" category : ").append(type);
		return sb.toString();
	}
}

/**
 * Java 8 Example to filter Collection on Predicates using Stream API. this
 * program also uses new Date and Time API, lambdas, method reference etc.
 * 
 * @author Javin Paul
 */
public class Java8FilterDemo {

	public static void main(String args[]) {
		List<Deal> deals = loadDeals();
		System.out.println("All Deals");
		System.out.println("--------------------------------");
		// this will print all deals from list
		deals.forEach(System.out::println);
		System.out.println(deals.stream().count());
		System.out.println("--------------------------------");
		// Filtering elements from a Collectionin Java 8
		// filtering on category
		System.out.println("All deals for Electornic items");
		deals.stream().filter(deal -> deal.type() == Deal.Type.ELECTRONIC).forEach(System.out::println);
		System.out.println("--------------------------------");
		// filter all deals which are expiring on March
		System.out.println("Deals expiring on March");
		deals.stream().filter(deal -> deal.validity().getMonth() == Month.MARCH).forEach(System.out::println);
		System.out.println("--------------------------------");
		// filter all deals which has more than 30% discount
		System.out.println("All deals with 30% or more discount");
		deals.stream().filter(deal -> deal.discount().compareTo(new BigDecimal("00.30")) > 0).forEach(
				System.out::println);
		System.out.println("--------------------------------");
		// filter all deals from companies
		System.out.println("All deals from Apple");
		deals.stream().filter(deal -> deal.provider().equalsIgnoreCase("Apple")).forEach(System.out::println);
		System.out.println("--------------------------------");
	}

	private static List<Deal> loadDeals() {
		List<Deal> deals = new ArrayList<>();
		deals.add(new Deal("Manning", Deal.Type.BOOK, new BigDecimal("30.00"), new BigDecimal(".50"),
				"Save 50% on Java 8 Books", LocalDate.of(2014, Month.MARCH, 20)));
		deals.add(new Deal("Amazon", Deal.Type.BOOK, new BigDecimal("20.00"), new BigDecimal(".20"),
				"Save 20% on Clean Code", LocalDate.of(2014, Month.FEBRUARY, 10)));
		deals.add(new Deal("Kathy Pacific", Deal.Type.TRAVEL, new BigDecimal("300.00"), new BigDecimal(".40"),
				"Save 40% on flight to USA", LocalDate.of(2014, Month.FEBRUARY, 19)));
		deals.add(new Deal("Luftanse", Deal.Type.TRAVEL, new BigDecimal("30.00"), new BigDecimal(".50"),
				"Save 50% on flight to Berlin", LocalDate.of(2014, Month.MARCH, 27)));
		deals.add(new Deal("Trekking", Deal.Type.ACTIVITY, new BigDecimal("400.00"), new BigDecimal(".50"),
				"Save 50% on Trekking", LocalDate.of(2014, Month.MARCH, 25)));
		deals.add(new Deal("Apple", Deal.Type.ELECTRONIC, new BigDecimal("800.00"), new BigDecimal(".10"),
				"10% discount on iPhone 5S", LocalDate.of(2014, Month.APRIL, 19)));
		deals.add(new Deal("Samsung", Deal.Type.ELECTRONIC, new BigDecimal("700.00"), new BigDecimal(".20"),
				"20% discount on Galaxy S4", LocalDate.of(2014, Month.MARCH, 18)));
		deals.add(new Deal("LG", Deal.Type.ELECTRONIC, new BigDecimal("390.00"), new BigDecimal(".50"),
				"Save 40% on LG Smartphones", LocalDate.of(2014, Month.FEBRUARY, 17)));
		deals.add(new Deal("Sony", Deal.Type.ELECTRONIC, new BigDecimal("500.00"), new BigDecimal(".50"),
				"Save 50% on Sony Viao Laptops", LocalDate.of(2014, Month.APRIL, 10)));
		return deals;
	}
}
