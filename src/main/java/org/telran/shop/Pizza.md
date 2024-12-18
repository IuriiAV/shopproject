Pizza project :

Part 1:
-------------
Entities :

Pizza(title, size, description) (Add, edit, delete, get pizza info)
Price list (pizza, price, discount for clients) (set price, change discount, delete price)
Pizzeria (title, city , address, work time) (add , edit, delete, add pizza to pizzeria)
Каждая пицерия предлагает свои варианты пиццы
User actions :  get all pizza, get all pizzerias, get pizza info

User (email, login, name , surname)

Part 2:
-------------------------------------
For User : 
Delivery Address(street , city, country, building) (add address for current user)
Wallet(amount, currency) (load money to wallet to current user)

Part 3:
-------------------------------------
CartItem(pizza, amount, price per one , price for all)
Cart(List CartItem) (add cartItem to cart)
Order (list cartItems, user, delivery address, state, sum, date time) 
(create order(created), list orders for current user, cancel order(cancelled))
(state : created, paid, ready, delivered, cancelled)

Payment(order, sum , date time)(pay order(paid))(учитывать деньги в кошельке)

Part 4:
------------------------------------
Scheduler Spring :
Процесс, который периодично будет получать список всех заказов в статусе 
оплачены и если с момента оплаты прошло больше чем 5 минут, переводить их 
в статус Ready

Брать все заказы в статусе готов и если с момента этого статуса прошло больше 5 минут,
переводить заказ в статус доставлен

Брать все заказы со статусом создан и если прошло больше чем 10 минут - отменять их


------------------------------------
1) Unit Tests, (Integration Test), Test for controllers
2) Handle exceptions
3) Validation
4) DTO
5) Swagger for rest(add description)
6) log info - create success, error - for exceptions
------------------------------------
