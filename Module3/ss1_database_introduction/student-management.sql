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


