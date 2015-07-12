CREATE TABLE cliente(
id INT NOT NULL,
nome VARCHAR(30) NOT NULL,
sobrenome VARCHAR(30) NOT NULL,
idade VARCHAR(30) NOT NULL,
numeroCNH VARCHAR(30) NOT NULL,
cpf VARCHAR(30) NOT NULL,

PRIMARY KEY(id)
);

CREATE TABLE veiculo(
id INT NOT NULL,
modelo VARCHAR(30) NOT NULL,
fabricante VARCHAR(30) NOT NULL,
placa VARCHAR(30) NOT NULL,
chassi VARCHAR(30) NOT NULL,
ano VARCHAR(30) NOT NULL,

PRIMARY KEY(id)
);


CREATE TABLE aluguel(
id INT NOT NULL,
idCliente INT NOT NULL,
idVeiculo INT NOT NULL,
valorAluguel DOUBLE NOT NULL,
dataInicio VARCHAR(30) NOT NULL,
dataDevolucao VARCHAR(30) NOT NULL,

PRIMARY KEY(id)
);

CREATE TABLE multa(
id INT NOT NULL,
idCliente INT NOT NULL,
idVeiculo INT NOT NULL,
valor DOUBLE NOT NULL,
pontuacao int NOT NULL,

PRIMARY KEY(id)
);



ALTER TABLE aluguel ADD CONSTRAINT fk_Aluguel_Cliente FOREIGN KEY (idCliente) 
REFERENCES cliente (id);

ALTER TABLE aluguel ADD CONSTRAINT fk_Aluguel_Viculo FOREIGN KEY (idVeiculo) 
REFERENCES veiculo (id);

ALTER TABLE multa ADD CONSTRAINT fk_Multa_Cliente FOREIGN KEY (idCliente) 
REFERENCES cliente (id);

ALTER TABLE multa ADD CONSTRAINT fk_Multa_Viculo FOREIGN KEY (idVeiculo) 
REFERENCES veiculo (id);
