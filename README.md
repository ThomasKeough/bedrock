# team bedrock
*week3project submission*

# Problem Domain

# Our Application
We would like to design an application that will allow us to play the Pokémon trading card game. This means that we will
need to develop several core features; these will form the backbone of the application and ultimately
be used to play the card game.

**Core Features:**
* Player Collection
  * Logs all the cards that a player has acquired.
* Deck Builder
  * Enables the player to build a deck using the cards that are in their collection.
* Gameplay
  * Create an instance of the card game. A loop will run for each player's turn. The game ends when a player wins, or 
    someone has forfeited.

Beyond the core features, we have some other ideas for functions that we think would be fun. For now, we will call these
the complementary features.

**Complementary Features:**
* Booster Packs
  * A tool for players to extend their card collection. In the real-life Pokémon card game, there are rules for the
    number of cards and the rarity of cards that can be included in a single booster pack: we will likely follow those 
    same rules
* Currency System
  * The inclusion of a currency system will enable a way to acquire booster packs. It can also be used to encourage
    players to win their games, through currency rewards.
* Experience System
  * We can implement an experience tracker to encourage players to keep playing the card game, even if they have trouble
    winning. Experience can be awarded on both losses and wins, with wins giving more experience than losses. Upon
    reaching certain thresholds of experience, players will "level up", and earn rewards. Rewards can be booster
    packs or pre-determined cards.

# API of Choice
The API we've chosen to work with is called [PokémonTCG](https://pokemontcg.io). It provides an extensive database of 
Pokémon cards which we can use to build player collections and decks, which can then be used to play the game. It is a 
REST API that uses the standard HTTP codes for queries. When queried, it will return Pokémon cards in JSON format.

## Link to Documentation &rarr; [PokémonTCG](https://docs.pokemontcg.io)

## Testing the API (Screenshot)

## Example Output

# Technical Problems
