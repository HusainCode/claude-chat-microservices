# 🤖 Claude Chatbot Microservices (AWS Bedrock Edition)

A modular chatbot platform powered by **Claude (via AWS Bedrock)**, built using **Java Spring Boot microservices** and a **React frontend**. This system supports multi-user chat, history storage, and real-time streaming responses.

---

## 🧭 Architecture

---

## 📁 Project Structure

---
claude-chat-microservices/
│
├── chat-ui/                   # React frontend for the chat interface
│   ├── src/
│   └── public/
│
├── chat-api/                  # Spring Boot API Gateway for routing & WebSocket
│   └── src/
│
├── auth-service/              # Handles login, JWT generation/verification
│   └── src/
│
├── claude-connector/          # Handles Claude prompt requests via AWS Bedrock SDK
│   └── src/
│
├── history-service/           # Chat persistence layer with PostgreSQL
│   └── src/
│
├── docker-compose.yml         # Local dev orchestration
├── .env                       # Environment variables (for local dev)
├── README.md
└── .gitignore


---

## 🔧 Microservices

| Service              | Description                                  |
|----------------------|----------------------------------------------|
| `chat-ui`            | React web frontend (chat UI + settings)      |
| `chat-api`           | Gateway for chat requests + streaming output |
| `auth-service`       | Handles login, registration, and JWT tokens  |
| `history-service`    | Stores chat history in PostgreSQL            |
| `claude-connector`   | Talks to Claude via AWS Bedrock              |

---

## 🚀 Tech Stack

- Java 21 + Spring Boot (API, Auth, Claude)
- React + Tailwind (Frontend)
- PostgreSQL (History DB)
- Redis (Session cache, optional)
- AWS Bedrock SDK (Claude integration)
- Docker Compose (for local dev)

---

## 🛠️ Getting Started

1. **Clone the repo**
   ```bash
   git clone https://github.com/yourname/claude-chatbot-microservices.git
   cd claude-chatbot-microservices
