package repository;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private static final Map<Integer,Customer> map;

    static {
        map = new HashMap<>();
        map.put(1,new Customer(1,"Nguyen Thanh Cong","thanhcong@gmail.com","Da Nang"));
        map.put(2,new Customer(2,"Ho Quang Kha","quangkha@gmail.com","Da Nang"));
        map.put(3,new Customer(3,"Dinh Van Thang","thangdinh@gmail.com","Da Nang"));
        map.put(4,new Customer(4,"Nguyen Huy","huynguyen@gmail.com","Da Nang"));
        map.put(5,new Customer(5,"Le Duc Sang","sangle@gmail.com","Da Nang"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void save(Customer customer) {
        map.put(customer.getId(),customer);
    }

    @Override
    public Customer findById(int id) {
        return map.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        map.replace(id,customer);
    }

    @Override
    public void remove(int id) {
        map.remove(id);
    }
}
