Inventory Management Application
--------------------------------

Tech Stack:
----------
<ul>
<li>UI: Angular 12 (Components, Services, Interceptors) & Bootstrap 4.0 CSS Framework</li>
<li>Backend: Spring Boot 2.5.0 , Spring Data JPA, MySQL 8.0, Docker</li>
</ul>

<br>

<b>Swagger URL for Rest Api Documentation:</b> http://localhost:8080/swagger-ui/

Features:
--------
<ul>
  <li>User Can Register to Inventory Management Application</li>
  <li>After successfull registration user can login </li>
  <li>If Login as Admin we can see Manage DB & Manage User Link</li>
  <li>If Login as User we can only see link to Test the DB Connectivity</li>
  <li>Admin can Add New Connection</li>
  <li>Admin can Update Connection</li>
  <li>Admin can Delete Connection</li>
  <li>Admin/Users can Test DB Connectivity</li>
  <li>Admin/Users can Logout</li>
<ul>

  
Application Security: (Spring Securtity with JWT)
-------------------------------------------------
<h3> We are using JWT (Json Web Token) to protect our API</h3>
<p>Once User is registered and Login to our Application using Username & Password, we will going to first Validate the User in our Backend, Once user is validated we are creating JWT Token which is sent to UI, UI will going to send this Token for each API Call, Backend will validate the Token and on successful validation only API will going to provide the response.</p>
  
  
Architecture Diagram:
---------------------
![inventory-management](https://user-images.githubusercontent.com/84853770/120985560-5b436800-c799-11eb-8f62-47ca30cc0c35.png)
  
  
Register Screen:
---------------
![Screenshot from 2021-06-07 14-08-05](https://user-images.githubusercontent.com/84853770/120986046-d016a200-c799-11eb-8cca-025c540484a4.png)


Login Screen:
-------------
![Screenshot from 2021-06-07 14-07-07](https://user-images.githubusercontent.com/84853770/120985928-b5442d80-c799-11eb-8527-b7da692d2480.png)


Home Screen:
-----------
![Screenshot from 2021-06-07 14-10-01](https://user-images.githubusercontent.com/84853770/120986318-166c0100-c79a-11eb-8484-3a8057479146.png)


Admin Screen To Manage DB Inventory:
------------------------------------
![Screenshot from 2021-06-07 14-10-34](https://user-images.githubusercontent.com/84853770/120986418-31d70c00-c79a-11eb-9011-5ea41aed37e5.png)


Admin can Update DB Configuration:
----------------------------------
![Screenshot from 2021-06-07 14-13-55](https://user-images.githubusercontent.com/84853770/120986818-9befb100-c79a-11eb-84b1-138f00cc7f69.png)


Admin can Add DB Configuration:
------------------------------------
![Screenshot from 2021-06-07 14-14-29](https://user-images.githubusercontent.com/84853770/120986907-b164db00-c79a-11eb-8692-8e56b4858987.png)


Admin can Test DB Connectivity:
----------------------------------
![Screenshot from 2021-06-07 14-15-19](https://user-images.githubusercontent.com/84853770/120987016-cd687c80-c79a-11eb-8b02-e397139ac2e1.png)



Admin Users Screen:
-------------------
![Screenshot from 2021-06-07 14-11-24](https://user-images.githubusercontent.com/84853770/120986496-4ca98080-c79a-11eb-90be-f3ea86cf4c52.png)


Logout Screen:
--------------
![Screenshot from 2021-06-07 14-11-55](https://user-images.githubusercontent.com/84853770/120986581-5fbc5080-c79a-11eb-9216-877426064fb1.png)


CLasses Used :
-------------
![classes](https://user-images.githubusercontent.com/84853770/121001228-b466c800-c7a8-11eb-8bb4-b597072080c4.png)

Database Diagram:
----------------
![db](https://user-images.githubusercontent.com/84853770/121001471-f3951900-c7a8-11eb-829a-889b53372369.png)
  
  
  
  
