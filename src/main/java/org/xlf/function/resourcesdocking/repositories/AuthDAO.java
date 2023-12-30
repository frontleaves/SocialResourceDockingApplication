package org.xlf.function.resourcesdocking.repositories;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import org.xlf.function.resourcesdocking.mappers.UserMapper;
import org.xlf.function.resourcesdocking.model.UserDO;

/**
 * <h1>AuthDAO 认证数据访问对象</h1>
 * <hr/>
 * 用于访问认证相关数据
 *
 * @since v1.0.0
 * @version v1.0.0
 */
@Repository
@RequiredArgsConstructor
public class AuthDAO {
    /**
     * <h2>userMapper 用户映射器</h2>
     * <hr/>
     * 用于访问用户相关数据
     */
    private final UserMapper userMapper;

    /**
     * <h2>getUserByUsername 根据用户名获取用户信息</h2>
     * <hr/>
     * 用于根据用户名获取用户信息
     *
     * @param username 用户名
     * @return {@link UserDO}
     */
    public UserDO getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    /**
     * <h2>getUserByEmail 根据邮箱获取用户信息</h2>
     * <hr/>
     * 用于根据邮箱获取用户信息
     *
     * @param email 邮箱
     * @return {@link UserDO}
     */
    public UserDO getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    /**
     * <h2>getUserById 根据用户 ID 获取用户信息</h2>
     * <hr/>
     * 用于根据用户 ID 获取用户信息
     *
     * @param id 用户 ID
     * @return {@link UserDO}
     */
    public UserDO getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    /**
     * <h2>getUserByTelephone 根据手机号获取用户信息</h2>
     * <hr/>
     * 用于根据手机号获取用户信息
     *
     * @param tel 手机号
     * @return {@link UserDO}
     */
    public UserDO getUserByTelephone(String @NotNull [] tel) {
        return userMapper.getUserByTelephone(tel[0], tel[1]);
    }
}
