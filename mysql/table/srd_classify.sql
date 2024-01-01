-- 分类
-- srd_classify
create table srd_classify
(
    id         int unsigned auto_increment comment '分类主键'
        primary key,
    name       varchar(10)                         not null comment '分类名字',
    created_at timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_at timestamp                           null comment '更新时间'
)
    comment '分类';