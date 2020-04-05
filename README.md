# sohail.ghousuddin-gmail.com

# Design
1. Used Graph to store the information of cities and its connection
2. Assumed we should return YES if there is a connection indirectly to city from its connection, for example BOSTON to PHILADELPHIA there is no direct connection
but there is an in direct connection through NEWARK ( i have modified the data little bit) 
3. Used BFS , wanted to check if the city is on its direct connections first
4. Was not able to implement exception/error handling 
5. converted all the cities to upper case just to make sure we are ignoring case , i could have used ignore case also, saw there were some blanks in front and end so did trim
6. test cases also put it to very simple but overall coverage is 92%
7. Have not used any repositories or created any interfaces to access domain 
8. There was a thought to use graph DB like noe4j but i was not sure if i can use it.
