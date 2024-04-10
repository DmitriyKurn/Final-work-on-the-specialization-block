
USE 'HumanFrends';

CREATE TABLE animal (
    id INT PRIMARY KEY AUTO_INCREMENT,
    type_animal VARCHAR(50) NOT NULL
);

INSERT INTO
    animal (type_animal)
VALUES
    ('Pets'),
    ('Pak animals');

CREATE TABLE pets (
    id INT PRIMARY KEY AUTO_INCREMENT,
    type_animal INT NOT NULL,
    FOREIGN KEY (type_animal) REFERENCES animal (id),
    genus_animal VARCHAR(50) NOT NULL
);

INSERT INTO
    pets (type_animal, genus_animal)
VALUES
    (1, 'Dog'),
    (1, 'Cat'),
    (1, 'Hamster');

CREATE TABLE PetAnimal (
    id INT PRIMARY KEY AUTO_INCREMENT,
    type_animal INT NOT NULL,
    FOREIGN KEY (type_animal) REFERENCES animal (id),
    genus_animal VARCHAR(50) NOT NULL
);

INSERT INTO
    PetAnimal (type_animal, genus_animal)
VALUES
    (2, 'Horse'),
    (2, 'Camel'),
    (2, 'Donkey');

CREATE TABLE dog (
    id INT PRIMARY KEY AUTO_INCREMENT,
    genus_animal INT NOT NULL,
    FOREIGN KEY (genus_animal) REFERENCES pets (id),
    name VARCHAR(50) NOT NULL,
    birthday DATE NOT NULL,
    comands VARCHAR(255) NOT NULL
);

INSERT INTO
    dog (genus_animal, name, birthday, comands)
VALUES
    (1, 'Бадди', '2024-01-01', 'seat guard run voice'),
    (1, 'Шарик', '2024-01-01', 'seat guard run voice'),
    (1, 'Тузик', '2023-01-02', 'seat guard run voice'),
    (1, 'Дозор', '2022-01-02', 'seat guard run voice'),
    (1, 'Бим', '2024-01-02', 'seat guard run voice');

CREATE TABLE cat (
    id INT PRIMARY KEY AUTO_INCREMENT,
    genus_animal INT NOT NULL,
    FOREIGN KEY (genus_animal) REFERENCES pets (id),
    name VARCHAR(50) NOT NULL,
    birthday DATE NOT NULL,
    comands VARCHAR(255) NOT NULL
);

INSERT INTO
    cat (genus_animal, name, birthday, comands)
VALUES
    (2, 'Ася', '2024-01-02', 'seat climb run voice'),
    (2, 'Пуся', '2021-01-02', 'seat climb run voice'),
    (2, 'Муся', '2023-05-02', 'seat climb run voice'),
    (2, 'Буся', '2024-01-01', 'seat climb run voice'),
    (2, 'Мурка', '2024-01-02', 'seat climb run voice');

CREATE TABLE hamster (
    id INT PRIMARY KEY AUTO_INCREMENT,
    genus_animal INT NOT NULL,
    FOREIGN KEY (genus_animal) REFERENCES pets (id),
    name VARCHAR(50) NOT NULL,
    birthday DATE NOT NULL,
    comands VARCHAR(255) NOT NULL
);

INSERT INTO
    hamster (genus_animal, name, birthday, comands)
VALUES
    (3, 'Фливти', '2021-01-02', 'seat run eat'),
    (3, 'Боб', '2023-01-01', 'seat run eat'),
    (3, 'Рокки', '2023-06-02', 'seat run eat'),
    (3, 'Кекс', '2022-09-15', 'seat run eat'),
    (3, 'Черт', '2024-01-01', 'seat run eat');

CREATE TABLE horse (
    id INT PRIMARY KEY AUTO_INCREMENT,
    genus_animal INT NOT NULL,
    FOREIGN KEY (genus_animal) REFERENCES PetAnimal (id),
    name VARCHAR(50) NOT NULL,
    birthday DATE NOT NULL,
    comands VARCHAR(255) NOT NULL
);

