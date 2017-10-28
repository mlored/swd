

CREATE TABLE `persons` (
  `id` int(11) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `surname` varchar(250) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `RUC` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `cars` (
  `id` INT NOT NULL,
  `mark` VARCHAR(50) NULL,
  `model` VARCHAR(50) NULL,
  `number` VARCHAR(50) NULL,
  `color` VARCHAR(20) NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `entries` (
  `id` INT NOT NULL,
  `date` DATE NULL,
  `number` INT NULL,
  `person_id` INT NULL,
  `car_id` INT NULL,
  `diagnostic` VARCHAR(250) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_person_id_idx` (`person_id` ASC),
  INDEX `fk_car_id_idx` (`car_id` ASC),
  CONSTRAINT `fk_person_id`
    FOREIGN KEY (`person_id`)
    REFERENCES `tracker`.`persons` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_car_id`
    FOREIGN KEY (`car_id`)
    REFERENCES `tracker`.`cars` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
