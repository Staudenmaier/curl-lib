#!/usr/bin/env groovy
import groovyx.net.http.ContentType

def call(String name = 'klaus') {
  echo "Hello, ${name}."
  echo "-----------------------------"
  echo "${env.JOB_NAME}"
  echo "-----------------------------"
  uri.path = 'http://example.com/handler.php'
    body = [name: 'bob', title: 'construction worker']
    requestContentType = ContentType.JSON

    response.success = { resp ->
        println "Success! ${resp.status}"
    }

    response.failure = { resp ->
        println "Request failed with status ${resp.status}"
    }
	
}