INSERT INTO
    horse (genus_animal, name, birthday, comands)
VALUES
    (1, 'Бурый', '2020-04-17', 'seat run eat load-cargo'),
    (1, 'Пегий', '2021-02-02', 'seat run eat load-cargo'),
    (1, 'Изумруд', '2024-01-02','seat run eat load-cargo'),
    (1, 'Буран', '2022-07-08', 'seat run eat load-cargo'),
    (1, 'Тяж', '2024-01-01', 'seat run eat load-cargo');

CREATE TABLE camel (
    id INT PRIMARY KEY AUTO_INCREMENT,
    genus_animal INT NOT NULL,
    FOREIGN KEY (genus_animal) REFERENCES PetAnimal (id),
    name VARCHAR(50) NOT NULL,
    birthday DATE NOT NULL,
    comands VARCHAR(255) NOT NULL
);

INSERT INTO
    camel (genus_animal, name, birthday, comands)
VALUES
    (2, 'Иуда', '2019-05-02', 'seat run eat load-cargo'),
    (2, 'Марс', '2021-09-12', 'seat run eat load-cargo'),
    (2,'Плевака', '2023-03-25', 'seat run eat load-cargo'),
    (2,'Быстрый','2022-04-18','seat run eat load-cargo'),
    (2, 'Джони', '2024-01-02', 'seat run eat load-cargo');

CREATE TABLE donkey (
    id INT PRIMARY KEY AUTO_INCREMENT,
    genus_animal INT NOT NULL,
    FOREIGN KEY (genus_animal) REFERENCES PetAnimal (id),
    name VARCHAR(50) NOT NULL,
    birthday DATE NOT NULL,
    comands VARCHAR(255) NOT NULL
);

INSERT INTO
    donkey (genus_animal, name, birthday, comands)
VALUES
    (3, 'Альтаир', '2020-01-02', 'seat run eat load-cargo'),
    (3, 'Мойша', '2021-01-02', 'seat run eat load-cargo'),
    (3, 'Гейша', '2023-01-02', 'seat run eat load-cargo'),
    (3, 'Лентяй', '2022-01-02', 'seat run eat load-cargo'),
    (3, 'Вудди', '2024-01-02', 'seat run eat load-cargo');

DROP TABLE camel;

