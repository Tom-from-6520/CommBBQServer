street = ["Lincoln Ave", "Water Bender St", "N. Wash Ave", "Fire Bender St", "Earth Bender St", "Air Bender St"]
city = ["Anniston", "Tucson", "Bowling Green", "Red Bank", "The Dalles", "San Diego"]
state = ["AL", "AZ", "VA", "NJ", "OR", "CA"]
zip_code = ["36207", "85705", "22427", "07701", "97058", "92111"]

num_org = 5
num_patron = 10
num_event = 10


# open the test data sql file
f = open('db_add_test_data.sql', 'a')

# add the org
org_query = "insert into organizers ()"
for i in range(num_org):
    email = str(chr(97+i)) + "@test.edu"
    name = "test" + str(i)
    phone = str(zip_code[i%len(zip_code)]) + str(zip_code[(i+1)%len(zip_code)])
    password = name + name
    

    


# close the test data sql file
f.close()