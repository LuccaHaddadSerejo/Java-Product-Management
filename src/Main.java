import exceptions.NegativePriceException;
import exceptions.NotFoundException;
import exceptions.UniqueNameException;
import product.ProductController;
import product.ProductModel;

public class Main {
        private static int id = 0;

        public static void main(String[] args) {
                createProduct();
        }

        private static void createProduct() {
                ProductController controller = new ProductController();
                try {
                        setId(id + 1);
                        ProductModel newProduct = new ProductModel(getId());

                        newProduct.setName("Produto 1");
                        newProduct.setPriceInCents(500);
                        newProduct.setStock(25);
                        controller.create(newProduct);

                        controller.read();

                        controller.retrievePrice(getId());

                        setId(id + 1);
                        ProductModel novoProduto = new ProductModel(getId());

                        novoProduto.setName("Produto 1");
                        novoProduto.setPriceInCents(400);
                        novoProduto.setStock(50);
                        controller.create(novoProduto);

                        controller.read();

                        controller.retrievePrice(getId());
                } catch (UniqueNameException | NegativePriceException | NotFoundException e) {
                        System.err.println("Error creating product: " + e.getMessage());
                } catch (Exception e) {
                        System.err.println("Error: " + e.getMessage());
                }
        }

        private static void setId(int newId) {
                id = newId;
        }

        private static String getId() {
                return String.valueOf(id);
        }

}