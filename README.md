Fawry Quantum Internship Challenge – Shopping Cart System

Overview

This Java-based console application simulates a basic shopping cart system for an e-commerce platform. It supports products with different behaviors (expirable, shippable, Non-expirable, Non-shipable), allows customers to add items to a cart with quantity limits, and performs checkout with shipping and payment processing.

Code Explaination

First, I used Strategy Design Pattern to handle the cases of Expiry and Shippable. I created 2 Interfaces, one for the Expiry and one for the Shipping. Then I created 2 classes for each interface to handle all cases for the expiry and shippable.
Each class implements the methods present in the interface and adjust them accordingly to the state also i have added additional attributes.

Second, I have defined a new Object called Tuple that takes a product and a quantity, to make it easier and match the example output provided. This class implements an interface called ShippableItem, which containes only String getName() and double getWeight() methods which were mentioned. In the tuple class i added some attributes and functions that help me construct an output similar to the one provided.

Third, Customers which have attributes name, id, email, and most importantly balance. Also i constructed the getters, setters and constructors for this class. 

Fourth, Products, which have name, price, quantity, expiry strategy, and shipping strategy. Also, have getters, setters, and constructors. these strategy help me construct the product as i wish.

Fifth, Cart, containing attributes like customers_id List<Tuples>(which containes products and quantities in the cart),total_price(Cart), weight, and weight unit. This class also have the basic getters,setters, and constructors.
In addition, It have add, remove, and getFullCartWeight.

Sixth, shippingService, whch conatines 2 methods one for printing the quantity, product_name, weight, and weight unit. The second method is responsible for handling all the cases for the weight and weight unit. For example, if there is 2 items of a product each 600g it calculates them to be 1.2Kg.

Lastly, The main class, the main class containes the initialization of the dummy data, the Checkout method, and a shipment price calculater. The checkout containes the customer balance at the beginning, checks if the cart is empty, checks for expired products, sorts the shippable products, shows cart weight, shows each product total weight with units, Checkout reciept with each product price, shipping amount, and total amount.

Adding an out of stock product is handeled in the cart add method.

Weight unit is manged by calculating all weights in grams and then convert it to its suitable range. Weights more than 999g is converted to Kg and weights more than 999 Kg is converted to Ton.

Also i have managed to combine multiple instances of one object in cart to merge and increase the quantity.

The 3 classes of weights are "g" for grams, "Kg" for kilograms. and "Ton" for Ton.

I handeled also inputs with numbers less than zero in quanities, weights, and prices.

The shipping amount is calculated as follows 15 for orders less than 1 Kg, 30 for every Kilogram rounded , and 10000 for every ton rounded.
