`java -jar ../target/vtl-cli-1.0-SNAPSHOT-jar-with-dependencies.jar *.vtl | jq -e '(.results[2].render | fromjson | .result) == 15'`
