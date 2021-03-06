# Order-Service (Xeno Take Home Project)

- Application can be accessed from : `https://mysterious-gorge-62682.herokuapp.com/`   

- Docker Image Of Application Can be Pulled From : `https://hub.docker.com/layers/enforc3rr/dockerhub/orderservice/images/sha256:19dbb8af73370e40b8b87b9c5c5596df6dfde842562120e833d05617064e6cb5`


#### Note : 
I was not able to find any cloud hosting service which allowed me to host my docker container for free And services like AWS or GCP requires us to use non-RUPAY Debit cards which I currently don't have.
So , instead I have uploaded docker image of the project which can be pulled and tested out on local machine.


### About :
- Based On Spring Boot ( Java ) 
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

#### Working : 
![working](Working.gif)




