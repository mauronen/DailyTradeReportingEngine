Tech test - Daily Trade Reporting Engine – Analysis and Design

A. User needs

Customer needs to produce a daily report that must show following data:
1)	Amount in USD settled incoming everyday
2)	Amount in USD settled outgoing everyday
3)	Ranking of entities based on incoming and outgoing amount.

B. Functional requirements
1)	A work week starts Monday and ends Friday, unless the currency of the trade is AED or SAR, where the work week starts Sunday and ends Thursday. No other holidays to be taken into account. 
2)	A trade can only be settled on a working day. 
3)	If an instructed settlement date falls on a weekend, then the settlement date should be changed to the next working day. 
4)	USD amount of a trade = Price per unit * Units * Agreed Fx 

C. Non Functional Requirements
1)	No database or UI is required 
2)	You can assume the code will only ever be executed in a single threaded environment 
3)	Minimize the number of external jar dependencies your code has. We would expect a maximum of one or two would be required. 
4)	All data to be in memory. 
5)	Output format to be plain text, printed out to the console 

D. Glossary of Terms
1) Instruction: An instruction to buy or sell
2) Entity: A financial entity whose shares are to be bought or sold
3) Instruction Date: Date on which the instruction was sent to JP Morgan by various clients
4) Settlement Date: The date on which the client wished for the instruction to be settled with respect to Instruction Date
5) Buy/Sell flag:
    5a) B – Buy – outgoing
    5b) S – Sell – incomin
6) Agreed Fx is the foreign exchange rate with respect to USD that was agreed
7) Units: Number of shares to be bought or sold

E. Solution

I’ve designed a solution based on Java platform that requires a Java class with main() method that can be directly launched
to produce report. I’ve added a Junit class that can be launched to test the execution before to put the project in 
a production environment.
According to Non Functional Requirement 1) I’ve designed an utility class, called com.jpmorgan.dailytradereporting.utilities.TradesListBuilder 
that allow to build and send sample data, so to test whole project.

Attached to solution there are two
