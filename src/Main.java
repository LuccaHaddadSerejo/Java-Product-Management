import exceptions.NegativePriceException;
import exceptions.NotFoundException;
import exceptions.UniqueNameException;
import product.ProductController;
import product.ProductModel;

public class Main {
        private int id = 0;

        public static void main(String[] args) {
                Main mainInstance = new Main();
                mainInstance.createProduct();
        }

        void createProduct() {
                ProductController controller = new ProductController();
                try {
                        this.setId(this.id + 1);
                        ProductModel newProduct = new ProductModel(this.getId());
                        ;

                        newProduct.setName("Produto 1");
                        newProduct.setPriceInCents(500);
                        newProduct.setStock(25);
                        controller.create(newProduct);

                        controller.read();

                        controller.retrievePrice(this.getId());

                        this.setId(this.id + 1);
                        ProductModel novoProduto = new ProductModel(this.getId());

                        novoProduto.setName("Produto 1");
                        novoProduto.setPriceInCents(400);
                        novoProduto.setStock(50);
                        controller.create(novoProduto);

                        controller.read();

                        controller.retrievePrice(this.getId());
                } catch (UniqueNameException | NegativePriceException | NotFoundException e) {
                        System.err.println("Error creating product: " + e.getMessage());
                } catch (Exception e) {
                        System.err.println("Error: " + e.getMessage());
                }
        }

        void setId(int newId) {
                this.id = newId;
        }

        String getId() {
                return String.valueOf(this.id);
        }

}