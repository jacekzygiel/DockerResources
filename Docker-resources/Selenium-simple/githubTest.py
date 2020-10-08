import unittest
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from time import sleep

class GoogleSearchTest(unittest.TestCase):

    def setUp(self):
        self.driver = webdriver.Remote(
                         command_executor='http://51.68.175.198:4444/wd/hub',
                         desired_capabilities={'browserName': 'chrome', 'javascriptEnabled': True})

    def test_search_in_python_org(self):
        driver = self.driver
        driver.maximize_window()
        driver.get("https://github.com")
        assert "GitHub" in driver.title
        elem = driver.find_element_by_name("q")
        elem.send_keys("sele")
        sleep(5)
        elem.send_keys("nium")
        elem.send_keys(Keys.RETURN)
        sleep(5)
        assert "No results found." not in driver.page_source

    def tearDown(self):
        self.driver.close()

if __name__ == "__main__":
    unittest.main()
