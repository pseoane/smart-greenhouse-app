# Modelling Analysis of Requirements
## 4.1 Requirements

The following section describes, defines and specificates all the characteristics that are necessary to the development of the system, dividing these requirements in two groups, functional and non functional.

### 4.1.1 Functional requirements
+ FR01: There must be a sensing mote that measures
	+ FR01.1: Ambient humidity. From 0 to 100 %.
	+ FR01.2: Soil moisture. From 0 to 100 %.
	+ FR01.3: Ambient temperature. In ºC.
	+ FR01.4: Ambient light. From 0 to 100%.
	+ FR01.5: Soil PH. From 1 to 14.
+ FR02: All gathered data must be transferred using LoRaWan from the sensing mote to the greenhouse gateway.
+ FR03: All gathered data must be transferred from the gateway to the Thingsboard platform.
+ FR04: Processed information must be displayed in a mobile user interface.
+ FR05: The system must display an alarm if at least one of the following conditions is matched to ensure good crop quality
	+ FR05.1: Temperature below 20ºC.
	+ FR05.2: Temperature above 30ºC.
	+ FR05.3: Humidity below 60%.
	+ FR05.4: Humidity above 80%.
	+ FR05.5: Soil Ph below 6.0.
	+ FR05.6: Soil Ph above 6.8.
	+ FR05.7: Soil moisture below 70%.
	+ FR05.8: Soil moisture above 75%.
	+ FR05.9: Light is below 70% from 8:30 to 20:30 (approximate light hours in spring).
+ FR06: The system should automatically turn on irrigation when soil moisture goes below 70%.
+ FR07: The system should automatically turn off irrigation when soil moisture goes above 75%.
+ FR08: The system should automatically turn on artificial light when natural light goes below 70% from 8:30 to 20:30. In other cases, artificial light must be off.
+ FR09: The system should compute weekly average values from all the sensors listed above and display them in an interactive dashboard.
+ FR10: The system should consider the amount of time the actuators are triggered per week to calculate the total cost of using them and show this price in a dashboard.

### 4.1.2 Non-functional requirements
+ NFR 01 Usability: The system will be available in English.
+ NFR 03 Quality: The system will offer a high-quality user experience, through intuitive and useful information.
+ NFR 04 User-friendliness: Efforts will be made to ensure that the system follows levels of appropriate difficulty, ensuring sufficient ease of use for the farmer.
+ NFR 05 Confidentiality: It will be guaranteed that the data provided by the user are purely confidential and exclusive.
+ NFR 06 Security: Security access to the system will be guaranteed using access credentials.
+ NFR 07 Availability: The system will be available 24 hours a day during the 365 days a year.

