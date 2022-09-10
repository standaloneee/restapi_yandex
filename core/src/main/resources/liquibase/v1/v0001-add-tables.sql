create table "item"
(
    id       uuid primary key,
    name     varchar(255),
    url      varchar(255),
    date     DATE,
    parentId uuid,
    type     varchar(20),
    size     BIGINT,
    FOREIGN KEY (parentId) REFERENCES item (id)
);
