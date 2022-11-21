from random import Random

rand = Random(256)

street = ["Lincoln Ave", "Water Bender St", "N. Wash Ave", "Fire Bender St", "Earth Bender St", "Air Bender St"]
city = ["Anniston", "Tucson", "Bowling Green", "Red Bank", "The Dalles", "San Diego"]
state = ["AL", "AZ", "VA", "NJ", "OR", "CA"]
zip_code = ["36207", "85705", "22427", "07701", "97058", "92111"]
food = ["chicken", "turkey", "beef", "mash potato", "cold beer", "hot cider", "warm soup", "chill vibe"]

num_org = 5
num_addr_per_org = 2
num_addr = num_org * num_addr_per_org
num_patron = num_addr * 2

# open the test data sql file
file = open("C:/Users/Tom/codespace/vscode_test/cbbq/cbbq/src/main/resources/db_files/db_add_test_data.sql", 'w+')

# add the org
org_query = "insert into organizers (username, name, phone, password) values \n"
for i in range(num_org):
    email = str(chr(97+i)) + "@test.edu"
    name = "test_org_" + str(i)
    phone = str(zip_code[i%len(zip_code)]) + str(zip_code[(i+1)%len(zip_code)])
    password = name + name
    org_query += "('{}', '{}', '{}', '{}'), \n".format(email, name, phone, password)
file.write(org_query[:-3] + ";\n\n")

# add the address
addr_query = "insert into addresses (org_id, street_address, city, us_state, zip_code, country) values \n"
for i in range(num_addr):
    org_id = i // num_addr_per_org + 1
    newSt = street[rand.randint(0, 5)]
    newCity = city[rand.randint(0, 5)]
    newState = state[rand.randint(0, 5)]
    newZip = zip_code[rand.randint(0, 5)]
    addr_query += "({}, '{}', '{}', '{}', '{}', '{}'), \n".format(org_id, newSt, newCity, newState, newZip, 'US')
file.write(addr_query[:-3] + ";\n\n")

# add the events
event_query = "insert into events (org_id, address_id, name, event_time, price) values \n"
for i in range(num_addr):
    org_id = i // num_addr_per_org + 1
    addr_id = i+1
    name = "test_event_" + str(i)
    event_time = "2022-12-" + str(rand.randint(1, 14)) + " " + str(rand.randint(12, 19)) + ":" + str(rand.randint(10, 59)) + ":00"
    price = "$" + str(i+10) + " each adult."
    event_query += "({}, {}, '{}', '{}', '{}'), \n".format(org_id, addr_id, name, event_time, price)
file.write(event_query[:-3] + ";\n\n")

# add the food
food_query = "insert into foods (name) values "
for f in food:
    food_query += "('{}'), ".format(f)
file.write(food_query[:-2] + ";\n\n")

# add have_food relationship
have_foor_query = "insert into have_food (event_id, food_id) values "
for i in range(num_addr):
    food_idx = rand.sample(list(range(1, len(food)+1, 1)), 3)
    for j in range(3):
        have_foor_query += "({}, {}), ".format(i+1, food_idx[j])
file.write(have_foor_query[:-2] + ";\n\n")

# add the patrons
patron_query = "insert into patrons (username, name, phone, password) values \n"
for i in range(num_patron):
    email = str(chr(97+i)) + "@test.edu"
    name = "test_patron_" + str(i)
    phone = str(zip_code[i%len(zip_code)]) + str(zip_code[(i+1)%len(zip_code)])
    password = name + name
    patron_query += "('{}', '{}', '{}', '{}'), \n".format(email, name, phone, password)
file.write(patron_query[:-3] + ";\n\n")

# add attend relationship
attend_query = "insert into attend (patron_id, event_id) values "
for i in range(num_patron):
    num_attended = rand.randint(1, num_addr-1)
    events_attended = rand.sample(list(range(1, num_addr+1, 1)), num_attended)
    for j in range(num_attended):
        attend_query += "({}, {}), ".format(i+1, events_attended[j])
file.write(attend_query[:-2] + ";\n\n")

# add favorite_event relationship
fav_event_query = "insert into favorite_event (patron_id, event_id) values "
for i in range(num_patron):
    num_fav = rand.randint(1, num_addr//2)
    fav_events = rand.sample(list(range(1, num_addr+1, 1)), num_fav)
    for j in range(num_fav):
        fav_event_query += "({}, {}), ".format(i+1, fav_events[j])
file.write(fav_event_query[:-2] + ";\n\n")


# add favorite_org relationship
fav_org_query = "insert into favorite_org (patron_id, org_id) values "
for i in range(num_patron):
    num_fav = rand.randint(1, num_org//2)
    fav_org = rand.sample(list(range(1, num_org+1, 1)), num_fav)
    for j in range(num_fav):
        fav_org_query += "({}, {}), ".format(i+1, fav_org[j])
file.write(fav_org_query[:-2] + ";\n\n")


# close the test data sql file
file.close()