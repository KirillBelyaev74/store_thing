docker compose up

docker build -t kirbel74/thing:latest .

docker push kirbel74/thing:latest

docker rm $(docker ps -a -q -f status=exited)

https://habr.com/ru/companies/flant/articles/336654/

https://habr.com/ru/companies/timeweb/articles/595687/