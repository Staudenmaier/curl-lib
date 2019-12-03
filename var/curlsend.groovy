#!/usr/bin/env groovy
def call(String name = 'human') {
  echo "Hello, ${name}."
  echo "-----------------------------"
  echo "${env.JOB_NAME}"
  echo "-----------------------------"
  sh '{"_index":"test123","_type":"_doc","_id":"1234r45_83756","_version":3,"result":"updated","_shards":{"total":2,"successful":1,"failed":0},"_seq_no":3,"_primary_term":4}'
  echo "-----------------------------"
}
