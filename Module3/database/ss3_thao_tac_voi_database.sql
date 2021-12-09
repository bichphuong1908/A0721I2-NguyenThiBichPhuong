use demo_a07;
-- Yêu cầu 1: Lấy ra toàn bộ thông tin của các học sinh đang theo học kể cả thông tin của lớp
select * from hoc_vien inner join lop_hoc on hoc_vien.ma_lop_hoc = lop_hoc.ma_lop_hoc;

-- Yêu cầu 2: Lấy ra toàn bộ thông tin của các học sinh đang theo học kể cả thông tin của lớp kể cả 
-- những học sinh không theo học lớp nào
select * from lop_hoc  right join hoc_vien on hoc_vien.ma_lop_hoc = lop_hoc.ma_lop_hoc;

-- full join.
select * from hoc_vien left join lop_hoc on hoc_vien.ma_lop_hoc = lop_hoc.ma_lop_hoc 
union 
select * from hoc_vien  right join lop_hoc on hoc_vien.ma_lop_hoc = lop_hoc.ma_lop_hoc;

-- Yêu cầu 3: Lấy ra thông tin của học viên tên là TrungDC
select * from hoc_vien where hoc_vien.username = "trungdc";

-- Tìm kiếm thông tin của học viên có tên Trung trong username
select * from hoc_vien where hoc_vien.username like "%t"; -- Kết thúc phải là trung
-- trung%: bắt đầu phải là chữ trung
-- %trung% chỉ cần tồn tại chuỗi trung trong tên là được.

-- Yêu cầu 4: Đếm số lượng học viên của từng lớp.
select count(ma_hoc_vien), ma_lop_hoc from hoc_vien group by ma_lop_hoc;

-- Chỉ hiển thị các lớp có trên 2 thành viên 
select count(ma_hoc_vien) as 'number_hoc_vien', ma_lop_hoc from hoc_vien 
group by ma_lop_hoc having number_hoc_vien >=2;

-- Yêu cầu 5: Hiển thị tên tăng dần
select * from hoc_vien order by username desc;


