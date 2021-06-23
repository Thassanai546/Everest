# Everest :game_die: :game_die: :game_die:
The dice game Everest aka Matterhorn in Java CLI.
In this game players race to strike off all values on their scorecard. An example of what this card may look like is shown below. Normally all you need to play is quick mental maths and good luck, however thanks to java all you need here is good luck.

## Rules

Each player in turn throws three dice and crosses off any values, using either row and in any order they wish according to the values thrown. A player may use combinations of dice values or the value of a single die, but each number rolled may only be used once. If you cannot remove any values from your scorecard then it automatically changes to the next players turn. A player wins when they get rid of all values on their scorecard or in this case, their scorecard contains only 0 values.

Let’s say we roll 3 dice and get 2, 3, 5
The values that we can remove are:
+ 2
+ 3
+ 5
+ 7 (5+2)
+ 8 (5+3)


### An example of output

![image](https://user-images.githubusercontent.com/72495327/123151834-c6f52880-d45b-11eb-8645-00490e74106b.png)

The player who crosses off all twenty-four numbers first, wins the game.


## Example of a scorecard
![Everest Scoresheet 1](https://user-images.githubusercontent.com/72495327/121529930-cb99f580-c9f4-11eb-98c7-90201735d858.png)
(Image source): https://www.patreon.com/posts/everest-45867444

