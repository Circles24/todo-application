<!-- Improved compatibility of back to top link: See: https://github.com/Circles24/todo-application/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">

[//]: # (  <a href="https://github.com/Circles24/todo-application">)

[//]: # (    <img src="images/logo.png" alt="Logo" width="80" height="80">)

[//]: # (  </a>)

<h3 align="center">TODO Application</h3>

  <p align="center">
    A CLI based todo application!
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

This is your yet another todo application, nothing special here it just persist the records in sqllite and exposes cli API for crud operations. 



### Built With
This application is built with java along with few mainstream libraries like, jdbi, jdbc, lombok, etc.

* [![Java][Java]][Java-url]


<!-- GETTING STARTED -->
## Getting Started

To get started clone the repository and build the application.

### Prerequisites

Your system needs to have maven installed to build the application.
* install maven
  ```shell
  brew install maven
  ```

### Installation

1. Clone the repository
    ```shell
    git clone https://github.com/Circles24/todo-application.git
    ```
3. Build the project
   ```shell
   mvn clean install
   ```
4. Use CLI to command the todo-application
   ```shell
   java -jar <jar name> <cmd> <args> ...
   ```


<!-- USAGE EXAMPLES -->
## Usage

Todo application supports the following 6 commands.
1. ADD
2. GET
3. UPDATE
4. DELETE
5. GET_ALL
6. HELP

eg:
1. HELP
    ```shell
    java -jar target/todo-application-1.0-SNAPSHOT-jar-with-dependencies.jar help
    ```
2. ADD
    ```shell
    java -jar target/todo-application-1.0-SNAPSHOT-jar-with-dependencies.jar add walk the dog
    ```
3. GET
    ```shell
    java -jar target/todo-application-1.0-SNAPSHOT-jar-with-dependencies.jar get 60e3b65f-9f84-47a1-b40e-0a0f4e7a998b
    ```
3. GET_ALL
    ```shell
    java -jar target/todo-application-1.0-SNAPSHOT-jar-with-dependencies.jar get_all
    ```
4. UPDATE
    ```shell
    java -jar target/todo-application-1.0-SNAPSHOT-jar-with-dependencies.jar update 60e3b65f-9f84-47a1-b40e-0a0f4e7a998b walk the dog in park
    ``` 
5. DELETE
    ```shell
    java -jar target/todo-application-1.0-SNAPSHOT-jar-with-dependencies.jar delete 60e3b65f-9f84-47a1-b40e-0a0f4e7a998b
    ```

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<!-- CONTACT -->
## Contact

Suraj Singh Rana - surajsinghrana7417@gmail.com

Project Link: [https://github.com/Circles24/todo-application](https://github.com/Circles24/todo-application)

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/Circles24/todo-application.svg?style=for-the-badge
[contributors-url]: https://github.com/Circles24/todo-application/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/Circles24/todo-application.svg?style=for-the-badge
[forks-url]: https://github.com/Circles24/todo-application/network/members
[stars-shield]: https://img.shields.io/github/stars/Circles24/todo-application.svg?style=for-the-badge
[stars-url]: https://github.com/Circles24/todo-application/stargazers
[issues-shield]: https://img.shields.io/github/issues/Circles24/todo-application.svg?style=for-the-badge
[issues-url]: https://github.com/Circles24/todo-application/issues
[license-shield]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[license-url]: https://github.com/Circles24/todo-application/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/suraj-rana-24circles/
[product-screenshot]: images/screenshot.png
[Java]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://www.java.com/en/
