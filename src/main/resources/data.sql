# INSERT INTO `charity-donation`.institutions (description, name)
# VALUES ('Cel i misja: Pomoc dzieciom z ubogich rodzin.', 'Fundacja "Dbam o Zdrowie"');
# INSERT INTO `charity-donation`.institutions (description, name)
# VALUES ('Cel i misja: Pomoc wybudzaniu dzieci ze śpiączki.', 'Fundacja "A kogo"');
# INSERT INTO `charity-donation`.institutions (description, name)
# VALUES ('Cel i misja: Pomoc osobom znajdującym się w trudnej sytuacji życiowej.', 'Fundacja “Dla dzieci"');
# INSERT INTO `charity-donation`.institutions (description, name)
# VALUES ('Cel i misja: Pomoc dla osób nie posiadających miejsca zamieszkania.', 'Fundacja “Bez domu”');
#
# INSERT INTO `charity-donation`.categories (name) VALUE ('ubrania, które nadają się do ponownego użycia');
# INSERT INTO `charity-donation`.categories (name) VALUE ('ubrania, do wyrzucenia');
# INSERT INTO `charity-donation`.categories (name) VALUE ('zabawki');
# INSERT INTO `charity-donation`.categories (name) VALUE ('książki');
# INSERT INTO `charity-donation`.categories (name) VALUE ('inne');
#
# INSERT INTO `charity-donation`.donations (city, pick_up_comment, pick_up_date, pick_up_time, quantity, street, zip_code,
#                                           institution_entity_id)
# VALUES ('Warsaw', 'comment 1', '2019-12-12', '15:00', 2, 'Ks. Janusza', '01-452', 1);
#
# INSERT INTO `charity-donation`.donations_categories (donation_entity_id, categories_id)
# VALUES (1, 1);
#
# INSERT INTO `charity-donation`.donations (city, pick_up_comment, pick_up_date, pick_up_time, quantity, street, zip_code,
#                                           institution_entity_id)
# VALUES ('Warsaw', 'comment 2', '2019-12-24', '17:00', 5, 'Ks. Janusza', '01-452', 2);
#
# INSERT INTO `charity-donation`.donations_categories (donation_entity_id, categories_id)
# VALUES (2, 3);
