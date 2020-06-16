# Generated by Selenium IDE
import unittest
import time
import json
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.desired_capabilities import DesiredCapabilities

class TestT030616(unittest.TestCase):
  def setUp(self):
    self.driver = webdriver.Firefox()
    self.vars = {}
  
  def tearDown(self):
    self.driver.quit()
  
  def wait_for_window(self, timeout = 2):
    time.sleep(round(timeout / 1000))
    wh_now = self.driver.window_handles
    wh_then = self.vars["window_handles"]
    if len(wh_now) > len(wh_then):
      return set(wh_now).difference(set(wh_then)).pop()
  
  def test_t030616(self):
    self.driver.get("https://www.baidu.com/")
    self.driver.set_window_size(1550, 840)
    self.driver.find_element(By.ID, "kw").click()
    self.driver.find_element(By.ID, "kw").send_keys("秦牛正威")
    self.driver.find_element(By.ID, "kw").send_keys(Keys.ENTER)
    time.sleep(6)
    self.vars["window_handles"] = self.driver.window_handles
    self.driver.find_element(By.LINK_TEXT, "秦牛正威_百度百科").click()
    self.vars["win8984"] = self.wait_for_window(2000)
    self.driver.switch_to.window(self.vars["win8984"])
    self.driver.execute_script("window.scrollTo(0,600)")
    self.driver.execute_script("window.scrollTo(0,2090.39990234375)")
if __name__ == "__main__":
  unittest.main()