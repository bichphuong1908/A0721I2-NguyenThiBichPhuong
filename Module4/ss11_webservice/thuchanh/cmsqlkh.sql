CREATE DATABASE cms1;
USE cms1;
CREATE TABLE customer(
    id INT(3) NOT NULL AUTO_INCREMENT,
    firstName varchar(220) Not Null,
    lastName varchar(220) Not Null,
    PRIMARY KEY (id)
);
select * from customer;
insert into customer(firstName, lastName) 
values('nguyen', 'phuong');
insert into customer(firstName, lastName) 
values('nguyen', 'phuc');
