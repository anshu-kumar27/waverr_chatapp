<p align="center">
  <img src="https://i.gifer.com/ZZ5H.gif" width="100" alt="loading" />
</p>

<h1 align="center">🚧 Chat Application (Under Development) 🚧</h1>

A real-time full-stack chat application built with **Spring Boot**, **WebSockets**, **React**, and **PostgreSQL** — featuring JWT authentication, Redux state management, and modular Java MVC architecture.

---

## 🛠️ Tech Stack

### 🔹 Backend
<p>
  <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/>
  <img src="https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens"/>
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white"/>
  <img src="https://img.shields.io/badge/WebSocket-000000?style=for-the-badge&logo=websocket&logoColor=white"/>
  <img src="https://img.shields.io/badge/Lombok-EF3A3A?style=for-the-badge&logo=lombok&logoColor=white"/>
</p>

### 🔹 Frontend
<p>
  <img src="https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB"/>
  <img src="https://img.shields.io/badge/Redux-764ABC?style=for-the-badge&logo=redux&logoColor=white"/>
  <img src="https://img.shields.io/badge/TailwindCSS-06B6D4?style=for-the-badge&logo=tailwindcss&logoColor=white"/>
</p>

### 🔹 Database & Tools
<p>
  <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white"/>
  <img src="https://img.shields.io/badge/VSCODE-007ACC?style=for-the-badge&logo=visualstudiocode&logoColor=white"/>
  <img src="https://img.shields.io/badge/SpringTools4-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
</p>

---

## 📁 Project Structure

This project follows a clean **Java MVC architecture** and separates concerns across layers:
```
📦 src 
└── 📁 main 
  └── 📁 java 
    └── 📁 com.example.chatapp 
    ├── 📁 config # All configuration classes (@Configuration) 
    ├── 📁 controller # REST Controllers (@RestController) 
    ├── 📁 dto # Data Transfer Objects (DTOs) 
    ├── 📁 mapper # DTO ↔ Model mapping logic 
    ├── 📁 model │ ├── 📄 [Entities] # Database schema classes (@Entity) 
    │ └── 📁 enums # Enum definitions (e.g., Role, Status) 
    ├── 📁 repository # JPA repositories (interfaces) 
    ├── 📁 service │ ├── 📄 [Interfaces] # Service layer contracts 
    │ └── 📁 implementation # Concrete service implementations 
    ├── 📁 exception # Global error handling (@ControllerAdvice) 
    └── 📁 util # Utility/helper classes
```

---

## 🚀 Features in Progress

- [x] JWT-based login/authentication system
- [x] Real-time communication with WebSocket  
- [x] Modular backend with layered architecture  
- [x] Redux-powered frontend state  
- [ ] One-on-one and group chat support  
- [ ] Typing indicators, online presence  
- [ ] Media sharing (images, files)  
- [ ] Notification sounds  
- [ ] Responsive mobile design


---

<p align="center">
  <img src="https://media0.giphy.com/media/v1.Y2lkPTc5MGI3NjExcWEycmVyZzczN3BtaWl4ZHlqb2s5d2RqeXQ5ZWNvejRoeWVyYnd5ZSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/cvyz3Hw4d7EIw/giphy.gif" width="300" alt="anime-coding-gif"/>
</p>

<h3 align="center">✨ In progress... On my wayyyy.... ✨</h3>
