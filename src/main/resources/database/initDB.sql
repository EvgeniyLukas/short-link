DROP TABLE IF EXISTS link;

CREATE TABLE IF NOT EXISTS link
(
    id           SERIAL PRIMARY KEY,
    hash         varchar(20) not null unique,
    original_url varchar,
    created_at   timestamp
);