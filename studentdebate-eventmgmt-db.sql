CREATE DATABASE studentsdebate_eventmgmt;
use studentsdebate_eventmgmt;

insert into book(author, category, name) values("Lord of the Rings"	,"fantasy Adventure	J.R.R." ,"Tolkien");

insert into roles(name) values("ADMIN");
insert into roles(name) values("USER");

insert into users(username, password) values("USER1","$2a$12$pvrQdGfu03wXAuym5V8YouSTp28vgcYk9uvMydceqg.HLFlVWiPDy");
insert into users(username, password) values("USER2","$2a$12$pvrQdGfu03wXAuym5V8YouSTp28vgcYk9uvMydceqg.HLFlVWiPDy");

insert into user_roles values(1,1);
insert into user_roles values(2,2);

drop database studentsdebate_eventmgmt;