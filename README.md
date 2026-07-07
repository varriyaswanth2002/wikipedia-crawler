# Multithreaded Wikipedia Crawler and Frequency Analyser

A high-performance Java web application built on Spring MVC that concurrently crawls Wikipedia articles based on user keywords, extracts structured text and image components, and integrates a custom Word Frequency Analyser.

## System Features

* **Concurrent Multi-Threading**: Implements Java's Runnable interface to execute data scraping pipelines for multiple keywords simultaneously, avoiding main thread block.
* **HTML Content Parsing**: Utilizes JSoup to extract and sanitize remote HTML DOM hierarchies, isolating article text blocks from primary image coordinates.
* **JSON Serialization Engine**: Integrates GSON to serialize data objects into lightweight web payloads.
* **Word Frequency Analytics**: Features a standalone processing engine that calculates exact word distributions and term densities from raw text files.
* **Database Management**: Configured to interface with a local PostgreSQL database cluster using jOOQ queries for persistent data operations.

## Technical Architecture

* **Backend Core**: Java Spring MVC
* **Build System**: Maven
* **Core Libraries**: JSoup (HTML Scraper), GSON (JSON Engine)
* **Deployment Server**: Jetty Web Container Plugin
* **Frontend Components**: JavaServer Pages (JSP), Responsive JavaScript, CSS3

## Application Routes

* `/helloworld` - Basic health check endpoint confirming view resolver connectivity.
* `/login/user` - Dedicated portal layout for student authentication logs.
* `/api/time` - Dynamic endpoint exposing current system epoch time parameters.
* `/api/wiki?keyword=YOUR_TERM` - Returns structural text summaries and absolute image source links in raw JSON format.
* `/api/wiki/html?keyword=YOUR_TERM` - Renders scraped Wikipedia datasets directly into a clean, readable web page layout.

## Full Project Documentation

The complete technical report, code structure analysis, compilation timelines, and environment verification logs are available in the repository documentation file: [WikiCrawlerProject.docx](./WikiCrawlerProject.docx)

