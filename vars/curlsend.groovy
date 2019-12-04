#!/usr/bin/env groovy
def call(String name = 'klaus') {
  echo "Hello, ${name}."
  echo "-----------------------------"
  echo "${env.JOB_NAME}"
  echo "-----------------------------"
  sh 'curl -XPUT "http://localhost:9200/elapstimemeter_master/_doc/gitcommit_sha" -H "Content-Type: application/json" -d"
	{
	\"Buildstatus\"  : \"success\",
	\"BuildDuration\": 12345,
	\"artifact_size\": 90000,
	\"SpawnDocker\": [{
			\"Containtername\": \"Container A\",
			\"spawntime\": 60
		},
		{
			\"Containtername\": \"Container B\",
			\"spawntime\": 6
		}
		]
	}"'
}
