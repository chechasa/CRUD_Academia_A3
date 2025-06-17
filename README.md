💪 Sistema de Academia em Java
Este é um projeto simples de um sistema de gerenciamento de alunos e treinos para uma academia, desenvolvido em Java com base em menus interativos via terminal. Ele permite cadastrar, listar, editar, excluir e buscar alunos e treinos associados a eles.

✅ Funcionalidades
Alunos:
Cadastrar novo aluno
Listar todos os alunos
Atualizar dados de um aluno
Excluir aluno por nome ou CPF
Buscar aluno por nome ou CPF


Treinos:
Cadastrar treino para um aluno (por ID)
Listar treinos de um aluno específico
Editar um treino existente
Excluir treino por ID


Código Sql para o BD:
CREATE DATABASE IF NOT EXISTS academia_db;
USE academia_db;

CREATE TABLE IF NOT EXISTS alunos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    data_nascimento DATE NOT NULL,
    telefone VARCHAR(15),
    email VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS treinos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_aluno INT NOT NULL,
    tipo_treino VARCHAR(50) NOT NULL,
    descricao TEXT,
    duracao INT NOT NULL,
    data_inicio DATE NOT NULL,
    FOREIGN KEY (id_aluno) REFERENCES alunos(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

📦 Requisitos
Java 8 ou superior

IDE (Eclipse, IntelliJ, VSCode) ou terminal com javac

Biblioteca JDBC + Conexão com banco de dados (MySQL, PostgreSQL etc.)

Banco de dados já configurado com as tabelas alunos e treinos

📌 Observações
O sistema utiliza Scanner para entrada de dados.

A persistência é feita por meio de classes DAO (AlunoDAO e TreinoDAO).

Os dados devem ser armazenados em um banco relacional configurado previamente.

🧑‍💻 Autores
Desenvolvido por Maickel Cardoso, Erick Mello, Arthur Abilio e Marcos Lotici

