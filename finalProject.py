#Tyler Malone
#Final Project

#initialize variables to be modified for final price output
totalCostGlobal = 0
seniorDiscountGlobal = 0
serviceTypeOutput = ''

#Define three menus - main, cleaning, and lawn
def mainMenu():
	print('WELCOME TO SCHWAB HOME AND LAWN CARE')
	print('we do not offer price matching')

	print('[1] House Cleaning Service')
	print('[2] Lawn Care Service')

def cleaningMenu():
	print('[1] Floor cleaning - $20')
	print('[2] Bathroom cleaning - $15')
	print('[3] Window cleaning - $10')
	print('[4] Dusting - $5')
	print('[5] Proceed to payment')

def lawnMenu():
	print('[1] Mowing - $1 per sqft')
	print('[2] Edging - $2 per ft')
	print('[3] Shrub Pruning - $5 per shrub')
	print('[4] Proceed to payment')


#Define cleaning function
def cleaningService():
	#Cost will be based on the number of rooms - minus 10% for 7+ rooms, minus 5% 4-6 rooms, and no deduction for 1-3 rooms
	totalCost = 0
	numRoomCatCost = 1
	#While loops are used to avoid program termination upon invalid input
	while True:
		try:
			numRooms = int(input('How many rooms would you like to be cleaned?: '))
			if numRooms > 6:
				numRoomCatCost = .10
			elif numRooms > 4:
				numRoomCatCost = .05
			break
		except ValueError:
			print('numerical values only!')
	#Counter is used for prompting message
	roomCounter = 1
	cleaningMenu()
	#This for loop allows the user to apply one service to each room
	for option in range(numRooms):
		while True:
			try:
				option = int(input('What service would you like in room ' + str(roomCounter) + '?: '))
				if option == 1:
					#modify total cost upon selection of service
					totalCost += 20
					print('Floor cleaning selected')
					break
				elif option == 2:
					totalCost += 15
					print('Bathroom cleaning selected')
					break
				elif option == 3:
					totalCost += 10
					print('Window cleaning selected')
					break
				elif option == 4:
					totalCost += 5
					print('Dusting selected')
					break
				elif option > 5 or option < 1:
					print('Enter a valid selection!')
					continue
				else:
					break
			except ValueError:
				print('numerical values only!')
		roomCounter += 1
	#modify global cost variable for final calculation with senior discount
	global totalCostGlobal
	totalCostGlobal += (totalCost * numRoomCatCost)


#Define lawn service function
def lawnService():
	totalCost = 0
	lawnMenu()
	#this loop handles the menu while the inner loops handle the inputs for yard parameters
	while True:
		try:
			option = int(input('Please make a selection: '))
			if option == 1:
				while True:
					try:
						yardSize = int(input('In square feet, how large is your yard?: '))
						break
					except ValueError:
						print('whole numerical values only!')
				totalCost += yardSize
			elif option == 2:
				while True:
					try:
						yardEdge = int(input('In feet, how long is the edge of your yard?: '))
						break
					except ValueError:
						print('whole numerical values only!')
				totalCost += yardEdge * 2
			elif option == 3:
				while True:
					try:
						numShrubs = int(input('How many shrubs would you like us to prune?: '))
						break
					except ValueError:
						print('whole numerical values only')
				totalCost += numShrubs * 5
			elif option > 4 or option < 1:
				print('Enter a valid selection!')
				continue
			else:
				break
			break
		except ValueError:
			print('whole numerical values only!')
	#modifying global cost for final cost calculation with senior discount
	global totalCostGlobal
	totalCostGlobal += totalCost


#import time to be used for age calculation in senior discount function
from datetime import date
#initialize percent 
seniorDiscountPercent = 1
#define senior discount function
def seniorDiscount():
	while True:
		try:
		#get birthdate
			year = int(input('Enter the year you were born: '))
			if len(str(year)) != 4:
				print('Enter a valid year!')
				continue
			month = int(input('Enter the month you were born: '))
			if len(str(month)) > 2 or month > 12 or month < 1:
				print('Enter a valid month!')
				continue
			day = int(input('Enter the day you were born: '))
			if len(str(day)) < 1 or len(str(day)) > 2 or day > 31 or day < 1:
				print('Enter a valid day!')
				continue
			break
		except ValueError:
                	print('Enter whole numerical values only!')
	#calculate birthdate with user input variables using built-in date function
	birthdate = date(year, month, day)
	#initialize today's date
	today = date.today()
	#calculate age in years
	age = today.year - birthdate.year - ((today.month, today.day) < (birthdate.month, birthdate.day))
	#determine if user is qualified for senior discount
	if age > 60:
		print('Senior Discount 10% off!')
		seniorDiscount = .1
		#modify global discount variable
		global seniorDiscountGlobal
		global totalCostGlobal
		seniorDiscountGlobal = totalCostGlobal * seniorDiscount
	else:
		print('You do not qualify for Senior Discount ;( ')

#Define main function to call all other functions in correct order
def main():
	mainMenu()
	while True:
		try:
			mainOption = int(input('Please make a selection by entering a number: '))
			if mainOption == 1:
				cleaningService()
				#modify global string to display user's choice in output string
				global serviceTypeOutput
				serviceTypeOutput = 'cleaning request'
				break
			elif mainOption == 2:
				lawnService()
				global seriveTypeOutput
				serviceTypeOutput = 'lawn service request'
				break
			elif mainOption < 1 or mainOption > 2:
				print('Enter a valid option')
		except ValueError:
			print('Enter numerical values only!')

#Call the main function and senior discount, then output the price calculation
main()
seniorDiscount()
print('The total cost for your ' + str(serviceTypeOutput) + ' is $' + str(totalCostGlobal - seniorDiscountGlobal))
