USE QuanLynghiduongFurama;

-- Câu2: Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu 
-- là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
SELECT * FROM nhan_vien
WHERE (ho_ten like 'H%' OR ho_ten like 'T%' OR ho_ten like 'K%') AND char_length(ho_ten)<=15;

-- tên bắt đầu là “H”, “T” hoặc “K” và không tính họ
SELECT * from nhan_vien 
WHERE CAST(substring_index(ho_ten, ' ', -1) as BINARY)  regexp binary '^[HKT]' and char_length(ho_ten)<= 15;

-- Câu3: Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi 
-- và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
SELECT * from khach_hang
WHERE YEAR(NOW()) - YEAR(ngay_sinh) BETWEEN 18 and 50 
and (dia_chi like '%Đà Nẵng' OR dia_chi like '%Quảng Tri');

-- Câu4: Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
SELECT kh.ma_khach_hang, kh.ho_ten, COUNT(kh.ho_ten) AS so_lan_dat_phong FROM loai_khach lkh
JOIN khach_hang kh ON lkh.ma_loai_khach = kh.ma_loai_khach 
JOIN hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
JOIN kieu_thue kth ON dv.ma_kieu_thue = kth.ma_kieu_thue
WHERE lkh.ten_loai_khach like 'Diamond' 
GROUP BY kh.ho_ten
ORDER BY so_lan_dat_phong;

-- Câu5: 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien
-- (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) 
-- cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
SELECT kh.ma_khach_hang, kh.ho_ten, lkh.ten_loai_khach, hd.ma_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, 
       sum(dv.chi_phi_thue + hdct.so_luong * dvdk.gia) AS tong_tien FROM loai_khach lkh
left JOIN khach_hang kh ON lkh.ma_loai_khach = kh.ma_loai_khach 
left JOIN hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
left JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
left JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
left JOIN dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
GROUP BY kh.ma_khach_hang 
order by tong_tien;

-- cách 2: cách này đúng
select kh.ma_khach_hang, kh.ho_ten, lkh.ten_loai_khach, hd.ma_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, 
       (dv.chi_phi_thue + count( hdct.so_luong * dvdk.gia)) AS tong_tien from khach_hang kh 
left join loai_khach lkh on kh.ma_loai_khach = lkh.ma_loai_khach
left join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by hd.ma_khach_hang;

-- Câu6: Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ 
-- chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu from dich_vu dv
join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
where not exists (select * from hop_dong
where ngay_lam_hop_dong between '2021-01-01' and '2021-03-31' and ma_dich_vu = dv.ma_dich_vu);

-- Câu7: Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ
-- đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu from dich_vu dv
join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
where exists (select * from hop_dong
where year(ngay_lam_hop_dong)= '2020'and ma_dich_vu = dv.ma_dich_vu) and not exists(select * from hop_dong 
where year(ngay_lam_hop_dong)= '2021' and ma_dich_vu = dv.ma_dich_vu);

-- 8.Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
select distinct khach_hang.ho_ten from khach_hang;
-- cách 2:
select khach_hang.ho_ten from khach_hang group by khach_hang.ho_ten;
-- cách 3:
select khach_hang.ho_ten from khach_hang 
union
select khach_hang.ho_ten from khach_hang ;

-- 9. Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 
-- thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(hd.ngay_lam_hop_dong) as month, count(hd.ma_khach_hang) as khach_hang_dat_phong from khach_hang kh
inner join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
where year(hd.ngay_lam_hop_dong) = 2021
group by month;

