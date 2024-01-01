-- 交流
-- srd_talk
create table srd_talk
(
    id         bigint unsigned auto_increment
        primary key,
    user_id    bigint unsigned                     not null comment '用户主键',
    topic      bigint unsigned                     null comment '话题',
    talk       mediumtext                          not null comment '聊天',
    replay     bigint unsigned                     null comment '回复',
    created_at timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    constraint srd_talk_srd_talk_id_fk
        foreign key (replay) references srd_talk (id)
            on delete set null,
    constraint srd_talk_srd_topic_id_fk
        foreign key (topic) references srd_topic (id)
            on delete set null,
    constraint srd_talk_srd_user_id_fk
        foreign key (user_id) references srd_user (id)
            on delete cascade
)
    comment '交流';

