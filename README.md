Code for LEGO_18's NXT Mindstorm Robot coded in Java for LejOS.

The robot uses simple behaviors which has different priorities to determine what the robot should do.
Behaviors:  
* DetectEnemySound - If the robot detects something with the ultrasonic sound sensor it will move towards it.  
* DetectLine - If the robot detects a large difference in the color of the ground it will move backwards for one second.  
* KillTheRobot - If the exit button is pressed the program will be terminated.  
* RobotForward - Behavior used for debugging, which makes the robot move forward  
* SpinRobot - Behavior with lowest priority, which makes the robot spin either to the left or right.  

## License

The MIT License (MIT)

Copyright (c) 2014 Felix Gustavsson

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.

