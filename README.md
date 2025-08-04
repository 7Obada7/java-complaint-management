# Complaint Management System 📝

A desktop-based complaint tracking system built in Java with a GUI interface and MySQL database integration.  
This project was developed during my **early university years** to practice user authentication, form validation, and database operations through a graphical interface.

---

## 🎯 Features

### 🔐 User Side
- Register and Login system
- Input validation using regular expressions for:
  - Name
  - Email
  - Phone
  - ID
- Submit complaints with:
  - Product name
  - Complaint description
  - Optional image attachment
- View submitted complaints and their status

### 🛠️ Admin Side
- Admin login
- View all user complaints
- Update complaint status to `"solved"` and write solutions
- Filter unresolved complaints

---

## 🧰 Tech Stack

- **Java** (Swing GUI)
- **MySQL** (Database)
- **JDBC** (Database connection)
- **Maven** (Project management - via `pom.xml`)
- **Regex** (Data validation)

---

## 💾 Database Configuration

1. Start your local **MySQL server**
2. Create a database named `proje`
3. The app connects using:
   
```java
DriverManager.getConnection("jdbc:mysql://localhost:3306/proje", "root", "")

```
---

## 🖼️ GUI Overview
User-friendly Java Swing interface

Input forms for registration, login, and complaint submission

Admin panel with complaint list and status management

---

## 🧠 Educational Context
This was one of my first full Java projects combining GUI development with real database connectivity. Through it, I learned:

How to build and validate forms

Connecting Java apps to a relational database

Structuring desktop applications using basic OOP

Implementing simple admin features and data filtering

It laid the foundation for future backend/frontend systems I would later build using more advanced frameworks.
