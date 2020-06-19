from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.action_chains import ActionChains
import time
driver = webdriver.Firefox()
driver.get("https://news.baidu.com")
driver.implicitly_wait(3)
qqq = driver.find_element_by_xpath("//*[@id='s_btn_wr']")
ActionChains(driver).context_click(qqq).perform()
time.sleep(3)
ActionChains(driver).double_click(qqq).perform()
element = driver.find_element_by_id("s_btn_wr")
target = driver.find_element_by_class_name("btn")
ActionChains(driver).drag_and_drop(element, target).perform()