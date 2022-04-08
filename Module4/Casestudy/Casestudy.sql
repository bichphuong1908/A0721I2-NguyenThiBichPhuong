CREATE DATABASE Study;

USE Study;

CREATE TABLE `position`(
position_id INT PRIMARY KEY AUTO_INCREMENT,
position_name VARCHAR(45)
);

CREATE TABLE education_degree (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45)
);

CREATE TABLE division (
division_id INT PRIMARY KEY AUTO_INCREMENT,
division_name VARCHAR(45)
);

CREATE TABLE `role`(
role_id INT PRIMARY KEY AUTO_INCREMENT,
role_name VARCHAR(255)
);

CREATE TABLE `user` (
username VARCHAR(255) PRIMARY KEY ,
`password` VARCHAR(255)
);

CREATE TABLE user_role (
role_id INT,
username VARCHAR(255), 
FOREIGN KEY (role_id) REFERENCES `role`(role_id),
FOREIGN KEY (username) REFERENCES `user`(username)
);

CREATE TABLE employee (
employee_id INT PRIMARY KEY AUTO_INCREMENT,
employee_name VARCHAR(45),
birthday DATE,
id_card VARCHAR(45),
salary DOUBLE,
phone VARCHAR(45),
email VARCHAR(45),
address VARCHAR(45),
position_id INT,
id INT,
division_id INT,
username VARCHAR(255),
FOREIGN KEY (position_id) REFERENCES `position`(position_id),
FOREIGN KEY (id) REFERENCES education_degree(id),
FOREIGN KEY (division_id) REFERENCES division(division_id),
FOREIGN KEY (username) REFERENCES `user`(username)
);

CREATE TABLE customer_type (
customer_type_id INT PRIMARY KEY AUTO_INCREMENT,
customer_type_name VARCHAR(45)
);

CREATE TABLE customer (
customer_id INT PRIMARY KEY AUTO_INCREMENT,
customer_type_id INT,
customer_name VARCHAR(45),
birthday DATE,
customer_gender BIT(1),
id_card VARCHAR(45),
phone VARCHAR(45),
email VARCHAR(45),
address VARCHAR(45),
FOREIGN KEY (customer_type_id) REFERENCES customer_type(customer_type_id)
);

CREATE TABLE rent_type (
rent_type_id INT PRIMARY KEY AUTO_INCREMENT,
rent_type_name VARCHAR(45)
);

CREATE TABLE service_type (
service_type_id INT PRIMARY KEY AUTO_INCREMENT,
service_type_name VARCHAR(45)
);

CREATE TABLE service (
service_id INT PRIMARY KEY AUTO_INCREMENT,
service_name VARCHAR(45),
service_area INT,
service_cost DOUBLE,
max_people INT,
rent_type_id INT,
service_type_id INT,
standard_room VARCHAR(45),
description_other_convenience VARCHAR(45),
pool_area DOUBLE,
number_of_floors INT,
FOREIGN KEY (rent_type_id) REFERENCES rent_type(rent_type_id),
FOREIGN KEY (service_type_id) REFERENCES service_type(service_type_id)
);

CREATE TABLE contract (
contract_id INT PRIMARY KEY AUTO_INCREMENT,
contract_start_date DATETIME,
contract_end_date DATETIME,
contract_deposit DOUBLE,
contract_total_money DOUBLE,
employee_id INT,
customer_id INT,
service_id INT,
FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
FOREIGN KEY (service_id) REFERENCES service(service_id)
);

CREATE TABLE attach_service (
attach_service_id INT PRIMARY KEY AUTO_INCREMENT,
attach_service_name VARCHAR(45),
attach_service_cost DOUBLE,
attach_service_unit INT,
attach_service_status VARCHAR(45)
);

