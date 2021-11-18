# SinbadDataLab

## Project 1
Run the `main` method in the `ProcessWeatherStations_1` class. When you select “1” from the menu, the program will connect with the Atlanta Hartsfield International Airport weather station. You will see the URL (http://weather.gov/xml/current_obs/KATL.xml) that was used to connect with the `DataSource`. When you click the link to the URL, you will see a webpage constructed from the data that is retrieved. In the console, you will see the fields that can be accessed from the `DataSource`, as well as the current temperature at the airport in Fahrenheit.

Your task is to complete two methods.

The `promptUserAndRetrieve` method which prompts the user for a weather station code (you can check [here](https://w1.weather.gov/xml/current_obs/) to search for one) then returns a `String` that is built of the four weather attributes of the current weather conditions at the requested location. The `compareLocations` method prompts the user for two (or more) locations and compares attributes of them and returns a `String` built of the results.

## Project 2
For this problem, you will make modifications to the `Observation` class. The `Observation` class is intended to encapsulate the attributes of a weather observation. Initially it has temperature, wind direction and description attributes. When you run this project, initially, two objects are instantiated, but the class doesn’t work correctly. You need to finish the constructor, `colderThan`, `compareTo` and `toString` methods. After solving that, move on to part two, the `test6ParamConstructor` which requires you to modify the `Observation` class so that you can construct an `Observation` object with 6 parameters. After adding a second constructor, add some getters so that you can compare `Observation` objects based on the new attributes. Make sure to update your `toString` method so that it is appropriate for the latest version of the `Observation` class. Use the 

`ProcessWeatherStationObject` class and the `Observation` class.

## Project 3
For this problem you will make changes to the `WeatherStation` class. You need to add a state attribute, as well as other attributes (like longitude, latitude, etc. things that a weather station would have). After adding this, input all the weather stations and find the number of stations in a user prompted state. Then prompt the user for a state then find the station with the largest latitude or longitude or…

Use `ProcessWeatherStationList` class and `WeatherStation` class.
