### Запуск minikube, создание namespace и включение ingress

    minikube start --vm-driver=kvm2

    kubectl create namespace demo-app

    kubectl config set-context --current --namespace=demo-app

    minikube addons enable ingress

так же прописать ip и arch.homework в файл hosts 

    minikube ip - узнать айпишник миникуба

### Установка postgresql из helm

    helm repo add bitnami https://charts.bitnami.com/bitnami
    helm repo update
    helm install --namespace=demo-app --values=./values/postgres-values.yaml postgres bitnami/postgresql

### Запуск приложения 

    helm install demo-app ./helm/demo-app