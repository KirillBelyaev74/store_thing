create table brand(
    id serial primary key,
    brand varchar(50) unique not null
);

create table category(
    id serial primary key,
    category varchar(50) unique not null
);

create table size(
    id serial primary key,
    size varchar(5) unique not null
);

create table things(
    id serial primary key,
    brand_id int,
    category_id int,
    size_id int,
    description varchar(200),
    price bigint,
    foreign key (brand_id) references brand(id),
    foreign key (category_id) references category(id),
    foreign key (size_id) references size(id)
);