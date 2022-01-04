package com.spring.banhang.Client.cartbean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
	private int id;
	private String name;
	private String urlImage;
	private long price;
	private int quantily;
	private int quantilyInStock;	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public Item(int id, long price, int quantily) {
		super();
		this.id = id;
		this.price = price;
		this.quantily = quantily;
	}
	
	
}
