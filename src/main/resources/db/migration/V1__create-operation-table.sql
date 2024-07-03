CREATE TABLE operations (
  id SERIAL PRIMARY KEY UNIQUE NOT NULL,
  userDocument Text NOT NULL,
  creditCardToken TEXT NOT NULL,
  operationValue BIGINT NOT NULL
  );