# 🛒 Fashion Bajar — Full-Stack eCommerce Application

A production-ready eCommerce backend built with **Spring Boot 4.0** and **Java 17**, featuring JWT-based authentication, role-based access control, and a fully documented REST API.

---

## 🚀 Features

- 🔐 **JWT Authentication** — Secure login & registration with token-based auth
- 👥 **Role-Based Access Control** — Separate roles for Admin, Seller, and Customer
- 📦 **Product Management** — Full CRUD for products with category support
- 🛍️ **Order Management** — Place, track, and manage orders
- 🗂️ **Category Management** — Organize products into categories
- 🧾 **Cart System** — Add/remove items and manage cart per user
- 📄 **Swagger UI** — Fully documented and testable API via OpenAPI 3
- ✅ **Bean Validation** — Input validation on all request payloads

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Java 17 |
| Framework | Spring Boot 4.0 |
| Security | Spring Security + JWT (jjwt 0.12.3) |
| Database | MySQL |
| ORM | Spring Data JPA + Hibernate |
| Mapping | ModelMapper 3.2.4 |
| API Docs | SpringDoc OpenAPI (Swagger UI) |
| Build Tool | Maven |
| Utilities | Lombok |

---

## 📁 Project Structure

```
sb-ecom/
├── src/
│   └── main/
│       ├── java/com/ecommerce/sb-ecom/
│       │   ├── config/        # Security & JWT config
│       │   ├── controller/    # REST Controllers
│       │   ├── model/         # Entity classes
│       │   ├── repository/    # JPA Repositories
│       │   ├── service/       # Business logic
│       │   ├── payload/       # DTOs / Request-Response
│       │   └── security/      # JWT Filter, UserDetails
│       └── resources/
│           └── application.properties
├── pom.xml
└── README.md
```

---

## ⚙️ Getting Started

### Prerequisites

- Java 17+
- MySQL 8+
- Maven 3.8+

### 1. Clone the repository

```bash
git clone https://github.com/abhaypalke/sb-ecom.git
cd sb-ecom
```

### 2. Configure the database

Open `src/main/resources/application.properties` and update:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sb_ecom
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Run the application

```bash
./mvnw spring-boot:run
```

The server will start at **http://localhost:8080**

### 4. Access Swagger UI

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🔐 API Authentication

This project uses **JWT Bearer Token** authentication.

1. Register a user via `POST /api/auth/signup`
2. Login via `POST /api/auth/signin` to receive a JWT token
3. Pass the token in the Authorization header for protected routes:

```
Authorization: Bearer <your_token>
```

---

## 📌 Key API Endpoints

| Method | Endpoint | Description | Role |
|--------|----------|-------------|------|
| POST | `/api/auth/signup` | Register new user | Public |
| POST | `/api/auth/signin` | Login & get JWT | Public |
| GET | `/api/public/products` | Get all products | Public |
| POST | `/api/admin/products` | Add new product | Admin |
| PUT | `/api/admin/products/{id}` | Update product | Admin |
| DELETE | `/api/admin/products/{id}` | Delete product | Admin |
| GET | `/api/public/categories` | Get all categories | Public |
| POST | `/api/admin/categories` | Add category | Admin |
| POST | `/api/carts/products/{id}` | Add to cart | Customer |
| GET | `/api/carts` | View cart | Customer |
| POST | `/api/orders` | Place order | Customer |

---

## 🖼️ Screenshots

> Add screenshots of Swagger UI and Postman API calls here

---

## 🙋‍♂️ Author

**Abhay Palke**
- 📧 abhaypalke4@gmail.com
- 💼 [LinkedIn](https://www.linkedin.com/in/abhaypalke)
- 🐙 [GitHub](https://github.com/abhaypalke)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
