package com.spring.banhang.Client.cartbean;

import java.util.ArrayList;

import lombok.ToString;

@ToString
public class Cart {
	private ArrayList<Item> cart;

	public Cart() {
		// TODO Auto-generated constructor stub
		cart = new ArrayList<Item>();
	}

	public void addItem(Item item) {
		if (cart.contains(item)) {
			Item item2 = cart.get(cart.indexOf(item));
			item2.setQuantily(item2.getQuantily() + item.getQuantily());
		} else {
			cart.add(item);
		}
	}

	public void deleteItem(Item item) {
		if (cart.contains(item)) {
			cart.remove(cart.indexOf(item));
		}
	}

	public void updateItem(Item item, int q) {
		if (q > 0) {
			if (cart.contains(item)) {
				Item item2 = cart.get(cart.indexOf(item));
				item2.setQuantily(q);
			}
		}
	}

	public Item getItemById(int id) {
		for (Item item : cart) {
			if (item.getId() == id) {
				return item;
			}
		}
		return null;
	}

	public int soLuongItiem() {
		return cart.size();
	}

	public double TongTien() {
		double tien = 0;
		for (Item item : cart) {
			tien += item.getPrice() * item.getQuantily();
		}
		return tien;
	}

	public int checkSoLuongCon() {
		for (Item item : cart) {
			if (item.getQuantily() > item.getQuantilyInStock()) {
				return -1;
			}
		}
		return 1;
	}

	public ArrayList<Item> getCart() {
		return cart;
	}
}
