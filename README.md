# Coffee Machine Refactoring

Coffee Machine is an awesome console application that from a few input parameters (drink type, 
amount of money, number of sugars, extra hot check) is capable to order a drink and show a cool 
message of the desired drink.

## How it works

### Command

```
./make run
```

### Input

|#      |Name       |Type   |Required   |Description    |Values                 |Default|
|---    |---        |---    |---        |---            |---                    |---    |
|1      |drinkType  |string |true       |Type of drink  |tea, coffee, chocolate |
|2      |money      |float  |true       |Money given    |                       |
|3      |sugars     |int    |false      |# of sugars    |0, 1, 2                |0      |
|4      |extraHot   |boolean|false      |Extra hot flag |true, false            |false  |

### List prices

|Drink      |Price  |
|---        |---    |
|Tea        |0.4    |
|Coffee     |0.5    |
|Chocolate  |0.6    |

### Validations

- If the drink type is not *tea*, *coffee* or *chocolate*, it shows the following message:

```
The drink type should be tea, coffee or chocolate.
```

- If the amount of money does not reach the price of the drink, a message as the following is displayed:

```
The tea costs 0.4.
```

- If the number of sugars is not between 0 and 2, it shows a message like this:

```
The number of sugars should be between 0 and 2.
```

- If the arguments are right, the displayed message is:

```
You have ordered a coffee!
```

- If the number of sugars is greater than 0, it includes the stick to the drink and it shows a message similar tot this:

```
You have ordered a coffee with 2 sugars (stick included).
```

-  If it adds extra hot option, the displayed message will be:

```
You have ordered a coffee extra hot with 2 sugars (stick included)
```

## What do you have to do?

We would like to have a reusable, maintainable and testable code, so we want to refactor following these principles:

* Clean code
* SOLID principles
* Decoupling
* Design patterns
* Error handling
* Unit testing
* TDD

You don't have to implement them all, but make the code better to be more comfortable with it.

Also, if there is time, our **Product Owner** has asked us to implement a new feature
so that we could know how much money we have earned with each type of drink.

Something like the following table would be great:

|Drink      |Money  |
|---        |---    |
|Tea        |15     |
|Coffee     |25.75  |
|Chocolate  |36     |

## Decisions made

1. This application has been refactored and modernized using **Java 11** and **Maven**
2. Legacy functionality is taken over and tested
3. Keeping the console application design approach, all the interaction is done via the terminal via a menu
4. **Spring Boot** and **Docker** have been added to multiply the amount of possible environments that can run this application.