USE QuanLyBanHang;

INSERT INTO Customer(cID, cName, cAge)
VALUES (1, 'Minh Quan', 10),
	   (2, 'Ngoc Anh', 20),
       (3, 'Hong Ha', 50);
       
INSERT INTO `Order`(oID, cID, oDate, oTotalPrice)
VALUES (1, '1', '2006-03-21', Null),
	   (2, '2', '2006-03-23', Null),
       (3, '3', '2006-03-16', Null);
	
INSERT INTO Product(pID, pName, pPrice)
VALUES (1, 'May Giat', 3),
       (2, 'Tu Lanh', 5),
       (3, 'Dieu Hoa', 7),
       (4, 'Quat', 1),
       (5, 'Bep Đien', 2);
       
INSERT INTO  OrderDetail(oID, pID, odQTY)
VALUES (1, 1, 3),
       (1, 3, 7),
       (1, 4, 2),
       (2, 1, 1),
       (3, 1, 8),
       (2, 5, 4),
       (2, 3, 3);
       
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
SELECT oID, oDate, oTotalPrice FROM `Order`;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
SELECT C.cName, P.pName FROM Customer C
INNER JOIN `Order` O ON C.cID = O.cID
INNER JOIN OrderDetail Od ON O.oID = Od.oID
INNER JOIN Product P ON Od.pID = P.pID;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
SELECT Customer.cName FROM Customer
JOIN `Order` ON Customer.cID = `Order`.cID
JOIN OrderDetail ON `Order`.oID = OrderDetail.oID
JOIN Product ON OrderDetail.pID = Product.pID
WHERE Product.pName is null;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của 
-- từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
SELECT O.oID, O.oDATE, count(P.pPrice * Od.odQTY) as GiaTien FROM `Order` O
INNER JOIN OrderDetail Od ON O.oID = Od.oID
INNER JOIN Product P ON Od.pID = P.pID
group by O.oID;
