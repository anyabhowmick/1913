# Anya Bhowmick and Felicia Tao
# Template file for Lab03 -- weather. By Peter Wang and Daniel Kluver
# Additions made by: Your names here...

# Import Statements
import csv  # imported for DictReader
import math  # imported for


# provided functions -- one handles some tedious loading details, and the other can help make sure you know what you're
# working with -- it's worth reading both carefully, and trying to learn from what you're seeing.


def load(filename):
    """load the CSV file by name, return list of dictionaries, each dictionary describes one row. of the file"""
    reader = csv.DictReader(
        open(filename), dialect="excel", skipinitialspace=True
    )
    return list(reader)


# provided function
def min_min_temp(file_list):
    """The input is a list of dictionaries like would be returned by the load function. The output is the minimum temperature
    observed in the dataset. We are tacitly assuming that the min temperature for a day is always below the max temperature
    """
    min_temp = math.inf
    for row in file_list:
        row_min_temp = float(row["Min_Temperature"])
        if row_min_temp < min_temp:
            min_temp = row_min_temp
    return min_temp


# Put your functions below this.

def F_to_C(f_temp):
    '''takes in f_temp, a fahrenheit value, converts it to celsius, and return the float''' 
    return 5*(f_temp - 32) / 9
     

def F_to_C_file(file_list):
    '''takes in file_list, a list of dictionaries, and extracts the max and min temps in fahrenheit, converts them to floats, and 
    changes them to celsius in the file. it returns nothing'''
    for dictionary in file_list:
        dictionary['Max_Temperature'] = F_to_C(float(dictionary['Max_Temperature']))
        dictionary['Min_Temperature'] = F_to_C(float(dictionary['Min_Temperature']))


def clean(file_list, column):
    '''takes in a given list of dictionaries (file_list) and a specific column name. 
    the function returns a new list without dictionaries containing special values ('T', 
    'M', 'S', 'A', ''), to 'clean' the given dictionary'''
    returnList = []
    for row in file_list:
        if isfloat(row[column]):
            returnList.append(row)
    
    return returnList 


def isfloat(num): 
    #https://www.programiz.com/python-programming/examples/check-string-number#:~:text=In%20the%20function%20isfloat(),is%20raised%20and%20returns%20False%20.
    #from programiz.com 

    '''returns true if num is a float, returns false if otherwise'''
    try:
        float(num)
        return True
    except ValueError:
        return False

def average(file_list, column):
    '''takes in a list of dictionaries and a column name and
    finds the average of all the values in that column from each dictionary 
    and returns it '''
    cleanList = clean(file_list, column)
    total = 0.0 

    if len(cleanList) == 0:
        return 0.0

    for row in cleanList:
        total += float(row[column])

    return total / len(cleanList)

def total_rain_by_year(file_list):
    '''takes in a list of dictionaries and returns a dictionary of the sums of all the rain
    for each year, where the years are the keys'''
    returnDict = {}
    cleanList = clean(file_list, "Precipitation")
    for row in cleanList:
        year = int(row["Date"][:4])
        if year in returnDict:
            returnDict[year] += float(row["Precipitation"])
        else: 
            returnDict[year] = float(row["Precipitation"])

    return returnDict

