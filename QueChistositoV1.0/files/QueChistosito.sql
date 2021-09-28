DROP DATABASE IF EXISTS que_chistosito_db;
CREATE DATABASE que_chistosito_db;
USE que_chistosito_db;

-- Drop Tables
        
DROP TABLE IF EXISTS users; 
CREATE TABLE users (
                            
	email VARCHAR(100) NOT NULL PRIMARY KEY,
                                            
	password VARCHAR(100) NOT NULL,

	firstname VARCHAR(100) NOT NULL,

	lastname VARCHAR(100) NOT NULL 

);

DROP TABLE IF EXISTS jokes;

CREATE TABLE jokes (
	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	joke_creator_email VARCHAR(100) NOT NULL,
	name VARCHAR(100) NOT NULL,
	category VARCHAR(100) NOT NULL,
	key_words VARCHAR(500) NOT NULL,
	content VARCHAR(2500)  NOT NULL,
	image VARCHAR(1000) NOT NULL,
	FOREIGN KEY (joke_creator_email) REFERENCES users(email)	
);

DROP TABLE IF EXISTS blog_entries;

CREATE TABLE blog_entries (
	
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	user_email VARCHAR(100) NOT NULL,
	entry_value VARCHAR(2000) NOT NULL,
	registration_date TIMESTAMP NOT NULL,
	
	INDEX user_email_index (user_email),
    FOREIGN KEY (user_email)
        REFERENCES users(email)
        ON DELETE CASCADE
);


INSERT INTO users VALUES ("admin@novalidserver.net", "passw0rd", "Admin", "");
INSERT INTO users VALUES ("pato@gmail.com", "1234", "Angel Uriel", "Lopez Patricio");
INSERT INTO users VALUES ("guillermart@gmail.com", "passw0rd", "Guillermo", "Martinez");
INSERT INTO users VALUES ("guillermart@hotmail.com", "passw0rd", "Guillermo", "Martinez");
INSERT INTO users VALUES ("maryjane.watson@dccomics.com", "passw0rd", "Mary Jane", "Watson");
INSERT INTO users VALUES ("salvador.m2303@gmail.com", "passw0rd", "Salvador", "Miranda Flores");
INSERT INTO users VALUES ("fran.huesca9706@gmail.com", "Mishuevos115!", "Francisco", "Huesca");


INSERT INTO jokes (joke_creator_email, name, category, key_words, content,image)
VALUES( 
"salvador.m2303@gmail.com",
"Tropiezo", 
"Inocente", 
"Mam�, hijo, abuelo", 
"Mam�, mam�, el abuelo se cay�... �Lo ayudaste hijo?... No, se cay� solo.",
"images/4.jpg");


INSERT INTO jokes (joke_creator_email, name, category, key_words, content,image)
VALUES( 
"salvador.m2303@gmail.com",
"Lugar", 
"Inocente", 
"Ni�o, bicicleta, casa", 
"�Sabes que mi hermano anda en bicicleta desde los cuatro a�os?... Mmm, ya debe estar lejos.",
"images/5.jpg");


INSERT INTO jokes (joke_creator_email, name, category, key_words, content,image)
VALUES( 
"salvador.m2303@gmail.com",
"Casa", 
"Inocente", 
"Ni�o, escuela, mama", 
"�Mam�, en el colegio me llaman distra�do... Juanito, tu vives en la casa de enfrente.",
"images/6.jpg");


INSERT INTO jokes (joke_creator_email, name, category, key_words, content,image)
VALUES( 
"salvador.m2303@gmail.com",
"Cima", 
"Inocente", 
"Canica, hombre, mundo", 
"Hab�a una vez un hombre tan peque�o que se subi� encima de una canica y dijo:... �El mundo es m�o!",
"images/7.jpg");


INSERT INTO jokes (joke_creator_email, name, category, key_words, content,image)
VALUES( 
"salvador.m2303@gmail.com",
"Emociones", 
"Inocente", 
"Persona, estado, comportamiento", 
"Hola, �est� Agust�n?... No, estoy incomod�n.",
"images/8.jpg");


INSERT INTO jokes (joke_creator_email, name, category, key_words, content,image)
VALUES( 
"salvador.m2303@gmail.com",
"Superheroe", 
"Inocente", 
"Persona, comics, identidad", 
"�D�nde cuelga Superman su supercapa?... En superchero.",
"images/9.png");


INSERT INTO jokes (joke_creator_email, name, category, key_words, content,image)
VALUES( 
"salvador.m2303@gmail.com",
"Astronauta", 
"Inocente", 
"Espacio, hombre, lugar", 
"�De qu� se quejan siempre los astronautas?... De falta de espacio.",
"images/10.jpg");


INSERT INTO jokes (joke_creator_email, name, category, key_words, content,image)
VALUES( 
"fran.huesca9706@gmail.com",
"Quimicos", 
"Inocente", 
"Formula, bata, sustancias", 
"�C�mo se despiden los qu�micos?... �cido un placer",
"images/11.jpg");

INSERT INTO jokes (joke_creator_email, name, category, key_words, content,image)
VALUES( 
"fran.huesca9706@gmail.com",
"Diabetes", 
"Negro", 
"Negro,diabetes,dulce", 
"�Por qu� los diabeticos no pueden vengarse?... Porqu� la venganza es dulce",
"https://arc-anglerfish-arc2-prod-abccolor.s3.amazonaws.com/public/VSILDI5X6ZHN5AVLNDCIFFEMO4.jpg");

INSERT INTO jokes (joke_creator_email, name, category, key_words, content,image)
VALUES( 
"fran.huesca9706@gmail.com",
"Pinocho", 
"Rojo", 
"rojo,pinocho,paja", 
"�C�mo se dio cuenta Pinocho de que era un ni�o de madera? Porque fue a hacerse una paja y comenz� a arder�",
"images/15.jpg");

INSERT INTO jokes (joke_creator_email, name, category, key_words, content,image)
VALUES( 
"guillermart@gmail.com",
"Bruce lee", 
"Inocente", 
"bruce lee,brocoli", 
"�Como se llama el primo vegetariano de bruce lee? Brocolee",
"https://i.pinimg.com/originals/c2/52/78/c25278f06662f1480477510b00846dfa.jpg");


INSERT INTO blog_entries (user_email, entry_value, registration_date) VALUES ("guillermart@hotmail.com", "Pero que buenos chistes", now());
INSERT INTO blog_entries (user_email, entry_value, registration_date) VALUES ("maryjane.watson@dccomics.com", "Alguien sabe como agregar chistes?", now());
INSERT INTO blog_entries (user_email, entry_value, registration_date) VALUES ("salvador.m2303@gmail.com", "Dale en la opcion de registrar chiste pelotuda?", now());
INSERT INTO blog_entries (user_email, entry_value, registration_date) VALUES ("admin@novalidserver.net", "Nada de ofender a otros en este blog por favor", now());

  