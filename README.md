# API Docker - User Management

## Descrição do Projeto

API REST desenvolvida em **Spring Boot** para gerenciamento de usuários. O projeto demonstra a integração de uma aplicação Spring Boot com um banco de dados PostgreSQL (Neon) e containerização com Docker.

## O que foi implementado

- ✅ **API REST** com endpoints para CRUD de usuários
- ✅ **Banco de Dados PostgreSQL** (Neon Cloud)
- ✅ **ORM JPA/Hibernate** para persistência de dados
- ✅ **Docker** para containerização da aplicação
- ✅ **Variáveis de ambiente** para configuração segura das credenciais
- ✅ **Spring Data JPA** para operações em banco de dados

## Endpoints Disponíveis

- `POST /users` - Criar novo usuário
- `GET /users/all` - Listar todos os usuários
- `PUT /users/{id}` - Atualizar usuário
- `DELETE /users/{id}` - Deletar usuário

## Requisitos

- Docker instalado
- Docker Compose (opcional)
- Java 17+ (para desenvolvimento local)
- Maven (para desenvolvimento local)

## Como Rodar

### 1. Preparar o Container Docker

Compile o projeto e crie o build do Docker:

```bash
# Build do Maven (gera o JAR)
mvn clean package

# Build da imagem Docker
docker build -t api-teste .
```

### 2. Executar o Container

```bash
docker run -p 8080:8080 api-teste
```

A API estará disponível em: `http://localhost:8080`

### 3. Testar os Endpoints

```bash
# Criar um usuário
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{"name": "João", "email": "joao@example.com"}'

# Listar todos os usuários
curl http://localhost:8080/users/all
```

## Variáveis de Ambiente

As credenciais do banco de dados estão configuradas no arquivo `.env`:

```
SPRING_DATASOURCE_URL=jdbc:postgresql://...
SPRING_DATASOURCE_USERNAME=neondb_owner
SPRING_DATASOURCE_PASSWORD=npg_XYIqKkCBU78F
```

## Estrutura do Projeto

```
src/main/java/com/example/docker/
├── controller/     # Endpoints REST
├── entity/        # Modelos de dados
├── dto/           # Data Transfer Objects
├── service/       # Lógica de negócio
└── repository/    # Acesso a dados
```

## Tecnologias Utilizadas

- **Spring Boot 4.0.5**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **Docker**
- **Maven**

---

**Desenvolvido para demonstrar containerização de aplicações Spring Boot com Docker.**
