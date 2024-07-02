CREATE TABLE exchange(
    id int primary key auto_increment,
    from_currency CHAR(3) NOT NULL,
    to_currency CHAR(3) NOT NULL,
    convertion_factor DECIMAL(65,2) NOT NULL,
    from_currency CHAR(3) NOT NULL,
)