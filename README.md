# Multithreaded Wikipedia Crawler and Frequency Analyser

A full-stack Java web application built using **Spring MVC** and **PostgreSQL** that concurrently crawls Wikipedia articles based on user keywords, extracts structured text and image content, performs word frequency analysis, and exposes the processed data through REST APIs and dynamic web pages.

## Technologies

**Backend:** Java, Spring MVC

**Frontend:** JSP, HTML, CSS, JavaScript

**Database:** PostgreSQL using jOOQ

**Libraries:** JSoup, Gson

**Build Tool:** Maven

**Deployment:** Jetty Plugin

**Concurrency:** Java Multithreading (Runnable Interface)

## System Core Features

- Concurrent Wikipedia article crawling using Java multithreading (`Runnable`)
- HTML parsing and content extraction using JSoup
- JSON serialization using Gson
- Word Frequency Analysis for uploaded text files
- PostgreSQL integration using jOOQ
- Dynamic HTML rendering of crawled Wikipedia content
- REST APIs for structured JSON responses

## Technical Architecture Stack

**Backend Framework:** Java Spring MVC

**Database Query Engine:** jOOQ

**Database Server:** PostgreSQL

**Libraries:** JSoup, Gson

**Frontend:** JSP, HTML, CSS, JavaScript

**Build Tool:** Maven

**Deployment:** Jetty Plugin

## Application Routes

- `/helloworld` – Health check endpoint
- `/login/user` – User login portal
- `/api/time` – Returns current server time
- `/api/wiki?keyword=YOUR_TERM` – Returns Wikipedia data in JSON format
- `/api/wiki/html?keyword=YOUR_TERM` – Displays crawled content in HTML format

## Project Documentation

The repository contains **[WikiCrawlerProject.pdf](./WikiCrawlerProject.pdf)**, which includes:

- Complete System Architecture
- Folder Structure
- Database Schema
- REST API Screenshots
- User Interface Screenshots
- Project Workflow
- Implementation Details
