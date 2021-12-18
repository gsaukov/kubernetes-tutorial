https://aws.amazon.com/blogs/compute/kubernetes-clusters-aws-kops/
https://kops.sigs.k8s.io/getting_started/aws/
https://stackoverflow.com/questions/55049641/kubernetes-kops-without-dns

Create user api user with API keys/CLI access only
AmazonEC2FullAccess
AmazonRoute53FullAccess
AmazonS3FullAccess
IAMFullAccess
AmazonVPCFullAccess


aws s3 mb s3://k8s-kops-bucket-736473
export KOPS_STATE_STORE=s3://k8s-kops-bucket-736473

kops create cluster --help | grep volume-size // use help to see more options and examples

kops create cluster mycluster-736473.k8s.local --zones us-east-1a --yes --state s3://k8s-kops-bucket-736473 \
--master-size=t3.micro \
--node-size=t3.micro \
--master-volume-size 10 \
--node-volume-size 10 \
--cloud aws

--api-loadbalancer-class network \ // i was unable to make it work.

//after cluster was created kops updated /Users/georgy.saukov/.kube with access data


kops create secret --name mycluster-736473.k8s.local sshpublickey admin -i ~/.ssh/id_rsa.pub
kops validate cluster --name mycluster-736473.k8s.local
kops get cluster mycluster-736473.k8s.local -o yaml

kops delete cluster --name=mycluster-736473.k8s.local --yes --state s3://k8s-kops-bucket-736473

kubectl create -f helloworld.yml
kubectl create -f helloworld-service.yml // will create new aws load balancer
http://a6835eede47934214a7e2329b90995a8-280e9302d349a4f4.elb.us-east-1.amazonaws.com/
http://a6835eede47934214a7e2329b90995a8-494249827.us-east-1.elb.amazonaws.com/

kops with fargate via kubelet - https://aws.amazon.com/blogs/opensource/aws-fargate-virtual-kubelet/
