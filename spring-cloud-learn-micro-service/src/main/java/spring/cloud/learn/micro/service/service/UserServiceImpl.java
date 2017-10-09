package spring.cloud.learn.micro.service.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author flsh
 * @version 1.0
 * @description
 * @date 2017/8/14
 * @since Jdk 1.8
 */
@Service
public class UserServiceImpl  {

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public Boolean createUser(User user) {
        return this.userMapper.insert(user) > 0;
    }


    public List<User> getAllUser() {
        return this.userMapper.selectAllUser();
    }


    public User getUserById(Long id) {
        return this.userMapper.selectByPrimaryKey(id);
    }


    public Boolean updateUser(Long id, User user) {
        return this.userMapper.updateByPrimaryKey(user) > 0;
    }


    public Boolean deleteUser(Long id) {
        return this.userMapper.deleteByPrimaryKey(id) >0;
    }


    public User getUserByName(String name) {
        User retVal = null;
        List<User> allUsers  = this.getAllUser();
        if (allUsers == null || allUsers.size() < 1)
            return null;

        for (User user:allUsers) {
            if(user.getName().equals(name)){
                retVal = user;
                break;
            }
        }
        return retVal;
    }
}
