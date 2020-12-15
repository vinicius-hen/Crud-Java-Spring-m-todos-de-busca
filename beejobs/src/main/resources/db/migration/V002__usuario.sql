create table usuario (
   
		id bigInt AUTO_INCREMENT not null,
		nome varchar(20) not null,
		sobrenome varchar(20) not null,
		email varchar(50) not null,
		senha varchar(10) not null,
		servico varchar(100) not null,
		descricao_servico varchar(200) not null,
		cidade varchar(20) not null,
		estado varchar(10) not null,
		cep varchar(100) not null,
		taxa integer(50) not null,
		 PRIMARY KEY(id)
		
		
);