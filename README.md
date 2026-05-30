# ⚡ AuthPulse: Elegant & Secure Auth System

[![Java Version](https://img.shields.io/badge/Java-21-orange.svg?style=flat-square&logo=openjdk)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.11-brightgreen.svg?style=flat-square&logo=springboot)](https://spring.io/projects/spring-boot)
[![React](https://img.shields.io/badge/React-19-blue.svg?style=flat-square&logo=react)](https://react.dev/)
[![Tailwind CSS](https://img.shields.io/badge/Tailwind_CSS-v4.0-38bdf8.svg?style=flat-square&logo=tailwindcss)](https://tailwindcss.com/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue.svg?style=flat-square&logo=postgresql)](https://www.postgresql.org/)

**AuthPulse** is a clean, modern, and high-security full-stack authentication system built with a **Spring Boot 3** backend and a **React 19 (TypeScript + Vite)** frontend. It features standard-compliant dual-token authentication, background token rotation, Google Social Login, and a beautiful dashboard with session audit logs.

🌐 **Live Backend:** [https://auth-back-latest.onrender.com/](https://auth-back-latest.onrender.com/)

---

## ✨ Features

*   **🔒 Double-Locked Security:** Uses short-lived Access Tokens for API requests and database-tracked, secure HttpOnly Cookies (Refresh Tokens) to manage sessions.
*   **🔄 Refresh Token Rotation (RTR):** Automatically rotates refresh tokens on every refresh to prevent session theft.
*   **🌐 Google Sign-In:** One-click OAuth2 social authentication.
*   **📊 Login Auditing:** A gorgeous dashboard that displays login history, including client browser, OS, IP address, and status.
*   **🎨 Premium UI:** Beautiful interface built with Tailwind CSS v4, Radix UI, and smooth animations powered by Framer Motion.
*   **⚡ Race-Condition Guard:** A smart Axios interceptor queue that handles simultaneous session refresh requests silently in the background.

---

## 🏗️ How it Works (The Simple Version)

1.  **Login:** You authenticate via password or Google. The backend gives the frontend a temporary access key and stores a secure session token inside a hidden browser cookie.
2.  **Silent Refresh:** Every 10 minutes, the frontend silently asks the backend for a new access key in the background using the secure cookie—zero interruption for the user.
3.  **Rotation Guard:** Each refresh replaces the old session token. If anyone tries to reuse an old, stolen session key, the backend instantly logs all sessions out.

---

## 💻 Tech Stack

*   **Backend:** Java 21, Spring Boot 3.5.11, Spring Security (OAuth2), JPA/Hibernate, PostgreSQL, JWT,Lombok,Maven.
*   **Frontend:** React 19, TypeScript, Vite, Tailwind CSS v4, Zustand, Axios, Framer Motion.

---

## 🚀 Quick Start

### 1. Setup Environment
Copy the example environment file in the root directory and fill in your secrets (e.g. database credentials, JWT secret, and Google client ID):
```bash
cp .env.example .env
```
*(The backend automatically loads this `.env` file at startup!)*

### 2. Run Database
Ensure PostgreSQL is running and create the database:
```sql
CREATE DATABASE authdb;
```

### 3. Run Backend
```bash
cd authBackendSystem
./mvnw spring-boot:run
```
*API is live on `http://localhost:8081`. Inspect Swagger docs at `http://localhost:8081/swagger-ui/index.html`.*

### 4. Run Frontend
In a new terminal:
```bash
cd frontened/react-app
npm install
npm run dev
```
*App is live on `http://localhost:5173`.*

---

## 🐳 Docker (Optional)
Deploy the database and backend instantly using Docker Compose:
```bash
docker-compose --env-file .env up --build -d
```
