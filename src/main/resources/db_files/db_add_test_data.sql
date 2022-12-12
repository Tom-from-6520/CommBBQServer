insert into organizers (username, name, phone, password) values 
('a@test.edu', 'test_org_1', '3620785705', 'test_org_1test_org_1'), 
('b@test.edu', 'test_org_2', '8570522427', 'test_org_2test_org_2'), 
('c@test.edu', 'test_org_3', '2242707701', 'test_org_3test_org_3'), 
('d@test.edu', 'test_org_4', '0770197058', 'test_org_4test_org_4'), 
('e@test.edu', 'test_org_5', '9705892111', 'test_org_5test_org_5');

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
(1, 1, 'test_event_1', '2022-12-3 18:33:00', '$10 each adult.'), 
(1, 2, 'test_event_2', '2022-12-6 19:28:00', '$11 each adult.'), 
(2, 3, 'test_event_3', '2022-12-14 19:14:00', '$12 each adult.'), 
(2, 4, 'test_event_4', '2022-12-3 16:26:00', '$13 each adult.'), 
(3, 5, 'test_event_5', '2022-12-11 18:43:00', '$14 each adult.'), 
(3, 6, 'test_event_6', '2022-12-12 15:17:00', '$15 each adult.'), 
(4, 7, 'test_event_7', '2022-12-14 18:57:00', '$16 each adult.'), 
(4, 8, 'test_event_8', '2022-12-1 13:32:00', '$17 each adult.'), 
(5, 9, 'test_event_9', '2022-12-1 14:27:00', '$18 each adult.'), 
(5, 10, 'test_event_10', '2022-12-12 13:10:00', '$19 each adult.');

insert into foods (name) values ('chicken'), ('turkey'), ('beef'), ('mash potato'), ('cold beer'), ('hot cider'), ('warm soup'), ('chill vibe');

insert into patrons (username, name, phone, password) values 
('a@test.edu', 'test_patron_1', '3620785705', 'test_patron_1test_patron_1'), 
('b@test.edu', 'test_patron_2', '8570522427', 'test_patron_2test_patron_2'), 
('c@test.edu', 'test_patron_3', '2242707701', 'test_patron_3test_patron_3'), 
('d@test.edu', 'test_patron_4', '0770197058', 'test_patron_4test_patron_4'), 
('e@test.edu', 'test_patron_5', '9705892111', 'test_patron_5test_patron_5'), 
('f@test.edu', 'test_patron_6', '9211136207', 'test_patron_6test_patron_6'), 
('g@test.edu', 'test_patron_7', '3620785705', 'test_patron_7test_patron_7'), 
('h@test.edu', 'test_patron_8', '8570522427', 'test_patron_8test_patron_8'), 
('i@test.edu', 'test_patron_9', '2242707701', 'test_patron_9test_patron_9'), 
('j@test.edu', 'test_patron_10', '0770197058', 'test_patron_10test_patron_10'), 
('k@test.edu', 'test_patron_11', '9705892111', 'test_patron_11test_patron_11'), 
('l@test.edu', 'test_patron_12', '9211136207', 'test_patron_12test_patron_12'), 
('m@test.edu', 'test_patron_13', '3620785705', 'test_patron_13test_patron_13'), 
('n@test.edu', 'test_patron_14', '8570522427', 'test_patron_14test_patron_14'), 
('o@test.edu', 'test_patron_15', '2242707701', 'test_patron_15test_patron_15'), 
('p@test.edu', 'test_patron_16', '0770197058', 'test_patron_16test_patron_16'), 
('q@test.edu', 'test_patron_17', '9705892111', 'test_patron_17test_patron_17'), 
('r@test.edu', 'test_patron_18', '9211136207', 'test_patron_18test_patron_18'), 
('s@test.edu', 'test_patron_19', '3620785705', 'test_patron_19test_patron_19'), 
('t@test.edu', 'test_patron_20', '8570522427', 'test_patron_20test_patron_20');

