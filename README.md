# ROCK PAPER SCISSORS

A REST API for the "Rock Paper Scissors" game implemented in Java and built using Maven, the Spring Boot framework have been used.
It is a game that is played between two users, where each user can choose between "Rock", "Paper" or "Scissors".

- Rock beats Scissors
- Paper beats Rock
- Scissors beats Paper




ENDPOINTS (provided from the assignment description):

POST	/api/games
POST	/api/games/{id}/join
POST	/api/games/{id}/move
GET	/api/games/{id}




RUN:

Run it from the project folder which contains the pom.xml file.

1. $ mvn package

2. $ java -jar target/rock-paper-scissors-1.0-SNAPSHOT.jar




USAGE:

Using curl:

1. $ curl --header "Content-Type: application/json" --request POST --data '{"name":"Lisa"}' http://localhost:8080/api/games
Player 1 joined: Lisa Game ID is: efe78c6a-df6b-4922-b7cd-df92d30f7f54

- A new game is created and player 1 joined
- A Game ID is returned which is used to access the current game

2. $ curl --header "Content-Type: application/json" --request POST --data '{"name":"Pelle"}' http://localhost:8080/api/games/efe78c6a-df6b-4922-b7cd-df92d30f7f54/join
Player 2 joined: Pelle

3. $ curl --header "Content-Type: application/json" --request POST --data '{"name":"Lisa", "move": "SCISSORS"}' http://localhost:8080/api/games/efe78c6a-df6b-4922-b7cd-df92d30f7f54/move
Player 1: Lisa made a move: SCISSORS

4. $ curl --header "Content-Type: application/json" --request POST --data '{"name":"Pelle", "move": "ROCK"}' http://localhost:8080/api/games/efe78c6a-df6b-4922-b7cd-df92d30f7f54/move
Player 2: Pelle made a move ROCK

5. $ curl --header "Content-Type: application/json" --request GET http://localhost:8080/api/games/efe78c6a-df6b-4922-b7cd-df92d30f7f54
GameId: efe78c6a-df6b-4922-b7cd-df92d30f7f54
Game state: ENDED
Player 1: Lisa
Player 1 move: SCISSORS
Player 2: Pelle
Player 2 move: ROCK
RESULT: Player 1 - LOSE, Player 2 - WIN

- The game has ended and player 2 won
