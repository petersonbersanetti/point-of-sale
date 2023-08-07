CREATE TABLE db_user (
  user_id BIGINT(20) NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(100) NULL,
  user_is_enable BIT(1) DEFAULT FALSE,
  PRIMARY KEY (`user_id`));
