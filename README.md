---
categories: ["code-styled", "all-profile"]
---
# VirtualThreads
Springboot - Java 21 - Virtual Threads
### Objective
- Infrastructure with terraform
- Utilize Github Actions
- Demonstrate a Springboot application utilizing virtual threads

### Create an s3 bucket for terraform state
- You may choose to create an S3 bucket in the AWS console
- Alternately, if you have aws client configured, you may create the following way
````bash
> aws s3api create-bucket --bucket virtual-app-tfstate --region us-east-1
> aws s3api put-bucket-versioning --bucket virtual-app-tfstate --versioning-configuration Status=Enabled
> aws s3api put-bucket-encryption --bucket virtual-app-tfstate --server-side-encryption-configuration '{
    "Rules": [
        {
            "ApplyServerSideEncryptionByDefault": {
                "SSEAlgorithm": "AES256"
            }
        }
    ]
}'
````
- Then, configure your `backend.tf` with your bucket information
```bash
# backend.tf

terraform {
  backend "s3" {
    bucket  = "virtual-app-tfstate" # name of the s3 bucket you created
    key     = "production/terraform.tfstate"
    region  = "us-east-1" # change to your region
    encrypt = true
  }
}
````

### Configure Terraform variables
- Edit your `vairiables.tf`
  - `namespace`
  - `region`
  - `stage`
  - `name`
  
### Configure Terraform
- From the terraform directory, let's install the infrastructure
```bash
> terraform init
```

```bash
> terraform plan
```
```bash
> terraform apply
```
- You should see output:
```bash
alb_dns_name = "app-prod-virtualthreads-185414366.us-east-1.elb.amazonaws.com"
ecr_repository_name = "app-prod-virtualthreads"
github_actions_role_arn = "arn:aws:iam::020157571320:role/github_actions"
```
- Update `.github/workflows/buildAndDeploy.yaml` to reflect aws region and `github_actions_role_arn`:
```yaml
env:
  AWS_REGION: us-east-1 # Change to your region
  IAM_ROLE_ARN: arn:aws:iam::020157571320:role/github_actions # Change to github action role arn

```

- You have now accomplished the following
  - Configured remote state for your infrastructure using s3 backend
  - Created access for github actions to deploy the application
  - Github Actions scripts are located in `.github/workflows`