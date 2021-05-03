package repository;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository {
    private static final Map<Integer,Product> map ;

    static {
        map = new HashMap<>();
        map.put(1,new Product(1,"Iphone 6",200,"Old","White"));
        map.put(2,new Product(2,"Iphone 7",300,"Old","White"));
        map.put(3,new Product(3,"Iphone 8",400,"New","Black"));
        map.put(4,new Product(4,"Iphone X",500,"New","Black"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public Product findById(int id) {
        return map.get(id);
    }

    @Override
    public void save(int id, Product product) {
        map.put(id,product);
    }

    @Override
    public void remove(int id) {
        map.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> list = new ArrayList<>();
        for(Map.Entry<Integer,Product> entry : map.entrySet()){
            if (entry.getValue().getName().contains(name)){
                list.add(entry.getValue());
            }
        }
        return list;
    }
}