-- Câu10: Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. Kết quả hiển thị bao gồm 
-- ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem 
-- (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
select hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc, sum(hdct.so_luong) as so_luong_dich_vu_di_kem 
from hop_dong hd left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by hd.ma_hop_dong;

-- Câu11: Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng 
-- có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem from dich_vu_di_kem dvdk
inner join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
inner join hop_dong hd on hdct.ma_hop_dong = hd.ma_hop_dong
inner join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
inner join loai_khach lkh on kh.ma_loai_khach = lkh.ma_loai_khach
where lkh.ten_loai_khach like 'Diamond' and (kh.dia_chi like '%Vinh' or kh.dia_chi like '%Quang Ngai');

-- Câu12: Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, 
-- so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất cả các dịch vụ 
-- đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
select hd.ma_hop_dong, nv.ho_ten as ho_ten_nhan_vien, kh.ho_ten as ho_ten_khach_hang, kh.so_dien_thoai, dv.ma_dich_vu, dv.ten_dich_vu, 
sum(hdct.so_luong) as so_luong_dich_vu_di_kem, hd.tien_dat_coc from nhan_vien nv
inner join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
inner join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
inner join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
inner join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
where exists (select hd.ma_hop_dong from hop_dong 
where year(hd.ngay_lam_hop_dong) between '2020-09-01' and '2020-12-31' and ma_hop_dong = hd.ma_hop_dong)
and not exists (select hd.ma_hop_dong from hop_dong
where year(hd.ngay_lam_hop_dong) between '2021-01-01' and '2021-06-30' and ma_hop_dong = hd.ma_hop_dong);

-- Câu13: Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
-- cách 1:
create temporary table temp
select dvdk.ten_dich_vu_di_kem as ten_dich_vu_di_kem, count(hdct.ma_dich_vu_di_kem) as so_lan_su_dung from hop_dong_chi_tiet hdct
inner join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by dvdk.ten_dich_vu_di_kem;
select * from temp;

create temporary table temp1
select max(temp.so_lan_su_dung) as max_so_lan_su_dung from temp;
select * from temp1;

select temp.ten_dich_vu_di_kem, temp.so_lan_su_dung from temp
inner join temp1 on temp.so_lan_su_dung = temp1.max_so_lan_su_dung;

drop temporary table temp;
drop temporary table temp1;

-- cách 2:
select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, count(*) as so_luong_dich_vu_di_kem from dich_vu_di_kem dvdk 
join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by dvdk.ten_dich_vu_di_kem;
select * from temp t where t.so_luong_dich_vu_di_kem = (select max(so_luong_dich_vu_di_kem ) from temp);

-- Câu14: Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm 
-- ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).
select hd.ma_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, count(dvdk.ten_dich_vu_di_kem) as so_lan_su_dung from loai_dich_vu ldv
inner join dich_vu dv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
inner join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
inner join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
inner join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by (dvdk.ten_dich_vu_di_kem) having so_lan_su_dung = 1;

-- Câu15: Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai,
-- dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
select nv.ma_nhan_vien, nv.ho_ten, td.ten_trinh_do, bp.ten_bo_phan, nv.so_dien_thoai, nv.dia_chi, count(hd.ma_nhan_vien) as so_lan_tao_hop_dong from nhan_vien nv
inner join trinh_do td on td.ma_trinh_do = nv.ma_trinh_do
inner join bo_phan bp on bp.ma_bo_phan = nv.ma_bo_phan
inner join hop_dong hd on hd.ma_nhan_vien = nv.ma_nhan_vien
where hd.ngay_lam_hop_dong between "2020-01-01" and "2021-12-31"
group by nv.ho_ten having so_lan_tao_hop_dong;

-- Câu16: Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
delete from nhan_vien nv
where not exists (select nv.ma_nhan_vien from hop_dong hd
where hd.ngay_lam_hop_dong between "2019-01-01" and "2021-12-31"
and hd.ma_nhan_vien = nv.ma_nhan_vien);

select * from nhan_vien;

-- Câu17: Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond,
-- chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
update khach_hang kh, (select hd.ma_khach_hang as id, sum(hd.tien_dat_coc) as tong_tien from hop_dong hd
where year(hd.ngay_lam_hop_dong) = '2021'
group by hd.ma_khach_hang having tong_tien > 10000000)
as temp set kh.ma_khach_hang = (select lkh.ma_loai_khach from loai_khach lkh where lkh.ten_loai_khach = "Diamond")
where kh.ma_khach_hang = (select lkh.ma_loai_khach from loai_khach lkh where lkh.ten_loai_khach = "Platinum")
and temp.id= kh.ma_khach_hang;

select * from khach_hang;

-- Câu18: Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).

-- Câu19: Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.

-- Câu20: Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị bao gồm 
-- id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.







