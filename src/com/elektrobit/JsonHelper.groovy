package com.elektrobit
import groovy.json.JsonOutput
 

class JsonHelper {
  private String path = ''

  JsonHelper(String x) {
    path = x
  }

  def createJSON(String filename) {
    def data = [
        "Bugs": 199,
        "Failed Tests": 99,
        "succsec": 90000
    ]
 
    def json_str = JsonOutput.toJson(data)
    def json_beauty = JsonOutput.prettyPrint(json_str)
    File file = new File(path+"/"+filename)
    file.write(json_beauty)
  }
}
