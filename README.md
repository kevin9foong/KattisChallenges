# Kattisprojects

Just sharing the solutions to my attempted Kattis challenges(a portal of coding related challenges from various qualifiers/competitions etc etc) :)

DRM: encrypts any input based on the specialised DRM encryption method in the challenge. Divide, rotate and merge. 

Divide
– First, divide the message in half to “EWPG” and “AJRB”.
Rotate
– For each half, calculate its rotation value by summing up the values of each character (A=0,B=1,…,Z=25). The rotation value of “EWPG” is 4+22+15+6=47. Rotate each character in “EWPG” 47 positions forward (wrapping from Z to A when necessary) to obtain the new string “ZRKB”. Following the same process on “AJRB” results in “BKSC”.
Merge
– The last step is to combine these new strings (“ZRKB” and “BKSC”) by rotating each character in the first string by the value of the corresponding character in the second string. For the first position, rotating ‘Z’ by ‘B’ means moving it forward 1 character, which wraps it around to ‘A’. Continuing this process for every character results in the final decrypted message, “ABCD”.

Tarifa: Calculates the number of gb of data one has left after N+1 months, provided the data can be brought over to the next. 

Oddity: Displays whether a number input is odd/even.

Yours truly, 
Kevin Foong
