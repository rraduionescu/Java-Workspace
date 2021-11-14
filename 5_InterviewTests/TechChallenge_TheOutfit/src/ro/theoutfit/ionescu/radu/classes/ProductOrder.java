package ro.theoutfit.ionescu.radu.classes;

public class ProductOrder
{
	private String orderId;
	private long productId;
	private String size;
	private String status;
	private String brand;

	public String getOrderId()
	{
		return orderId;
	}

	public long getProductId()
	{
		return productId;
	}

	public String getStatus()
	{
		return status;
	}

	public String getBrand()
	{
		return brand;
	}

	@Override
	public String toString()
	{
		return "Product{" +
				"orderId='" + orderId + '\'' +
				", productId=" + productId +
				", size='" + size + '\'' +
				", status='" + status + '\'' +
				", brand='" + brand + '\'' +
				'}';
	}
}