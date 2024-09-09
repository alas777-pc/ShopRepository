import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.NotFoundException;
import ru.netology.Product;
import ru.netology.ShopRepository;


public class ShopRepositoryTest {

    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(1, "Car", 2000);
    Product product2 = new Product(2, "Pen", 49);
    Product product3 = new Product(3, "Meet", 357);




    @Test
    public void shouldDeleteProductInRepository() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.removeById(1);

        Product[] expected = { product2, product3 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(56);
        });
    }

}