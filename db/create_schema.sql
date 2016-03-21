CREATE TABLE IF NOT EXISTS mydb.BASIC_ENTITY (
  ID BIGINT NOT NULL AUTO_INCREMENT,
  STRING_VALUE VARCHAR(45) NULL,
  DATE_VALUE DATETIME NULL,
  BOOLEAN_VALUE TINYINT(1) NULL,
  CURRENCY_VALUE DECIMAL(12,2) NULL,
  ENUM_VALUE VARCHAR(45) NULL,
  PRIMARY KEY (ID))
ENGINE = InnoDB;