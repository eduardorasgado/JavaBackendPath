(mvn clean test &&
mvn site -DgenerateReports=false) &&
echo "> Report with css and images were successfully CREATED" ||
echo "> Report creation FAILED"

