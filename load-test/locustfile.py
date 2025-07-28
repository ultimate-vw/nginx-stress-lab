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

    # For third party call with token
    #
    #     class ThirdPartyUser(HttpUser):
    # # override the default host (instead of http://nginx)
    # host = "https://api.thirdparty.com"
    #
    # wait_time = between(1, 2)
    #
    # @task
    # def fetch_resource(self):
    #     # hits https://api.thirdparty.com/v1/resource
    #     self.client.get("/v1/resource")
    #
    # @task
    # def post_data(self):
    #     # hits https://api.thirdparty.com/v1/submit
    #     self.client.post(
    #         "/v1/submit",
    #         json={"foo":"bar"},
    #         headers={"Authorization":"Bearer YOUR_TOKEN"}
    #     )