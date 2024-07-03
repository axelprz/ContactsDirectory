-- States --
INSERT INTO states (id, name) VALUES (1, 'Buenos Aires');
INSERT INTO states (id, name) VALUES (2, 'Santa Fe');
INSERT INTO states (id, name) VALUES (3, 'Cordoba');
INSERT INTO states (id, name) VALUES (4, 'Mendoza');
INSERT INTO states (id, name) VALUES (5, 'Salta');
-- Cities --
INSERT INTO cities (id, name, id_state) VALUES (1, 'La Matanza', 1);
INSERT INTO cities (id, name, id_state) VALUES (3, 'General Roca', 3);
INSERT INTO cities (id, name, id_state) VALUES (4, 'San Martín', 4);
INSERT INTO cities (id, name, id_state) VALUES (5, 'Capital', 5);
INSERT INTO cities (id, name, id_state) VALUES (6, 'La Plata', 1);
INSERT INTO cities (id, name, id_state) VALUES (2, 'Rosario', 2);
-- Addresses --
INSERT INTO addresses (id, street, id_city) VALUES (1, 'Av. Libertador 1234', 1);
INSERT INTO addresses (id, street, id_city) VALUES (2, 'Calle Falsa 456', 2);
INSERT INTO addresses (id, street, id_city) VALUES (3, 'Calle Luna 789', 3);
INSERT INTO addresses (id, street, id_city) VALUES (4, 'Calle Sol 101', 4);
INSERT INTO addresses (id, street, id_city) VALUES (5, 'Calle Estrella 202', 5);
INSERT INTO addresses (id, street, id_city) VALUES (6, 'Calle Campo 303', 6);
-- Contacts --
INSERT INTO contacts (first_name, last_name, email, birth_date, id_address) VALUES ('Maria', 'Gonzalez', 'maria.gonzalez@example.com', '1990-08-15', 1);
INSERT INTO contacts (first_name, last_name, email, birth_date, id_address) VALUES ('Juan', 'Martinez', 'juan.martinez@example.com', '1985-03-20', 2);
INSERT INTO contacts (first_name, last_name, email, birth_date, id_address) VALUES ('Lucia', 'Rodriguez', 'lucia.rodriguez@example.com', '2000-12-01', 3);
INSERT INTO contacts (first_name, last_name, email, birth_date, id_address) VALUES ('Carlos', 'Fernandez', 'carlos.fernandez@example.com', '1975-11-25', 4);
INSERT INTO contacts (first_name, last_name, email, birth_date, id_address) VALUES ('Ana', 'Lopez', 'ana.lopez@example.com', '1995-05-10', 5);
INSERT INTO contacts (first_name, last_name, email, birth_date, id_address) VALUES ('Pedro', 'Ramirez', 'pedro.ramirez@example.com', '1982-07-15', 6);
-- Phones --
INSERT INTO phones (number, type, id_contact) VALUES ('1112345678', 'MOBILE', 1); -- Maria Gonzalez
INSERT INTO phones (number, type, id_contact) VALUES ('3412345678', 'HOME', 2); -- Juan Martinez
INSERT INTO phones (number, type, id_contact) VALUES ('3512345678', 'WORK', 3); -- Lucia Rodriguez
INSERT INTO phones (number, type, id_contact) VALUES ('2612345678', 'MOBILE', 4); -- Carlos Fernandez
INSERT INTO phones (number, type, id_contact) VALUES ('3872345678', 'HOME', 5); -- Ana Lopez
INSERT INTO phones (number, type, id_contact) VALUES ('2212345678', 'MOBILE', 6); -- Pedro Ramirez
-- Groups --
INSERT INTO groups (name) VALUES ('Trabajo');
INSERT INTO groups (name) VALUES ('Familia');
INSERT INTO groups (name) VALUES ('Amigos');
INSERT INTO groups (name) VALUES ('Deportes');
-- Contacts-Groups --
INSERT INTO contacts_groups (contact_id, group_id) VALUES (1, 1); -- Maria Gonzalez en Trabajo
INSERT INTO contacts_groups (contact_id, group_id) VALUES (2, 2); -- Juan Martinez en Familia
INSERT INTO contacts_groups (contact_id, group_id) VALUES (3, 3); -- Lucia Rodriguez en Amigos
INSERT INTO contacts_groups (contact_id, group_id) VALUES (4, 1); -- Carlos Fernandez en Trabajo
INSERT INTO contacts_groups (contact_id, group_id) VALUES (4, 4); -- Carlos Fernandez en Deportes
INSERT INTO contacts_groups (contact_id, group_id) VALUES (5, 2); -- Ana Lopez en Familia
INSERT INTO contacts_groups (contact_id, group_id) VALUES (5, 3); -- Ana Lopez en Amigos
INSERT INTO contacts_groups (contact_id, group_id) VALUES (6, 1); -- Pedro Ramirez en Trabajo
INSERT INTO contacts_groups (contact_id, group_id) VALUES (6, 2); -- Pedro Ramirez en Familia
