# HMarkets.com Selenium Automation Suite

This project is a robust UI test automation framework for validating the core functionalities of [HMarkets.com](https://hmarkets.com). It focuses on form submission scenarios, ensuring both successful and negative test flows across key user-facing forms.

## 📌 Overview

This suite automates **end-to-end testing** for:

- ✅ **Live Account Opening Form**
- ✅ **Demo Account Opening Form**
- ✅ **Contact Us Form**

Both **successful form submissions** and **field-level validation errors** are thoroughly tested to ensure optimal user experience and system reliability.

---

## 💡 Key Features

- 🔄 **Comprehensive Form Testing** — Validates both positive and negative test flows.
- 🧱 **Modular Architecture** — Built using **Object-Oriented Design** and **Page Object Model**.
- 📦 **Data-Driven Testing** — Uses **external JSON files** to define expected validation messages and test inputs.
- ⚙️ **Environment Configurable** — Config properties such as URL is managed via `config.properties`.
- 🚀 **Scalable & Maintainable** — Designed for long-term use and easy expansion.
- 🧪 **TestNG + Maven** — For streamlined execution and dependency management.

---

## 🛠 Tech Stack

| Component      | Description                     |
|----------------|---------------------------------|
| Language       | Java                            |
| Framework      | Selenium WebDriver + TestNG     |
| Build Tool     | Maven                           |
| Data Format    | JSON                            |
| IDE            | IntelliJ IDEA (Recommended)     |
| Version Control| Git + GitHub                    |

---

## 🚀 Getting Started

### 🔧 Prerequisites

Ensure the following tools are installed on your machine:

- Java JDK 15 or above
- Maven 3.6+
- IntelliJ IDEA (or any Java IDE)
- Git
- Chrome browser (latest version)

### 📥 Clone the Repository

```bash
git clone https://github.com/chopradhruv6038/hMarket_Java_Selenium.git
cd hMarket_Java_Selenium

⚙️ Configure the Base URL
Navigate to src/main/resources/config.properties and ensure the base URL is set correctly:
hmarketswebURL=https://hmarkets.com/

🧪 Running the Tests
From IntelliJ IDEA:
Right-click on testng.xml or any test class.

Choose Run to execute tests via TestNG.

FROM Command Line:
mvn clean test

Maven will automatically resolve dependencies and execute the test suite.

✅ Test Coverage Summary:

Feature           | Positive Test | Negative Validation
Live Account Form | ✅            | ✅
Demo Account Form | ✅            | ✅
Contact Us Form   | ✅            | ✅


📚 Best Practices Followed:

✅ Page Object Model (POM) implementation

✅ Clean code and reusable components

✅ No hardcoded values – externalized via JSON and config.properties

✅ Organized test data and selectors

✅ TestNG annotations for grouping, parallelization, and prioritization

✅ Only explicit waits with conditions are used – no Thread.sleep() calls anywhere in the test code


👤 Author
Dhruv Chopra
Senior QA Engineer | Dubai
https://www.linkedin.com/in/dhruv-chopra-dxb/
