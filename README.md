# SabaccAPCSA
 Sabacc APCSA Final Project

    By: Dylan W, Chris M, Jack Z, Jj D
    
## Rules

### Setup

 1. Sabacc is played with a 72-card deck, four suits numbered 1-15, and 8 face cards that have special negative values
 2. At the beginning of a game users input number of players and player names
 3. Each player is dealt 2 cards, and starts with a balance of 200 credits

### Play

1. Each turn starts with a Betting phase where players can see their hand and must place a bet that is equal to or greater than the minimum bet
2. Every time a player bets, the minimum bet is raised to whatever amount of credits they bet
3. After Betting, a player can choose to either hit, fold, or check
4. **Hit:** Draw a card and add it to your hand, ending your turn
5. **Fold:** Concede the round for yourself, not being able to play until the next round but also not having to continue to bet
6. **Check:** Ends the round, totals each player's hand, and declares a winner
7. After player decides action they are warned to have the next user sit down so that players don't see each other's hands
8. Winner is declared and the money in the pot is transfered to their balance
9. Pot is refilled with a small initial sum and players are asked if they wantto play another round or quit

## Known Bugs

1. The bot player created in singleplayer mode will occasionally sieze control of the player's turn and create an infinite loop

## Future Plans

#### (cause this is actually a pretty cool game that doesn't have a digital version so I might keep working on it over summer maybe)
1. Update graphics to use Swing instead of AWT to allow it to work with Chris's keylisteners and UI
2. Make the bot player's AI smarter and more adaptive
3. allow oppurtunity to add and remove players between rounds
4. Allow the option to create and load save files
5. Online capabilities
