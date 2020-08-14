INSERT INTO USER
(ID, FIRSTNAME, LASTNAME, AGE)
VALUES
(1, 'Stewart', 'Barry', 32),
(2, 'Morris', 'Bobby', 26),
(3, 'Sandra', 'Parker', 29),
(4, 'Stephie', 'Woods', 42),
(5, 'Ryana', 'Hunter', 33);

INSERT INTO USER_ROLE
(USER_ID, ROLE)
VALUES
(1, 'LEADER'),
(1, 'PRODUCT_OWNER'),
(2, 'DEVELOPER'),
(2, 'TESTER'),
(3, 'DEVELOPER'),
(3, 'TESTER'),
(4, 'PRODUCT_OWNER'),
(4, 'TESTER'),
(5, 'STAKEHOLDER');

INSERT INTO PROJECT
(ID, NAME, DESCRIPTION, LEADER_ID)
VALUES
(1, 'DYNAMIC_FILTER_BOARD', 'Search for dynamic content', 1);

INSERT INTO FEATURE
(ID, STATE, DESCRIPTION, PROJECT_ID)
VALUES
(1, 'PROGRESS', 'Search-service for dynamic content for single resultType', 1),
(2, 'OPEN', 'Create UI for dynamic board search', 1);

INSERT INTO TASK
(ID, STATE, TITLE, DESCRIPTION, ASSIGNEE_ID, FEATURE_ID)
VALUES
(1, 'PROGRESS', 'First Single Request over HTTP', 'Create a Search-service for dynamic content for single resultTypes. Support a REST-Controller for using this service', 2, 1),
(2, 'OPEN', 'Support lists filter', 'TBD', 2, 1),
(3, 'OPEN', 'Support filtering join columns ', 'TBD', 2, 1),
(4, 'OPEN', 'Support db functions for filtering ', 'TBD', 2, 1),
(5, 'OPEN', 'Support request over multiple table ', 'TBD', 2, 1);