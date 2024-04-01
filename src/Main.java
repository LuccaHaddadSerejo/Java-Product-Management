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
                        ProductModel productOne = new ProductModel(getId());

                        productOne.setName("Produto 1");
                        productOne.setPriceInCents(500);
                        productOne.setStock(25);
                        controller.create(productOne);

                        controller.read();

                        controller.retrievePrice(getId());

                        setId(id + 1);
                        ProductModel productTwo = new ProductModel(getId());

                        productTwo.setName("Produto 1");
                        productTwo.setPriceInCents(400);
                        productTwo.setStock(50);
                        controller.create(productTwo);

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