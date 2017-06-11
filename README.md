# _Airlines_
##### This is the midterm project for WAA using JSF and REST service

###### The Rest services urls and descriptions are as:

1. For Airlines
    1. GET [http://localhost:8080/midTermProject/rs/airline]()
        * List of all airlines in following Format
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
    4. DELETE [http://localhost:8080/midTermProject/rs/airline/delete/{id}]()
        * Deletes the airline that matches the id
            ```
            eg: DELETE http://localhost:8080/midTermProject/rs/airline/delete/2252
            output:
            {
                "id": 2252,
                "name": "abc"
            }
    5. PUT [http://localhost:8080/midTermProject/rs/airline/update]()
        * Updates airline
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
        * Creates new Airline
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
    5. DELETE [http://localhost:8080/midTermProject/rs/airplane/delete/{id}]()
        * Deletes the airline that matches the id
            ```
            eg: DELETE http://localhost:8080/midTermProject/rs/airplane/delete/2253
            output:
            {
                "capacity": 500,
                "id": 2253,
                "model": "A381",
                "serialnr": "12000"
            }
    6. PUT [http://localhost:8080/midTermProject/rs/airplane/update]()
        * Updates airline
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