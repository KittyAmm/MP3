CREATE USER mp3 identified BY wawa;
GRANT dba TO mp3;
CONNECT mp3;
wawa


CREATE TABLE menu (
  idmenu VARCHAR(20),
  nom    VARCHAR(60),
  PRIMARY KEY (idmenu)
);

CREATE TABLE utilisateur (
  idutil        VARCHAR(20),
  nom           VARCHAR(50),
  mdp           VARCHAR(50),
  mail          VARCHAR(50),
  sexe          VARCHAR(50),
  datenaissance VARCHAR(50),
  datedajout    VARCHAR(50),
  PRIMARY KEY (idutil)
);

CREATE TABLE chanson (
  idson       VARCHAR(50),
  idartiste   VARCHAR(50),
  titre       VARCHAR(20),
  duree       VARCHAR(20),
  datedajout  VARCHAR(50),
  datepublier VARCHAR(50),
  PRIMARY KEY (idson),
  FOREIGN KEY (idartiste) REFERENCES artiste (idartiste)

);

CREATE TABLE artiste (
  idartiste  VARCHAR(20),
  idimage    VARCHAR(20),
  idson      VARCHAR(20),
  nom        VARCHAR(50),
  datedajout VARCHAR(50),
  PRIMARY KEY (idartiste),
  FOREIGN KEY (idimage) REFERENCES image (idimage),
  FOREIGN KEY (idson) REFERENCES chanson (idson)
);

CREATE TABLE album (
  idalbum     VARCHAR(20),
  idartiste   VARCHAR(20),
  idimage     VARCHAR(20),
  nom         VARCHAR(20),
  datedajout  VARCHAR(50),
  datepublier VARCHAR(50),
  PRIMARY KEY (idalbum),
  FOREIGN KEY (idimage) REFERENCES image (idimage),
  FOREIGN KEY (idartiste) REFERENCES artiste (idartiste)

);

CREATE TABLE genre (
  idgenre    VARCHAR(20),
  idimage    VARCHAR(20),
  idson      VARCHAR(20),
  nom        VARCHAR(50),
  datedajout VARCHAR(50),
  PRIMARY KEY (idgenre),
  FOREIGN KEY (idimage) REFERENCES image (idimage),
  FOREIGN KEY (idson) REFERENCES chanson (idson)
);

CREATE TABLE playlist (
  idplay     VARCHAR(20),
  idsong     VARCHAR(20),
  datedajout VARCHAR(50),
  PRIMARY KEY (idplay),
  FOREIGN KEY (idson) REFERENCES chanson (idson)
);

CREATE TABLE image (
  idmage VARCHAR(20),
  nom    VARCHAR(50),
  PRIMARY KEY (idmage)
);


