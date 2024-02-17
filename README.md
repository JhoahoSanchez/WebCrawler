# Web Crawler and Entry Filtering

A simple Java application for web scraping and entry filtering. It allows you to extract entries from a website and apply different filtering options. In this example, this [site](https://news.ycombinator.com) is used.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [Acknowledgments](#acknowledgments)

## Introduction

This Java application serves as a web crawler and entry filter. It scrapes entries from a website, extracts relevant information, and provides options to filter and sort the entries based on specific criteria.

## Features

- Web scraping focused on extract the first 30 entries from a website.
- Filtering options for entries with more than five words or less in the title.
- Sorting entries by the number of comments or points.

## Getting Started

### Prerequisites

Ensure you have the following installed:

- Java (version 17)
- NetBeans (version 20)

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/JhoahoSanchez/WebCrawler.git
    ```

2. Open the project with NetBeans:

3. Build the project:

## Usage

1. Run the application:

    ```bash
    java -jar target/WebCrawler-1.0-SNAPSHOT.jar
    ```

## Acknowledgments

- Thanks to the Jsoup library for simplifying HTML parsing.
