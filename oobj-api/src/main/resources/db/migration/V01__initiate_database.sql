--DROP TABLE flyway_schema_history;
--DROP TABLE transaction CASCADE;
--DROP TABLE account CASCADE;
--DROP TABLE client CASCADE;
--DROP TABLE agency CASCADE;


CREATE TABLE agency (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	street VARCHAR(50) NOT NULL,
	city VARCHAR(50) NOT NULL,
	state VARCHAR(50) NOT NULL,
	zipcode VARCHAR(10) NOT NULL
	);

CREATE TABLE client (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	cpf VARCHAR(11) NOT NULL,
	phone_number VARCHAR(10) NOT NULL,
	street VARCHAR(50) NOT NULL,
	city VARCHAR(50) NOT NULL,
	state VARCHAR(50) NOT NULL,
	zipcode VARCHAR(10) NOT NULL
	);
	
CREATE TABLE account (
	id SERIAL PRIMARY KEY,
	client_id INTEGER NOT NULL REFERENCES client,
	agency_id INTEGER NOT NULL REFERENCES agency,
	account_type VARCHAR(10) NOT NULL,
	UNIQUE (client_id, account_type)
	);

CREATE TABLE transaction (
	id SERIAL PRIMARY KEY,
	amount DECIMAL(10, 2) NOT NULL,
	account_id INTEGER NOT NULL REFERENCES account,
	source_account_id INTEGER REFERENCES account,
	destination_account_id INTEGER REFERENCES account,
	transaction_type VARCHAR(20) NOT NULL
);

	
	
INSERT INTO agency (name, street, city, state, zipcode) VALUES ('Itau', 'Itau Street', 'Itau City', 'Itau State', '75261187');
INSERT INTO agency (name, street, city, state, zipcode) VALUES ('Santander', 'Santander Street', 'Santander City', 'Santander State', '85261387');
INSERT INTO agency (name, street, city, state, zipcode) VALUES ('Bradresco', 'Bradesco Street', 'Bradesco City', 'Bradesco State', '23261187');
INSERT INTO agency (name, street, city, state, zipcode) VALUES ('Caixa', 'Caixa Street', 'Caixa City', 'Caixa State', '45261287');

INSERT INTO client (name, cpf, phone_number, street, city, state, zipcode) VALUES ('Fulano', '56393089075', '1125146789','Fulano Street', 'Fulano City', 'Fulano State', '45721287');
INSERT INTO client (name, cpf, phone_number, street, city, state, zipcode) VALUES ('Ciclano', '37335150051', '2775126714', 'Ciclano Street', 'Ciclano City', 'Ciclano State', '35226231');

INSERT INTO account (client_id, agency_id, account_type) VALUES (1, 1, 'CURRENT');
INSERT INTO account (client_id, agency_id, account_type) VALUES (1, 1, 'SAVING');
INSERT INTO account (client_id, agency_id, account_type) VALUES (2, 2, 'CURRENT');
INSERT INTO account (client_id, agency_id, account_type) VALUES (2, 3, 'SAVING');

INSERT INTO transaction (amount, account_id, source_account_id, destination_account_id, transaction_type)
VALUES (10.0, 1, null, null, 'DEPOSIT');

INSERT INTO transaction (amount, account_id, source_account_id, destination_account_id, transaction_type)
VALUES (20.0, 2, null, null, 'DEPOSIT');

INSERT INTO transaction (amount, account_id, source_account_id, destination_account_id, transaction_type)
VALUES (-10.0, 2, null, 3, 'TRANSFER');

INSERT INTO transaction(amount, account_id, source_account_id, destination_account_id, transaction_type)
VALUES (10.0, 3, 2, null, 'TRANSFER');







