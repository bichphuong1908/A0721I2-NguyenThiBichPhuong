-- Yêu cầu 1: Tạo database
-- tên bảng, thuộc tính, database tất cả đều phải theo quy tắc snake_case
create database demo_a07;
-- Sử dụng database demo_a07 để thực hiện truy vấn.
use demo_a07;

-- yêu cầu 2: Tạo table sinh viên có các thuộc tính: mã sinh viên, tên sinh viên, ngày sinh
create table sinh_vien(
ma_sinh_vien int,
ten_sinh_vien varchar(70),-- 70 là số lượng kí tự tối đa
ngay_sinh date,
primary key(ma_sinh_vien)
);

-- Hiển thị table sinh viên có dữ liệu như thế nao
-- * hiển thị tất cả thông tin
select * from sinh_vien;

-- Yêu cầu 3 xóa bảng và xóa DB
drop table sinh_vien;
drop database demo_a07;

-- Yêu cầu 4: Thêm dữ liệu
-- Thêm đầy đủ thông tin
insert into sinh_vien values(1, "Truong Tan Hai", "1998-01-01");

-- Thêm thiếu thông tin
insert into sinh_vien(ma_sinh_vien,ten_sinh_vien) values(2,"TrungDP");

insert into sinh_vien(ma_sinh_vien,ten_sinh_vien) values(3,"TrungDC")
,(4,"TienNVT"),(5,"ChienTM");

-- Yêu cầu 5: Thay đổi cấu trúc của bảng
-- first nếu muốn thêm cột ở trước hoặc after để thêm vào sau 1 cột nào đó.
alter table sinh_vien add mo_ta text after ngay_sinh;

-- yêu cầu 6: cập nhật thông tin của 1 anh tên là TrungDC -> Ngày sinh.
-- Cập nhật/xóa 1 bản ghi dựa theo 1 điều kiện mà không phải là khóa chính -> lỗi không cập nhật được
set SQL_SAFE_UPDATES = 0;
update sinh_vien set ngay_sinh = "1995-01-01" 
where ten_sinh_vien = "TrungDC";

delete from sinh_vien where ten_sinh_vien = "TrungDP";
set SQL_SAFE_UPDATES = 1;

-- Truncate: DDL: xóa toàn bộ dữ liệu -> reset.
truncate table sinh_vien;