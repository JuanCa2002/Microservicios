INSERT INTO category (id, name,status) VALUES(1,'Tecnologia','CREATED');
INSERT INTO category (id, name,status) VALUES(2,'Ropa','CREATED');
INSERT INTO category (id, name,status) VALUES(3,'Deportes','CREATED');
INSERT INTO category (id, name,status) VALUES(4,'Aseo','CREATED');
INSERT INTO category (id, name,status) VALUES(5,'Restaurante','CREATED');

INSERT INTO product (id,name,description,price, status, stock,category_id)
VALUES(1,'Shampoo','Bonito',1000,'CREATED',10,1);

INSERT INTO product (id,name,description,price, status, stock,category_id)
VALUES(2,'Balon de futbol','Buen balo',10000,'CREATED',20,3);