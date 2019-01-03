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
    iduser varchar(20),
    nomuser varchar(50),
    pswrd varchar(50),
    Email varchar(50),
    sexe varchar(50),
    datenaissance varchar(50),
<<<<<<< HEAD
=======
	datedajout date,
>>>>>>> base io aaa
    primary key(iduser)
);

create table song(
    idsong varchar(50),
	idartiste varchar(50),
    titre varchar(20),
    duree varchar(20),
<<<<<<< HEAD
    datesortie date,
=======
	datedajout date,
    datepublier date,
>>>>>>> base io aaa
    primary key(idsong),
    foreign key(idartiste) references artiste(idartiste)
   
);

create table artiste(
    idartiste varchar(20),
	idimage varchar(20),
	idsong varchar(20),
    nom varchar(50),
<<<<<<< HEAD
=======
	datedajout date,
>>>>>>> base io aaa
    primary key(idartiste),
    foreign key(idimage) references image(idimage),
    foreign key(idsong) references song(idsong)
);

create table album(
    idalbum varchar(20),
	idartiste varchar(20),
	idimage varchar(20),
    nom varchar(20),
<<<<<<< HEAD
=======
	datedajout date,
    datepublier date,
>>>>>>> base io aaa
    primary key(idalbum),
	foreign key(idimage) references image(idimage),
    foreign key(idartiste) references artiste(idartiste)
  
);

create table genre(
    idgenre varchar(20),
    idimage varchar(20),
    idsong varchar(20),
	nom varchar(50),
<<<<<<< HEAD
=======
	datedajout date,
>>>>>>> base io aaa
    primary key(idgenre),
	foreign key(idimage) references image(idimage),
    foreign key(idsong) references song(idsong)
);

create table playlist(
    idp varchar(20),
    idsong varchar(20),
	datedajout Date,
    primary key(idp),
	foreign key(idsong) references song(idsong)
);

create table image(
    idmage varchar(20),
	nom varchar(50),
    primary key(idmage)
);

