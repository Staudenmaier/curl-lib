import groovy.json.JsonOutput
 
class JsonHelper {
  private String path = ''

  JsonHelper(String p) {
  path = p

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
    File file = new File(p+"/"+filename)
    file.write(json_beauty)
  }
}
