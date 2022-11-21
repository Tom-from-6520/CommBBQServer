insert into organizers (username, name, phone, password) values 
('a@test.edu', 'test_org_0', '3620785705', 'test_org_0test_org_0'), 
('b@test.edu', 'test_org_1', '8570522427', 'test_org_1test_org_1'), 
('c@test.edu', 'test_org_2', '2242707701', 'test_org_2test_org_2'), 
('d@test.edu', 'test_org_3', '0770197058', 'test_org_3test_org_3'), 
('e@test.edu', 'test_org_4', '9705892111', 'test_org_4test_org_4');

insert into addresses (org_id, street_address, city, us_state, zip_code, country) values 
(1, 'Fire Bender St', 'Bowling Green', 'NJ', '22427', 'US'), 
(1, 'Fire Bender St', 'Anniston', 'NJ', '07701', 'US'), 
(2, 'Water Bender St', 'The Dalles', 'AZ', '22427', 'US'), 
(2, 'Air Bender St', 'Bowling Green', 'OR', '22427', 'US'), 
(3, 'N. Wash Ave', 'The Dalles', 'AL', '97058', 'US'), 
(3, 'N. Wash Ave', 'The Dalles', 'AZ', '92111', 'US'), 
(4, 'N. Wash Ave', 'Anniston', 'OR', '07701', 'US'), 
(4, 'Lincoln Ave', 'San Diego', 'NJ', '85705', 'US'), 
(5, 'Air Bender St', 'The Dalles', 'AZ', '36207', 'US'), 
(5, 'Air Bender St', 'Bowling Green', 'AL', '85705', 'US');

insert into events (org_id, address_id, name, event_time, price) values 
(1, 1, 'test_event_0', '2022-12-3 18:33:00', '$10 each adult.'), 
(1, 2, 'test_event_1', '2022-12-6 19:28:00', '$11 each adult.'), 
(2, 3, 'test_event_2', '2022-12-14 19:14:00', '$12 each adult.'), 
(2, 4, 'test_event_3', '2022-12-3 16:26:00', '$13 each adult.'), 
(3, 5, 'test_event_4', '2022-12-11 18:43:00', '$14 each adult.'), 
(3, 6, 'test_event_5', '2022-12-12 15:17:00', '$15 each adult.'), 
(4, 7, 'test_event_6', '2022-12-14 18:57:00', '$16 each adult.'), 
(4, 8, 'test_event_7', '2022-12-1 13:32:00', '$17 each adult.'), 
(5, 9, 'test_event_8', '2022-12-1 14:27:00', '$18 each adult.'), 
(5, 10, 'test_event_9', '2022-12-12 13:10:00', '$19 each adult.');

insert into foods (name) values ('chicken'), ('turkey'), ('beef'), ('mash potato'), ('cold beer'), ('hot cider'), ('warm soup'), ('chill vibe');

insert into have_food (event_id, food_id) values (1, 4), (1, 7), (1, 2), (2, 4), (2, 8), (2, 2), (3, 8), (3, 7), (3, 5), (4, 4), (4, 5), (4, 6), (5, 6), (5, 4), (5, 1), (6, 8), (6, 6), (6, 3), (7, 6), (7, 4), (7, 1), (8, 8), (8, 5), (8, 7), (9, 8), (9, 5), (9, 1), (10, 6), (10, 4), (10, 7);

