CREATE DATABASE hospital;

USE hospital;

CREATE TABLE Medico (
    ID_Medico INT PRIMARY KEY, 
    Nombre VARCHAR(255),
    Especialidad VARCHAR(255),
    Numero_de_telefono VARCHAR(20)
);

CREATE TABLE Enfermera (
    ID_Enfermera INT PRIMARY KEY, 
    Nombre VARCHAR(255),
    Numero_de_telefono VARCHAR(20)
);

CREATE TABLE Paciente (
    ID_Paciente INT PRIMARY KEY,
    Nombre VARCHAR(255),
    Edad INT,
    Genero VARCHAR(10),
    Sintomas TEXT,
    Prioridad VARCHAR(20),
    ID_Enfermera INT,
    ID_Medico INT,
    FOREIGN KEY (ID_Enfermera) REFERENCES Enfermera(ID_Enfermera),
    FOREIGN KEY (ID_Medico) REFERENCES Medico(ID_Medico)
);

CREATE TABLE Resultados (
    ID_Resultado INT PRIMARY KEY, 
    ID_Paciente INT,
    Diagnostico TEXT,
    Tratamiento_recomendado TEXT,
    Fecha_del_resultado DATE,
    FOREIGN KEY (ID_Paciente) REFERENCES Paciente(ID_Paciente)
);