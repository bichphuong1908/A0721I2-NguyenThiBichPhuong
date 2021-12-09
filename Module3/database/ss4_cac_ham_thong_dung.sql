-- Yêu cầu lấy ra học sinh có tuổi lớn nhất của mỗi lớp học.
select min(hoc_vien.ngay_sinh), lop_hoc.ten_lop_hoc
from hoc_vien left join lop_hoc on hoc_vien.ma_lop_hoc = lop_hoc.ma_lop_hoc
group by hoc_vien.ma_lop_hoc;
-- Lưu ý đối với các hàm gộp thì chúng ta không thể hiển thị dữ liệu đi kèm
-- được mà chỉ hiển thị thuộc tính của group by.

-- Yêu cầu lấy ra thông tin của học viên và giảng viên
select ma_hoc_vien as "ma", ten_hoc_vien as "ten", "học viên" as "role" 
from hoc_vien
union
select ma_giang_vien as "ma", ten_giang_vien as "ten", "giảng viên" as "role" 
from giang_vien;

-- Lấy ra 3 học viên nhỏ tuổi nhất.
select * from hoc_vien order by ngay_sinh desc limit 3;

select * from hoc_vien order by ngay_sinh desc limit 4,2;
-- Vị trí bắt đầu như mảng bắt đầu từ 0, tham số sau dấu phẩy 
-- là số lượng phần tử muốn lấy ra -> làm phân trang

-- Yêu cầu: Lấy ra thông của lớp có học sinh tên là A;
-- Cách 1:
select * from lop_hoc inner join hoc_vien on 
lop_hoc.ma_lop_hoc = hoc_vien.ma_lop_hoc where hoc_vien.ten_hoc_vien = "A";
-- Cách 2:
select * from lop_hoc where lop_hoc.ma_lop_hoc = 
(select ma_lop_hoc from hoc_vien where hoc_vien.ten_hoc_vien = "A");

-- Yêu cầu: Lấy ra thông của lớp có học sinh tên là A;
select * from lop_hoc where lop_hoc.ma_lop_hoc 
in (select hoc_vien.ma_lop_hoc from hoc_vien where hoc_vien.ten_hoc_vien ="A");

select * from lop_hoc where exists(select hoc_vien.ma_lop_hoc from hoc_vien
where hoc_vien.ten_hoc_vien = "A" and lop_hoc.ma_lop_hoc = hoc_vien.ma_lop_hoc);
-- Chỉ nên sử dụng exists cho các trường hợp kiểm tra tồn tại hoặc không tồn tại

-- Yêu câu hiển thị tất cả học có năm sinh là 1999;
-- Datedif() trừ 2 ngày với nhau -> tổng số ngày chênh lệch
select * from hoc_vien where year(hoc_vien.ngay_sinh) ="1997";

