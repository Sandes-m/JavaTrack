# JavaTrack v1.0 - Sistema de Gestão de Clientes Inteligente 

---

## 🎯 Visão Geral do Projeto

Este projeto surgiu a partir de um exercício na minha formação em Java, onde o objetivo era apenas buscar o endereço 
do usuário via API e salvá-lo em JSON, Eu decidi ir um pouco além, usei esse exercício como a fundação para desenvolver esta aplicação, **um sistema back-end que superasse intencionalmente o nível de um projeto de formação básica**.

**O que é:** Um sistema de console em Java Puro para **Gerenciamento e Cadastro Persistente de Clientes** de um pequeno negócio.

**O Objetivo:** Aplicar o máximo de conceitos já estudados e **buscar ativamente** conhecimentos de arquitetura de alto nível 
(como POO, Persistência, Variáveis de Ambiente) **antes mesmo de iniciar os estudos formais de Frameworks** (como Spring Boot).

---

## ✅ Status

**Versão 1.0 (Concluída):** Back-end robusto com funcionalidade de cadastro e persistência de dados (JSON) totalmente implementada. Contém validação de formato e integração real de API externa (ViaCEP e as bibliotecas `libphonenumber` e `Gson`). 

**Versão 2.0 (Em Planejamento):** Foco na migração para **Spring Boot**, implementação de API REST, persistência em Banco de Dados **(`MySQL/PostgreSQL`)** e a inclusão de **Agentes de IA**.

---

## 🧩 Estrutura do Projeto

A aplicação foi desenvolvida em Java Puro (JDK 17+), organizada em pacotes lógicos para melhor manutenção e escalabilidade.
Além da estrutura src, o projeto contém as pastas **libs (dependências externas)** e **data (persistência local em JSON)**.

```text
JavaTrack/
├── src/
│   ├── main/
│   │   └── Main.java
│   │
│   ├── model/
│   │   ├── Cliente.java
│   │   ├── Endereco.java
│   │   └── Pessoa.java
│   │
│   ├── service/
│   │   ├── GestaoDeClientes.java
│   │   ├── ViaCEPService.java
│   │   ├── Menu.java
│   │   └── NacionalityService.java
│   │
│   ├── utils/
│   │   ├── CadastrosUtils.java
│   │   └── ConsoleUtils.java
│   │
│   └── exception/
│       └── EnvVarNotFoundException.java
│
├── libs/
│   ├── gson.jar
│   ├── libphonenumber.jar
│   └── lingua.jar
│
├── data/
│   └── Clientes.json
└── README.md
```
---
## 🧰 Tecnologias e Ferramentas Utilizadas

| Linguagem | IDE | Controle de Versão |                                                                                                                                                                                              Bibliotecas / Ferramentas de Apoio                                                                                                                                                                                               |
|:----------:|:---:|:-----------------:|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
| ![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white) | ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-000000?style=flat-square&logo=intellijidea&logoColor=white) | ![Git](https://img.shields.io/badge/Git-F05032?style=flat-square&logo=git&logoColor=white) | ![Gson](https://img.shields.io/badge/Gson-4285F4?style=flat-square&logo=google&logoColor=white) ![libphonenumber](https://img.shields.io/badge/libphonenumber-34A853?style=flat-square&logo=google&logoColor=white) ![ChatGPT](https://img.shields.io/badge/ChatGPT-10A37F?style=flat-square&logo=openai&logoColor=white) ![Gemini](https://img.shields.io/badge/Gemini-FF7F7F?style=flat-square&logo=google&logoColor=white) |

---

## 🧠 Lições de Arquitetura e Crescimento (O Que Aprendi)

Construí esse projeto com foco em **Boas Práticas de Back-end**, e esta sessão detalha o conhecimento técnico e estratégico adquirido.

### 1. Orientação a Objetos (POO) e Organização Estrutural
Aprendi a importância de aplicar o conceito de **Single Responsibility Principle (SRP)** ou **Princípio da Responsabilidade Única**, que me possibilitou
ter um `main` totalmente funcional a partir de um único método usado `Menu.executar`, algo que definitivamente buscarei aplicar em todos os meus projetos.

Também pude colocar em prática os meus aprendizados de encapsulamento e herança além de criar uma base mais robusta sobre **I/O** e **Validação**

### 2. Gestão de Dados e Segurança
Tive oportunidade de pesquisar e aprender mais sobre os pilares de segurança dentro duma aplicação, graças as ferramentas de IA como apoio conheci as **`Variáveis de ambiente`**, essenciais para manter dados sensíveis protegidos e amplamente utilizadas no desenvolvimento.

Reforcei o meu aprendizado sobre **`try-catch`**, podendo conhecer diferentes tipos de excessões e criar a minha própria `EnvVarNotFoundException` personalizada para os casos em que a variável de ambiente `VIACEP_URL` não esteja configurada corretamente.

Aprendi e reforcei os meus conhecimentos sobre as bibliotecas, podendo aplicar `Gson`, `libphonenumber` diretamente no meu projeto, com isso entendi um pouco mais sobre arquivos `.jar` e como aplicá-los via estrutura do projeto.

### 3. O Desafio da Evolução

Por fim entendi que existe um limite até onde o desenvolvimento em java puro pode chegar, por mais que eu tenha grandes ideias ainda para esse projeto, cheguei num ponto onde optei por seguir os meus estudos em java antes de dar os próximos passos.

---
## 🖥️ Contatos

| Network Profile | E-mail | Social Profile |
|------------------|------------------|------------------|
| [![LinkedIn](https://img.shields.io/badge/LinkedIn-0A66C2?style=flat&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/paulo-m-sandes-51742422b) | [![Gmail](https://img.shields.io/badge/Gmail-EFEFEF?style=flat&logo=gmail&logoColor=555555)](mailto:paulohenriquesandes@gmail.com) | [![Instagram](https://img.shields.io/badge/Instagram-E1306C?style=flat&logo=instagram&logoColor=white)](https://www.instagram.com/sandes_xz) |

---
## ✍🏻 Teste o projeto 
```text
1. Clone o repositório:
   git clone https://github.com/seu-usuario/JavaTrack.git

2. Entre na pasta do projeto:
   cd JavaTrack

3. Compile todo o projeto (Java 17+):
   javac -cp "libs/*" -d bin src/**/*.java

4. Execute o sistema:
   java -cp "bin:libs/*" main.Main

# Observações importantes
- Configure a variável de ambiente `VIACEP_URL` antes de rodar.
- Dados de clientes são salvos automaticamente em `data/Clientes.json`.
