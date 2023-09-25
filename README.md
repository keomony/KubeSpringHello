References:

1: Spring and Kubernetes: [Click here](https://spring.io/guides/gs/spring-boot-kubernetes/)

2: Spring and webApplication: [Click here](https://spring.io/guides/gs/spring-boot/)

3: Kubernetes deployment and service: [Click here](https://kubernetes.io/docs/concepts/workloads/controllers/deployment/)

4: Ingress: [Click here](https://kubernetes.io/docs/concepts/services-networking/ingress/)
[quick start](https://kubernetes.github.io/ingress-nginx/deploy/#quick-start)

5: namespace: [Click here](https://kubernetes.io/docs/concepts/overview/working-with-objects/namespaces/)
[example:](https://cloud.google.com/blog/products/containers-kubernetes/kubernetes-best-practices-organizing-with-namespaces)
we create a namespace then we create a deployment and service in that namespace.



Steps to run the application:
build an image
1- ./gradlew bootBuildImage
tag the image with a different version each time, 0.0.1-SNAPSHOT is your build version. 
You can change it in build.gradle file.
keomonykhun is your docker username.
kubespringhello:0.0.2 is your image name and version.
demo:0.0.1-SNAPSHOT is your application name and version.
2- docker tag demo:0.0.1-SNAPSHOT keomonykhun/kubespringhello:0.0.2
push the image to docker hub
3- docker push keomonykhun/kubespringhello:0.0.2
create a deployment and service in kubernetes
Make sure spec.containers.image is the same as the image you pushed to docker hub
4- kubectl apply -f kubeConfig/deploy.yml 
5- kubectl apply -f kubeConfig/service.yml
port forward to the application using deployment name and port. 
9090 (exposed port) is the port of the application and 8080 is the port of the host machine.
6- kubectl port-forward deployment/kube-spring-hello-deployment 8080:9090
7- open browser and go to http://localhost:8080/