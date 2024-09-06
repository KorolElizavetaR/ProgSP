package laba2.shop;

import java.util.Objects;
import java.util.Optional;

import laba2.interf.Electronics;
import laba2.interf.implementation.ElectronicsImpl;

public class Product {
	Optional<ElectronicsImpl> electronics;
	Integer price;
	OrderStatus status;
	
	public Product()
	{
		setElectronics(null);
		setPrice(0);
		status = OrderStatus.INACTIVE;
	}
	
	public Product(ElectronicsImpl electronics, Integer price)
	{
		setElectronics(electronics);
		setPrice(price);
		status = OrderStatus.ACTIVE;
	}
	
	public Product(Product product)
	{
		setElectronics(product.getElectronics());
		setPrice(product.getPrice());
		setStatus(product.getStatus());
	}

	public ElectronicsImpl getElectronics() {
		return electronics.orElse(null);
	}

	public void setElectronics(ElectronicsImpl electronics) {
		this.electronics = Optional.ofNullable(electronics);
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(electronics, price, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(electronics, other.electronics) && Objects.equals(price, other.price)
				&& status == other.status;
	}

	@Override
	public String toString() {
		return "electronics = " + electronics + ", price=" + price + ", status=" + status;
	}
	
}
