create table IF NOT EXISTS news_item
(
id integer primary key,
title text not null,
url text not null
);
create table IF NOT EXISTS customers
(
id integer primary key,
name text not null,
age integer
);
create table IF NOT EXISTS shirts
(
id integer primary key,
color text not null,
brand text not null,
customer_id integer
);
create table IF NOT EXISTS sequence
(
next_value integer
);
insert into sequence value (1000);