package cn.group17.service.user;

import cn.group17.model.UserDomain;

import org.springframework.stereotype.Service;
/**
 *  .
 */
@Service
public interface UserService {

    /**
     * @Author: group17
     * @Description: 更改用户信息
     * @Date: 2021/4/20
     * @param user
     */
    int updateUserInfo(UserDomain user);

    /**
     * @Author: group17
     * @Description: 根据主键编号获取用户信息
     * @Date: 2021/4/20
     * @param uId 主键
     */
    UserDomain getUserInfoById(Integer uId);


    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    UserDomain login(String username, String password);

}
