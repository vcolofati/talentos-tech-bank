drop table academia;

create table academia (
	id int not null primary key,
	nome varchar not null
);

create table personal (
	id int not null primary key,
	nome varchar not null,
	cref varchar not null
);

create table aluno (
	id int not null primary key,
	nome varchar not null,
	idade int not null,
	id_academia int not null,
	id_personal int,
	foreign key(id_academia) references academia(id),
	foreign key(id_personal) references personal(id)
);

create table personais_habilitados(
	id_personal int not null,
	id_academia int not null,
	primary key(id_personal, id_academia),
	foreign key(id_personal) references personal(id),
	foreign key(id_academia) references academia(id)
);

INSERT INTO academia values(1, 'SmartGit');
insert into academia values (2, 'Força');
insert into academia values (3, 'Be Fitness');
insert into academia values (4, 'Bolt');
insert into academia values (5, 'GitExpress');
insert into academia values (6, 'Monstrão');
INSERT INTO PERSONAL VALUES (1, 'Rebecca', 12354);
INSERT INTO PERSONAL VALUES (2, 'Eder', 54321);
INSERT INTO PERSONAL VALUES (3, 'Ari', 9876);
INSERT INTO PERSONAL VALUES (4, 'Arlindão', 9090);
INSERT INTO aluno values(1, 'Aretha', 20, 1, 1);
INSERT INTO aluno values(2, 'Douglas', 21, 1, null);
INSERT INTO aluno values(3, 'Bruno Souza', 22, 1, 2);
INSERT INTO aluno values(4, 'Bruno Brito', 23, 2, 2);
INSERT INTO aluno values(5, 'Ana Beatriz', 24, 3, 2);
INSERT INTO aluno values(6, 'Raquel', 25, 4, null);
INSERT INTO aluno values(7, 'Mayara', 26, 4, 3);
INSERT INTO aluno values(8, 'Nicoli', 27, 4, 3);
INSERT INTO aluno values(9, 'Rafaela', 28, 4, null);
INSERT INTO aluno values(10, 'Victor', 29, 5, 4);
INSERT INTO aluno values(11, 'Giovanna', 30, 5, null);
INSERT INTO aluno values(12, 'Carolina', 31, 4, 4);
INSERT INTO aluno values(13, 'Yuri', 32, 3, 3);
INSERT INTO aluno values(14, 'Daiane', 33, 2, 2);
INSERT INTO aluno values(15, 'Gisele', 34, 1, 1);
INSERT INTO aluno values(16, 'Mariana', 35, 5, null);
INSERT INTO personais_habilitados values (1,1);
insert into personais_habilitados values (1, 2);
insert into personais_habilitados values (2, 1);

-- seleciona todas as academias que não tem alunos
select
	ac.nome as nome_da_academia
from
	academia ac
left join aluno al
on
	ac.id = al.id_academia
where
	al.id is null;

-- seleciona os personais e os alunos de cada um.
select
	p.nome nome_personal,
	a.nome nome_do_aluno
from
	personal p
join aluno a
on
	p.id = a.id_personal
order by p.nome;

-- seleciona todos alunos da academia 1 que não possuem personal
select
	*
from
	aluno a
where
	a.id_personal is null
	and a.id_academia = 1;

-- seleciona todos personais habilitados na academia 1
select
	*
from
	personais_habilitados ph
join personal p
on
	p.id = ph.id_personal
join academia a
on
	a.id = ph.id_academia
where
	ph.id_academia = 1;

-- seleciona as academias com menos de 3 alunos sendo que a academia Força não entra na pesquisa.
select
		ac.id,
		ac.nome,
		count(al.id) as total
from
		academia ac
left join aluno al
on
		ac.id = al.id_academia
where
		ac.nome <> 'Força'
group by
		ac.id,
		ac.nome
having
		count(al.id) < 3
order by
	total desc;

--média da idade dos alunos entre todas academias com cast para inteiro
select
	cast(avg(idade) as int) as mediaa_da_idade_dos_alunos
from
	aluno a
where
	a.idade is not null;

-- seleciona alunos com menos de 30 anos ordenados de forma decrescente.
select
	a.nome,
	a.idade
from aluno a
where a.idade < 30
ORDER BY a.idade desc;

-- seleciona os nomes, idades de todos alunos com mais de 21 anos e menos que 23 do personal Eder
SELECT
 	a.nome,
 	a.idade
FROM aluno a
JOIN personal p
ON a.id_personal == p.id
WHERE p.nome = "Eder" AND a.idade > 21 AND a.idade < 23;


ALTER TABLE academia ADD COLUMN telefone VARCHAR;
ALTER TABLE academia ADD COLUMN email VARCHAR;

ALTER TABLE personal ADD COLUMN telefone VARCHAR;
ALTER TABLE personal ADD COLUMN email VARCHAR;

ALTER TABLE aluno ADD COLUMN telefone VARCHAR;
ALTER TABLE aluno ADD COLUMN email VARCHAR;

