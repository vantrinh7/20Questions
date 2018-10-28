# 20 Questions Game

This program is a simple version of the 20Q (20 Questions) game invented by Robin Burgener in 1988. The game asks the player to think of a subject, asks twenty Yes/No questions and then guesses the identity of the subject. The game utilizes neural-network-based artificial intelligence to produce the answer and is able to improve over time by learning from its interactions with the player. 

In this simple version of the game, the program gives player a small list of options to start with, asks Yes/No questions and then presents a possible guess based on the information from player. There are two modes: restricted and unrestricted. In the restricted mode, the program's answer in the end is final:

![](misc/question.png) ![](misc/answer.png)

In the unrestricted mode, after the final answer, the program asks player whether this is the correct asnwer. If the player chooses No, the program then proceeds to ask for the player's answer, a question that detect the correct answer, and whether the answer to that question is Yes or No. All of this information is saved into the game for the next round, or the program "learns" from the player. 

![](misc/input1.png) ![](misc/input2.png)

## Tree structure represents a simple neural network 
Each question is a node in the tree, and the tree of questions represents a network of possible paths the program can traverse based on the answers of the player. QuestionTree.java defines a tree of questions (with methods to set and get the root). TreeNode.java defines a node in the tree (with methods to get and set data, get and set left and right children, and check whether a node has leaves or not). 

## xml file stores a potential arrangment of the tree
This program uses xml file

## 


## File Description


* GuessingGameController and Unrestri
