CREATE DATABASE baithi;
USE baithi;
CREATE TABLE product (
    id INT(3) NOT NULL AUTO_INCREMENT,
    name VARCHAR(120) NOT NULL,
    price double NOT NULL,
    quantity double NOT NULL,
    color varchar(20) Not Null,
    category varchar(100) Not Null,
    PRIMARY KEY (id)
);
select * from product;
insert into product(name, price, quantity, color, category) 
values('iPhone 11','799','12','Black','phone');
insert into product(name, price, quantity, color, category) 
values('iPhone 11 Pro','1100','15','Green','phone');

