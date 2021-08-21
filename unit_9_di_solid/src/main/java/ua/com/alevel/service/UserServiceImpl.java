package ua.com.alevel.service;

import org.diframework.annotation.BeanClass;
import org.diframework.annotation.InjectBean;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.entity.Transaction;
import ua.com.alevel.entity.User;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

@BeanClass
public class UserServiceImpl implements UserService {

    @InjectBean
    private UserDao userDao;

    @Override
    public void create(User user) {

        if (null == null) {
            System.out.println("null == null");
        }

        Double sum = user
                .getTransaction()
                .orElseThrow(() -> {
                    throw new RuntimeException("Transaction not found !!!");
                })
                .getAmount()
                .orElse(new BigDecimal("00.00"))
                .doubleValue();
        System.out.println("sum = " + sum);

//        Transaction transaction = user.getTransaction();
//        if (transaction != null) {
//            BigDecimal am = transaction.?getAmount().?get();
//            if (am != null) {
//                double d = am.doubleValue();
//            }
//        }

        List<User> users = findAll();
        boolean b = users.stream().noneMatch(u -> u.getEmail().equals(user.getEmail()));
        if (b) {
            userDao.create(user);
        }
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    public User findById(long id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
