CREATE DATABASE module3;
USE module3;

CREATE TABLE chothue(
id  INT PRIMARY KEY AUTO_INCREMENT,
dien_tich DOUBLE,
trang_thai VARCHAR (100),
tang int,
loai_van_phong VARCHAR (100),
gia_cho_thue DOUBLE,
ngay_bat_dau DATE,
ngay_ket_thuc DATE
);

insert into chothue(dien_tich, trang_thai, tang, loai_van_phong, gia_cho_thue, ngay_bat_dau, ngay_ket_thuc )
values('100', 'trong', '2', 'cho thue', 2000000, '2020/11/20', '2021/11/25');
insert into chothue(dien_tich, trang_thai, tang, loai_van_phong, gia_cho_thue, ngay_bat_dau, ngay_ket_thuc )
values('240', 'trong', '5', 'tron ngoai', 5000000, '2020/04/03', '2020/10/03');
insert into chothue(dien_tich, trang_thai, tang, loai_van_phong, gia_cho_thue, ngay_bat_dau, ngay_ket_thuc )
values('250', 'trong', '10', 'cho thue', 5000000, '2020/04/03', '2020/10/03');

select * from chothue