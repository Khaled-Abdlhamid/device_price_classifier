# Device Price Classification System using Python and Spring Boot

### Project Objective:
Building Price Classification System (AI System).
Mainly the system will include two small projects:
- Python project: to predict the prices, allowing the sellers to classify the device's prices based on their characteristics
- SpringBoot project: Will contain a simple entity, and a few endpoints, to call the service from the Python project for some test cases, and store them.

## Important Note: This project is still under development, as i'm still facing some obstacles.



### Data Dictionary:
- battery_power - Total energy a battery can store in one time measured in mAh
- blue - Has Bluetooth or not **(Categorical)**
- clock_speed - The speed at which the microprocessor executes instructions
- dual_sim - Has dual sim support or not **(Categorical)**
- fc - Front Camera megapixels
- four_g - Has 4G or not **(Categorical)**
- int_memory - Internal Memory in Gigabytes
- m_dep - Mobile Depth in cm
- mobile_wt - Weight of mobile phone
- n_cores - Number of cores of the processor
- pc - Primary Camera megapixels
- px_height - Pixel Resolution Height
- px_width - Pixel Resolution Width
- ram - Random Access Memory in Megabytes
- sc_h - Screen Height of mobile in cm
- sc_w - Screen Width of mobile in cm
- talk_time - longest time that a single battery charge will last when you are
- three_g - Has 3G or not **(Categorical)**
- touch_screen - Has touch screen or not **(Categorical)**
- wifi - Has wifi or not **(Categorical)**
- price_range - This is the target variable with the value of: 0 (low cost), 1 (medium cost), 2 (high cost), 3 (very high cost)


### Project Structure: 
~~~
device-price-predictor/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── controller/
│   │   │   │   ├── DeviceController.java
│   │   │   │   ├── PredictionController.java
│   │   │   ├── model/
│   │   │   │   └── Device.java
│   │   │   ├── repository/
│   │   │   │   └── DeviceRepository.java
│   │   │   ├── service/
│   │   │   │   └── DeviceService.java
│   │   │   └── DemoApplication.java
│   └── resources/
│       ├── application.properties
├── flask/
│   ├── app.py
│   └── model.pkl
├── notebook/
│   └── price_classification.ipynb
└── README.md
~~~

### Module Description :
- DeviceContriller.java: This controller handles HTTP requests related to Device operations such as retrieving, adding, and deleting devices. it services as the API layer.
- PredictionController.java: This controller handles the prediction endpoint. It sends the device feauters to the Flask server to get the predicted price range and then updates the Device entity.
- Devices.java: This is the entity class representing the Device in the database. It includes fields for each attribute of the device and provides getter methods to access those fields.
- DeviceRepository.java:  This interface extends **JpaRepository** and provides CRUD operations for the Device entity. Spring Data JPA will automatically implement this interface at runtime. it services as the data access layer.
- DeviceService.java: This service class contains business logic related to Device operations. It interacts with the DeviceRepository. it acts as the service layer.
- app.py: The Flask server to get the specs of the device and return the prediction.
- model.pkl: The trained ML model.
- price_classification.ipynb: The notebook in which the ML model was developed.


### Deploying and Running: 
- Deploy the Flask server: cd to_the_flask_server app.py run
- Deploy the Spring Boot Application: cd to_device-price-predictor ./mvnw spring-boot:run
- Test the Endpoints: in this project i'm using Postman. 
	- POST http://localhost:8080/api/devices/ Content-Type: application/json
   		~~~
		{
		    "batteryPower": 1500,
		    "blue": true,
		    "clockSpeed": 2.0,
		    "dualSim": true,
		    "fc": 5,
		    "fourG": true,
		    "intMemory": 32,
		    "mDep": 0.5,
		    "mobileWt": 150,
		    "nCores": 4,
		    "pc": 12,
		    "pxHeight": 800,
		    "pxWidth": 600,
		    "ram": 3000,
		    "scH": 14,
		    "scW": 7,
		    "talkTime": 15,
		    "threeG": true,
		    "touchScreen": true,
		    "wifi": true
		}
		~~~
- Store the device data on any Database.
- Then to get the prediction for any device we access the device by id



**Please feel free to reach out. i could use some guidence and maybe recommendation for recources to build more intuition and better understanding, especially of the java/Spring Boot part.**
