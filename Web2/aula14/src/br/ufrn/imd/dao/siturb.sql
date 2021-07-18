CREATE SCHEMA siturb;

USE siturb;

CREATE TABLE `cobrador` (
	`nome` varchar(400),
	`cpf` varchar(20),	
	`matricula` varchar(20), 
	`endereco` varchar(4000)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `empresa` (
	`razao_social` varchar(500),
	`cnpj` varchar(40)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `linha` (
	`ident` varchar(10),
	`origem` varchar(100),	
	`destino` varchar(100), 
	`hora_saida` varchar(5),
	`hora_chegada` varchar(5)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `motorista` (
	`nome` varchar(400),
	`cpf` varchar(20),	
	`matricula` varchar(20), 
	`endereco` varchar(4000),
	`registro_cnh` VARCHAR(100),
	`categoria_cnh` VARCHAR(2)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `onibus` (
	`marca` varchar(100),
	`modelo` varchar(100),
	`ano` INT,
	`razao_social_empresa` varchar(500),
	`ident_linha` varchar(10),
	`nome_cobrador` varchar(400),
	`nome_motorista` varchar(400) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

show tables;

insert into cobrador (nome, cpf, matricula, endereco) 
	values ('Peter Parker', '111.111.111-11', '111011-1', 'Rua das Casas, NY.');
    
insert into motorista (nome, cpf, matricula, endereco, registro_cnh, categoria_cnh) 
	values ('Tony Stark', '222.222.222-22', '121121-2', 'Malibu', '11123', 'AE');   
    
insert into empresa (razao_social, cnpj) 
	values ('Empresas Stark', '26.118.781/0001-07');
    
insert into linha (ident, origem, destino, hora_saida, hora_chegada) 
	values ('49', 'Rodoviária', 'Midway', '11:00', '12:30');
    
insert into onibus (marca, modelo, ano, razao_social_empresa, ident_linha, nome_cobrador, nome_motorista) 
	values ('0371', 'Mercedes', 1999, 'Empresas Stark', '49', 'Peter Parker', 'Tony Stark');  
    
    
SELECT * FROM `cobrador`;
SELECT * FROM `motorista`;
SELECT * FROM `empresa`;
SELECT * FROM `linha`;
SELECT * FROM `onibus`;


