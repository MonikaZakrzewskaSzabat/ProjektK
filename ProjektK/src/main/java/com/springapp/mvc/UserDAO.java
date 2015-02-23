package com.springapp.mvc;

import java.util.List;
import com.springapp.mvc.User;

/**
 * Created by darsonss on 2015-01-03.
 */
public interface UserDAO {

    public void saveOrUpdate(User user);

    public void delete(Long id);

    public User get(Long id);

    public List<User> list();

    public String getPassword (User user);
}
