create user 'fithealthappuser'@'%' identified by 'welcome1';
GRANT ALL PRIVILEGES ON mydb.* TO 'fithealthappuser'@'%' WITH GRANT OPTION;
flush privileges;