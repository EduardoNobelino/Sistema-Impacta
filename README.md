# Impacta

Sistema de gerenciamento de voluntários e ações socioambientais desenvolvido em Java.

## Sobre o projeto

O Impacta permite cadastrar voluntários e ações socioambientais, realizar inscrições e acompanhar a pontuação dos participantes.

O sistema possui três tipos de ações:

- Plantio
- Mutirão de Reciclagem
- Oficina Ecológica

Cada tipo de ação possui uma regra própria para cálculo de pontuação.

## Funcionalidades

- Cadastro de voluntários
- Cadastro de ações socioambientais
- Inscrição de voluntários em ações
- Controle de vagas
- Prevenção de inscrições duplicadas
- Prevenção de e-mails duplicados
- Cálculo de pontuação
- Ranking de voluntários
- Desempate por nome
- Tratamento de exceções
- Testes automatizados com JUnit

## Conceitos utilizados

O projeto utiliza conceitos de Programação Orientada a Objetos, incluindo:

- Encapsulamento
- Herança
- Polimorfismo
- Classes abstratas
- Sobrescrita de métodos
- Exceções personalizadas
- Collections (`HashMap` e `ArrayList`)

## Polimorfismo

A classe `AcaoSocioambiental` define o método `pontuacao()`, que é implementado de maneira diferente pelas classes:

- `Plantio`
- `MutiraoReciclagem`
- `OficinaEcologica`

Dessa forma, cada tipo de ação possui sua própria regra de pontuação.

## Testes

Foram desenvolvidos testes automatizados utilizando JUnit 5 para verificar:

- Cálculo polimórfico de pontuação
- Ordenação do ranking
- Desempate do ranking
- Acúmulo de pontos
- Inscrição duplicada
- Ação lotada
- E-mail duplicado
- Dados inexistentes
- Formato inválido de data

## Tecnologias

- Java
- Maven
- JUnit 5