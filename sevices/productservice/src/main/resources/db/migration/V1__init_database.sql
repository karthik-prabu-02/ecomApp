create table if not exists category
(
    category_id integer not null primary key,
    description varchar(255),
    category_name varchar(255)
);
create table if not exists product
(
    product_id integer not null primary key,
    description varchar(255),
    product_name varchar(255),
    available_quantity double precision not null,
    price numeric(38, 2),
    category_id integer
        constraint categoryOfProduct references category
);
create sequence if not exists category_seq increment by 50;
create sequence if not exists product_seq increment by 50;
