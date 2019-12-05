package com.elektrobit
import groovy.json.JsonOutput
 

class JsonHelper {
  private String path = ''

  JsonHelper(String x) {
    path = x
  }

  def createJSON(String filename) {
    def listmap = [
     ["Containtername": "Container A", "spawntime": 60],
     ["Containtername": "Container b", "spawntime": 99]
    ]

    def data = [
        "Buildstatus": "success",
        "BuildDuration": 12345,
        "artifact_size": 90000,
        "SpawnDocker": listmap
    ]
 
    def json_str = JsonOutput.toJson(data)
    def json_beauty = JsonOutput.prettyPrint(json_str)
    File file = new File(path+"/"+filename)
    file.write(json_beauty)
    println "****"
    println json_beauty
    println "****"
    println json_str
   
   
   
  }
}
