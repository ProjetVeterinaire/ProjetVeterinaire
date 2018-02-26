create table Clients(
CodeClient bigint identity not null,
Client varchar(20) not null,
PrenomClient varchar(30) not null,
Adresse1 varchar(30) not null,
Adresse2 varchar(30) not null,
CodePostal varchar(6) not null,
Ville varchar(25) not null,
NumTel varchar(15) not null,
Assurance varchar(30) not null,
Email varchar(20) not null,
Remarque varchar,
Archive bit
)

alter table Clients add constraint Clients_pk primary key (codeClient);

create table Animaux(
CodeAnimal bigint identity not null,
NomAnimal varchar(30) not null,
Sexe char(1) not null,
Couleur varchar(20) not null,
Race varchar(20) not null,
Espece varchar(20) not null,
CodeClient bigint not null,
Tatouage varchar(20) not null,
Antecedents varchar,
Archive bit 
)

alter table Animaux add constraint Animaux_pk primary key (CodeAnimal);

create table Personnels(
CodePers bigint identity not null,
Nom varchar(30) not null,
MotPasse varchar(10) not null,
Role char(3) not null,
Archive bit
)

alter table Personnels add constraint Personnels_pk primary key (CodePers);

create table Races(
Race varchar(20) not null,
Espece varchar(20) not null
)

alter table Races add constraint Races_pk primary key(Race, Espece)

create table Agendas(
CodeVeto bigint not null,
DateRdv date not null,
CodeAnimal bigint not null
)

alter table Agendas add constraint Agendas_pk primary key(CodeVeto, DateRdv, CodeAnimal) 

alter table Animaux add constraint Animaux_Clients_fk foreign key(CodeClient)
				references Clients
alter table Animaux add constraint Animaux_Races_fk foreign key(Race, Espece)
				references Races;
alter table Agendas add constraint Agendas_Animaux_fk foreign key(CodeAnimal)
				references Animaux;
alter table Agendas add constraint Agendas_Personnels_fk foreign key(codeVeto)
				references Personnels(CodePers);




