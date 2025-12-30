from wordle import check_word
from words import words
from display_utility import green, yellow, grey 
import random


def filter_word_list(words, clues):
    '''
    takes in the entire list of words and the words the user guessed, and their color lists when compared o the secret word 
    if the color lists between a word from the words list and a guessed word are equal to the one made with the guessed 
        word and secret, and this is true for ALL the words in clues, then that word is added to the return list 
    '''
    returnList = []
    for wordElm in words:
        wordElm = wordElm.lower()
        matches = True
        for pair in clues:
            if check_word(wordElm, pair[0].lower()) != pair[1]:
                ''' 
                if the color lists between wordElm (word from massive words list) and a previously guessed
                one are equal to the one formed with the previously guessed word and the secret, matchCount++
                '''
                matches = False
                break
            
        if matches:
            returnList.append(wordElm)
    
    return returnList
        
    

def easy_game(secret):
    '''
    takes in the secret and creates a playable game that shows the hints (colors) and max 5 words that 
        COULD be the secret word by calling filter_word_list 
    loops through until all 6 guesses are used or the correct word is picked 
    returns nothing '''
    numGuesses = 0
    allClues = []
    secret = secret.lower()

    while numGuesses < 6:
        userGuess = input("> ").lower()
        if(len(userGuess) != 5 or userGuess not in words):
            print("Not a word. Try again")
        else:
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

        
            filteredWords = filter_word_list(words, allClues)
            print(len(filteredWords),  "words possible:")
            
            random.shuffle(filteredWords)

            if len(filteredWords) < 5:
                for i in range(len(filteredWords)):
                    print(filteredWords[i])
            else: 
                for i in range(5):
                    print(filteredWords[i])

        if userGuess == secret:
            break
    
    print("Answer: " + secret.upper())


if __name__ == "__main__":
    randWord = words[random.randint(0, len(words))]
    easy_game(randWord)

   