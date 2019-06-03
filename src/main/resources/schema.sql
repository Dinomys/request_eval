DROP TABLE IF EXISTS plan;
DROP TABLE IF EXISTS agent;

CREATE  TABLE plan (
                        id VARCHAR(20) NOT NULL,
                        PRIMARY KEY (id));

CREATE TABLE agent (
                        id BIGINT NOT NULL,
                        firstname VARCHAR (40),
                        lastname VARCHAR (40),
                        manager VARCHAR (40),
                        archived BIT,
                        PRIMARY KEY (id));

INSERT INTO plan (id) VALUES ('May 2018');
INSERT INTO plan (id) VALUES ('April 2018');
INSERT INTO plan (id) VALUES ('March 2018');

INSERT INTO agent (id, firstname, lastname, manager, archived)
VALUES (0111111, 'Zenek', 'Kowalski', '14', false);
INSERT INTO Agent (id, firstname, lastname, manager, archived)
VALUES (0222222, 'Krzysiek', 'Kowalski', '14', true);
INSERT INTO Agent (id, firstname, lastname, manager, archived)
VALUES (0333333, 'Zofia', 'Brzeczyszczykiewicz', '15', false);