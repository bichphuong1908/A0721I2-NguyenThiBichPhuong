CREATE DATABASE thi1;
USE thi1;
CREATE TABLE thu_vien (
id INT PRIMARY KEY  AUTO_INCREMENT,
ten_sach varchar(100),
tac_gia varchar(100),
so_luong int,
mo_ta varchar(100)
);

insert into thu_vien ( ten_sach, tac_gia, so_luong, mo_ta)
value('Số Đỏ', 'Vũ Trọng Phụng', '10', 'nhân vật chính là xuân tóc đỏ');
insert into thu_vien (ten_sach, tac_gia, so_luong, mo_ta)
value('Truyện Kiều', 'Nguyễn Du', '15', 'cuộc đời thúy kiều');

select * from thu_vien;