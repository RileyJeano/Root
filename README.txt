Root Coding Problem 
Riley Patrick 

To create this project I first started off by making a model for each driver. Each driver would contain information about
how many miles the driver drove, how long they drove, the total miles, and the average miles per hour. Having each of these
variables belong to one driver object allowed me to quickly and easily assign new variables and to calculate those 
variables specific to each driver. Having objects with driver names also allowed me to assign multiple trip data to a 
single driver. 
Having a driver object also allowed for streamlined testing. I personally like to organize my testing so that each test
file coresponds to one java file. So, it helped me to organize those tests to have all my variables and methods to 
calcluate those variables in one place. 

I originally started out using reposities and databases to house my driver objects. But, quickly I found that this approach 
was adding too muchunecessary complexity. I then swithced to using an ArrayList, which offered many of the benefits of a 
database. The ArrayList offered the necessary functions to add objects, to access data within those objects, and sort 
those objects. I have also found ArrayLists quick to test, which added to this decision. Switching to using an ArrayList
helped make my project more simplified without compromising any functionality. 

I worked hard to make sure that each one of my files has different functionallity. RootApplication only takes in user input
and makes sure that it is viable. DriversTracking does all the logic that is not pertaining to the data in particular
drivers. DriversTracking holds the ArrayList of drivers and many of its methods pertain to that ArrayList. DriversTracking 
reads files, checks if the app should add a new driver or add information to an exhisting driver, it creates new drivers
to the ArrayList, checks to make sure trips are viable, sorts the ArrayList, gets specific drivers out of the 
ArrayList, and prints out the data from the ArrayList. The Driver file houses all the information about specific drivers. 
The Driver file calculates the data pertaining to that driver and prints out that data in a readable format for the 
DriversTracking file. 

I tested by using the TDD method. I started out not doing test driven development. I had started out coding on vacation, 
where I didn't have my computer, so I was coding on word. I had then copied that work over into eclipse when I got back 
home from vacation. But, after looking at the code I wrote, I realized that since I had not started out testing, 
trying to go back and write tests for exhisting code was much more difficult. So, I decided to scrap what I had done. I 
started writing the project over again, this time doing TDD. Becuase I had done much of the project once before, the
process didn't add too much extra time. I think that restarting with TDD probably saved me a great deal of time that would
have been spent on strugglingt to find bugs.
