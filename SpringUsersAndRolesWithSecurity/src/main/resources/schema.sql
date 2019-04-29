create table users(
	id IDENTITY NOT NULL PRIMARY KEY, 
	username varchar_ignorecase(50),
	password varchar_ignorecase(200) not null,
	enabled boolean not null
);

create table authorities (
	id IDENTITY NOT NULL PRIMARY KEY,
	username varchar_ignorecase(50) not null,
	authority varchar_ignorecase(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
