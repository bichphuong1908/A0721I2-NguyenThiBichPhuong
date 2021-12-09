CREATE DATABASE QuanLyBanHang;

USE QuanLyBanHang;

CREATE TABLE Customer(
      cID INT PRIMARY KEY,
      cName VARCHAR(50) NOT NULL,
      cAge INT NOT NULL
);

CREATE TABLE `Order`(
      oID INT PRIMARY KEY,
	  cID INT NOT NULL,
      oDate DATE,
      oTotalPrice DOUBLE,
      FOREIGN KEY (cID) REFERENCES Customer(cID)
);

CREATE TABLE Product(
	  pID INT PRIMARY KEY,
      pName VARCHAR(50) NOT NULL,
      pPrice DOUBLE 
);

CREATE TABLE OrderDetail(
      oID INT,
      pID INT,
      odQTY VARCHAR(50),
      PRIMARY KEY (oID, pID),
      FOREIGN KEY (oID) REFERENCES `Order`(oID),
      FOREIGN KEY (pID) REFERENCES Product(pID)
);
