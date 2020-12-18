Create table `jogo`(
`codigo` int NOT NULL AUTO_INCREMENT,
`nome` varchar(100) DEFAULT NULL,
`numero` int NOT NULL,
`cnpj` int NOT NULL,
PRIMARY KEY (`codigo`),
FOREIGN KEY (`numero`) REFERENCES `console` (`numero`),
FOREIGN KEY (`cnpj`) REFERENCES `desenvolvedora` (`cnpj`)
);