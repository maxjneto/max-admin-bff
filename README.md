# BFF for Customer/Transfers system management

This project is a BFF API for Customer/Transfers system management built with Java, Spring Boot, and Maven. It follows the Hexagonal Architecture pattern to ensure a clean separation of concerns.

## Table of Contents

- [Architecture](#architecture)
- [Endpoints](#endpoints)

## Architecture

The project is organized following the Hexagonal Architecture (Ports and Adapters) pattern. The main packages are:

- **domain**: Contains the core business logic and domain entities.
- **application**: Contains the application logic, including use cases and DTOs.
- **infrastructure**: Contains the implementation of the output ports, such as repositories and external services.
- **adapter**: Contains the input and output adapters, such as controllers and API clients.

## Endpoints

The API provides the following endpoints:

- POST /cliente: Create a new customer.
- GET /cliente/{id}: Get customer by ID.
- GET /cliente/nome/{nome}: Get customer by name.
- GET /cliente/contatos/{id}: Get customer contacts by ID.
- GET /cliente/documentos/{id}: Get customer documents by ID.
- GET /info/conta/numero/{numeroConta}: Get account by number.
- GET /info/conta/{id}: List accounts by customer ID.
- GET /info/saque/{numeroConta}: List withdrawals by account number.
- GET /info/deposito/{numeroConta}: List deposits by account number.
- GET /info/transferencias/todas/{id}: List all transfers by account ID.
- GET /info/transferencias/enviadas/{id}: List sent transfers by account ID.
- GET /info/transferencias/recebidas/{id}: List received transfers by account ID.

Refer to the `openapi.yaml` file for detailed API specifications.
