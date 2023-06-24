# Power-of-G-Man

Problem statement

Context
 G-Man is a video game in which G-Man has to move from one point to another on a grid (6 X 6 grid). There could be multiple paths between a source coordinate and destination coordinate and G-Man needs to reach the destination by spending least amount of power.

Position
 -G-Man’s position is located by the x, y coordinate of the grid. 
 -One of the four compass points N, E, S and W indicates the direction G-Man is facing. 
 Eg: 2, 1 N means the G-Man is at 2 on the x coordinate, 1 on the y coordinate, and facing North.

6 X 6 Grid
Moves
 At the start of the game, G-Man is given a power of 200 units. His power is reduced for every move and turn he takes.
 
-G-Man can turn left or right 90 degrees at a time to change his direction.
-For every turn G-Man makes, his power is reduced by 5.
-For every move that G-Man makes by 1 grid point, his power is reduced by 10.
  eg: If G-Man moves from 2, 1 E to the destination 4, 1 he loses 20 power points. 
  eg: If G-Man moves from 2, 1 S to 4, 5; he has to turn twice and move 6 grid points. So he loses 70 power points. 

Goal
 Given the source and destination coordinates, G-Man needs to reach the destination by spending least amount of power. And you need to print the remaining power he has after taking the shortest path with minimum number of turns. 


Input Commands & Format
 Your program should take as input the source coordinates, direction and destination coordinates.
 
SOURCE X_COORDINATE Y_COORDINATE DIRECTION 
DESTINATION X_COORDINATE Y_COORDINATE 
PRINT_POWER 
Output Commands & Format
 The output should be remaining power G-Man has after taking the shortest path.
 
POWER  REMAINING_POWER_QUANTITY

Sample Input/Output 1
INPUT	
SOURCE2 1 E
DESTINATION4 3 
OUTPUT
PRINT_POWER	POWER155

Sample Input/Output 2
INPUT	
SOURCE 0 5 W
DESTINATION6 1
OUTPUT
PRINT_POWER	POWER90

Sample Input/Output 3
INPUT	
SOURCE 3 6 N
DESTINATION1 0
OUTPUT
PRINT_POWER POWER110

