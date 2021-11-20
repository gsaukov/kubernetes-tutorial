Create user api user with API keys/CLI access only
AmazonEC2FullAccess
AmazonRoute53FullAccess
AmazonS3FullAccess
IAMFullAccess
AmazonVPCFullAccess

https://stackoverflow.com/questions/55049641/kubernetes-kops-without-dns
aws s3 mb s3://k8s-kops-bucket-736472
export KOPS_STATE_STORE=s3://k8s-kops-bucket-736472

kops create cluster mycluster-736472.k8s.local --zones us-east-1a --yes --state s3://k8s-kops-bucket-736472
kops create secret --name mycluster-736472.k8s.local sshpublickey admin -i ~/.ssh/id_rsa.pub
kops validate cluster
kops delete cluster --name=mycluster-736472.k8s.local --yes


AKIAUKK6JWYMUPZDX26V
RPLTjcPGm+FLwWGhsZrW51dVurxO8Ms2n0VXPbGb
