# 📦 Projeto Spring Boot – Sistema de Mentorias

Aplicação backend com Spring Boot com o objetivo de criar uma API REST para gerenciamento de mentores, mentorados e suporte, permitindo operações de cadastro, listagem, atualização e remoção de registros dependendo da permissão ao grupo do usuario.

## Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Spring Security
- Spring Web
- MySQL
- Lombok
- JUnit
- Gradle

---

## 🛠️ Instalação e execução

### Pré-requisitos

- Java 17 instalado
- MySQL 8.0.42 em execução 
- Maven configurado (ou uso do wrapper `./mvnw`)
- Uma IDE como IntelliJ

## 📦 Dependências do Projeto (Gradle)

implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
implementation 'org.springframework.boot:spring-boot-starter-web'
implementation 'org.springframework.boot:spring-boot-starter-security'
compileOnly 'org.projectlombok:lombok'
runtimeOnly 'com.mysql:mysql-connector-j'
annotationProcessor 'org.projectlombok:lombok'
testImplementation 'org.springframework.boot:spring-boot-starter-test'
testRuntimeOnly 'org.junit.platform:junit-platform-launcher'


1. Clone o repositório:

bash
git clone github.com/RafaelRSCaldeira/Projeto-Engenharia-Software
