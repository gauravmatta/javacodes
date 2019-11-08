create table page
(
name varchar(255) primary key,
content text not null,
published int default 0,
published_id varchar(255)
);