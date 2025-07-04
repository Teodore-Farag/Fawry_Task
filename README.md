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

Also, Products number is subtracted when added to cart.
Case 1: adding items to the cart normally and the customer have balance

<img width="1680" alt="Screenshot 2025-07-04 at 10 32 34 PM" src="https://github.com/user-attachments/assets/dfa0c303-23b0-4b40-a007-4e06e273a6eb" />

case 2: customer have balance, and added 2 items one shippable and one is not

<img width="1680" alt="Screenshot 2025-07-04 at 10 34 18 PM" src="https://github.com/user-attachments/assets/b4f18667-8f5f-4324-a5f0-c94bcdea4066" />

case 3: customer has no enough balance
 
<img width="1680" alt="Screenshot 2025-07-04 at 10 35 41 PM" src="https://github.com/user-attachments/assets/d023db19-d521-4c13-a5cf-1fe0cc7208f4" />

Case 4: Shipping Cart is Empty

<img width="1680" alt="Screenshot 2025-07-04 at 10 36 48 PM" src="https://github.com/user-attachments/assets/d42f6599-55c8-4621-a7fc-5753777c5c31" />

Case 5: customer adding expired item

<img width="1680" alt="Screenshot 2025-07-04 at 10 37 48 PM" src="https://github.com/user-attachments/assets/908eb517-90f8-4e25-9655-ef437a4ff0ae" />

Case 6: Customer adding quantity less than in stock or out of Stock

<img width="1680" alt="Screenshot 2025-07-04 at 10 39 24 PM" src="https://github.com/user-attachments/assets/66a447ea-fbbc-4ffe-b6d7-7ea2d1a74469" />
<img width="1680" alt="Screenshot 2025-07-04 at 10 39 09 PM" src="https://github.com/user-attachments/assets/16156ef6-3a9d-4279-ad22-e57581445ddc" />

case 7: adding multiple items of the same product

<img width="1680" alt="Screenshot 2025-07-04 at 10 40 44 PM" src="https://github.com/user-attachments/assets/a3c32231-63b7-401d-9cca-9fe387d31b61" />

case 8: defining product with negative price

<img width="1680" alt="Screenshot 2025-07-04 at 10 41 58 PM" src="https://github.com/user-attachments/assets/04765edf-24e1-49ed-b73c-750fac80fa93" />

case 9: adding negative weight

<img width="1680" alt="Screenshot 2025-07-04 at 10 42 51 PM" src="https://github.com/user-attachments/assets/efaa1b1b-4c54-4e92-b7c5-7d3441239aca" />

case 10: adding multiple items of un shippable product
<img width="1680" alt="Screenshot 2025-07-04 at 10 44 42 PM" src="https://github.com/user-attachments/assets/665cb761-1cf4-4993-a368-d0c1fff19d0c" />









