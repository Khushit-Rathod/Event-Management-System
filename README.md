To run the system you have to run the splash.java file. After this a login page will appear. If you have already registered then you can login directly with your email and password. If not then you have to register first and then login. After login you will be able to view the home page.

In this System there are two main pages:

1. Admin Home Page
2. Student Home Page

Admin page can be accessed by the event organisers only. It has a separate email and password for login. One who has that email and password can login to the page. Admin can change the login credentials if needed. The default email and password for login to admin page is: email - admin@viit.ac.in , password - 12345.

Admin has the rights to register student for an event , update student details , add new event , delete participants from an event , view student and participant details. 

Student Page can be accessed only by the students who have registered successfully in the portal. New student have to first register to the portal with their username , email and password. Students will be assigned with unique id during the registration(PRN) which he/she has to remember for future use. Registered student can access the page with their email and password.

Students have the right to update their information , view events lists , participate in an event and view their information and participation details.

All forms in this system have validation and an error message is displayed if you enter incorrect or invalid data. All data entered is stored in different tables in SQL database.

To create these tables run the following queries:


create database eventmanagementsystem;

use eventmanagementsystem;

create table login(email varchar(50),password varchar(25),primary key(email));

create table events(eventname varchar(50),description varchar(1000),teammembers int,check (teammembers<=4),primary key(eventname));

create table register(prn varchar(25),username varchar(50),email varchar(50),password varchar(25),primary key(prn),foreign key(email) references login(email));

create table student(firstname varchar(50),middlename varchar(50),lastname varchar(50),prn varchar(25),email varchar(50),phone varchar(25),dob varchar(50),year varchar(25),branch varchar(50),foreign key(prn) references register(prn));

create table participate(eventname varchar(100),teamname varchar(100),teamleadername varchar(100),teammember1name varchar(100),teammember2name varchar(100),teammember3name varchar(100),email varchar(100));

You also need to add 3 jar files which I have added in the folder named jar files.

Some snapshots of our project

![Screenshot 2024-07-18 232512](https://github.com/user-attachments/assets/741cda15-fe19-4a26-94e5-feb999134dce)
![Screenshot 2024-07-18 232630](https://github.com/user-attachments/assets/c426a599-84d9-451d-a85e-ae4aee9743f1)
![Screenshot 2024-07-18 232653](https://github.com/user-attachments/assets/9929470e-5751-4319-b411-c4477f7c0def)

