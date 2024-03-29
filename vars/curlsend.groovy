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
  echo "-----------------------------"
  def index = env.JOB_NAME.replace("/","-").toLowerCase()
  def timestamp = new Date().format("YYYY-MM-dd'T'hh:mm:ss.SSS'Z'")
  
  echo "Elastic url:          ${env.ELASTIC_URL}"
  echo "Elastic port:         ${env.ELASTIC_PORT}"
  echo "Elastic index:        ${index}"
  echo "Logstash ID:          ${env.GIT_COMMIT}"
  echo "Jenkins build status: ${env.BUILD_STATUS}"
  echo "Jenkins buildTime:    "+timestamp
  echo "Jenkins build number: ${env.BUILD_NUMBER}"
  echo "Filepath:             ${env.WORKSPACE}/${name}"
  echo "${env.ELASTIC_URL}:${env.ELASTIC_PORT}/${index}/_doc/${env.BUILD_NUMBER}"
  echo "----------------------------- "
  
  JsonHelper helper = new JsonHelper(env.WORKSPACE)
  helper.createJSON(name)
  
  def listmap = [
    ["Containtername": "Container A", "spawntime": 60],
    ["Containtername": "Container b", "spawntime": 99]
  ]
 
 Random rand = new Random()

  def data = [
    "@timestamp" :  "${timestamp}",
    "Buildstatus":  "success",
    "GitCommit SHA": "${env.GIT_COMMIT}",
    "BuildDuration": rand.nextInt(1000),
    "ARTIFACT_SIZE": rand.nextInt(10000),
    "SPAWN_DOCKER": listmap
  ]
  
  def jsonSlurper = new JsonSlurper()
  
  data << jsonSlurper.parse(new File("${env.WORKSPACE}/${name}"))

  JenkinsHttpClient client = new JenkinsHttpClient()
  echo "${env.ELASTIC_URL}:${env.ELASTIC_PORT}/${index}/_doc/${env.BUILD_NUMBER}", JsonOutput.toJson(data)
  echo client.postJson("${env.ELASTIC_URL}:${env.ELASTIC_PORT}/${index}/_doc/${env.BUILD_NUMBER}", JsonOutput.toJson(data)) 
}
