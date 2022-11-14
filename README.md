**Inventory Management**:  
This application enables users to create item records and track inventory for those items.

**Tech** **Stack**:   
Spring boot as Web Framework  
Java as Programming Language  
Junit for unit testing  
Mockito for mocking   
Gradle for dependency management  

**Endpoints Exposed**  
**To create an item**   
To post an item to the database hit the endpoint and the endpoint consumes item properties in the request body as Json and produces item details in the response body with unique item id ad Json. The HTTP status code should 201 Created.
```
curl --location --request POST 'http://localhost:8081/inventory_management/v1/item' \
--header 'Content-Type: application/json' \
--data-raw '{
"description": "HB Pencil",
"brand": "HB",
"cost": 2,
"package_quantity": 12
}'
```    
**To get an item**  
To get an item from the database hit the endpoint given below with a proper item id. The endpoint produces item details as Json in the response body and HttP status code as 200 OK.
```
curl --location --request GET 'http://localhost:8081/inventory_management/v1/id/3'
```  
**To update an item**  
To update an item in the database hit the endpoint with a proper item id and this endpoint consumes item details in the request body as Json and produces updated item details in the response body as Json and HTTP status code is 201 Created.  
```
curl --location --request PUT 'http://localhost:8081/inventory_management/v1/id/1' \
--header 'Content-Type: application/json' \
--data-raw '{
"description": "Ink_Pen",
"brand": "HeroPen",
"cost": 3,
"package_quantity": 3
}'
```  
**To delete an item**  
To delete an item from the database hit the endpoint with a proper item id. When the item is deleted successfully, the HTTP status code will be 200 Ok.  
```
curl --location --request DELETE 'http://localhost:8081/inventory_management/v1/inventory/1'
```  
**To create an inventory**  
To create an inventory hit the endpoint point with proper item id and this endpoint consumes inventory details in the request body as Json and produces inventory details at the response body as Json and the HTTP status code is 201 Created.  
```
curl --location --request POST 'http://localhost:8081/inventory_management/v1/inventory_details/1' \
--header 'Content-Type: application/json' \
--data-raw '{
"on_hand": 3,
"on_arrival": 5,
"on_order": 6
}'  
```
**To get an inventory**   
To get an inventory hit the endpoint with proper item id and the endpoint produces inventory details at the response body as Json and HTTP status as 200 OK.  
```
curl --location --request GET 'http://localhost:8081/inventory_management/v1/inventory/2'
```  
**To update on hand inventory**  
To update the on hand inventory hit the endpoint with on hand increment with proper item id, it will automatically increment on hand inventory by 1 and produces the updated inventory details in the response body as Json and the HTTP status as 201 Created.  
```
curl --location --request PUT 'http://localhost:8081/inventory_management/v1/inventory/2/on_hand/increment'
```  
**To update on arrival inventory**   
To update the on arrival inventory hit the endpoint with on arrival increment with proper item id, it will automatically increment on arrival inventory by 1 and produces the updated inventory details in the response body as Json and the HTTP status as 201 Created.  
```
curl --location --request PUT 'http://localhost:8081/inventory_management/v1/inventory/2/on_arrival/increment'
```  
**To update on order inventory**   
To update the on order inventory hit the endpoint with on order increment with proper item id, it will automatically increment on order inventory by 1 and produces the updated inventory details in the response body as Json and the HTTP status as 201 Created.  
```
curl --location --request PUT 'http://localhost:8081/inventory_management/v1/inventory/800/on_order/increment'
```
  
**To update an inventory**   
To update an inventory in the database hit the endpoint with a proper item id and this endpoint consumes inventory details in the request body as Json and produces updated inventory details in the response body as Json and HTTP status code is 201 Created.
```
curl --location --request PUT 'http://localhost:8081/inventory_management/v1/inventory/2' \```
--header 'Content-Type: application/json' \
--data-raw '{
"on_hand": 5,
"on_arrival": 3,
"on_order": 3
}'
```  
**To delete an inventory**  
To delete an inventory from the database hit the endpoint with a proper item id. When the inventory is deleted successfully, the HTTP status code will be 200 Ok.  
```
curl --location --request DELETE 'http://localhost:8081/inventory_management/v1/inventory/2'
```    

**To Run This Application Locally**
1. Download this application   
2. Build this application using the command `./gradlew clean build`    
3. Run the jar from `/build/libs/inventorymanagement-0.0.1-SNAPSHOT.jar`