insert into patrons (username, name, phone, password) values 
('a@test.edu', 'test_patron_0', '3620785705', 'test_patron_0test_patron_0'), 
('b@test.edu', 'test_patron_1', '8570522427', 'test_patron_1test_patron_1'), 
('c@test.edu', 'test_patron_2', '2242707701', 'test_patron_2test_patron_2'), 
('d@test.edu', 'test_patron_3', '0770197058', 'test_patron_3test_patron_3'), 
('e@test.edu', 'test_patron_4', '9705892111', 'test_patron_4test_patron_4'), 
('f@test.edu', 'test_patron_5', '9211136207', 'test_patron_5test_patron_5'), 
('g@test.edu', 'test_patron_6', '3620785705', 'test_patron_6test_patron_6'), 
('h@test.edu', 'test_patron_7', '8570522427', 'test_patron_7test_patron_7'), 
('i@test.edu', 'test_patron_8', '2242707701', 'test_patron_8test_patron_8'), 
('j@test.edu', 'test_patron_9', '0770197058', 'test_patron_9test_patron_9'), 
('k@test.edu', 'test_patron_10', '9705892111', 'test_patron_10test_patron_10'), 
('l@test.edu', 'test_patron_11', '9211136207', 'test_patron_11test_patron_11'), 
('m@test.edu', 'test_patron_12', '3620785705', 'test_patron_12test_patron_12'), 
('n@test.edu', 'test_patron_13', '8570522427', 'test_patron_13test_patron_13'), 
('o@test.edu', 'test_patron_14', '2242707701', 'test_patron_14test_patron_14'), 
('p@test.edu', 'test_patron_15', '0770197058', 'test_patron_15test_patron_15'), 
('q@test.edu', 'test_patron_16', '9705892111', 'test_patron_16test_patron_16'), 
('r@test.edu', 'test_patron_17', '9211136207', 'test_patron_17test_patron_17'), 
('s@test.edu', 'test_patron_18', '3620785705', 'test_patron_18test_patron_18'), 
('t@test.edu', 'test_patron_19', '8570522427', 'test_patron_19test_patron_19');

insert into attend (patron_id, event_id) values (1, 1), (2, 2), (2, 7), (2, 4), (2, 1), (2, 3), (2, 10), (2, 9), (3, 1), (3, 2), (3, 3), (3, 10), (3, 8), (3, 6), (3, 5), (3, 4), (3, 7), (4, 5), (4, 4), (4, 7), (4, 1), (5, 4), (5, 8), (5, 10), (6, 6), (6, 7), (6, 4), (6, 3), (6, 1), (6, 9), (6, 5), (7, 5), (7, 4), (7, 7), (7, 10), (7, 6), (7, 8), (7, 9), (7, 1), (8, 2), (9, 5), (9, 4), (9, 6), (9, 7), (9, 10), (9, 3), (9, 1), (9, 8), (10, 5), (10, 9), (10, 3), (10, 2), (10, 6), (10, 7), (10, 10), (10, 8), (11, 10), (11, 2), (11, 3), (11, 9), (11, 7), (11, 6), (11, 5), (11, 8), (12, 9), (12, 1), (12, 8), (13, 5), (13, 9), (13, 4), (13, 1), (14, 9), (14, 5), (14, 2), (14, 6), (14, 7), (14, 8), (14, 1), (14, 4), (15, 3), (15, 6), (15, 1), (15, 10), (15, 7), (15, 8), (15, 2), (15, 4), (15, 9), (16, 8), (16, 10), (16, 4), (16, 1), (16, 7), (16, 2), (16, 5), (16, 6), (16, 9), (17, 7), (18, 5), (18, 10), (19, 2), (19, 8), (19, 5), (19, 1), (19, 7), (19, 4), (19, 10), (19, 6), (20, 10), (20, 7), (20, 3), (20, 2), (20, 4), (20, 8);

insert into favorite_event (patron_id, event_id) values (1, 8), (1, 9), (1, 1), (1, 3), (2, 7), (2, 10), (3, 10), (3, 1), (3, 4), (3, 8), (4, 3), (4, 10), (4, 2), (4, 1), (5, 4), (5, 1), (5, 2), (5, 10), (5, 6), (6, 5), (6, 3), (6, 7), (7, 9), (7, 1), (7, 8), (7, 6), (7, 4), (8, 6), (8, 8), (8, 2), (9, 9), (9, 6), (9, 8), (9, 1), (9, 2), (10, 4), (10, 8), (11, 3), (11, 9), (12, 4), (13, 10), (13, 7), (13, 1), (14, 6), (15, 4), (15, 7), (16, 8), (16, 10), (16, 9), (17, 4), (17, 10), (17, 1), (17, 8), (17, 5), (18, 6), (18, 1), (18, 5), (19, 5), (20, 3), (20, 7), (20, 5);

insert into favorite_org (patron_id, org_id) values (1, 2), (1, 3), (2, 4), (3, 2), (3, 1), (4, 4), (4, 2), (5, 3), (6, 3), (7, 4), (7, 3), (8, 2), (8, 3), (9, 2), (10, 4), (10, 1), (11, 3), (12, 1), (13, 5), (14, 2), (15, 3), (15, 1), (16, 3), (16, 1), (17, 4), (17, 3), (18, 5), (19, 4), (20, 2), (20, 3);

