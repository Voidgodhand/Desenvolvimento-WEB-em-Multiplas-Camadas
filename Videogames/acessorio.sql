create table `acessorio`(
`id` int NOT NULL AUTO_INCREMENT,
`nome` varchar(100) DEFAULT NULL,
`numero` int NOT NULL,
PRIMARY KEY (`id`),
FOREIGN KEY (`numero`) REFERENCES `console`(`numero`) 
);