# A simple helloworld Spring Boot app

1. This is a simple Spring Boot API with some endpoints saying "hello world"
2. It exposes 2 endpoints
   1. GET /helloworld/sayhi which returns a non-json string.
   2. GET /helloworld/greet which returns a Json string.
3. It also demonstrates how to use Github actions for basic CI and CD activities.
4. It also makes an attempt to push code to a docker registry
5. It also shows how to make the application run in a Kubernetes cluster.
6. maven commands 
   ```maven
      mvn clean build //clean and building 
      mvn test 
      mvn spring-boot:run
   ```
# How to release Apps to a VM 

1. Create a mini Spring Boot application using Spring Initializr. (https://start.spring.io/)
2. Add a "Hello, World!" REST controller.
3. Run the application locally to test it.
4. Initialize a Git repository and commit the code.
5. Push the repository to GitHub.
6. Create a project on Google Cloud Platform (GCP).
7. Enable the Compute Engine API.
8. Create a virtual machine (VM) instance on GCP.
9. SSH into the VM and install Java and Git.
10. Generate an SSH key pair for secure access to the VM.
11. Configure SSH access by adding the public key to the VM. (in the ~/.ssh/authorized_keys)
12. Create a GitHub Actions workflow for CI/CD.
13. Build the Spring Boot app in the GitHub Actions workflow.
14. Deploy the Spring Boot app JAR file to the GCP VM using GitHub Actions.
15. Run the Spring Boot app on the GCP VM.
16. Test the deployed application by accessing it via the VM's public IP.
17. Enable the firewall on GCP to allow traffic on the port the app listens on
18. Set up NGINX as a reverse proxy (optional).
19. Monitor the application (optional).

# How to release Apps to Cloud run 

1. Create a Spring Boot application using Spring Initializr.
2. Add a "Hello, World!" REST controller.
3. Run the application locally to test it.
4. Initialize a Git repository and commit the code.
5. Push the repository to GitHub.
6. Create a project on Google Cloud Platform (GCP).
7. Enable the **Cloud Run API** or **Cloud Functions API** on GCP.
8. Install and configure the **Google Cloud CLI** locally.
9. Write a `Dockerfile` to containerize the Spring Boot app (for Cloud Run).
10. Build the container image locally and test it.
11. Push the container image to Google Container Registry (GCR) or Artifact Registry.
12. Create a GitHub Actions workflow for CI/CD.
13. Build the Spring Boot app JAR file in the GitHub Actions workflow.
14. Containerize the application in GitHub Actions (if deploying to Cloud Run).
15. Push the container image to GCR via GitHub Actions.
16. Deploy the containerized app to Cloud Run using GitHub Actions.
17. (Alternatively) Deploy the app as a function to Cloud Functions (without Docker).
18. Test the deployed application using the URL provided by Cloud Run or Cloud Functions.
19. Configure a custom domain and HTTPS for the Cloud Run or Cloud Functions endpoint (optional).
20. Monitor the application using GCP's monitoring tools (optional).  