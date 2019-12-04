#!/usr/bin/env groovy
@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7')

import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.Method.POST
import groovyx.net.http.HTTPBuilder
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

import com.elektrobit.JenkinsHttpClient

def call(String name = 'klaus') {
  echo "http://10.243.180.253:12003/${env.JOB_NAME}/_doc/${env.GIT_COMMIT}"
  echo "-----------------------------"
  echo "${env.JOB_NAME}"
  echo "${env.GIT_COMMIT}"
  echo "${env.$BUILD_STATUS}"
  echo "----------------------------- "
  
  def jsonSlurper = new JsonSlurper()
  def object = jsonSlurper.parseText('{ \
                                        "BUILD_NUMBER": env.BUILD_NUMBER \
                                        "Buildstatus": "success", \
                                        "BuildDuration": 12345, \
                                        "artifact_size": 90000, \
                                      } \
                                     ')
                                   

  JenkinsHttpClient client = new JenkinsHttpClient()
  client.postJson("http://10.243.180.253:12003/${env.JOB_NAME}/_doc/${env.GIT_COMMIT}", JsonOutput.toJson(object)) 
  
}
