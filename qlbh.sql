CREATE DATABASE qlbh;
USE qlbh;

create TABLE category(
	id int primary key auto_increment,
    name varchar(100) unique not null,
    status bit(1) default 1
);
create TABLE product(
	id int primary key auto_increment,
    name varchar(100) unique not null,
    price float check (price >0),
    category_id int not null,
    status bit(1) default 1,
    foreign key(category_id) references category(id)
);
INSERT INTO product(name,price,category_id,status) VALUE('Ao xin',100,1,1);