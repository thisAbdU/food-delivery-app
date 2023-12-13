[User]
-------------------
- UserID: int
- Name: string
- ContactInfo: string
- DeliveryAddress: string
-------------------
+ getUserID(): int
+ getName(): string
+ getContactInfo(): string
+ getDeliveryAddress(): string
+ setUserID(userID: int): void
+ setName(name: string): void
+ setContactInfo(contactInfo: string): void
+ setDeliveryAddress(deliveryAddress: string): void
-------------------

[Restaurant]
-------------------
- RestaurantID: int
- Name: string
- Cuisine: string
- Location: string
- Menu: List<Dish>
-------------------
+ getRestaurantID(): int
+ getName(): string
+ getCuisine(): string
+ getLocation(): string
+ getMenu(): List<Dish>
+ setRestaurantID(restaurantID: int): void
+ setName(name: string): void
+ setCuisine(cuisine: string): void
+ setLocation(location: string): void
+ setMenu(menu: List<Dish>): void
-------------------

[Dish]
-------------------
- DishID: int
- Name: string
- Description: string
- Price: double
- Image: string
-------------------
+ getDishID(): int
+ getName(): string
+ getDescription(): string
+ getPrice(): double
+ getImage(): string
+ setDishID(dishID: int): void
+ setName(name: string): void
+ setDescription(description: string): void
+ setPrice(price: double): void
+ setImage(image: string): void
-------------------

[Order]
-------------------
- OrderID: int
- UserID: int
- RestaurantID: int
- Dishes: List<Dish>
- OrderStatus: string
-------------------
+ getOrderID(): int
+ getUserID(): int
+ getRestaurantID(): int
+ getDishes(): List<Dish>
+ getOrderStatus(): string
+ setOrderID(orderID: int): void
+ setUserID(userID: int): void
+ setRestaurantID(restaurantID: int): void
+ setDishes(dishes: List<Dish>): void
+ setOrderStatus(orderStatus: string): void
-------------------

[Payment]
-------------------
- PaymentID: int
- OrderID: int
- Amount: double
- PaymentMethod: string
-------------------
+ getPaymentID(): int
+ getOrderID(): int
+ getAmount(): double
+ getPaymentMethod(): string
+ setPaymentID(paymentID: int): void
+ setOrderID(orderID: int): void
+ setAmount(amount: double): void
+ setPaymentMethod(paymentMethod: string): void
-------------------

[Review]
-------------------
- ReviewID: int
- UserID: int
- RestaurantID: int
- Rating: double
- Comment: string
-------------------
+ getReviewID(): int
+ getUserID(): int
+ getRestaurantID(): int
+ getRating(): double
+ getComment(): string
+ setReviewID(reviewID: int): void
+ setUserID(userID: int): void
+ setRestaurantID(restaurantID: int): void
+ setRating(rating: double): void
+ setComment(comment: string): void
-------------------

[Notification]
-------------------
- NotificationID: int
- UserID: int
- Message: string
- Timestamp: DateTime
-------------------
+ getNotificationID(): int
+ getUserID(): int
+ getMessage(): string
+ getTimestamp(): DateTime
+ setNotificationID(notificationID: int): void
+ setUserID(userID: int): void
+ setMessage(message: string): void
+ setTimestamp(timestamp: DateTime): void
-------------------
