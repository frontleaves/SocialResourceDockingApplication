-- 文章
-- srd_article
create table srd_article
(
    id         bigint unsigned auto_increment comment '主键'
        primary key,
    user_type  tinyint unsigned                           not null comment '普通/组织/RAM',
    user_id    bigint unsigned                            not null comment '用户主键',
    title      varchar(50)                                not null comment '文章标题',
    classify   json                                       not null comment '文章类型',
    topic      bigint unsigned                            null comment '话题',
    `desc`     varchar(100)                               null comment '描述',
    article    longtext                                   not null comment '文章正文',
    state      tinyint unsigned default '0'               not null comment '状态',
    created_at timestamp        default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_at timestamp                                  null comment '更新时间',
    deleted_at timestamp                                  null comment '删除时间',
    constraint srd_article_srd_topic_id_fk
        foreign key (topic) references srd_topic (id)
            on delete set null
)
    comment '文章';