CREATE TABLE USER_INFO
(
    user_id            serial PRIMARY KEY,
    user_name          VARCHAR(50) UNIQUE NOT NULL,
    online_status      BOOLEAN            NOT NULL,
    registration_date  date               NOT NULL,
    last_activity_date date               NOT NULL,
    subscribers        INT                NOT NULL,
    followers          INT                NOT NULL
);


CREATE TABLE PAYER_INFO
(
    user_id            serial PRIMARY KEY,
    user_name          VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE CLIENT_INFO
(
    user_id            serial PRIMARY KEY,
    user_name          VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE CLIENT_VIEWS_INFO
(
    user_id            serial PRIMARY KEY,
    user_name          VARCHAR(50) UNIQUE NOT NULL
);