-- 评论
-- srd_comment
create table srd_comment
(
    id           bigint unsigned auto_increment comment '组件'
        primary key,
    comment_type int unsigned                        not null comment '评论类别',
    comment_id   bigint unsigned                     not null comment '对应评论类别的主键',
    user_type    tinyint(1)                          not null comment '用户类型',
    user_id      bigint unsigned                     not null comment '用户主键',
    comment      text                                not null comment '评论',
    replay       bigint unsigned                     null comment '回复',
    created_at   timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_at   timestamp                           null comment '修改时间',
    constraint srd_comment_srd_comment_id_fk
        foreign key (replay) references srd_comment (id)
            on delete cascade
)
    comment '评论';