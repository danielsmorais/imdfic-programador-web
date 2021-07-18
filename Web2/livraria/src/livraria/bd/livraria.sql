CREATE SCHEMA livraria;

USE livraria;

CREATE TABLE `livros` (
  `idLivro` varchar(20),
  `titulo` varchar(256) DEFAULT NULL,
  `autores` varchar(45) DEFAULT NULL,
  `ano` integer,
  `preco` decimal(10,2) DEFAULT NULL,
  `quantidade` integer DEFAULT 0,
  `descricao` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `livraria`.`livros` (`idLivro`, `titulo`, `autores`, `ano`, `preco`, `quantidade`, `descricao`) 
VALUES ('0596005407', 'Head First Servlets and JSP', 'Bryan Basham, Kathy Sierra, Bert Bates', '2008', '200.5', '10', 'Livro sobre Servlets e JSP.');

INSERT INTO `livraria`.`livros` (`idLivro`, `titulo`, `autores`, `ano`, `preco`, `quantidade`, `descricao`) 
VALUES ('9788573935721', 'Desenvolvendo Aplicações Web com JSP, Servlets,Desenvolvendo Aplicações Web com JSP, Servlets, JavaServer Faces, Hibernate, EJB 3 Persistence e Ajax', 'Edson Gonçalves', '2007', '110.9', '15', 'Livro sobre tecnologias usadas na programação Java para Web.');

select * from livros;


