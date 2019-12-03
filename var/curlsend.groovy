#!/usr/bin/env groovy
def call(String name = 'human') {
  echo "Hello, ${name}."
  echo "-----------------------------"
  echo "${env.JOB_NAME}"
  echo "-----------------------------"
  sh 'curl -H "Content-Type: application/json" -XPOST "http://10.243.180.253:12003/_doc/tes123" -d "{ \"field\" : \"value\"}"'
  echo "-----------------------------"
}
