# Energy-API

## Required environment to run this project
&#8594; OS must have installed java 8 or higher <br />

## Framework use to complete this task:
* Spring-boot to develop back end

##To run this project follow the below instructions:
1. Now execute the following command: <br />
   &#8594; ./mvnw clean && ./mvnw install && ./mvnw spring-boot:run
2. Make sure 8080 port not occupied by any other application.

## Two Rest-end endpoint description are as follows:
 First save end point: http://localhost:8080/api/v1/battery/create
 * Payload are as follows:
 [
  {
       "name": "Alkalin",      
       "postcode": 20,
       "watt": 4
   },
   {
      "name": "Alkalin",      
      "postcode": 10,
      "watt": 5
   }
]

 make post request using any rest client.

 Second get end point: 
 http://localhost:8080/api/v1/battery/list/{starting-postcode}/{end-postcode}

 Here starting-postcode and end-postcode are path parameter which define postcode range
 So for 1 to 100 postcode range the end-point will look like following:

http://localhost:8080/api/v1/battery/list/1/100

* Output will be like:
  {
    "data": 
    {
      "Average watt capacity": "6.5",
      "Total watt capacity": "9",
      "Returned battery list": [
         {
             "id": "548fcc87-362e-4a03-9bba-d46f2dc9bed5",
             "name": "Alkalin",
             "postcode": 20,
             "watt": 4
         },
         {
             "id": "52536742-0d43-4ecb-a84d-580fa323888c",
             "name": "Alkalin",
             "postcode": 10,
             "watt": 5
         }
      ]
    },
    "httpStatusCode": 200,
    "message": "Successfully get all batteries"
  }
