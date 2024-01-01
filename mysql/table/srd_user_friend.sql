-- 交友
-- srd_user_friend
create table srd_user_friend
(
    id         bigint unsigned auto_increment comment '主键'
        primary key,
    user_id    bigint unsigned                      not null comment '用户主键',
    friend_id  bigint unsigned                      not null comment '好友',
    state      tinyint(1) default 0                 not null comment '对方是否同意',
    created_at timestamp  default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_at timestamp                            null comment '修改时间',
    constraint srd_user_friend_srd_user_id_fk
        foreign key (user_id) references srd_user (id)
            on delete cascade,
    constraint srd_user_friend_srd_user_id_fk_2
        foreign key (friend_id) references srd_user (id)
            on delete cascade
)
    comment '交友';