use demo_a07;
create table `tai_khoan` (
username varchar(15) primary key,
`password` varchar(100) not null -- là bắt buộc nhập thông tin khi thêm mới hoặc sửa 
);

create table lop_hoc(
ma_lop_hoc int primary key auto_increment,
ten_lop_hoc varchar(100)
);

create table giang_vien(
ma_giang_vien int primary key auto_increment,
ten_giang_vien varchar(100),
ngay_sinh date
);

create table hoc_vien (
-- auto_increment : tự động tăng, áp dụng cho số
ma_hoc_vien int primary key auto_increment,
ten_hoc_vien varchar(100),
ngay_sinh date,
email varchar(100),
-- unique : không trùng lặp
username varchar(15) unique,
ma_lop_hoc int,
foreign key(ma_lop_hoc) references lop_hoc(ma_lop_hoc),
foreign key(username) references tai_khoan(username)
);

create table dia_chi(
ma_dia_chi int primary key auto_increment,
dia_chi varchar (255),
ma_hoc_vien int,
foreign key(ma_hoc_vien) references hoc_vien(ma_hoc_vien)
);

create table giang_vien_day_lop_hoc(
ma_giang_vien int,
ma_lop_hoc int,
primary key(ma_giang_vien,ma_lop_hoc), -- khóa phức hợp
foreign key(ma_giang_vien) references giang_vien(ma_giang_vien),
foreign key(ma_lop_hoc) references  lop_hoc(ma_lop_hoc)
);

insert into `tai_khoan`(username, `password`)
values("TanHai", "19980101"),
      ("TranTan", "20010101"),
      ("VanTu", "20010410"),
	  ("VanMy", "20021109"),
	  ("NgoTri", "19971030"),
	  ("ThanhHai", "19981130"),
      ("BuiTy", "19970529");
select * from `tai_khoan`;

insert into lop_hoc (ma_lop_hoc, ten_lop_hoc)
values("024101", "Toan K24"),
      ("024102", "Van K24"),
      ("024103", "Ly K24"),
      ("024104", "Hoa K24"),
      ("024105", "Su K24"),
      ("024106", "Dia K24"),
      ("024107", "Tieng Anh K24");
select * from lop_hoc;

insert into giang_vien (ma_giang_vien, ten_giang_vien, ngay_sinh)
values("01020001", "Nguyen Thi Ngoc Anh", "1983-03-21"),
	  ("01020002", "Nguyen Cong Binh", "1979-06-06"),
      ("01020003", "Ngo Viet Bac", "1982-03-11"),
      ("01020004", "Tran Thi Kim Anh", "1982-11-04"),
      ("01020005", "Nguyen Tuan Anh", "1979-07-15"),
      ("01020006", "Ho Dang Chien", "1982-01-20"),
      ("01020007", "Ngo Thi Nhat Anh", "1982-11-27");
select * from giang_vien;

insert into hoc_vien (ma_hoc_vien, ten_hoc_vien, ngay_sinh, email, username, ma_lop_hoc )
values("01241020001", "Truong Tan Hai", "1998-01-01", "Hai98@gmail.com", "TanHai", "024101"),
      ("01241020002", "Tran Tan Tai", "2001-01-01", "Tai01@gmail.com", "TranTan", "024102"),
      ("01241020003", "Nguyen Van Tu", "2001-04-10", "Tu010410@gmail.com", "VanTu", "024103"),
      ("01241020004", "Nguyen Van My", "2002-11-09", "Vanmy02@gmail.com", "VanMy", "024104"),
      ("01241020005", "Ngo Tri Tai", "1997-10-30", "Tritai97@gmail.com", "NgoTri", "024105"),
      ("01241020006", "Nguyen Thanh Hai", "1998-11-30", "Thanhhai98@gmail.com", "ThanhHai", "024106"),
      ("01241020007", "Mai Bui Ty", "1997-05-29", "Buity97@gmail.com", "BuiTy", "024107");
select * from hoc_vien;

insert into dia_chi (ma_dia_chi, dia_chi, ma_hoc_vien)
values("020001", "Hoa Khanh", "01241020002"),
      ("020002", "Nguyen Van Linh", "01241020003"),
      ("020003", "Thanh Khue", "01241020001"),
      ("020004", "Lien Chieu", "01241020005"),
      ("020005", "Hoa Khanh", "01241020007"),
      ("020006", "Hoa Vang", "01241020004"),
      ("020007", "Quang Trung", "01241020006");
select * from dia_chi;

insert into giang_vien_day_lop_hoc (ma_giang_vien, ma_lop_hoc)
value ("01020001", "024107"),
      ("01020002", "024103"),
      ("01020003", "024106"),
      ("01020004", "024102"),
      ("01020005", "024104"),
      ("01020006", "024105"),
      ("01020007", "024101");
select * from giang_vien_day_lop_hoc






