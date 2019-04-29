insert into users (id,username, password, enabled) values (default,'bob', '{noop}123', true);
insert into authorities (id,username, authority) values (default,'bob', 'ROLE_USER');

insert into users (id,username, password, enabled) values (default,'sara', '{noop}234', true);
insert into authorities (id,username, authority) values (default,'sara', 'ROLE_ADMIN');
