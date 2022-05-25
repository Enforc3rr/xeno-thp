# Order-Service (Xeno Take Home Project)

- This Application is just a simple Order placing application with Three main Entities :
  - User Entity 
    ```
    userID : Long
    name   : String
    email  : String
    address : String
      ```
  - Product Entity
    ```
    productID : Long
    productName     : String
    productCategory : String
    productPrice : String
      ```
  - Order Entity
    ```
    orderID : Long
    totalPrice : int
    userAssociated   : UserEntity
    productsAssociated : List<ProductsEntity> 
      ```
    
### EndPoints : 

- ##### Users (/api/v1/user)
  - /signup : For User Signup [POST]
    ```
    {
        "name":"some 1",
        "email":"some@gmail.com",
        "address":"Delhi"
    }
    ```
  - /:userID : Returns user Detail [GET]
  - /orderDetails/:userID : Returns all the order details of the user. [GET]
  - /updateUserDetails : To Update User Details [PUT]
  - /deleteUser/:userID : To Delete User [DELETE]

- ##### Product (/api/v1/product)
    - /add : To Add A Product [POST]
    ```
    {
      "productName":"name",
      "productCategory":"productCategory",
      "productPrice":20
    }
    ```
    - /:productID : Returns product detail. [GET]
  
- ##### Product (/api/v1/order)
    - / : To Place an order [POST]
    ```
    {
    "orderedBy":1, (userID)
    "products":[1,2] (array of product IDs)
    }
    ```
    - /:orderID : Returns order details.[GET]

