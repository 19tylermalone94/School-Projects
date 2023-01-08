#Tyler Malone
#Week 7 Assignment

totalFood = 0
totalGasCost = 0
foodPerPerson = []
#input number of people
while True:
	try:
		numPeople = int(input('Enter the number of people on the trip: '))
		for person in range(numPeople):
			#establish the length for the foodPerPerson list
			foodPerPerson.append(0)
		break
	except ValueError:
		print('Enter only whole numberical values!')
#input number of days
while True:
	try:
		numDays = int(input('Enter the number of days the trip lasted: '))
		break
	except ValueError:
		print('Enter only whole numerical values!')


#input for each day - food cost per person, and daily gas
dayCounter = 1
for day in range(numDays):
	while True:
		try:
			dailyGasCost = float(input('How much money was spent on gas on day ' + str(dayCounter) + '?: '))
			break
		except ValueError:
			print('numerical values only!')
	#add to gas total for each day iteration
	totalGasCost = totalGasCost + dailyGasCost
	dayCounter += 1
	personCounter = 1
	#calculate daily food cost per person for each day iteration
	for person in range(numPeople):
		while True:
			try:
				dailyFood = float(input('How much money did person ' + str(personCounter) + ' spend on food this day?: '))
				break
			except ValueError:
				print('numerical values only!')
		foodPerPerson[personCounter - 1] += dailyFood
		personCounter += 1

#calculate total food cost by summing indivual food costs
totalFoodCost = 0
for individualFoodCost in range(len(foodPerPerson)):
	totalFoodCost += foodPerPerson[individualFoodCost]

#Calculate each person's percentage of the total cost. Gas is divided equally, so it's calculated with food cost
costShareRatio = []
for share in range(len(foodPerPerson)):
	costShareRatio.append(foodPerPerson[share] / totalFoodCost)

#Calculate total trip cost
totalTripCost = totalFoodCost + totalGasCost

#Display each category cost and total cost
print('Total cost of food: $' + str(totalFoodCost))
print('Total cost of gas: $' + str(totalGasCost))
print('Total trip cost: $' + str(totalTripCost))

#This loop finds each share by multiplying each percentage with the total cost
personCounter2 = 1
for ratio in range(len(costShareRatio)):
	print('price for person ' + str(personCounter2) +' is: $' + str(totalTripCost * costShareRatio[ratio]))
	personCounter2 += 1 

