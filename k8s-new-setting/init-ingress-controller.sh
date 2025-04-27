# https://www.f5.com/products/nginx/nginx-ingress-controller

# ingress-controller 설치
minikube addons enable ingress -p local-cluster
kubectl get pod -n ingress-nginx

# ingress 설정
kubectl apply -f ingress.yaml
kubectl describe ingress
kubectl get svc --all-namespaces