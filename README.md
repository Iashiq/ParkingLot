# ParkingLot
Lets assume that we have a parking lot with fixed dimension, and there is a large variety of cars, busses,
motorcycles and various other vehicles that need to be parked on it for long term. In the long term, we
do not care where the individual vehicles are, and if they are accessible or not, all that we care about is
to fit all of the vehicles on the lot.

# Introduction
Given a matrix sizes 𝑃 ∈ 𝑁𝐿×𝑊 which shows, the position of the individual cars on the lot. Let us also
have a set of vehicles V= {(𝑙𝑖, 𝑤𝑖)}𝑖=1
𝑁 , where li is the length of vehicle i., and wi is the width of the vehicle
i. For example, on a 5x7 sized parking lot, and set of vehicles:
V = {(4,2),(3,2),(1,2),(2,5),(2,2),(2,1),(3,1)}
A possible arrangement of vehicles can be placed as follows:
1 1 1 1 4 4 6
1 1 1 1 4 4 6
2 2 3 3 4 4 7
2 2 5 5 4 4 7
2 2 5 5 4 4 7

# Inputs
The input is multiple lines of text, with the individual elements being tab separated. The first line
contains the length and width of the parking lot. The second line contains the number of vehicles. Each
subsequent row contains the length and width of a single vehicle. So for the above example, the input
would look like this:
5 7
7
4 2
3 2
1 2
2 5
2 2
2 1
3 1

# Output
Output the entire P matrix to the standard output, with values on each line separated by tabs. (A
common mistake is to have extra tabs at the end of the lines, and we will not accept solutions that make
this error).
1 1 1 1 4 4 6
1 1 1 1 4 4 6
2 2 3 3 4 4 7
2 2 5 5 4 4 7
2 2 5 5 4 4 7
