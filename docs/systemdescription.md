# System Description

Smart Greenhouse is a system with four main components:

+ Sensor mote: there will be a mote that will gather ambience data using a temperature and humidity sensor, a soil moisture sensor, a PH sensor and a light sensor. This mote will also be equipped with a LoRaWan antenna to transmit the data to the closest gateway. 
+ Smart irrigation system: there will be a smart irrigation system that receives Rx commands through LoRaWan. Depending on the command, it will be turned on or off.
+ Smart light system: In case sunlight is scarce during light hours, the greenhouse will be equipped with smart lights, able to receive Rx commands through LoRaWan. Depending on the command, lights will be turned on or off.
+ Mobile app: The farmer will be able to visualize telemetry data through a user-friendly mobile application, 

Due to hardware limitations, some of the sensors will be real, whereas others will be simulated using Node-Red. The smart irrigation system will also be simulated.
Physical sensors (soil moisture, light, and temperature/humidity) will be connected to a B-L072Z-LRWAN1 ARM platform using a protoboard. Smart light will be simulated using an RGB led also connected to the ARM platform.

![projectDescription](https://github.com/mariasanzs/smart-greenhouse-app/blob/main/docs/img/projectDescription.png)


