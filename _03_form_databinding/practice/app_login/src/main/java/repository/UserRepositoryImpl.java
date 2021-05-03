package repository;

import model.Login;
import model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class UserRepositoryImpl{

   private static List<User> list;

    static {
        list = new ArrayList<>();
        User user1 = new User();
        user1.setAccount("admin");
        user1.setPassword("123");
        user1.setName("Nguyen Thanh Cong");
        user1.setAge(31);
        user1.setEmail("sirrin1991@gmail.com");
        list.add(user1);

        User user2 = new User();
        user2.setAccount("dongtran");
        user2.setPassword("1234");
        user2.setName("Tran Hong Gia Dong");
        user2.setAge(26);
        user2.setEmail("dongtran@gmail.com");
        list.add(user2);

        User user3 = new User();
        user3.setAccount("khaho");
        user3.setPassword("1234");
        user3.setName("Ho Quang Kha");
        user3.setAge(31);
        user3.setEmail("khaho@gmail.com");
        list.add(user3);

        System.out.println(list);
    }


    public User checkLogin(Login login) {
        for (User user : list){
            if(user.getAccount().equals(login.getAccount())
                    && user.getPassword().equals(login.getPassword())){
                return user;
            }
        }
        return null;
    }

}
