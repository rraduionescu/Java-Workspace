package ro.theoutfit.ionescu.radu.classes;

// @author Radu Ionescu

public class ProductOrder
{
	private String orderId;
	private long productId;
	private String size;
	private String status;
	private String brand;

	public ProductOrder(String orderId, long productId, String size, String status, String brand)
	{
		this.orderId   = orderId;
		this.productId = productId;
		this.size      = size;
		this.status    = status;
		this.brand     = brand;
	}

	public String getOrderId()
	{
		return orderId;
	}

	public void setOrderId(String orderId)
	{
		this.orderId = orderId;
	}

	public long getProductId()
	{
		return productId;
	}

	public void setProductId(long productId)
	{
		this.productId = productId;
	}

	public String getSize()
	{
		return size;
	}

	public void setSize(String size)
	{
		this.size = size;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
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