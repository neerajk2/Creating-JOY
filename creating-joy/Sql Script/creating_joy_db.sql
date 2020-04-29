DROP SCHEMA IF EXISTS `creating_joy_db`;

CREATE SCHEMA `creating_joy_db`;

USE `creating_joy_db`;




DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
   `user_id` int(11) NOT NULL AUTO_INCREMENT,
   `user_firstname` varchar(45) NOT NULL,
   `user_lastname` varchar(45) NOT NULL,
   `username` varchar(45) NOT NULL UNIQUE,
   `password` varchar(80) NOT NULL,
   `user_website` varchar(45),
   `user_rating` int(11) NOT NULL,
   `user_phoneno` varchar(20) NOT NULL UNIQUE,
  
	PRIMARY KEY (`user_id`)
 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`(
	`category_id` int(11) NOT NULL AUTO_INCREMENT,
    `category_name` varchar(45) NOT NULL,
    
    primary key(`category_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `user_category`;
CREATE TABLE `user_category` (                   
  `user_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  
  PRIMARY KEY (`user_id`,`category_id`),
  
  CONSTRAINT `FK_CATEGORIES_1` FOREIGN KEY (`category_id`) 
  REFERENCES `category`(`category_id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_USERS_3` FOREIGN KEY (`user_id`) 
  REFERENCES `user`(`user_id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `query`;
CREATE TABLE `query`(
	`query_id` int(11) NOT NULL AUTO_INCREMENT,
    `requestor_id` int(11) ,
    `acceptor_id` int(11) ,
    `query_text` text ,
	`category_id` int(11),
    `query_image`  varchar(120),
    `timestamp` varchar(120) ,
    `likes` int(11),
    `dislikes` int(11),
   
    primary key(`query_id`),
    
    CONSTRAINT FK_USER_REQUESTOR FOREIGN KEY(`requestor_id`)
    REFERENCES user (`user_id`),
    CONSTRAINT FK_CATEGORY FOREIGN KEY(`category_id`)
    REFERENCES category (`category_id`)
    
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
SET GLOBAL FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `address`;
 CREATE TABLE `address`(
    `address_id` int(11) NOT NULL AUTO_INCREMENT,
    `user_id` int(11),
    `query_id` int(11),
    `house_no` varchar(45),
    `street` varchar(50) NOT NULL,
    `city` varchar(45) NOT NULL,
    `landmark` varchar(45),
    `ZIP` varchar(6) NOT NULL,
    `state` varchar(45) NOT NULL,
    `country` varchar(45) NOT NULL,
	 
     primary key(`address_id`),
     
     CONSTRAINT `FK_ADDRESS_1` FOREIGN KEY(`user_id`)
     REFERENCES `user`(`user_id`),
     
	 CONSTRAINT `FK_ADDRESS_2` FOREIGN KEY(`query_id`)
     REFERENCES `query`(`query_id`)
     
    
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `category` 
VALUES 
(1,'FOOD'),
(2,'SHELTER'),
(3,'CLOTHES');





    

	

    
    

