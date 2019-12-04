#!/usr/bin/env groovy
@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7')

import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.Method.POST
import groovyx.net.http.HTTPBuilder
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

import com.elektrobit.JenkinsHttpClient
import com.elektrobit.JsonHelper

def call(String name = '/generatedFile.txt') {
  echo "http://10.243.180.253:12003/${env.JOB_NAME}/_doc/${env.GIT_COMMIT}"
  echo "-----------------------------"
  echo "${env.JOB_NAME}"
  echo "${env.GIT_COMMIT}"
  echo "${env.$BUILD_STATUS}"
  echo "${env.WORKSPACE}/name"
  echo "----------------------------- "
  
  JsonHelper helper = new JsonHelper(env.WORKSPACE)
  helper.createJSON(name)
    
  echo "----------------25------------- "
  def jsonSlurper = new JsonSlurper()
  json = jsonSlurper.parse(new File("${env.WORKSPACE}/${name}"))
                          
  echo "-----------------26------------ "
  JenkinsHttpClient client = new JenkinsHttpClient()
  //client.postJson("http://10.243.180.253:12003/${env.JOB_NAME}/_doc/${env.GIT_COMMIT}", JsonOutput.toJson(json)) 
  
}
