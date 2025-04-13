# 🔗 Spring Boot URL Shortener System

This project is a remake of a previously developed Node.js system, rebuilt using **Spring Boot**. It’s a performant, scalable, and modular URL shortener built with a custom UID generator and intelligent caching.

## 🧠 System Overview

The system is divided into multiple services/components:

1. **UID Generator Service**
   - A Spring Boot microservice that generates unique IDs.
   - Ensures scalability and uniqueness across requests.
   - 🔗 [View UID Generator Repo](https://github.com/Chiheb-Ellefi/Unique_Id_Gen)

2. **URL Shortener Service**
   - Accepts a long URL, fetches a unique ID, hashes it, and returns a short URL.
   - Uses Hibernate + Spring Data JPA to persist mappings to PostgreSQL.
   - Caches data in Redis to reduce latency.
   - Clicks are tracked, and a Redis Pub/Sub event updates persistent data asynchronously.

3. **Cache Management**
   - Uses **Redis** for fast GET operations and click counting.
   - A **cron job** periodically invalidates stale cache entries.
   - Ensures consistency between cache and PostgreSQL.

4. **Spring AOP Integration**
   - Custom AOP is used to log requests or encapsulate cross-cutting concerns like cache refresh, hit/miss logging, etc.

---

## ⚙️ Tech Stack

| Layer             | Technology           |
|------------------|----------------------|
| Language          | Java (Spring Boot)   |
| Persistence       | PostgreSQL + JPA + Hibernate |
| Caching & Pub/Sub | Redis                |
| Background Tasks  | Spring Scheduled Tasks (cron) |
| AOP               | Spring AOP           |

---

## 🚀 How It Works

1. **Shortening**
   - User sends a long URL.
   - System requests a UID from the UID Generator.
   - The UID is hashed (e.g., base62) and mapped to the long URL.
   - Mapping is stored in PostgreSQL and cached in Redis.

2. **Redirection**
   - User visits a short URL.
   - The hash is looked up in Redis.
   - If found → redirect and increment click count in Redis.
   - A Redis Pub/Sub message triggers a DB update via a listener service.

3. **Cache Invalidation**
   - A scheduled cron job runs at fixed intervals to evict or refresh stale Redis cache keys.

