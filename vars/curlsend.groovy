#!/usr/bin/env groovy
@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7')

import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.Method.POST
import groovyx.net.http.HTTPBuilder
import groovy.json.JsonSlurper

import com.elektrobit.JenkinsHttpClient

def call(String name = 'klaus') {
  
def jsonSlurper = new JsonSlurper()
def object = jsonSlurper.parseText('{ "name": "John Doe" }')
                                   

JenkinsHttpClient client = new JenkinsHttpClient()
client.postJson("http://10.243.180.253:12003/elapstimemeter_master/_doc/gitcommit_sha", object.toJson()) 
  
}
