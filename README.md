# 🚛 FleetMax – Sistema de Gestão de Frotas

**FleetMax** é um aplicativo Android voltado à **gestão de frotas**, permitindo que empresas realizem o cadastro de motoristas, veículos e rotas, promovendo uma administração mais eficiente e organizada de suas operações logísticas.

## 👨‍💻 Discentes Desenvolvedores


📍 **21 de maio de 2025 – Juazeiro do Norte - CE**

---

## 🧾 Sumário

- [Introdução](#introdução)
- [Descrição do Aplicativo](#descrição-do-aplicativo)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Instruções de Execução](#instruções-de-execução)
- [Notas Importantes](#notas-importantes)
- [Futuras Etapas](#futuras-etapas)
- [Estrutura do Projeto](#estrutura-do-projeto)

---

## 📌 Introdução

A gestão de frotas é uma atividade essencial para empresas que dependem do transporte de mercadorias e serviços. O projeto **FleetMax** busca centralizar e otimizar a administração de veículos, motoristas e rotas, oferecendo uma plataforma acessível e funcional para empresas e gestores logísticos.

---

## 📱 Descrição do Aplicativo

FleetMax é uma **aplicação Android** com foco em:

- Cadastro de motoristas
- Cadastro de veículos
- Definição de rotas
- Associação entre motoristas, veículos e rotas
- Interface intuitiva, pensada para facilitar a navegação mesmo por usuários sem conhecimento técnico

> **Nota:** A versão atual é apenas uma simulação visual da interface.

---

## 🛠️ Tecnologias Utilizadas

- **Android Studio** – IDE para desenvolvimento do aplicativo
- **Kotlin** – Linguagem utilizada para a construção da lógica da aplicação
- **Gradle com Kotlin DSL** – Gerenciamento de build e dependências

---

## ▶️ Instruções de Execução

1. Abra o **Android Studio**
2. Faça o clone deste repositório ou importe o arquivo `.zip`
3. Aguarde a **sincronização com o Gradle**
4. Conecte um **emulador ou dispositivo Android físico**
5. Execute o projeto iniciando pela **MainActivity**

---

## ❗ Notas Importantes

- O projeto **ainda não possui backend ou banco de dados** integrado.
- Todas as informações exibidas são **somente para simulação da interface**.
- A navegação entre telas já está **parcialmente implementada**.

---

## 🔮 Futuras Etapas

- Integração com banco de dados (Firebase, SQLite, etc.)
- Implementação de sistema de autenticação funcional
- Adição de lógica de negócios para controle de frota em tempo real

---

## 📂 Estrutura do Projeto

```bash
FletMaxMobile/
├── app/
│   ├── build.gradle.kts         # Build específico do módulo app
│   └── src/main/
│       ├── AndroidManifest.xml  # Configuração das permissões e atividades
│       └── java/...             # Código-fonte da aplicação (em Kotlin)
├── build.gradle.kts             # Build principal com configurações do projeto
├── gradle/                      # Configurações do wrapper do Gradle
├── gradlew / gradlew.bat        # Executores do Gradle
├── settings.gradle.kts          # Configurações de módulos
└── local.properties             # Caminho local do SDK
