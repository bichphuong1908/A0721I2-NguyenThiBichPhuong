<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
      header {
        background-color:black;
        color:white;
        text-align:justify;
        margin-right: auto;
        padding:5px;
      }

      nav ul {
        font-weight: bolder;
        font-size: 30px;
        text-align:center;
        line-height: 20px;
      }

      nav ul li {
        display: inline;
      }
      .container-1{
        width: 300px;
        vertical-align: middle;
        white-space: nowrap;
        position: relative;

      }

      article {
        font-size: 20px;
        text-align: center;
        list-style: none;
        line-height:30px;
        background-color:#eeeeee;
        height:300px;
        width:200px;
        float:left;
        padding:5px;
      }
      section {
        width:1000px;
        float:left;
        margin-left: 10px;
        margin-right: auto;
      }
      aside{
        font-size: 20px;
        margin-left: revert;
      }
      footer {
        background-color:black;
        color:white;
        clear:both;
        text-align:center;
        padding:15px;
      }
    </style>
  </head>
  <body>
  <header>
    <h2>Khách sạn Furama</h2>
  </header>

  <nav>
    <ul>
      <li>Home</li>
      <li>Employee</li>
      <li>Customer</li>
      <li>Service</li>
      <li>Contract</li>
      <li class="container-1">
        <span class="icon"><i class="fa fa-search"></i></span>
        <input type="search" id="search" placeholder="Search..." />
      </li>
    </ul>
  </nav>

  <section>
    <article>
      <li>Item One</li>
      <li>Item Two</li>
      <li>Item Three</li>
    </article>
    <aside>
      <h1>Hà Nội</h1>
      <p>Hà Nội là thủ đô của nước và cũng là kinh đô của rất nhiều vương triều Việt cổ. Lịch sử Hà Nội gắn liền với sự thăng trầm của lịch sử Việt Nam qua các thời kì.</p>
      <p>Hiện nay, Hà Nội là thành phố lớn nhất Việt Nam về diện tích, đồng thời cũng là địa phương đứng thứ nhì về dân số.</p>
      <p>Hà Nội nằm giữa đồng bằng sông Hồng trù phú, nơi đây đã sớm trở thành một trung tâm chính trị, kinh tế và văn hóa ngay từ những buổi đầu của lịch sử Việt Nam.</p>
    </aside>
  </section>

  <footer>
    Copyright © timoday.edu.vn
  </footer>
  </body>
</html>
