package ro.theoutfit.ionescu.radu.main;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ro.theoutfit.ionescu.radu.classes.ProductOrder;
import ro.theoutfit.ionescu.radu.http.HttpConnection;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		try
		{
			// GET Request
			String response = HttpConnection.getResponse();
			if(!response.equals("GET request failed!"))
			{
				// Bind JSON data to ProductOrder objects
				Gson gson = new Gson();
				Type productListType = new TypeToken<ArrayList<ProductOrder>>(){}.getType();
				ArrayList<ProductOrder> productsOrders = gson.fromJson(response, productListType);

				HashMap<String, ArrayList<Long>>   orders   = new HashMap<>();
				HashMap<Long, ArrayList<String>>   products = new HashMap<>();
				HashMap<String, ArrayList<String>> brands   = new HashMap<>();

				long soldProducts = 0;

				for(ProductOrder productOrder : productsOrders)
				{
					// Total number of sold products
					if(productOrder.getStatus().equals("VANDUT"))
					{
						soldProducts++;
					}

					// Product ids & statuses
					ArrayList<String> statuses;
					if(!products.containsKey(productOrder.getProductId()))
					{
						statuses = new ArrayList<>();
						statuses.add(productOrder.getStatus());
						products.put(productOrder.getProductId(), statuses);
					}
					else
					{
						statuses = products.get(productOrder.getProductId());
						statuses.add(productOrder.getStatus());
					}

					// Order ids & product ids
					ArrayList<Long> productIds;
					if(!orders.containsKey(productOrder.getOrderId()))
					{
						productIds = new ArrayList<>();
						productIds.add(productOrder.getProductId());
						orders.put(productOrder.getOrderId(), productIds);
					}
					else
					{
						productIds = orders.get(productOrder.getOrderId());
						productIds.add(productOrder.getProductId());
					}

					// Brands & statuses
					if(!brands.containsKey(productOrder.getBrand().toUpperCase()))
					{
						statuses = new ArrayList<>();
						statuses.add(productOrder.getStatus());
						brands.put(productOrder.getBrand().toUpperCase(), statuses);
					}
					else
					{
						statuses = brands.get(productOrder.getBrand().toUpperCase());
						statuses.add(productOrder.getStatus());
					}
				}

				// Display ORDERS & PRODUCT IDS
				System.out.println("========================================== ORDERS & PRODUCT IDS ==========================================");
				orders.forEach((orderId, productIds)->System.out.println("Order #" + orderId + " -> " + "Products " + productIds));

				// Display PRODUCTS & STATUSES
				System.out.println("\n=========================================== PRODUCTS & STATUSES ===========================================");
				products.forEach((productId, statuses)->System.out.println("Product #" + productId + " -> " + statuses));

				// Display BRANDS & STATUSES
				System.out.println("\n============================================ BRANDS & STATUSES ============================================");
				brands.forEach((brand, statuses)->System.out.println(brand + " -> " + statuses));

				// Calculate product sales probabilities
				HashMap<Long, Double> productProbabilities = new HashMap<>();
				products.forEach((productId, statuses)->
				{
					double sold = 0;
					for(String status : statuses)
					{
						if(status.equals("VANDUT"))
						{
							sold++;
						}
					}
					Double probability = sold / statuses.size();
					if(statuses.size() > 5)
					{
						productProbabilities.put(productId, probability);
					}
				});

				// Sort product sales probabilities
				Comparator<Map.Entry<Long, Double>> productProbabilityComparator = (e1, e2)->
				{
					Double v1 = e1.getValue();
					Double v2 = e2.getValue();

					return -v1.compareTo(v2);
				};
				ArrayList<Map.Entry<Long, Double>> sortedProductProbabilities = new ArrayList<>(productProbabilities.entrySet());
				sortedProductProbabilities.sort(productProbabilityComparator);

				// Display PRODUCTS SALES PROBABILITIES (ordered more than five times - SORTED)
				System.out.println("\n===================== PRODUCTS SALES PROBABILITIES (ordered more than five times - SORTED) =====================");
				for(Map.Entry<Long, Double> entry : sortedProductProbabilities)
				{
					System.out.printf("Product #%d -> P = %.2f%%%n", entry.getKey(), entry.getValue() * 100);
				}

				// Calculate brand sales probabilities
				HashMap<String, Double> brandProbabilities = new HashMap<>();
				brands.forEach((brand, statuses)->
				{
					double sold = 0;
					for(String status : statuses)
					{
						if(status.equals("VANDUT"))
						{
							sold++;
						}
					}
					Double probability = sold / statuses.size();
					brandProbabilities.put(brand, probability);
				});

				// Sort brand sales probabilities
				Comparator<Map.Entry<String, Double>> brandProbabilityComparator = (e1, e2)->
				{
					Double v1 = e1.getValue();
					Double v2 = e2.getValue();

					return -v1.compareTo(v2);
				};
				ArrayList<Map.Entry<String, Double>> sortedBrandProbabilities = new ArrayList<>(brandProbabilities.entrySet());
				sortedBrandProbabilities.sort(brandProbabilityComparator);

				// Display BRANDS SALES PROBABILITIES (SORTED)
				System.out.println("\n======================== BRANDS SALES PROBABILITIES (SORTED) ========================");
				for(Map.Entry<String, Double> entry : sortedBrandProbabilities)
				{
					System.out.printf("%s -> P = %.2f%%%n", entry.getKey(), entry.getValue() * 100);
				}

				System.out.println("\n=============================== RESULTS ===============================");
				// Average sold products per order
				System.out.printf("1. Average number of sold products per order : %.4f/order%n", (double)soldProducts / orders.size());
				// Top 10 products by sale probability (ordered more than 5 times)
				System.out.println("2. Top 10 products by sale probability (ordered more than 5 times)");
				for(int i = 0 ; i < 10 ; i++)
				{
					System.out.printf("\t%2d. Product #%d (%.2f%%)%n", (i + 1), sortedProductProbabilities.get(i).getKey(), sortedProductProbabilities.get(i).getValue() * 100);
				}
				// Top 3 brands by sale probability
				System.out.println("3. Top 3 brands by sale probability");
				for(int i = 0 ; i < 3 ; i++)
				{
					System.out.printf("\t%d. %s (%.2f%%)%n", (i + 1), sortedBrandProbabilities.get(i).getKey(), sortedBrandProbabilities.get(i).getValue() * 100);
				}
				System.out.println("=======================================================================");
			}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}