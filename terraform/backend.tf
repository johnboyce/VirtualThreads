# backend.tf

terraform {
  backend "s3" {
    bucket  = "virtual-app-tfstate" # name of the s3 bucket you created
    key     = "production/terraform.tfstate"
    region  = "us-east-1" # change to your region
    encrypt = true
  }
}