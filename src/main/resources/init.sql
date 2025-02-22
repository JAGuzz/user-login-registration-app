-- init.sql

-- Crear un nuevo rol con permisos específicos
CREATE ROLE dev_user WITH LOGIN PASSWORD 'password123';
GRANT CONNECT ON DATABASE mi_base_de_datos TO dev_user;
GRANT USAGE ON SCHEMA public TO dev_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO dev_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO dev_user;