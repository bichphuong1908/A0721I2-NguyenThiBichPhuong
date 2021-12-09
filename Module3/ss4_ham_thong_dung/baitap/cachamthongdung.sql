USE QuanLySinhVien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
SELECT SubId, SubName, `Status`, Max(Credit)FROM `Subject`;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
SELECT S.SubName, max(M.Mark) FROM `Subject` S
INNER JOIN Mark M ON S.SubId = M.SubId;

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
SELECT St.StudentId, St.StudentName, AVG(Mark)
FROM Student St join Mark M on St.StudentId = M.StudentId
GROUP BY St.StudentId, St.StudentName;

select * from Class;
select * from Student;
select * from `Subject`;
select * from Mark;

