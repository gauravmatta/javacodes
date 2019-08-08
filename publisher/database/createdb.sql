create table news_item
(
id integer primary key,
title text not null,
url text not null
);
create table sequence
(
next_value integer
);
insert into sequence value (1000);