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


## How to add to the permissions of a service account 

### List of roles for a service account to push to a cloud run 
- Artifact Registry Repository Administrator
- Cloud Build Editor
- Cloud Run Admin
- Service Account User
- Service Usage Admin
- Storage Admin
- Artifact Registry Create-on-Push Writer

Once deployed, an endpoint is shown e.g. https://hello-world-54738136311.us-central1.run.app

https://hello-world-54738136311.us-central1.run.app | http://localhost:8080

https://hello-world-54738136311.us-central1.run.app/helloworld/blank | http://localhost:8080/helloworld/blank


It looks like the service account `cloud-run-deployment@***.iam.gserviceaccount.com` doesn't have the required permissions to enable the Google Cloud services you're trying to access, such as `cloud-run-deployment`, `cloudbuild`, and `containerregistry`. To resolve this issue, follow these steps:

1. **Grant permissions to the service account**:
   Ensure that the service account has the necessary roles assigned to enable and use the required services. You will likely need to assign roles like:
   - `roles/serviceusage.serviceUsageAdmin` (to enable services),
   - `roles/iam.serviceAccountUser` (to interact with service accounts),
   - `roles/storage.admin` (to use Cloud Storage and Container Registry),
   - `roles/cloudbuild.builds.editor` (to work with Cloud Build).

   You can grant these roles via the Google Cloud Console or using `gcloud`:

   ```bash
   gcloud projects add-iam-policy-binding [YOUR_PROJECT_ID] \
     --member "serviceAccount:cloud-run-deployment@***.iam.gserviceaccount.com" \
     --role "roles/serviceusage.serviceUsageAdmin"
   
   gcloud projects add-iam-policy-binding [YOUR_PROJECT_ID] \
     --member "serviceAccount:cloud-run-deployment@***.iam.gserviceaccount.com" \
     --role "roles/iam.serviceAccountUser"
   
   gcloud projects add-iam-policy-binding [YOUR_PROJECT_ID] \
     --member "serviceAccount:cloud-run-deployment@***.iam.gserviceaccount.com" \
     --role "roles/storage.admin"
   
   gcloud projects add-iam-policy-binding [YOUR_PROJECT_ID] \
     --member "serviceAccount:cloud-run-deployment@***.iam.gserviceaccount.com" \
     --role "roles/cloudbuild.builds.editor"
   ```

2. **Check for project permissions**:
   Ensure that the service account has the required permissions for the project itself, and that the project exists and is not archived or restricted.

3. **Enable the necessary services manually**:
   If you are still unable to enable the services, you can try enabling them manually through the Google Cloud Console:
   - Go to the [API & Services Dashboard](https://console.cloud.google.com/apis/dashboard) in your Google Cloud project.
   - Search for `Cloud Run`, `Cloud Build`, and `Container Registry`.
   - Enable these services if they are not already enabled.

4. **Ensure billing is enabled**:
   Make sure that billing is enabled for the project if required by any of these services.

Once you have verified and granted the required permissions, you should be able to enable the services successfully. Let me know if you need further assistance!
