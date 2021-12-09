USE QuanLySinhVien;

SELECT * FROM Student
WHERE StudentName like "h%";

SELECT * FROM Class
WHERE month(StartDate) =12;

-- Cách1:
SELECT * FROM `Subject`
WHERE Credit like 3 or Credit like 5;

-- Cách2:
SELECT * FROM `Subject`
WHERE Credit Between 3 and 5;

UPDATE Student Set StudentName = "Hung" 
WHERE ClassID =2;

SELECT St.StudentName, S.SubName, M.Mark FROM Student St
INNER JOIN Mark M ON St.StudentID = M.StudentID
INNER JOIN `Subject` S ON M.SubID = S.SubID
ORDER BY M.Mark DESC ;



