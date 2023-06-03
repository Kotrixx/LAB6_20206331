use lab6sw1;
ALTER TABLE cancion
ADD COLUMN favorito TINYINT NOT NULL;
ALTER TABLE listareproduccion AUTO_INCREMENT = 1;

UPDATE cancion SET favorito = 1 WHERE idCancion = 8;
ALTER TABLE cancion
ADD COLUMN favorito TINYINT NOT NULL;
select * from cancion;
select * from listareproduccion;
INSERT INTO listareproduccion (nombre) VALUES ("favorita");
INSERT INTO listareproduccion (nombre) VALUES ("asd");
DELETE from listareproduccion where idlistareproduccion = 2;

select * from cancion;
#where banda = "";
select * from cancion
inner join banda;


select * from banda;

