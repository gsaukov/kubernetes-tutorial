## To run in minikube with local repo and local DNS.

1. Start kube `minikube start`
2. Set kube image repository so image will be visible to minikube: `eval $(minikube docker-env)`
3. Build image via `docker build -t kt-sym .` (it will be pushed to minikube's repo)
4. Make sure that `docker images` repository has kt-sym image 
5. Run `kubectl apply -f kt-sym-deployment.yaml`
6. Run `kubectl apply -f kt-sym-service.yaml`
7. Run `kubectl port-forward svc/kt-sym-service 8000:80` this will make service accessible from localhost. Or `minikube service kt-sym-service --url` 
8. Run `minikube addons enable ingress`
9. Run `kubectl apply -f kt-sym-ingress.yaml`
10. Run `kubectl get ingress` and get ADDRESS:

        NAME             CLASS   HOSTS        ADDRESS        PORTS   AGE
        kt-sym-ingress   nginx   kt-sym.com   192.168.49.2   80      113s

11. Add `192.168.49.2 kt-sym.com` to private/etc/hosts (mac location, requires sudo)


## Knative 
Follow tis steps to enhance your cluster:
https://knative.dev/docs/install/yaml-install/serving/install-serving-with-yaml/#prerequisites

kubectl get ksvc knative-echo-service --output=custom-columns=NAME:.metadata.name,URL:.status.url


Troubleshooting:
https://stackoverflow.com/questions/40144138/pull-a-local-image-to-run-a-pod-in-kubernetes
https://stackoverflow.com/questions/38979231/imagepullbackoff-local-repository-with-minikube
https://kubernetes.io/docs/tasks/access-application-cluster/ingress-minikube/



