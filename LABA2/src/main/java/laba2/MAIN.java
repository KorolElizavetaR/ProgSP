package laba2;

import laba2.Objects.Computer;
import laba2.Objects.Kettle;
import laba2.shop.OrderStatus;
import laba2.shop.Product;
import laba2.shop.RangeOfProducts;

public class MAIN {

	public static void main(String[] args) throws Exception {
		RangeOfProducts products = RangeOfProducts.getInstance();
		System.out.println(products.GetProduct(2));
		System.out.println(products.GetProduct(2).getElectronics().isWorking());
		
		//equals
		System.out.print(products.GetProduct(0).getElectronics().equals(new Kettle(100)));
		System.out.println(" | " + products.GetProduct(1).getElectronics().equals(new Kettle(100)));
		
		//hash
		System.out.print(products.GetProduct(0).equals(new Product(new Kettle(100), 50)));
		System.out.println(" | " + products.GetProduct(1).equals(new Product(new Kettle(100), 50)));
		
		for (Product item : products.getList())
			System.out.println(item);
		
		//set
		products.GetProduct(3).setElectronics(new Computer());
		products.GetProduct(3).getElectronics().setVoltage(30);
		products.GetProduct(3).setStatus(OrderStatus.ACTIVE);
		products.GetProduct(3).setPrice(250);
		
		for (Product item : products.getList())
			System.out.println(item);
		
		// let's throw up something
		products.GetProduct(51);
	}

}
