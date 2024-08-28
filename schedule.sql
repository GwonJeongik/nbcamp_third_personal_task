drop table if exists test_schedule;
create table test_schedule
(
    schedule_id          bigint auto_increment,
    name        varchar(10),
    task_title  varchar(10),
    task        varchar(50),
    save_date   datetime,
    update_date datetime,
    primary key (schedule_id)
);

drop table if exists test_comment;
create table test_comment
(
comment_id          bigint auto_increment,
author        varchar(10),
content        varchar(50),
create_date   datetime,
update_date datetime,
schedule_id bigint,
primary key (comment_id),
foreign key (schedule_id) references test_schedule(schedule_id)
);
