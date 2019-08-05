# Smart foodie

Smart foodie gives its users a list of feasible recipes.
Application accepts user input for food ingredient to be included and to be excluded, also the maximum preparation time as filter, then it churns out List of dishes that can be prepared. With link to the recipe for that dish.

project plan
1. use a food recipe api - to get recipes for given ingredients
2. users to input - Ingredients to be included, Ingredients to be excluded and max preparation time 
3. software sends request to Yummly, reads the Yummly response and generates Smart Food response for a that request.


APIs -

*** GET /
Response - Dish search form


*** GET /recipesearch/*
Response - Recipe and Nutritional value for the specific Dish

*** POST /recipessearch
Response - List of Dishes that meet given input parameters

-------------------------------------------------------------












