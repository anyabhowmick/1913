from words import words
from display_utility import green, yellow, grey 
import random


def check_word(secret, guess):
    '''
    takes in the secret word and the guess, returns a list of colors
        (green, gray, yellow) corresponding to each letter of the guess as compared with the secret 
    if the same letter is in the same spot for both words, it's green
    if the same letter is in a different spot AND it's not a repeat of green, it's yellow
    else, gray
    '''
    secret = secret.upper()
    guess = guess.upper()
    secretList = list(secret)
    guessList = list(guess)
    colorList = []

    #assign green 
    for i in range(0, 5):
        if secret[i] == guess[i]:
            colorList.append("green")
        else: 
            colorList.append("grey")
    
    #assign yellow 
    for secretIndex in range(5):
        if colorList[secretIndex] != 'green': 
            for guessIndex in range(5):
                if secret[secretIndex] == guess[guessIndex] and colorList[guessIndex] == 'grey':
                    #if the letters match up and it's gray, change it to yellow 
                    colorList[guessIndex] = 'yellow'
                    break
        
    return colorList

    

def known_word(clues):
    '''
    takes in the set of clues, a list of tuples with the user's guesses so far 
        and the corresponding color lists when compared to the secret 

    creates returnList, a list with all the known letters marked and _ representing unknown letter
    returns a STRING crated by joining returnList
    '''    
    returnList = ['_', '_', '_', '_', '_']

    for tuples in clues:
        guessList = list(tuples[0])
        for idx in range(5):
            if tuples[1][idx] == 'green' and returnList[idx] == '_':
                returnList[idx] = guessList[idx]

    return "".join(returnList)

def no_letters(clues):
    '''
    takes in the set of clues, a list of tuples with the user's guesses so far 
        and the corresponding color lists when compared to the secret 

    returns all the letters guessed by user that were NOT in secret (aka marked grey in the corresponding color list)
    returns a STRING crated by joining returnList
    if no letters didnt match, an empty string is returned
    '''

    yellowSet = set()


    greySet = set()

    for tuples in clues:
        guessList = list(tuples[0]) #splits characters in guess and puts them in a list
        for idx in range(5):
            if tuples[1][idx] == 'yellow' or tuples[1][idx] == 'green':
                yellowSet.add(guessList[idx].upper())
            elif tuples[1][idx] == 'grey':
                greySet.add(guessList[idx].upper())
                
    returnList = list(greySet.difference(yellowSet))    
    if(returnList):
        returnList.sort()
        return "".join(returnList)
    else:
        return ""


def yes_letters(clues):
    '''
    takes in the set of clues, a list of tuples with the user's guesses so far 
        and the corresponding color lists when compared to the secret 

    returns all the letters guessed by user that WERE in secret (aka marked green or yellow in the corresponding color list)
    returns a STRING crated by joining returnList
    if no letters were found to match, an empty string is returned 
    '''
    yellowSet = set()
    greySet = set()

    for tuples in clues:
        guessList = list(tuples[0]) #splits characters in guess and puts them in a list
        for idx in range(5):
            if tuples[1][idx] == 'yellow' or tuples[1][idx] == 'green':
                yellowSet.add(guessList[idx].upper())
            elif tuples[1][idx] == 'grey':
                greySet.add(guessList[idx].upper())
                
    returnList = list(yellowSet)
    if(returnList):
        returnList.sort()
        return "".join(returnList)
    else:
        return ""
    

def game(secret):
    '''
    formats the game for player by taking in the secret word
    prints the known letters by calling the known_word function 
    prints confirmed (yellow or green) letters 
    prints gray letters 
    loops through until all guesses are used or until the right word is chosen 
    '''
    numGuesses = 0
    allClues = []
    secret = secret.lower()

    while numGuesses < 6:

        print("Known: " + known_word(allClues).upper())
        print("Green/Yellow Letters: " + str(yes_letters(allClues)))
        print("Grey Letters: " + str(no_letters(allClues)))

        userGuess = input("> ").lower()
        
        while (len(userGuess) != 5 or userGuess not in words):
            print("Not a word. Try again")
            userGuess = input("> ").lower()

        
        numGuesses += 1 
        userClues = check_word(secret, userGuess)
        allClues.append((userGuess, userClues))

        guessList = list(userGuess.upper())
        for guessTuples in allClues:
            for j in range(5):
                if guessTuples[1][j] == 'grey':
                    grey(guessTuples[0][j].upper())
                elif guessTuples[1][j] == 'yellow':
                    yellow(guessTuples[0][j].upper())
                else:
                    green(guessTuples[0][j].upper())
            print()

        
        if userGuess == secret:
            break
    
    print("Answer: " + secret.upper())




if __name__ == "__main__":
    randWord = words[random.randint(0, len(words))]
    game(randWord)
