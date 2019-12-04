package com.elektrobit
import groovy.json.JsonOutput
 
class JsonHelper {
  private String path = ''

  JsonHelper(String x) {
    path = x
  }

  def createJSON(String filename) {

    def data = [
      name: "Foo Bar",
      year: "2018",
      timestamp: "2018-03-08T00:00:00",
      tags: [ "person", "employee"],
      grade: 3.14
    ]
 
    def json_str = JsonOutput.toJson(data)
    def json_beauty = JsonOutput.prettyPrint(json_str)
    File file = new File(path+"/"+filename)
    file.write(json_beauty)
  }
}
