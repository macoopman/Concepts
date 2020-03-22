## Create Detached and Interactive Containers

### Detached 
```bash
    docker run  --detach \              # run detached
                --name web \            # name of container
                nginx:latest            # docker image
```
* **--detach**  or  **-d**
    * Start program in background (not interactive)
    * aka. daemon or service

### Interactive
```bash
    docker run  --interactive \
                --tty \
                --link web:web \
                --name web_test \
                busybox:1.20 /bin/sh

```

* **--interactive** or **-i**
    * Binding parts of the terminal to the input or output of a running container
* **--tty** or **-t**
    * Allocate a virtual terminal for the container 


## List Containers on System
```bash
    docker ps
    # or
    docker container ls
```

## View Container Logs
```bash
    docker logs {container_name}
```
* Any thing the container writes to STDIN or STDOUT is shown in the logs 

**Follow**
    * By default the logs will only display what has already happened.
    * To keep logs open to seen them in real time use:

        *  **--follow** or **--f**
    



## Stop and Restart Containers
### Restart Container
```bash
    docker restart {container_name}
```
### Stopping Containers
```bash
    docker stop {container_name}
```


## Reattach a terminal to a container



## Detach from an Attached Container

## Renaming Container
```bash
    docker rename {new_name} {old_name}
```

## Creating a Container
* **Create** a container without starting it
* After creating the unique id will be returned
```bash
    docker create {image_name} {flags...}
```
### Using Bash to Store Container Id
```bash
    CID=${docker create nginx:latest}
    echo $CID 
```
