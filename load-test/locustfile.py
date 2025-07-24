# File: load-test/locustfile.py
from locust import HttpUser, task, between

class NginxUser(HttpUser):
    wait_time = between(0.1, 0.5)

    # @task(1)
    # def hit_root(self):
    #     self.client.get("/")


    @task(1)
    def hit_api_ping(self):
        # If your backend is secured, add auth here (see below)
        self.client.get("/api/ping")