CREATE DATABASE thi;
USE thi;
CREATE TABLE mat_bang (
id INT PRIMARY KEY AUTO_INCREMENT,
dien_tich double,
trang_thai varchar(100),
tang int,
loai_van_phong varchar(100),
gia_cho_thue double,
ngay_bat_dau date,
ngay_ket_thuc date
);
select * from mat_bang;
insert into mat_bang(dien_tich, trang_thai, tang, loai_van_phong, gia_cho_thue, ngay_bat_dau, ngay_ket_thuc) 
values('100','trống','2','cho thuê','2000000','2020/11/10','2021/11/25');
insert into  mat_bang(dien_tich, trang_thai, tang, loai_van_phong, gia_cho_thue, ngay_bat_dau, ngay_ket_thuc) 
values('240','trống','5','trọn gói','5000000','2020/04/03','2020/10/03');

