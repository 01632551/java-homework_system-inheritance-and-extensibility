package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    @Test
    public void shouldSearchInNotBookOrSmartphone(){
        ProductRepository repository = new ProductRepository();

        // create products
        Product physic = new Book(1, "Физика, 9 класс", 300, "Пёрышкин");
        Product basePsychology = new Book(2, "Основы психологии", 600, "Сеченов");
        Product worldHistory = new Book(3, "всеобщая история, 9 класс", 400, "Маэстро Евгений");
        Product samsungS20SuperSurprise = new Smartphone(4, "samsungS20SuperSurprise", 15_000_000, "Китай");
        Product apple213ProMaxUltra = new Smartphone(5, "apple213ProMaxUltra", 150_000_0000, "Китай");
        Product xiaomiReadme500NoteMinus = new Smartphone(6, "xiaomiReadme500NoteMinus", 151_000_000, "Китай");
        Product realMeWithFairyTailScreen = new Smartphone(7, "realMeWithFairyTailScreen", 152_000_000, "Китай");
        Product laptop = new Product(8, "LenovoFil 3000", 400_000_000);

        // save product
        ProductManager manager = new ProductManager(repository);
        manager.addProduct(physic);
        manager.addProduct(basePsychology);
        manager.addProduct(worldHistory);
        manager.addProduct(samsungS20SuperSurprise);
        manager.addProduct(apple213ProMaxUltra);
        manager.addProduct(xiaomiReadme500NoteMinus);
        manager.addProduct(realMeWithFairyTailScreen);
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
        ProductRepository repository = new ProductRepository();

        // create products
        Product physic = new Book(1, "Физика, 9 класс", 300, "Пёрышкин");
        Product basePsychology = new Book(2, "Основы психологии", 600, "Сеченов");
        Product worldHistory = new Book(3, "всеобщая история, 9 класс", 400, "Маэстро Евгений");
        Product samsungS20SuperSurprise = new Smartphone(4, "samsungS20SuperSurprise", 15_000_000, "Китай");
        Product apple213ProMaxUltra = new Smartphone(5, "apple213ProMaxUltra", 150_000_0000, "Китай");
        Product xiaomiReadme500NoteMinus = new Smartphone(6, "xiaomiReadme500NoteMinus", 151_000_000, "Китай");
        Product realMeWithFairyTailScreen = new Smartphone(7, "realMeWithFairyTailScreen", 152_000_000, "Китай");

        // save product
        ProductManager manager = new ProductManager(repository);
        manager.addProduct(physic);
        manager.addProduct(basePsychology);
        manager.addProduct(worldHistory);
        manager.addProduct(samsungS20SuperSurprise);
        manager.addProduct(apple213ProMaxUltra);
        manager.addProduct(xiaomiReadme500NoteMinus);
        manager.addProduct(realMeWithFairyTailScreen);

        // comparing results
        Product[] expected = {samsungS20SuperSurprise, apple213ProMaxUltra, xiaomiReadme500NoteMinus, realMeWithFairyTailScreen};
        Product[] actual = manager.searchBy("Китай");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchByManufacturer(){
        ProductRepository repository = new ProductRepository();

        // create products
        Product physic = new Book(1, "Физика, 9 класс", 300, "Пёрышкин");
        Product basePsychology = new Book(2, "Основы психологии", 600, "Сеченов");
        Product worldHistory = new Book(3, "всеобщая история, 9 класс", 400, "Маэстро Евгений");
        Product samsungS20SuperSurprise = new Smartphone(4, "samsungS20SuperSurprise", 15_000_000, "Китай");
        Product apple213ProMaxUltra = new Smartphone(5, "apple213ProMaxUltra", 150_000_0000, "Китай");
        Product xiaomiReadme500NoteMinus = new Smartphone(6, "xiaomiReadme500NoteMinus", 151_000_000, "Китай");
        Product realMeWithFairyTailScreen = new Smartphone(7, "realMeWithFairyTailScreen", 152_000_000, "Китай");

        // save product
        ProductManager manager = new ProductManager(repository);
        manager.addProduct(physic);
        manager.addProduct(basePsychology);
        manager.addProduct(worldHistory);
        manager.addProduct(samsungS20SuperSurprise);
        manager.addProduct(apple213ProMaxUltra);
        manager.addProduct(xiaomiReadme500NoteMinus);
        manager.addProduct(realMeWithFairyTailScreen);

        // comparing results
        Product[] expected = {};
        Product[] actual = manager.searchBy("Корея");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchByAuthor(){
        ProductRepository repository = new ProductRepository();

        // create products
        Product physic = new Book(1, "Физика, 9 класс", 300, "Пёрышкин");
        Product basePsychology = new Book(2, "Основы психологии", 600, "Сеченов");
        Product worldHistory = new Book(3, "всеобщая история, 9 класс", 400, "Маэстро Евгений");
        Product samsungS20SuperSurprise = new Smartphone(4, "samsungS20SuperSurprise", 15_000_000, "Китай");
        Product apple213ProMaxUltra = new Smartphone(5, "apple213ProMaxUltra", 150_000_0000, "Китай");
        Product xiaomiReadme500NoteMinus = new Smartphone(6, "xiaomiReadme500NoteMinus", 151_000_000, "Китай");
        Product realMeWithFairyTailScreen = new Smartphone(7, "realMeWithFairyTailScreen", 152_000_000, "Китай");

        // save product
        ProductManager manager = new ProductManager(repository);
        manager.addProduct(physic);
        manager.addProduct(basePsychology);
        manager.addProduct(worldHistory);
        manager.addProduct(samsungS20SuperSurprise);
        manager.addProduct(apple213ProMaxUltra);
        manager.addProduct(xiaomiReadme500NoteMinus);
        manager.addProduct(realMeWithFairyTailScreen);

        // comparing results
        Product[] expected = {};
        Product[] actual = manager.searchBy("Александр Беляев");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor(){
        ProductRepository repository = new ProductRepository();

        // create products
        Product physic = new Book(1, "Физика, 9 класс", 300, "Пёрышкин");
        Product basePsychology = new Book(2, "Основы психологии", 600, "Сеченов");
        Product worldHistory = new Book(3, "всеобщая история, 9 класс", 400, "Маэстро Евгений");
        Product samsungS20SuperSurprise = new Smartphone(4, "samsungS20SuperSurprise", 15_000_000, "Китай");
        Product apple213ProMaxUltra = new Smartphone(5, "apple213ProMaxUltra", 150_000_0000, "Китай");
        Product xiaomiReadme500NoteMinus = new Smartphone(6, "xiaomiReadme500NoteMinus", 151_000_000, "Китай");
        Product realMeWithFairyTailScreen = new Smartphone(7, "realMeWithFairyTailScreen", 152_000_000, "Китай");

        // save product
        ProductManager manager = new ProductManager(repository);
        manager.addProduct(physic);
        manager.addProduct(basePsychology);
        manager.addProduct(worldHistory);
        manager.addProduct(samsungS20SuperSurprise);
        manager.addProduct(apple213ProMaxUltra);
        manager.addProduct(xiaomiReadme500NoteMinus);
        manager.addProduct(realMeWithFairyTailScreen);

        // comparing results
        Product[] expected = {worldHistory};
        Product[] actual = manager.searchBy("Маэстро Евгений");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByName(){
        ProductRepository repository = new ProductRepository();

        // create products
        Product physic = new Book(1, "Физика, 9 класс", 300, "Пёрышкин");
        Product basePsychology = new Book(2, "Основы психологии", 600, "Сеченов");
        Product worldHistory = new Book(3, "всеобщая история, 9 класс", 400, "Маэстро Евгений");
        Product samsungS20SuperSurprise = new Smartphone(4, "samsungS20SuperSurprise", 15_000_000, "Китай");
        Product apple213ProMaxUltra = new Smartphone(5, "apple213ProMaxUltra", 150_000_0000, "Китай");
        Product xiaomiReadme500NoteMinus = new Smartphone(6, "xiaomiReadme500NoteMinus", 151_000_000, "Китай");
        Product realMeWithFairyTailScreen = new Smartphone(7, "realMeWithFairyTailScreen", 152_000_000, "Китай");

        // save product
        ProductManager manager = new ProductManager(repository);
        manager.addProduct(physic);
        manager.addProduct(basePsychology);
        manager.addProduct(worldHistory);
        manager.addProduct(samsungS20SuperSurprise);
        manager.addProduct(apple213ProMaxUltra);
        manager.addProduct(xiaomiReadme500NoteMinus);
        manager.addProduct(realMeWithFairyTailScreen);

        // comparing results
        Product[] expected = {realMeWithFairyTailScreen};
        Product[] actual = manager.searchBy("realMeWithFairyTailScreen");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchBookByName(){
        ProductRepository repository = new ProductRepository();

        // create products
        Product physic = new Book(1, "Физика, 9 класс", 300, "Пёрышкин");
        Product basePsychology = new Book(2, "Основы психологии", 600, "Сеченов");
        Product worldHistory = new Book(3, "всеобщая история, 9 класс", 400, "Маэстро Евгений");
        Product samsungS20SuperSurprise = new Smartphone(4, "samsungS20SuperSurprise", 15_000_000, "Китай");
        Product apple213ProMaxUltra = new Smartphone(5, "apple213ProMaxUltra", 150_000_0000, "Китай");
        Product xiaomiReadme500NoteMinus = new Smartphone(6, "xiaomiReadme500NoteMinus", 151_000_000, "Китай");
        Product realMeWithFairyTailScreen = new Smartphone(7, "realMeWithFairyTailScreen", 152_000_000, "Китай");

        // save product
        ProductManager manager = new ProductManager(repository);
        manager.addProduct(physic);
        manager.addProduct(basePsychology);
        manager.addProduct(worldHistory);
        manager.addProduct(samsungS20SuperSurprise);
        manager.addProduct(apple213ProMaxUltra);
        manager.addProduct(xiaomiReadme500NoteMinus);
        manager.addProduct(realMeWithFairyTailScreen);

        // comparing results
        Product[] expected = {physic};
        Product[] actual = manager.searchBy("Физика, 9 класс");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchByName(){
        ProductRepository repository = new ProductRepository();

        // create products
        Product physic = new Book(1, "Физика, 9 класс", 300, "Пёрышкин");
        Product basePsychology = new Book(2, "Основы психологии", 600, "Сеченов");
        Product worldHistory = new Book(3, "всеобщая история, 9 класс", 400, "Маэстро Евгений");
        Product samsungS20SuperSurprise = new Smartphone(4, "samsungS20SuperSurprise", 15_000_000, "Китай");
        Product apple213ProMaxUltra = new Smartphone(5, "apple213ProMaxUltra", 150_000_0000, "Китай");
        Product xiaomiReadme500NoteMinus = new Smartphone(6, "xiaomiReadme500NoteMinus", 151_000_000, "Китай");
        Product realMeWithFairyTailScreen = new Smartphone(7, "realMeWithFairyTailScreen", 152_000_000, "Китай");

        // save product
        ProductManager manager = new ProductManager(repository);
        manager.addProduct(physic);
        manager.addProduct(basePsychology);
        manager.addProduct(worldHistory);
        manager.addProduct(samsungS20SuperSurprise);
        manager.addProduct(apple213ProMaxUltra);
        manager.addProduct(xiaomiReadme500NoteMinus);
        manager.addProduct(realMeWithFairyTailScreen);

        // comparing results
        Product[] expected = {};
        assertArrayEquals (expected, manager.searchBy("Abra Cadabra and the magic Stick"));

        
    }
}