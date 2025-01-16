import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

// TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
    //  Product
    Product product1 = new Product(1L, "Book A", "Books", 120.0);
    Product product2 = new Product(2L, "Book B", "Books", 80.0);
    Product product3 = new Product(3L, "Toy A", "Baby", 50.0);
    Product product4 = new Product(4L, "Toy B", "Boys", 70.0);
    Product product5 = new Product(5L, "Book C", "Books", 150.0);

    //
    List<Product> productList = new ArrayList<>();
    productList.add(product1);
    productList.add(product2);
    productList.add(product3);
    productList.add(product4);
    productList.add(product5);

    //
    System.out.println("Product List:");
    productList.forEach(System.out::println);

    //

    //  Customer
    Customer customer1 = new Customer(1L, "Alice", 1);
    Customer customer2 = new Customer(2L, "Bob", 2);
    Customer customer3 = new Customer(3L, "Charlie", 2);

    //
    System.out.println("--------------------------------------------------");
    System.out.println("Customers:");
    System.out.println(customer1);
    System.out.println(customer2);
    System.out.println(customer3);
    //
    Order order1 =
        new Order(
            1L,
            "Delivered",
            LocalDate.of(2021, 2, 15),
            LocalDate.of(2021, 2, 20),
            Arrays.asList(product1, product2),
            customer1);

    Order order2 =
        new Order(
            2L,
            "Pending",
            LocalDate.of(2021, 3, 1),
            LocalDate.of(2021, 3, 5),
            Arrays.asList(product3),
            customer2);
    Order order3 =
        new Order(
            3L,
            "Cancelled",
            LocalDate.of(2021, 4, 1),
            LocalDate.of(2021, 4, 5),
            Arrays.asList(product1),
            customer3);

    //
    /* System.out.println("------------------------------------");
    System.out.println("Orders:");
    System.out.println(order1);
    System.out.println(order2);

    System.out.println("---------------------------------------");
    List<Product> filterdBook = productList.stream().filter(product -> product.getCategory().equalsIgnoreCase("Books"))
            .filter(product -> product.getPrice() > 100)
            .collect(Collectors.toList());
    System.out.println("Filtered Books (Price > 100):");
    filterdBook.forEach(System.out::println);
    System.out.println("---------------------------------------"); */
    //
    List<Order> orderList = new ArrayList<>();
    orderList.add(order1);
    orderList.add(order2);
    orderList.add(order3);

    /* List<Order> filteredOrders = orderList.stream().filter(order-> order.getProducts().stream().anyMatch(product->product.getCategory().equalsIgnoreCase("Baby"))).collect(Collectors.toList());
    System.out.println("Orders with 'Baby' products:");
    filteredOrders.forEach(System.out::println);
    System.out.println("---------------------------------------");

    List<Product> filteredBoys = productList.stream()
            .filter(product -> product.getCategory().equalsIgnoreCase("Boys"))
            .map(product -> new Product(
                    product.getId(),
                    product.getName(),
                    product.getCategory(),
                    product.getPrice() * 0.9))
            .collect(Collectors.toList());


    System.out.println("Filtered Boys (with 10% discount):");
    filteredBoys.forEach(System.out::println);



    System.out.println("---------------------------------------");
    List<Product> productsOrderedByTier2 = orderList.stream()
            .filter(order -> order.getCustomer().getTier() == 2)
            .filter(order -> order.getOrderDate().isAfter(LocalDate.of(2021, 1, 31)) &&
                    order.getOrderDate().isBefore(LocalDate.of(2021, 4, 2)))
            .flatMap(order -> order.getProducts().stream())
            .collect(Collectors.toList());

    //
    System.out.println("Products ordered by Tier 2 customers between 01-Feb-2021 and 01-Apr-2021:");
    productsOrderedByTier2.forEach(System.out::println);*/

    System.out.println("------Esercizio 1 ------------");
    Map<Customer, List<Order>> ordersGroupedByCustomer =
        orderList.stream().collect(Collectors.groupingBy(Order::getCustomer));
    ordersGroupedByCustomer.forEach(
        (customer, orders) -> {
          System.out.println("Customer: " + customer.getName());
          orders.forEach(order -> System.out.println("  Order ID: " + order.getId()));
        });
    System.out.println("------Esercizio 2 ------------");

    Map<Customer,Double> totalSpentByCustomer = orderList.stream()
                                                .collect(Collectors.groupingBy(Order::getCustomer,Collectors
                                                .summingDouble(order -> order.getProducts().stream().mapToDouble(Product::getPrice).sum())));

    totalSpentByCustomer.forEach((customer, total) -> {
      System.out.println("Customer: " + customer.getName() + ", Total Spent: " + total);
    });
    System.out.println("------Esercizio 3 ------------");
    Optional<Product> expensiveProduct = productList.stream().max(Comparator.comparing(Product::getPrice));
    System.out.println(expensiveProduct);
  }
}
