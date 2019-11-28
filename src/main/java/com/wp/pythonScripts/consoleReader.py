# @auther Andrew Truett
# Dependencies: selenium, pandas, xlrd

# This script serves as a toolkit for reading any and all console messages. See usage instructions below

from selenium import webdriver
from selenium.webdriver.common.desired_capabilities import DesiredCapabilities
import selenium

import pandas as pd
import sys
import time

args = sys.argv

search_network = False
search_dev_console = False

# Command line documentation
#
# Ex. python3 consoleReader.py -DC -string "Got response for slots" -limit 1000 -sheet "URLs" -column "Staging URLs"
#
# -DC : read the developer console
# -N : read the network console
# -string : the following string is the string to check existence for in console
# -limit : the following number is for console messages that check load times, this is the upper limit for those load times
# -sheet : the following string is the sheet name in the data.xlsx to read URLs from
# -column : the following string is the column in the specified sheet
# -waittime: the following number is the amount of seconds the script will wait for the page to load

# If no limit is specified, the existence of the string is only checked

# Check command line arguments
if "-DC" in args:
    search_dev_console = True
elif "-N" in args:
    search_network = True
else:
    sys.exit('FAIL: No console type specified')

search_string = ''
limit = None
sheet_name = ''
column_name = ''

#If no limit is specified, the script only checks for existence of the string in the console
check_for_existence = False

#Required Arguments
try:
    string_index = args.index('-string')
    search_string = args[string_index + 1]

    sheet_name_index = args.index('-sheet')
    sheet_name = args[sheet_name_index + 1]

    column_name_index = args.index('-column')
    column_name = args[column_name_index + 1]

except ValueError:
    sys.exit('FAIL: Improper command line arguments')

#Wait time
try:
    waittime_index = args.index('-waittime')
    waittime = int(args[waittime_index + 1])
except ValueError:
    waittime = 5

#Limit
try:
    limit_index = args.index('-limit')
    limit = int(args[limit_index + 1])
except ValueError:
    #If no limit is specified
    check_for_existence = True

# enable browser logging
d = DesiredCapabilities.CHROME
d['goog:loggingPrefs'] = { 'browser':'ALL' }
#d["pageLoadStrategy"] = "normal"  #  complete
#d["pageLoadStrategy"] = "eager"  #  interactive : NOT SUPPORTED
d["pageLoadStrategy"] = "none"   #  undefined - Note: Using this will require implementation of some mechanism to wait

driver = webdriver.Chrome(desired_capabilities=d, executable_path="src/main/resources/Drivers/chromedriver")

#Create dataframe and remove any empty rows from the column
df = pd.read_excel('datafiles/data.xlsx', sheet_name=sheet_name)
df = df.dropna(subset=[column_name])

# For each URL in excel sheet
test_num = 1

for url in df[column_name]:
    
    #Remove ?googfc from URL, it is not necessary for this test, and removing it greatly improves loadtimes of pages
    #url = url[:-7]
    
    time_out = False
    try:
        # Load desired webpage
        driver.get(url)
        time.sleep(waittime) 

    except selenium.common.exceptions.TimeoutException:
        time_out = True
        test_num = test_num + 1


    # Get logs
    load_times = []
    if search_dev_console:
        logs = driver.get_log('browser')
        
        # Filter logs to contain what we want
        logs = list(filter(lambda entry: search_string in entry['message'], logs))
        test_result = None

        # If relevant logs were found, parse them
        if len(logs) > 0:
            if check_for_existence:
                test_result = True
            else:
                load_times = []
                for entry in logs:
                    msg = entry['message']
        
                    for word in msg.split():
                        if word.isnumeric():
                            load_times.append(int(word)) 
        
           

    elif search_network:
        logs = driver.execute_script('var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;')


        # Filter logs to contain what we want
        #logs = list(filter(lambda entry: 'https://js-sec.indexww.com/ht/p/184414-82921100256406.js' in entry['name'], logs))
        logs = list(filter(lambda entry: search_string in entry['name'], logs))

        test_result = None

        # If relevant logs were found, parse them
        if len(logs) > 0:
            load_times = []
            for entry in logs:
                duration = entry['duration']
                load_times.append(float(duration)) 

    test_result = all(num < limit for num in load_times)


    # Print results
    print('Test ', test_num)
    print('URL: ', url)

    if time_out:
        print('Passed: False')
        print('Note: Timed out')

    elif len(logs) == 0:
        print('Passed: False')
        print('Note: No logs found')

    else:
        print('Passed: ', test_result)

        # If test passed, nothing to note
        if test_result:
            print('Note: None')
        else: 
            print('Note: Failed')

    test_num = test_num + 1

    # For tesing purposes
    #if test_num > 4:
    #    break


driver.close()