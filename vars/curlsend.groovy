#!/usr/bin/env groovy
@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7')

import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.Method.POST
import groovyx.net.http.HTTPBuilder


def call(String name = 'klaus') {
  JenkinsHttpClient httpxxx;
  echo "Hello, ${name}."
  echo "-----------------------------"
  echo "${env.JOB_NAME}"
  echo "-----------------------------"
  
  String targetUrl = 'http://10.243.180.253'
  def http = new HTTPBuilder(targetUrl)
  http.request(POST) {
  	uri.path = "/elapstimemeter_master/_doc/gitcommit_sha"
  	requestContentType = JSON
  	body = [  
        	"Buildstatus": "success",
        	"BuildDuration": 12345,
        	"artifact_size": 90000,
  	]
  	//headers.'Authorization' = ""
  	headers.'User-Agent' = 'Logstash'
  	headers.Accept = 'application/json'
/*
  	response.success = { resp, json ->
    		println "GitHub updated successfully! ${resp.status}"
  	}

  	response.failure = { resp, json ->
    		println "GitHub update Failure! ${resp.status} " + json.message
  	}
*/
  }
	
}
