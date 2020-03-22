## PID Namespace

* **Process Identifier(PID)**
    * Every process running in linux has one 


* **PID Namespace**
    * A set of unique numbers that identify a process.
    * Linux allows for the creation of many namespaces
    * Each Unique namespace can contain the same process ids
        * IE
            * **Namespace_1**
                * PID 1
                * PID 2 
                * PID 3
            * **Namespace_2**
                * PID 1
                * PID 2 
                * PID 3
    * Each Docker container has its own **unique** namespace 


### Environment Independence 
* Provides the freedom to configure software taking dependencies on sacarce system resources without regard for other co-located software with conficting requirements
* Common Conflicts:
    * 2 programs want to bind to the same network port
    * 2 programs use the same temp filename, and file locks are preventing that
    * 2 programs want to use diferent versionof a global library
    * 2 processes want to use the same PID file
    * A 2nd program modified an environment var that another program uses
    * Mupltiple processes competing for memory or CPU time