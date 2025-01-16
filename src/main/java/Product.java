public class Product {
    private  long id ;
    private  String name;
    private  String category;
    private  double price;

    public Product(long id,String name,String category,double price){
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }
    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double setPrice(Double price) {
        this.price = price;
        return this.price;
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', category='" + category + "', price=" + price + "}";
    }
}
