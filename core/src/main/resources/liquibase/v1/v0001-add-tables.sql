create table "folder"
(
    "id"       uuid primary key,
    "name"     varchar(255),
    "url"      varchar(255),
    "date"     DATE,
    "parentId" uuid,
    "type"     anyenum,
--     надо сделать long
    "size"     INTEGER
);
create table "file"
(
    "id"       uuid primary key,
    "name"     varchar(255),
    "url"      varchar(255),
    "date"     DATE,
    "parentId" uuid,
    "type"     anyenum,
    "size"     INTEGER,
    "children" uuid
);