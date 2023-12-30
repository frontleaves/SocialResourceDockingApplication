package org.xlf.function.resourcesdocking.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.xlf.function.resourcesdocking.model.UserDO;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM srd_user WHERE username = #{username} LIMIT 1")
    UserDO getUserByUsername(String username);

    @Select("SELECT * FROM srd_user WHERE email = #{email} LIMIT 1")
    UserDO getUserByEmail(String email);

    @Select("SELECT * FROM srd_user WHERE id = #{id} LIMIT 1")
    UserDO getUserById(Long id);

    @Select("SELECT * FROM srd_user WHERE tel_country_area = #{country} AND tel = #{tel} LIMIT 1")
    UserDO getUserByTelephone(String country, String tel);
}
