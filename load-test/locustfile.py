# File: load-test/locustfile.py
from locust import HttpUser, task, between

class NginxUser(HttpUser):
    wait_time = between(0.1, 0.5)

    @task(1)
    def hit_root(self):
        self.client.get("/")

    @task(2)
    def hit_ping(self):
        self.client.get("/ping")
