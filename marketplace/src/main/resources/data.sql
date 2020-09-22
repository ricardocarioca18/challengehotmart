INSERT INTO PRODUCT(name, description, creation_Date) VALUES('Notebook', 'Notebook SAMSUNG Expert X30, Core i3, 4GB RAM', '2020-09-20 11:00:00');
INSERT INTO PRODUCT(name, description, creation_Date) VALUES('Notebook', 'Notebook SAMSUNG Expert X40, Core i5, 8GB RAM', '2020-07-15 12:00:00');
INSERT INTO PRODUCT(name, description, creation_Date) VALUES('Notebook', 'Notebook SAMSUNG Expert X50, Core i7, 8GB RAM', '2020-08-06 13:00:00');
INSERT INTO PRODUCT(name, description, creation_Date) VALUES('Notebook', 'Notebook SAMSUNG Expert E20, Pentium, 2GB RAM', '2020-09-15 16:00:00');



INSERT INTO BUYER(name) VALUES('Ricardo');
INSERT INTO BUYER(name) VALUES('Marina');




INSERT INTO SELLER(name) VALUES('Rodrigo');
INSERT INTO SELLER(name) VALUES('Ryan');
INSERT INTO SELLER(name) VALUES('Fátima');
INSERT INTO SELLER(name) VALUES('Joaquim');



INSERT INTO PRODUCT_CATEGORY(name) VALUES('Informática');
INSERT INTO PRODUCT_CATEGORY(name) VALUES('Indústria');
INSERT INTO PRODUCT_CATEGORY(name) VALUES('Varejo');
INSERT INTO PRODUCT_CATEGORY(name) VALUES('Atacado');



INSERT INTO SALE(seller_id, buyer_id, product_id) VALUES(2, 1, 1);
INSERT INTO SALE(seller_id, buyer_id, product_id) VALUES(4, 2, 3);
