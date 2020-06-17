DROP SEQUENCE IF EXISTS SEQ_PRIMARYKEY;
CREATE SEQUENCE SEQ_PRIMARYKEY START WITH 4 INCREMENT BY 1;

DROP TABLE IF EXISTS ORDERS;

CREATE TABLE ORDERS
(
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    ORDER_NO VARCHAR(250) NOT NULL,
    NAME  VARCHAR(250) NOT NULL
);

INSERT INTO ORDERS (ID, ORDER_NO, NAME)
VALUES ('1', '50000111221', 'Meier'),
       ('2', '50000112222', 'Mueller'),
       ('3', '50000113223', 'Schulze');