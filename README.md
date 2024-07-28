# Info
- This is our rest application for getting data from the db that is populated by our blockexplorer which got made in go
- Supposely for remote development it is better to package our application and then create a docker image with it.. lets try it out
- To package the app
    ```
    mvn package
    ```
- Then we create a image from the docker directory inside the main
- docker build -f  src/main/docker/Dockerfile.jvm  -t pedrosilvamnchunks/quarkus-rest-hlf-network:latest .
- docker expose on port 8080 
- We should build the image with the ip of the db correct poiting to the db inside of the cluster.. trying to overide it with envs does not work
- Also, we should add the properties for remote development otherwise it will fail like:
```
quarkus.package.jar.type=mutable-jar 
quarkus.live-reload.password=12341234
quarkus.live-reload.url=http://CHP-SRVAIDA69.chuporto.min-saude.pt:30020
```
- After all setup we just need to run:
  ```
  mvn quarkus:remote-dev
  ```
- You cant do tests in remote.. we need to mock
# Notes
- It get simpler if we put labels on our components (ex: we want orderers and peers we put a label called type-component on them, that makes them easier to manage)