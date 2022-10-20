if [ $1 == "prod" ]
then
    echo "prod environment selected"
    docker run -d -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=prod" --name cvbuilder  cvbuilder:0.0.1
elif [ $1 == "dev" ]
then
    echo "dev environment selected"
    docker run -d -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=dev" --name cvbuilder  cvbuilder:0.0.1
elif [ $1 == "test" ]
then
    echo "test environment selected"
    docker run -d -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=test" --name cvbuilder  cvbuilder:0.0.1
else
    echo "h2-default environment selected"
    docker run -d -p 8080:8080 --name cvbuilder  cvbuilder:0.0.1
fi
