
delete from adopter;
alter sequence adopter_id_seq restart;

delete from animal;
alter sequence animal_id_seq restart;

INSERT INTO Adopter (name, phone_number) VALUES
('Jonas', 2345678),
('Fred', 3456789);

INSERT INTO Animal (name, type, breed) VALUES
('Filbert', 'Turtle', 'Snapping'),
('Bowser', 'Dog', 'Rottweiler'),
('Sam', 'Cat', 'Orange');