CREATE TABLE allpetanimal
AS( SELECT *
FROM donkey
UNION
SELECT *
FROM horse);


  CREATE TABLE younganimal
  AS (SELECT id, genus_animal, name, comands, (EXTRACT(YEAR FROM curdate())  - EXTRACT(YEAR FROM donkey.birthday)) 
  * 12 +
  (CASE WHEN  EXTRACT(MONTH FROM curdate()) < EXTRACT(MONTH FROM donkey.birthday)
  THEN EXTRACT(MONTH FROM donkey.birthday) - EXTRACT(MONTH FROM curdate())
  WHEN  EXTRACT(MONTH FROM curdate()) > EXTRACT(MONTH FROM donkey.birthday)
  THEN EXTRACT(MONTH FROM curdate()) - EXTRACT(MONTH FROM donkey.birthday)
  WHEN EXTRACT(MONTH FROM curdate()) = EXTRACT(MONTH FROM donkey.birthday)
  THEN 0

END) AS age_mounth
FROM donkey
WHERE EXTRACT(YEAR FROM curdate()) - EXTRACT(YEAR FROM  donkey.birthday) BETWEEN 1 AND 3

UNION 

SELECT id, genus_animal, name, comands, (EXTRACT(YEAR FROM curdate())  - EXTRACT(YEAR FROM horse.birthday)) * 12 +
(CASE WHEN  EXTRACT(MONTH FROM curdate()) < EXTRACT(MONTH FROM horse.birthday)
		THEN EXTRACT(MONTH FROM horse.birthday) - EXTRACT(MONTH FROM curdate())
  			WHEN  EXTRACT(MONTH FROM curdate()) > EXTRACT(MONTH FROM horse.birthday)
  			THEN EXTRACT(MONTH FROM curdate()) - EXTRACT(MONTH FROM horse.birthday)
  			WHEN EXTRACT(MONTH FROM curdate()) = EXTRACT(MONTH FROM horse.birthday)
  			THEN 0
  		
END) AS age_mounth
FROM horse
WHERE EXTRACT(YEAR FROM curdate()) - EXTRACT(YEAR FROM  horse.birthday) BETWEEN 1 AND 3

UNION

SELECT id, genus_animal, name, comands, (EXTRACT(YEAR FROM curdate())  - EXTRACT(YEAR FROM cat.birthday)) * 12 +
(CASE WHEN  EXTRACT(MONTH FROM curdate()) < EXTRACT(MONTH FROM cat.birthday)
		THEN EXTRACT(MONTH FROM cat.birthday) - EXTRACT(MONTH FROM curdate())
  			WHEN  EXTRACT(MONTH FROM curdate()) > EXTRACT(MONTH FROM cat.birthday)
  			THEN EXTRACT(MONTH FROM curdate()) - EXTRACT(MONTH FROM cat.birthday)
  			WHEN EXTRACT(MONTH FROM curdate()) = EXTRACT(MONTH FROM cat.birthday)
  			THEN 0
  		
END) AS age_mounth
FROM cat
WHERE EXTRACT(YEAR FROM curdate()) - EXTRACT(YEAR FROM  cat.birthday) BETWEEN 1 AND 3

UNION

SELECT id, genus_animal, name, comands, (EXTRACT(YEAR FROM curdate())  - EXTRACT(YEAR FROM dog.birthday)) * 12 +
(CASE WHEN  EXTRACT(MONTH FROM curdate()) < EXTRACT(MONTH FROM dog.birthday)
		THEN EXTRACT(MONTH FROM dog.birthday) - EXTRACT(MONTH FROM curdate())
  			WHEN  EXTRACT(MONTH FROM curdate()) > EXTRACT(MONTH FROM dog.birthday)
  			THEN EXTRACT(MONTH FROM curdate()) - EXTRACT(MONTH FROM dog.birthday)
  			WHEN EXTRACT(MONTH FROM curdate()) = EXTRACT(MONTH FROM dog.birthday)
  			THEN 0
  		
END) AS age_mounth
FROM dog
WHERE EXTRACT(YEAR FROM curdate()) - EXTRACT(YEAR FROM  dog.birthday) BETWEEN 1 AND 3

UNION

SELECT id, genus_animal, name, comands, (EXTRACT(YEAR FROM curdate())  - EXTRACT(YEAR FROM hamster.birthday)) * 12 +
(CASE WHEN  EXTRACT(MONTH FROM curdate()) < EXTRACT(MONTH FROM hamster.birthday)
		THEN EXTRACT(MONTH FROM hamster.birthday) - EXTRACT(MONTH FROM curdate())
  			WHEN  EXTRACT(MONTH FROM curdate()) > EXTRACT(MONTH FROM hamster.birthday)
  			THEN EXTRACT(MONTH FROM curdate()) - EXTRACT(MONTH FROM hamster.birthday)
  			WHEN EXTRACT(MONTH FROM curdate()) = EXTRACT(MONTH FROM hamster.birthday)
  			THEN 0
  		
END) AS age_mounth
FROM hamster
WHERE EXTRACT(YEAR FROM curdate()) - EXTRACT(YEAR FROM  hamster.birthday) BETWEEN 1 AND 3);



CREATE TABLE all_table
AS(SELECT * FROM cat UNION
SELECT * FROM dog UNION
SELECT * FROM horse UNION
SELECT * FROM hamster UNION
SELECT * FROM donkey);
