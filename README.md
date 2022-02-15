![logo](https://github.com/mariasanzs/smart-greenhouse-app/blob/main/docs/img/greenhouse.png)
# 🌿🌱 SmartGreenhouse 🌱🌿
### 🍅 Sustainable management of Tomato🍅
Project developed for the Architectures and Service Platforms subject (Master in Science in Internet of Things)

## What problem are we trying to resolve? 🤔
Sustainable development in crop processing is a topical issue that significantly influences the economics of the sector, having achieved great importance in recent years due to environmental awareness in society.

The use of new technologies brings a new opportunity and perspective to this challenge, helping to facilitate the task and achieve cost savings in crop production and maintenance.

In this way, this project aims to develop an intelligent system that contributes to sustainable tomato agriculture, in order to create quality and eco-friendly products avoiding unnecessary expenses and with optimal costs, including water waste, which is very important, especially in arid areas, and can be solved with smart irrigation.

## Project Description 📄
Smart Greenhouse is a system with four main components:
* Sensor mote
* Smart irrigation system
* Smart light system
* Mobile app

You can see the full description [here](https://github.com/mariasanzs/smart-greenhouse-app/blob/main/docs/systemdescription.md)

Also, you can access to the StoryBoard of the system described [here](https://github.com/mariasanzs/smart-greenhouse-app/blob/main/docs/img/storyboard.png)

## Analysis of Requirements ☑️

You can see all the system requirements (functional and not functional) that describes, defines and specificates all the characteristics of our development [here](https://github.com/mariasanzs/smart-greenhouse-app/blob/main/docs/modellingAnalysis.md)

## Architecture

In the following picture the elements that take part on the system as well as the communications technologies used between them can be seen:

![architecture](https://github.com/mariasanzs/smart-greenhouse-app/blob/main/docs/img/architecture.png)


#### Node-red. It has been used to simulate sensors such as pH and temperature and humidity sensors, and actuators like the irrigation system and the artificial lamp. It is communicated with Thingsboard through MQTT so sensor’s values can be sent and actuators status can be received and updated.

The code of the Node-red flow is available [here](https://github.com/mariasanzs/smart-greenhouse-app/blob/main/node-red_flow.json)

#### Embedded platform. It has been utilized to acquire measures from the soil moisture and light sensors. The platform is connected to ResIOT.

The code for the embedded platform is available [here](https://github.com/mariasanzs/smart-greenhouse-app/tree/main/keilproject)

#### ResIOT. It has been employed to retrieve real values from the platform and send them to Thingsboard.

The Lua Code is available [here](https://github.com/mariasanzs/smart-greenhouse-app/blob/main/luacode.txt)

#### Thingsboard. It has been used to monitor and control the system since it allows device management, data collection, processing and visualization through a dashboard.

Part of the code is available [here](https://github.com/mariasanzs/smart-greenhouse-app/tree/main/ThingsBoard)

#### Smart Greenhouse APP. It has been employed to inform the farmer about the measures from the sensors, so he can be aware of the greenhouse status; to show the actuators situation, indicating if they have been activated; and to notify the farmer if any sensor value has exceeded the fixed limits. In addition, the farmer could see the weekly averages related to each sensor.

The code is available [here](https://github.com/mariasanzs/smart-greenhouse-app/tree/main/app)

## Documentation 📄📄
You can see the full documentation [here](https://drive.google.com/file/d/1iTsLth1kTUGn-N5L1hfDHyeoAUmlOE6Q/view?usp=sharing)

## Presentation 🖥️
You can see the full presentation [here](https://www.canva.com/design/DAE2eYOXRpI/ODA3DVH978nal-W1eKx4LA/view?utm_content=DAE2eYOXRpI&utm_campaign=designshare&utm_medium=link&utm_source=publishsharelink)

### Authors 🖋️👩🏻‍💻👨🏻‍💻
Carlos Clemente Martín | María Martín Peral | María Sanz Sánchez | Paulo Seoane Davila


