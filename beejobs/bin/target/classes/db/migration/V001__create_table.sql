create table convite(
	
		id bigInt not null AUTO_INCREMENT ,
		titulo_vaga varchar(100) not null,
		faixa_salarial varchar(100) not null,
		regime_contratacao varchar(100) not null,
		descricao_vaga varchar (100) not null,
		email varchar(20) not null,
		password varchar(10) not null,
		taxa integer(50) not null,
		PRIMARY KEY (id)
		 
	
		
);
