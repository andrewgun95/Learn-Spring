## Exercise 1 :

Requirements :
1. Create a simple transaction of item and each transaction can proceed into two different of payment.
2. Payment with card and with cash and both payment must have the same interface (with the same method signature).
3. Each transaction must track a payment status : unpaid (before payment initialize) and paid (after payment initialized).
4. In application configuration (.xml) will contain at least 5 bean definition: transaction service, transaction, item, card payment, and cash payment.
(a) Transaction service is a bean with stereotype as Service containing Transaction bean (have reference to Transaction bean) and listen on payment transaction.
(b) Transaction is a bean containing an item to process and status of payment (by default set to 'unpaid')
(c) Item is a bean containing the name, price and qty of item
(d) Card payment is a bean containing the nominal amount of payment, limit usage for single payment and logic to process payment item using credit card
(e) Cash payment is a bean containing the nominal amount of payment and logic to process payment item using cash
5. Transaction service bean should register as BeanPostProcessor and will listen every bean created in the application context. 
After Payment bean has been initialized set the transaction status into 'unpaid' and proceed the payment transaction.
6. On Payment bean must define scope as prototype to only instantiate payment when transaction occurs.
Payment should not create on the first time of application running, but only when there is a transaction.