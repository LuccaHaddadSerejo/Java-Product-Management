package product;

public class ProductModel {
    private String barCode;
    private String name;
    private int priceInCents;
    private int stock;

    public ProductModel(String barCode) {
        this.barCode = barCode;
    }

    public String getBarCode() {
        return this.barCode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getPriceInCents() {
        return this.priceInCents;
    }

    public void setPriceInCents(int newPrice) {
        this.priceInCents = newPrice;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int newStock) {
        this.stock = newStock;
    }

    @Override
    public String toString() {
        return String.format("{id=%s, name='%s', priceInCents=%d, stock=%d}",
                barCode, name, priceInCents, stock);
    }
}
