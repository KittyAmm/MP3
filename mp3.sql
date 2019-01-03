create user mp3 identified by wawa;
grant dba to mp3;
connect mp3;
wawa


create table menu(
    idmenu varchar(20),
    nom varchar(60),
    primary key(idmenu)
);

create table utilisateur(
    idutil varchar(20),
    nom varchar(50),
    mdp varchar(50),
    mail varchar(50),
    sexe varchar(50),
    datenaissance varchar(50),
	datedajout varchar(50),
    primary key(idutil)
);

create table chanson(
    idson varchar(50),
	idartiste varchar(50),
    titre varchar(20),
    duree varchar(20),
	datedajout varchar(50),
    datepublier varchar(50),
    primary key(idson),
    foreign key(idartiste) references artiste(idartiste)
   
);

create table artiste(
    idartiste varchar(20),
	idimage varchar(20),
	idson varchar(20),
    nom varchar(50),
	datedajout varchar(50),
    primary key(idartiste),
    foreign key(idimage) references image(idimage),
    foreign key(idson) references chanson(idson)
);

create table album(
    idalbum varchar(20),
	idartiste varchar(20),
	idimage varchar(20),
    nom varchar(20),
	datedajout varchar(50),
    datepublier varchar(50),
    primary key(idalbum),
	foreign key(idimage) references image(idimage),
    foreign key(idartiste) references artiste(idartiste)
  
);

create table genre(
    idgenre varchar(20),
    idimage varchar(20),
    idson varchar(20),
	nom varchar(50),
	datedajout varchar(50),
    primary key(idgenre),
	foreign key(idimage) references image(idimage),
    foreign key(idson) references chanson(idson)
);

create table playlist(
    idplay varchar(20),
    idsong varchar(20),
	datedajout varchar(50),
    primary key(idplay),
	foreign key(idson) references chanson(idson)
);

create table image(
    idmage varchar(20),
	nom varchar(50),
    primary key(idmage)
);

