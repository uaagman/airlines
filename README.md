# _Airlines_
##### This is the midterm project for WAA using JSF and REST service

###### The Rest services urls and descriptions are as:

1. For Airlines
    1. GET [http://localhost:8080/midTermProject/rs/airline]()
        * List of all Airlines in following Format
          ```
          output:
          [{
                "id": 2,
                "name": "SkyTeam"
            },
            {
                "id": 10,
                "name": "oneworld"
            }]
            ```
    2. GET [http://localhost:8080/midTermProject/rs/airline/{id}]()
        * Returns an Airline that matches the id
            ```
            eg: GET http://localhost:8080/midTermProject/rs/airline/2
            output: 
            {
                "id": 2,
                "name": "SkyTeam"
            }
            ```
    3. POST [http://localhost:8080/midTermProject/rs/airline/new]()
        * Creates new Airline
            ``` 
            eg: POST http://localhost:8080/midTermProject/rs/airline/new
            input: 
            {
            	"name":"abc"
            }
            output:
            {
                "id": 2252,
                "name": "abc"
            }
            ```
    4. DELETE [http://localhost:8080/midTermProject/rs/airline/delete/{id}]()
        * Deletes the Airline that matches the id
            ```
            eg: DELETE http://localhost:8080/midTermProject/rs/airline/delete/2252
            output:
            {
                "id": 2252,
                "name": "abc"
            }
            ```
    5. PUT [http://localhost:8080/midTermProject/rs/airline/update]()
        * Updates Airline
            ```
            eg: PUT http://localhost:8080/midTermProject/rs/airline/update
            input:
            {
                "id": 2252,
                "name": "abcd"
            }
            output:
            {
                "id": 2252,
                "name": "abcd"
            }
            ```
2. For Airplane
    1. GET [http://localhost:8080/midTermProject/rs/airplane]()
        * List of all Airplanes in following Format
          ```
          output:
          [{
               "capacity": 519,
               "id": 3,
               "model": "A380",
               "serialnr": "12345"
           },
           {
               "capacity": 416,
               "id": 7,
               "model": "747",
               "serialnr": "54321"
           }]
            ```
    2. GET [http://localhost:8080/midTermProject/rs/airplane/{id}]()
        * Returns an Airplane that matches the id
            ```
            eg: GET http://localhost:8080/midTermProject/rs/airplane/3
            output: 
            {
               "capacity": 519,
               "id": 3,
               "model": "A380",
               "serialnr": "12345"
           }
            ```
    3. GET [http://localhost:8080/midTermProject/rs/airplane/serial?serialNo={serialN}]()
        * Returns an Airplane that matches the serial number to serialN
            ```
            eg: GET http://localhost:8080/midTermProject/rs/airplane/serial?serialNo=12345
            output: 
            {
               "capacity": 519,
               "id": 3,
               "model": "A380",
               "serialnr": "12345"
           }
            ```
    4. GET [http://localhost:8080/midTermProject/rs/airplane/model?model={modelN}]()
        * Returns List of Airplane that matches the model to modelN
            ```
            eg: GET http://localhost:8080/midTermProject/rs/airplane/model?model=A380
            output: 
            [{
                    "capacity": 519,
                    "id": 3,
                    "model": "A380",
                    "serialnr": "12345"
                },
                {
                    "capacity": 519,
                    "id": 11,
                    "model": "A380",
                    "serialnr": "23451"
                }]
            ```
    5. POST [http://localhost:8080/midTermProject/rs/airplane/new]()
        * Creates new Airplane
            ``` 
            eg: POST http://localhost:8080/midTermProject/rs/airplane/new
            input: 
            {
                "capacity": 500,
                "model": "A381",
                "serialnr": "12000"
            }
            output:
            {
                "capacity": 500,
                "id": 2253,
                "model": "A381",
                "serialnr": "12000"
            }
            ```
    6. DELETE [http://localhost:8080/midTermProject/rs/airplane/delete/{id}]()
        * Deletes the Airplane that matches the id
            ```
            eg: DELETE http://localhost:8080/midTermProject/rs/airplane/delete/2253
            output:
            {
                "capacity": 500,
                "id": 2253,
                "model": "A381",
                "serialnr": "12000"
            }
            ```
    7. PUT [http://localhost:8080/midTermProject/rs/airplane/update]()
        * Updates Airplane
            ```
            eg: PUT http://localhost:8080/midTermProject/rs/airplane/update
            input:
            {
                "capacity": 501,
                "id": 2253,
                "model": "A381",
                "serialnr": "12001"
            }
            output:
            {
                "capacity": 501,
                "id": 2253,
                "model": "A381",
                "serialnr": "12001"
            }
            ```
            
3. For Airport
    1.  GET [http://localhost:8080/midTermProject/rs/airport]()
           * List of all Airports in following Format
             ```
             output:
             [{
                 "airportcode": "AMS",
                 "city": "Amsterdam",
                 "country": "The Netherlands",
                 "id": 4,
                 "name": "Schiphol"
             },
             {
                 "airportcode": "DTW",
                 "city": "Detroid",
                 "country": "USA",
                 "id": 5,
                 "name": "Detroid City"
             }]
             ```
   2. GET [http://localhost:8080/midTermProject/rs/airport/{id}]()
       * Returns an Airport that matches the id
           ```
           eg: GET http://localhost:8080/midTermProject/rs/airport/5
           output: 
           {
               "airportcode": "DTW",
               "city": "Detroid",
               "country": "USA",
               "id": 5,
               "name": "Detroid City"
           }
           ```
   3. GET [http://localhost:8080/midTermProject/rs/airport/code?code={codeN}]()
         * Returns an Airport that matches the airportcode as codeN
             ```
             eg: GET http://localhost:8080/midTermProject/rs/airport/code?code=DTW
             output: 
             {
                 "airportcode": "DTW",
                 "city": "Detroid",
                 "country": "USA",
                 "id": 5,
                 "name": "Detroid City"
             }
             ```
   4. GET [http://localhost:8080/midTermProject/rs/airport/name?name={aName}]()
        * Returns an Airport that matches the name as aName
            ```
            eg: GET http://localhost:8080/midTermProject/rs/airport/name?name=Detroid City
            output: 
            {
                "airportcode": "DTW",
                "city": "Detroid",
                "country": "USA",
                "id": 5,
                "name": "Detroid City"
            }
            ```
   5. POST [http://localhost:8080/midTermProject/rs/airport/new]()
       * Creates new Airport
           ``` 
           eg: POST http://localhost:8080/midTermProject/rs/airport/new
           input: 
           {
               "airportcode": "KTM",
               "city": "Kathmandu",
               "country": "NEP",
               "name": "Yeti"
           }
           output:
           {
               "airportcode": "KTM",
               "city": "Kathmandu",
               "country": "NEP",
               "id": 2301,
               "name": "Yeti"
           }
           ```
   6. PUT [http://localhost:8080/midTermProject/rs/airport/update]()
         * Updates Airport
             ```
             eg: PUT http://localhost:8080/midTermProject/rs/airline/update
             input:
             {
                "airportcode": "KTM",
                "city": "Kathmandu",
                "country": "NEP",
                "id": 2301,
                "name": "Yeti Airlines"
             }
             output:
             {
                "airportcode": "KTM",
                "city": "Kathmandu",
                "country": "NEP",
                "id": 2301,
                "name": "Yeti Airlines"
             }
             ```
   7. DELETE [http://localhost:8080/midTermProject/rs/airport/delete/{id}]()
       * Deletes the Airport that matches the id
           ```
           eg: DELETE http://localhost:8080/midTermProject/rs/airport/delete/2301
           output:
           {
              "airportcode": "KTM",
              "city": "Kathmandu",
              "country": "NEP",
              "id": 2301,
              "name": "Yeti Airlines"
          }
          ```
          
4. For Flight
    1.  GET [http://localhost:8080/midTermProject/rs/flight]()
           * List of all Flights in following Format
             ```
             output:
             [{
                 "airline": {
                     "id": 10,
                     "name": "oneworld"
                 },
                 "airplane": {
                     "capacity": 519,
                     "id": 11,
                     "model": "A380",
                     "serialnr": "23451"
                 },
                 "arrivalDate": "6/25/15",
                 "arrivalTime": "6:15 AM",
                 "departureDate": "8/5/09",
                 "departureTime": "10:30 PM",
                 "destination": {
                     "airportcode": "SYD",
                     "city": "Sydney",
                     "country": "Australia",
                     "id": 12,
                     "name": "Kingsford Smith"
                 },
                 "flightnr": "QF 102",
                 "id": 9,
                 "origin": {
                     "airportcode": "LAX",
                     "city": "Los Angeles",
                     "country": "USA",
                     "id": 13,
                     "name": "Los Angeles International"
                 }
             },
             {
                 "airline": {
                     "id": 10,
                     "name": "oneworld"
                 },
                 "airplane": {
                     "capacity": 416,
                     "id": 15,
                     "model": "747",
                     "serialnr": "43215"
                 },
                 "arrivalDate": "6/25/15",
                 "arrivalTime": "6:55 AM",
                 "departureDate": "8/6/09",
                 "departureTime": "9:55 PM",
                 "destination": {
                     "airportcode": "NRT",
                     "city": "Tokyo",
                     "country": "Japan",
                     "id": 8,
                     "name": "Narita International Airport"
                 },
                 "flightnr": "QF 21",
                 "id": 14,
                 "origin": {
                     "airportcode": "SYD",
                     "city": "Sydney",
                     "country": "Australia",
                     "id": 12,
                     "name": "Kingsford Smith"
                 }
             }]
             ```
   2. GET [http://localhost:8080/midTermProject/rs/flight/{id}]()
       * Returns a Flight that matches the id
           ```
           eg: GET http://localhost:8080/midTermProject/rs/flight/14
           output: 
           {
               "airline": {
                   "id": 10,
                   "name": "oneworld"
               },
               "airplane": {
                   "capacity": 416,
                   "id": 15,
                   "model": "747",
                   "serialnr": "43215"
               },
               "arrivalDate": "6/25/15",
               "arrivalTime": "6:55 AM",
               "departureDate": "8/6/09",
               "departureTime": "9:55 PM",
               "destination": {
                   "airportcode": "NRT",
                   "city": "Tokyo",
                   "country": "Japan",
                   "id": 8,
                   "name": "Narita International Airport"
               },
               "flightnr": "QF 21",
               "id": 14,
               "origin": {
                   "airportcode": "SYD",
                   "city": "Sydney",
                   "country": "Australia",
                   "id": 12,
                   "name": "Kingsford Smith"
               }
           }
           ```
   3. GET [http://localhost:8080/midTermProject/rs/flight/get?flightNo={flightN}]()
        * Returns list of Flights that has flight number as flightN
        ```
        eg: http://localhost:8080/midTermProject/rs/flight/get?flightNo=QF 21
        output:
        [{
             "airline": {
                 "id": 10,
                 "name": "oneworld"
             },
             "airplane": {
                 "capacity": 416,
                 "id": 15,
                 "model": "747",
                 "serialnr": "43215"
             },
             "arrivalDate": "6/25/15",
             "arrivalTime": "6:55 AM",
             "departureDate": "8/6/09",
             "departureTime": "9:55 PM",
             "destination": {
                 "airportcode": "NRT",
                 "city": "Tokyo",
                 "country": "Japan",
                 "id": 8,
                 "name": "Narita International Airport"
             },
             "flightnr": "QF 21",
             "id": 14,
             "origin": {
                 "airportcode": "SYD",
                 "city": "Sydney",
                 "country": "Australia",
                 "id": 12,
                 "name": "Kingsford Smith"
             }
        }]
        ```
   4. POST [http://localhost:8080/midTermProject/rs/flight/new]()
       * Creates new Flight
           ``` 
           eg: POST http://localhost:8080/midTermProject/rs/flight/new
           
           input: 
           {
               "airline": {
                   "id": 10,
                   "name": "oneworld"
               },
               "airplane": {
                   "capacity": 416,
                   "id": 15,
                   "model": "747",
                   "serialnr": "43215"
               },
               "arrivalDate": "6/25/17",
               "arrivalTime": "8:00 AM",
               "departureDate": "6/30/17",
               "departureTime": "6:30 PM",
               "destination": {
                   "airportcode": "KTM",
                   "city": "Kathmandu",
                   "country": "NEP",
                   "id": 2301,
                   "name": "Yeti Airlines"
               },
               "flightnr": "AS 23",
               "origin": {
                   "airportcode": "SYD",
                   "city": "Sydney",
                   "country": "Australia",
                   "id": 12,
                   "name": "Kingsford Smith"
               }
           }
           
           output:
           {
              "airline": {
                  "id": 10,
                  "name": "oneworld"
              },
              "airplane": {
                  "capacity": 416,
                  "id": 15,
                  "model": "747",
                  "serialnr": "43215"
              },
              "arrivalDate": "6/25/17",
              "arrivalTime": "8:00 AM",
              "departureDate": "6/30/17",
              "departureTime": "6:30 PM",
              "destination": {
                  "airportcode": "KTM",
                  "city": "Kathmandu",
                  "country": "NEP",
                  "id": 2301,
                  "name": "Yeti Airlines"
              },
              "flightnr": "AS 23",
              "id": 2394,
              "origin": {
                  "airportcode": "SYD",
                  "city": "Sydney",
                  "country": "Australia",
                  "id": 12,
                  "name": "Kingsford Smith"
              }
          }
           ```
   5. PUT [http://localhost:8080/midTermProject/rs/flight/update]()
         * Updates Flight
             ```
             eg: PUT http://localhost:8080/midTermProject/rs/flight/update
             input:
             {
                "airline": {
                    "id": 10,
                    "name": "oneworld"
                },
                "airplane": {
                    "capacity": 416,
                    "id": 15,
                    "model": "747",
                    "serialnr": "43215"
                },
                "arrivalDate": "6/26/17",
                "arrivalTime": "8:05 AM",
                "departureDate": "6/30/17",
                "departureTime": "6:30 PM",
                "destination": {
                    "airportcode": "KTM",
                    "city": "Kathmandu",
                    "country": "NEP",
                    "id": 2301,
                    "name": "Yeti Airlines"
                },
                "flightnr": "AS 234",
                "id": 2394,
                "origin": {
                    "airportcode": "SYD",
                    "city": "Sydney",
                    "country": "Australia",
                    "id": 12,
                    "name": "Kingsford Smith"
                }
            }
            
             output:
             {
                 "airline": {
                     "id": 10,
                     "name": "oneworld"
                 },
                 "airplane": {
                     "capacity": 416,
                     "id": 15,
                     "model": "747",
                     "serialnr": "43215"
                 },
                 "arrivalDate": "6/26/17",
                 "arrivalTime": "8:05 AM",
                 "departureDate": "6/30/17",
                 "departureTime": "6:30 PM",
                 "destination": {
                     "airportcode": "KTM",
                     "city": "Kathmandu",
                     "country": "NEP",
                     "id": 2301,
                     "name": "Yeti Airlines"
                 },
                 "flightnr": "AS 234",
                 "id": 2394,
                 "origin": {
                     "airportcode": "SYD",
                     "city": "Sydney",
                     "country": "Australia",
                     "id": 12,
                     "name": "Kingsford Smith"
                 }
             }
             ```
   6. DELETE [http://localhost:8080/midTermProject/rs/flight/delete/{id}]()
       * Deletes the Flight that matches the id
           ```
           eg: DELETE http://localhost:8080/midTermProject/rs/flight/delete/2394
           output:
           {
               "airline": {
                   "id": 10,
                   "name": "oneworld"
               },
               "airplane": {
                   "capacity": 416,
                   "id": 15,
                   "model": "747",
                   "serialnr": "43215"
               },
               "arrivalDate": "6/26/17",
               "arrivalTime": "8:05 AM",
               "departureDate": "6/30/17",
               "departureTime": "6:30 PM",
               "destination": {
                   "airportcode": "KTM",
                   "city": "Kathmandu",
                   "country": "NEP",
                   "id": 2301,
                   "name": "Yeti Airlines"
               },
               "flightnr": "AS 234",
               "id": 2394,
               "origin": {
                   "airportcode": "SYD",
                   "city": "Sydney",
                   "country": "Australia",
                   "id": 12,
                   "name": "Kingsford Smith"
               }
           }
          ```
---
###### For JSF pages for airline CRUD and flights list/filter
   [http://localhost:8080/midTermProject/]()