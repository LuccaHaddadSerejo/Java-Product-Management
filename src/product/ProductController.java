package product;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

import exceptions.NegativePriceException;
import exceptions.NotFoundException;
import exceptions.UniqueNameException;

public class ProductController {
    private ArrayList<ProductModel> products = new ArrayList<ProductModel>();

    private boolean checkName(String name) throws UniqueNameException {
        Stream<ProductModel> productStream = products.stream();
        Optional<ProductModel> product = productStream.filter(p -> p.getName().equals(name)).findFirst();

        if (product.isPresent()) {
            throw new UniqueNameException("Já existe um produto com este nome.");
        }

        return true;
    }

    private void checkValue(int value) throws NegativePriceException {
        if (value < 0) {
            throw new NegativePriceException("O preço do produto precisa ser positivo");
        }
    }

    private ProductModel checkBarCode(String barCode) throws NotFoundException {
        Stream<ProductModel> productStream = products.stream();
        Optional<ProductModel> product = productStream.filter(p -> p.getBarCode().equals(barCode)).findFirst();
        if (!product.isPresent()) {
            throw new NotFoundException("Produto não encontrado");
        }
        return product.get();
    }

    public String create(ProductModel payload) throws UniqueNameException, NegativePriceException {
        this.checkName(payload.getName());
        this.checkValue(payload.getPriceInCents());

        products.add(payload);
        System.out.println(String.format("Produto %1s adicionado", payload.getName()));
        return String.format("Produto %1s adicionado", payload.getName());
    }

    public ArrayList<ProductModel> read() {
        System.out.println(this.products);
        return this.products;
    }

    public int retrievePrice(String barCode) throws NotFoundException {
        ProductModel product = null;

        product = this.checkBarCode(barCode);

        System.out.println(product.getPriceInCents());
        return product.getPriceInCents();
    }
}