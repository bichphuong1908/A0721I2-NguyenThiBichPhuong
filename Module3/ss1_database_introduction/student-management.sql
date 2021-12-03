create database student_management;

use student_management;

create table class(
    id int,
    name varchar(50)
);

create table teacher(
    id int,
    name varchar(50),
    age smallint,
    country varchar(50)
);

select * from class;
select * from teacher;

create table `student`(
    id int NOT NULL,
    name varchar(45),
    age int NULL,
    country varchar(45)  
);
