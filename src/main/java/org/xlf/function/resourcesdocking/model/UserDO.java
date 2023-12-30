package org.xlf.function.resourcesdocking.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * <h1>UserDO 自定义实体类</h1>
 * <hr/>
 * 数据表 srd_user
 *
 * @author 筱锋xiao_lfeng
 * @version v1.0.0
 * @since v1.0.0
 */
@Getter
@Setter
public class UserDO {
    private Long id;
    private String username;
    private String nickname;
    private String email;
    private Integer telCountryArea;
    private String tel;
    private Boolean verify;
    private String password;
    private String oldPassword;
    private Long ram;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Boolean ban;
    private String contactQq;
    private String contactWechat;
    private String contactOrganization;
}
