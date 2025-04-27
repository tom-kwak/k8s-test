

# cluster 생성 및 초기화
minikube config set rootless true
minikube start --nodes 3 -p local-cluster --driver=podman --container-runtime=containerd
# enable ingress controller
# https://kubernetes.io/docs/tasks/access-application-cluster/ingress-minikube/kubectl get pods -n ingress-nginx
minikube addons enable ingress -p local-cluster

# workder node label 설정
## Label vs Namespace 
## https://stackoverflow.com/questions/47441565/label-selector-vs-namespaces

kubectl label node local-cluster-m02 node-role.kubernetes.io/worker=
kubectl label node local-cluster-m03 node-role.kubernetes.io/worker=

## service-a node
## https://kubernetes.io/ko/docs/concepts/overview/working-with-objects/common-labels/
kubectl label node local-cluster-m02 app.kubernetes.io/name=service-a
kubectl label node local-cluster-m02 app.kubernetes.io/component=was

## service-b node
kubectl label node local-cluster-m03 app.kubernetes.io/name=service-b
kubectl label node local-cluster-m03 app.kubernetes.io/component=was
kubectl get nodes --show-labels

# namespace 설정
## cluster 논리적 분리 하지말자..
kubectl get namespace


minikube addons enable ingress






