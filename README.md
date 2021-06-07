Inventory Management Application
--------------------------------

Tech Stack:
----------
<ul>
<li>UI: Angular 12 (Components, Form Validation, Services, Interceptors) & Bootstrap 4.0 CSS Framework</li>
<li>Backend: Spring Boot 2.5.0 , Spring Data JPA, MySQL 8.0, Junit, Docker</li>
<li>Code Scan: Sonar Scan used Free Cloud Sonar Scan</li>  
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

Jenkins CI/CD:
--------------
<ul>
  <li>Push code to Github, which will invoke Webhook and Start Jenkins Job to Build the Code</li>
  <li>Stage 1 : OWASP Scan (Open Web App Security Project)</li>
  <li>Stage 2 : Junit Test </li>
  <li>Stage 3 : Build Application </li>
  <li>Stage 4 : Sonar Scan </li>
  <li>Stage 5 : Fortify Scan </li>
  <li>Stage 6 : Docker Build </li>
  <li>Stage 7 : Deploy </li>
<ul>  
  
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



Admin Users List Screen:
------------------------
![Screenshot from 2021-06-07 17-35-56](https://user-images.githubusercontent.com/84853770/121013799-eed76180-c7b6-11eb-94a1-b7f16954861a.png)


Logout Screen:
--------------
![Screenshot from 2021-06-07 14-11-55](https://user-images.githubusercontent.com/84853770/120986581-5fbc5080-c79a-11eb-9216-877426064fb1.png)

  
Normal User Flow, Home Screen:
------------------------------
![Screenshot from 2021-06-07 17-40-01](https://user-images.githubusercontent.com/84853770/121014257-686f4f80-c7b7-11eb-8ef0-2e1a7aab7b84.png)
  

Normal User can view DB Connection:
-----------------------------------
![Screenshot from 2021-06-07 17-41-56](https://user-images.githubusercontent.com/84853770/121014511-b1bf9f00-c7b7-11eb-9bce-fde287d8f0ea.png)

Normal User can Test DB Connection:
-----------------------------------
![Screenshot from 2021-06-07 17-42-43](https://user-images.githubusercontent.com/84853770/121014612-cbf97d00-c7b7-11eb-9295-9cc1d131acde.png)

DB Architecture on Cloud:
------------------------
![db-architecture](https://user-images.githubusercontent.com/84853770/121022118-af614300-c7bf-11eb-8316-be639d9c870e.png)
  
  

Classes Used :
-------------
![classes](https://user-images.githubusercontent.com/84853770/121001228-b466c800-c7a8-11eb-8bb4-b597072080c4.png)

Database Diagram:
----------------
![db](https://user-images.githubusercontent.com/84853770/121022328-db7cc400-c7bf-11eb-92fb-abd5c11bd65f.png)

  
  
  
  
