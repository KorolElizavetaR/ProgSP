package laba2.shop;

import laba2.Objects.Computer;
import laba2.Objects.Kettle;

public class RangeOfProducts {
	private static RangeOfProducts instance;
	Product [] products;
	Integer size = 0;
	
	private RangeOfProducts()
	{
		products = new Product[] {
			new Product(new Kettle(100), 50),
			new Product(new Kettle(), 40),
			new Product(new Computer(220), 169),
			new Product()
		};
		size = products.length;
	}
	
	public static RangeOfProducts getInstance() 
	{
	        if (instance == null) 
	        {
	            instance = new RangeOfProducts();
	        }
	        return instance;
	}
	
	public Product GetProduct(Integer index) throws Exception
	{
		if (index >= size) throw new Exception();
		return products[index];
	}
	
	public Product [] getList()
	{
		return products;
	}
}
