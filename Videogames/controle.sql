Create table `controle`(
`seq` int NOT NULL AUTO_INCREMENT,
`cor` varchar(30) DEFAULT NULL,
`numero` int NOT NULL,
PRIMARY KEY (`seq`),
FOREIGN KEY (`numero`) REFERENCES `console` (`numero`)
);