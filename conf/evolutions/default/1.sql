# --- !Ups
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `email` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(100) NOT NULL DEFAULT '',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `accounts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `type` enum('CASH','BANK','CREDIT_CARD','DEPOSIT') NOT NULL DEFAULT 'CASH',
  `description` text,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `type` (`type`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `categories` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `parent_id` bigint(20) DEFAULT NULL,
  `description` text,
  `icon` varchar(20) NOT NULL DEFAULT 'DEFAULT_ICON',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  KEY `parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `budgets` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `type` enum('DAILY','MONTHLY','YEARLY') NOT NULL DEFAULT 'MONTHLY',
  `amount` bigint(20) NOT NULL DEFAULT '0',
  `start_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_date` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  KEY `type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `transactions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) NOT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `currency_id` bigint(20) NOT NULL,
  `category_type` enum('INCOME','EXPENSE','LEND','BORROW','COLLECTING','REPAYMENT') DEFAULT NULL,
  `amount` bigint(20) NOT NULL,
  `description` text,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `debt_target` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `account_id` (`account_id`),
  KEY `category_id` (`category_id`),
  KEY `category_id_2` (`category_id`),
  KEY `category_type` (`category_type`),
  KEY `debt_target` (`debt_target`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `budget_relations` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `budget_id` bigint(20) NOT NULL,
  `target_type` enum('ACCOUNT','CATEGORY') NOT NULL DEFAULT 'ACCOUNT',
  `target_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `budget_id` (`budget_id`),
  KEY `target_type` (`target_type`,`target_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# --- !Downs
DROP TABLE users;
DROP TABLE accounts;
DROP TABLE categories;
DROP TABLE budgets;
DROP TABLE transactions;
DROP TABLE budget_relations;