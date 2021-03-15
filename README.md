# BullsAndCows

# Description

Some players need a challenge, so let's make the secret code in the game harder to guess. Add support for more than 10 symbols by adding letters. Now, the secret code can contain numbers 0-9 and lowercase Latin characters a-z. The new maximum length for the code is 36. Note that the length of the secret word may not match the size of possible characters in the secret code, so you should make two separate inputs for the secret code length and for the size of possible characters.

Also, since a secret code is not a number anymore, the symbol 0 should be allowed as the first character in a secret code.

# Objectives

In this step, your program should:

1. Ask for the length of the secret code.
2. Ask for the range of possible characters in the secret code.
3. Generate a secret code using numbers and characters. This time, you should also print the secret code using * characters and print which characters were used to generate the secret code.
4. Function as a fully playable game.
