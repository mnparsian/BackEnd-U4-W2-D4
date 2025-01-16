public class Customer {

    private long id;
    private String name;
    private int tier;

    public Customer(long id,String name,int tier){
        this.id = id;
        this.name = name;
        this.tier = tier;
    }
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }

    @Override
    public String toString() {
        return "Customer{id=" + id + ", name='" + name + "', tier=" + tier + "}";
    }
}
