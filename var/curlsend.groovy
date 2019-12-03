#!/usr/bin/env groovy
def call(String name = 'human') {
  echo "Hello, ${name}."
  echo "-----------------------------"
  echo "${env.JOB_NAME}"
  echo "-----------------------------"
  sh 'curl -H "Content-Type: application/json" -XPOST "http://10.243.180.253:12003/tes123/doc" -d "{ \"field\" : \"value\"}"'
  echo "-----------------------------"

  
  def url = new URL('http://google.de')
  def connection = url.openConnection()
  connection.requestMethod = 'GET'
  if (connection.responseCode == 200) {
    println connection.content.text
    println connection.contentType
    println connection.lastModified
    connection.headerFields.each { println "> ${it}"}
  }
}
