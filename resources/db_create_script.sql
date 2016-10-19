-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bicycle_rental
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bicycle_rental
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bicycle_rental` DEFAULT CHARACTER SET utf8 ;
USE `bicycle_rental` ;

-- -----------------------------------------------------
-- Table `bicycle_rental`.`categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bicycle_rental`.`categories` (
  `id_category` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_category`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bicycle_rental`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bicycle_rental`.`products` (
  `id_product` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_category` INT UNSIGNED NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `price` DECIMAL(5,2) UNSIGNED NOT NULL,
  `description` TEXT NOT NULL,
  PRIMARY KEY (`id_product`),
  INDEX `fk_products_catigories_idx` (`id_category` ASC),
  CONSTRAINT `fk_products_catigories`
    FOREIGN KEY (`id_category`)
    REFERENCES `bicycle_rental`.`categories` (`id_category`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `bicycle_rental`.`categories`
-- -----------------------------------------------------
START TRANSACTION;
USE `bicycle_rental`;
INSERT INTO `bicycle_rental`.`categories` (`id_category`, `name`) VALUES (DEFAULT, 'Велоаксессуары');
INSERT INTO `bicycle_rental`.`categories` (`id_category`, `name`) VALUES (DEFAULT, 'Велозапчасти');
INSERT INTO `bicycle_rental`.`categories` (`id_category`, `name`) VALUES (DEFAULT, 'Велосипеды горные');
INSERT INTO `bicycle_rental`.`categories` (`id_category`, `name`) VALUES (DEFAULT, 'Велосипеды детские');
INSERT INTO `bicycle_rental`.`categories` (`id_category`, `name`) VALUES (DEFAULT, 'Велосипеды трёхколесные');

COMMIT;


-- -----------------------------------------------------
-- Data for table `bicycle_rental`.`products`
-- -----------------------------------------------------
START TRANSACTION;
USE `bicycle_rental`;
INSERT INTO `bicycle_rental`.`products` (`id_product`, `id_category`, `name`, `price`, `description`) VALUES (DEFAULT, 1, 'Велобагажник регулируемый KW 622-02', 42.50, 'Велобагажник раздвижной. Ставится на велосипеды с размером колеса 24\"-28\". Сделан из сплава алюминия и стали, легкий. Цвет: черный.');
INSERT INTO `bicycle_rental`.`products` (`id_product`, `id_category`, `name`, `price`, `description`) VALUES (DEFAULT, 1, 'Велосумочка на раму велосипеда KW-834', 18.90, 'Велосумка, с тремя точками крепления на застежках Velcro. Имеет один карман под ZIP-застежку. Имеет светоотражательные полоски.');
INSERT INTO `bicycle_rental`.`products` (`id_product`, `id_category`, `name`, `price`, `description`) VALUES (DEFAULT, 1, 'Фликер на велосипед боковой TF-530', 1.50, 'Фликер на велосипед боковой TF-530, оранжевый.');
INSERT INTO `bicycle_rental`.`products` (`id_product`, `id_category`, `name`, `price`, `description`) VALUES (DEFAULT, 2, 'Колодка для вело-тормоза Alhonga MTB-947V', 4.90, 'Колодка для вело-тормоза Alhonga MTB-947V. Производитель: Alhonga. Сделано в Тайване.');
INSERT INTO `bicycle_rental`.`products` (`id_product`, `id_category`, `name`, `price`, `description`) VALUES (DEFAULT, 2, 'Велопокрышка для горного велосипеда 26\" GMD G-801', 24.70, 'Велопокрышка для горного велосипеда. Сделано в Тайване. Завод GMD. Качественная резина, без запаха, отличный корд. 45-60PSI. 3,1-4,2 BAR.');
INSERT INTO `bicycle_rental`.`products` (`id_product`, `id_category`, `name`, `price`, `description`) VALUES (DEFAULT, 2, 'Цепь велосипедная KMC Z-510', 9.70, 'Цепь для односкоростного велосипеда. Сделано в Тайване. Производитель: KMC.');
INSERT INTO `bicycle_rental`.`products` (`id_product`, `id_category`, `name`, `price`, `description`) VALUES (DEFAULT, 2, 'Велокамера Hongda 26\"', 6.00, 'Велокамера бутиловая. Имеет американский тип нипеля, с колпачком.');
INSERT INTO `bicycle_rental`.`products` (`id_product`, `id_category`, `name`, `price`, `description`) VALUES (DEFAULT, 3, 'Велосипед горный Amigo Alto 26\"', 388.03, 'Не смотря на большой диаметр колес, велосипед предназначен для детей. Не важно, насколько Высокий будет ребенок в подростковом возрасте, Alto-будет в самый раз!');
INSERT INTO `bicycle_rental`.`products` (`id_product`, `id_category`, `name`, `price`, `description`) VALUES (DEFAULT, 3, 'Stark (Старк) B1 Onix Alloy', 407.55, 'Горный велосипед с легкой и прочной алюминиевой рамой, оснащенный амортизационной вилкой и надежным оборудованием SHIMANO. Прочные двойные обода, 18 скоростей.');
INSERT INTO `bicycle_rental`.`products` (`id_product`, `id_category`, `name`, `price`, `description`) VALUES (DEFAULT, 3, 'Fuji (Фуджи) Adventure Lady\'s', 577.72, 'Велосипеды FUJI - это качество умноженное на надёжность. Благодаря передовым японским технологиям все велосипеды отличаются высоким качеством сборки и прекрасными ходовыми характеристиками, ничем не уступающими лидирующим американским брендам. С горным велосипедом от Fuji любая прогулка превратится в незабываемое велоприключение!');
INSERT INTO `bicycle_rental`.`products` (`id_product`, `id_category`, `name`, `price`, `description`) VALUES (DEFAULT, 3, 'Trek (Трек) SKYE 2017 года', 793.65, 'произведен с учетом отличий женской и мужской анатомии, укороченная верхняя труба и узкий руль предохраняют шею и плечи от усталости, WSD геометрия предохраняет от болей в пояснице');
INSERT INTO `bicycle_rental`.`products` (`id_product`, `id_category`, `name`, `price`, `description`) VALUES (DEFAULT, 4, 'Велосипед детский Amigo-001 16\" Junior', 165.67, 'Велосипед Амиго для детей от 4-х лет, рост 104 см +\\10 см, вес 17,5 кг +\\ 10 кг. Вес велосипеда 10, 5 кг. Размер велосипеда L=111 cm, W=57 cm, H=77 cm. ');
INSERT INTO `bicycle_rental`.`products` (`id_product`, `id_category`, `name`, `price`, `description`) VALUES (DEFAULT, 4, 'Велосипед для девочек Amiga-001 18\" Brillante', 159.89, 'Amigo Brillante-это изящный велосипед для маленьких дам в ретро-стиле. Как поётся в одной песне, \"лучшие друзья девушек-это бриллианты\", что дословно переводится в нашем названии велосипеда \"Бриллиантовая подружка\". Велосипед Амиго для девочек от 5-ти лет, рост 111 см +\\10 см, вес 20 кг +\\10 кг. Вес велосипеда 11, 5 кг. Размер велосипеда L=120 cm, W=60 cm, H=83 cm. ');
INSERT INTO `bicycle_rental`.`products` (`id_product`, `id_category`, `name`, `price`, `description`) VALUES (DEFAULT, 4, 'Велосипед детский для мальчика от 6-ти лет Amigo Agent 007 20\"', 181.90, 'Кто из мальчишек не хотел стать Джеймс Бондом? А что за агент спецслужб, без транспорта? Прекрасно подходит для игр в убегалки с \"Мiлiцыей\"! Имеется письмо-уведомление Ее Величества Королевы Великобритании. ');
INSERT INTO `bicycle_rental`.`products` (`id_product`, `id_category`, `name`, `price`, `description`) VALUES (DEFAULT, 4, 'Велосипед детский от 6-ти лет Amigo Impulso 20\"', 158.95, 'Современный велосипед с рамой унисекс. Имеет яркий насыщенный цвет и ультра салатовый цвет, подходящий для девочек и мальчиков.');
INSERT INTO `bicycle_rental`.`products` (`id_product`, `id_category`, `name`, `price`, `description`) VALUES (DEFAULT, 5, 'Трехколесный детский велосипед (Lexx Trike combi) 950', 184.00, 'Коляска-трансформер, трехколесный велосипед-управляшка Lexus, для детей от 1 года. Культовая модель, для самых взыскательных маленьких байкеров. Толстая, но легкая рама из композитных материалов, широкие колеса, покрышка из мягкого вспененного полиуретана, которая никогда не сдуется и не пробъется, удобная двойная ручка, современный дизайн, все это не оставит равнодушным ни вашего малыша, ни его маму!');
INSERT INTO `bicycle_rental`.`products` (`id_product`, `id_category`, `name`, `price`, `description`) VALUES (DEFAULT, 5, 'Трехколесный велосипед-коляска Brabus', 246.70, 'Коляска-трансформер Brabus с куполом-капюшоном на надувных, широких, больших колесах. Переднее колесо 12\", задние колеса 10\". Трехколесный велосипед-управляшка Brabus, для детей от 1 года. Культовая модель, для самых взыскательных маленьких байкеров. Толстая, но легкая рама из композитных материалов, задний стояночный тормоз, удобная двойная ручка, современный дизайн, все это не оставит равнодушным ни вашего малыша, ни его маму! ');
INSERT INTO `bicycle_rental`.`products` (`id_product`, `id_category`, `name`, `price`, `description`) VALUES (DEFAULT, 5, 'Трехколесный велосипед с ручкой Amigo 107A4', 103.50, 'Коляска-трансформер, трехколесный велосипед-управляшка, для детей от 1 года. Недорогая, классическая модель. Низкая посадка, пояс-держатель, регулируемый навес, удобная ручка для управления и корзинка для поклажи. Моргающие поворотники и светящаяся фара. \"Крякалка\"-подача звукового сигнала.');

COMMIT;

