
Scenario: Looking up the definition of 'apple'
Given the user is on the Wikionary home page
When the user looks up the definition of the word 'apple'
Then they should see the definition 'A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates.'

Scenario: Looking up the definition of 'pears'
Given the user is on the Wikionary home page
When the user looks up the definition of the word '<word>'
Then they should see the definition '1An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.'

Scenario: User can log in to the account
Given the user is on the login page
When i use login 'Student' and password '909090'
Then authentication is successful and i see Avatar on Home Page

Examples:
| word |
| pear        |
| pear1       |