drop table if exists test_schedule;
create table test_schedule
(
    id          bigint auto_increment,
    name        varchar(10),
    task_title  varchar(10),
    task        varchar(50),
    save_date   datetime,
    update_date datetime,
    primary key (id)
);
