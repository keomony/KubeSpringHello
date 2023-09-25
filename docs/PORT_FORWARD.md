port forward to the application using deployment name and port.
9090 (exposed port) is the port of the application and 8080 is the port of the host machine.
6- kubectl port-forward deployment/kube-spring-hello-deployment 8081:9090
7- open browser and go to http://localhost:8081/

8081 is the port of the host machine ( local port )
9090 is the port of the application ( some remote port or vm )

when you run this command 
`kubectl port-forward deployment/kube-spring-hello-deployment 8081:9090`
you can access the application from your local machine using this url http://localhost:8081/

while this command is running, you can access the application from the above url.
```agsl
Forwarding from 127.0.0.1:8081 -> 9090
Forwarding from [::1]:8081 -> 9090
Handling connection for 8081
Handling connection for 8081
Handling connection for 8081
Handling connection for 8081
Handling connection for 8081
Handling connection for 8081
```

However, if you delete the pods/containers of the application in your remote vm (k8s in this case),
you will not be able to access the application from your local machine using the above url.

error message from the port 
```agsl
E0920 09:02:05.060053   43198 portforward.go:409] an error occurred forwarding 8081 -> 9090: error forwarding port 9090 to pod 299a0bdbbb4d583d96759e5750279fde7362d6475c42743444806f19b8a7db94, uid : Error: No such container: 299a0bdbbb4d583d96759e5750279fde7362d6475c42743444806f19b8a7db94
E0920 09:02:05.060616   43198 portforward.go:409] an error occurred forwarding 8081 -> 9090: error forwarding port 9090 to pod 299a0bdbbb4d583d96759e5750279fde7362d6475c42743444806f19b8a7db94, uid : Error: No such container: 299a0bdbbb4d583d96759e5750279fde7362d6475c42743444806f19b8a7db94
error: lost connection to pod
```