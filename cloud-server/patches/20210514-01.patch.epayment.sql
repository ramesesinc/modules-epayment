
CREATE TABLE `gcash_log` (
  `objid` varchar(50) NOT NULL,
  `poid` varchar(50) NOT NULL,
  `txndate` datetime NOT NULL,
  `txntype` varchar(32) NOT NULL,
  `info` longtext,
  PRIMARY KEY (`objid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
