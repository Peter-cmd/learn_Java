#coding=utf-8
from selenium import webdriver
from time import sleep
import os
#启动火狐浏览器
driver = webdriver.Firefox()
#获取本地文件地址
file_path = 'file:///' + os.path.abspath('0622/alert.html')
#访问本地文件
driver.get(file_path)
#通过 id 定位链接并点击
driver.find_element_by_id('tooltip').click()
#等待3秒
sleep(3)
#定位并接收弹框
driver.switch_to.alert.accept()
#等待2秒
sleep(2)
#关闭浏览器,释放session
driver.quit()

