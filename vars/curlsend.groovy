#!/usr/bin/env groovy
@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7')

import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.Method.POST
import groovyx.net.http.HTTPBuilder

import com.elektrobit.JenkinsHttpClient

def call(String name = 'klaus') {
  
  def json = [
    "Buildstatus": "success",
    "BuildDuration": 12345,
    "artifact_size": 90000
  ]

  JenkinsHttpClient client
  client.postJson("http://10.243.180.253:12003/elapstimemeter_master/_doc/gitcommit_sha", json) {
}
