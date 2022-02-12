package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void addProduct(Product product) {
        repo.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1]; // create with one more cell
                System.arraycopy(result, 0, tmp, 0, result.length); // add old elements
                tmp[tmp.length - 1] = product; // add new element
                result = tmp;
            }
        }
        return result; // if false of matches - empty array
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) { // если в параметре product лежит объект класса Book
            Book book = (Book) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            // проверим есть ли поисковое слово в данных об авторе или названии
            return book.getAuthor().contains(search) || book.getName().contains(search);
        }
        if (product instanceof Smartphone) { // если в параметре product лежит объект класса Smartphone
            Smartphone smartphone = (Smartphone) product; // положем его в переменную типа Smartphone чтобы пользоваться методами класса Book
            // проверим есть ли поисковое слово в данных о производителе или названии
            return smartphone.getManufacturer().contains(search) || smartphone.getName().contains(search);
        }
        return false;
    }
}
