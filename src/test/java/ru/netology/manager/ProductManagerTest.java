package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    // create products
    private Product physic = new Book(1, "Физика, 9 класс", 300, "Пёрышкин");
    private Product basePsychology = new Book(2, "Основы психологии", 600, "Сеченов");
    private Product worldHistory = new Book(3, "всеобщая история, 9 класс", 400, "Маэстро Евгений");
    private Product samsungS20SuperSurprise = new Smartphone(4, "samsungS20SuperSurprise", 15_000_000, "Китай");
    private Product apple213ProMaxUltra = new Smartphone(5, "apple213ProMaxUltra", 150_000_0000, "Китай");
    private Product xiaomiReadme500NoteMinus = new Smartphone(6, "xiaomiReadme500NoteMinus", 151_000_000, "Китай");
    private Product realMeWithFairyTailScreen = new Smartphone(7, "realMeWithFairyTailScreen", 152_000_000, "Китай");

    @BeforeEach
    public void sutUp() {
        manager.addProduct(physic);
        manager.addProduct(basePsychology);
        manager.addProduct(worldHistory);
        manager.addProduct(samsungS20SuperSurprise);
        manager.addProduct(apple213ProMaxUltra);
        manager.addProduct(xiaomiReadme500NoteMinus);
        manager.addProduct(realMeWithFairyTailScreen);

    }

    @Test
    public void shouldSearchInNotBookOrSmartphone(){

        Product laptop = new Product(8, "LenovoFil 3000", 400_000_000);

        manager.addProduct(laptop);

        // comparing results
        Product[] expected = {};
        Product[] actual = manager.searchBy("LenovoFil 3000");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAboutNothing(){
        ProductRepository repository = new ProductRepository();

        ProductManager manager = new ProductManager(repository);

        // comparing results
        Product[] expected = {};
        Product[] actual = manager.searchBy("Шоушенк");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacturer(){

        // comparing results
        Product[] expected = {samsungS20SuperSurprise, apple213ProMaxUltra, xiaomiReadme500NoteMinus, realMeWithFairyTailScreen};
        Product[] actual = manager.searchBy("Китай");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchByManufacturer(){

        // comparing results
        Product[] expected = {};
        Product[] actual = manager.searchBy("Корея");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchByAuthor(){

        // comparing results
        Product[] expected = {};
        Product[] actual = manager.searchBy("Александр Беляев");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor(){

        // comparing results
        Product[] expected = {worldHistory};
        Product[] actual = manager.searchBy("Маэстро Евгений");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByName(){

        // comparing results
        Product[] expected = {realMeWithFairyTailScreen};
        Product[] actual = manager.searchBy("realMeWithFairyTailScreen");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchBookByName(){

        // comparing results
        Product[] expected = {physic};
        Product[] actual = manager.searchBy("Физика, 9 класс");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchByName(){

        // comparing results
        Product[] expected = {};
        Product[] actual = manager.searchBy("Abra Cadabra and the magic Stick");
        assertArrayEquals (expected, actual);


    }
}