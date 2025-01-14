# Automated Testing Framework

## Overview
This is a Selenium-based framework for automating tests on the Magento platform. It validates key features like search and cart functionality and generates detailed HTML reports.

---

## Tools Used
- **Java**
- **TestNG**
- **Selenium WebDriver**
- **ExtentReports**
- **Maven**

---

## How to Run
1. **Clone the Repository:**
   ```bash
   git clone <repository_url>
   cd <repository_directory>
   ```
2. **Install Dependencies:**
   ```bash
   mvn clean install
   ```
3. **Update ChromeDriver Path:**
   Set your ChromeDriver path in the `setUp()` method of `mainTestClass`.
4. **Run Tests:**
   - **In IDE:** Run `mainTestClass` as a TestNG test.
   - **Using Maven:**
     ```bash
     mvn test
     ```
5. **View Report:**
   Open `MyTestReport.html` in a browser.

---

## Features
- **Search Test:** Validates product search functionality.
- **Cart Test:** Ensures products can be added and verified in the cart.

---

## Page Object Model
The framework implements the Page Object Model (POM) design pattern for better code maintainability. All UI interactions are encapsulated in `PageObjectClass`, making test scripts clean and reusable.

---

## Contact
Author: Nasif Sadiq

