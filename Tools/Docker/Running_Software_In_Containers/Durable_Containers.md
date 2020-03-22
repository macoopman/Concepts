## Auto Restarting Containers

### **--restart** Flag
    * Set at container creation/run
* **backoff strategy**
    * Detemins the amount of time that should pass between successive restart attemps.

***Options***
* Never
* Attempt to restart when a failure is detected
* Attempt for some predetermined time to restart when a failue is detected
* Always restart the container regardless of the condition 
    ```bash
    docker run -d -name backoff --restart always
    ```

## PID 1 and init Systems

* An **init system** is a program that is used to launch and maintain the state of other programs. 
    * An proccess with the **PID 1** is treated like an init process by linux
    * What it does:
        * Starts other processes
        * restarts processes in the event of failure
        * transforms and fowards signals sent by OS
        * prevents resouce leaks 
    * Popular System
        * runit
        * Yelp/dumb-init
        * tini
        * supervisord
        * tianson/gosu

* Start Up Script
    * Common alt to init system
    * Uses: **entrypoint** to run a setup script
