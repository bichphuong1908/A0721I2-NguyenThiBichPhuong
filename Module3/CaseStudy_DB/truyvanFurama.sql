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

-- cách 2:
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

-- Câu7: 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ
-- đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu from dich_vu dv
join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
where exists (select * from hop_dong
where year(ngay_lam_hop_dong)= '2020'and ma_dich_vu = dv.ma_dich_vu) and not exists(select * from hop_dong 
where year(ngay_lam_hop_dong)= '2021' and ma_dich_vu = dv.ma_dich_vu);








