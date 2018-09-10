SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema loadDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema loadDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `loadDB` DEFAULT CHARACTER SET utf8 ;
USE `loadDB` ;

-- -----------------------------------------------------
-- Table `loadDB`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `loadDB`.`patient` (
  `patient_id` INT NOT NULL AUTO_INCREMENT,
  `patient_id_diag` VARCHAR(30) NOT NULL,
  `birth_data` DATE NOT NULL,
  `sex` CHAR(1) NOT NULL,
  `age` TINYINT(2) NOT NULL,
  `weight` DECIMAL(4,2) NOT NULL,
  PRIMARY KEY (`patient_id`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `loadDB`.`study`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `loadDB`.`study` (
  `study_id` INT NOT NULL AUTO_INCREMENT,
  `study_instance_uid_study` VARCHAR(200) NOT NULL,
  `study_date` DATE NOT NULL,
  `study_time` TIME NOT NULL,
  `study_description` VARCHAR(100) NOT NULL,
  `body_part_examined` VARCHAR(30) NOT NULL,
  `patient_id_diag` VARCHAR(30) NOT NULL,
  `patient_id` INT NOT NULL,
  PRIMARY KEY (`study_id`),
  INDEX `fk_patient_id_idx` (`patient_id` ASC),
  CONSTRAINT `fk_patient_id`
  FOREIGN KEY (`patient_id`)
  REFERENCES `loadDB`.`patient` (`patient_id`)
    ON DELETE RESTRICT
)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `loadDB`.`series`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `loadDB`.`series` (
  `series_id` INT NOT NULL AUTO_INCREMENT,
  `series_instance_uid_series` VARCHAR(200) NOT NULL,
  `series_number` INT NULL,
  `series_date` DATE NULL,
  `series_time` TIME NULL,
  `series_description` VARCHAR(100) NOT NULL,
  `study_id` INT NOT NULL,
  `patient_id_diag` VARCHAR(30) NOT NULL,
  `patient_id` INT NOT NULL,
  PRIMARY KEY (`series_id`),
  INDEX `fk_study_id_idx` (`study_id` ASC),
  INDEX `fk_patient_id_idx` (`patient_id` ASC),
  CONSTRAINT `fk_study_id`
  FOREIGN KEY (`study_id`)
  REFERENCES `loadDB`.`study` (`study_id`)
    ON DELETE RESTRICT,
  CONSTRAINT `fk_patient_id_2`
  FOREIGN KEY (`patient_id`)
  REFERENCES `loadDB`.`patient` (`patient_id`)
    ON DELETE RESTRICT)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `loadDB`.`image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `loadDB`.`image` (
  `image_id` INT NOT NULL AUTO_INCREMENT,
  `image_data` BLOB NULL,
  `image_position` VARCHAR(200) NULL,
  `image_orientation` VARCHAR(200) NULL,
  `smallest_image_pixel_value` DECIMAL(2,2) NULL,
  `largest_image_pixel_value` DECIMAL(2,2) NULL,
  `series_id` INT NOT NULL,
  `study_id` INT NOT NULL,
  `patient_id_diag` VARCHAR(30) NOT NULL,
  `patient_id` INT NOT NULL,
  PRIMARY KEY (`image_id`),
  INDEX `fk_series_id_idx` (`series_id` ASC),
  INDEX `fk_study_id_idx` (`study_id` ASC),
  INDEX `fk_patient_id_idx` (`patient_id` ASC),
  CONSTRAINT `fk_series_id`
  FOREIGN KEY (`series_id`)
  REFERENCES `loadDB`.`series` (`series_id`)
    ON DELETE RESTRICT,
  CONSTRAINT `fk_study_id_2`
  FOREIGN KEY (`study_id`)
  REFERENCES `loadDB`.`study` (`study_id`)
    ON DELETE RESTRICT,
  CONSTRAINT `fk_patient_id_3`
  FOREIGN KEY (`patient_id`)
  REFERENCES `loadDB`.`patient` (`patient_id`)
    ON DELETE RESTRICT)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `loadDB`.`instance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `loadDB`.`instance` (
  `instance_id` INT NOT NULL AUTO_INCREMENT,
  `sop_class_uid` VARCHAR(200) NULL,
  `sop_instance_uid` VARCHAR(200) NULL,
  `instance_creation_date` DATE NULL,
  `instance_creation_time` TIME NULL,
  `series_instance_uid` VARCHAR(200) NULL,
  `study_instance_uid` VARCHAR(200) NULL,
  `instance_number` INT NULL,
  `image_id` INT NOT NULL,
  `series_id` INT NOT NULL,
  `study_id` INT NOT NULL,
  PRIMARY KEY (`instance_id`),
  INDEX `fk_series_id_idx` (`series_id` ASC),
  INDEX `fk_study_id_idx` (`study_id` ASC),
  INDEX `fk_image_id_idx` (`image_id` ASC),
  CONSTRAINT `fk_series_id_2`
  FOREIGN KEY (`series_id`)
  REFERENCES `loadDB`.`series` (`series_id`)
    ON DELETE RESTRICT,
  CONSTRAINT `fk_study_id_3`
  FOREIGN KEY (`study_id`)
  REFERENCES `loadDB`.`study` (`study_id`)
    ON DELETE RESTRICT,
  CONSTRAINT `fk_image_id`
  FOREIGN KEY (`image_id`)
  REFERENCES `loadDB`.`image` (`image_id`)
    ON DELETE RESTRICT)
  ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;