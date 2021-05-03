package repository;

import model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(int id);
    void save (int id , Product product);
    void remove(int id);
    List<Product> findByName(String name);
}
