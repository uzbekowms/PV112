create table if not exists purchases
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    name  varchar(50) NOT NULL,
    price double      NOT null
);

create table if not exists accounts
(
    id     INT AUTO_INCREMENT PRIMARY KEY,
    name   varchar(50) NOT NULL,
    amount DOUBLE      NOT NULL
);